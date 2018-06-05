
/** required package class namespace */
package year2018.cs40s.findprize;

/** required imports */
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static javax.swing.SwingConstants.CENTER;

/**
 * NextScreenUI.java - the next user interface for the find prizes game
 *
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public class NextScreenUI extends JFrame
{

    private JLabel text;
    private JButton back;
    
    /**
     * Default constructor sets class properties
     */
    public NextScreenUI() {
        Globals.initFrame(Globals.NEXT_SCREEN,this);    // initiallizes frame
        setControls();                                  // sets UI controls
        setActions();                                   // sets user actions
    }

    /**
     * Sets all user interface controls into locations and look and feel
     */
    private void setControls() {  
        int controlWidth = Globals.NEXT_FRAME_WIDTH - 
                (Globals.FRAME_HORIZONTAL_SPACER * 2);
        int controlHeight = (Globals.NEXT_FRAME_HEIGHT / 2) - 
                (Globals.FRAME_VERTICAL_SPACER * 2);        
        text = new JLabel("Go Back");   
        back = new JButton("BACK");
        text.setHorizontalAlignment(CENTER); 
        text.setForeground(Color.white);
        getContentPane().add(text);
        getContentPane().add(back);
        int x = Globals.FRAME_HORIZONTAL_SPACER;
        int y = Globals.FRAME_VERTICAL_SPACER;
        text.setBounds(x, y, controlWidth, controlHeight);
        y = y + controlHeight + Globals.FRAME_HORIZONTAL_SPACER;
        back.setBounds(x, y, controlWidth, controlHeight);                
    }

    /**
     * Sets user keyboard and button click actions
     */
    private void setActions() {
        back.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                goBack(null);
            }
        });
        back.addKeyListener(new KeyListener()
        {
            public void keyTyped(KeyEvent e) {    }
            public void keyPressed(KeyEvent e) { goBack(e); }
            public void keyReleased(KeyEvent e) {  }
        });
        this.addKeyListener(new KeyListener()
        {
            public void keyTyped(KeyEvent e) {    }
            public void keyPressed(KeyEvent e) { goBack(e); }
            public void keyReleased(KeyEvent e) {  }
        });
    }
    
    /**
     * Goes back to the main screen
     * 
     * @param event the keyboard user event to check
     */
    private void goBack(KeyEvent event) {
        if (event == null || event.getKeyCode() == KeyEvent.VK_ENTER) {
            Globals.main.setVisible(true);
            Globals.next.setVisible(false);
        }
    }
    
}
