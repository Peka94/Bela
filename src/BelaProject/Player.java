package BelaProject;

public abstract class Player {

    private final int startBudget;
    private int currentBudget;
    private boolean isPlay;
    private int currentBet;

    public Player(int startBudget) {
        this.startBudget = startBudget;
        currentBudget = startBudget;
        isPlay = true;
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
        this.currentBet=bet;
    }

    /***
     * Strategy az UML-ben
     * @return 
     */
    public abstract BetOption myBet();  
}
