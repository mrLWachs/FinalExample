
/** required package class namespace */
package year2019.cs30s.animations;

import javax.swing.JLabel;
import year2019.cs30s.animations.gametools.GameCharacter;


/**
 * Enemy.java - 
 *
 * @author Mr. Wachs 
 * @since 15-May-2019 
 */
public class Enemy extends GameCharacter
{
    
    public Enemy(JLabel label, Wall[] walls, Hero hero) {
        super(label, 0, 0, 0, 0);
    }

    @Override
    public void action() {
        
    }
    
}
