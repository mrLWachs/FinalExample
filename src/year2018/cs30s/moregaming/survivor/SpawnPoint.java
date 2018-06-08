
/** required package class namespace */
package year2018.cs30s.moregaming.survivor;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.Timer;
import year2018.cs30s.gametools.GameObject;
import year2018.cs30s.gametools.Image;

/**
 * SpawnPoint.java - description here...
 *
 * @author Mr. Wachs (login: lawrence.wachs)
 * @since Jun 7, 2018 
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

    public void shutDown() {
        for (int i = 0; i < enemies.size(); i++) {
            enemies.get(i).shutDown();
        }
        spawnTimer.stop();
    }
    
    public void spawnEnemy() {
        Image enemyImage = createImage();
        Enemy enemy = new Enemy(enemyImage, hero, walls, engine);
        enemies.add(enemy);
    }
    
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

}
