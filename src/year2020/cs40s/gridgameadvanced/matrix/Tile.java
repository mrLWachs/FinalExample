
/** required package class namespace */
package year2020.cs40s.gridgameadvanced.matrix;

import java.awt.Color;
import java.awt.Container;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;
import year2020.cs40s.gridgameadvanced.Constants;

 
/**
 * Tile.java - description
 *
 * @author Mr. Wachs
 * @since Dec. 4, 2019, 3:17:27 p.m.
 */
public class Tile extends JLabel
{
    
    public int type;
    public boolean canWalk;
    
    private final Border BORDER     = BorderFactory.createEtchedBorder();
    private final Color  BACKGROUND = Color.LIGHT_GRAY;
    
    /**
     * Default constructor, set class properties
     */
    public Tile(Container container, int x, int y, int width, int height) {
        container.add(this);
        setBounds(x, y, width, height);
        setBorder(BORDER);
        setOpaque(true);
        setBackground(BACKGROUND);
        setText("X");
        setFont(Constants.COMPONENT_FONT);
    }
    
    public void draw(int type) {
        this.type = type;
        canWalk = Types.CAN_WALK[type];
    }
    
}
