
/** required package class namespace */
package year2018.cs30s.gametools;

import java.awt.Color;

/**
 * GameObject.java - represents a typical object in a game
 *
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public class GameObject 
{
    /**
     * Coordinates to store data on position and movement
     */
    protected Coordinate coordinate;
    
    /**
     * Visual picture image used on a user interface
     */
    protected Image image;
    
    /**
     * Flag determines if this object is alive in a game
     */
    protected boolean isAlive;
    
    
    /**
     * Constructor for the class sets class data
     * 
     * @param x the x coordinate
     * @param y the y coordinate
     * @param width the width coordinate
     * @param height the height coordinate
     */
    public GameObject(int x, int y, int width, int height) {
        this.image        = null;                     // assign parameter to property
        coordinate        = new Coordinate();     // assign parameter to property
        coordinate.x      = x;
        coordinate.y      = y;
        coordinate.width  = width;
        coordinate.height = height;        
        coordinate.recalculate();
        isAlive           = true;                      // set object to be alive
    }
    
    /**
     * Constructor for the class sets class data
     * 
     * @param image picture image used on a user interface
     */
    public GameObject(Image image) {
        this.image = image;                     // assign parameter to property
        coordinate = new Coordinate(image);     // assign parameter to property
        isAlive    = true;                      // set object to be alive
    }
    
    /**
     * Determines if this game character is colliding with a game object
     * 
     * @param target the game object to check for collision with
     * @return it is colliding (true) or not (false)
     */
    public boolean isColliding(GameObject target) {
        if (!target.isAlive) return false;                      // do not check
        return coordinate.isOverlapping(target.coordinate);
    }
    
    /**
     * Shows the game object in the user interface
     */
    public void show() {
        isAlive = true;
        image.show();
    }
    
    /**
     * hides the game object in the user interface
     */
    public void hide() {
        isAlive = false;
        image.hide();
    }
   
    /**
     * Sets the game object to debug mode, meaning it removes any graphics and
     * changes to a colored rectangle with text
     * 
     * @param text the text to display in the image
     * @param background the background color of the image
     */
    public void setDebug(String text, Color background) {
        image.setDebug(text, background);
    }
    
    /**
     * Accesses the background color of the game object
     * 
     * @return the game object's background color
     */
    public Color getBackground() {
        return image.getBackground();
    }
    
    
    public boolean isAbove(GameObject target) {
        return coordinate.isAbove(target.coordinate);
    }
    
    
    public boolean isBelow(GameObject target) {
        return coordinate.isBelow(target.coordinate);
    }
    
    
    public boolean isRightOf(GameObject target) {
        return coordinate.isRightOf(target.coordinate);
    }
    
    
    public boolean isLeftOf(GameObject target) {
        return coordinate.isLeftOf(target.coordinate);
    }
    
    public void setBorder(boolean haveBorder) {
        image.setBorder(haveBorder);
    }
    
}
