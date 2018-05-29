
package gametools;


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
