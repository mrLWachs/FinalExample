package yearOthers.mousetest;

import javax.swing.JButton;
import javax.swing.JLabel;

/**
 * Coordinates.java -
 * @author lwachs
 * @since
 * @version 1.0
 */

public class Coordinates
{
    public int left;
    public int top;
    public int right;
    public int bottom;
    public int width;
    public int height;

    /**
     * constructs an empty coordinate object 
     */    
    public Coordinates() {
        left   = 0;
        top    = 0;
        right  = 0;
        bottom = 0;
        width  = 0;
        height = 0;
    }
    
    /**
     * constructs a coordinate object from a JLabel object
     * @param button the JLabel object to use
     */
    public Coordinates(JLabel label) {
        left   = label.getX();
        top    = label.getY();
        width  = label.getWidth();
        height = label.getHeight();
        right  = left + width;
        bottom = left + width;
    }

    /**
     * constructs a coordinate object from a JButton object
     * @param button the JButton object to use
     */
    public Coordinates(JButton button) {
        left   = button.getX();
        top    = button.getY();
        width  = button.getWidth();
        height = button.getHeight();
        right  = left + width;
        bottom = left + width;
    }
    
    /**
     * determines if two sets of coordinates are in collision (overlapping)
     * @param target the coordinate object to check against
     * @return colliding (true) or not (false)
     */
    public boolean isCollidingWith(Coordinates target) {
        if (((this.left   >= target.left && this.left   <= target.right) ||
             (this.right  >= target.left && this.right  <= target.right)) &&
            ((this.top    >= target.top  && this.top    <= target.bottom) ||
             (this.bottom >= target.top  && this.bottom <= target.bottom))) {
            return true;
        }
        if (((target.left   >= this.left && target.left   <= this.right) ||
             (target.right  >= this.left && target.right  <= this.right)) &&
            ((target.top    >= this.top  && target.top    <= this.bottom) ||
             (target.bottom >= this.top  && target.bottom <= this.bottom))) {
            return true;
        }
        return false;
    }
    
}
