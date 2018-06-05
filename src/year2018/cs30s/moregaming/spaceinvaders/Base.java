
/** required package class namespace */
package year2018.cs30s.moregaming.spaceinvaders;

/** required imports */
import year2018.cs30s.gametools.GameObject;
import java.awt.Color;
import year2018.cs30s.gametools.Image;

/**
 * Base.java - represents the base of the space invaders game
 *
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public class Base extends GameObject
{

    private int hitCount;
    
    /**
     * Constructor for the class sets class data
     * 
     * @param image the image associated with the game object
     */
    public Base(Image image) {
        super(image);
        hitCount = 0;
        setDebug(Constants.BASE_TEXT, Constants.BASE_COLOR);
    }

    /** 
     * Represents what occurs when the base is hit with a bullet 
     */
    public void kill() {
        hitCount++;                             // increment hit count
        if (hitCount == 5) {                    // reached maximum hit count
            hide();                             // hide base
        }
        else {
            Color color = getBackground();      // get color
            int r = color.getRed();             // get color components
            int g = color.getGreen();
            int b = color.getBlue();
            b = b - 50;                         // reduce blue
            setDebug(Constants.BASE_TEXT, new Color(r,g,b));    // re-color
        }
    }
        
}
