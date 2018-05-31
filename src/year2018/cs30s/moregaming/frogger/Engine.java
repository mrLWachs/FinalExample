
/** required package */
package year2018.cs30s.moregaming.frogger;

/** required imports */
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import year2018.cs30s.gametools.Image;

/**
 * Engine.java - the logic connected to the user interface that runs game logic
 * @author Mr. Wachs' Computer Science Student
 * @since 18-Jan-2016
 * @version 1.0
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
    
    /**
     * constructor for the class sets class data
     * @param backgroundImage the JLabel image associated with the background
     * @param frogImage the JLabel image associated with the frog
     * @param waterImage the JLabel image associated with the water
     * @param homeImage the JLabel image associated with the home
     * @param carImages the JLabel images associated with the cars
     * @param logImages the JLabel images associated with logs
     * @param wallImages the JLabel images associated with walls
     */
    public Engine(JLabel   backgroundPic, 
                      JLabel   frogPic, 
                      JLabel   waterPic, 
                      JLabel   homePic, 
                      JLabel[] carPics, 
                      JLabel[] logPics, 
                      JLabel[] wallPics) {
                
        Image backgroundImage = new Image(backgroundPic);
        Image homeImage = new Image(homePic);
        Image waterImage = new Image(waterPic);
        background = new Background(backgroundImage);
        home       = new Home(homeImage);
        water      = new Water(waterImage);   
                
        walls = new Wall[wallPics.length];
        Image[] wallImages = new Image[wallPics.length];        
        for (int i = 0; i < walls.length; i++) {
            wallImages[i] = new Image(wallPics[i]);
            walls[i] = new Wall(wallImages[i]);
        }       
                
        logs = new Log[logPics.length];
        Image[] logImages = new Image[logPics.length];
        for (int i = 0; i < logs.length; i++) {
            logImages[i] = new Image(logPics[i]);
            logs[i] = new Log(logImages[i],walls);
        }
        
        Image frogImage = new Image(frogPic);
        frog = new Frog(frogImage,walls,home,water,logs);  
        
        cars = new Car[carPics.length];
        Image[] carImages = new Image[carPics.length];
        for (int i = 0; i < cars.length; i++) {
            carImages[i] = new Image(carPics[i]);
            cars[i] = new Car(carImages[i],frog,walls);
        }        
    }

    /**
     * sends direction value on to the frog character
     * @param event the keyboard event 
     */
    public void keyPress(KeyEvent event) {
        frog.keyPress(event);
    }

}
