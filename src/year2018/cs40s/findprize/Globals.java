
/** required package class namespace */
package year2018.cs40s.findprize;

/** required imports */
import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import mainpackage.Examples2018;
import mainpackage.MainClass;

/**
 * Globals.java - game global variables, constants and static methods for the 
 * Find Prizes game
 *
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public class Globals 
{
    
    public static final  int     MAIN_SCREEN             = 1;
    public static final  int     NEXT_SCREEN             = 2;
    public static final  int     FRAME_HORIZONTAL_SPACER = 20;
    public static final  int     FRAME_VERTICAL_SPACER   = 10; 
    private static final int     MAIN_FRAME_WIDTH        = 1200;
    private static final int     MAIN_FRAME_HEIGHT       = 980;
    private static final Color   MAIN_BACKGROUND_COLOR   = Color.white;
    public static final  int     GRID_SIZE               = MAIN_FRAME_WIDTH / 
                                                                            20;
    private static final String  MAIN_TITLE              = "Main Screen"; 
    private static final String  MAIN_ICON_FILE          = MainClass.MEDIA_PATH + 
                                                            "FindPrizes.png"; 
    private static final String  NEXT_ICON_FILE          = MainClass.MEDIA_PATH + 
                                                            "FindPrizes.png";     
    public static final  int     NEXT_FRAME_WIDTH        = 300;
    public static final  int     NEXT_FRAME_HEIGHT       = 150;   
    private static final String  NEXT_TITLE              = "Next Screen";
    private static final Color   NEXT_BACKGROUND_COLOR   = Color.black;
    public static final  int     GRID_VERTICAL_SPACER    = (int)
                                                           (GRID_SIZE * 1/4);
    public static final  int     GRID_HORIZONTAL_SPACER  = (int)
                                                           (GRID_SIZE * 1/2);  
    public static final  Font    GRID_FONT               = new Font(
                                                            "Arial Narrow",
                                                            Font.BOLD,
                                                            GRID_SIZE / 4);    
    public static final  Color   GRID_COLOR              = Color.white;
    public static final  Color   HERO_COLOR              = Color.orange;
    public static final  Color   PRIZE_COLOR             = Color.green; 
    public static final  Color   PRIZE_EATEN_COLOR       = Color.magenta;   
    public static final  Color   GOAL_COLOR              = Color.yellow;   
    public static final  String  GRID_TEXT               = "";
    public static final  String  HERO_TEXT               = "HERO";
    public static final  String  PRIZE_TEXT              = "PRIZE ";
    public static final  String  PRIZE_EATEN_TEXT        = "EATEN";
    public static final  String  GOAL_TEXT               = "GOAL"; 
    public static int            gridRows;
    public static int            gridColumns;    
    public static int            gridWidth;
    public static int            gridHeight;
    public static MainScreenUI   main;
    public static NextScreenUI   next;   
    public static Engine         engine;   
        
    /**
     * Initializes the two frames for the Find prizes game
     * 
     * @param screen which screen is currently being initialized
     * @param frame the particular frame to initialize
     */
    public static void initFrame(int screen, JFrame frame) {
        frame.getContentPane().setLayout(null);
        if (screen == MAIN_SCREEN) {    
            MainClass.frameTool.startup(frame, MAIN_TITLE, MAIN_FRAME_WIDTH, 
                    MAIN_FRAME_HEIGHT, false, true, false, false, 
                    MAIN_BACKGROUND_COLOR, MAIN_ICON_FILE); 
        }
        else if (screen == NEXT_SCREEN) {
            MainClass.frameTool.startup(frame, NEXT_TITLE, NEXT_FRAME_WIDTH, 
                    NEXT_FRAME_HEIGHT, false, true, false, true, 
                    NEXT_BACKGROUND_COLOR, NEXT_ICON_FILE);
            
        }   
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                close(frame);
            }
        });
    }
    
    /**
     * Starts the game find prizes by setting global values and hiding the 
     * next screen
     */
    public static void startGame() {        
        gridWidth   = gridHeight = GRID_SIZE;  
        int width   = MAIN_FRAME_WIDTH  - GRID_VERTICAL_SPACER   * 2;
        int height  = MAIN_FRAME_HEIGHT - GRID_HORIZONTAL_SPACER * 2;
        gridRows    = (height / gridHeight);
        gridColumns = (width  / gridWidth );  
        main        = new MainScreenUI();
        next        = new NextScreenUI();   
        engine      = new Engine(main.grid);
        next.setVisible(false);
    }
    
    /**
     * Closing th4 find prizes example returns to the main application menu
     * 
     * @param frame the current frame to close 
     */
    private static void close(JFrame frame) {
        frame.dispose();
        MainClass.gamesPlayed++;
        Examples2018.menu();
    }
        
}
