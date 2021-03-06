
/** required package class namespace */
package year2018.cs30s.pacman;

/** required imports */
import java.awt.event.KeyEvent;
import mainpackage.Examples2018;
import mainpackage.MainClass;
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
    private PacmanUI ui;
    
    /**
     * Constructor sets class properties
     * 
     * @param pacmanImage the image associated with Pacman
     * @param ghostImages the image array associated with all ghosts
     * @param dotImages the image array associated with all dots
     * @param wallImages the image array associated with all walls
     * @param ui the frame user interface for the game
     */
    public Engine(Image pacmanImage, Image[] ghostImages, Image[] dotImages, 
                  Image[] wallImages, PacmanUI ui) {
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
            ghosts[i] = new Ghost(ghostImages[i],walls,pacman,this);
        }        
        this.ui = ui;                           // set parameter to property
    }

    /**
     * The user's keyboard event of pressing a key to respond to
     * 
     * @param event the keyboard event registered
     */
    public void keyPress(KeyEvent event) {
        pacman.keyPress(event);                 // pass event to Pacman object
    }
    
    /**
     * Shut down the Pacman game and all game characters and return to main 
     * application menu
     */
    public void shutDown() {
        pacman.shutDown();                      // shut down pacman
        for (int i = 0; i < ghosts.length; i++) {   // traverse ghosts
            ghosts[i].shutDown();               // shut down all ghosts
        }
        ui.dispose();                           // displose of user interface
        MainClass.gamesPlayed++;                // increment games played
        Examples2018.menu();                    // return to menu
    }

}
