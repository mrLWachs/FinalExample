
/** required package */
package year2018.cs32s.moregaming.frogger;

/** required imports */
import year2018.cs32s.gametools.GameCharacter;
import java.awt.Color;
import year2018.cs32s.gametools.Image;

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
     * @param amount the amount the game object will move
     * @param delay the delay in milliseconds of the character's timer
     * @param color the background color associated with the image
     * @param walls the wall objects associated with this object
     * @param home the home object associated with this object
     * @param water the water object associated with this object
     * @param logs the log objects associated with this object
     */
    public Frog(Image image, int amount, int delay, 
            Color color, Wall[] walls, 
            Home home, Water water, Log[] logs) {
        super(image, 0, amount, delay, 4);
        this.walls = walls;
        this.home  = home;
        this.water = water;
        this.logs  = logs;
        onLog = false;
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