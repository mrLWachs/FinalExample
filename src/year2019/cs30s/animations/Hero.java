
/** required package class namespace */
package year2019.cs30s.animations;

import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import year2019.cs30s.animations.gametools.Animation;
import year2019.cs30s.animations.gametools.GameCharacter;
import year2019.cs40s.genericgame.gametools.Directions;


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
    private Prize     prize;
    private Engine    engine;
    
    
    /**
     * Default constructor for the class, sets class properties
     */
    public Hero(JLabel label, Wall[] walls, Objective objective, Prize prize,
                Engine engine) {
        super(label, 
                Globals.HERO_AMOUNT, 
                Globals.HERO_DIRECTION, 
                Globals.HERO_DELAY, 
                Globals.HERO_DIRECTIONS);
        this.walls     = walls;
        this.objective = objective;
        this.prize     = prize;
        this.engine    = engine;
        
        int animateDelay = 300;
                
        Animation animateIdol  = new Animation(label, Globals.PACMAN_IDOLE_IMAGES, animateDelay+700, true);
        Animation animateLeft  = new Animation(label, Globals.PACMAN_LEFT_IMAGES, animateDelay, true);
        Animation animateRight = new Animation(label, Globals.PACMAN_RIGHT_IMAGES, animateDelay, true);        
        Animation animateUp    = new Animation(label, Globals.PACMAN_UP_IMAGES, animateDelay, true);
        Animation animateDown  = new Animation(label, Globals.PACMAN_DOWN_IMAGES, animateDelay, true);
        
        Animation[] animations = {animateIdol,animateLeft,animateRight,animateUp,animateDown};
        
        gameImage.setAnimations(animations);
        gameImage.animate(0);
    }
    
    @Override
    public void keypress(KeyEvent event) {        
        super.keypress(event);
        animateImages();        
    }

    @Override
    public void action() {
        mover.move();                                   // move coordinates
        for (int i = 0; i < walls.length; i++) {        // traverse walls
            if (detector.isOverLapping(walls[i])) { // colliding with wall
                reactor.stickTo(walls[i]);          // stick to wall
                i = walls.length;                       // exit loop early
                mover.stop();
                animateImages();
            }
        }
        if (detector.isOverLapping(objective)) {    // colliding with objective
            System.exit(0);                         // end application
        }
        if (detector.isOverLapping(prize)) {
            engine.media.playWAV(Globals.PACMAN_SOUND);
            prize.despawn();
        }
        redraw();                                   // re draw hero
    }

    private void animateImages() {
        if      (coordinates.direction == Directions.LEFT)  gameImage.animate(1);  
        else if (coordinates.direction == Directions.RIGHT) gameImage.animate(2);
        else if (coordinates.direction == Directions.UP)    gameImage.animate(3);
        else if (coordinates.direction == Directions.DOWN)  gameImage.animate(4);
        else if (coordinates.direction == Directions.STOP)  gameImage.animate(0);        
    }

}
