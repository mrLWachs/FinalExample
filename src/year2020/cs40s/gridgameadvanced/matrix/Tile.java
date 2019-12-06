
/** required package class namespace */
package year2020.cs40s.gridgameadvanced.matrix;

import java.awt.Color;
import java.awt.Container;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;
import year2020.cs40s.gridgameadvanced.Constants;
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
    private final Border BORDER     = BorderFactory.createEtchedBorder();
    private final Color  BACKGROUND = Color.LIGHT_GRAY;

    public Tile(Container container, int x, int y, int width, int height) {
        super(null, 0, Directions.STOP, Directions.FOUR_DIRECTIONS);
        image = new JLabel();
        container.add(image);
        image.setBounds(x, y, width, height);
        image.setBorder(BORDER);
        image.setOpaque(true);
        image.setBackground(BACKGROUND);
        image.setText("X");
        image.setFont(Constants.COMPONENT_FONT);
    }

    public void draw(int type) {
        this.type = type;
        canWalk = Types.CAN_WALK[type];
    }
    
}
