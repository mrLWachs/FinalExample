
/** required package class namespace */
package year2018.cs30s.moregaming.frogger;

/** required imports */
import year2018.cs30s.gametools.GameCharacter;
import year2018.cs30s.gametools.Directions;
import year2018.cs30s.gametools.Image;

/**
 * Log.java - represents a log in the Frogger game
 *
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public class Log extends GameCharacter
{

    private Wall[] walls;
    
    /**
     * Constructor for the class sets class data
     * 
     * @param image the image associated with the game object
     * @param walls the wall objects associated with this object
     */
    public Log(Image image, Wall[] walls) {
        super(image, Directions.STOP, Constants.LOG_MOVE_AMOUNT,
              Constants.LOG_TIMER_DELAY, Constants.LOG_MOVE_DIRECTIONS);
        this.walls = walls;             // associate parameter with property
        randomDirection();              // start in a random direction
        setDebug(Constants.LOG_TEXT, Constants.LOG_COLOR);  // debug mode
    }

    /** 
     * The movement actions that this log performs 
     */
    @Override
    public void action() {
        move();
        checkWalls();
        redraw();
    }    

    /** 
     * Checks for collisions with walls and reacts 
     */
    private void checkWalls() {
        for (int i = 0; i < walls.length; i++) {
            if (isColliding(walls[i])) {
                bounceOff(walls[i]);
                return;
            }
        }
    }
        
}
