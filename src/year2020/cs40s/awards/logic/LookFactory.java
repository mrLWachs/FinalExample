
/** required package class namespace */
package year2020.cs40s.awards.logic;

import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import year2020.cs40s.awards.data.DataStructures;

 
/**
 * LookFactory.java - description
 *
 * @author Mr. Wachs
 * @since 19-May-2020, 9:10:37 PM
 */
public class LookFactory 
{
    
    public static void setComponents(JComponent[] components, 
            JFrame userInterface, int width, int height) {        
        userInterface.getContentPane().setBackground(DataStructures.BACKGROUND);
        userInterface.setBackground(DataStructures.BACKGROUND);
        userInterface.setForeground(DataStructures.FOREGROUND);
        userInterface.setSize(width, height);
        userInterface.setResizable(false);
        userInterface.setLocationRelativeTo(null);
        for (JComponent component : components) {
            component.setBackground(DataStructures.BACKGROUND);
            component.setForeground(DataStructures.FOREGROUND);
            component.setFont(DataStructures.FONT1);
            if (component instanceof JList) {
                component.setFont(DataStructures.FONT2);
            }            
        }
        userInterface.setVisible(true);
    }
    
    public static void setComponents(JComponent[] components, 
            JDialog userInterface, int width, int height) { 
        userInterface.getContentPane().setBackground(DataStructures.FOREGROUND);
        userInterface.setBackground(DataStructures.FOREGROUND);
        userInterface.setForeground(DataStructures.BACKGROUND);
        userInterface.setSize(width, height);
        userInterface.setResizable(false);
        userInterface.setLocationRelativeTo(null);
        for (JComponent component : components) {
            component.setBackground(DataStructures.FOREGROUND);
            component.setForeground(DataStructures.BACKGROUND);
            component.setFont(DataStructures.FONT1);
            if (component instanceof JList) {
                component.setFont(DataStructures.FONT2);
            }            
        }
    }
    
}
