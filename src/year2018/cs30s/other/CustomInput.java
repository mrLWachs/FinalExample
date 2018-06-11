
/** required package class namespace */
package year2018.cs30s.other;

/** required imports */
import javax.swing.JFrame;

/**
 * CustomInput.java - creates a custom user input dialog to display
 *
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public class CustomInput 
{

    /**
     * The user inputted text stored by the user interface
     */
    public static String inputText;
    
    /**
     * Shows a custom designed input dialog 
     * 
     * @param parent the JFrame to parent (center) the input dialog to
     * @param text the text displayed in the dialog
     * @param title the title displayed on the dialog
     * @return the text the user inputted into the dialog
     */
    public static String show(JFrame parent, String text, String title) {
        inputText = "";
        CustomInputUI customInputUI = new CustomInputUI(parent,true,text,title);
        return inputText;
    }

}
