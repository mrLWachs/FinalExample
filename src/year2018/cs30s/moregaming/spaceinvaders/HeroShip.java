
/** required package class namespace */
package year2018.cs30s.moregaming.spaceinvaders;

/** required imports */
import year2018.cs30s.gametools.GameCharacter;
import java.awt.event.KeyEvent;
import year2018.cs30s.gametools.Directions;
import year2018.cs30s.gametools.Image;

/**
 * Ship.java - represents the hero ship of the space invaders game
 *
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public class HeroShip extends GameCharacter
{

    private Wall[]     walls;
    private HeroBullet heroBullet;
    
    
    /**
     * Constructor for the class sets class data
     * 
     * @param image the image associated with the game character
     * @param walls the wall objects associated with this object
     */
    public HeroShip(Image image, Wall[] walls) {        
        super(image, 
              Directions.STOP,
              Constants.HERO_MOVE_AMOUNT,
              Constants.HERO_TIMER_DELAY,
              Constants.HERO_MOVE_DIRECTIONS);
        this.walls = walls;
        setDebug(Constants.HERO_TEXT, Constants.HERO_COLOR);
    }

    /** 
     * The movement actions that this hero ship performs 
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
                stickTo(walls[i]);
            }
        }
    }
    
    /**
     * Moves or fires based on user keyboard action
     * 
     * @param event the keyboard event 
     */
    public void keyPress(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.VK_SPACE &&
            heroBullet.isFiring == false) 
            heroBullet.fire();
        super.keyPress(event);
    }

    /**
     * Associates this hero ship object with the passed hero bullet object
     * 
     * @param heroBullet the hero bullet object to associate with
     */
    public void connect(HeroBullet heroBullet) {
        this.heroBullet = heroBullet;
    }

}
