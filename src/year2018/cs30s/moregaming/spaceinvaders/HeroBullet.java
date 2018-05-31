
/** required package */
package year2018.cs30s.moregaming.spaceinvaders;

/** required imports */
import year2018.cs30s.gametools.Directions;
import year2018.cs30s.gametools.GameCharacter;
import java.awt.Color;
import year2018.cs30s.gametools.Image;

/**
 * HeroBullet.java - represents the hero bullet of the space invaders game
 * @author Mr. Wachs' Computer Science Student 
 * @since 18-Jan-2016
 * @version 1.0
 * @instructor Mr. Wachs
 */
public class HeroBullet extends GameCharacter
{

    private HeroShip    heroShip;   
    private Wall[]      walls;
    private EnemyShip[] enemyShips;
    private Base[]      bases;
    
    /** determines if the hero ship's bullet is firing or not */
    public  boolean isFiring;
    
    
    /**
     * constructor for the class sets class data
     * @param image the label associated with the image
     * @param amount the amount the game object will move
     * @param delay the delay in milliseconds of the character's timer
     * @param color the background color associated with the image
     * @param heroShip the hero ship object associated with this object
     * @param walls the wall objects associated with this object
     * @param enemyShips the enemy ship objects associated with this object
     * @param bases the base objects associated with this object
     */
    public HeroBullet(Image image, HeroShip heroShip, Wall[] walls,
                      EnemyShip[] enemyShips, Base[] bases) {
        super(image, 
              Directions.STOP,
              Constants.HERO_BULLET_MOVE_AMOUNT,
              Constants.HERO_BULLET_TIMER_DELAY,
              Constants.HERO_BULLET_MOVE_DIRECTIONS);
        this.heroShip   = heroShip;
        this.walls      = walls;
        this.enemyShips = enemyShips;
        this.bases      = bases;
        isFiring        = false;   
        hide();
        setDebug(Constants.HERO_BULLET_TEXT, Constants.HERO_BULLET_COLOR);
    }

    /** the movement actions that this hero bullet performs */
    @Override
    public void action() {
        if (isFiring) {
            move();
            checkBases();
            checkEnemyShips();
            checkWalls();
            redraw();
        }
    }
    
    /** starts the hero bullet in a state of firing */
    public void fire() {        
        centerOnTop(heroShip);
        coordinate.direction =  Directions.UP;
        isFiring = true;
        show();
    }

    /** checks for collisions with bases and reacts */
    private void checkBases() {
        for (int i = 0; i < bases.length; i++) {
            if (isColliding(bases[i])) {
                bases[i].kill();
                isFiring = false;
                hide();
            }
        }
    }

    /** checks for collisions with enemy ships and reacts */
    private void checkEnemyShips() {
        for (int i = 0; i < enemyShips.length; i++) {
            if (isColliding(enemyShips[i])) {
                enemyShips[i].kill();
                isFiring = false;
                hide();
            }
        }
    }

    /** checks for collisions with walls and reacts */
    private void checkWalls() {
        for (int i = 0; i < walls.length; i++) {
            if (isColliding(walls[i])) {
                isFiring = false;
                hide();
            }
        }
    }

}
