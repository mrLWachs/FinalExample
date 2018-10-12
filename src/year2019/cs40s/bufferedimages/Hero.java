
/** required package class namespace */
package year2019.cs40s.bufferedimages;

import javax.swing.JLabel;
import year2019.cs40s.bufferedimages.gametools.GameCharacter;



/**
 * Hero.java - 
 *
 * @author Mr. Wachs 
 * @since 12-Oct-2018 
 */
public class Hero extends GameCharacter
{

    public Hero(JLabel heroLabel) {
        super(null, 0, 0, 0, 0);
    }

    @Override
    public void action() {
        move();
    }

}
