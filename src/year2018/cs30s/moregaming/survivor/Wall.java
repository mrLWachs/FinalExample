
/** required package class namespace */
package year2018.cs30s.moregaming.survivor;

/** required imports */
import year2018.cs30s.gametools.GameObject;
import year2018.cs30s.gametools.Image;

/**
 * Wall.java - represents a wall in the survivor game
 *
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public class Wall extends GameObject
{

    /**
     * Constructor for the class sets class data
     * 
     * @param image the image associated with the game character
     */
    public Wall(Image image) {
        super(image);        
        setDebug(Constants.WALL_TEXT, Constants.WALL_COLOR);
        setBorder(false);
    }

}
