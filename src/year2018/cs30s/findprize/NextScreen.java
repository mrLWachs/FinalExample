
package year2018.cs30s.findprize;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static javax.swing.SwingConstants.CENTER;


public class NextScreen extends JFrame
{

    private JLabel text;
    private JButton back;
    
    public NextScreen() {
        Globals.initFrame(Globals.NEXT_SCREEN,this);
        setControls();
        setActions();
    }

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

    private void setActions() {
        back.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                backClick();
            }
        });
        back.addKeyListener(new KeyListener()
        {
            public void keyTyped(KeyEvent e) {    }
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    backClick();
                }
            }
            public void keyReleased(KeyEvent e) {  }
        });
        this.addKeyListener(new KeyListener()
        {
            public void keyTyped(KeyEvent e) {    }
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    backClick();
                }
            }
            public void keyReleased(KeyEvent e) {  }
        });
    }
    
    private void backClick() {
        Globals.main.setVisible(true);
        Globals.next.setVisible(false);
    }
    
}
