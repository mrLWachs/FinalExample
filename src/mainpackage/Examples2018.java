
/** required package class namespace */
package mainpackage;

import year2018.cs30s.moregaming.frogger.FroggerGUI;
import year2018.cs30s.moregaming.snake.SnakeUI;
import year2018.cs30s.moregaming.spaceinvaders.SpaceInvadersGUI;
import year2018.cs30s.other.OtherUI;
import year2018.cs30s.pacman.PacmanUI;
import year2018.cs40s.findprize.FindPrizes;
import year2018.cs40s.login.LogIn;
import year2018.cs40s.pokedex.PokeDexStart;

/**
 * Examples2018.java - description here...
 *
 * @author Mr. Wachs (login: lawrence.wachs)
 * @since Jun 7, 2018 
 * @instructor Mr. Wachs
 */
public class Examples2018 
{
        
    private static final String[]  CS30S_OPTIONS       = { "Pacman", 
                                                           "Frogger",
                                                           "Space Invaders", 
                                                           "Snake",
                                                           "Other",
                                                           "Return" };
    private static final String[]  CS40S_OPTIONS       = { "Login", 
                                                           "Find Prizes",
                                                           "PokeDex",
                                                           "Return" };
    
    public  static final String    FROGGER_ICON        = MainClass.MEDIA_PATH + 
                                                            "Frogger.png";
    public  static final String    PACMAN_ICON         = MainClass.MEDIA_PATH + 
                                                            "Pacman.png";
    public  static final String    SPACE_INVADERS_ICON = MainClass.MEDIA_PATH + 
                                                            "SpaceInvaders.png";
    public  static final String    SNAKE_ICON          = MainClass.MEDIA_PATH + 
                                                            "Snake.png";
    public  static final String    OTHER_ICON          = MainClass.MEDIA_PATH + 
                                                            "examples.png";

    public static final String    LOGIN_ICON          = MainClass.MEDIA_PATH + 
                                                            "Login.png";
    public static final String    FIND_PRIZES_ICON    = MainClass.MEDIA_PATH + 
                                                            "FindPrizes.png";
        
    public Examples2018() {
        menu();
    }
    
    /**
     * The main application menu for the various examples
     */
    public static void menu() {
        String text = "Choose an example from 2018 in Computer "
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
        String text = "Choose a Computer Science 30S example...";
        String choice = MainClass.dialog.buttons(text, CS30S_OPTIONS);
        if      (choice.equals(CS30S_OPTIONS[0])) new PacmanUI();
        else if (choice.equals(CS30S_OPTIONS[1])) new FroggerGUI();
        else if (choice.equals(CS30S_OPTIONS[2])) new SpaceInvadersGUI();
        else if (choice.equals(CS30S_OPTIONS[3])) new SnakeUI();
        else if (choice.equals(CS30S_OPTIONS[4])) new OtherUI();
        else                                      MainClass.menu(); 
    }
    
    /**
     * The menu for the Computer Science 40S examples
     */
    private static void menuCS40S() {
        String text = "Choose a Computer Science 40S example...";
        String choice = MainClass.dialog.buttons(text, CS40S_OPTIONS);
        if      (choice.equals(CS40S_OPTIONS[0])) new LogIn();
        else if (choice.equals(CS40S_OPTIONS[1])) new FindPrizes();
        else if (choice.equals(CS40S_OPTIONS[2])) new PokeDexStart();
        else                                      MainClass.menu(); 
    }
    
}
