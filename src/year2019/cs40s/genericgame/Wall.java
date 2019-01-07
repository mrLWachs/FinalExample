
/** required package class namespace */
package year2019.cs40s.genericgame;

/** required imports */
import year2019.cs40s.genericgame.gametools.Directions;
import year2019.cs40s.genericgame.gametools.GameObject;
import java.awt.Color;
import javax.swing.JLabel;


/**
 * Wall.java - representation of a Wall in a game 
 *
 * @author Mr. Wachs 
 * @since 19-Dec-2018 
 */
public class Wall extends GameObject
{

    /**
     * Constructor for the class, sets class property data
     * 
     * @param image the label associated with the image for the game character 
     */
    public Wall(JLabel image) {
        super(image,0,Directions.STOP,Directions.FOUR_DIRECTIONS);
        gameImage.debug("WALL", Color.blue);
    }
    
}
