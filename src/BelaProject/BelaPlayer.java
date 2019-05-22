package BelaProject;

public class BelaPlayer extends Player {

    private static boolean prevRoundLoser;
    private final int originalBet;

    public BelaPlayer(int startBudget) {
        super(startBudget, PlayerID.BELA);
        originalBet = Casino.MinBet;
        
    }

    private void doubleBet() {
        if (!this.isIsWinner()) {
            this.setBet(this.getCurrentBet() * 2);
        } else {
            this.setBet(originalBet);
        }
    }

    @Override
    public BetOption myBet() {
        return BetOption._RED;
    }

    public static boolean isPrevRoundLoser() {
        return prevRoundLoser;
    }

    public void setPrevRoundLoser() {
        this.prevRoundLoser = prevRoundLoser;
        doubleBet();
    }

}
