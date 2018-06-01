
/** required package class namespace */
package year2018.cs30s.moregaming.frogger;

/** required imports */
import year2018.cs30s.gametools.GameCharacter;
import year2018.cs30s.gametools.Directions;
import year2018.cs30s.gametools.Image;

/**
 * Frog.java - represents a frog in the Frogger game
 *
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public class Frog extends GameCharacter
{
    
    private Wall[]  walls;
    private Log[]   logs;
    private Home    home;
    private Water   water;
    private boolean onLog;
    
    
    /**
     * Constructor for the class sets class data
     * 
     * @param image the label associated with the image
     * @param walls the wall objects associated with this object
     * @param home the home object associated with this object
     * @param water the water object associated with this object
     * @param logs the log objects associated with this object
     */
    public Frog(Image image, Wall[] walls, Home home, Water water, Log[] logs) {
        super(image, Directions.STOP, Constants.FROGGER_MOVE_AMOUNT,
              Constants.FROGGER_TIMER_DELAY, Constants.FROGGER_MOVE_DIRECTIONS);
        this.walls = walls;             // associate parameter with property
        this.home  = home;              // associate parameter with property
        this.water = water;             // associate parameter with property
        this.logs  = logs;              // associate parameter with property
        onLog = false;                  // assume frog is not on a log
        setDebug(Constants.FROGGER_TEXT, Constants.FROGGER_COLOR);
    }

    /** 
     * The movement actions that this frog performs 
     */
    @Override
    public void action() {
        move();
        checkWalls();
        checkHome();
        checkLogs();
        checkWater();        
        redraw();
    }

    /** 
     * Checks for collisions with walls and reacts 
     */
    private void checkWalls() {
        for (int i = 0; i < walls.length; i++) {
            if (isColliding(walls[i])) {
                stickTo(walls[i]);
            }
        }
    }

    /** 
     * Checks for collision with home and reacts 
     */
    private void checkHome() {
        if (isColliding(home)) {
            landOn(home);
        }
    }

    /** 
     * Checks for collision with water and reacts 
     */
    private void checkWater() {
        if (isColliding(water) && onLog == false) {
            System.exit(0);
        }
    }

    /** 
     * Checks for collisions with logs and reacts 
     */
    private void checkLogs() {
        onLog = false;
        for (int i = 0; i < logs.length; i++) {
            if (isColliding(logs[i])) {
                onLog = true;
            }
        }
    }

    /**
     * User key board action of releasing a key stops movement
     */
    public void keyRelease() {
        stop();
    }

}