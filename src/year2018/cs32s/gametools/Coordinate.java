
/** required package class namespace */
package year2018.cs32s.gametools;

/**
 * XXX.java - 
 *
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public class Coordinate 
{
    // properties:
    
    public int x,y,width,height,
               left,right,top,bottom,
               amount,direction;
    
    public Image hitbox;
    
    // methods:
    
    public Coordinate(Image hitbox) {
        this.hitbox = hitbox;
        direction   = Directions.STOP;
        amount      = Directions.STOP;
        update();
    }
    
    public Coordinate(Image hitbox,
                      int direction,
                      int amount) {
        this.hitbox    = hitbox;
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
        
    public void moveUp() {
        y = y - amount;
        recalculate();
    }
    
    public void moveDown() {
        y = y + amount;
        recalculate();
    }
    
    public void moveLeft() {
        x = x - amount;
        recalculate();
    }
    
    public void moveRight() {
        x = x + amount;
        recalculate();
    }
    
    public void moveNorth() {
        moveUp();
    }
    
    public void moveSouth() {
        moveDown();
    }
    
    public void moveEast() {
        moveRight();
    }
    
    public void moveWest() {
        moveLeft();
    }
    
    public void moveNorthEast() {
        moveNorth();
        moveEast();
    }
    
    public void moveNorthWest() {
        moveNorth();
        moveWest();
    }

    public void moveSouthEast() {
        moveSouth();
        moveEast();
    }
    
    public void moveSouthWest() {
        moveSouth();
        moveWest();
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
    
    public boolean isOverLapping(Coordinate target) {
        if (isOverlappingVertically(target) && 
            isOverlappingHorizontally(target)) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public void move() {
        if      (direction == Directions.UP)         moveUp();
        else if (direction == Directions.DOWN)       moveDown();
        else if (direction == Directions.LEFT)       moveLeft();
        else if (direction == Directions.RIGHT)      moveRight();        
        else if (direction == Directions.NORTH)      moveNorth();
        else if (direction == Directions.NORTH_EAST) moveNorthEast();
        else if (direction == Directions.EAST)       moveEast();
        else if (direction == Directions.SOUTH_EAST) moveSouthEast();
        else if (direction == Directions.SOUTH)      moveSouth();
        else if (direction == Directions.SOUTH_WEST) moveSouthWest();
        else if (direction == Directions.WEST)       moveWest();
        else if (direction == Directions.NORTH_WEST) moveNorthWest();        
    }
    
    public int randomDirection(int numberOfDirections) {
        double random = (numberOfDirections) * Math.random() + 1;
        if (numberOfDirections == 2) {
            if      (random == 1) return Directions.LEFT;
            else if (random == 2) return Directions.RIGHT;
        }
        else if (numberOfDirections == 4) {
            if      (random == 1) return Directions.UP;
            else if (random == 2) return Directions.DOWN;
            else if (random == 3) return Directions.LEFT;
            else if (random == 4) return Directions.RIGHT;
        }
        else if (numberOfDirections == 8) {
            if      (random == 1) return Directions.NORTH;
            else if (random == 2) return Directions.NORTH_EAST;
            else if (random == 3) return Directions.EAST;
            else if (random == 4) return Directions.SOUTH_EAST;
            else if (random == 5) return Directions.SOUTH;
            else if (random == 6) return Directions.SOUTH_WEST;
            else if (random == 7) return Directions.WEST;
            else if (random == 8) return Directions.NORTH_WEST;
        }
        return Directions.STOP;
    }
    
}
