/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BelaProject;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Reich Jenő
 */
public class RouletteWheel {
    public static final List<RouletteNumber> numbers=new ArrayList<>();
    
    
    /**
     * creates an instance of the class RouletteWheel
     */
    public RouletteWheel() {
        
        String line="0-32-15-19-4-21-2-25-17-34-6-27-13-36-11-30-8-23-10-5-24-16-33-1-20-14-31-9-22-18-29-7-28-12-35-3-26";
        
        String [] parts=line.split("-");
        numbers.add(new RouletteNumber(Integer.parseInt(parts[0]), Color.GREEN));
        
        
        for (int i = 1; i < parts.length; i++) {
            if (i%2==0) {
                numbers.add(new RouletteNumber(Integer.parseInt(parts[i]), Color.BLACK));
            } else{
                numbers.add(new RouletteNumber(Integer.parseInt(parts[i]), Color.RED));
            }
            
        }
        
    }

    public static List<RouletteNumber> getNumbers() {
        return numbers;
    }
    
    
    
}
