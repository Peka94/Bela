package BelaProject;

public class RoundHistory {

    private final Enum playerId;
    private final int bet;
    private final RouletteNumber giveYourNumber;
    private final RouletteNumber result;
    private final boolean winner;
    private final int profit;
    private final int currentBudget;

    public RoundHistory(Enum playerId, int bet, RouletteNumber giveYourNumber, RouletteNumber result, boolean winner, int profit, int currentBudget) {
        this.playerId = playerId;
        this.bet = bet;
        this.giveYourNumber = giveYourNumber;
        this.result = result;
        this.winner = winner;
        this.profit = profit;
        this.currentBudget = currentBudget;
    }

    public Enum getPlayerId() {
        return playerId;
    }

    public int getBet() {
        return bet;
    }

    public RouletteNumber getGiveYourNumber() {
        return giveYourNumber;
    }

    public RouletteNumber getResult() {
        return result;
    }

    public boolean isWinner() {
        return winner;
    }

    public int getProfit() {
        return profit;
    }

    public int getCurrentBudget() {
        return currentBudget;
    }
    
    
    
}
