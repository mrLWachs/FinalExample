
/** required package class namespace */
package year2018.cs30s.moregaming.survivor;

/** required imports */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import year2018.cs30s.gametools.Directions;
import year2018.cs30s.gametools.GameCharacter;
import year2018.cs30s.gametools.Image;
import year2018.cs30s.tools.MediaPlayer;
import year2018.cs30s.tools.Numbers;

/**
 * Enemy.java - represents an enemy of the survivor game
 *
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public class Enemy extends GameCharacter
{
    
    private Wall[]      walls;
    private Hero        hero;
    private Engine      engine;
    private Spawner     spawner;
    private MediaPlayer player;
    private Timer       tracker;
    
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
                 Spawner spawner) {
        super(image, 
              Directions.STOP,
              Constants.ENEMY_MOVE_AMOUNT,
              Constants.ENEMY_TIMER_DELAY,
              Constants.ENEMY_MOVE_DIRECTIONS);
        this.walls   = walls;               // connect parameter to property
        this.hero    = hero;
        this.engine  = engine;
        this.spawner = spawner;        
        player = new MediaPlayer();
        number = spawner.enemies.size();
        tracker = new Timer(Constants.ENEMY_TRACKER_TIMER_DELAY, 
                            new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trackHero();
            }
        });
        tracker.start();
        randomDirection();                  // start in a random direction
        player.playWav(Constants.SPAWN_ENEMY_SOUND_FILE);
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
        if (spawner.enemies == null) return;                // no enemies yet
        for (int i = 0; i < spawner.enemies.size(); i++) {  // traverse enemies
            Enemy enemy = spawner.enemies.get(i);           // get an enemy
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

    private void trackHeroVertially() {
        if      (hero.isAbove(this)) coordinate.direction = Directions.UP;
        else if (hero.isBelow(this)) coordinate.direction = Directions.DOWN;
    }
    
    private void trackHeroHorizontally() {
        if      (hero.isRightOf(this)) coordinate.direction = Directions.RIGHT;
        else if (hero.isLeftOf(this))  coordinate.direction = Directions.LEFT;
    }

    private void trackHero() {
        int chance = Numbers.random(1, 2);
        if      (chance == 1) trackHeroVertially();
        else if (chance == 2) trackHeroHorizontally();
    }
    
    public void shutDown() {
        super.shutDown();
        player.stop();
    }

}
