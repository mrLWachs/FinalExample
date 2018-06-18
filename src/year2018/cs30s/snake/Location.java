
/** required package class namespace */
package year2018.cs30s.snake;

/**
 * Location.java - stores and adjusts an object's location
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
     * The direction of travel 
     */
    public int direction;
    
    /**
     * Class constructor, sets class properties to the parameters
     * 
     * @param row the row location
     * @param column the column location
     * @param direction the direction of travel
     */
    public Location(int row, int column, int direction) {
        this.row       = row;
        this.column    = column;
        this.direction = direction;
    }
    
}
