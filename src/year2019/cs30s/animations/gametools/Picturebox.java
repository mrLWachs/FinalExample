
/** required package class namespace */
package year2019.cs30s.animations.gametools;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;



/**
 * Picturebox.java - 
 *
 * @author Mr. Wachs 
 * @since 14-May-2019 
 */
public class Picturebox 
{

    private JLabel label;
    private String imageFile;
    
    public Picturebox(JLabel label) {
        this.label = label;
        setDebug("", Color.white);
        resizeToContainer();
    }
    
    public Picturebox(JLabel label, String imageFile) {
        this.label = label;
        setImage(imageFile);
    }
    
    public Picturebox(JLabel label, String text, Color background) {
        this.label = label;
        setDebug(text,background);
    }
        
    public void show() {
        if (imageFile != null) {
            ImageIcon icon = new ImageIcon(getClass().getResource(imageFile));
            label.setIcon(icon);
        }
        label.setVisible(true);
    }
    
    public void hide() {
        label.setIcon(null);
        label.setVisible(false);
    }
    
    public void resize(int width, int height) {
        label.setSize(width, height);
        resizeToContainer();
    }
    
    /**
     * Resizes the image inside the label to match the size of the label
     */
    public void resizeToContainer() {
        int       w             = label.getWidth();
        int       h             = label.getHeight();
        ImageIcon originalIcon  = (ImageIcon)label.getIcon();
        if (originalIcon == null) return;
        Image     originalImage = originalIcon.getImage();        
        Image     newImage      = originalImage.getScaledInstance(w,h,
                                                          Image.SCALE_SMOOTH);
        ImageIcon newIcon       = new ImageIcon(newImage); 
        label.setIcon(newIcon);  
    }
    
    public Coordinates getCoordinates() {
        int x = label.getX();
        int y = label.getY();
        int w = label.getWidth();
        int h = label.getHeight();
        return new Coordinates(x, y, w, h, 0, 0);
    }
    
    public void update(Coordinates coordinates) {
        coordinates.x      = label.getX();
        coordinates.y      = label.getY();
        coordinates.width  = label.getWidth();
        coordinates.height = label.getHeight();
        coordinates.recalculate();
    }
        
    public void redraw(Coordinates coordinates) {
        int x = coordinates.x;
        int y = coordinates.y;
        int w = coordinates.width;
        int h = coordinates.height;
        label.setBounds(x, y, w, h);
    }
    
    /**
     * Change the image inside a label to a new image an possibly resize the 
     * image to fit the label size
     * 
     * @param imageFile the new image file to change the label to
     */
    public void setImage(String imageFile) {
        this.imageFile = imageFile;
        show();
        resizeToContainer();        
    }
    
    /**
     * Sets the image to debug mode, meaning it removes any graphics and
     * changes to a colored rectangle with text
     * 
     * @param text the text to display in the image
     * @param background the background color of the image
     */
    public void setDebug(String text, Color background) {
        label.setBorder(BorderFactory.createEtchedBorder());        
        label.setIcon(null);
        label.setOpaque(true);
        label.setBackground(background);
        label.setForeground(Color.white);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Arial Narrow",Font.BOLD,8));
        label.setText(text);    
    }
        
}
