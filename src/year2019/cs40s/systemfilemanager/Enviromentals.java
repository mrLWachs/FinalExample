
/** required package class namespace */
package year2019.cs40s.systemfilemanager;

/** required imports */
import java.awt.Color;
import java.awt.Font;
import javax.swing.JOptionPane;
import mainpackage.MainConstants;



/**
 * Enviromentals.java - global constant values for  the application
 *
 * @author Mr. Wachs 
 * @since 13-Sep-2018 
 */
public class Enviromentals 
{

    private static final Color  DEFAULT_BACKGROUND_COLOR        
            = new JOptionPane().getBackground();
    private static final Color  DEFAULT_FOREGROUND_COLOR        
            = new JOptionPane().getForeground();   
    public  static       Color  DIALOG_BACKGROUND_COLOR         
            = DEFAULT_BACKGROUND_COLOR;
    public  static       Color  DIALOG_FOREGROUND_COLOR         
            = DEFAULT_FOREGROUND_COLOR;  
    public  static       String APP_TITLE                       
            = "Operating System File Tools";
    public  static       String SELECT_TARGET_DIALOG_TITLE      
            = "Select the Target folder to copy from";
    public  static       String SELECT_DESTINATION_DIALOG_TITLE 
            = "Select the Destination folder to copy to";
    public  static       String DIRECTORY_CHOOSER_TITLE        
            = "Choose directory to use";
    public  static       String TEXT_FILE_CHOOSER_TITLE         
            = "Choose text file to use";
    public  static       String UI_ICON                         
            = MainConstants.MEDIA_PATH + "tools.png";
    public  static       int    UI_WIDTH                        = 1030;
    public  static       int    UI_HEIGHT                       = 660;        
    public  static       int    DIALOG_TYPE                     
            = JOptionPane.PLAIN_MESSAGE;
    public  static       Font   DIALOG_FONT                     
            = new Font("Consolas", Font.PLAIN, 20);    
                
}
