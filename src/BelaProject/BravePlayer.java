package BelaProject;

public class BravePlayer extends Player {

    public BravePlayer(int startBudget) {
        super(startBudget, PlayerID.BRAVE);
        setBet(Casino.MaxBet);
    }

    @Override
    public void myBet() {
        setMyBet(BetOption._RED);
    }

}
