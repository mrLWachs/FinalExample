
/** required package class namespace */
package year2018.cs30s.moregaming.spaceinvaders;

/** required imports */
import year2018.cs30s.gametools.Directions;
import year2018.cs30s.gametools.GameCharacter;
import year2018.cs30s.gametools.Image;

/**
 * HeroBullet.java - represents the hero bullet of the space invaders game
 *
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public class HeroBullet extends GameCharacter
{

    private HeroShip    heroShip;   
    private Wall[]      walls;
    private EnemyShip[] enemyShips;
    private Base[]      bases;
    
    /** 
     * Determines if the hero ship's bullet is firing or not 
     */
    public  boolean isFiring;
    
    
    /**
     * Constructor for the class sets class data
     * 
     * @param image the image associated with the game character
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

    /** 
     * The movement actions that this hero bullet performs 
     */
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
    
    /** 
     * Starts the hero bullet in a state of firing 
     */
    public void fire() {        
        centerOnTop(heroShip);
        coordinate.direction =  Directions.UP;
        isFiring = true;
        show();
    }

    /** 
     * Checks for collisions with bases and reacts 
     */
    private void checkBases() {
        for (int i = 0; i < bases.length; i++) {
            if (isColliding(bases[i])) {
                bases[i].kill();
                isFiring = false;
                hide();
            }
        }
    }

    /** 
     * Checks for collisions with enemy ships and reacts 
     */
    private void checkEnemyShips() {
        for (int i = 0; i < enemyShips.length; i++) {
            if (isColliding(enemyShips[i])) {
                enemyShips[i].kill();
                isFiring = false;
                hide();
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
            }
        }
    }

}
