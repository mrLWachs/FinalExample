
/** required package class namespace */
package year2018.cs30s.moregaming.survivor;


import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import mainpackage.Examples2018;
import mainpackage.MainClass;
import year2018.cs30s.gametools.Image;

/**
 * Engine.java - description here...
 *
 * @author Mr. Wachs (login: lawrence.wachs)
 * @since Jun 7, 2018 
 * @instructor Mr. Wachs
 */
public class Engine 
{

    private Hero       hero;
    private Goal       goal;
    private SpawnPoint spawnPoint;
    private Wall[]     walls;
    private SurvivorUI survivorUI;
    
    
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

    public void shutDown() {
        hero.shutDown();
        spawnPoint.shutDown();        
        survivorUI.dispose();
        MainClass.gamesPlayed++;
        Examples2018.menu();
    }

    public void keypress(KeyEvent event) {
        hero.keyPress(event);
    }

}
