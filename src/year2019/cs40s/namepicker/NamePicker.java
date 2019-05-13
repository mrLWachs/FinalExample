
/** required package class namespace */
package year2019.cs40s.namepicker;

import java.awt.Font;


/**
 * MainClass.java - 
 *
 * @author Mr. Wachs 
 * @since 12-Apr-2019 
 */
public class NamePicker 
{

    /**
     * Main method for the project
     * 
     * @param args the command line arguments
     */
    public NamePicker() {
        new MainModel();
    }

    public static void main(String[] args) {
        new NamePicker();
        
        int i = 1;
        for (Font font : MainView.allFonts) {
            System.out.println(i + " name:  " + font.getName());
            System.out.println(i + " size:  " + font.getSize());
            System.out.println(i + " style: " + font.getStyle());            
            i++;
        }
        
    }
    
}
