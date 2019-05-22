/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BelaProject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author Pepe
 */
public class Game implements Casino  {

    List<Player> winners = new ArrayList<>();
    List<Player> losers = new ArrayList<>();
    Set<Player> players = new HashSet<>();
    Map<Player, BetOption> currentRound = new HashMap<>();
    RouletteWheel rw = new RouletteWheel();
    Random rand = new Random();
    
    int currentSolution;
//    public int MinBet = (int)(Math.random()*10+1);
//    public int MaxBet = (int) (Math.random()*1000+1);
         
    // egy adott kör végigvitele
    public void getRound() {
        for (Player player : players) {
            if (player.getCurrentBet() > Casino.MinBet && player.getCurrentBet() < Casino.MaxBet) {
                giveYourNumber();
            }
        }
        spin();
        checkWinners();
        changePlayersBudget();
    }
    
    // Az adott körben adjuk be azt a számot, amit szeretnénk megtenni
    private void giveYourNumber() {
        for (Player player : players) {
            if (player.isIsPlay()) {
                currentRound.put(player, player.myBet());
            }
        }
    }
    
    // Az adott körben a pörgetés        
    public void spin() {
        for (Player player : players) {
           
        }
        currentSolution = rand.nextInt(RouletteWheel.numbers.size());
    }
    
    // Ellenőrzi kik(ha esetleg többen lennének) nyertek az adott pörgetés(spin) után
    public void checkWinners() {
        winners.clear();
        losers.clear();
        for (Player player : players) {
           if (player.isIsPlay()) {
                if (player.myBet().equals(RouletteWheel.numbers.get(currentSolution).getColor())) {
                    winners.add(player);
                } else if (ProcessorBetOption.getBetOptionAs_Integer(player.myBet()).equals(RouletteWheel.numbers.get(currentSolution).getNumber())) {
                    winners.add(player);
                } else {
                    losers.add(player);
                }
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
    
}
