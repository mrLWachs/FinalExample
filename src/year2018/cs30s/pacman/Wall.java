
/** required package class namespace */
package year2018.cs30s.pacman;

/** required imports */
import year2018.cs30s.gametools.GameObject;
import year2018.cs30s.gametools.Image;

/**
 * Wall.java - represents a Wall object in the game Pacman
 *
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public class Wall extends GameObject
{

    /**
     * Constructor sets class properties
     * 
     * @param image the image to use for this game object
     */
    public Wall(Image image) {
        super(image);
        setDebug(Constants.WALL_TEXT, Constants.WALL_COLOR);
    }
    
}
