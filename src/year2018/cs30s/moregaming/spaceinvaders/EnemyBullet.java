
/** required package */
package year2018.cs30s.moregaming.spaceinvaders;

/** required imports */
import year2018.cs30s.gametools.Directions;
import year2018.cs30s.gametools.GameCharacter;
import year2018.cs30s.gametools.Image;

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
     * @param heroShip the hero ship object associated with this object
     * @param walls the wall objects associated with this object
     * @param bases the base objects associated with this object
     */
    public EnemyBullet(Image image, HeroShip heroShip, Wall[] walls, 
                       Base[] bases) {
        super(image, 
              Directions.STOP,
              Constants.ENEMY_BULLET_MOVE_AMOUNT,
              Constants.ENEMY_BULLET_TIMER_DELAY,
              Constants.ENEMY_BULLET_MOVE_DIRECTIONS);
        this.heroShip = heroShip;
        this.walls    = walls;
        this.bases    = bases;
        isFiring      = false;   
        hide();
        setDebug(Constants.ENEMY_BULLET_TEXT, Constants.ENEMY_BULLET_COLOR);
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
        show();
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
