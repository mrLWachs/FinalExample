

/** required package class namespace */
package year2020.cs40s.gridgameadvanced.matrix;

import javax.swing.JPanel;
import year2020.cs40s.gridgameadvanced.Map;

 
/**
 * SmallMatrix.java - description
 *
 * @author Mr. Wachs
 * @since Dec. 4, 2019, 8:21:25 a.m.
 */
public class SmallMatrix extends Matrix
{

    private Tile[][] matrix;
    
    public int rows;
    public int columns;
    public final double SCALE_FACTOR = 0.10;
    
    
    
    public SmallMatrix(JPanel panel, Map map) {
        super(panel);
        rows    = (int)(map.MAX_ROWS    * SCALE_FACTOR);
        columns = (int)(map.MAX_COLUMNS * SCALE_FACTOR);
        init(rows, columns);
    }
    
}
