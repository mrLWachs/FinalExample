
package yearOthers.mousetest;


// <editor-fold defaultstate="collapsed" desc="Code Imports"> ----------------

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

// </editor-fold>

/**
 * Toolbox.java - a collection of useful methods and properties
 * for problem solving
 * @author Mr. Wachs
 */

public abstract class Toolbox
{

    // <editor-fold desc="Public Class Properties"> --------------------------

    /**
     * the font name to use in the dialog box's font
     */
    public static String     FONT_NAME;
    /**
     * the font size to use in the dialog box's font
     */
    public static int        FONT_SIZE;
    /**
     * the dialog box's background color amount of red
     */
    public static int        COLOR_CODE_RED;
    /**
     * the dialog box's background color amount of green
     */
    public static int        COLOR_CODE_GREEN;
    /**
     * the dialog box's background color amount of blue
     */
    public static int        COLOR_CODE_BLUE;
    /**
     * the dialog box's title text
     */
    public static       String     applicationTitle;
    /**
     * the dialog box's icon image file to load
     */
    public static       String     applicationIconFile;

    // </editor-fold>

    // <editor-fold desc="Private Class Properties"> -------------------------

    private static      int        messageType;
    private static      JTextArea  area;                  // objects
    private static      Color      background;
    private static      Font       font;
    private static      Icon       applicationIcon;
    private static      Component  parentComponent;

    // </editor-fold>

    // <editor-fold desc="Public Class Methods"> -----------------------------

    /**
     * default constructor for the class sets all class data
     */
    public Toolbox() {
        this("","","Lucida Sans Typewriter",24,238,238,238);
    }

    /**
     * constructor for the class sets all class data to the parameters
     * @param title the dialog title
     * @param iconFile the dialog icon picture file
     * @param fontName the dialog font name
     * @param fontSize the dialog font size
     * @param red the dialog background red color
     * @param green the dialog background green color
     * @param blue the dialog background blue color
     */
    public Toolbox(String title, String iconFile, String fontName,
            int fontSize, int red, int green, int blue) {
        applicationTitle    = title;
        applicationIconFile = iconFile;
        FONT_NAME           = fontName;
        FONT_SIZE           = fontSize;
        COLOR_CODE_RED      = red;
        COLOR_CODE_GREEN    = green;
        COLOR_CODE_BLUE     = blue;
        area                = new JTextArea();
        background          = new Color(COLOR_CODE_RED,
                               COLOR_CODE_GREEN,COLOR_CODE_BLUE);
        font                = new Font(FONT_NAME,Font.PLAIN,FONT_SIZE);
        applicationIcon     = new ImageIcon(applicationIconFile);
        area.setBackground(background);
        area.setFont(font);
        area.setEditable(false);
        parentComponent = null;
        messageType = JOptionPane.PLAIN_MESSAGE;
    }

    /**
     * display a starting dialog welcome
     */
    public static void start() {
        output("Welcome to " + applicationTitle +
                "\n\nPlease read all instructions...");
    }

    /**
     * display a ending dialog, and terminate the program
     */
    public static void end() {
        output("Thanks for playing " + applicationTitle +
                "\n\nHave a nice day!");
        System.exit(0);
    }

    /**
     * display an output dialog with the text parameter
     * @param text the text to display
     */
    public static void output(String text) {
        area.setText(text);
        JOptionPane.showMessageDialog(parentComponent,area,
                applicationTitle,messageType,applicationIcon);
    }

    /**
     * display an input dialog with the text parameter
     * @param text the text to display
     * @return the text the user entered
     */
    public static String input(String text) {
        area.setText(text);
        Object value = JOptionPane.showInputDialog(parentComponent,
                area,applicationTitle,messageType,applicationIcon,null,"");
        if (value == null) return "";
        return value.toString();
    }

    /**
     * generate a random integer inside the assigned range
     * @param low the low range value
     * @param high the high range value
     * @return a random integer in range
     */
    public static int randomInteger(int low, int high) {
        double rnd = Math.random();
        double L = (double)low;
        double H = (double)high;
        double random = (H - L + 1) * rnd + L;
        int answer = (int)random;
        return answer;
    }

    /**
     * determines if the text parameter is a valid integer or not
     * @param text the value to check
     * @return valid integer or not
     */
    public static boolean isNotValidInteger(String text) {
        if (text == null)    return true;
        if (text.equals("")) return true;
        for (int i = 0; i < text.length(); i++) {
            char letter = text.charAt(i);
            if (Character.isDigit(letter) == false)
                return true;
        }
        return false;
    }

    /**
     * asks the user for an integer, verifies it and returns it
     * @param text the text to display in the dialog
     * @return a valid integer
     */
    public static int inputInteger(String text) {
        boolean valid = false;
        int number = 0 ;
        String originalText = text;
        do {
            String value = input(text);
            if (isNotValidInteger(value)) {
                text = originalText + "\nSorry, please try again";;
            }
            else {
                number = Integer.parseInt(value);
                valid = true;
            }
        } while(!valid);
        return number;
    }

    /**
     * asks the user for an integer, verifies it and returns it
     * @param text the text to display in the dialog
     * @param low the low range to stay within
     * @param high the high range to stay within
     * @return a valid integer
     */
    public static int inputInteger(String text, int low, int high) {
        boolean valid = false;
        int number = 0 ;
        String originalText = text;
        do {
            String value = input(text);
            if (isNotValidInteger(value)) {
                text = originalText + "\nSorry, please try again";
            }
            else {
                number = Integer.parseInt(value);
                if (number < low || number > high) {
                    text = originalText + "\nSorry, please try again";
                }
                else {
                    valid = true;
                }
            }
        } while(!valid);
        return number;
    }

    /**
     * displays a yes/no dialog and returns a boolean
     * @param text the dialog text to display
     * @return true (yes) or false (no)
     */
    public static boolean question(String text) {
        area.setText(text);
        int answer = JOptionPane.showConfirmDialog(parentComponent,
                area,applicationTitle,JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if(answer == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * displays an input dialog with a drop down combo box
     * @param values the values to display in the combo box
     * @param text the dialog text to display above the dialog box
     * @return the user selected value in the combo box
     */
    public static String options(String values[], String text) {
        area.setText(text);
        Object value = JOptionPane.showInputDialog(parentComponent,
                area,applicationTitle,messageType,applicationIcon,
                values,values[0]).toString();
        if (value == null) return "";
        return value.toString();
    }

    /**
     * creates a random string in the range between
     * startingString >= random <= endingString
     * @param startingString the beginning value
     * @param endingString the ending value
     * @return a random string in range
     */
    public static String randomString(String startingString, String endingString) {
        char letter1       = startingString.charAt(0);
        char letter2       = endingString.charAt(0);
        int  startingASCII = (int)letter1;
        int  endingASCII   = (int)letter2;
        int  value         = randomInteger(startingASCII,endingASCII);
        char randomChar    = (char)value;
        return "" + randomChar;
    }

    // </editor-fold>

}
