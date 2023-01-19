
package year2022.cs40s.timeddialogs;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/** 
 * TimedDialogs.java - example of timed dialogs
 *
 * @author Mr. Wachs 
 * @since 23-Nov-2021 
*/
public class TimedDialogs {

    /**
     * @param args the command line arguments
     */
    public TimedDialogs() {
        showTimedDialog("Example 1", "Title 1", 3000);
        showTimedDialog("Example 2", "Title 2", 2000);
        showTimedDialog("Example 3", "Title 3", 1000);      
        
        String text =   "This is the first sentence in this " +
                        "paragraph. Paragraphs may be long " +
                        "or short. In this paragraph the first line is " +
                        "indented. Indented and non-indented " +
                        "sentences are allowed. White space within " +
                        "the paragraph lines is ignored in " +
                        "defining paragraphs. Only completely blank " +
                        "lines are significant." + 
                        "This is the first sentence in this " +
                        "paragraph. Paragraphs may be long " +
                        "or short. In this paragraph the first line is " +
                        "indented. Indented and non-indented " +
                        "sentences are allowed. White space within " +
                        "the paragraph lines is ignored in " +
                        "defining paragraphs. Only completely blank " +
                        "lines are significant." + 
                        "This is the first sentence in this " +
                        "paragraph. Paragraphs may be long " +
                        "or short. In this paragraph the first line is " +
                        "indented. Indented and non-indented " +
                        "sentences are allowed. White space within " +
                        "the paragraph lines is ignored in " +
                        "defining paragraphs. Only completely blank " +
                        "lines are significant." + 
                        "This is the first sentence in this " +
                        "paragraph. Paragraphs may be long " +
                        "or short. In this paragraph the first line is " +
                        "indented. Indented and non-indented " +
                        "sentences are allowed. White space within " +
                        "the paragraph lines is ignored in " +
                        "defining paragraphs. Only completely blank " +
                        "lines are significant.";
        
        output(text);
        
        output(text, 400,200);
        
        String filename = "C:\\Users\\lawrence.wachs\\Desktop\\Picture1.png";
        
        output(text, 400, 200, Color.yellow, Color.blue, 
                true, "Ugly", filename,"Comic Sans MS",24);
        
        
        final String TITLE = "Mr. Wachs' Rotating Image...";
        
        // Create a path to the image file
        final String FIRST_NAME  = "E:\\File Backup\\Work\\2021-2022\\"
                + "NetBeansProjects\\RotateImage\\src\\rotateimage\\";
        final String MIDDLE_NAME = "image";
        final String LAST_NAME   = ".png";
        final String IMAGE_NAME  = FIRST_NAME + MIDDLE_NAME + LAST_NAME;
        
        // Now create an icon object
        ImageIcon icon = new ImageIcon(IMAGE_NAME);
        
        // Display that icon in a dialog
        JOptionPane.showMessageDialog(null, "Original Image", TITLE, 
                JOptionPane.PLAIN_MESSAGE, icon);
        
        // Create a rotatable icon from the same image file
        RotatableIcon rotatableIcon = new RotatableIcon(IMAGE_NAME, 90.0);
                
        // Display that icon in a dialog
        JOptionPane.showMessageDialog(null, "Rotated Image by 90 degrees", 
                TITLE, JOptionPane.PLAIN_MESSAGE, rotatableIcon);
        
        
        // A third rotatable icon from the same image file again
        RotatableIcon anotherIcon = new RotatableIcon(IMAGE_NAME,
                                    RotatableIcon.Rotate.UPSIDE_DOWN);
        
        // Display that icon in a dialog
        JOptionPane.showMessageDialog(null, "Rotated Image upside down", 
                TITLE, JOptionPane.PLAIN_MESSAGE, anotherIcon);
        
    }

    /**
     * Displays a standard JOption dialog for a set amount of time
     * 
     * @param text the message to display in the dialog
     * @param title the text at the top of the dialog
     * @param delay the time to show (in milliseconds)
     */
    public static void showTimedDialog(String text, String title, int delay) {
        // Create a JOptionPane dialog with a constructor
        JOptionPane jOptionDialog = new JOptionPane(text, 
                JOptionPane.PLAIN_MESSAGE,JOptionPane.DEFAULT_OPTION,null);
        // Also create a JDialog from the JOptionPane dialog
        final JDialog dialog = jOptionDialog.createDialog(title);
        // Do not shut down the program when it disappears
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE); 
        // Sets a runnable object which can be timed using a timer
        Runnable run = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(delay);        // Sets the milliseconds 
                } 
                catch (InterruptedException e) {
                    e.printStackTrace();        // In case of an error
                }
                dialog.dispose();               // Remove the dialog
            }
        };
        // The thread initiates the timer to run and start
        Thread thread = new Thread(run);
        thread.start();
        // Make the dialog appear
        dialog.setVisible(true);
    }
    
    private static void output(String text) {
        output(text,100,100);
    }
    
    private static void output(String text, int width, int height) {
        output(text, width, height, null, null, false, "", null,"Arial",12);
    }
    
    private static void output(String text, int width, int height, 
            Color backround, Color foreground, boolean hasBorder, 
            String title, String pictureFilename, String fontName,
            int fontSize) {
        
        // Setup a display area
        JTextArea area = new JTextArea(text);        
        area.setLineWrap(true);
        area.setWrapStyleWord(true); 
        area.setBackground(backround);
        area.setForeground(foreground);
        
        // Setup a dimension (size) 
        Dimension size = new Dimension(width,height);
        
        // Setup a scrollable area
        JScrollPane scroller = new JScrollPane(area);
        scroller.setPreferredSize(size);
        
        // Add borders?
        if (hasBorder) {
            area.setBorder(BorderFactory.createLineBorder(Color.black, 1));
            scroller.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        }
        
        // Setup a font
        Font font = new Font(fontName, Font.PLAIN, fontSize);
        area.setFont(font);
        scroller.setFont(font);        
        
        // Setup an icon (picture)
        Icon icon = new ImageIcon(pictureFilename);
        
        // Put that scrollable area in the dialog
        JOptionPane.showMessageDialog(null, scroller,title,
                JOptionPane.PLAIN_MESSAGE,icon);
        
    }

}
