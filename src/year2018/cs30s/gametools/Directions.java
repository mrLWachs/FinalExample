

package year2018.cs30s.gametools;



public class Directions 
{
    
    // 8 direction games (with diagonals):
    public static int NORTH      = 1;
    public static int NORTH_EAST = 2;
    public static int EAST       = 3;
    public static int SOUTH_EAST = 4;
    public static int SOUTH      = 5;
    public static int SOUTH_WEST = 6;
    public static int WEST       = 7;
    public static int NORTH_WEST = 8;
    
    // 4 directions games (no diagonal):
    public static int STOP  = 0;    
    public static int UP    = NORTH;
    public static int DOWN  = SOUTH;
    public static int LEFT  = WEST;
    public static int RIGHT = EAST;
    
}
