
/** required package class namespace */
package year2019.cs30s.animations;

/** required imports */
import javax.swing.JLabel;
import year2019.cs30s.animations.gametools.GameObject;


/**
 * Objective.java - representation of a objective in a game 
 *
 * @author Mr. Wachs 
 * @since 15-May-2019 
 */
public class Objective extends GameObject
{

    /**
     * Constructor for the class, sets class property data
     * 
     * @param label the label associated with the image for the game object
     */
    public Objective(JLabel label) {
        super(label);
        super.gameImage.debug(Globals.OBJECTIVE_TEXT,Globals.OBJECTIVE_COLOR);
    }
    
}
