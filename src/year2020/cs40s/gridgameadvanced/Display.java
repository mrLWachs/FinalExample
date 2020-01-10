
/** required package class namespace */
package year2020.cs40s.gridgameadvanced;

import javax.swing.JPanel;
import year2020.cs40s.gridgameadvanced.matrix.SmallMatrix;
import year2020.cs40s.gridgameadvanced.matrix.Tile;
import year2020.cs40s.gridgameadvanced.matrix.Types;

 
/**
 * Display.java - description
 *
 * @author Mr. Wachs
 * @since Nov. 29, 2019, 3:30:23 p.m.
 */
public class Display 
{
    
    private Map map;
    
    public JPanel panel;
    public SmallMatrix matrix;
    
    
    public Display(JPanel panel, Map map) {
        this.panel = panel;
        this.map   = map;
        matrix     = new SmallMatrix(panel,map);
        update();
    }

    public void update() {
        for (int row = 0; row < matrix.rows; row++) {
            for (int column = 0; column < matrix.columns; column++) {
                Tile tile = matrix.get(row, column);
                tile.draw(Types.random());
            }
        }
    }

}
