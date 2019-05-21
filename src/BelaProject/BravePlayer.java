package BelaProject;

public class BravePlayer extends Player{

    public BravePlayer(int startBudget) {
        super(startBudget);
        setBet(Casino.MaxBet);
    }

    @Override
    public BetOption myBet() {
        return BetOption._RED;
    }

}
