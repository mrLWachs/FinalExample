
/** required package */
package year2018.cs32s.moregaming.spaceinvaders;

/** required imports */
import year2018.cs32s.gametools.GameObject;
import java.awt.Color;
import javax.swing.JLabel;
import year2018.cs32s.gametools.Image;

/**
 * Base.java - represents the base of the space invaders game
 * @author Mr. Wachs' Computer Science Student 
 * @since 18-Jan-2016
 * @version 1.0
 * @instructor Mr. Wachs
 */
public class Base extends GameObject
{

    private int hitCount;
    private Color color;
    
    /**
     * constructor for the class sets class data
     * @param image the label associated with the image
     * @param color the background color associated with the image
     */
    public Base(Image image, Color color) {
        super(image);
        this.color = color;
        hitCount = 0;
    }

    /** represents what occurs when the base is hit with a bullet */
    public void kill() {
        hitCount++;
        if (hitCount == 5) {
            
        }
        else {
            int r = color.getRed();
            int g = color.getGreen();
            int b = color.getBlue();
            b = b - 50;
            color = new Color(r,g,b);
        }
    }
        
}
