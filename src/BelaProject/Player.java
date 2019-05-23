package BelaProject;

public abstract class Player {

    private final int startBudget;
    private int currentBudget;
    private boolean isPlay;
    private boolean isWinner;
    private int currentBet= Casino.MinBet;
    private final PlayerID id;
    private BetOption myBet;

    public Player(int startBudget, PlayerID id) {
        this.startBudget = startBudget;
        currentBudget = startBudget;
        isPlay = true;
        isWinner = true;
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

    public boolean isIsWinner() {
        return isWinner;
    }

    public int getCurrentBet() {
        return currentBet;
    }

    public final void setCurrentBudget(int currentBudget) {
        this.currentBudget = currentBudget;
    }

    public void setIsWinner(boolean isWinner) {
        this.isWinner = isWinner;
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
    public abstract void myBet();

    public BetOption getMyBet() {
        return myBet;
    }

    protected final void setMyBet(BetOption myBet) {
        this.myBet = myBet;
    }
    
}
