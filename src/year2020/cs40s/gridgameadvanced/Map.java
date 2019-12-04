
/** required package class namespace */
package year2020.cs40s.gridgameadvanced;

import javax.swing.JPanel;
import year2020.cs40s.gridgameadvanced.matrix.LargeMatrix;

 
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
            
    
    public Map(JPanel panel) {
        this.panel = panel;
        matrix = new LargeMatrix(50, 40, panel);
    }
    
    public void update() {
    }

}
