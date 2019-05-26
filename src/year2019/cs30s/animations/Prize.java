
/** required package class namespace */
package year2019.cs30s.animations;

import javax.swing.JLabel;
import year2019.cs30s.animations.gametools.GameObject;


/**
 * Prize.java - 
 *
 * @author Mr. Wachs 
 * @since 15-May-2019 
 */
public class Prize extends GameObject 
{

    public Prize(JLabel label) {
        super(label);
        super.gameImage.debug(Globals.PRIZE_TEXT,Globals.PRIZE_COLOR);
    }
      
}
