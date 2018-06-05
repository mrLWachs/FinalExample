
/** required package class namespace */
package year2018.cs30s.pacman;

/** required imports */
import year2018.cs30s.gametools.Directions;
import year2018.cs30s.gametools.GameCharacter;
import year2018.cs30s.gametools.Image;

/**
 * Pacman.java - represents a Pacman character in the game Pacman
 *
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public class Pacman extends GameCharacter
{
      
    private Dot[]  dots;
    private Wall[] walls;
    
    
    /**
     * Constructor sets class properties
     * 
     * @param image the image to use for this game character
     * @param dots the Dot array representing all the game dots
     * @param walls the Wall array representing all the game walls
     */
    public Pacman(Image image, Dot[] dots, Wall[] walls) {        
        super(image, Directions.STOP, 
              Constants.PACMAN_MOVE_AMOUNT,
              Constants.PACMAN_TIMER_DELAY, 
              Constants.PACMAN_MOVE_DIRECTIONS);
        this.walls  = walls;
        this.dots   = dots;
        setDebug(Constants.PACMAN_TEXT, Constants.PACMAN_COLOR);
    }

    /**
     * The action this character does in it's timer
     */
    @Override
    public void action() {
        move();
        checkWalls();
        checkDots();
        redraw();
    } 

    /**
     * Checks for collision with all the walls in the game
     */
    private void checkWalls() {
        for (int i = 0; i < walls.length; i++) {
            if (isColliding(walls[i])) {
                stickTo(walls[i]);
            }
        }
    }

    /**
     * Checks for collision with all the dots in the game
     */
    private void checkDots() {
        for (int i = 0; i < dots.length; i++) {
            if (isColliding(dots[i])) {
                dots[i].getEaten();
            }
        }
    }

}
