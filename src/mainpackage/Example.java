
/** required package class namespace */
package mainpackage;

/** required imports */
import year2018.cs30s.findprize.FindPrizes;
import year2018.cs30s.login.LogIn;
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
    
    private static final String[] OPTIONS             = { "Login", 
                                                          "Pacman", 
                                                          "Find Prizes", 
                                                          "Frogger",
                                                          "Space Invaders", 
                                                          "Snake",
                                                          "Exit" };
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
                   + "example from 2018 in Computer Science 30S or 32SIB...";
        String choice = dialog.buttons(dialogText, OPTIONS);
        if      (choice.equals(OPTIONS[0])) new LogIn();
        else if (choice.equals(OPTIONS[1])) new PacmanUI();
        else if (choice.equals(OPTIONS[2])) new FindPrizes();
        else if (choice.equals(OPTIONS[3])) new FroggerGUI();
        else if (choice.equals(OPTIONS[4])) new SpaceInvadersGUI();
        else if (choice.equals(OPTIONS[5])) new SnakeUI();
        else                                end(); 
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