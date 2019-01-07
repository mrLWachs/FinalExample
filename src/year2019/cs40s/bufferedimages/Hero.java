
/** required package class namespace */
package year2019.cs40s.bufferedimages;

import javax.swing.JFrame;
import javax.swing.JLabel;
import year2019.cs40s.bufferedimages.gametools.GameCharacter;
import year2019.cs40s.bufferedimages.gametools.GameImage;



/**
 * Hero.java - 
 *
 * @author Mr. Wachs 
 * @since 12-Oct-2018 
 */
public class Hero extends GameCharacter
{

    public Hero(JLabel heroLabel, JFrame frame) {
        super(null, 0, 0, 0, 0);
        String filename = "/media/Frogger.png";
        GameImage image = new GameImage(filename, heroLabel, frame);
        super.image = image;    
        heroLabel.setVisible(false);
    }

    @Override
    public void action() {
        move();
    }

}
