package yearOthers.triangle;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Created by: Alex Friesen
 * "Box" v2.1.1
 * 
 * Last updated 09/01/2012
 * 
 * -Now primed for GUI use-
 * 
 * A collection of methods, all in one box.
 */

public class Box 
{
    /**
     * input - asks for user input
     * @param obj - what is to be displayed
     * @return - returns the user input
     */
    public static String input(Object obj)
    {
        return JOptionPane.showInputDialog(null, obj);
    }
    
    /**
     * output - outputs a message box
     * @param obj - what is to be displayed
     */
    public static void output(Object obj)
    {
        JOptionPane.showMessageDialog(null, obj);
    }
    
    private static void output(Object obj, String title) {
        JOptionPane.showMessageDialog(null,obj,title,JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * print - prints something to the console
     * @param obj - what is to be printed
     * @param newLine - whether or not we want a new line
     */
    public static void print(Object obj, boolean newLine)
    {
        if(newLine)
        {
            System.out.println(obj);
        }
        else
        {
            System.out.print(obj);
        }
    }
    
    /**
     * printLoop - prints 'msg' numTimes times.
     * @param obj - what is to be printed
     * @param numTimes - how many times to print it
     * @param newLine - whether or not we want a new line
     */
    public static void printLoop(Object obj, int numTimes, boolean newLine)
    {
        for(int i = 0; i < numTimes; i++)
        {
            if(newLine)
            {
                System.out.println(obj);
            }
            else
            {
                System.out.print(obj);
            }
        }
    }
    
    /**
     * printNL - prints a new line
     */
    public static void printNL()
    {
        System.out.print("\n");
    }
    
    /**
     * randomInt - creates a random integer
     * @param high - upper range
     * @param low - lower range
     * @return - returns the random integer
     */
    public static int randomInt(double low, double high)
    {
        return (int)((high - low + 1) * Math.random() + low);
    }
    
    /**
     * randomDouble - creates a random double
     * @param high - upper range
     * @param low - lower range
     * @return - returns the random double
     */
    public static double randomDouble(double low, double high)
    {
        return ((high - low + 1) * Math.random() + low);
    }
    
    /**
     * makeInt - parses a string into an integer
     * @param string - what is to be parsed
     * @return - returns the parsed string as an integer
     */
    public static int textToInt(String string)
    {
        return Integer.parseInt(string);
    }
    
    /**
     * makeDouble - parses a string into a double
     * @param string - what is to be parsed
     * @return - returns the parsed string as a double
     */
    public static double textToDouble(String string)
    {
        return Double.parseDouble(string);
    }
    
    /**
     * fillArray - fills an entire array with whatever filler is set to
     * @param array - the array to fill
     * @param filler - what to fill it with
     */
    public static void fillArray(int[] array, int filler)
    {
        for(int i = 0; i < array.length; i++)
        {
            array[i] = filler;
        }
    }
    
    /**
     * fillArray - fills an entire array with whatever filler is set to
     * @param array - the array to fill
     * @param filler - what to fill it with
     */
    public static void fillArray(int[][] array, int filler)
    {
        for(int r = 0; r < array.length; r++)
        {
            for(int c = 0; c < array.length; c++)
            {
                array[r][c] = filler;
            }
        }
    }
    
    /** 
     * fillArray - fills an entire array with whatever filler is set to
     * @param array - the array to fill
     * @param filler - what to fill it with
     */
    
    //not sure if this works. will test later.
    
//    public static void fillArray(int[][][] array, int filler)
//    {
//        for(int x = 0; x < array.length; x++)
//        {
//            for(int y = 0; y < array.length; y++)
//            {
//                for(int z = 0; z < array.length; z++)
//                {
//                    array[x][y][z] = filler;
//                }
//            }
//        }
//    }
    
    /**
     * emptyStringArray - takes a string array and empties it
     * @param array - what array to empty
     */
    public static void emptyStringArray(String[] array)
    {
        for(int i = 0; i < array.length; i++)
        {
            array[i] = "";
        }
    }
    
    /**
     * isEven - checks if a number is even
     * @param num - what number to be checked
     * @return - true or false
     */
    public static boolean isEven(int num)
    {
        if(num % 2 != 0)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
    /**
     * midpoint - calculates midpoint between two numbers
     * @param one - first number
     * @param two - second number
     * @return - midpoint
     */
    public static int midpoint(int one, int two)
    {
        return ((one + two) / 2);
    }
    
    @Deprecated
    /**
     * runAgain - ask the user if they wish to run the program again
     * @param input - the user's Y or N
     * @return - true or false
     */
    public static boolean runAgain(String msg)
    {
        String input = Box.input(msg + "\n(Y/N)");
        
        if(input.equalsIgnoreCase("Y"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * makeStringFromArray - turns an entire array into 
     *                       a string
     * 
     * @param array - what array to make a string from
     * @param msg - what to display before the index of the array
     * @param symbol - what to say after the index of the array
     * @param mod - if we need to add / subtract from the index
     * @return - returns the completed string
     * 
     * format of input:
     * ARRAYNAME MESSAGE SYMBOL MODIFIER
     * 
     * format of output:
     * MESSAGE -space- (INDEX + MODIFIER) SYMBOL -space- CONTENTSOFARRAY
     * 
     * assuming myArray has 5 slots (size of 4),
     * 
     * input:
     * myArray, Index, ':', 1  
     * 
     * output:
     * Index 1: One
     * Index 2: Two
     * Index 3: Three
     * Index 4: Four
     * Index 5: Five
     * 
     * the modifier is to compensate for the fact that arrays start
     * at 0 and not 1, this allows for cleaner display and less user
     * confusion.
     */
    public static String makeStringFromArray
            (int[] array, String msg, char symbol, int mod)
    {
        String arrayMsg = "";
        for(int i = 0; i < array.length; i++)
        {
            arrayMsg = arrayMsg + 
                    ("\n" + msg + " " + (i + mod) + symbol + " " + array[i]);
        }
        return arrayMsg;
    }
    
    /**
     * compare - compares two strings
     * @param str1 - string 1
     * @param str2 - string 2
     * @param exact - whether we care if it's an exact match or not
     * @return - returns true if they match
     */
    public static boolean compare(String str1, String str2, boolean exact)
    {
        if(exact)
        {
            if(str1.contains(str2))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            if(str1.equalsIgnoreCase(str2))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    }
    
    /**
     * compare - compares two text fields
     * @param txt1 - first text field
     * @param txt2 - second text field
     * @param exact - whether we care if it's an exact match or not
     * @return - returns true if they match
     */
    public static boolean compare(JTextField txt1, JTextField txt2, boolean exact)
    {
        if(exact)
        {
            if(txt1.getText().equals(txt2.getText()))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            if(txt1.getText().equalsIgnoreCase(txt2.getText()))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    }
    
    public static boolean yesNo(String msg)
    {
        int choice = 
                JOptionPane.showConfirmDialog
                (null, msg, null, JOptionPane.YES_NO_OPTION);
        
        if(choice == 0)
        {
            return true;      
        }
        else
        {
            return false;
        }
    }
    
    /**
     * end - ends the program
     * @param msg - what is to be displayed
     * calls output, System.exit
     */
    public static void end(String msg)
    {
        output(msg);
        System.exit(0);
    }
    
    public static void end(String msg, String title)
    {
        output(msg,title);
        System.exit(0);
    }
    
    /**
     * end - ends the program
     * calls System.exit
     * 
     * no message in this version
     */
    public static void end()
    {
        System.exit(0);
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
        frame.setVisible(true);
    }
    
    /**
     * This sets the JFrame to full screen size
     * @param frame the JFrame to set
     */
    public static void setFullScreen(JFrame frame) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dim = toolkit.getScreenSize();
        int width = ((int)dim.getWidth());
        int height = ((int)dim.getHeight());
        frame.setSize(width,height);
        frame.setVisible(true);
    }

    public static void setFullScreen(Frame frame) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dim = toolkit.getScreenSize();
        int width = ((int)dim.getWidth());
        int height = ((int)dim.getHeight());
        frame.setSize(width,height);
        frame.setVisible(true);
    }

    public static Color randomColor() {
        int r = randomInt(0.0,255.0);
        int g = randomInt(0.0,255.0);
        int b = randomInt(0.0,255.0);
        return new Color(r,g,b);
    }

    

}