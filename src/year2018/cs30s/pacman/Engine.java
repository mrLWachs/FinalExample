
/** required package class namespace */
package year2018.cs30s.pacman;

import java.awt.event.KeyEvent;
import year2018.cs30s.gametools.Image;

/**
 * Engine.java - the logic connected to the user interface that runs game logic
 *
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public class Engine 
{
    
    private Pacman   pacman;
    private Ghost[]  ghosts;
    private Dot[]    dots;
    private Wall[]   walls;
    private PacmanUI screen;
    
    /**
     * Constructor sets class properties
     * 
     * @param pacmanImage the image associated with Pacman
     * @param ghostImages the image array associated with all ghosts
     * @param dotImages the image array associated with all dots
     * @param wallImages the image array associated with all walls
     * @param userInterface the frame user interface for the game
     */
    public Engine(Image pacmanImage, Image[] ghostImages, Image[] dotImages, 
                  Image[] wallImages, PacmanUI userInterface) {
        dots = new Dot[dotImages.length];               // create object array
        for (int i = 0; i < dots.length; i++) {         // traverse array
            dots[i] = new Dot(dotImages[i]);            // instantiate object
        }        
        walls = new Wall[wallImages.length];            // create object array
        for (int i = 0; i < walls.length; i++) {        // traverse array
            walls[i] = new Wall(wallImages[i]);         // instantiate object
        }        
        pacman = new Pacman(pacmanImage,dots,walls);    // instantiate object    
        ghosts = new Ghost[ghostImages.length];         // create object array
        for (int i = 0; i < ghosts.length; i++) {       // traverse array
            ghosts[i] = new Ghost(ghostImages[i],walls,pacman);
        }        
        screen = userInterface;                     // set parameter to property
    }

    /**
     * The user's keyboard event of pressing a key to respond to
     * 
     * @param event the keyboard event registered
     */
    public void keyPress(KeyEvent event) {
        pacman.keyPress(event);                 // pass event to Pacman object
    }

}
