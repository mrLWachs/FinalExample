
/** required package class namespace */
package year2018.cs30s.moregaming.spaceinvaders;

/** required imports */
import year2018.cs30s.gametools.GameObject;
import year2018.cs30s.gametools.Image;

/**
 * Background.java - represents the background of the space invaders game
 *
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public class Background extends GameObject
{

    /**
     * Constructor for the class sets class data
     * 
     * @param image the image associated with the game object
     */
    public Background(Image image) {
        super(image);
        setDebug(Constants.BACKGROUND_TEXT, Constants.BACKGROUND_COLOR);
    }

}
