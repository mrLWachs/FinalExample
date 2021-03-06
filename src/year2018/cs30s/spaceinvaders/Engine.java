
/** required package class namespace */
package year2018.cs30s.spaceinvaders;

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

    private Background       background;
    private HeroShip         heroShip;
    private HeroBullet       heroBullet;
    private Base[]           bases;
    private EnemyShip[]      enemyShips;
    private EnemyBullet[]    enemyBullets;
    private Wall[]           walls;
    private SpaceInvadersGUI ui;
    
    /**
     * Constructor for the class sets class data
     * 
     * @param backgroundImage the JLabel image associated with the background
     * @param heroShipImage the JLabel image associated with the hero ship
     * @param heroBulletImage the JLabel image associated with the hero bullet
     * @param baseImages the JLabel images associated with bases
     * @param enemyShipImages the JLabel images associated with enemy ships
     * @param enemyBulletImages the JLabel images associated with enemy bullets
     * @param wallImages the JLabel images associated with walls
     */
    public Engine(Image backgroundImage, Image heroShipImage, 
                  Image heroBulletImage, Image[] baseImages, 
                  Image[] enemyShipImages, Image[] enemyBulletImages, 
                  Image[] wallImages, SpaceInvadersGUI ui) {
        this.ui      = ui;
        background   = new Background(backgroundImage);        
        walls        = new Wall[wallImages.length];
        bases        = new Base[baseImages.length];
        enemyBullets = new EnemyBullet[enemyBulletImages.length];
        enemyShips   = new EnemyShip[enemyShipImages.length];        
        for (int i = 0; i < walls.length; i++) {
            walls[i] = new Wall(wallImages[i]);
        }    
        for (int i = 0; i < bases.length; i++) {
            bases[i] = new Base(baseImages[i]);
        }    
        heroShip = new HeroShip(heroShipImage,walls);
        for (int i = 0; i < enemyBullets.length; i++) {
            enemyBullets[i] = new EnemyBullet(enemyBulletImages[i],
                    heroShip,walls,bases,this);
        }          
        for (int i = 0; i < enemyShips.length; i++) {
            enemyShips[i] = new EnemyShip(enemyShipImages[i],
                                          walls,enemyBullets[i]);
        }       
        heroBullet = new HeroBullet(heroBulletImage,heroShip,walls,
                                    enemyShips,bases);
        heroShip.connect(heroBullet);
    }

    /**
     * Sends direction value on to the hero ship character
     * 
     * @param event the keyboard event 
     */
    public void keyPress(KeyEvent event) {
        heroShip.keyPress(event);
    }

    /**
     * Shut down the Space Invaders game and all game characters and return
     * to main application menu
     */
    public void shutDown() {
        heroShip.shutDown();
        heroBullet.shutDown();
        for (int i = 0; i < enemyShips.length; i++) {
            enemyShips[i].shutDown();
        }
        for (int i = 0; i < enemyBullets.length; i++) {
            enemyBullets[i].shutDown();
        }
        ui.dispose();
        MainClass.gamesPlayed++;
        Examples2018.menu();
    }
    
}
