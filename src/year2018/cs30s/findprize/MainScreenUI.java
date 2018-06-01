
/** required package class namespace */
package year2018.cs30s.findprize;

/** required imports */
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static javax.swing.SwingConstants.CENTER;

/**
 * MainScreenUI.java - the main user interface for the find prizes game
 *
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public class MainScreenUI extends JFrame
{

    /**
     * The two dimensional array (matrix) of JLabels
     */
    public JLabel[][] grid;
    
    
    /**
     * Default constructor sets class properties
     */
    public MainScreenUI() {
        Globals.initFrame(Globals.MAIN_SCREEN,this);    // initiallizes frame
        setControls();                                  // sets UI controls
        setActions();                                   // sets user actions
    }

    /**
     * Sets all user interface controls into locations and look and feel
     */
    private void setControls() {
        int x = Globals.GRID_HORIZONTAL_SPACER;
        int y = Globals.GRID_VERTICAL_SPACER;
        grid  = new JLabel[Globals.gridRows][Globals.gridColumns];
        for (int row = 0; row < Globals.gridRows; row++) {
            for (int column = 0; column < Globals.gridColumns; column++) {
                grid[row][column] = new JLabel();                
                getContentPane().add(grid[row][column]);  
                grid[row][column].setBorder(
                        BorderFactory.createLineBorder(Color.lightGray,1));                
                grid[row][column].setOpaque(true);
                grid[row][column].setBackground(Globals.GRID_COLOR);  
                grid[row][column].setFont(Globals.GRID_FONT);
                grid[row][column].setHorizontalAlignment(CENTER);
                grid[row][column].setBounds(x, y, 
                        Globals.gridWidth, 
                        Globals.gridHeight);                
                x += Globals.gridWidth;                
            }
            x  = Globals.GRID_HORIZONTAL_SPACER;
            y += Globals.gridHeight;
        }
        setBackground(Color.white);
        getContentPane().setBackground(Color.white);
    }

    /**
     * Sets user keyboard actions
     */
    private void setActions() {
        addKeyListener(new KeyListener()
        {
            public void keyTyped(KeyEvent e) { }
            public void keyPressed(KeyEvent e) {
                Globals.engine.keyPress(e);
            }
            public void keyReleased(KeyEvent e) { }
        });
    }
        
}
