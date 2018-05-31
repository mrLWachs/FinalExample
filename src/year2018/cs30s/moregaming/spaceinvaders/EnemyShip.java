
/** required package */
package year2018.cs30s.moregaming.spaceinvaders;

/** required imports */
import year2018.cs30s.gametools.Directions;
import year2018.cs30s.gametools.GameCharacter;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import year2018.cs30s.gametools.Image;

/**
 * EnemyShip.java - represents the enemy ship of the space invaders game
 * @author Mr. Wachs' Computer Science Student 
 * @since 18-Jan-2016
 * @version 1.0
 * @instructor Mr. Wachs
 */
public class EnemyShip extends GameCharacter
{

    private Wall[]      walls;
    private EnemyBullet enemyBullet;
    private Timer       shootTimer;
    
    
    /**
     * constructor for the class sets class data
     * @param image the label associated with the image
     * @param amount the amount the game object will move
     * @param delay the delay in milliseconds of the character's timer
     * @param color the background color associated with the image
     * @param walls the wall objects associated with this object
     * @param shootDelay the delay in milliseconds of the time between shots
     * @param enemyBullet the enemy bullet object associated with this object
     */
    public EnemyShip(Image image, Wall[] walls, EnemyBullet enemyBullet) {        
        super(image, 
              Directions.STOP,
              Constants.ENEMY_MOVE_AMOUNT,
              Constants.ENEMY_TIMER_DELAY,
              Constants.ENEMY_MOVE_DIRECTIONS); 
        this.walls       = walls;
        this.enemyBullet = enemyBullet;
        shootTimer       = new Timer(Constants.ENEMY_SHOOT_TIMER_DELAY, 
                                     new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                shouldShoot();
            }
        });
        shootTimer.start();
        coordinate.direction = Directions.RIGHT;
        int r = (int)((255-100+1)*Math.random()+100);
        int g = (int)((255-100+1)*Math.random()+100);
        int b = (int)((255-100+1)*Math.random()+100);  
        setDebug(Constants.ENEMY_TEXT, new Color(r,g,b));
    }

    /** the movement actions that this enemy ship performs */
    @Override
    public void action() {
        move();
        checkWalls();
        redraw();
    }
    
    /** when this enemy ship is killed and removed from the game */
    public void kill() {
        shootTimer.stop();
        hide();
    }

    /** checks for collisions with walls and reacts */
    private void checkWalls() {
        for (int i = 0; i < walls.length; i++) {
            if (isColliding(walls[i])) {
                bounceOff(walls[i]);
            }
        }
    }
    
    /** the action to shoot or not randomly when it's time */
    private void shouldShoot() {
        if (enemyBullet.isFiring == false) {
             int chance = (int)((3-1+1)*Math.random()+1);
             if (chance == 1) {
                 enemyBullet.fire(this);
             }
        }
    }

}
