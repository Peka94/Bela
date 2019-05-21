package BelaProject;

public class RandomColorPlayer extends Player {

    public RandomColorPlayer(int startBudget) {
        super(startBudget);
    }

    @Override
    public BetOption myBet() {
        return Math.random() > 0.5 ? BetOption._BLACK : BetOption._RED;
    }

}