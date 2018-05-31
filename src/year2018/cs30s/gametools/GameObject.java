
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
     * @param image picture image used on a user interface
     */
    public GameObject(Image image) {
        this.image = image;                     // assign parameter to property
        coordinate = new Coordinate(image);     // assign parameter to property
        isAlive    = true;                      // set object to be alive
    }
    
    /**
     * Shows the game object in the user interface
     */
    public void show() {
        image.show();
    }
    
    /**
     * hides the game object in the user interface
     */
    public void hide() {
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
    
}
