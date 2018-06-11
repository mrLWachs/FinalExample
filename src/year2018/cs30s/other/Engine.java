
/** required package class namespace */
package year2018.cs30s.other;

/** required imports */
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import mainpackage.Examples2018;
import mainpackage.MainClass;
import static mainpackage.MainClass.MEDIA_PATH;
import year2018.cs30s.tools.Dialogs;
import year2018.cs30s.tools.ImageLabel;
import year2018.cs30s.tools.ImageTools;

/**
 * Engine.java - the logic behind the other example user interface
 *
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public class Engine 
{

    private JButton    customUserInputButton;
    private JButton    getIntegerButton;
    private JButton    dropdownButton;
    private JButton    multipleButtonButton;
    private JButton    rotateImageButton;
    private JButton    resizeImageButton;
    private JLabel     customDialogsLabel;
    private JLabel     customImageLabel;
    private JLabel     imageLabel;
    private OtherUI    otherUIFrame;
    private Dialogs    dialog;
    private ImageTools tool;    
    private boolean    isRotating;
    private ImageLabel rotatingImage;
    
    /**
     * Constructor for the class sets class properties to the parameters
     * 
     * @param resizeImageButton the button to resize images
     * @param customUserInputButton the button for custom user input dialog
     * @param getIntegerButton the button for getting an integer
     * @param dropdownButton the button for drop down input
     * @param multipleButtonButton the button for multiple button input
     * @param rotateImageButton the button for rotating an image
     * @param customDialogsLabel the label for the custom dialogs
     * @param customImageLabel the label for the custom images
     * @param imageLabel the label holding an image
     * @param otherUIFrame the user interface for the other examples
     */
    public Engine(JButton resizeImageButton, JButton customUserInputButton, 
                  JButton getIntegerButton, JButton dropdownButton, 
                  JButton multipleButtonButton, JButton rotateImageButton, 
                  JLabel  customDialogsLabel, JLabel  customImageLabel, 
                  JLabel  imageLabel, OtherUI otherUIFrame) {
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
        dialog     = new Dialogs(Constants.OTHER_UI_TITLE, otherUIFrame);
        tool       = new ImageTools();
        isRotating = false;
    }

    /**
     * Displays a custom user input dialog
     */
    public void customUserInput() {        
        String item = CustomInput.show(otherUIFrame,"Custom input box text", 
                Constants.OTHER_UI_TITLE);
        dialog.output("Item inputted was " + item, Constants.OTHER_UI_TITLE);
    }

    /**
     * Displays a dialog to get an integer
     */
    public void getInteger() {
        int number = dialog.getInteger("Enter a number", 
                Constants.OTHER_UI_TITLE);
        dialog.output("Number entered was " + number, Constants.OTHER_UI_TITLE);
    }

    /**
     * Displays a drop down user input dialog
     */
    public void dropdown() {
        String[] choices = {"Pick 1","Pick 2","Pick 3","Pick 4","Pick 5"};
        String choice = dialog.dropdown("Select a choice", 
                Constants.OTHER_UI_TITLE, choices);
        dialog.output("Choice selected was " + choice, 
                Constants.OTHER_UI_TITLE);
    }

    /**
     * Displays a custom dialog with custom buttons with custom text
     */
    public void multipleButton() {
        String[] buttonTexts = {"Button 1","Button 2","Button 3","Button 4",
                                "Button 5"};
        String choice = dialog.buttons("Click a button",buttonTexts);
        dialog.output("Button clicked was " + choice, 
                Constants.OTHER_UI_TITLE);
    }

    /**
     * Rotates an image using keyboard commands
     */
    public void rotateImage() {
        dialog.output("The image will be changed!\n\nUse the up/down arrow "
                    + "keys on the keyboard to rotate the image!\n\nPress "
                    + "escape to return to the original image", 
                      Constants.OTHER_UI_TITLE);        
        tool.changeImage(imageLabel, MEDIA_PATH + "arrow.jpg",true);   
        int x = imageLabel.getX();                  // get image dimensions
        int y = imageLabel.getY();
        int w = imageLabel.getWidth();
        int h = imageLabel.getHeight();
        imageLabel.setVisible(false);           // make original image invisible
        rotatingImage = new ImageLabel(imageLabel,x,y,w,h);        
        otherUIFrame.getContentPane().add(rotatingImage);
        rotatingImage.setBorder(BorderFactory.createEtchedBorder());
        rotatingImage.setBounds(x, y, w, h);
        isRotating = true;                      // flag as rotating
    }

    /**
     * Resize the image to fit the label size
     */
    public void resizeImage() {
        tool.resizeImage(imageLabel);                       // resize image
    }

    /**
     * Close the frame and return to the main menus
     */
    public void closeWindow() {
        otherUIFrame.dispose();                             // dispose of frame
        MainClass.gamesPlayed++;                            // increment count
        Examples2018.menu();                                // main menu
    }

    /**
     * User has pressed a key and rotating an image
     * 
     * @param event the keyboard event
     */
    public void keypress(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.VK_ESCAPE) {     // escape key
            imageLabel.setVisible(true);                    // make visible
            tool.changeImage(imageLabel, MEDIA_PATH + 
                             "computerScience.jpg",false);  // change image
            rotatingImage.setVisible(false);                // make invisble
        }        
        if (isRotating) {                                   // rotating image
            if (event.getKeyCode() == KeyEvent.VK_UP) {     // up key
                double rotation = rotatingImage.getRotation();
                rotation += 1.0;                            // adjust rotation
                rotatingImage.turn(rotation);               // rotate image
            }
            else if (event.getKeyCode() == KeyEvent.VK_DOWN) {  // down key
                double rotation = rotatingImage.getRotation();
                rotation -= 1.0;                            // adjust rotation
                rotatingImage.turn(rotation);               // rotate image
            }
        }
    }

}
