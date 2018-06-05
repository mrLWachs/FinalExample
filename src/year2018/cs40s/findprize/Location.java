
/** required package class namespace */
package year2018.cs40s.findprize;

/** required imports */
import java.awt.Color;
import javax.swing.JLabel;

/**
 * Location.java - class tracks the location in a two dimensional matrix of
 * JLabel images for the find prizes game
 *
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public class Location 
{

    /**
     * The row location on the grid
     */
    public int row;
    
    /**
     * The column location on the grid
     */
    public int column;
    
    /**
     * Constructor for the class sets class data to a random location
     * 
     * @param grid the JLabel matrix to set the location to
     * @param color the color to set
     * @param text the text to set
     */
    public Location(JLabel[][] grid, Color color, String text) {
        double maxRows    = (double)grid.length    - 1;
        double maxColumns = (double)grid[0].length - 1;
        double low        = 0d;
        row    = (int)((maxRows    - low + 1d) * Math.random() + low);
        column = (int)((maxColumns - low + 1d) * Math.random() + low);        
        while (grid[row][column].getBackground() != Globals.GRID_COLOR) {
            row    = (int)((maxRows    - low + 1d) * Math.random() + low);
            column = (int)((maxColumns - low + 1d) * Math.random() + low);
        }        
        grid[row][column].setBackground(color);
        grid[row][column].setText(text);        
    }
    
}
