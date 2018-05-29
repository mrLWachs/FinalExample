
/** required package class namespace */
package mainpackage;

/** required imports */
import javax.swing.JOptionPane;
import year2018.cs30s.finalexample.CS30SFinalExample;
import year2018.cs32s.finalexample.CS32SFinalExample;

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
        String[] options = {"CS30S","CS32SIB"};
        int result = JOptionPane.showOptionDialog(null,"Choose...",
                     "Final Example 2018",JOptionPane.DEFAULT_OPTION,
                     JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        if      (result == 0) new CS30SFinalExample();
        else if (result == 1) new CS32SFinalExample();
    }

}
