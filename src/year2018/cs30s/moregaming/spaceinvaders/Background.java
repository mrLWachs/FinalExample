
/** required package */
package year2018.cs30s.moregaming.spaceinvaders;

/** required imports */
import year2018.cs30s.gametools.GameObject;
import year2018.cs30s.gametools.Image;

/**
 * Background.java - represents the background of the space invaders game
 * @author Mr. Wachs' Computer Science Student 
 * @since 18-Jan-2016
 * @version 1.0
 * @instructor Mr. Wachs
 */
public class Background extends GameObject
{

    /**
     * constructor for the class sets class data
     * @param image the label associated with the image
     * @param color the background color associated with the image
     */
    public Background(Image image) {
        super(image);
        setDebug(Constants.BACKGROUND_TEXT, Constants.BACKGROUND_COLOR);
    }

}
