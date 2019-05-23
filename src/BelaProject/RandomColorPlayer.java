package BelaProject;

public class RandomColorPlayer extends Player {

    public RandomColorPlayer(int startBudget) {
        super(startBudget, PlayerID.RANDOMCOLOR);
    }

    @Override
    public void myBet() {
        setBet(100);
        setMyBet(Math.random() > 0.5 ? BetOption._BLACK : BetOption._RED);
    }

}
