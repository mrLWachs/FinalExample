
/** required package class namespace */
package year2018.cs30s.moregaming.spaceinvaders;

/** required imports */
import year2018.cs30s.gametools.Directions;
import year2018.cs30s.gametools.GameCharacter;
import year2018.cs30s.gametools.Image;

/**
 * EnemyBullet.java - represents the enemy bullet of the space invaders game
 *
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public class EnemyBullet extends GameCharacter
{
    
    private HeroShip heroShip;   
    private Wall[]   walls;
    private Base[]   bases; 
    private Engine   engine;
    
    /** 
     * Is this ship firing or not 
     */
    public boolean isFiring;
    
    /**
     * Constructor for the class sets class data
     * 
     * @param image the image associated with the game character
     * @param heroShip the hero ship object associated with this object
     * @param walls the wall objects associated with this object
     * @param bases the base objects associated with this object
     * @param engine the logic engine for the game
     */
    public EnemyBullet(Image image, HeroShip heroShip, Wall[] walls, 
                       Base[] bases, Engine engine) {
        super(image, 
              Directions.STOP,
              Constants.ENEMY_BULLET_MOVE_AMOUNT,
              Constants.ENEMY_BULLET_TIMER_DELAY,
              Constants.ENEMY_BULLET_MOVE_DIRECTIONS);
        this.engine   = engine;
        this.heroShip = heroShip;
        this.walls    = walls;
        this.bases    = bases;
        isFiring      = false;   
        hide();
        setDebug(Constants.ENEMY_BULLET_TEXT, Constants.ENEMY_BULLET_COLOR);
    }

    /** 
     * The movement actions that this enemy bullet performs 
     */
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
     * Starts this bullet firing
     * 
     * @param enemyShip the ship that this bullet fires from
     */
    public void fire(EnemyShip enemyShip) {
        show();
        centerOnBottom(enemyShip);
        coordinate.direction = Directions.DOWN;
        move();
        isFiring = true;
    }

    /** 
     * Checks for collision with the hero ship and reacts 
     */
    private void checkHero() {
        if (isColliding(heroShip)) {
            engine.shutDown();
        }
    }

    /** 
     * Checks for collision with bases and reacts 
     */
    private void checkBases() {
        for (int i = 0; i < bases.length; i++) {
            if (isColliding(bases[i])) {
                bases[i].kill();
                isFiring = false;
                hide();
                return;
            }
        }
    }

    /** 
     * Checks for collisions with walls and reacts 
     */
    private void checkWalls() {
        for (int i = 0; i < walls.length; i++) {
            if (isColliding(walls[i])) {
                isFiring = false;
                hide();
                return;
            }
        }
    }
    
}
