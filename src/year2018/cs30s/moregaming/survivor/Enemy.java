
/** required package class namespace */
package year2018.cs30s.moregaming.survivor;

/** required imports */
import java.util.ArrayList;
import year2018.cs30s.gametools.Directions;
import year2018.cs30s.gametools.GameCharacter;
import year2018.cs30s.gametools.Image;

/**
 * Enemy.java - represents an enemy of the survivor game
 *
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public class Enemy extends GameCharacter
{
    
    private Wall[]           walls;
    private Hero             hero;
    private Engine           engine;
    private ArrayList<Enemy> enemies;
    
    /**
     * Tracking number to identify each enemy separately
     */
    public int number;

    
    /**
     * Constructor for the class sets class data to the parameters
     * 
     * @param image the image associated with the game character
     * @param hero the hero object to associate with
     * @param walls the walls objects to associate with
     * @param engine the game engine to associate with
     * @param enemies the list of enemy objects to associate with
     */
    public Enemy(Image image, Hero hero, Wall[] walls, Engine engine, 
                 ArrayList<Enemy> enemies) {
        super(image, 
              Directions.STOP,
              Constants.ENEMY_MOVE_AMOUNT,
              Constants.ENEMY_TIMER_DELAY,
              Constants.ENEMY_MOVE_DIRECTIONS);
        this.walls   = walls;               // connect parameter to property
        this.hero    = hero;
        this.engine  = engine;
        this.enemies = enemies;        
        setDebug(Constants.ENEMY_TEXT, Constants.ENEMY_COLOR);
        number = enemies.size();
        randomDirection();                  // start in a random direction
    }

    /** 
     * The actions that this game character performs 
     */
    @Override
    public void action() {
        move();
        checkWalls();
        checkOtherEnemies();
        checkHero();
        redraw();
    }
    
    /** 
     * Checks for collisions with walls and reacts 
     */
    private void checkWalls() {
        for (int i = 0; i < walls.length; i++) {
            if (isColliding(walls[i])) {
                bounceOff(walls[i]);
                randomDirection();
                return;
            }
        }
    }

    /** 
     * Checks for collisions with the hero and reacts 
     */
    private void checkHero() {
        if (isColliding(hero)) {
            engine.shutDown();
        }
    }

    /** 
     * Checks for collisions with other enemies and reacts 
     */
    private void checkOtherEnemies() {
        if (enemies == null) return;                // no enemies yet
        for (int i = 0; i < enemies.size(); i++) {  // traverse enemies
            Enemy enemy = enemies.get(i);           // get an enemy
            if (enemy.equals(this) == false) {      // not colliding with self
                if (isColliding(enemy)) {           // collision
                    bounceOff(enemy);
                    randomDirection();
                    return;
                }
            }
        }
    }
    
    /**
     * Checks to see if an enemy is equal to another enemy
     * 
     * @param enemy the enemy to check with
     * @return is the same enemy (true) or not (false)
     */
    public boolean equals(Enemy enemy) {
        if (this.number == enemy.number) return true;
        else                             return false;
    }

}
