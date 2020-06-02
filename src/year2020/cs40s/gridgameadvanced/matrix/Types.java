
/** required package class namespace */
package year2020.cs40s.gridgameadvanced.matrix;

import year2018.cs30s.tools.Numbers;

 
/**
 * Types.java - description
 *
 * @author Mr. Wachs
 * @since Dec. 4, 2019, 3:17:32 p.m.
 */
public class Types 
{
    
    public static final int GRASS = 0;
    public static final int WATER = 1;
    public static final int ROCK  = 2;
    public static final int SAND  = 3;
        
    public static final boolean[] CAN_WALK = {
        true, 
        false, 
        false,
        true
    };
    
    public static int random() {
        if      (Numbers.random(1, 20) == 1) return ROCK;
        else if (Numbers.random(1, 10) == 1) return WATER;
        else if (Numbers.random(1, 5)  == 1) return SAND;
        else                                 return GRASS;        
    }
        
}
