
/** required package class namespace */
package year2018.cs30s.moregaming.survivor;

/** required imports */
import year2018.cs30s.gametools.GameObject;
import year2018.cs30s.gametools.Image;

/**
 * Goal.java - represents the goal of the survivor game
 *
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public class Goal extends GameObject
{
    
    /**
     * Constructor for the class sets class data
     * 
     * @param image the image associated with the game object
     */
    public Goal(Image image) {
        super(image);
        setDebug(Constants.GOAL_TEXT, Constants.GOAL_COLOR);
    }

}
