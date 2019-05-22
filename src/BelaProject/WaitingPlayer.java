package BelaProject;

import java.util.Random;

public class WaitingPlayer extends Player {

    private final int waitingNumber;
    private int expectSuccess;
    private BetOption expects;

    public WaitingPlayer(int startBudget) {
        super(startBudget, PlayerID.WAITING);
        waitingNumber = new Random().nextInt(7) + 4;
        expects = ProcessorBetOption.getRandom_ColorAs_BetOption();
        setBet(new Random().nextInt(Integer.MAX_VALUE));
    }

    public void whatGotRolled(BetOption color) throws Exception {
        if (color != BetOption._BLACK || color != BetOption._RED) {
            throw new Exception("Wrong enum");
        }
        if (color == expects) {
            expectSuccess++;
        } else {
            expectSuccess = 0;
        }

    }

    @Override
    public BetOption myBet() {
        if (expectSuccess == waitingNumber) {
            expectSuccess = 0;
            if (expects == BetOption._BLACK) {
                expects = BetOption._RED;
                return expects;
            } else {
                expects = BetOption._BLACK;
                return expects;
            }
        }
        return BetOption.NONE;
    }

}
