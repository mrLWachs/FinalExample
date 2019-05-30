
/** required package class namespace */
package mainpackage;

/** required imports */
import static mainpackage.MainClass.gamesPlayed;
import static mainpackage.MainClass.totalPoints;
import year2019.cs30s.animations.AnimationsMain;
import year2019.cs30s.email.EmailMain;
import year2019.cs40s.bufferedimages.BufferedImagesMain;
import year2019.cs40s.genericgame.Game;
import year2019.cs40s.systemfilemanager.FileToolsUI;
import year2019.cs40s.twitter.TwitterMainClass;

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
        
    private static final String[]  CS30S_OPTIONS       = { "Emailer",
                                                           "Animated Game",
                                                           "Choose year",
                                                           "Exit" };
    private static final String[]  CS40S_OPTIONS       = { "File Tools",
                                                           "Buffered Images",
                                                           "Generic Game",
                                                           "Twitter Reader",
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
        String text = MainConstants.MENU_PROMPT_1 + gamesPlayed + 
                      MainConstants.MENU_PROMPT_2 + totalPoints + 
                      MainConstants.MENU_PROMPT_3 +  
                      MainConstants.MENU_PROMPT_4 + "2019 " +
                      MainConstants.MENU_PROMPT_5;
        String choice = MainClass.dialog.buttons(text, 
                                                 MainConstants.EXAMPLE_OPTIONS);
        if      (choice.equals(MainConstants.EXAMPLE_OPTIONS[0])) 
            menuCS30S();
        else if (choice.equals(MainConstants.EXAMPLE_OPTIONS[1])) 
            menuCS40S();
        else if (choice.equals(MainConstants.EXAMPLE_OPTIONS[2])) 
            MainClass.menu();         
        else                                                  
            MainClass.end();
     }
     
    /**
     * The menu for the Computer Science 30S examples
     */
    private static void menuCS30S() {
        String text = MainConstants.MENU_PROMPT_1 + gamesPlayed + 
                      MainConstants.MENU_PROMPT_2 + totalPoints + 
                      MainConstants.MENU_PROMPT_3 + 
                      MainConstants.MENU_PROMPT_6;
        String choice = MainClass.dialog.buttons(text, CS30S_OPTIONS);
        if      (choice.equals(CS30S_OPTIONS[0])) new EmailMain();
        else if (choice.equals(CS30S_OPTIONS[1])) new AnimationsMain();
        else if (choice.equals(CS30S_OPTIONS[2])) MainClass.menu();
        else                                      MainClass.end();
    }
    
    /**
     * The menu for the Computer Science 40S examples
     */
    private static void menuCS40S() {
        String text = MainConstants.MENU_PROMPT_1 + gamesPlayed + 
                      MainConstants.MENU_PROMPT_2 + totalPoints + 
                      MainConstants.MENU_PROMPT_3 + 
                      MainConstants.MENU_PROMPT_7;
        String choice = MainClass.dialog.buttons(text, CS40S_OPTIONS);
        if      (choice.equals(CS40S_OPTIONS[0])) new FileToolsUI();
        else if (choice.equals(CS40S_OPTIONS[1])) new BufferedImagesMain();
        else if (choice.equals(CS40S_OPTIONS[2])) new Game();
        else if (choice.equals(CS40S_OPTIONS[3])) new TwitterMainClass();
        else if (choice.equals(CS40S_OPTIONS[4])) MainClass.menu();
        else                                      MainClass.end(); 
    }
    
}
