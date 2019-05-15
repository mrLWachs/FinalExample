
/** required package class namespace */
package year2019.cs30s.animations;

import java.awt.event.KeyEvent;
import javax.swing.JLabel;



/**
 * Engine.java - 
 *
 * @author Mr. Wachs 
 * @since 15-May-2019 
 */
public class Engine 
{

    private JLabel        heroLabel;
    private JLabel        objectiveLabel;
    private JLabel[]      wallLabels;
    private JLabel[]      enemyLabels;
    private JLabel        backgroundLabel;
    private UserInterface userInterface;
    
    private Hero       hero;
    private Objective  objective;
    private Background background;
    private Wall[]     walls;
    private Enemy[]    enemies;
    
    
    public Engine(
            JLabel heroLabel, 
            JLabel objectiveLabel, 
            JLabel[] wallLabels, 
            JLabel[] enemyLabels, 
            JLabel backgroundLabel, 
            UserInterface userInterface) {
        this.heroLabel       = heroLabel;
        this.objectiveLabel  = objectiveLabel;
        this.wallLabels      = wallLabels;
        this.enemyLabels     = enemyLabels;
        this.backgroundLabel = backgroundLabel;
        this.userInterface   = userInterface;
        initialize();
    }

    public void keyPress(KeyEvent event) {
        hero.keyPress(event);
    }

    private void initialize() {
        Objective objective = new Objective(objectiveLabel);
        Background background = new Background(backgroundLabel);
        Wall[] walls = new Wall[wallLabels.length];
        for (int i = 0; i < walls.length; i++) {
            walls[i] = new Wall(wallLabels[i]);
        }
        Hero hero = new Hero(heroLabel,walls,objective);
        Enemy[] enemies = new Enemy[enemyLabels.length];
        for (int i = 0; i < enemies.length; i++) {
            enemies[i] = new Enemy(enemyLabels[i],walls,hero);
        }      
        userInterface.setSize(Globals.UI_WIDTH, Globals.UI_HEIGHT);
        userInterface.setTitle(Globals.UI_TITLE);
        userInterface.setResizable(false);
        userInterface.setLocationRelativeTo(null);
        userInterface.setVisible(true);
    }

}
