
/** required package class namespace */
package year2018.cs30s.moregaming.frogger;

/** required imports */
import java.awt.Color;
import year2018.cs30s.gametools.Directions;

/**
 * Constants.java - game constant values for the Frogger game
 *
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public class Constants 
{

    public static final int    FROGGER_TIMER_DELAY     = 300;
    public static final int    FROGGER_MOVE_AMOUNT     = 50;
    public static final int    FROGGER_MOVE_DIRECTIONS = 
                                                    Directions.FOUR_DIRECTIONS;
    public static final String FROGGER_TEXT            = "FROGGER";
    public static final Color  FROGGER_COLOR           = Color.green;    
    
    public static final int    CAR_TIMER_DELAY         = 100;
    public static final int    CAR_MOVE_AMOUNT         = 10;
    public static final int    CAR_MOVE_DIRECTIONS     = 
                                                    Directions.TWO_DIRECTIONS;
    public static final String CAR_TEXT                = "CAR";
    public static final Color  CAR_COLOR               = Color.red;        
    public static final int    LOG_TIMER_DELAY         = 100;
    public static final int    LOG_MOVE_AMOUNT         = 5;
    public static final int    LOG_MOVE_DIRECTIONS     = 
                                                    Directions.TWO_DIRECTIONS;
    public static final String LOG_TEXT                = "LOG";
    public static final Color  LOG_COLOR               = Color.pink;       
    public static final String BACKGROUND_TEXT         = "";
    public static final Color  BACKGROUND_COLOR        = Color.lightGray;     
    public static final String WATER_TEXT              = "WATER";
    public static final Color  WATER_COLOR             = Color.blue;     
    public static final String WALL_TEXT               = "";
    public static final Color  WALL_COLOR              = Color.gray;     
    public static final String HOME_TEXT               = "HOME";
    public static final Color  HOME_COLOR              = Color.orange;     
    public static final int    FROGGER_UI_WIDTH        = 920;
    public static final int    FROGGER_UI_HEIGHT       = 720;
    public static final Color  FROGGER_UI_BACK_COLOR   = Color.black;
    public static final String FROGGER_UI_TITLE        = "Frogger";
    
}
