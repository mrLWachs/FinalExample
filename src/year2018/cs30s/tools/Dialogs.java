
/** required package class namespace */
package year2018.cs30s.tools;

/** required imports */
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 * Dialogs.java - a collection of useful methods for user dialog boxes
 * 
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public class Dialogs 
{
    /** 
     * The title to appear on the dialog 
     */
    public String dialogTitle;
    
    /** 
     * The parent frame to parent the dialog to 
     */
    public JFrame parent;

    
    /** 
     * Default constructor for the class 
     */
    public Dialogs() {
        this("",null);
    }
    
    /**
     * Constructor sets class data
     * 
     * @param dialogTitle the title to appear on the dialog
     */
    public Dialogs(String dialogTitle) {
        this(dialogTitle,null);
    }
    
    /**
     * Constructor sets class data
     * 
     * @param dialogTitle the title to appear on the dialog
     * @param parent the parent frame to parent the dialog to
     */
    public Dialogs(String dialogTitle, JFrame parent) {
        this.dialogTitle = dialogTitle;
        this.parent      = parent;
    }
    
    /**
     * Shows a dialog with a drop down of choices
     * 
     * @param text to display in the dialog
     * @param choices to display in the drop down
     * @return the choice the user selects
     */
    public String choose(String text, String[] choices) {        
        JTextArea area = new JTextArea(text);
        Font font = new Font("Arial",Font.BOLD,12);
        Color background = new Color(238,238,238);
        area.setFont(font);
        area.setBackground(background);
        Object object = JOptionPane.showInputDialog(parent, area, dialogTitle,
                JOptionPane.PLAIN_MESSAGE, null, choices, choices[0]);
        if (object == null) return null;
        else                return object.toString();        
    }
    
    /**
     * Shows a dialog with a series of buttons
     * 
     * @param text to display in the dialog
     * @param buttonTexts the text on the various buttons
     * @return the text of the button that was clicked
     */
    public String buttons(String text, String[] buttonTexts) {
        int result = JOptionPane.showOptionDialog(null, text, dialogTitle,
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, 
                buttonTexts, buttonTexts[0]);
        if (result == -1) return "";
        return buttonTexts[result];
    }
    
}
