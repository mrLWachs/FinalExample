
/** required package */
package year2018.cs30s.moregaming.spaceinvaders;

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

    private Background    background;
    private HeroShip      heroShip;
    private HeroBullet    heroBullet;
    private Base[]        bases;
    private EnemyShip[]   enemyShips;
    private EnemyBullet[] enemyBullets;
    private Wall[]        walls;
       
    
    /**
     * constructor for the class sets class data
     * @param backgroundImage the JLabel image associated with the background
     * @param heroShipImage the JLabel image associated with the hero ship
     * @param heroBulletImage the JLabel image associated with the hero bullet
     * @param baseImages the JLabel images associated with bases
     * @param enemyShipImages the JLabel images associated with enemy ships
     * @param enemyBulletImages the JLabel images associated with enemy bullets
     * @param wallImages the JLabel images associated with walls
     */
    public Engine(JLabel   backgroundPic, 
                      JLabel   heroShipPic, 
                      JLabel   heroBulletPic, 
                      JLabel[] basePics, 
                      JLabel[] enemyShipPics, 
                      JLabel[] enemyBulletPics, 
                      JLabel[] wallPics) {
        
        
        Image backgroundImage = new Image(backgroundPic);
        background = new Background(backgroundImage,Color.black);        
        
        Image[] wallImages = new Image[wallPics.length];
        walls = new Wall[wallImages.length];
        for (int i = 0; i < walls.length; i++) {
            wallImages[i] = new Image(wallPics[i]);
            walls[i] = new Wall(wallImages[i],Color.darkGray);
        }        
        
        Image heroShipImage = new Image(heroShipPic);
        heroShip = new HeroShip(heroShipImage,1,1,Color.yellow,walls);        
        
        Image[] baseImages = new Image[basePics.length];
        bases = new Base[baseImages.length];
        for (int i = 0; i < bases.length; i++) {
            baseImages[i] = new Image(basePics[i]);
            bases[i] = new Base(baseImages[i],Color.blue);
        }        
              
        Image[] enemyBulletImages = new Image[enemyBulletPics.length];
        enemyBullets = new EnemyBullet[enemyBulletImages.length];
        for (int i = 0; i < enemyBullets.length; i++) {
            enemyBulletImages[i] = new Image(enemyBulletPics[i]);
            enemyBullets[i] = new EnemyBullet(enemyBulletImages[i],
                    1,1,Color.green,heroShip,walls,bases);
        }           
        
        Image[] enemyShipImages = new Image[enemyShipPics.length];
        enemyShips = new EnemyShip[enemyShipImages.length];
        for (int i = 0; i < enemyShips.length; i++) {
            enemyShipImages[i] = new Image(enemyShipPics[i]);
            enemyShips[i] = new EnemyShip(enemyShipImages[i],1,1,
                    walls,3000,enemyBullets[i]);
        } 
        
        Image heroBulletImage = new Image(heroBulletPic);
        heroBullet = new HeroBullet(heroBulletImage,1,1,Color.white,
                heroShip,walls,enemyShips,bases);
        
        heroShip.connect(heroBullet);
    }

    /**
     * sends direction value on to the hero ship character
     * @param event the keyboard event 
     */
    public void keyPress(KeyEvent event) {
        heroShip.keyPress(event);
    }

}
