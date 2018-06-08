
/** required package class namespace */
package year2018.cs30s.moregaming.survivor;


import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JLabel;
import mainpackage.MainClass;
import year2018.cs30s.gametools.Directions;
import year2018.cs30s.gametools.GameCharacter;
import year2018.cs30s.gametools.Image;

/**
 * Hero.java - description here...
 *
 * @author Mr. Wachs (login: lawrence.wachs)
 * @since Jun 7, 2018 
 * @instructor Mr. Wachs
 */
public class Hero extends GameCharacter
{
    
    private Wall[]     walls;
    private Goal       goal;
    private Engine     engine;
    private SpawnPoint spawnPoint;
    private SurvivorUI survivorUI;
    
    private ArrayList<Projectile> projectiles;

    
    public Hero(Image image, Wall[] walls, Goal goal, SurvivorUI survivorUI, 
                Engine engine) {
        super(image, 
              Directions.STOP,
              Constants.HERO_MOVE_AMOUNT,
              Constants.HERO_TIMER_DELAY,
              Constants.HERO_MOVE_DIRECTIONS);
        this.walls      = walls;
        this.goal       = goal;
        this.engine     = engine;
        this.survivorUI = survivorUI;
        projectiles     = new ArrayList<>();
        setDebug(Constants.HERO_TEXT, Constants.HERO_COLOR);
    }

    @Override
    public void action() {
        move();
        checkWalls();
        checkGoal();
        redraw();
    }

    private void checkWalls() {
        for (int i = 0; i < walls.length; i++) {
            if (isColliding(walls[i])) {
                stickTo(walls[i]);
                return;
            }
        }
    }

    private void checkGoal() {
        if (isColliding(goal)) {
            MainClass.totalPoints++;
            engine.shutDown();
        }
    }

    public void connectTo(SpawnPoint spawnPoint) {
        this.spawnPoint = spawnPoint;
    }
    
    public void keyPress(KeyEvent event) {
        super.keyPress(event);
        if (event.getKeyCode() == KeyEvent.VK_SPACE) {
            Image projectileImage = createImage();
            Projectile projectile = new Projectile(projectileImage,spawnPoint,
                                                   walls,coordinate.direction);
            projectiles.add(projectile);
        }
    }

    private Image createImage() {
        JLabel label = new JLabel();
        survivorUI.getContentPane().add(label);
        int w = coordinate.width / 2;
        int h = coordinate.height / 2;
        int x = coordinate.x + w / 2;
        int y = coordinate.y + h / 2;        
        label.setBounds(x, y, w, h);
        Image image = new Image(label);
        return image;
    }

}
