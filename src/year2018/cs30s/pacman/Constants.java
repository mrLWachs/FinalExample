
/** required package class namespace */
package year2018.cs30s.pacman;

/** required imports */
import java.awt.Color;
import mainpackage.MainClass;
import year2018.cs30s.gametools.Directions;

/**
 * Constants.java - game constant values for the Pacman game
 *
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public class Constants 
{

    public static final int    PACMAN_TIMER_DELAY      = 100;
    public static final int    PACMAN_MOVE_AMOUNT      = 10;
    public static final int    PACMAN_MOVE_DIRECTIONS  = 
                                                    Directions.FOUR_DIRECTIONS;
    public static final String PACMAN_TEXT             = "PACMAN";
    public static final Color  PACMAN_COLOR            = Color.yellow;    
    public static final int    GHOST_TIMER_DELAY       = 100;
    public static final int    GHOST_MOVE_AMOUNT       = 10;
    public static final int    GHOST_MOVE_DIRECTIONS   = 
                                                    Directions.FOUR_DIRECTIONS;
    public static final String GHOST_TEXT              = "GHOST";
    public static final Color  GHOST_COLOR             = Color.pink;    
    public static final String DOT_TEXT                = "";
    public static final Color  DOT_COLOR               = Color.white;    
    public static final String WALL_TEXT               = "";
    public static final Color  WALL_COLOR              = Color.blue;    
    public static final int    PACMAN_UI_WIDTH         = 900;
    public static final int    PACMAN_UI_HEIGHT        = 700;
    public static final Color  PACMAN_UI_BACK_COLOR    = Color.black;
    public static final String PACMAN_UI_TITLE         = "Pacman";
    public static final String PACMAN_UI_ICON          = MainClass.MEDIA_PATH + 
                                                         "Pacman.png";
        
}
