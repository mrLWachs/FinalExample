
/** required package class namespace */
package year2018.cs30s.moregaming.survivor;

/** required imports */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import year2018.cs30s.gametools.GameObject;
import year2018.cs30s.gametools.Image;

/**
 * SpawnPoint.java - represents the spawn point in the survivor game.
 *
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public class SpawnPoint extends GameObject
{

    private Hero    hero;
    private Wall[]  walls;
    private Engine  engine;
    private Spawner spawner;
    private Timer   spawnTimer;
    
    /**
     * Constructor for the class sets class data to the parameters
     * 
     * @param image the image associated with the game character
     * @param hero the hero object to associate with
     * @param walls the walls objects to associate with
     * @param engine the game engine to associate with 
     * @param spawner 
     */
    public SpawnPoint(Image image, Hero hero, Wall[] walls, Engine engine,
                      Spawner spawner) {
        super(image);        
        this.hero    = hero;
        this.walls   = walls;
        this.engine  = engine; 
        this.spawner = spawner;
        spawnTimer   = new Timer(Constants.SPAWN_TIMER_DELAY, 
                               new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                spawnEnemy();
            }
        });
        spawnTimer.start();
//        setDebug(Constants.SPAWN_POINT_TEXT, Constants.SPAWN_POINT_COLOR);
    }

    /**
     * Shuts down all enemies and the spawning timer
     */
    public void shutDown() {
        spawnTimer.stop();
    }
    
    /**
     * Spawns a new enemy at the spawn point
     */
    public void spawnEnemy() {
        if (isClear()) {
            int x = coordinate.x;
            int y = coordinate.y;
            int w = coordinate.width;
            int h = coordinate.height;
            Image enemyImage = engine.createImage(x,y,w,h,
                                                  Constants.ENEMY_IMAGE);
            Enemy enemy = new Enemy(enemyImage, hero, walls, engine, spawner);
            spawner.enemies.add(enemy);
        }
    }

    /**
     * Determines if the spawn point enemy is clear of any enemies to spawn
     * a new enemy
     * 
     * @return the spawn area is clear (true) or not (false)
     */
    private boolean isClear() {
        if (spawner.enemies == null) return true;           // no enemies to check
        for (int i = 0; i < spawner.enemies.size(); i++) {  // traverse enemies
            Enemy enemy = spawner.enemies.get(i);           // get an enemy
            if (enemy.isColliding(this)) {          // collision with enemy
                return false;                       // not clear
            }
        }
        return true;                                // coast is clear
    }

}
