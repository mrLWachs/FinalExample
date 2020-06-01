
/** required package class namespace */
package year2020.cs40s.awards.userinterfaces.controllers;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import year2020.cs40s.awards.logic.LookFactory;
import year2020.cs40s.awards.userinterfaces.LoadingView;

 
/**
 * LoadingController.java - description
 *
 * @author Mr. Wachs
 * @since 26-May-2020, 8:55:31 AM
 */
public class LoadingController 
{

    private JLabel       label;
    private JProgressBar progressBar;
    private LoadingView  userInterface;
    private Frame        parent;
    private int          milliseconds;
    
    private Timer        timer;
    
    private int count;
    
    
    public LoadingController(
            JLabel       label, 
            JProgressBar progressBar, 
            LoadingView  userInterface, 
            Frame        parent,
            int          milliseconds) {
        
        this.label         = label;
        this.progressBar   = progressBar;
        this.userInterface = userInterface;
        this.label         = label;
        this.parent        = parent;
        this.milliseconds  = milliseconds;
        
        final int WIDTH = 285;
        final int HEIGHT = 110;
        JComponent[] components = {
            label,
            progressBar
        };
        
        LookFactory.setComponents(components, userInterface, WIDTH, HEIGHT);
        
        progressBar.setMaximum(milliseconds);
        
        count = 1;
        timer = new Timer(count, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tick();
            }
        });
        timer.start();
        
        label.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) { }
            public void keyPressed(KeyEvent e) {
                end();
            }
            public void keyReleased(KeyEvent e) {  }
        });
        
        progressBar.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) { }
            public void keyPressed(KeyEvent e) {
                end();
            }
            public void keyReleased(KeyEvent e) {  }
        });
        
        userInterface.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) { }
            public void keyPressed(KeyEvent e) {
                end();
            }
            public void keyReleased(KeyEvent e) {  }
        });
        
        label.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                end();
            }
            public void mousePressed(MouseEvent e) {  }
            public void mouseReleased(MouseEvent e) {  }
            public void mouseEntered(MouseEvent e) {  }
            public void mouseExited(MouseEvent e) { }
        });
        
        progressBar.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                end();
            }
            public void mousePressed(MouseEvent e) {  }
            public void mouseReleased(MouseEvent e) {  }
            public void mouseEntered(MouseEvent e) {  }
            public void mouseExited(MouseEvent e) { }
        });
        
        userInterface.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                end();
            }
            public void mousePressed(MouseEvent e) {  }
            public void mouseReleased(MouseEvent e) {  }
            public void mouseEntered(MouseEvent e) {  }
            public void mouseExited(MouseEvent e) { }
        });
        
        userInterface.setVisible(true);
    }
    
    private void tick() {
        count++;
        if (count >= milliseconds) end();
        else progressBar.setValue(count);     
    }
    
    public void end() {
        timer.stop();
        userInterface.setVisible(false);
        userInterface.dispose();
        if (parent != null) parent.requestFocus();
    }
    
}
