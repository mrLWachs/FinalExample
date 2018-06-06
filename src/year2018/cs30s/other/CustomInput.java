
/** required package class namespace */
package year2018.cs30s.other;

import javax.swing.JFrame;

/**
 * CustomInput.java - description here...
 *
 * @author Mr. Wachs (login: lawrence.wachs)
 * @since Jun 6, 2018 
 * @instructor Mr. Wachs
 */
public class CustomInput 
{

    public static String inputText;
    
    public static String show(JFrame parent, String text, String title) {
        inputText = "";
        CustomInputUI customInputUI = new CustomInputUI(parent,true,text,title);
        return inputText;
    }

}
