
/** required package class namespace */
package year2018.cs32s.moregaming;

import javax.swing.JOptionPane;
import year2018.cs32s.moregaming.frogger.FroggerGUI;
import year2018.cs32s.moregaming.snake.Snake;
import year2018.cs32s.moregaming.spaceinvaders.SpaceInvadersGUI;

/**
 * MoreGaming.java - description here...
 *
 * @author Mr. Wachs (login: lawrence.wachs)
 * @since May 30, 2018 
 * @instructor Mr. Wachs
 */
public class MoreGaming 
{

    public MoreGaming() {
        String[] options = {"Frogger","Space Invaders", "Snake"};
        int result = JOptionPane.showOptionDialog(null,"Choose...",
                     "Gaming Example 2018",JOptionPane.DEFAULT_OPTION,
                     JOptionPane.PLAIN_MESSAGE,null, options, options[0]);
        if (result == 0) {
            FroggerGUI game = new FroggerGUI();
        }
        else if (result == 1) {
            SpaceInvadersGUI game = new SpaceInvadersGUI();
        }
        else if (result == 2) {
            Snake game = new Snake();
        }        
    }
    
}
