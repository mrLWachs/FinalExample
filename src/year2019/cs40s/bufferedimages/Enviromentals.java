
/** required package class namespace */
package year2019.cs40s.bufferedimages;

/** required imports */
import java.awt.Color;
import javax.swing.JOptionPane;
import mainpackage.MainConstants;


/**
 * Enviromentals.java - global constant values for  the application
 *
 * @author Mr. Wachs 
 * @since 12-Oct-2018 
 */
public class Enviromentals 
{
    
    private static final Color  DEFAULT_BACKGROUND_COLOR        
            = new JOptionPane().getBackground();   
    public  static       Color  UI_BACKGROUND_COLOR         
            = DEFAULT_BACKGROUND_COLOR;
    public  static       String APP_TITLE                       
            = "Buffered Images Example";
    public  static       String UI_ICON                         
            = MainConstants.MEDIA_PATH + "tools.png";
    public  static       int    UI_WIDTH                        = 900;
    public  static       int    UI_HEIGHT                       = 700;    

}
