
/** required package class namespace */
package year2018.cs32s.gametools;

/** required imports */
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;

/**
 * Image.java - a visual picture image used on a user interface
 *
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public class Image 
{
    
    private JLabel picture;
    
    /**
     * Class constructor sets class properties
     * 
     * @param label the JLabel to display the image in
     */
    public Image(JLabel label) {
        picture = label;
    }
    
    /**
     * Class constructor sets class properties
     * 
     * @param label the JLabel to display the image in
     * @param haveBorder whether or not the image has a border
     * @param text the text to display in the image
     * @param background the background color for the image
     */
    public Image(JLabel label, boolean haveBorder, String text,
                 Color background) {
        picture = label;
        if (text != null)  picture.setText(text); 
        if (haveBorder == true)  
            picture.setBorder(BorderFactory.createEtchedBorder()); 
        else  picture.setBorder(null); 
        if (background != null) {
            picture.setOpaque(true);
            picture.setBackground(background);
        }
    } 
    
    /**
     * Re-positions the image in it's container based on game character's data
     * 
     * @param coordinate the coordinate data for this image to use
     */
    public void redraw(Coordinate coordinate) {
        picture.setBounds(coordinate.x, coordinate.y,
                          coordinate.width, coordinate.height);
    }    
    
    /**
     * Shows the image in the user interface
     */
    public void show() {
        picture.setVisible(true);
    }
    
    /**
     * Hides the image in the user interface
     */
    public void hide() {
        picture.setVisible(false);
    }

    /**
     * Accesses the current x coordinate of the image in it's container
     * 
     * @return the current x coordinate
     */
    public int getX() {
        return picture.getX();
    }
    
    /**
     * Accesses the current y coordinate of the image in it's container
     * 
     * @return the current y coordinate
     */
    public int getY() {
        return picture.getY();
    }
    
    /**
     * Accesses the current width of the image in it's container
     * 
     * @return the current width
     */
    public int getWidth() {
        return picture.getWidth();
    }
    
    /**
     * Accesses the current height of the image in it's container
     * 
     * @return the current height
     */
    public int getHeight() {
        return picture.getHeight();
    }
    
}
