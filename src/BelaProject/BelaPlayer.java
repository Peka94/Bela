package BelaProject;

public class BelaPlayer extends Player {

    private static boolean prevRoundLoser;
    private final int originalBet;

    public BelaPlayer(int startBudget) {
        super(startBudget, PlayerID.BELA);
        originalBet = Casino.MinBet;
        setBet(originalBet);
        
    }

    private void doubleBet() {
        if (!this.isIsWinner()) {
            this.setBet(this.getCurrentBet() * 2);
        } else {
            this.setBet(originalBet);
        }
    }

    @Override
    public void myBet() {
        setMyBet(BetOption._RED);
    }

    public static boolean isPrevRoundLoser() {
        return prevRoundLoser;
    }

    public void setPrevRoundLoser() {
        this.prevRoundLoser = prevRoundLoser;
        doubleBet();
    }

}
