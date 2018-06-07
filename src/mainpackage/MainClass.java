
/** required package class namespace */
package mainpackage;

/** required imports */
import year2018.cs30s.tools.Dialogs;
import year2018.cs30s.tools.FileHandler;
import year2018.cs30s.tools.FrameTools;
import year2018.cs30s.tools.MediaPlayer;

/**
 * MainClass.java - the main class for the project
 *
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public class MainClass 
{

    public  static final String   MEDIA_PATH      = "/media/";  
    public  static final String   ICON            = MEDIA_PATH + "icon.png";
    public  static final String   SOUND           = MEDIA_PATH + "Ding.wav";   
    public  static final String   DATA_FILE       = MEDIA_PATH + "data.txt";
        
    private static final String[] YEAR_OPTIONS    = { "2017-2018",
                                                      "Past years",
                                                      "Exit" };    
    public static final String[]  EXAMPLE_OPTIONS = { "Computer Science 30S",
                                                      "Computer Science 40S",
                                                      "Choose year",
                                                      "Exit" };
    public static final String    APP_TITLE       = "Mr. Wachs Examples...";
        
    public static int         gamesPlayed = 0;
    public static int         totalPoints = 0;   
    public static MediaPlayer mediaPlayer = new MediaPlayer();   
    public static Dialogs     dialog      = new Dialogs(APP_TITLE);
    public static FrameTools  frameTool   = new FrameTools();
    public static FileHandler fileHandler = new FileHandler(DATA_FILE);
    
    
    /**
     * Starting the examples application, open saved data from the data file
     */
    private static void start() {
        mediaPlayer.playWav(SOUND);                     // play sound file
        String[] data = fileHandler.read();             // read data from file
        if (data != null && data.length > 0) {          // if data is valid
            gamesPlayed = Integer.parseInt(data[0]);    // get games played
            totalPoints = Integer.parseInt(data[1]);    // get total points
        }
        menu();                                         // bring up main menu
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
        String text = "You have played " + gamesPlayed + " total "
                    + "games, and earned " + totalPoints + " total "
                    + "points!\n\nChoose a year to see examples from...";     
        String choice = dialog.choose(text,YEAR_OPTIONS);
        if      (choice == null || choice.equals("")) menu();
        if      (choice.equals(YEAR_OPTIONS[0]))      new Examples2018();
        else if (choice.equals(YEAR_OPTIONS[1]))      new ExamplesPastYears();
        else                                          end(); 
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