package BelaProject;

import java.util.Random;

public class RandomColorPlayer extends Player {

    public RandomColorPlayer(int startBudget) {
        super(startBudget, PlayerID.RANDOMCOLOR);
        setBet(new Random().nextInt(Casino.MaxBet-Casino.MinBet)+Casino.MinBet);
    }

    @Override
    public void myBet() {

        setMyBet(Math.random() > 0.5 ? BetOption._BLACK : BetOption._RED);
    }

}
