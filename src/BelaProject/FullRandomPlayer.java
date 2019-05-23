package BelaProject;

import java.util.Random;

public class FullRandomPlayer extends Player {

    public FullRandomPlayer(int startBudget) {
        super(startBudget, PlayerID.FULLRANDOM);
    }

    @Override
    public void myBet() {
        setBet(new Random().nextInt(Casino.MaxBet-Casino.MinBet)+Casino.MinBet);
        setMyBet(Math.random() >= 0.5 ? ProcessorBetOption.getRandom_ColorAs_BetOption() : ProcessorBetOption.getRandom_NumberAs_BetOption());
    }

}
