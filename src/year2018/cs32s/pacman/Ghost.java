
/** required package class namespace */
package year2018.cs32s.pacman;

/** required imports */
import year2018.cs32s.gametools.Directions;
import year2018.cs32s.gametools.GameCharacter;
import year2018.cs32s.gametools.Image;

/**
 * XXX.java - 
 *
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public class Ghost extends GameCharacter
{
      
    public Ghost(Image image) {        
        super(image, Directions.STOP, 100, 100);
    }

    @Override
    public void action() {
        
    }

    
}
