
/** required package class namespace */
package year2018.cs30s.moregaming.survivor;

/** required imports */
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
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

    private Hero       hero;
    private Goal       goal;
    private SpawnPoint spawnPoint;
    private Wall[]     walls;
    private SurvivorUI survivorUI;
    
    /**
     * Constructor for the class sets class data to the parameters
     * 
     * @param heroLabel the label for the hero
     * @param goalLabel the label for the goal
     * @param spawnPointLabel the label for the spawn point
     * @param wallLabels the labels for the walls
     * @param survivorUI the user interface for the game
     */
    public Engine(JLabel heroLabel, JLabel goalLabel, JLabel spawnPointLabel, 
                  JLabel[] wallLabels, SurvivorUI survivorUI) {
        this.survivorUI = survivorUI;   
        Image heroImage       = new Image(heroLabel);
        Image goalImage       = new Image(goalLabel);
        Image spawnPointImage = new Image(spawnPointLabel);
        walls                 = new Wall[wallLabels.length];
        for (int i = 0; i < walls.length; i++) {
            walls[i] = new Wall(new Image(wallLabels[i]));
        }
        goal       = new Goal(goalImage);
        hero       = new Hero(heroImage,walls,goal,survivorUI,this);        
        spawnPoint = new SpawnPoint(spawnPointImage,hero,walls,survivorUI,this);
        hero.connectTo(spawnPoint);
    }

    /**
     * Shut down the Space Invaders game and all game characters and return
     * to main application menu
     */
    public void shutDown() {
        hero.shutDown();
        spawnPoint.shutDown();        
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

}
