
/** required package class namespace */
package year2018.cs32s.gametools;

/**
 * GameObject.java - represents a typical object in a game
 *
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public class GameObject 
{
    
    // properties:
    public Coordinate coordinate;
    public Image      image;
    public boolean    isAlive;
    
    // methods:
    
    public GameObject(Image image) {
        this.image = image;
        coordinate = new Coordinate(image);
        isAlive    = true;
    }
   
}
