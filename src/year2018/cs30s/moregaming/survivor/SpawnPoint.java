
/** required package class namespace */
package year2018.cs30s.moregaming.survivor;

/** required imports */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JLabel;
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

    private Hero             hero;
    private Wall[]           walls;
    private SurvivorUI       survivorUI;
    private Engine           engine;
    private Timer            spawnTimer;
    public  ArrayList<Enemy> enemies;
    
    /**
     * Constructor for the class sets class data to the parameters
     * 
     * @param image the image associated with the game character
     * @param hero the hero object to associate with
     * @param walls the walls objects to associate with
     * @param survivorUI the user interface to associate with
     * @param engine the game engine to associate with 
     */
    public SpawnPoint(Image image, Hero hero, Wall[] walls, 
                      SurvivorUI survivorUI, Engine engine) {
        super(image);        
        this.hero       = hero;
        this.walls      = walls;
        this.survivorUI = survivorUI;
        this.engine     = engine;
        enemies         = new ArrayList<>();
        spawnTimer = new Timer(Constants.SPAWN_TIMER_DELAY, 
                               new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                spawnEnemy();
            }
        });
        spawnTimer.start();
        setDebug(Constants.SPAWN_POINT_TEXT, Constants.SPAWN_POINT_COLOR);
    }

    /**
     * Shuts down all enemies and the spawning timer
     */
    public void shutDown() {
        for (int i = 0; i < enemies.size(); i++) {
            enemies.get(i).shutDown();
        }
        spawnTimer.stop();
    }
    
    /**
     * Spawns a new enemy at the spawn point
     */
    public void spawnEnemy() {
        if (isClear()) {
            Image enemyImage = createImage();
            Enemy enemy = new Enemy(enemyImage, hero, walls, engine, enemies);
            enemies.add(enemy);
        }
    }
    
    /**
     * Create a new image for the created enemy
     * 
     * @return a image for the projectile image
     */
    private Image createImage() {
        JLabel label = new JLabel();
        survivorUI.getContentPane().add(label);
        int x = coordinate.x;
        int y = coordinate.y;
        int w = coordinate.width;
        int h = coordinate.height;
        label.setBounds(x, y, w, h); 
        Image image = new Image(label);
        return image;
    }

    /**
     * Determines if the spawn point enemy is clear of any enemies to spawn
     * a new enemy
     * 
     * @return the spawn area is clear (true) or not (false)
     */
    private boolean isClear() {
        if (enemies == null) return true;           // no enemies to check
        for (int i = 0; i < enemies.size(); i++) {  // traverse enemies
            Enemy enemy = enemies.get(i);           // get an enemy
            if (enemy.isColliding(this)) {          // collision with enemy
                return false;                       // not clear
            }
        }
        return true;                                // coast is clear
    }

}
