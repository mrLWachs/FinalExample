
/** required package */
package year2018.cs30s.moregaming.frogger;

/** required imports */
import year2018.cs30s.gametools.GameCharacter;
import java.awt.Color;
import year2018.cs30s.gametools.Directions;
import year2018.cs30s.gametools.Image;

/**
 * Frog.java - represents a frog in the frogger game
 * @author Mr. Wachs' Computer Science Student 
 * @since 18-Jan-2016
 * @version 1.0
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
     * constructor for the class sets class data
     * @param image the label associated with the image
     * @param walls the wall objects associated with this object
     * @param home the home object associated with this object
     * @param water the water object associated with this object
     * @param logs the log objects associated with this object
     */
    public Frog(Image image, Wall[] walls, Home home, Water water, Log[] logs) {
        super(image, 
              Directions.STOP,
              Constants.FROGGER_MOVE_AMOUNT,
              Constants.FROGGER_TIMER_DELAY,
              Constants.FROGGER_MOVE_DIRECTIONS);
        this.walls = walls;
        this.home  = home;
        this.water = water;
        this.logs  = logs;
        onLog = false;
        setDebug(Constants.FROGGER_TEXT, Constants.FROGGER_COLOR);
    }

    /** the movement actions that this frog performs */
    @Override
    public void action() {
        move();
        checkWalls();
        checkHome();
        checkWater();
        checkLogs();
        redraw();
    }

    /** checks for collisions with walls and reacts */
    private void checkWalls() {
        for (int i = 0; i < walls.length; i++) {
            if (isColliding(walls[i])) {
                stickTo(walls[i]);
            }
        }
    }

    /** checks for collision with home and reacts */
    private void checkHome() {
        if (isColliding(home)) {
            landOn(home);
        }
    }

    /** checks for collision with water and reacts */
    private void checkWater() {
        if (isColliding(water) && onLog == false) {
            System.exit(0);
        }
    }

    /** checks for collisions with logs and reacts */
    private void checkLogs() {
        onLog = false;
        for (int i = 0; i < logs.length; i++) {
            if (isColliding(logs[i])) {
                onLog = true;
            }
        }
    }

}