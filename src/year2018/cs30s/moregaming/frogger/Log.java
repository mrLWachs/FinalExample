
/** required package */
package year2018.cs30s.moregaming.frogger;

/** required imports */
import year2018.cs30s.gametools.GameCharacter;
import java.awt.Color;
import year2018.cs30s.gametools.Directions;
import year2018.cs30s.gametools.Image;

/**
 * Log.java - represents a log in the frogger game
 * @author Mr. Wachs' Computer Science Student 
 * @since 18-Jan-2016
 * @version 1.0
 * @instructor Mr. Wachs
 */
public class Log extends GameCharacter
{

    private Wall[] walls;
    
    /**
     * constructor for the class sets class data
     * @param image the label associated with the image
     * @param walls the wall objects associated with this object
     */
    public Log(Image image, Wall[] walls) {
        super(image, 
              Directions.STOP,
              Constants.LOG_MOVE_AMOUNT,
              Constants.LOG_TIMER_DELAY,
              Constants.LOG_MOVE_DIRECTIONS);
        this.walls = walls;
        randomDirection();
        setDebug(Constants.LOG_TEXT, Constants.LOG_COLOR);
    }

    /** the movement actions that this log performs */
    @Override
    public void action() {
        move();
        checkWalls();
        redraw();
    }
    

    /** checks for collisions with walls and reacts */
    private void checkWalls() {
        for (int i = 0; i < walls.length; i++) {
            if (isColliding(walls[i])) {
                bounceOff(walls[i]);
            }
        }
    }
        
}
