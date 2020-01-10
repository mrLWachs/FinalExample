
/** required package class namespace */
package year2020.cs40s.gridgameadvanced.matrix;

import java.awt.Color;
import java.awt.Container;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;
import year2020.cs40s.gridgameadvanced.Updater;
import year2020.cs40s.gridgameadvanced.tools.Directions;
import year2020.cs40s.gridgameadvanced.tools.GameObject;

 
/**
 * Tile.java - description
 *
 * @author Mr. Wachs
 * @since Dec. 4, 2019, 3:17:27 p.m.
 */
public class Tile extends GameObject
{
        
    public int type;
    public boolean canWalk;
    
    private JLabel image;
    private final Border BORDER = null; //BorderFactory.createLineBorder(Color.DARK_GRAY,1,false); // null; 
    private final Color  GRASS  = Color.GREEN;
    private final Color  WATER  = Color.BLUE;
    private final Color  ROCK   = Color.LIGHT_GRAY;
    private final Color  SAND   = Color.PINK;
    
    public Tile(Container container, int x, int y, int width, int height) {
        super(null, 0, Directions.STOP, Directions.FOUR_DIRECTIONS);
        image = new JLabel();
        container.add(image);
        image.setBounds(x, y, width, height);
        image.setBorder(BORDER);
        image.setOpaque(true);
        image.setBackground(GRASS);        
    }

    public void draw(int type) {
        this.type = type;
        canWalk = Types.CAN_WALK[type];
        if      (type == Types.GRASS) image.setBackground(GRASS);
        else if (type == Types.WATER) image.setBackground(WATER);
        else if (type == Types.ROCK)  image.setBackground(ROCK);
        else if (type == Types.SAND)  image.setBackground(SAND);     
    }
    
}
