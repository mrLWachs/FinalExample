
/** required package class namespace */
package mainpackage;

/** required imports */
import static mainpackage.MainClass.gamesPlayed;
import static mainpackage.MainClass.totalPoints;
import yearOthers.triangle.FractalMain;
import yearOthers.mousetest.MouseTestGUI;
import yearOthers.polygonmath.PolygonMathGUI;


/**
 * ExamplesOther.java - The in class examples done and requested for the 
 * various past school years
 *
 * @author Mr. Wachs
 * @since September 21, 2018 
 * @instructor Mr. Wachs
 */
public class ExamplesOther
{
        
    private static final String[]  CS30S_OPTIONS       = { "Fractal Triangle Creator",
                                                           "Mouse Test",
                                                           "Choose year",
                                                           "Exit" };
    private static final String[]  CS40S_OPTIONS       = { "Polygon Math",
                                                           "Grid Game",
                                                           "Seating Plan",
                                                           "Choose year",
                                                           "Exit" };
        
    /** 
     * Default constructor for the class
     */
    public ExamplesOther() {
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
        if      (choice.equals(CS30S_OPTIONS[0])) new FractalMain();
        else if (choice.equals(CS30S_OPTIONS[1])) new MouseTestGUI();
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
        if      (choice.equals(CS40S_OPTIONS[0])) new PolygonMathGUI().main(null);
        else if (choice.equals(CS40S_OPTIONS[1])) new yearOthers.gridgame.MainProgram.MainClass().main(null);
        else if (choice.equals(CS40S_OPTIONS[2])) new yearOthers.seatingplan.SeatingPlan().main(null);
        else if (choice.equals(CS40S_OPTIONS[3])) MainClass.menu();
        else                                      MainClass.end(); 
    }
    
}
