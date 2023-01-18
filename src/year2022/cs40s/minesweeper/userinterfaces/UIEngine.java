
/** Required package class namespace */
package year2022.cs40s.minesweeper.userinterfaces;


/** Required API imports */
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static javax.swing.SwingConstants.CENTER;
import year2022.cs40s.minesweeper.logic.MineSweeperLogic;

 
/**
 * UIEngine.java - this class runs all the logic for this game. It received
 * references from the other class to modify those objects from this class.
 * 
 * @author Mr. Wachs
 * @since 9-Mar-2022, 7:52:42 AM
 */
public class UIEngine 
{
    
    private MineSweeperLogic logic;
    
    private UI      userInteface;   // Reference to the "view" (user interface)
    private JButton generateButton; // Reference to the button to generate
    private JLabel  statusLabel;    // Reference to the label to update status
    private JPanel  gamePanel;      // Reference to the panel for labels
    
    private JLabel[][] matrix;        // A 2D array of JLabel objects
    
    private final int    WIDTH              = 50;            // Label's width
    private final int    HEIGHT             = WIDTH;         // Label's size    
    private final String CELL_FONT_NAME     = "Arial";  
    private final int    CELL_FONT_SIZE     = WIDTH / 2;   
    private final Color  CELL_BACKGROUND    = Color.white;   // Label background
    private final Color  CELL_BORDER        = Color.gray;    // Label border
    private final Color  CELL_BOMB          = Color.red;     // Bomb fill color
    private final Color  CELL_REVEAL_BOMB   = Color.magenta; // revealed label's
    private final Color  CELL_REVEAL_NUMBER = Color.cyan;    // fill colors 
    private final Color  CELL_REVEAL_BLANK  = Color.yellow;
    private final Color  CELL_REVEAL_FLAG   = Color.orange;    
    private final Font   CELL_FONT          = new Font(CELL_FONT_NAME, 
                                                       Font.BOLD, 
                                                       CELL_FONT_SIZE);
    
    /**
     * Constructor for the class, sets class property data
     * 
     * @param userInteface the "view" (user interface)
     * @param generateButton the button to generate
     * @param statusLabel the label to update status
     * @param gamePanel the panel to draw labels inside of
     */
    public UIEngine(
            UI      userInteface, 
            JButton generateButton,
            JLabel  statusLabel,
            JPanel  gamePanel) {
        this.userInteface   = userInteface;     // Connect this class (engine)
        this.generateButton = generateButton;   // to the other class (view)
        this.statusLabel    = statusLabel;      // or "form" references
        this.gamePanel      = gamePanel;
        setMatrix();                              // Setup the label matrix
        userInteface.setResizable(false);           // Form not sizable
        userInteface.setLocationRelativeTo(null);   // Center form on screen
        userInteface.setVisible(true);              // Show form to user
    }

    /**
     * Method connected to the UI button to generate a new matrix
     */
    public void generate() {
        logic.newMatrix();
        clearMatrix();                                    // Clear the design
        renderMatrix();
    }

    private void renderMatrix() {
        for (int row = 0; row < logic.rows; row++) {
            for (int column = 0; column < logic.columns; column++) {
                matrix[row][column].setBackground(CELL_BACKGROUND);   // Color
                if (logic.revealedCells[row][column] == logic.SHOW) {
                    if (logic.matrix[row][column].equals(logic.BOMB)) {
                        matrix[row][column].setBackground(CELL_REVEAL_BOMB);
                        matrix[row][column].setText(logic.BOMB);
                    }
                    else if (logic.matrix[row][column].equals(logic.BLANK)) {
                        matrix[row][column].setBackground(CELL_REVEAL_BLANK);
                        matrix[row][column].setText(logic.BLANK);
                    }
                    else if (logic.matrix[row][column].equals(logic.FLAG)) {
                        matrix[row][column].setBackground(CELL_REVEAL_FLAG);
                        matrix[row][column].setText(logic.FLAG);
                    }
                    else {
                        matrix[row][column].setBackground(CELL_REVEAL_NUMBER);
                        matrix[row][column].setText(logic.matrix[row][column]);
                    }                
                }
                else {
                    matrix[row][column].setBackground(CELL_BACKGROUND);
                    matrix[row][column].setText(logic.EMPTY);
                }
            }
        }
    }
    
    /**
     * Initialize all label objects in the matrix
     */
    private void setMatrix() {
        // Get the size of the panel to draw inside of, and calculate how many
        // labels (based on their sizes) we can have in each row/column
        int rows    = gamePanel.getHeight() / HEIGHT;
        int columns = gamePanel.getWidth()  / WIDTH;
        // Instantiate the matrices
        matrix   = new JLabel[rows][columns];
        // Now loop through and build all the labels each at a (x,y) location
        int y = 0;                                      
        // Traverse all the rows
        for (int row = 0; row < rows; row++) {
            int x = 0;
            // Traverse all the columns
            for (int column = 0; column < columns; column++) {
                createLabel(row, column, x, y);
                // Move x location past this label
                x += WIDTH;
            }
            // Move y location past this row for the next row
            y += HEIGHT;
        }  
        logic = new MineSweeperLogic(rows,columns);
    }
    
    /**
     * Creates a label object at this location in the matrix on the panel
     * of the passed size
     * 
     * @param row the row in the matrix for the label
     * @param column the column in the matrix for the label
     * @param x the x coordinate to draw the label in the panel
     * @param y the y coordinate to draw the label in the panel 
     */
    private void createLabel(int row, int column, int x, int y) {
        matrix[row][column] = new JLabel();             // Create label
        gamePanel.add(matrix[row][column]);             // Add label to panel
        matrix[row][column].setOpaque(true);            // Make color fillable
        matrix[row][column].setBackground(CELL_BACKGROUND); // Starting color
        matrix[row][column].setHorizontalAlignment(CENTER); // Align text
        matrix[row][column].setFont(CELL_FONT);
        matrix[row][column].setBorder(BorderFactory.createLineBorder(
                CELL_BORDER, 1));                           // Label border
        matrix[row][column].addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                mouseClick(row, column, e);                // Mouse click event
            }
            public void mousePressed(MouseEvent e)  { }
            public void mouseReleased(MouseEvent e) { }
            public void mouseEntered(MouseEvent e)  { }
            public void mouseExited(MouseEvent e)   { }
        });
        matrix[row][column].setBounds(x, y, WIDTH, HEIGHT); // Position label
    }
    
    /**
     * When the user clicks on a spot of the matrix, react
     */
    private void mouseClick(int row, int column, MouseEvent event) {
        String text = logic.click(row, column, event);
        statusLabel.setText(text);
        renderMatrix();
    }

    /**
     * Clears the label matrix for a new generation
     */
    private void clearMatrix() {
        for (int row = 0; row < logic.rows; row++) {        // Traverse rows and
            for (int column = 0; column < logic.columns; column++) { // columns
                matrix[row][column].setBackground(CELL_BACKGROUND);   // Color
                matrix[row][column].setText(logic.BLANK);
            }
        }
    }
        
}