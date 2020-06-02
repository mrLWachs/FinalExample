package yearOthers.mousetest;


// <editor-fold defaultstate="collapsed" desc="Code Imports">

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

// </editor-fold>

/**
 * FormTools.java
 * This is a set of methods to use with JFrames
 * Created on 10-Jan-2011, 12:36:34 PM
 * @author Mr. Wachs
 */

public abstract class FormTools
{

    // <editor-fold defaultstate="collapsed" desc="Programmer Methods">

    /**
     * Default class constructor
     */
    public FormTools() { }

    /**
     * Another constructor to set the frame to these parameter values
     * @param frame the frame to set up
     * @param width the frame's width to set
     * @param height the frame's height to set
     * @param title the frame's title to set
     * @param resizable if the frame is resizable or not
     */
    public static void setGUI(JFrame frame, int width, int height, String title,
            boolean resizable) {
        frame.setSize(width,height);
        frame.setTitle(title);
        frame.setResizable(resizable);
        centerFrameOnScreen(frame);
    }

    /**
     * Another constructor to set the frame to these parameter values
     * @param frame the frame to set up
     * @param width the frame's width to set
     * @param height the frame's height to set
     * @param title the frame's title to set
     * @param resizable if the frame is resizable or not
     */
    public static void setGUI(JFrame frame, int width, int height, String title,
            boolean resizable, JPanel panel) {
        frame.setSize(width,height);
        frame.setTitle(title);
        frame.setResizable(resizable);
        centerFrameOnScreen(frame);
        setJavaColors(frame,panel);
    }

    /**
     * This sets up the frame to these parameter values
     * @param frame the frame to set up
     * @param width the frame's width to set
     * @param height the frame's height to set
     * @param title the frame's title to set
     * @param resizable if the frame is resizable or not
     */
    public static void setGUI(JDialog frame, int width, int height, String title,
            boolean resizable) {
        frame.setSize(width,height);
        frame.setTitle(title);
        frame.setResizable(resizable);
        centerFrameOnScreen(frame);
    }

    /**
     * This disposes of the current frame
     * @param currentForm the frame to dispose of
     */
    public static void exitForm(JFrame currentForm) {
        currentForm.dispose();
    }

    /**
     * This centers the JFrame based on screen resolution
     * @param frame the JFrame to center
     */
    public static void centerFrameOnScreen(JFrame frame) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dim = toolkit.getScreenSize();
        int width = frame.getWidth() / 2;
        int height = frame.getHeight() / 2;
        int x = ((int)dim.getWidth() / 2) - width;
        int y = ((int)dim.getHeight() / 2) - height;
        frame.setLocation(x,y);
    }

    /**
     * This centers the JDialog based on screen resolution
     * @param frame the JDialog to center
     */
    public static void centerFrameOnScreen(JDialog frame) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dim = toolkit.getScreenSize();
        int width = frame.getWidth() / 2;
        int height = frame.getHeight() / 2;
        int x = ((int)dim.getWidth() / 2) - width;
        int y = ((int)dim.getHeight() / 2) - height;
        frame.setLocation(x,y);
    }

    /**
     * This sets the JFrame to full screen size
     * @param frame the JFrame to set
     */
    public static void setFullScreen(JFrame frame) {
        //frame.setUndecorated(true);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dim = toolkit.getScreenSize();
        int width = ((int)dim.getWidth());
        int height = ((int)dim.getHeight());
        frame.setSize(width,height);
    }

    public static void setJavaColors(JFrame frame, JPanel panel) {
        Color background = new Color(223,233,243);
        frame.setBackground(background);
        panel.setBackground(background);
    }

    public static void setJavaColors(JFrame frame, JPanel panel, Color color) {
        frame.setBackground(color);
        panel.setBackground(color);
    }

    // </editor-fold>

}
