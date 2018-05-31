
/** required package */
package year2018.cs30s.moregaming.frogger;

/** required imports */
import year2018.cs30s.gametools.GameObject;
import java.awt.Color;
import year2018.cs30s.gametools.Image;

/**
 * Water.java - represents the water of the frogger game
 * @author Mr. Wachs' Computer Science Student 
 * @since 18-Jan-2016
 * @version 1.0
 * @instructor Mr. Wachs
 */
public class Water extends GameObject
{

    /**
     * constructor for the class sets class data
     * @param image the label associated with the image
     * @param color the background color associated with the image
     */
    public Water(Image image) {
        super(image);
        setDebug(Constants.WATER_TEXT, Constants.WATER_COLOR);
    }

}
