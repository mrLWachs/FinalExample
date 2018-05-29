
/** required package class namespace */
package year2018.cs32s.finalexample;

/** required imports */
import javax.swing.JOptionPane;
import year2018.cs32s.pacman.PacmanUI;
import year2018.cs32s.snakemonster.MainScreen;

/**
 * CS32SFinalExample.java - the final example for Computer Science 32SIB
 *
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public class CS32SFinalExample 
{

    /**
     * Main method for the project
     * 
     * @param args the command line arguments
     */
    public CS32SFinalExample() {
        String[] options = {"Pacman","Snake Monster"};
        int result = JOptionPane.showOptionDialog(null,"Choose...",
                     "Gaming Example 2018",JOptionPane.DEFAULT_OPTION,
                     JOptionPane.PLAIN_MESSAGE,null, options, options[0]);
        if (result == 0) {
            PacmanUI game = new PacmanUI();
        }
        else if (result == 1) {
            MainScreen game = new MainScreen();
        }        
    }

}