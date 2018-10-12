
/** required package class namespace */
package year2019.cs40s.bufferedimages;

/** required imports */
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import year2018.cs30s.tools.FrameTools;


/**
 * UIManager.java - the user interface controller for the application
 *
 * @author Mr. Wachs 
 * @since 12-Oct-2018 
 */
public class UIManager 
{
    
    private JLabel      heroLabel;
    private JLabel[]    wallLabels;
    private UI          userInterface;
    private GameManager gameManager;

    /**
     * Constructor for the class sets class properties
     * 
     * @param heroLabel
     * @param wallLabels
     * @param userInterface 
     */
    public UIManager(JLabel heroLabel, JLabel[] wallLabels, UI userInterface) {
        this.heroLabel     = heroLabel;
        this.wallLabels    = wallLabels;
        this.userInterface = userInterface;  
        gameManager        = new GameManager(heroLabel,wallLabels);
        new FrameTools().startup(
                userInterface, 
                Enviromentals.APP_TITLE, 
                Enviromentals.UI_WIDTH, 
                Enviromentals.UI_HEIGHT, 
                false, true, false, false, 
                Enviromentals.UI_BACKGROUND_COLOR, 
                Enviromentals.UI_ICON);  
    }

    public void keyPress(KeyEvent evt) {
        gameManager.keyPress(evt);
    }

}
