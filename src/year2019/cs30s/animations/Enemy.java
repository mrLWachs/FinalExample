
/** required package class namespace */
package year2019.cs30s.animations;

import javax.swing.JLabel;
import year2019.cs30s.animations.gametools.GameCharacter;


/**
 * Enemy.java - 
 *
 * @author Mr. Wachs 
 * @since 15-May-2019 
 */
public class Enemy extends GameCharacter
{
    
    private Wall[] walls;
    private Hero   hero;
    
    public Enemy(JLabel label, Wall[] walls, Hero hero) {
        super(label, 
                Globals.ENEMY_AMOUNT, 
                Globals.ENEMY_DIRECTION, 
                Globals.ENEMY_DELAY, 
                Globals.ENEMY_DIRECTIONS);
        this.walls = walls;
        this.hero  = hero;
        mover.randomDirection();
        super.gameImage.debug(Globals.ENEMY_TEXT,Globals.ENEMY_COLOR);
    }

    @Override
    public void action() {
        mover.move();                               // move coordinates
        for (int i = 0; i < walls.length; i++) {    // traverse walls
            if (detector.isOverLapping(walls[i])) { // colliding with wall
                reactor.bounceOff(walls[i]);    // bounce off wall
                mover.randomDirection();            // go random direction
                i = walls.length;                   // exit loop early 
            }
        }
        if (detector.isOverLapping(hero)) {         // colliding with hero
            System.exit(0);                         // end application
        }
        redraw();                                   // re draw hero
    }
    
}
