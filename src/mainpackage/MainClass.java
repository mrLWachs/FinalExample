
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
import year2018.cs30s.tools.Dialogs;

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
        Dialogs dialog = new Dialogs("Final Examples 2018");
        final String[] OPTIONS = { "Login", "Pacman", "Find Prizes", "Frogger",
            "Space Invaders", "Snake" };
        String choice = dialog.buttons("Choose an example from 2018 in "
                + "Computer Science 30S or 32SIB to see...", OPTIONS);
        if      (choice.equals(OPTIONS[0])) new LogIn();
        else if (choice.equals(OPTIONS[1])) new PacmanUI();
        else if (choice.equals(OPTIONS[2])) new FindPrizes();
        else if (choice.equals(OPTIONS[3])) new FroggerGUI();
        else if (choice.equals(OPTIONS[4])) new SpaceInvadersGUI();
        else if (choice.equals(OPTIONS[5])) new SnakeUI();
    }

}
