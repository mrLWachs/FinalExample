
/** required package class namespace */
package year2018.cs30s.pacman;

/** required imports */
import year2018.cs30s.gametools.Directions;
import year2018.cs30s.gametools.GameCharacter;
import year2018.cs30s.gametools.Image;

/**
 * Ghost.java - represents a Ghost character in the game Pacman
 *
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public class Ghost extends GameCharacter
{
    
    private Wall[] walls;
    private Pacman pacman;
    private Engine engine;
    
    
    /**
     * Constructor sets class properties
     * 
     * @param image the image to use for this game character
     * @param walls the Wall array representing all the game walls
     * @param pacman the Pacman game character 
     * @param engine the logic engine for the game
     */
    public Ghost(Image image, Wall[] walls, Pacman pacman, Engine engine) {        
        super(image, Directions.STOP, 
              Constants.GHOST_MOVE_AMOUNT,
              Constants.GHOST_TIMER_DELAY, 
              Constants.GHOST_MOVE_DIRECTIONS);
        this.walls  = walls;
        this.pacman = pacman;
        this.engine = engine;
        setDebug(Constants.GHOST_TEXT, Constants.GHOST_COLOR);
        randomDirection();
    }

    /**
     * The action this character does in it's timer
     */
    @Override
    public void action() {
        move();
        checkWalls();
        checkPacman();
        redraw();
    }

    /**
     * Checks for collision with all the walls in the game
     */
    private void checkWalls() {
        for (int i = 0; i < walls.length; i++) {
            if (isColliding(walls[i])) {
                bounceOff(walls[i]);
                randomDirection();
            }
        }
    }

    /**
     * Checks for collision with Pacman in the game
     */
    private void checkPacman() {
        if (isColliding(pacman)) {
            engine.shutDown();
        }
    }
    
}
