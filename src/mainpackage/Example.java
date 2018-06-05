
/** required package class namespace */
package mainpackage;

/** required imports */
import year2018.cs40s.findprize.FindPrizes;
import year2018.cs40s.login.LogIn;
import year2018.cs30s.moregaming.frogger.FroggerGUI;
import year2018.cs30s.moregaming.snake.SnakeUI;
import year2018.cs30s.moregaming.spaceinvaders.SpaceInvadersGUI;
import year2018.cs30s.pacman.PacmanUI;
import year2018.cs30s.tools.Dialogs;
import year2018.cs30s.tools.FileHandler;
import year2018.cs30s.tools.FrameTools;
import year2018.cs30s.tools.MediaPlayer;

/**
 * Example.java - the main class for the project
 *
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public class Example 
{

    public static final String    MEDIA_PATH          = "/media/";    
    public static final String    LOGIN_ICON          = MEDIA_PATH + 
                                                            "Login.png";
    public static final String    FIND_PRIZES_ICON    = MEDIA_PATH + 
                                                            "FindPrizes.png";
    public static final String    FROGGER_ICON        = MEDIA_PATH + 
                                                            "Frogger.png";
    public static final String    PACMAN_ICON         = MEDIA_PATH + 
                                                            "Pacman.png";
    public static final String    SPACE_INVADERS_ICON = MEDIA_PATH + 
                                                            "SpaceInvaders.png";
    public static final String    SNAKE_ICON          = MEDIA_PATH + 
                                                            "Snake.png";
    public static final String    ICON                = MEDIA_PATH + "icon.png";
    public static final String    SOUND               = MEDIA_PATH + "Ding.wav";   
    public static final String    DATA_FILE           = MEDIA_PATH + "data.txt";
        
    private static final String[] EXAMPLE_OPTIONS   = { "Computer Science 30S",
                                                        "Computer Science 40S",
                                                        "Exit" };
    private static final String[] CS30S_OPTIONS     = { "Pacman", 
                                                        "Frogger",
                                                        "Space Invaders", 
                                                        "Snake",
                                                        "Return" };
    private static final String[] CS40S_OPTIONS     = { "Login", 
                                                        "Find Prizes",
                                                        "PokeDex",
                                                        "Return" };
    
    public static int         gamesPlayed = 0;
    public static int         totalPoints = 0;
    public static String      dialogText  = "";    
    public static MediaPlayer mediaPlayer = new MediaPlayer();   
    public static Dialogs     dialog      = new Dialogs("Final Examples 2018");
    public static FrameTools  frameTool   = new FrameTools();
    public static FileHandler fileHandler = new FileHandler(DATA_FILE);
    
    
    /**
     * Starting the examples application, open saved data from the data file
     */
    public static void start() {
        mediaPlayer.playWav(SOUND);                     // play sound file
        String[] data = fileHandler.read();             // read data from file
        if (data != null && data.length > 0) {          // if data is valid
            gamesPlayed = Integer.parseInt(data[0]);    // get games played
            totalPoints = Integer.parseInt(data[1]);    // get total points
        }
        menu();                                         // show main menu
    }
    
    /**
     * Ending the examples application, saves data to the data file
     */
    public static void end() {     
        String[] data = new String[3];      // create data array
        data[0] = "3";                      // size of array saved first
        data[1] = "" + gamesPlayed;         // then all array data
        data[2] = "" + totalPoints;
        fileHandler.write(data);            // write array to data file
        mediaPlayer.playWav(SOUND);         // play sound file
        System.exit(0);                     // exit application
    }

    /**
     * The main application menu for the various examples
     */
    public static void menu() {
        dialogText = "You have played " + gamesPlayed + " total games, and "
                   + "earned " + totalPoints + " total points!\n\nChoose an "
                   + "example from 2018 in Computer Science 30S (or 32SIB) "
                   + "or 40S (or 42SIB)...";
        String choice = dialog.buttons(dialogText, EXAMPLE_OPTIONS);
        if      (choice.equals(EXAMPLE_OPTIONS[0])) menuCS30S();
        else if (choice.equals(EXAMPLE_OPTIONS[1])) menuCS40S();
        else                                        end(); 
    }
    
    /**
     * The menu for the Computer Science 30S examples
     */
    public static void menuCS30S() {
        dialogText = "Choose a Computer Science 30S example...";
        String choice = dialog.buttons(dialogText, CS30S_OPTIONS);
        if      (choice.equals(CS30S_OPTIONS[0])) new PacmanUI();
        else if (choice.equals(CS30S_OPTIONS[1])) new FroggerGUI();
        else if (choice.equals(CS30S_OPTIONS[2])) new SpaceInvadersGUI();
        else if (choice.equals(CS30S_OPTIONS[3])) new SnakeUI();
        else                                      menu(); 
    }
    
    /**
     * The menu for the Computer Science 40S examples
     */
    public static void menuCS40S() {
        dialogText = "Choose a Computer Science 40S example...";
        String choice = dialog.buttons(dialogText, CS40S_OPTIONS);
        if      (choice.equals(CS40S_OPTIONS[0])) new LogIn();
        else if (choice.equals(CS40S_OPTIONS[1])) new FindPrizes();
        else if (choice.equals(CS40S_OPTIONS[2])) { /* new Pokedex(); */ }
        else                                      menu(); 
    }
        
    /**
     * Main method for the project
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        start();
    }

}