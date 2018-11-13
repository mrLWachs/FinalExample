
/** required package class namespace */
package mainpackage;

/** required imports */
import static mainpackage.MainClass.gamesPlayed;
import static mainpackage.MainClass.totalPoints;
import year2018.cs30s.frogger.FroggerGUI;
import year2018.cs30s.snake.SnakeUI;
import year2018.cs30s.spaceinvaders.SpaceInvadersGUI;
import year2018.cs30s.survivor.SurvivorUI;
import year2018.cs30s.uno.UnoUI;
import year2018.cs30s.other.OtherUI;
import year2018.cs30s.pacman.PacmanUI;
import year2018.cs40s.findprize.FindPrizes;
import year2018.cs40s.login.LogIn;
import year2018.cs40s.pokedex.PokeDexStart;

/**
 * Examples2018.java - The in class example done and requested for the 
 * 2017-2018 school year
 *
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public class Examples2018 
{
        
    private static final String[]  CS30S_OPTIONS       = { "Pacman", 
                                                           "Frogger",
                                                           "Space Invaders", 
                                                           "Snake",
                                                           "Survivor",
                                                           "Uno",
                                                           "Other",
                                                           "Choose year",
                                                           "Exit" };
    private static final String[]  CS40S_OPTIONS       = { "Login", 
                                                           "Find Prizes",
                                                           "PokeDex",
                                                           "Choose year",
                                                           "Exit" };
        
    /** 
     * Default constructor for the class
     */
    public Examples2018() {
        menu();
    }
    
    /**
     * The main application menu for the various examples
     */
    public static void menu() {
        String text = MainConstants.MENU_PROMPT_1 + gamesPlayed + 
                      MainConstants.MENU_PROMPT_2 + totalPoints + 
                      MainConstants.MENU_PROMPT_3 +  
                      MainConstants.MENU_PROMPT_4 + "2018 " +
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
        if      (choice.equals(CS30S_OPTIONS[0])) new PacmanUI();
        else if (choice.equals(CS30S_OPTIONS[1])) new FroggerGUI();
        else if (choice.equals(CS30S_OPTIONS[2])) new SpaceInvadersGUI();
        else if (choice.equals(CS30S_OPTIONS[3])) new SnakeUI();
        else if (choice.equals(CS30S_OPTIONS[4])) new SurvivorUI(); 
        else if (choice.equals(CS30S_OPTIONS[5])) new UnoUI();
        else if (choice.equals(CS30S_OPTIONS[6])) new OtherUI();
        else if (choice.equals(CS30S_OPTIONS[7])) MainClass.menu();
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
        if      (choice.equals(CS40S_OPTIONS[0])) new LogIn();
        else if (choice.equals(CS40S_OPTIONS[1])) new FindPrizes();
        else if (choice.equals(CS40S_OPTIONS[2])) new PokeDexStart();
        else if (choice.equals(CS40S_OPTIONS[3])) MainClass.menu();
        else                                      MainClass.end(); 
    }
    
}
