/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BelaProject;

/**
 *
 * @author Reich Jenő
 */
public class RouletteNumber {
    private final int number;
    private final BetOption color;

    public RouletteNumber(int number, BetOption color) {
        this.number = number;
        this.color = color;
    }

    /**
     * returns the number of the specific location of the roulette wheel
     * @return 
     */
    public int getNumber() {
        return number;
    }

    
    /**
     * returns the Color of the specific number
     * @return 
     */
    public BetOption getColor() {
        return color;
    }
    
    
    
}
