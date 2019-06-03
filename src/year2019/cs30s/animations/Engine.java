
/** required package class namespace */
package year2019.cs30s.animations;

/** required imports */
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import year2019.cs30s.animations.gametools.Dialogs;
import year2019.cs30s.animations.gametools.FileHandler;
import year2019.cs30s.animations.gametools.MediaPlayer;


/**
 * Engine.java - the logic connected to the user interface that runs game logic
 *
 * @author Mr. Wachs 
 * @since 15-May-2019 
 */
public class Engine 
{

    private JLabel        heroLabel;
    private JLabel        objectiveLabel;
    private JLabel[]      prizeLabels;
    private JLabel[]      wallLabels;
    private JLabel[]      enemyLabels;
    private JLabel        backgroundLabel;
    private UserInterface userInterface;    
    private Hero          hero;
    private Objective     objective;
    private Background    background;
    private Prize[]       prizes;
    private Wall[]        walls;
    private Enemy[]       enemies;
    public MediaPlayer    media;
    public FileHandler    file;
    public Dialogs        dialog;
    public int            points;
   
    
    /**
     * Constructor for the class, sets class property data
     * 
     * @param heroLabel the label image for the corresponding object
     * @param objectiveLabel the label image for the corresponding object
     * @param prizeLabels the label image array for the corresponding object
     * @param wallLabels the label image array for the corresponding object
     * @param enemyLabels the label image array for the corresponding object
     * @param backgroundLabel the label image for the corresponding object
     * @param userInterface the user interface container for the game
     */
    public Engine(
            JLabel heroLabel, 
            JLabel objectiveLabel, 
            JLabel[] prizeLabels,
            JLabel[] wallLabels, 
            JLabel[] enemyLabels, 
            JLabel backgroundLabel, 
            UserInterface userInterface) {
        this.heroLabel       = heroLabel;       // associate parameter with 
        this.objectiveLabel  = objectiveLabel;  // class properties
        this.prizeLabels     = prizeLabels;
        this.wallLabels      = wallLabels;
        this.enemyLabels     = enemyLabels;
        this.backgroundLabel = backgroundLabel;
        this.userInterface   = userInterface;
        objective  = new Objective(objectiveLabel);     // create objective 
        background = new Background(backgroundLabel);   // create background
        walls      = new Wall[wallLabels.length];       // create wall array
        prizes     = new Prize[prizeLabels.length];     // create prize array
        for (int i = 0; i < prizes.length; i++) {       // traverse
            prizes[i] = new Prize(prizeLabels[i]);      // create all prizes
        }        
        for (int i = 0; i < walls.length; i++) {        // traverse
            walls[i] = new Wall(wallLabels[i]);         // create all walls
        }
        hero    = new Hero(heroLabel,walls,objective,prizes,this); // hero
        enemies = new Enemy[enemyLabels.length];        // create enemy array
        for (int i = 0; i < enemies.length; i++) {      // traverse
            enemies[i] = new Enemy(enemyLabels[i],walls,hero,this); // enemies
        }      
        media  = new MediaPlayer();                     // create media player
        file   = new FileHandler(Globals.DATA_FILE);    // create file handler
        dialog = new Dialogs(Globals.UI_TITLE, userInterface);  // dialogs
        String data[] = file.read();                    // read data from file
        if (data != null) dialog.show("Last game\n\n" + data[0]); // show data        
        userInterface.setSize(Globals.UI_WIDTH, Globals.UI_HEIGHT);
        userInterface.setTitle(Globals.UI_TITLE);       // set UI properties
        userInterface.setResizable(false);
        userInterface.setLocationRelativeTo(null);
        userInterface.setVisible(true);
    }

    /**
     * The user's keyboard event of pressing a key to respond to
     * 
     * @param event the keyboard event registered
     */
    public void keyPress(KeyEvent event) {
        hero.keypress(event);
    }

}
