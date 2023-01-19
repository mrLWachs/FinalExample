
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


        
    public static int         gamesPlayed = 0;
    public static int         totalPoints = 0;   
    public static MediaPlayer mediaPlayer = new MediaPlayer();   
    public static Dialogs     dialog      = 
            new Dialogs(MainConstants.APP_TITLE);
    public static FrameTools  frameTool   = new FrameTools();
    public static FileHandler fileHandler = 
            new FileHandler(MainConstants.DATA_FILE);
    
    
    /**
     * Starting the examples application, open saved data from the data file
     */
    private static void start() {
        mediaPlayer.playWAV(MainConstants.SOUND);           // play sound file
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
        mediaPlayer.playWAV(MainConstants.SOUND);         // play sound file
        System.exit(0);                     // exit application
    }

    /**
     * The main application menu for the various examples
     */
    public static void menu() {
        String text = MainConstants.MENU_PROMPT_1 + gamesPlayed + 
                      MainConstants.MENU_PROMPT_2 + totalPoints + 
                      MainConstants.MENU_PROMPT_3 +
                      MainConstants.MENU_PROMPT_8;
        String choice = dialog.choose(text,MainConstants.YEAR_OPTIONS);
        if      (choice == null || choice.equals(""))          menu();
        if      (choice.equals(MainConstants.YEAR_OPTIONS[0])) new Examples2022();
        else if (choice.equals(MainConstants.YEAR_OPTIONS[1])) new Examples2021(); 
        else if (choice.equals(MainConstants.YEAR_OPTIONS[2])) new Examples2020();        
        else if (choice.equals(MainConstants.YEAR_OPTIONS[3])) new Examples2019();        
        else if (choice.equals(MainConstants.YEAR_OPTIONS[4])) new Examples2018();        
        else if (choice.equals(MainConstants.YEAR_OPTIONS[5])) new ExamplesOther();        
        else                                                   end(); 
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