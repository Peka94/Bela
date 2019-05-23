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
        setBet(new Random().nextInt(Casino.MaxBet));
    }

    public void whatGotRolled(BetOption color){
        if (color == expects) {
            expectSuccess++;
        } else {
            expectSuccess = 0;
        }

    }

    @Override
    public void myBet() {
        if (expectSuccess == waitingNumber) {
            expectSuccess = 0;
            if (expects == BetOption._BLACK) {
                expects = BetOption._RED;
                setMyBet(expects);
            } else {
                expects = BetOption._BLACK;
                setMyBet(expects);
            }
        }
        setMyBet(BetOption.NONE);
    }

}
