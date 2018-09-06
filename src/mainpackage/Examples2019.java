
/** required package class namespace */
package mainpackage;

/** required imports */
import static mainpackage.MainClass.gamesPlayed;
import static mainpackage.MainClass.totalPoints;
import year2019.cs40s.systemfilemanager.FileToolsUI;

/**
 * Examples2019.java - The in class example done and requested for the 
 * 2018-2019 school year
 *
 * @author Mr. Wachs
 * @since September 21, 2018 
 * @instructor Mr. Wachs
 */
public class Examples2019
{
        
    private static final String[]  CS30S_OPTIONS       = { "Nothing yet...",
                                                           "Choose year",
                                                           "Exit" };
    private static final String[]  CS40S_OPTIONS       = { "File Tools",
                                                           "Choose year",
                                                           "Exit" };
        
    /** 
     * Default constructor for the class
     */
    public Examples2019() {
        menu();
    }
    
    /**
     * The main application menu for the various examples
     */
    public static void menu() {
        String text = "You have played " + gamesPlayed + " total "
                    + "games, and earned " + totalPoints + " total "
                    + "points!\n\nChoose an example from 2019 in Computer "
                    + "Science 30S (or 32SIB) or 40S (or 42SIB)...";
        String choice = MainClass.dialog.buttons(text, 
                                                 MainClass.EXAMPLE_OPTIONS);
        if      (choice.equals(MainClass.EXAMPLE_OPTIONS[0])) menuCS30S();
        else if (choice.equals(MainClass.EXAMPLE_OPTIONS[1])) menuCS40S();
        else if (choice.equals(MainClass.EXAMPLE_OPTIONS[2])) MainClass.menu();         
        else                                                  MainClass.end();
     }
     
    /**
     * The menu for the Computer Science 30S examples
     */
    private static void menuCS30S() {
        String text = "You have played " + gamesPlayed + " total "
                    + "games, and earned " + totalPoints + " total "
                    + "points!\n\nChoose a Computer Science 30S example...";
        String choice = MainClass.dialog.buttons(text, CS30S_OPTIONS);
        if      (choice.equals(CS30S_OPTIONS[1])) MainClass.menu();
        else                                      MainClass.end();
    }
    
    /**
     * The menu for the Computer Science 40S examples
     */
    private static void menuCS40S() {
        String text = "You have played " + gamesPlayed + " total "
                    + "games, and earned " + totalPoints + " total "
                    + "points!\n\nChoose a Computer Science 40S example...";
        String choice = MainClass.dialog.buttons(text, CS40S_OPTIONS);
        if      (choice.equals(CS40S_OPTIONS[0])) new FileToolsUI();
        else if (choice.equals(CS40S_OPTIONS[1])) MainClass.menu();
        else                                      MainClass.end(); 
    }
    
}
