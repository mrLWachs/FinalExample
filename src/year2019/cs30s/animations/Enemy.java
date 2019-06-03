
/** required package class namespace */
package year2019.cs30s.animations;

/** required imports */
import javax.swing.JLabel;
import year2019.cs30s.animations.gametools.GameCharacter;


/**
 * Enemy.java - representation of a enemy in a game 
 *
 * @author Mr. Wachs 
 * @since 15-May-2019 
 */
public class Enemy extends GameCharacter
{
    
    private Wall[] walls;
    private Hero   hero;
    private Engine engine;
    
    
    /**
     * Constructor for the class, sets class property data
     * 
     * @param label the label associated with the image for the game character
     * @param walls the array of wall objects
     * @param hero the hero object
     * @param engine the game engine object 
     */
    public Enemy(JLabel label, Wall[] walls, Hero hero, Engine engine) {
        super(label, 
                Globals.ENEMY_AMOUNT, 
                Globals.ENEMY_DIRECTION, 
                Globals.ENEMY_DELAY, 
                Globals.ENEMY_DIRECTIONS);
        this.walls  = walls;
        this.hero   = hero;
        this.engine = engine;
        mover.randomDirection();
        super.gameImage.debug(Globals.ENEMY_TEXT,Globals.ENEMY_COLOR);
    }

    /** The action this enemy does in it's timer */
    @Override
    public void action() {
        mover.move();                               // move coordinates
        for (int i = 0; i < walls.length; i++) {    // traverse walls
            if (detector.isOverLapping(walls[i])) { // colliding with wall
                reactor.bounceOff(walls[i]);        // bounce off wall
                mover.randomDirection();            // go random direction
                i = walls.length;                   // exit loop early 
            }
        }
        if (detector.isOverLapping(hero)) {         // colliding with hero
            loseGame();
        }
        redraw();                                   // re draw hero
    }

    /** When you lose the game */
    private void loseGame() {
        hero.despawn();                             // remove hero
        engine.dialog.show("You lose\n\nPoints = " + engine.points);
        System.exit(0);                             // terminate application
    }
    
}
