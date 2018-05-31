
/** required package class namespace */
package year2018.cs30s.tools;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 * FrameTools.java - description here...
 *
 * @author Mr. Wachs (login: lawrence.wachs)
 * @since May 31, 2018 
 * @instructor Mr. Wachs
 */
public class FrameTools 
{

    public static void setIcon(JFrame frame, String iconFileName) {
        if (frame == null) return;
        if (iconFileName == null) return;
        ImageIcon icon = new ImageIcon(iconFileName);
        frame.setIconImage(icon.getImage());
    }
    
    public static void setBackground(JFrame frame, Color background) {
        if (frame == null) return;
        if (background != null) {
            frame.getContentPane().setBackground(background);
            frame.setBackground(background);
        }
    }
    
    /**
     * Initializes a JFrame to the set parameter values
     * 
     * @param frame the JFrame to initialize
     * @param title the frame's title
     * @param width the frame's width
     * @param height the frame's height
     */
    public static void init(JFrame frame, String title, int width, int height) {
        if (frame == null) return;
        frame.setTitle(title);
        frame.setSize(width, height);
        frame.setVisible(true);
    }    
    
    /**
     * Initializes a JFrame to the set parameter values
     * 
     * @param frame the JFrame to initialize
     * @param title the frame's title
     * @param width the frame's width
     * @param height the frame's height
     * @param resizable should the user resize the frame (true) or not (false)
     * @param isCenterScreen is the frame center screen (true) or not (false)
     * @param closeShouldEndApp should close end the app (true) or not (false)
     */
    public static void init(JFrame frame, String title, int width, int height,
                     boolean resizable, boolean isCenterScreen, 
                     boolean closeShouldEndApp) {
        if (frame == null) return;
        frame.setTitle(title);
        frame.setSize(width, height);
        frame.setResizable(resizable);
        if (isCenterScreen)    frame.setLocationRelativeTo(null);
        if (closeShouldEndApp) frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    /**
     * Initializes a JFrame to the set parameter values
     * 
     * @param frame the JFrame to initialize
     * @param title the frame's title
     * @param width the frame's width
     * @param height the frame's height
     * @param resizable should the user resize the frame (true) or not (false)
     * @param isCenterScreen is the frame center screen (true) or not (false)
     * @param closeShouldEndApp should close end the app (true) or not (false)
     * @param hasNoBorders should frame have control box (true) or not (false)
     * @param background the background color for the frame
     */
    public static void init(JFrame frame, String title, int width, int height,
                     boolean resizable, boolean isCenterScreen, 
                     boolean closeShouldEndApp, boolean hasNoBorders,
                     Color background) {
        if (frame == null) return;
        frame.setTitle(title);
        frame.setSize(width, height);
        frame.setResizable(resizable);
        if (isCenterScreen)    frame.setLocationRelativeTo(null);
        if (closeShouldEndApp) frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        if (hasNoBorders)      frame.setUndecorated(true);
        setBackground(frame, background);
        frame.setVisible(true);
    }
    
    /**
     * Initializes a JFrame to the set parameter values
     * 
     * @param frame the JFrame to initialize
     * @param title the frame's title
     * @param width the frame's width
     * @param height the frame's height
     * @param resizable should the user resize the frame (true) or not (false)
     * @param isCenterScreen is the frame center screen (true) or not (false)
     * @param closeShouldEndApp should close end the app (true) or not (false)
     * @param hasNoBorders should frame have control box (true) or not (false)
     * @param background the background color for the frame
     * @param iconFileName the file name for the frame icon
     */
    public static void init(JFrame frame, String title, int width, int height,
                     boolean resizable, boolean isCenterScreen, 
                     boolean closeShouldEndApp, boolean hasNoBorders,
                     Color background, String iconFileName) {
        if (frame == null) return;
        frame.setTitle(title);
        frame.setSize(width, height);
        frame.setResizable(resizable);
        if (isCenterScreen)    frame.setLocationRelativeTo(null);
        if (closeShouldEndApp) frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        if (hasNoBorders)      frame.setUndecorated(true);
        setBackground(frame, background);
        setIcon(frame, iconFileName);
        frame.setVisible(true);
    }
    
}
