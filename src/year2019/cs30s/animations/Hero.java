
/** required package class namespace */
package year2019.cs30s.animations;

import javax.swing.JLabel;
import year2019.cs30s.animations.gametools.GameCharacter;


/**
 * Hero.java - 
 *
 * @author Mr. Wachs 
 * @since 15-May-2019 
 */
public class Hero extends GameCharacter
{

    private Wall[]    walls;
    private Objective objective;
    
    
    /**
     * Default constructor for the class, sets class properties
     */
    public Hero(JLabel label, Wall[] walls, Objective objective) {
        super(label, 
                Globals.HERO_AMOUNT, 
                Globals.HERO_DIRECTION, 
                Globals.HERO_DELAY, 
                Globals.HERO_DIRECTIONS);
        this.walls     = walls;
        this.objective = objective;
//        super.gameImage.debug(Globals.HERO_TEXT,Globals.HERO_COLOR);
    }

    @Override
    public void action() {
        mover.move();                                   // move coordinates
        for (int i = 0; i < walls.length; i++) {        // traverse walls
            if (detector.isOverLapping(walls[i])) { // colliding with wall
                reactor.stickTo(walls[i]);          // stick to wall
                i = walls.length;                       // exit loop early
            }
        }
        if (detector.isOverLapping(objective)) {    // colliding with objective
            System.exit(0);                         // end application
        }
        redraw();                                   // re draw hero
    }

}
