
/** required package class namespace */
package year2019.cs40s.namepicker;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;



/**
 * MainView.java - 
 *
 * @author Mr. Wachs 
 * @since 12-Apr-2019 
 */
public class MainView 
{

    public static final String INSTRUCTIONS = "<html><head></head><body>" +
            "The unchosen list of names on "
            + "the left is all names not yet chosen. You can add and remove "
            + "names from this list. As well, you can save this list to a "
            + "file, or open a previously saved list from a file. The list "
            + "of names on the right are the names that have been randomly "
            + "drawn from the list on the left. Once a name is in the "
            + "chosen list, it cannot be drawn again (even if it appears "
            + "multiple times in the unchosen list). This list can also be "
            + "altered, saved or opened. Click the draw name button to "
            + "draw a name each time." +
            "</body></html>";
    
    public static final int  MAIN_UI_WIDTH  = 810;
    public static final int  MAIN_UI_HEIGHT = 850;
    
    
    public static Font[] allFonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts();
    
    private static final String DEFAULT_BODY_FONT_NAME       = "Arial";
    private static final int    DEFAULT_BODY_FONT_SIZE       = 14;
    private static final int    DEFAULT_BODY_FONT_STYLE      = Font.PLAIN;
    
    private static final int    DEFAULT_TITLE_FONT_INCREASE  = 14;
    
    private static final String DEFAULT_TITLE_FONT_NAME      = DEFAULT_BODY_FONT_NAME;
    private static final int    DEFAULT_TITLE_BODY_FONT_SIZE = DEFAULT_BODY_FONT_SIZE + DEFAULT_TITLE_FONT_INCREASE;
    private static final int    DEFAULT_TITLE_FONT_STYLE     = Font.BOLD;
    
    
    public static final Font DEFAULT_BODY_FONT  = new Font(DEFAULT_BODY_FONT_NAME, DEFAULT_BODY_FONT_STYLE, DEFAULT_BODY_FONT_SIZE);
    public static final Font DEFAULT_TITLE_FONT = new Font(DEFAULT_TITLE_FONT_NAME, DEFAULT_TITLE_FONT_STYLE, DEFAULT_TITLE_BODY_FONT_SIZE);
    
    public static final int DEFAULT_BACKGROUND_RED   = 255;
    public static final int DEFAULT_BACKGROUND_GREEN = 255;
    public static final int DEFAULT_BACKGROUND_BLUE  = 255;
    
    public static final int DEFAULT_FOREGROUND_RED   = 0;
    public static final int DEFAULT_FOREGROUND_GREEN = 0;
    public static final int DEFAULT_FOREGROUND_BLUE  = 0;
    
    public static final Color DEFAULT_BACKGROUND_COLOR = new Color(DEFAULT_BACKGROUND_RED,DEFAULT_BACKGROUND_GREEN,DEFAULT_BACKGROUND_BLUE);
    public static final Color DEFAULT_FOREGROUND_COLOR = new Color(DEFAULT_FOREGROUND_RED,DEFAULT_FOREGROUND_GREEN,DEFAULT_FOREGROUND_BLUE);
    

}
