
package year2018.cs30s.findprize;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import static javax.swing.JFrame.DISPOSE_ON_CLOSE;
import year2018.cs30s.tools.FrameTools;

public class Globals 
{
    public static final  int     MAIN_SCREEN             = 1;
    public static final  int     NEXT_SCREEN             = 2;
    public static final  int     FRAME_HORIZONTAL_SPACER = 20;
    public static final  int     FRAME_VERTICAL_SPACER   = 10; 
    private static final int     MAIN_FRAME_WIDTH        = 1200;
    private static final int     MAIN_FRAME_HEIGHT       = 980;
    public static final  int     GRID_SIZE               = MAIN_FRAME_WIDTH / 20;
    private static final String  MAIN_TITLE              = "Main Screen";  
    public static final  int     NEXT_FRAME_WIDTH        = 300;
    public static final  int     NEXT_FRAME_HEIGHT       = 150;   
    private static final String  NEXT_TITLE              = "Next Screen";
    private static final Color   NEXT_BACKGROUND_COLOR   = Color.black;
    public static final  int     GRID_VERTICAL_SPACER    = (int)(GRID_SIZE * 1/4);
    public static final  int     GRID_HORIZONTAL_SPACER  = (int)(GRID_SIZE * 1/2);  
    public static final  Font    GRID_FONT               = new Font("Arial Narrow",Font.BOLD,GRID_SIZE/4);    
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
    public static MainScreen     main;
    public static NextScreen     next;   
    public static Engine         engine;    
        
    
    public static void initFrame(int screen, JFrame frame) {
        frame.getContentPane().setLayout(null);
        if (screen == MAIN_SCREEN) {            
            FrameTools.init(
                    frame, 
                    MAIN_TITLE, 
                    MAIN_FRAME_WIDTH, 
                    MAIN_FRAME_HEIGHT, 
                    false, 
                    true, 
                    true);
        }
        else if (screen == NEXT_SCREEN) {
            FrameTools.init(
                    frame, 
                    NEXT_TITLE, 
                    NEXT_FRAME_WIDTH, 
                    NEXT_FRAME_HEIGHT, 
                    false, 
                    true, 
                    true,
                    true,
                    NEXT_BACKGROUND_COLOR);
        }                
    }
    
    public static void startGame() {
        gridWidth   = gridHeight = GRID_SIZE;  
        int width   = MAIN_FRAME_WIDTH  - GRID_VERTICAL_SPACER   * 2;
        int height  = MAIN_FRAME_HEIGHT - GRID_HORIZONTAL_SPACER * 2;
        gridRows    = (height / gridHeight);
        gridColumns = (width  / gridWidth );        
        main        = new MainScreen();
        next        = new NextScreen();   
        engine      = new Engine(main.grid);
        next.setVisible(false);
    }
        
}
