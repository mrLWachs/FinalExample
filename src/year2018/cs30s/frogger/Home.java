
/** required package class namespace */
package year2018.cs30s.frogger;

/** required imports */
import year2018.cs30s.gametools.GameObject;
import year2018.cs30s.gametools.Image;

/**
 * Home.java - represents the home of the Frogger game
 *
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public class Home extends GameObject
{

    /**
     * Constructor for the class sets class data
     * 
     * @param image the image associated with the game object
     */
    public Home(Image image) {
        super(image);
        setDebug(Constants.HOME_TEXT, Constants.HOME_COLOR);
    }

}
