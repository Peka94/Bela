package BelaProject;

public abstract class Player {

    private final int startBudget;
    private int currentBudget;
    private boolean isPlay;
    private int currentBet;
    private final PlayerID id;

    public Player(int startBudget, PlayerID id) {
        this.startBudget = startBudget;
        currentBudget = startBudget;
        isPlay = true;
        this.id = id;
    }

    public int getStartBudget() {
        return startBudget;
    }

    public int getCurrentBudget() {
        return currentBudget;
    }

    public boolean isIsPlay() {
        return isPlay;
    }

    public int getCurrentBet() {
        return currentBet;
    }

    public final void setCurrentBudget(int currentBudget) {
        this.currentBudget = currentBudget;
    }

    public final void setIsPlay(boolean isPlay) {
        this.isPlay = isPlay;
    }

    public final void setBet(int bet) {
        this.currentBet = bet;
    }

    public PlayerID getId() {
        return id;
    }

    /**
     * *
     * Strategy az UML-ben
     *
     * @return
     */
    public abstract BetOption myBet();
}
