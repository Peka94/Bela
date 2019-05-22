package BelaProject;

public class RoundHistory {

    private final Enum playerId;
    private final int bet;
    private final BetOption giveYourNumber;
    private final RouletteNumber result;
    private final boolean winner;
    private final int currentBudget;

    public RoundHistory(Enum playerId, int bet, BetOption giveYourNumber, RouletteNumber result, boolean winner, int currentBudget) {
        this.playerId = playerId;
        this.bet = bet;
        this.giveYourNumber = giveYourNumber;
        this.result = result;
        this.winner = winner;
        this.currentBudget = currentBudget;
    }

    public Enum getPlayerId() {
        return playerId;
    }

    public int getBet() {
        return bet;
    }

    public BetOption getGiveYourNumber() {
        return giveYourNumber;
    }

    public RouletteNumber getResult() {
        return result;
    }

    public boolean isWinner() {
        return winner;
    }

    public int getCurrentBudget() {
        return currentBudget;
    }
    
    
    
}
