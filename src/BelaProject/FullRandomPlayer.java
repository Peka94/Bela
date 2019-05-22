package BelaProject;

import java.util.Random;

public class FullRandomPlayer extends Player {

    public FullRandomPlayer(int startBudget) {
        super(startBudget, PlayerID.FULLRANDOM);
    }

    @Override
    public BetOption myBet() {
        setBet(new Random().nextInt(Integer.MAX_VALUE));
        return ProcessorBetOption.getRandom_ElementAs_BetOption();
    }

}
