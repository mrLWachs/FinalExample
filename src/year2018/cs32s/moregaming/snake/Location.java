
/** required package */
package year2018.cs32s.moregaming.snake;

/**
 * Location.java - stores and adjusts an object's location
 * @author Mr. Wachs' Computer Science Student (login: lwachs)
 * @since 03-June-2015
 * @version 1.0
 * @instructor Mr. Wachs
 */
public class Location 
{
    
    /** the row location */
    public int row;
    /** the column location */
    public int column;
    /** the direction of travel */
    public int direction;
    
    /**
     * class constructor, sets class properties to the parameters
     * @param row the row location
     * @param column the column location
     * @param direction the direction of travel
     */
    public Location(int row, int column, int direction) {
        this.row            = row;
        this.column         = column;
        this.direction      = direction;
    }
    
}
