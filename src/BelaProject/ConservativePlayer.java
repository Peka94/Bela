package BelaProject;

public class ConservativePlayer extends Player{

    public ConservativePlayer(int startBudget) {
        super(startBudget);
        setBet(Casino.MinBet);
    }

    @Override
    public BetOption myBet() {
        return BetOption._RED;
    }

}
