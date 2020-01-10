
/** required package class namespace */
package year2020.cs40s.gridgameadvanced.matrix;

import java.awt.Container;

 
/**
 * Matrix.java - description
 *
 * @author Mr. Wachs
 * @since Jan. 7, 2020, 12:19:39 p.m.
 */
public class Matrix 
{

    private Tile[][] matrix;
    private Container container;
    
    /**
     * Default constructor, set class properties
     */
    public Matrix(Container container) {
        this.container = container;
    }
    
    public void init(int rows, int columns) {
        final int ADJUST     = 1;
        int largeWidth       = container.getWidth()  - ADJUST;
        int largeHeight      = container.getHeight() - ADJUST;
        matrix               = new Tile[rows][columns];
        int width            = (largeWidth  / columns);
        int height           = (largeHeight / rows);        
        int verticalSpacer   = ((largeHeight - (height * rows))    / 2) + ADJUST;
        int horizontalSpacer = ((largeWidth  - (width  * columns)) / 2) + ADJUST;
        int y                = verticalSpacer;
        for (int row = 0; row < rows; row++) {
            int x = horizontalSpacer;
            for (int column = 0; column < columns; column++) {
                matrix[row][column] = new Tile(container, x, y, width, height);
                x += width;
            }
            y += height;
        }
    }
    
    public Tile get(int row, int column) {
        if (row    < 0 || row    >= matrix.length)    return null;
        if (column < 0 || column >= matrix[0].length) return null;
        else return matrix[row][column];
    }
    
}
