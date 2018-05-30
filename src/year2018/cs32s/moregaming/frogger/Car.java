
/** required package */
package year2018.cs32s.moregaming.frogger;

/** required imports */
import year2018.cs32s.gametools.GameCharacter;
import java.awt.Color;
import year2018.cs32s.gametools.Image;

/**
 * Car.java - represents a car in the frogger game
 * @author Mr. Wachs' Computer Science Student
 * @since 18-Jan-2016
 * @version 1.0
 * @instructor Mr. Wachs
 */
public class Car extends GameCharacter
{
    
    private Frog   frog;
    private Wall[] walls;

    /**
     * constructor for the class sets class data
     * @param image the label associated with the image
     * @param amount the amount the game object will move
     * @param delay the delay in milliseconds of the character's timer
     * @param color the background color associated with the image
     * @param frog the frog object associated with this object
     * @param walls the wall objects associated with this object
     */
    public Car(Image image, int amount, int delay, Color color,
            Frog frog, Wall[] walls) {
        super(image, 0, amount, delay, 4);
        this.frog  = frog;
        this.walls = walls;
    }

    /** the movement actions that this car performs */
    @Override
    public void action() {
        move();
        checkWalls();
        checkFrog();
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

    /** checks for collision with frog and reacts */
    private void checkFrog() {
        if (isColliding(frog)) {
            System.exit(0);
        }
    }

}
