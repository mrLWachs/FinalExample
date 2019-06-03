
/** required package class namespace */
package year2019.cs30s.animations;

/** required imports */
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import year2019.cs30s.animations.gametools.Animation;
import year2019.cs30s.animations.gametools.GameCharacter;
import year2019.cs40s.genericgame.gametools.Directions;


/**
 * Hero.java - representation of a hero in a game 
 *
 * @author Mr. Wachs 
 * @since 15-May-2019 
 */
public class Hero extends GameCharacter
{

    private Wall[]    walls;
    private Objective objective;
    private Prize[]   prizes;
    private Engine    engine;
    
    
    /**
     * Constructor for the class, sets class property data
     * 
     * @param label the label associated with the image for the game character
     * @param walls the array of wall objects
     * @param objective the objective object
     * @param prizes the array of prize objects
     * @param engine the game engine object  
     */
    public Hero(JLabel label, Wall[] walls, Objective objective, Prize[] prizes,
                Engine engine) {
        super(label, 
                Globals.HERO_AMOUNT, 
                Globals.HERO_DIRECTION, 
                Globals.HERO_DELAY, 
                Globals.HERO_DIRECTIONS);
        this.walls     = walls;
        this.objective = objective;
        this.prizes    = prizes;
        this.engine    = engine;
        createAnimations(label);        
    }
    
    /**
     * The user's keyboard event of pressing a key to respond to
     * 
     * @param event the keyboard event registered
     */
    @Override
    public void keypress(KeyEvent event) {        
        super.keypress(event);                  // send event to super class
        animateImages();                        // change animation to respond
    }

    /** The action this enemy does in it's timer */
    @Override
    public void action() {
        mover.move();                                   // move coordinates
        for (int i = 0; i < walls.length; i++) {        // traverse walls
            if (detector.isOverLapping(walls[i])) {     // colliding with wall
                reactor.stickTo(walls[i]);              // stick to wall
                i = walls.length;                       // exit loop early
                mover.stop();                           // stop movement
                animateImages();                        // change animation
            }
        }        
        for (int i = 0; i < prizes.length; i++) {       // traverse 
            if (detector.isOverLapping(prizes[i])) {    // hit a prize
                engine.media.playWAV(Globals.PACMAN_SOUND); // play sound
                engine.points++;                        // add a point
                prizes[i].despawn();                    // remove prize
            }
        }
        if (detector.isOverLapping(objective)) {    // colliding with objective
            winGame();                              // win the game
        }
        redraw();                                   // re draw hero
    }

    /** Plays the appropriate animation based on the character's direction */
    private void animateImages() {
        if      (coordinates.direction == Directions.LEFT)  gameImage.animate(1);  
        else if (coordinates.direction == Directions.RIGHT) gameImage.animate(2);
        else if (coordinates.direction == Directions.UP)    gameImage.animate(3);
        else if (coordinates.direction == Directions.DOWN)  gameImage.animate(4);
        else if (coordinates.direction == Directions.STOP)  gameImage.animate(0);        
    }

    /** Winning the game */
    private void winGame() {
        despawn();                                      // remove character
        String[] data = new String[1];                  // create data array
        data[0] = "Total points " + engine.points;      // fill array
        engine.file.write(data);                        // write to file
        engine.dialog.show("You win\n\n" + data[0]);    // display data
        System.exit(0);                                 // end application
    }

    /**
     * Set up all the animations for this character
     * 
     * @param label the label to associate the animation with
     */
    private void createAnimations(JLabel label) {
        int delay = 300;                         // set delay
        Animation animateIdol  = new Animation(label, 
                Globals.PACMAN_IDOLE_IMAGES, delay+700, true);
        Animation animateLeft  = new Animation(label, 
                Globals.PACMAN_LEFT_IMAGES, delay, true);
        Animation animateRight = new Animation(label, 
                Globals.PACMAN_RIGHT_IMAGES, delay, true);        
        Animation animateUp    = new Animation(label, 
                Globals.PACMAN_UP_IMAGES, delay, true);
        Animation animateDown  = new Animation(label, 
                Globals.PACMAN_DOWN_IMAGES, delay, true);        
        Animation[] animations = {animateIdol,animateLeft,
            animateRight,animateUp,animateDown};        
        gameImage.setAnimations(animations);    // set to the game image
        gameImage.animate(0);                   // start first animation
    }

}
