
/** required package class namespace */
package year2018.cs30s.other;

import javax.swing.JButton;
import javax.swing.JLabel;
import year2018.cs30s.tools.Dialogs;

/**
 * Engine.java - description here...
 *
 * @author Mr. Wachs (login: lawrence.wachs)
 * @since Jun 6, 2018 
 * @instructor Mr. Wachs
 */
public class Engine 
{

    private JButton customUserInputButton;
    private JButton getIntegerButton;
    private JButton dropdownButton;
    private JButton multipleButtonButton;
    private JButton rotateImageButton;
    private JButton resizeImageButton;
    private JLabel customDialogsLabel;
    private JLabel customImageLabel;
    private JLabel imageLabel;
    private OtherUI otherUIFrame;
    private Dialogs dialog;
    
    
    public Engine(JButton resizeImageButton, 
                  JButton customUserInputButton, 
                  JButton getIntegerButton, 
                  JButton dropdownButton, 
                  JButton multipleButtonButton, 
                  JButton rotateImageButton, 
                  JLabel  customDialogsLabel, 
                  JLabel  customImageLabel, 
                  JLabel  imageLabel, 
                  OtherUI otherUIFrame) {
        this.resizeImageButton     = resizeImageButton;
        this.customUserInputButton = customUserInputButton;
        this.getIntegerButton      = getIntegerButton;
        this.dropdownButton        = dropdownButton;
        this.multipleButtonButton  = multipleButtonButton;
        this.rotateImageButton     = rotateImageButton;
        this.customDialogsLabel    = customDialogsLabel;
        this.customImageLabel      = customImageLabel;
        this.imageLabel            = imageLabel;
        this.otherUIFrame          = otherUIFrame;   
        dialog = new Dialogs(Constants.OTHER_UI_TITLE, otherUIFrame);
    }

    public void customUserInput() {        
        String item = CustomInput.show(otherUIFrame,"Custom input box text", 
                Constants.OTHER_UI_TITLE);
        dialog.output("Item inputted was " + item, Constants.OTHER_UI_TITLE);
    }

    public void getInteger() {
        int number = dialog.getInteger("Enter a number", 
                Constants.OTHER_UI_TITLE);
        dialog.output("Number entered was " + number, Constants.OTHER_UI_TITLE);
    }

    public void dropdown() {
        String[] choices = { "Choice 1",
                             "Choice 2",
                             "Choice 3",
                             "Choice 4",
                             "Choice 5"   
        };
        String choice = dialog.dropdown("Select a choice", 
                Constants.OTHER_UI_TITLE, choices);
        dialog.output("Choice selected was " + choice, 
                Constants.OTHER_UI_TITLE);
    }

    public void multipleButton() {
        String[] buttonTexts = { "Button 1",
                                 "Button 2",
                                 "Button 3",
                                 "Button 4",
                                 "Button 5"   
        };
        String choice = dialog.buttons("Click a button",buttonTexts);
        dialog.output("Button clicked was " + choice, 
                Constants.OTHER_UI_TITLE);
    }

    public void rotateImage() {
        
    }

    public void resizeImage() {
        
    }

    public void closeWindow() {
        
    }

}
