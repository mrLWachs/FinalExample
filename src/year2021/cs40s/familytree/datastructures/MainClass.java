
/** Required package class namespace */
package year2021.cs40s.familytree.datastructures;

/** Required imports */
import year2021.cs40s.familytree.userinterfaces.WelcomeUI;


/**
 * MainClass.java - This class is the starting point for the application (app)
 * it sets up the data structures and displays the first user interface
 *
 * @author Mr. Wachs' student 
 * @since Mar. 17, 2021 
 */
public class MainClass 
{

    /**
     * Main method for the application
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Globals.start();                        // Start the app logic
        new WelcomeUI();                        // Display first screen
    }

}
