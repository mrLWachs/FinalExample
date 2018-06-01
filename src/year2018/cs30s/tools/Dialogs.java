
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
    /** the title to appear on the dialog */
    public String dialogTitle;
    /** the parent frame to parent the dialog to */
    public JFrame parent;
    /** the initial directory to start in */
    public String intitialDirectory;
    
    /** default constructor for the class */
    public Dialogs() {
        this("",null,System.getProperty("user.dir"));
    }
    
    /**
     * constructor sets class data
     * @param dialogTitle the title to appear on the dialog
     */
    public Dialogs(String dialogTitle) {
        this(dialogTitle,null,System.getProperty("user.dir"));
    }
    
    /**
     * constructor sets class data
     * @param dialogTitle the title to appear on the dialog
     * @param parent the parent frame to parent the dialog to
     */
    public Dialogs(String dialogTitle, JFrame parent) {
        this(dialogTitle,parent,System.getProperty("user.dir"));
    }

    /**
     * constructor sets class data
     * @param dialogTitle the title to appear on the dialog
     * @param parent the parent frame to parent the dialog to
     * @param intitialDirectory the initial directory to start in
     */
    public Dialogs(String dialogTitle, JFrame parent, 
            String intitialDirectory) {
        this.dialogTitle       = dialogTitle;
        this.parent            = parent;
        this.intitialDirectory = intitialDirectory;
    }

    /**
     * shows a dialog with a drop down of choices
     * @param text to display in the dialog
     * @param choices to display in the drop down
     * @return the choice the user selects
     */
    public String choose(String text, 
            String[] choices) {        
        JTextArea area = new JTextArea(text);
        Font font = new Font("Arial",Font.BOLD,12);
        Color background = new Color(238,238,238);
        area.setFont(font);
        area.setBackground(background);
        Object object = JOptionPane.showInputDialog(
                parent, 
                area, 
                dialogTitle,
                JOptionPane.PLAIN_MESSAGE,
                null, 
                choices, 
                choices[0]);
        if (object == null) return null;
        else                return object.toString();        
    }
    
    public String buttons(String text, String[] buttonTexts) {
        int result = JOptionPane.showOptionDialog(
                null,
                text,
                dialogTitle,
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE, 
                null, 
                buttonTexts, 
                buttonTexts[0]);
        if (result == -1) return "";
        return buttonTexts[result];
    }
    
}
