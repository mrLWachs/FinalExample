
package gametools;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public abstract class GameCharacter extends GameObject
{
    
    private Timer timer;

    public GameCharacter(Image image,
                         int direction,
                         int amount,
                         int delay) {
        super(image);
        super.coordinate = new Coordinate(image, 
                direction, amount);
        timer = new Timer(delay, new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                action();
            }
        });
        timer.start();        
    }

    public abstract void action();
    
    public void redraw() {
        image.redraw(coordinate);
    }
    
    public void move() {
        coordinate.move();
    }
    
    public boolean isColliding(GameObject target) {
        if (isAlive && target.isAlive) {
            return coordinate.isOverLapping(target.coordinate);
        }
        else {
            return false;
        }
    }
    
    public void stickTo(GameObject target) {
        if (coordinate.direction == Directions.UP) {
            coordinate.y = target.coordinate.bottom + 1;
        }
        else if (coordinate.direction == Directions.DOWN) {
            coordinate.y = target.coordinate.top - coordinate.height - 1;
        }
        else if (coordinate.direction == Directions.LEFT) {
            coordinate.x = target.coordinate.right + 1;
        }
        else if (coordinate.direction == Directions.RIGHT) {
            coordinate.x = target.coordinate.left - coordinate.width - 1;
        }
        coordinate.recalculate();
    }
    
    public void bounceOff(GameObject target) {
        stickTo(target);
        if (coordinate.direction == Directions.UP) {
            coordinate.direction = Directions.DOWN;
        }
        else if (coordinate.direction == Directions.DOWN) {
            coordinate.direction = Directions.UP;
        }
        else if (coordinate.direction == Directions.LEFT) {
            coordinate.direction = Directions.RIGHT;
        }
        else if (coordinate.direction == Directions.RIGHT) {
            coordinate.direction = Directions.LEFT;
        }
    }
    
    public void randomDirection(int numberOfDirections) {
        coordinate.randomDirection(numberOfDirections);
    }
   
}
