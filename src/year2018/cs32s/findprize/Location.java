
/** required package class namespace */
package year2018.cs32s.findprize;

import java.awt.Color;
import javax.swing.JLabel;

/**
 * Location.java - description here...
 *
 * @author Mr. Wachs (login: lawrence.wachs)
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public class Location 
{

    public int row;
    public int column;
    
    public Location(JLabel[][] grid, Color color) {
        double maxRows    = (double)grid.length    - 1;
        double maxColumns = (double)grid[0].length - 1;
        double low        = 0d;
        row    = (int)((maxRows    - low + 1d) * Math.random() + low);
        column = (int)((maxColumns - low + 1d) * Math.random() + low);        
        while (grid[row][column].getBackground() != Globals.GRID_COLOR) {
            row    = (int)((maxRows    - low + 1d) * Math.random() + low);
            column = (int)((maxColumns - low + 1d) * Math.random() + low);
        }        
        if (color == Globals.HERO_COLOR) {
            grid[row][column].setText(Globals.HERO_TEXT);
        }
        else if (color == Globals.PRIZE_COLOR) {
            grid[row][column].setText(Globals.PRIZE_TEXT);
        }
        else if (color == Globals.GOAL_COLOR) {
            grid[row][column].setText(Globals.GOAL_TEXT);
        }
        grid[row][column].setBackground(color);
    }
    
}
