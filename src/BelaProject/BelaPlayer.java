package BelaProject;

public class BelaPlayer extends Player {

    private boolean prevRoundLoser;
    private final int originalBet;

    public BelaPlayer(int startBudget) {
        super(startBudget, PlayerID.BELA);
        prevRoundLoser = false;
        originalBet = Casino.MinBet;
    }

    public void doubleBet() {
        if (prevRoundLoser) {
            this.setBet(this.getCurrentBet() * 2);
        } else {
            this.setBet(originalBet);
        }
    }

    @Override
    public BetOption myBet() {
        return BetOption._RED;
    }

    public void setPrevRoundLoser(boolean prevRoundLoser) {
        this.prevRoundLoser = prevRoundLoser;
    }

}
