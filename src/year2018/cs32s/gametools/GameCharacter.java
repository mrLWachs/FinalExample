
/** required package class namespace */
package year2018.cs32s.gametools;

/** required imports */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 * GameCharacter.java - representation of a character in a game 
 *
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public abstract class GameCharacter extends GameObject
{
    
    private Timer timer;

    /**
     * Constructor for the class sets class data
     * 
     * @param image the label associated with the image for the game character
     * @param direction the direction the game character will move
     * @param amount the amount the game character will move
     * @param delay the delay in milliseconds of the character's timer
     */
    public GameCharacter(Image image, int direction, int amount, int delay) {
        super(image);                               // build game object
        super.coordinate = new Coordinate(image, direction, amount);
        timer = new Timer(delay, new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                action();
            }
        });
        timer.start();                              // start character's timer
    }

    /**
     * The abstract action this character does in it's timer
     */
    public abstract void action();
    
    /**
     * Re-positions the image in it's container based on game character's data
     */
    public void redraw() {
        image.redraw(coordinate);
    }
    
    /**
     * Moves based on game character's coordinate data
     */
    public void move() {
        coordinate.move();
    }
    
    /**
     * Determines if this game character is colliding with a game object
     * 
     * @param target the game object to check for collision with
     * @return it is colliding (true) or not (false)
     */
    public boolean isColliding(GameObject target) {
        return coordinate.isOverlapping(target.coordinate);
    }
    
    public void stickTo(GameObject target) {
        coordinate.stickTo(target.coordinate);
    }
    
    public void bounceOff(GameObject target) {
        coordinate.bounceOff(target.coordinate);
    }
    
    public void randomDirection(int numberOfDirections) {
        coordinate.randomDirection(numberOfDirections);
    }
   
}
