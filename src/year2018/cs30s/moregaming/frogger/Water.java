
/** required package class namespace */
package year2018.cs30s.moregaming.frogger;

/** required imports */
import year2018.cs30s.gametools.GameObject;
import year2018.cs30s.gametools.Image;

/**
 * Water.java - represents the water of the Frogger game
 *
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public class Water extends GameObject
{

    /**
     * Constructor for the class sets class data
     * 
     * @param image the label associated with the image
     */
    public Water(Image image) {
        super(image);
        setDebug(Constants.WATER_TEXT, Constants.WATER_COLOR);
    }

    void splash() {
    }

}
