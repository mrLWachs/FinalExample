
/** required package class namespace */
package year2018.cs30s.pacman;

/** required imports */
import mainpackage.Example;
import year2018.cs30s.gametools.GameObject;
import year2018.cs30s.gametools.Image;

/**
 * Dot.java - represents a Dot object in the game Pacman
 *
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public class Dot extends GameObject
{

    /**
     * Constructor sets class properties
     * 
     * @param image the image to use for this game object
     */
    public Dot(Image image) {
        super(image);
        setDebug(Constants.DOT_TEXT, Constants.DOT_COLOR);
    }

    /**
     * When a dot gets eaten by Pacman
     */
    public void getEaten() {
        Example.totalPoints++;
        hide();
    }
    
}
