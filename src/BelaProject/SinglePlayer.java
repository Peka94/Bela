package BelaProject;

public class SinglePlayer extends Player{

    public SinglePlayer(int startBudget, PlayerID id) {
        super(startBudget, id);
    }

    @Override
    public BetOption myBet() {
        return Croupier.humanBet;
    }

}
