
package year2018.cs32s.pacman;

import gametools.Directions;
import gametools.GameCharacter;
import gametools.Image;

public class Ghost extends GameCharacter
{
      
    public Ghost(Image image) {        
        super(image, Directions.STOP, 100, 100);
    }

    @Override
    public void action() {
        
    }

    
}
