
/** required package class namespace */
package year2018.cs30s.moregaming.frogger;

/** required imports */
import java.awt.event.KeyEvent;
import mainpackage.Example;
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

    private Background background;
    private Frog       frog;  
    private Home       home;  
    private Water      water;
    private Car[]      cars;
    private Log[]      logs;
    private Wall[]     walls;
    private FroggerGUI ui;
    
    
    /**
     * Constructor for the class sets class data
     * 
     * @param backgroundImage the JLabel image associated with the background
     * @param frogImage the JLabel image associated with the frog
     * @param waterImage the JLabel image associated with the water
     * @param homeImage the JLabel image associated with the home
     * @param carImages the JLabel images associated with the cars
     * @param logImages the JLabel images associated with logs
     * @param wallImages the JLabel images associated with walls
     */
    public Engine(Image backgroundImage, Image frogImage, Image waterImage, 
                  Image homeImage, Image[] carImages, Image[] logImages, 
                  Image[] wallImages, FroggerGUI ui) {  
        this.ui    = ui;
        background = new Background(backgroundImage);
        home       = new Home(homeImage);
        water      = new Water(waterImage);   
        walls      = new Wall[wallImages.length];  
        logs       = new Log[logImages.length]; 
        cars       = new Car[carImages.length]; 
        for (int i = 0; i < walls.length; i++) {
            walls[i] = new Wall(wallImages[i]);
        }       
        for (int i = 0; i < logs.length; i++) {
            logs[i] = new Log(logImages[i],walls);
        }
        frog = new Frog(frogImage,walls,home,water,logs,this); 
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(carImages[i],frog,walls,this);
        }        
    }

    /**
     * User key board action sends direction value on to the frog character
     * 
     * @param event the keyboard event 
     */
    public void keyPress(KeyEvent event) {
        frog.keyPress(event);
    }

    /**
     * User key board action of releasing a key
     */
    public void keyRelease() {
        frog.keyRelease();
    }
    
    public void shutDown() {
        frog.shutDown();
        for (int i = 0; i < cars.length; i++) {
            cars[i].shutDown();
        }
        ui.dispose();
        Example.gamesPlayed++;
        Example.menu();
    }
    
}
