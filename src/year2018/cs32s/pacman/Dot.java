
/** required package class namespace */
package year2018.cs32s.pacman;

/** required imports */
import year2018.cs32s.gametools.GameObject;
import year2018.cs32s.gametools.Image;

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
    }

    /**
     * When a dot gets eaten by Pacman
     */
    public void getEaten() {
        hide();
    }
    
}
