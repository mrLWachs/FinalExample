
/** required package class namespace */
package year2019.cs30s.animations;

import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import year2019.cs30s.animations.gametools.GameCharacter;


/**
 * Hero.java - 
 *
 * @author Mr. Wachs 
 * @since 15-May-2019 
 */
public class Hero extends GameCharacter
{

    /**
     * Default constructor for the class, sets class properties
     */
    public Hero(JLabel label, Wall[] walls, Objective objective) {
        super(label, 0, 0, 0, 0);
    }

    public void keyPress(KeyEvent event) {
        
    }

    @Override
    public void action() {
        
    }

}
