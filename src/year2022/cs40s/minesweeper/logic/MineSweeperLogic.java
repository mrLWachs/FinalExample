
/** Required package class namespace */
package year2022.cs40s.minesweeper.logic;

import java.awt.event.MouseEvent;
import year2020.cs40s.awards.tools.Numbers;

 
/**
 * MineSweeperLogic.java - description
 *
 * @author Mr. Wachs
 * @since 16-Mar-2022, 8:55:29 AM
 */
public class MineSweeperLogic 
{
    
    public String[][] matrix;      // A 2D array to store values for the labels
    public boolean[][] revealedCells;  // A 2D array to store values for the labels
    
    public int rows;               // The number of rows for the matrix
    public int columns;            // The number of columns for the matrix
  
    public final String  BOMB  = "X";              // Bomb cell text
    public final String  BLANK = ".";               // Blank cell text
    public final String  EMPTY = "";               // Blank cell text
    public final String  FLAG  = "F";              // Flagged cell text
    public final boolean HIDE  = false;
    public final boolean SHOW  = true;
    
    private final double RATIO          = 4.85;            // Ratio of labels
    private final int    INVALID_NUMBER = -1;               // Invalid number
    
    
    /**
     * Constructor for the class, sets class property data
     * 
     * @param rows the total rows in the matrix 
     * @param columns the columns in the matrix 
     */
    public MineSweeperLogic(int rows, int columns) {
        this.rows    = rows;                        // Set class properties
        this.columns = columns;                     // to parameters
        newMatrix();
    }

    /**
     * Generates a new empty grid 
     */
    private void clearMatrix() {
        matrix        = new String[rows][columns];          // Instantiate the  
        revealedCells = new boolean[rows][columns];         // matricies
        for (int row = 0; row < rows; row++) {      // Traverse all the rows
            for (int column = 0; column < columns; column++) {   // and columns
                matrix[row][column]        = EMPTY;         // Set to blanks
                revealedCells[row][column] = HIDE;          // Set to hide
            }
        }
    }
    
    /**
     * Generate a new matrix with randomly placed bombs
     */
    public String newMatrix() {
        clearMatrix();
        // Calculate the number of bombs based on the size of the matrix
        int numberOfBombs = (int)(((double)(rows * columns)) / RATIO);
        Numbers numbers = new Numbers();    // Class to newMatrix randoms
        int randomRow    = 0;               // Variables for random locations
        int randomColumn = 0;
        for (int i = 0; i < numberOfBombs; i++) {   // Traverse all bombs
            do {                                    // Loop while spot occupied
                randomRow    = numbers.random(0, rows-1);       // Random row
                randomColumn = numbers.random(0, columns-1);    // and column
            } while (matrix[randomRow][randomColumn].equals(BOMB) &&
                     isCenterCell(randomRow,randomColumn));
            matrix[randomRow][randomColumn] = BOMB;     // Set bomb spot
        }
        countNeighbours();                              // Count all neighbors
        return "Generated new (" + rows + " by " + columns + ") matrix "
                + "with " + numberOfBombs + " bombs randomly placed";
    }

    /**
     * When the user clicks on a spot of the grid, react
     */
    public String click(int row, int column, MouseEvent event) {
        String text = "Clicked cell (" + row + ", " + column + ")";
        if (event.getButton() == MouseEvent.BUTTON3) {
            if (matrix[row][column] == FLAG) {
                text += " removing flag!";
                matrix[row][column] = EMPTY;
                revealedCells[row][column] = HIDE;
            }
            else {
                text += " planting flag!";
                matrix[row][column] = FLAG;
                revealedCells[row][column] = SHOW;
            }
        }
        else {
            revealedCells[row][column] = SHOW;
            if (matrix[row][column].equals(BOMB)) {    // Bomb spot
                matrix[row][column] = BOMB;
                text += " found bomb!";
                revealAllMines();
            }
            else if (reveal(row, column) == false) {
                // If the spot is a number, just reveal that spot
                text += " found number!";
            }
            else {
                // spot is a blank, reveal all spots around it
                text += " found blank, revealing all blanks!";
                boolean[][] checked = new boolean[rows][columns];
                revealCheck(row, column, checked);
            } 
        }
        return text;
    }
    
    /**
     * Traverse the matrix and count the number of neighbors that are bombs 
     * around each cell
     */
    private void countNeighbours() {
        for (int row = 0; row < rows; row++) {                  // Traverse rows
            for (int column = 0; column < columns; column++) {  // and columns
                // Count spots of cells next to bombs, but not the bomb spots
                if (matrix[row][column].equals(BOMB) == false) {
                    int bombCount = count(row,column);            // Count bombs
                    if (bombCount > 0) {                          // Not zero
                        matrix[row][column] = "" + bombCount;
                    }
                }
            }
        }
    }

    /**
     * Counts the number of neighbors that are bombs around this cell
     * 
     * @param row the row in the matrix for the label
     * @param column the column in the matrix for the label
     * @return the count of bombs around this cell
     */
    private int count(int row, int column) {
        // spots to check      coordinates of those spots
        // +---+---+---+    +---------+---------+---------+
        // | 1 | 2 | 3 |    | r-1,c-1 | r-1,c   | r-1,c+1 |
        // +---+---+---+    +---------+---------+---------+
        // | 4 | X | 5 |    | r  ,c-1 | r  ,c   | r  ,c+1 |
        // +---+---+---+    +---------+---------+---------+
        // | 6 | 7 | 8 |    | r+1,c-1 | r+1,c   | r+1,c+1 |
        // +---+---+---+    +---------+---------+---------+
        
        int r     = row;                            // Temporary variables for
        int c     = column;                         // row and column
        int count = 0;                              // Start a count
        r = row - 1;                                // Check row above..........
        if (rowIsInBounds(r)) {                     // Not outside grid
            c = column - 1;                         // Check spot #1
            if (columnIsInBounds(c)) {              // Not outside grid
                if (matrix[r][c].equals(BOMB)) count++; 
            }
            c = column;                             // Check spot #2
            if (matrix[r][c].equals(BOMB)) count++; 
            c = column + 1;                         // Check spot #3
            if (columnIsInBounds(c)) {              // Not outside grid
                if (matrix[r][c].equals(BOMB)) count++;  
            }
        }
        r = row;                                    // Check the same row.......
        c = column - 1;                             // Check spot #4
        if (columnIsInBounds(c))  {                 // Not outside grid
            if (matrix[r][c].equals(BOMB)) count++;  
        }
        c = column + 1;                             // Check spot #5
        if (columnIsInBounds(c))  {                 // Not outside grid
            if (matrix[r][c].equals(BOMB)) count++;  
        }
        r = row + 1;                                // Check row below..........
        if (rowIsInBounds(r)) {                     // Not outside grid
            c = column - 1;                         // Check spot #6
            if (columnIsInBounds(c)) {              // Not outside grid
                if (matrix[r][c].equals(BOMB)) count++; 
            }
            c = column;                             // Check spot #7
            if (matrix[r][c].equals(BOMB)) count++;  
            c = column + 1;                         // Check spot #8
            if (columnIsInBounds(c)) {              // Not outside grid
                if (matrix[r][c].equals(BOMB)) count++;  
            }
        }
        return count;                               // Send back final count
    }

    /**
     * Reveals the spots around this location (row,column) as number spots
     * or blank spots
     * 
     * @param row the row in the matrix to check
     * @param column the column in the matrix to check
     * @param checked the matrix of flagged spots to check or not
     */
    private void revealCheck(int row, int column, boolean[][] checked) {
        // spots to check      coordinates of those spots
        // +---+---+---+    +---------+---------+---------+
        // | 1 | 2 | 3 |    | r-1,c-1 | r-1,c   | r-1,c+1 |
        // +---+---+---+    +---------+---------+---------+
        // | 4 | X | 5 |    | r  ,c-1 | r  ,c   | r  ,c+1 |
        // +---+---+---+    +---------+---------+---------+
        // | 6 | 7 | 8 |    | r+1,c-1 | r+1,c   | r+1,c+1 |
        // +---+---+---+    +---------+---------+---------+
        
        check(row-1,column-1,checked);      // Check spot #1
        check(row-1,column  ,checked);      // Check spot #2
        check(row-1,column+1,checked);      // Check spot #3
        check(row  ,column-1,checked);      // Check spot #4
        // DO NOT CHECK THE SAME SPOT WE ARE ON (row,column) ....
        check(row  ,column+1,checked);      // Check spot #5
        check(row+1,column-1,checked);      // Check spot #6
        check(row+1,column  ,checked);      // Check spot #7
        check(row+1,column+1,checked);      // Check spot #8
    }
    
    /**
     * Checks this spot (row,column) to make sure it is in bounds, and then
     * reveals what is at this location (a number, bomb, or blank) and 
     * recursively checks the other blank spots around it
     * 
     * @param row the row in the matrix to check
     * @param column the column in the matrix to check
     * @param checked the matrix of flagged spots to check or not
     */
    private void check(int row, int column, boolean[][] checked) {    
        // First make sure we are not out of bounds in the spot to check
        if (rowIsInBounds(row) && columnIsInBounds(column)) {
            if (checked[row][column] == true) {     // Already checked here
                return;                             // Leave method
            }       
            else {                                  // Have not checked here
                checked[row][column] = true;        // Mark spot as checked
            }
            if (reveal(row,column) == true) {       // If spot is a space
                revealCheck(row,column,checked);    // Check spots around it
            }
        }
    }

    /**
     * Checks the passed row to see if it is inside the bounds of the matrix
     * 
     * @param row the row in the matrix to check
     * @return the row is in bounds (true) or out of bounds (false)
     */
    private boolean rowIsInBounds(int row) {
        if (row <  0)    return false;              // Before first row
        if (row >= rows) return false;              // After last row
        return true;                                // Valid row
    }
    
    /**
     * Checks the passed column to see if it is inside the bounds of the matrix
     * 
     * @param column the column in the matrix to check
     * @return the column is in bounds (true) or out of bounds (false)
     */
    private boolean columnIsInBounds(int column) {
        if (column <  0)       return false;            // Before first column
        if (column >= columns) return false;            // After last column
        return true;                                    // Valid row
    }
    
    /**
     * Reveals what is at this cell location (a number, bomb, or blank) with 
     * text and a background color
     * 
     * @param row the row in the matrix to reveal
     * @param column the column in the matrix to reveal
     * @return this location is a blank (true) cell or not (false)
     */
    private boolean reveal(int row, int column) {
        revealedCells[row][column] = SHOW;
        String text   = matrix[row][column];            // Text from cell
        int    number = isNumber(text);                 // Possible number
        if (text.equals(BLANK)) {                       // Blank spot
            matrix[row][column] = BLANK;
            return true;                                // Continue revealing
        }
        else if (text.equals(EMPTY)) {                  // Blank spot
            matrix[row][column] = EMPTY;
            return true;                                // Continue revealing
        }
        else if (text.equals(BOMB)) {                   // Bomb spot
            matrix[row][column] = BOMB;
            return false;
        }
        else if (number != INVALID_NUMBER) {            // A valid number spot
            matrix[row][column] = "" + number;
            return false;
        }
        else {                                          // Error check
            return false;
        }
    }
    
    /**
     * Determines if the passed text is a valid number or not
     * 
     * @param text the text to check
     * @return the valid numbers (1-8) or not a valid number (-1) 
     */
    private int isNumber(String text) {
        if      (text == null)     return INVALID_NUMBER;
        else if (text.equals("1")) return Integer.parseInt(text);
        else if (text.equals("2")) return Integer.parseInt(text);
        else if (text.equals("3")) return Integer.parseInt(text);
        else if (text.equals("4")) return Integer.parseInt(text);
        else if (text.equals("5")) return Integer.parseInt(text);
        else if (text.equals("6")) return Integer.parseInt(text);
        else if (text.equals("7")) return Integer.parseInt(text);
        else if (text.equals("8")) return Integer.parseInt(text);
        else                       return INVALID_NUMBER;
    }

    private void revealAllMines() {
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if (matrix[row][column].equals(BOMB)) {
                    revealedCells[row][column] = SHOW;
                }
            }
        }
    }

    private boolean isCenterCell(int row, int column) {
        int centerRow    = rows    / 2;
        int centerColumn = columns / 2;
        if (row == centerRow && column == centerColumn) return true;
        return false;        
    }
    
}