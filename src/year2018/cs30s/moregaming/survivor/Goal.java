
/** required package class namespace */
package year2018.cs30s.moregaming.survivor;

import year2018.cs30s.gametools.GameObject;
import year2018.cs30s.gametools.Image;

/**
 * Goal.java - description here...
 *
 * @author Mr. Wachs (login: lawrence.wachs)
 * @since Jun 7, 2018 
 * @instructor Mr. Wachs
 */
public class Goal extends GameObject
{
    
    public Goal(Image image) {
        super(image);
        
                
        setDebug(Constants.GOAL_TEXT, Constants.GOAL_COLOR);
    }
    

}
