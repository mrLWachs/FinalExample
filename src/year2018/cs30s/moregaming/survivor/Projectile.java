
/** required package class namespace */
package year2018.cs30s.moregaming.survivor;

/** required imports */
import year2018.cs30s.gametools.GameCharacter;
import year2018.cs30s.gametools.Image;
import year2018.cs30s.tools.MediaPlayer;

/**
 * Projectile.java - represents a projectile in the survivor game
 *
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public class Projectile extends GameCharacter
{

    private Wall[]      walls;
    private Spawner     spawner;
    private MediaPlayer player;
    
    
    /**
     * Constructor for the class sets class data to the parameters
     * 
     * @param image the image associated with the game character
     * @param spawners the spawners object to associate with
     * @param walls the walls objects to associate with
     * @param direction the direction to move the projectile
     */
    public Projectile(Image image, Spawner spawners, Wall[] walls, 
                      int direction) {
        super(image,
              direction, 
              Constants.PROJECTILE_MOVE_AMOUNT, 
              Constants.PROJECTILE_TIMER_DELAY, 
              Constants.PROJECTILE_MOVE_DIRECTIONS);           
        this.walls   = walls;
        this.spawner = spawners;        
        player = new MediaPlayer();
        player.playWav(Constants.PROJECTILE_SOUND_FILE);
    }

    /** 
     * The actions that this game character performs 
     */
    @Override
    public void action() {
        move();
        checkWalls();
        spawner.check(this);
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

    public void shutDown() {
        super.shutDown();
        player.stop();
    }
    
}
