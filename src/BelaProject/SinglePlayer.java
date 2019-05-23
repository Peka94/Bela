package BelaProject;

public class SinglePlayer extends Player{

    public SinglePlayer(int startBudget, PlayerID id) {
        super(startBudget, id);
    }

    public void setHumanBet(BetOption value){
        this.setMyBet(value);
    }
    @Override
    public void myBet() {
        
    }

}
