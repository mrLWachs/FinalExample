

package year2018.cs30s.gametools;

import javax.swing.JLabel;

public class Coordinate 
{

    // properties:
    
    public int x,y,width,height,
               left,right,top,bottom,
               amount,direction;
    
    private JLabel hitbox;
    
    // methods:
    
    public Coordinate(JLabel image) {
        hitbox    = image;
        direction = Directions.STOP;
        amount    = Directions.STOP;
        update();
    }
    
    public Coordinate(JLabel image, 
                      int direction, 
                      int amount) {
        hitbox         = image;
        this.direction = direction;
        this.amount    = amount;
        update();
    }
      
    public void update() {
        x      = hitbox.getX();
        y      = hitbox.getY();
        width  = hitbox.getWidth();
        height = hitbox.getHeight();
        recalculate();
    }

    public void recalculate() {
        left   = x;
        top    = y;
        right  = left + width;
        bottom = top  + height;
    }
    
    
    public boolean isOverlappingHorizontally(Coordinate target) {
        if      (left         >= target.left && left         <= target.right) return true;
        else if (right        >= target.left && right        <= target.right) return true;
        else if (target.left  >= left        && target.left  <= right)        return true;
        else if (target.right >= left        && target.right <= right)        return true;
        else                                                                  return false;
    }
    
    public boolean isOverlappingVertically(Coordinate target) {
        if      (top           >= target.top && top           <= target.bottom) return true;
        else if (bottom        >= target.top && bottom        <= target.bottom) return true;
        else if (target.top    >= top        && target.top    <= bottom)        return true;
        else if (target.bottom >= top        && target.bottom <= bottom)        return true;
        else                                                                    return false;
    }
    
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
