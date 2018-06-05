
/** required package class namespace */
package year2018.cs30s.moregaming.frogger;

/** required imports */
import year2018.cs30s.gametools.GameCharacter;
import year2018.cs30s.gametools.Directions;
import year2018.cs30s.gametools.Image;

/**
 * Car.java - represents a car in the Frogger game
 *
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public class Car extends GameCharacter
{
    
    private Frog   frog;
    private Wall[] walls;     
    private Engine engine;

    /**
     * Constructor for the class sets class data
     * 
     * @param image the image associated with the game object
     * @param frog the frog object associated with this object
     * @param walls the wall objects associated with this object
     * @param engine the logic engine for the Frogger game
     */
    public Car(Image image, Frog frog, Wall[] walls, Engine engine) {
        super(image, Directions.STOP, Constants.CAR_MOVE_AMOUNT,
              Constants.CAR_TIMER_DELAY, Constants.CAR_MOVE_DIRECTIONS);
        this.engine = engine;
        this.frog   = frog;              // associate parameter with property
        this.walls  = walls;             // associate parameter with property
        randomDirection();              // start a random direction
        setDebug(Constants.CAR_TEXT, Constants.CAR_COLOR);  // debug mode
    }

    /** 
     * Movement actions that this car performs 
     */
    @Override
    public void action() {
        move();
        checkWalls();
        checkFrog();
        redraw();
    }


    /** 
     * Checks for collisions with walls and reacts 
     */
    private void checkWalls() {
        for (int i = 0; i < walls.length; i++) {
            if (isColliding(walls[i])) {
                bounceOff(walls[i]);
            }
        }
    }

    /** 
     * Checks for collision with frog and reacts 
     */
    private void checkFrog() {
        if (isColliding(frog)) {
            engine.shutDown();
        }
    }

}
