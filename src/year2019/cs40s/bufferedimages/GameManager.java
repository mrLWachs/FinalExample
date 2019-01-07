/*
 *  Mr. Wachs' classes - Java Computer Science learning file GameManager.java
 *  for project FinalExamples on 12-Oct-2018 at 1:02:06 PM by lawrence.wachs
 */


/** required package class namespace */
package year2019.cs40s.bufferedimages;

import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;



/**
 * GameManager.java - 
 *
 * @author Mr. Wachs 
 * @since 12-Oct-2018 
 */
public class GameManager 
{

    private Hero   hero;
    private Wall[] walls;
    
    
    public GameManager(JLabel heroLabel, JLabel[] wallLabels, JFrame frame) {
        walls = new Wall[wallLabels.length];
        for (int i = 0; i < wallLabels.length; i++) {
            walls[i] = new Wall(wallLabels[i]);
        }
        hero = new Hero(heroLabel,frame);
    }

    public void keyPress(KeyEvent evt) {
        hero.keyPress(evt);
    }

}
