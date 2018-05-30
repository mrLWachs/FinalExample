
/** required package */
package year2018.cs32s.moregaming.spaceinvaders;

/** required imports */
import year2018.cs32s.gametools.GameCharacter;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import year2018.cs32s.gametools.Image;

/**
 * Ship.java - represents the hero ship of the space invaders game
 * @author Mr. Wachs' Computer Science Student 
 * @since 18-Jan-2016
 * @version 1.0
 * @instructor Mr. Wachs
 */
public class HeroShip extends GameCharacter
{

    private Wall[]     walls;
    private HeroBullet heroBullet;
    
    
    /**
     * constructor for the class sets class data
     * @param image the label associated with the image
     * @param amount the amount the game object will move
     * @param delay the delay in milliseconds of the character's timer
     * @param color the background color associated with the image
     * @param walls the wall objects associated with this object
     */
    public HeroShip(Image image, int amount, int delay, Color color, 
            Wall[] walls) {        
        super(image, 0, amount, delay, 4);
        this.walls = walls;
    }

    /** the movement actions that this hero ship performs */
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
                stickTo(walls[i]);
            }
        }
    }
    
    /**
     * moves or fires based on user keyboard action
     * @param event the keyboard event 
     */
    public void keyPress(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.VK_SPACE &&
            heroBullet.isFiring == false) 
            heroBullet.fire();
        super.keyPress(event);
    }

    /**
     * associates this hero ship object with the passed hero bullet object
     * @param heroBullet the hero bullet object to associate with
     */
    public void connect(HeroBullet heroBullet) {
        this.heroBullet = heroBullet;
    }

}
