
/** required package class namespace */
package year2020.cs40s.gridgameadvanced;

import javax.swing.JPanel;
import year2020.cs40s.gridgameadvanced.matrix.LargeMatrix;
import year2020.cs40s.gridgameadvanced.matrix.Types;

 
/**
 * Map.java - description
 *
 * @author Mr. Wachs
 * @since Nov. 29, 2019, 3:30:31 p.m.
 */
public class Map 
{

    private JPanel panel;
    
    public LargeMatrix matrix;
            
    public final int MAX_ROWS    = 49; //200; //50;
    public final int MAX_COLUMNS = 40; //190; //40;
    
    
    
    public Map(JPanel panel) {
        this.panel = panel;
        matrix = new LargeMatrix(MAX_ROWS, MAX_COLUMNS, panel);
        update();
    }
    
    public void update() {
        for (int row = 0; row < MAX_ROWS; row++) {
            for (int column = 0; column < MAX_COLUMNS; column++) {
                matrix.get(row, column).draw(Types.random());
            }
        }
    }

}
