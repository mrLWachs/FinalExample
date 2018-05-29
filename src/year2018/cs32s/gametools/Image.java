
/** required package class namespace */
package year2018.cs32s.gametools;

/** required imports */
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;

/**
 * XXX.java - 
 *
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public class Image 
{
    // properties
    private JLabel picture;
    
    // methods
    
    public Image(JLabel label) {
        picture = label;
    }
    
    public Image(JLabel label, 
                 boolean haveBorder,
                 String text,
                 Color background) {
        picture = label;
        if (text != null) {
            picture.setText(text);
        }
        if (haveBorder == true) {
            picture.setBorder(
                    BorderFactory.createEtchedBorder());
        }
        else {
            picture.setBorder(null);
        }
        if (background != null) {
            picture.setOpaque(true);
            picture.setBackground(background);
        }
    } 
    
    public void redraw(Coordinate coordinate) {
        picture.setBounds(coordinate.x,
                          coordinate.y,
                          coordinate.width,
                          coordinate.height);
    }    
    
    public void show() {
        picture.setVisible(true);
    }
    
    public void hide() {
        picture.setVisible(false);
    }

    public int getX() {
        return picture.getX();
    }
    
    public int getY() {
        return picture.getY();
    }
    
    public int getWidth() {
        return picture.getWidth();
    }
    
    public int getHeight() {
        return picture.getHeight();
    }
    
}
