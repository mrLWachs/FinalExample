
/** required package class namespace */
package year2018.cs30s.moregaming.survivor;

/** required imports */
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import mainpackage.MainClass;
import year2018.cs30s.gametools.Directions;
import year2018.cs30s.gametools.GameCharacter;
import year2018.cs30s.gametools.Image;

/**
 * Hero.java - represents the hero of the survivor game
 *
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public class Hero extends GameCharacter
{
    
    private Wall[]                walls;
    private Goal                  goal;
    private Engine                engine;
    private Spawner               spawners;
    private SurvivorUI            survivorUI;    
    private ArrayList<Projectile> projectiles;

    
    /**
     * Constructor for the class sets class data to the parameters
     * 
     * @param image the image associated with the game character
     * @param walls the walls objects to associate with
     * @param goal the goal object to associate with
     * @param survivorUI the user interface to associate with
     * @param engine the game engine to associate with 
     */
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
    }

    /** 
     * The actions that this game character performs 
     */
    @Override
    public void action() {
        move();
        checkWalls();
        checkGoal();
        redraw();
    }

    /** 
     * Checks for collisions with walls and reacts 
     */
    private void checkWalls() {
        for (int i = 0; i < walls.length; i++) {
            if (isColliding(walls[i])) {
                stickTo(walls[i]);
                return;
            }
        }
    }

    /** 
     * Checks for collisions with the goal and reacts 
     */
    private void checkGoal() {
        if (isColliding(goal)) {
            MainClass.totalPoints++;
            engine.shutDown();
        }
    }

    /**
     * Associates this object to the spawner object
     * 
     * @param spawners the spawners object to connect to
     */
    public void connectTo(Spawner spawners) {
        this.spawners = spawners;
    }
    
    /**
     * The user keyboard action to react to
     * 
     * @param event the keyboard event 
     */
    public void keyPress(KeyEvent event) {
        super.keyPress(event);
        if (event.getKeyCode() == KeyEvent.VK_SPACE) {
            int w = coordinate.width  / 2;
            int h = coordinate.height / 2;
            int x = coordinate.x + w / 2;
            int y = coordinate.y + h / 2;
            Image projectileImage = engine.createImage(x,y,w,h,
                    Constants.PROJECTILE_IMAGE);
            Projectile projectile = new Projectile(projectileImage,spawners,
                                                   walls,coordinate.direction);
            projectiles.add(projectile);
        }
    }

    public void shutDown() {
        super.shutDown();
        for (int i = 0; i < projectiles.size(); i++) {
            Projectile projectile = projectiles.get(i);    // get an enemy 
            projectile.hide();                       // hide enemy
            projectile.shutDown();                   // shut down enemy
        }
        projectiles.clear();
    }
    
}
