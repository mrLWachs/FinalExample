
/** required package class namespace */
package year2018.cs30s.moregaming.survivor;

import year2018.cs30s.gametools.GameCharacter;
import year2018.cs30s.gametools.Image;

/**
 * Projectile.java - description here...
 *
 * @author Mr. Wachs (login: lawrence.wachs)
 * @since Jun 7, 2018 
 * @instructor Mr. Wachs
 */
public class Projectile extends GameCharacter
{

    private Wall[]     walls;
    private SpawnPoint spawnPoint;
    
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

    @Override
    public void action() {
        move();
        checkWalls();
        checkEnemies();
        redraw();
    }

    private void checkWalls() {
        for (int i = 0; i < walls.length; i++) {
            if (isColliding(walls[i])) {
                hide();
                shutDown();
                return;
            }
        }
    }

    private void checkEnemies() {
        for (int i = 0; i < spawnPoint.enemies.size(); i++) {
            Enemy enemy = spawnPoint.enemies.get(i);
            if (isColliding(enemy)) {
                spawnPoint.enemies.remove(enemy);
                enemy.hide();
                enemy.shutDown();
                hide();
                shutDown();
                return;
            }
        }
    }

}
