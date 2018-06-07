
/** required package class namespace */
package year2018.cs40s.findprize;

/** required imports */
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import mainpackage.MainClass;

/**
 * Engine.java - the logic connected to the user interface that runs game logic
 *
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public class Engine 
{

    private JLabel[][] grid;                // the matrix of JLabel images
    private Location hero;                  // the location of the hero
    private Location goal;                  // the location of the goal
    private Location[] prizes;              // the array of prize locations
    private int totalPrizes;                // total prizes currently displayed
    
    /**
     * Constructor sets class properties
     * 
     * @param grid the JLabel matrix on the user interface
     */
    public Engine(JLabel[][] grid) {
        this.grid   = grid;                     // connect parameter to property
        totalPrizes = 0;
        prizes      = new Location[ (grid.length * grid[0].length) - 2];
        hero        = new Location(grid,Globals.HERO_COLOR,Globals.HERO_TEXT);
        goal        = new Location(grid,Globals.GOAL_COLOR,Globals.GOAL_TEXT); 
        prizes[0]   = new Location(grid,Globals.PRIZE_COLOR,Globals.PRIZE_TEXT); 
        totalPrizes++;
    }
        
    /**
     * The user's keyboard event of pressing a key to respond to
     * 
     * @param event the keyboard event registered
     */
    public void keyPress(KeyEvent event) {
        grid[hero.row][hero.column].setBackground(Globals.GRID_COLOR);
        grid[hero.row][hero.column].setText(Globals.GRID_TEXT);
        if      (event.getKeyCode() == KeyEvent.VK_ESCAPE) next();
        else if (event.getKeyCode() == KeyEvent.VK_UP)     hero.row--;
        else if (event.getKeyCode() == KeyEvent.VK_DOWN)   hero.row++;
        else if (event.getKeyCode() == KeyEvent.VK_LEFT)   hero.column--;
        else if (event.getKeyCode() == KeyEvent.VK_RIGHT)  hero.column++;
        checkEdges();
        checkPrizes();
        checkGoal(); 
        grid[hero.row][hero.column].setBackground(Globals.HERO_COLOR); 
        grid[hero.row][hero.column].setText(Globals.HERO_TEXT);
    }
        
    /** 
     * Move to the next screen user interface
     */
    private void next() {
        Globals.main.setVisible(false);
        Globals.next.setVisible(true);
    }
    
    /**
     * Check to see the hero does not go outside the grid area
     */
    private void checkEdges() {        
        if      (hero.row < 0)                       
                                            hero.row = 0; 
        else if (hero.row >= Globals.gridRows)       
                                            hero.row = Globals.gridRows-1; 
        else if (hero.column < 0)                    
                                            hero.column = 0; 
        else if (hero.column >= Globals.gridColumns) 
                                            hero.column = Globals.gridColumns-1;   
    }

    /**
     * Checks to see if the user has hit a prize, then add a new prize to 
     * the grid in a random unoccupied location
     */
    private void checkPrizes() {
        for (int i = 0; i < totalPrizes; i++) { // traverse all visible prizes
            Location prize = prizes[i];         // get current prize
            if (hero.row == prize.row && hero.column == prize.column) {                
                grid[hero.row][hero.column].setBackground(
                        Globals.PRIZE_EATEN_COLOR);
                grid[hero.row][hero.column].setText(Globals.PRIZE_EATEN_TEXT);                
                prizes[totalPrizes] = new Location(grid,Globals.PRIZE_COLOR,
                                                   Globals.PRIZE_TEXT);
                totalPrizes++;                  // total prizes increases
                MainClass.totalPoints++;
                return;                         // leave method
            }
            else {
                grid[prize.row][prize.column].setBackground(
                        Globals.PRIZE_COLOR);
                grid[prize.row][prize.column].setText(
                        Globals.PRIZE_TEXT + (i+1));   
            }
        }
    }

    /**
     * Checks to see if the user has hit the goal, leave this screen to the 
     * next screen and set a random location for the hero and goal when they 
     * return to this screen
     */
    private void checkGoal() {        
        if (hero.row == goal.row && hero.column == goal.column) {
            grid[hero.row][hero.column].setBackground(Globals.GRID_COLOR);
            grid[goal.row][goal.column].setBackground(Globals.GRID_COLOR);            
            grid[hero.row][hero.column].setText(Globals.GRID_TEXT);
            grid[goal.row][goal.column].setText(Globals.GRID_TEXT);
            next();
            hero = new Location(grid,Globals.HERO_COLOR,Globals.HERO_TEXT);
            goal = new Location(grid,Globals.GOAL_COLOR,Globals.GOAL_TEXT);
        }        
    }   

}
