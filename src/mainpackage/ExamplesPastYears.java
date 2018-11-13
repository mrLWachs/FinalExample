
/** required package class namespace */
package mainpackage;

/** required imports */
import static mainpackage.MainClass.gamesPlayed;
import static mainpackage.MainClass.totalPoints;
import year2018.cs30s.tools.Dialogs;

/**
 * ExamplesPastYears.java - The in class example done and requested for past 
 * school years
 *
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public class ExamplesPastYears
{

    /** 
     * Default constructor for the class
     */
    public ExamplesPastYears() {
        String text = "You have played " + gamesPlayed + " total "
                    + "games, and earned " + totalPoints + " total "
                    + "points!\n\nThese example are not yet prepared..";  
        new Dialogs().output(text, MainConstants.APP_TITLE);
        MainClass.menu();
    }
    
}
