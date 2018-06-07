
/** required package class namespace */
package year2018.cs30s.other;

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
 * Engine.java - description here...
 *
 * @author Mr. Wachs (login: lawrence.wachs)
 * @since Jun 6, 2018 
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
        dialog     = new Dialogs(Constants.OTHER_UI_TITLE, otherUIFrame);
        tool       = new ImageTools();
        isRotating = false;
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
        dialog.output("The image will be changed!\n\n"
                + "Use the up/down arrow keys on the keyboard to "
                + "rotate the image!\n\n"
                + "Press escape to return to the original image", 
                Constants.OTHER_UI_TITLE);        
        tool.changeImage(imageLabel, MEDIA_PATH + "arrow.jpg",true);   
        int x = imageLabel.getX();
        int y = imageLabel.getY();
        int w = imageLabel.getWidth();
        int h = imageLabel.getHeight();
        imageLabel.setVisible(false);
        rotatingImage = new ImageLabel(imageLabel,x,y,w,h);        
        otherUIFrame.getContentPane().add(rotatingImage);
        rotatingImage.setBorder(BorderFactory.createEtchedBorder());
        rotatingImage.setBounds(x, y, w, h);
        isRotating = true;
    }

    public void resizeImage() {
        tool.resizeImage(imageLabel); 
    }

    public void closeWindow() {
        otherUIFrame.dispose();
        MainClass.gamesPlayed++;
        Examples2018.menu();
    }

    public void keypress(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.VK_ESCAPE) {
            imageLabel.setVisible(true);
            tool.changeImage(imageLabel, MEDIA_PATH + 
                    "computerScience.jpg",false);
            rotatingImage.setVisible(false);
        }        
        if (isRotating) {            
            if (event.getKeyCode() == KeyEvent.VK_UP) {
                double rotation = rotatingImage.getRotation();
                rotation += 1.0;
                rotatingImage.turn(rotation);
            }
            else if (event.getKeyCode() == KeyEvent.VK_DOWN) {
                double rotation = rotatingImage.getRotation();
                rotation -= 1.0;
                rotatingImage.turn(rotation);
            }
        }
    }

}
