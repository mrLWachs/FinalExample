
package year2020.cs40s.gridgame;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Tile 
{
    
    public JLabel tile;
    public int    width;
    public int    height;
    
    
    public Tile(int width, int height, 
                int x, int y, 
                JFrame frame) {
        tile = new JLabel();
        frame.getContentPane().add(tile);
        tile.setBorder(Types.TILE_BORDER);
        tile.setBounds(x, y, width, height);
        tile.setOpaque(true);
    }

    public void set(Color color) {
        tile.setBackground(color);
    }
    
}
