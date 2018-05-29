
/** required package class namespace */
package year2018.cs30s.gametools;

/** required imports */
import javax.swing.JLabel;

/**
 * Coordinate.java - stores data on position and movement as well as methods 
 * to move those values
 *
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public class Coordinate 
{

    /** 
     * Property data tracking an object's location and movement 
     */
    public int x,y,width,height,
               left,right,top,bottom,
               amount,direction;
    
    private JLabel hitbox;                      // the JLabel hitbox image
    
    /**
     * Constructor for the class sets class properties
     * 
     * @param image the JLabel hitbox image
     */
    public Coordinate(JLabel image) {
        hitbox    = image;                      // assign parameter to property
        direction = Directions.STOP;            // set movement to stop
        amount    = Directions.STOP;
        update();                               // update coordinate data
    }
    
    /**
     * Constructor for the class sets class properties
     * 
     * @param image the JLabel hitbox image
     * @param direction the starting direction of movement
     * @param amount the starting amount of movement
     */
    public Coordinate(JLabel image, int direction, int amount) {
        hitbox         = image;                 // assign parameter to property
        this.direction = direction;             // assign parameter to property
        this.amount    = amount;                // assign parameter to property
        update();                               // update coordinate data
    }
      
    /**
     * Updates the current location of the coordinates box in its container
     */
    public void update() {
        x      = hitbox.getX();             // get x coordinate from hitbox
        y      = hitbox.getY();             // get y coordinate from hitbox
        width  = hitbox.getWidth();         // get width coordinate from hitbox
        height = hitbox.getHeight();        // get height coordinate from hitbox
        recalculate();                      // recalculate other needed data
    }

    /**
     * Recalculates needed movement data
     */
    public void recalculate() {
        left   = x;                         // calculate left from x
        top    = y;                         // calculate top from y
        right  = left + width;              // right calculated left + width
        bottom = top  + height;             // bottom calculated top + height
    }
    
    /**
     * Determines if one set of coordinate data is overlapping (colliding) 
     * with the target coordinate data horizontally
     * 
     * @param target the coordinate data to check against 
     * @return it is colliding (true) or not (false) horizontally
     */
    public boolean isOverlappingHorizontally(Coordinate target) {
        if      (left         >= target.left && 
                 left         <= target.right)      return true;
        else if (right        >= target.left && 
                 right        <= target.right)      return true;
        else if (target.left  >= left        && 
                 target.left  <= right)             return true;
        else if (target.right >= left        && 
                 target.right <= right)             return true;
        else                                        return false;
    }
    
    /**
     * Determines if one set of coordinate data is overlapping (colliding) 
     * with the target coordinate data vertically
     * 
     * @param target the coordinate data to check against 
     * @return it is colliding (true) or not (false) vertically
     */
    public boolean isOverlappingVertically(Coordinate target) {
        if      (top           >= target.top && 
                 top           <= target.bottom)    return true;
        else if (bottom        >= target.top && 
                 bottom        <= target.bottom)    return true;
        else if (target.top    >= top        && 
                 target.top    <= bottom)           return true;
        else if (target.bottom >= top        && 
                 target.bottom <= bottom)           return true;
        else                                        return false;
    }
    
    /**
     * Determines if one set of coordinate data is overlapping (colliding) 
     * with the target coordinate data both vertically and horizontally
     * 
     * @param target the coordinate data to check against 
     * @return it is colliding (true) or not (false) 
     */
    public boolean isOverlapping(Coordinate target) {
        if (isOverlappingVertically(target) &&
            isOverlappingHorizontally(target)) {
            return true;
        }
        else {
            return false;
        }
    }
    
}
