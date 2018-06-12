
/** required package class namespace */
package year2018.cs30s.moregaming.survivor;

/** required imports */
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import mainpackage.Examples2018;
import mainpackage.MainClass;
import year2018.cs30s.gametools.Image;
import year2018.cs30s.tools.ImageTools;

/**
 * Engine.java - the logic connected to the user interface that runs game logic
 *
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public class Engine 
{

    private Hero       hero;
    private Goal       goal;
    private Wall[]     walls;
    private SurvivorUI survivorUI;
    private Spawner    spawner;
    private ImageTools imageTool;
    
    /**
     * Constructor for the class sets class data to the parameters
     * 
     * @param heroLabel the label for the hero
     * @param goalLabel the label for the goal
     * @param wallLabels the labels for the walls
     * @param survivorUI the user interface for the game
     */
    public Engine(JLabel heroLabel, JLabel goalLabel, JLabel[] wallLabels, 
                  SurvivorUI survivorUI) {        
        this.survivorUI = survivorUI;   
        imageTool       = new ImageTools();
        imageTool.changeImage(heroLabel, Constants.HERO_IMAGE, true);
        imageTool.changeImage(goalLabel, Constants.GOAL_IMAGE, true);
        Image heroImage = new Image(heroLabel);
        Image goalImage = new Image(goalLabel);
        walls           = new Wall[wallLabels.length];
        for (int i = 0; i < walls.length; i++) {
            walls[i] = new Wall(new Image(wallLabels[i]));
        }
        goal    = new Goal(goalImage);
        hero    = new Hero(heroImage,walls,goal,survivorUI,this);        
        spawner = new Spawner(hero,goal,walls,survivorUI,this);        
        hero.connectTo(spawner);        
    }

    /**
     * Shut down the Space Invaders game and all game characters and return
     * to main application menu
     */
    public void shutDown() {
        hero.shutDown();
        spawner.shutDown();        
        survivorUI.dispose();
        MainClass.gamesPlayed++;
        Examples2018.menu();
    }

    /**
     * Sends direction value on to the hero character
     * 
     * @param event the keyboard event 
     */
    public void keypress(KeyEvent event) {
        hero.keyPress(event);
    }

    /**
     * Create a new image for a created object
     * 
     * @param x the x coordinate to create the image in the container
     * @param y the y coordinate to create the image in the container
     * @param w the width coordinate to create the image in the container
     * @param h the height coordinate to create the image in the container
     * @return a image for a created object 
     */
    public Image createImage(int x, int y, int w, int h, String imageFile) {
        JLabel label = new JLabel();
        survivorUI.getContentPane().add(label);  
        label.setSize(w, h);        
        imageTool.changeImage(label, imageFile, true);
        label.setBounds(x, y, w, h);
        Image image = new Image(label);
        return image;
    }
    
}
