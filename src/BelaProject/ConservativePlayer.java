package BelaProject;

public class ConservativePlayer extends Player {

    public ConservativePlayer(int startBudget) {
        super(startBudget, PlayerID.CONSERVATIVE);
        setBet(Casino.MinBet);
    }

    @Override
    public void myBet() {
        setMyBet(BetOption._RED);
    }

}
