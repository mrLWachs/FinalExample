
package year2018.cs30s.findprize;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static javax.swing.SwingConstants.CENTER;

public class MainScreen extends JFrame
{

    public JLabel[][] grid;
    
    
    public MainScreen() {
        Globals.initFrame(Globals.MAIN_SCREEN,this);
        setControls();
        setActions();
    }

    private void setControls() {
        int x = Globals.GRID_HORIZONTAL_SPACER;
        int y = Globals.GRID_VERTICAL_SPACER;
        grid = new JLabel[Globals.gridRows][Globals.gridColumns];
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
            x = Globals.GRID_HORIZONTAL_SPACER;
            y += Globals.gridHeight;
        }
        setBackground(Color.white);
        getContentPane().setBackground(Color.white);
    }

    private void setActions() {
        addKeyListener(new KeyListener()
        {
            @Override
            public void keyTyped(KeyEvent e) { }
            @Override
            public void keyPressed(KeyEvent e) {
                Globals.engine.keyPress(e);
            }
            @Override
            public void keyReleased(KeyEvent e) { }
        });
    }
        
}
