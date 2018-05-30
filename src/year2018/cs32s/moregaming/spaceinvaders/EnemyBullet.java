
/** required package */
package year2018.cs32s.moregaming.spaceinvaders;

/** required imports */
import year2018.cs32s.gametools.Directions;
import year2018.cs32s.gametools.GameCharacter;
import java.awt.Color;
import year2018.cs32s.gametools.Image;

/**
 * EnemyBullet.java - represents the enemy bullet of the space invaders game
 * @author Mr. Wachs' Computer Science Student 
 * @since 18-Jan-2016
 * @version 1.0
 * @instructor Mr. Wachs
 */
public class EnemyBullet extends GameCharacter
{
    
    private HeroShip    heroShip;   
    private Wall[]      walls;
    private Base[]      bases;    
    
    /** is this ship firing or not */
    public  boolean isFiring;
    
    /**
     * constructor for the class sets class data
     * @param image the label associated with the image
     * @param amount the amount the game object will move
     * @param delay the delay in milliseconds of the character's timer
     * @param color the background color associated with the image
     * @param heroShip the hero ship object associated with this object
     * @param walls the wall objects associated with this object
     * @param bases the base objects associated with this object
     */
    public EnemyBullet(Image image, int amount, int delay, Color color, 
            HeroShip    heroShip, 
            Wall[]      walls,
            Base[]      bases) {
        super(image, 0, amount, delay, 4);
        this.heroShip = heroShip;
        this.walls    = walls;
        this.bases    = bases;
        isFiring      = false;   
    }

    /** the movement actions that this enemy bullet performs */
    @Override
    public void action() {
        if (isFiring) {
            move();
            checkHero();
            checkBases();
            checkWalls();
            redraw();
        }
    }
        
    /**
     * starts this bullet firing
     * @param enemyShip the ship that this bullet fires from
     */
    public void fire(EnemyShip enemyShip) {
        centerOnBottom(enemyShip);
        coordinate.direction = Directions.DOWN;
        move();
        isFiring = true;
    }

    /** checks for collision with the hero ship and reacts */
    private void checkHero() {
        if (isColliding(heroShip)) {
            System.exit(0);
        }
    }

    /** checks for collision with bases and reacts */
    private void checkBases() {
        for (int i = 0; i < bases.length; i++) {
            if (isColliding(bases[i])) {
                bases[i].kill();
                isFiring = false;
                
            }
        }
    }

    /** checks for collisions with walls and reacts */
    private void checkWalls() {
        for (int i = 0; i < walls.length; i++) {
            if (isColliding(walls[i])) {
                isFiring = false;
                
            }
        }
    }
    
}
