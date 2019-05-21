package BelaProject;

import java.util.Random;

public class FullRandomPlayer extends Player{

    public FullRandomPlayer(int startBudget) {
        super(startBudget);
    }

    @Override
    public BetOption myBet() {
        return BetOption.values()[new Random().nextInt(BetOption.values().length)];
    }

}
