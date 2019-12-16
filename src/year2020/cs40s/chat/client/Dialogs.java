
/** required package class namespace */
package year2020.cs40s.chat.client;

/** required imports */
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Dialogs.java - a collection of useful methods for working with dialogs
 *
 * @author Mr. Wachs
 * @since Dec 12, 2017
 * @instructor Mr. Wachs
 */
public class Dialogs
{

    private final Font      DEFAULT_FONT             = new JOptionPane().getFont();
    private final Color     DEFAULT_BACKGROUND_COLOR = new JOptionPane().getBackground();
    private final Color     DEFAULT_FOREGROUND_COLOR = new JOptionPane().getForeground();
    private final String    DEFAULT_TITLE            = "";
    private final Component DEFAULT_COMPONENT        = null;
    private final ImageIcon DEFAULT_ICON             = null;
    private final int       DEFAULT_TYPE             = JOptionPane.PLAIN_MESSAGE;
    private final int       DEFAULT_OPTION_TYPE      = JOptionPane.YES_NO_OPTION;

    private JTextArea area;
    private Numbers   numbers;

    /** Font used for displaying in the dialogs */
    public Font font;
    /** Background color used for displaying in the dialogs */
    public Color background;
    /** Foreground (text) color used for displaying in the dialogs */
    public Color foreground;
    /** Top dialog title used */
    public String title;
    /** Frame or other component the dialog parents (centers) with */
    public Component parent;
    /** Type of icon used in the dialogs */
    public int messageType;
    /** Type of button options used in the dialogs */
    public int optionType;
    /** Custom icon (image) used in the dialogs */
    public Icon icon;

    /**
     * Default class constructor sets class properties
     */
    public Dialogs() {
        defaults();
        init();
    }
    
    /**
     * Class constructor sets class properties
     *
     * @param title The title used on any dialog in the class
     */
    public Dialogs(String title) {
        defaults();
        this.title = title;
        init();
    }

    /**
     * Class constructor sets class properties
     *
     * @param title The title used on any dialog in the class
     * @param parent the component to parent the dialogs to
     */
    public Dialogs(String title, Component parent) {
        defaults();
        this.title  = title;
        this.parent = parent;
        init();
    }

    /**
     * Class constructor sets passed properties
     * 
     * @param title top dialog title used
     * @param parent the component to parent the dialogs to
     * @param font font used in dialogs
     */
    public Dialogs(String title, 
                   Component parent,
                   Font font) {
        defaults();
        this.font  = font;
        this.title = title;
        init();
    }
    
    /**
     * Class constructor sets passed properties
     * 
     * @param title top dialog title used
     * @param parent the component to parent the dialogs to
     * @param font font used in dialogs
     * @param background background color used in dialogs
     * @param foreground foreground (text) color used in dialogs
     */
    public Dialogs(String title, 
                   Component parent,
                   Font font, 
                   Color background, 
                   Color foreground) {
        defaults();
        this.font       = font;
        this.background = background;
        this.foreground = foreground;
        this.title      = title;
        init();
    }

    /**
     * Class constructor sets passed properties
     * 
     * @param title top dialog title used
     * @param parent frame the dialog parents (centers) with
     * @param font font used in dialogs 
     * @param background background color used in dialogs
     * @param foreground foreground (text) color used in dialogs 
     * @param messageType type of icon used in the dialogs
     * @param icon custom icon (image) used in the dialogs
     */
    public Dialogs(String title,
                   Component parent,
                   Font font,
                   Color background,
                   Color foreground,
                   int messageType,
                   Icon icon) {
        defaults();
        this.parent      = parent;
        this.messageType = messageType;
        this.icon        = icon;
        this.font        = font;
        this.background  = background;
        this.foreground  = foreground;
        this.title       = title;
        init();
    }

    /**
     * Sets the image icon for the dialog methods invoked
     * 
     * @param imageFilePath the name of the image to display
     */
    public void setImage(String imageFilePath) {
        this.icon = new ImageIcon(imageFilePath);
    }
    
    /**
     * Outputs the passed text in a dialog
     *
     * @param text the text to display
     */
    public void output(String text) {
        area.setText(text);     
        JOptionPane.showMessageDialog(parent, area, title, messageType, icon);
    }

    /**
     * Outputs the passed text in a dialog
     *
     * @param text the text to display
     * @param width the set width of the dialog
     * @param height the set height of the dialog
     */
    public void output(String text, int width, int height) {
        JTextArea area = new JTextArea();
        area.setFont(font);
        area.setBackground(background);
        area.setForeground(foreground);
        area.setText(text);        
        JScrollPane scrollPane = new JScrollPane(area);  
        scrollPane.setPreferredSize(new Dimension(width,height));
        scrollPane.setBorder(null);
        JOptionPane.showMessageDialog(parent, scrollPane, title, messageType, 
                icon);
    }
    
    /**
     * Outputs the passed text in a dialog, and gets typed user input
     *
     * @param text the text to display
     * @return the text the user types in
     */
    public String input(String text) {
        area.setText(text);
        Object object = JOptionPane.showInputDialog(parent, area,
                title, messageType, icon, null, null);
        if (object == null) return null;
        return object.toString();
    }
    
    /**
     * Asks the user for a number (integer) in a input dialog box
     * 
     * @param text the text for the dialog box
     * @return a valid integer
     */
    public int inputInteger(String text) {
        String value = input(text);
        while (numbers.isInteger(value) == false) {
            value = input("Error, please enter again\n\n" + text);
        }
        int number = Integer.parseInt(value);
        return number;        
    }
    
    /**
     * Asks the user for a number (integer) in a input dialog box
     * 
     * @param text the text for the dialog box
     * @param minimum the lowest value in the input range
     * @param maximum the highest value in the input range
     * @return a valid integer
     */
    public int inputInteger(String text, int minimum, int maximum) {
        final String ERROR_1 = "Error, invalid number\n\n" + text;
        final String ERROR_2 = "Error, number not inside range\n\n" + text;
        String value = input(text);
        int number = 0;
        boolean done = false;
        while (!done) {
            if (numbers.isInteger(value) == false) value = input(ERROR_1);
            else {
                number = Integer.parseInt(value);
                if (numbers.inRange(number, minimum, maximum)) done = true;
                else value = input(ERROR_2);
            }            
        }
        return number;        
    }
    
    /**
     * Asks the user for a number (double) in a input dialog box
     * 
     * @param text the text for the dialog box
     * @return a valid integer
     */
    public double inputDouble(String text) {
        String value = input(text);
        while (numbers.isDouble(value) == false) {
            value = input("Error, please enter again\n\n" + text);
        }
        double number = Double.parseDouble(value);
        return number;        
    }

    /**
     * Asks the user for a number (integer) in a input dialog box
     * 
     * @param text the text for the dialog box
     * @param minimum the lowest value in the input range
     * @param maximum the highest value in the input range
     * @return a valid double
     */
    public double inputDouble(String text, int minimum, int maximum) {
        final String ERROR_1 = "Error, invalid number\n\n" + text;
        final String ERROR_2 = "Error, number not inside range\n\n" + text;
        String value = input(text);
        double number = 0d;
        boolean done = false;
        while (!done) {
            if (numbers.isDouble(value) == false) value = input(ERROR_1);
            else {
                number = Double.parseDouble(value);
                if (numbers.inRange(number, minimum, maximum)) done = true;
                else value = input(ERROR_2);
            }            
        }
        return number;        
    }
    
    /**
     * Ask the user a yes and no question, in a confirm dialog box
     * 
     * @param text the yes no question to ask in the dialog
     * @return true (yes), false (no)
     */
    public boolean yesNo(String text) {
        area.setText(text);
        int response = JOptionPane.showConfirmDialog(parent, area, title,
                optionType, JOptionPane.QUESTION_MESSAGE, icon);
        if (response == JOptionPane.YES_OPTION) return true;
        else                                    return false;
    }

    /**
     * Outputs the passed text in a dialog and creates buttons with the text
     * from the choices on each for the user to click on
     * 
     * @param text the text to display
     * @param choices the text choices for each button
     * @return the text on which button the user clicked on
     */
    public String buttons(String text, String[] choices) {
        area.setText(text);
        int value = JOptionPane.showOptionDialog(parent, area, title, 
                optionType, messageType, icon, choices, choices[0]);
        return choices[value];
    }

    /**
     * Presents an input dialog with a drop down selection of options
     * 
     * @param text the text to show in the dialog
     * @param options the array of option to have in the drop down
     * @return the option they choose
     */
    public String choices(String text, String[] options) {
        area.setText(text);
        Object object = JOptionPane.showInputDialog(parent, area, title, 
                JOptionPane.QUESTION_MESSAGE, icon, options, options[0]);
        if (object == null)  return "";
        else                 return object.toString();
    }
    
    /**
     * Ask the user if they want to play again, in a dialog box
     * 
     * @return true (yes, play again), false (no)
     */
    public boolean playAgain() {
        return yesNo("Do you want to play again?");
    }
    
    /**
     * Open file dialog parented to the passed frame
     *
     * @param frame the frame to parent to
     * @return the file object selected (or a null)
     */
    public File openFile(JFrame frame) {
        JFileChooser chooser = new JFileChooser(title);
        chooser.showOpenDialog(frame);
        return chooser.getSelectedFile();
    }

    /**
     * Save file dialog parented to the passed frame
     *
     * @param frame the frame to parent to
     * @return the file object selected (or a null)
     */
    public File saveFile(JFrame frame) {
        JFileChooser chooser = new JFileChooser(title);
        chooser.showSaveDialog(frame);
        return chooser.getSelectedFile();
    }

    /**
     * Open file dialog parented to the passed frame
     *
     * @param frame the frame to parent to
     * @return the file object selected (or a null)
     */
    public File openFileFrame(JDialog frame) {
        JFileChooser chooser = new JFileChooser(title);
        chooser.showOpenDialog(frame);
        return chooser.getSelectedFile();
    }

    /**
     * Save file dialog parented to the passed frame
     *
     * @param frame the frame to parent to
     * @return the file object selected (or a null)
     */
    public File saveFileFrame(JDialog frame) {
        JFileChooser chooser = new JFileChooser(title);
        chooser.showSaveDialog(frame);
        return chooser.getSelectedFile();
    }
    
    /**
     * Sets class properties to default values
     */
    private void defaults() {
        this.parent      = null;
        this.font        = DEFAULT_FONT;
        this.background  = DEFAULT_BACKGROUND_COLOR;
        this.foreground  = DEFAULT_FOREGROUND_COLOR;
        this.title       = DEFAULT_TITLE;
        this.parent      = DEFAULT_COMPONENT;
        this.messageType = DEFAULT_TYPE;
        this.optionType  = DEFAULT_OPTION_TYPE;
        this.icon        = DEFAULT_ICON;
        this.area        = new JTextArea();
        this.numbers     = new Numbers();
    }

    /**
     * Initializes the text area for the dialogs
     */
    private void init() {
        area.setFont(font);
        area.setBackground(background);
        area.setForeground(foreground);        
    }

}