
/** required package class namespace */
package year2018.cs30s.moregaming.survivor;

import year2018.cs30s.gametools.GameObject;
import year2018.cs30s.gametools.Image;

/**
 * Wall.java - description here...
 *
 * @author Mr. Wachs (login: lawrence.wachs)
 * @since Jun 7, 2018 
 * @instructor Mr. Wachs
 */
public class Wall extends GameObject
{

    public Wall(Image image) {
        super(image);        
        setDebug(Constants.WALL_TEXT, Constants.WALL_COLOR);
    }

}
