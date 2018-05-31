
/** required package class namespace */
package mainpackage;

/** required imports */
import javax.swing.JOptionPane;
import year2018.cs30s.findprize.FindPrizes;
import year2018.cs30s.login.LogIn;
import year2018.cs30s.moregaming.frogger.FroggerGUI;
import year2018.cs30s.moregaming.snake.SnakeUI;
import year2018.cs30s.moregaming.spaceinvaders.SpaceInvadersGUI;
import year2018.cs30s.pacman.PacmanUI;

/**
 * MainClass.java - the main class for the project
 *
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public class MainClass 
{

    /**
     * Main method for the project
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final String[] OPTIONS = { "Login", "Pacman", "Find Prizes", "Frogger",
            "Space Invaders", "Snake" };
        int result = JOptionPane.showOptionDialog(null,"Choose...",
                     "Final Example 2018",JOptionPane.DEFAULT_OPTION,
                     JOptionPane.PLAIN_MESSAGE, null, OPTIONS, OPTIONS[0]);
        if      (result == 0) new LogIn();
        else if (result == 1) new PacmanUI();
        else if (result == 2) new FindPrizes();
        else if (result == 3) new FroggerGUI();
        else if (result == 4) new SpaceInvadersGUI();
        else if (result == 5) new SnakeUI();
    }

}
