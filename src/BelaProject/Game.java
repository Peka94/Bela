/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BelaProject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author Pepe
 */
public class Game implements Casino {

    List<Player> winners = new ArrayList<>();
    List<Player> losers = new ArrayList<>();
    Set<Player> players = new HashSet<>();
    Map<Player, BetOption> currentRound = new HashMap<>();
    RouletteWheel rw = new RouletteWheel();
    Random rand = new Random();
    ArrayList<RoundHistory> history = new ArrayList<>();
    ArrayList< ArrayList<RoundHistory>> roundHistory = new ArrayList<>();
    int count = 0;

    int currentSolution;
//    public int MinBet = (int)(Math.random()*10+1);
//    public int MaxBet = (int) (Math.random()*1000+1);

    public Game() {
        players.add(new BelaPlayer(10000));
        players.add(new BravePlayer(10000));
        players.add(new ConservativePlayer(10000));
        players.add(new FullRandomPlayer(10000));
        players.add(new RandomColorPlayer(10000));
        players.add(new WaitingPlayer(10000));
    }

    // egy adott kör végigvitele
    public void getRound() {
        for (Player player : players) {
            if (player.getId() == PlayerID.BELA) {
                BelaPlayer bela = (BelaPlayer) (player);
                bela.setPrevRoundLoser();
            }
            if (player.getCurrentBet() >= Casino.MinBet && player.getCurrentBet() <= Casino.MaxBet && player.getCurrentBudget()>= player.getCurrentBet()) {
                giveYourNumber(player);
            }
        }
        spin();
        checkWinners();
        changePlayersBudget();
        fillHistory();
        fillRoundHistory();
    }

    // Az adott körben adjuk be azt a számot, amit szeretnénk megtenni
    private void giveYourNumber(Player player) {
//        for (Player player : players) {
        history.clear();
            if (player.isIsPlay()) {
                player.myBet();
                currentRound.put(player, player.getMyBet());
            }
//        }
    }

    // Az adott körben a pörgetés        
    public void spin() {
        currentSolution = rand.nextInt(RouletteWheel.numbers.size());
    }

    // Ellenőrzi kik(ha esetleg többen lennének) nyertek az adott pörgetés(spin) után
    public void checkWinners() {
        winners.clear();
        losers.clear();
        for (Player player : players) {
            if (player.isIsPlay()) {
                if (player.getMyBet().equals(RouletteWheel.numbers.get(currentSolution).getColor())) {
                    winners.add(player);
                    player.setIsWinner(true);
                } else if (ProcessorBetOption.getBetOptionAs_Integer(player.getMyBet()) != null) {
                    if (ProcessorBetOption.getBetOptionAs_Integer(player.getMyBet()) == (RouletteWheel.numbers.get(currentSolution).getNumber())) {
                        winners.add(player);
                        player.setIsWinner(true);
                    }
                } else {
                    losers.add(player);
                    player.setIsWinner(false);
                }
            }
            if (player.getId() == PlayerID.WAITING) {
                WaitingPlayer wp = (WaitingPlayer) player;
                wp.whatGotRolled(RouletteWheel.numbers.get(currentSolution).getColor());
            }
        }
    }

    // ha a játékos az adott körben játszik, és nyer vagy veszít, úgy változtatjuk az egyenlegét
    public void changePlayersBudget() {
        for (Player winner : winners) {

            winner.setCurrentBudget(winner.getCurrentBudget() + winner.getCurrentBet());
        }
        for (Player loser : losers) {
            loser.setCurrentBudget(loser.getCurrentBudget() - loser.getCurrentBet());
        }
    }

    public void fillHistory() {
        for (Player winner : winners) {
            for (Map.Entry<Player, BetOption> e : currentRound.entrySet()) {
                if (e.getKey().getId() == winner.getId()) {
                    history.add(new RoundHistory(winner.getId(), winner.getCurrentBet(), e.getKey().getMyBet(), RouletteWheel.numbers.get(currentSolution), true, winner.getCurrentBudget()));

                }
            }
        }
        for (Player loser : losers) {
            for (Map.Entry<Player, BetOption> e : currentRound.entrySet()) {
                if (e.getKey().getId() == loser.getId()) {
                    history.add(new RoundHistory(loser.getId(), loser.getCurrentBet(), e.getKey().getMyBet(), RouletteWheel.numbers.get(currentSolution), false, loser.getCurrentBudget()));

                }
            }
        }
    }
    
    public void fillRoundHistory(){
        roundHistory.add(history);
//        for (RoundHistory h : history) {
//            if(count == 0 || count % 6 != 0){
//                roundHistory.put(1, h);
//            }
//            else if(count % 6 == 0){
//                roundHistory.put(roundHistory.size()+1, h);
//            }
//            
//        }
    }
    

}
