
/** required package class namespace */
package year2020.cs40s.gridgameadvanced;

/** requires imports */
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import year2020.cs40s.gridgameadvanced.tools.Directions;

 
/**
 * Constants.java - the various game constants
 *
 * @author Mr. Wachs
 * @since Dec. 4, 2019, 7:49:32 a.m.
 */
public class Constants 
{

    public static final int    HERO_AMOUNT          = 4;
    public static final int    HERO_DIRECTION       = Directions.STOP;
    public static final int    HERO_DELAY           = 50;
    public static final int    NUMBER_OF_DIRECTIONS = Directions.FOUR_DIRECTIONS;
    public static final int    UI_WIDTH             = 1066;
    public static final int    UI_HEIGHT            = 780;
    public static final String TITLE                = "Map Game Simulator";
    public static final int    TOTAL_COMPONENTS     = 7;
    public static final String FONT_TYPE            = "Arial";
    public static final int    FONT_SIZE            = 12;
    public static final int    BORDER_SIZE          = 1;
    public static final Color  BORDER_COLOR         = Color.BLACK;
    public static final Color  COMPONENT_BACKGROUND = Color.WHITE;
    public static final Color  COMPONENT_FOREGROUND = Color.BLACK;    
    public static final Font   COMPONENT_FONT       = new Font(FONT_TYPE, Font.PLAIN, FONT_SIZE);
    public static final Border COMPONENT_BORDER     = BorderFactory.createLineBorder(BORDER_COLOR, BORDER_SIZE);
        
}
