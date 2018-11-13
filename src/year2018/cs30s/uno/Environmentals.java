
/** required package class namespace */
package year2018.cs30s.uno;

/** required imports */
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import mainpackage.MainConstants;

/**
 * Environmentals.java - game constant and variable values for the uno game
 *
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public class Environmentals 
{
    
    public static final int     UNO_UI_WIDTH      = 1040;
    public static final int     UNO_UI_HEIGHT     = 640;
    public static final Color   UNO_UI_BACK_COLOR = Color.white;
    public static final String  UNO_UI_TITLE      = "Uno";
    public static final String  UNO_UI_ICON       = MainConstants.MEDIA_PATH + 
                                                                    "uno.png";
    public static String        CARD_FONT         = "Times New Roman"; 
    public static int           CARD_FONT_SIZE    = 11;
    public static int           CARD_FONT_STYLE   = Font.BOLD;
    public static Border        CARD_BORDER       = 
                                            BorderFactory.createEtchedBorder();
    public static String        IMAGE_PATH        = "/year2018/cs30s/uno/media/";
        
}
