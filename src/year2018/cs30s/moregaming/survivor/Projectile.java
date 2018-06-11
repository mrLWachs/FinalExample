
/** required package class namespace */
package year2018.cs30s.moregaming.survivor;

/** required imports */
import year2018.cs30s.gametools.GameCharacter;
import year2018.cs30s.gametools.Image;

/**
 * Projectile.java - represents a projectile in the survivor game
 *
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public class Projectile extends GameCharacter
{

    private Wall[]     walls;
    private SpawnPoint spawnPoint;
    
    /**
     * Constructor for the class sets class data to the parameters
     * 
     * @param image the image associated with the game character
     * @param spawnPoint the spawn point object to associate with
     * @param walls the walls objects to associate with
     * @param direction the direction to move the projectile
     */
    public Projectile(Image image, SpawnPoint spawnPoint, Wall[] walls, 
                      int direction) {
        super(image,
              direction, 
              Constants.PROJECTILE_MOVE_AMOUNT, 
              Constants.PROJECTILE_TIMER_DELAY, 
              Constants.PROJECTILE_MOVE_DIRECTIONS);           
        this.walls      = walls;
        this.spawnPoint = spawnPoint;        
        setDebug(Constants.PROJECTILE_TEXT, Constants.PROJECTILE_COLOR);
    }

    /** 
     * The actions that this game character performs 
     */
    @Override
    public void action() {
        move();
        checkWalls();
        checkEnemies();
        redraw();
    }

    /** 
     * Checks for collisions with walls and reacts 
     */
    private void checkWalls() {
        for (int i = 0; i < walls.length; i++) {
            if (isColliding(walls[i])) {
                hide();
                shutDown();
                return;
            }
        }
    }

    /** 
     * Checks for collisions with all enemies and reacts 
     */
    private void checkEnemies() {
        for (int i = 0; i < spawnPoint.enemies.size(); i++) {   // traverse 
            Enemy enemy = spawnPoint.enemies.get(i);    // get en enemy
            if (isColliding(enemy)) {               // collision with enemy
                spawnPoint.enemies.remove(enemy);   // remove enemy from list
                enemy.hide();                       // hide enemy
                enemy.shutDown();                   // shut down enemy
                hide();                             // hide projectile
                shutDown();                         // shut down projectile
                return;
            }
        }
    }

}
