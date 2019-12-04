
/** required package class namespace */
package year2020.cs40s.gridgameadvanced.matrix;

import java.awt.Container;

 
/**
 * LargeMatrix.java - description
 *
 * @author Mr. Wachs
 * @since Dec. 4, 2019, 8:21:17 a.m.
 */
public class LargeMatrix 
{

    private Tile[][] matrix;
    
    /**
     * Default constructor, set class properties
     */
    public LargeMatrix(int rows, int columns, Container container) {
        int largeWidth  = container.getWidth();
        int largeHeight = container.getHeight();
        matrix = new Tile[rows][columns];
        int width  = (largeWidth  / columns);
        int height = (largeHeight / rows);
        int verticalSpacer   = ((largeHeight - (height * rows))    / 2) + 1;
        int horizontalSpacer = ((largeWidth  - (width  * columns)) / 2) + 1;
        int y = verticalSpacer;
        for (int row = 0; row < rows; row++) {
            int x = horizontalSpacer;
            for (int column = 0; column < columns; column++) {
                matrix[row][column] = new Tile(container, x, y, width, height);
                x += width;
            }
            y += height;
        }
    }
   
}
