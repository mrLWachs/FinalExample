
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

    private JLabel picturebox;
    
    public Picturebox(JLabel picturebox) {
        this.picturebox = picturebox;
        setDebug("", Color.white);
        resizeToContainer();
    }
    
    public Picturebox(JLabel picturebox, String imageFile) {
        this.picturebox = picturebox;
        setImage(imageFile);
        resizeToContainer();
    }
    
    public Picturebox(JLabel picturebox, String text, Color background) {
        this.picturebox = picturebox;
        setDebug(text,background);
        resizeToContainer();
    }
    
    public void setVisisble(boolean state) {
        picturebox.setVisible(state);
    }
    
    public void resize(int width, int height) {
        picturebox.setSize(width, height);
        resizeToContainer();
    }
    
    /**
     * Resizes the image inside the label to match the size of the label
     */
    public void resizeToContainer() {
        int       w             = picturebox.getWidth();
        int       h             = picturebox.getHeight();
        ImageIcon originalIcon  = (ImageIcon)picturebox.getIcon();
        Image     originalImage = originalIcon.getImage();        
        Image     newImage      = originalImage.getScaledInstance(w,h,
                                                          Image.SCALE_SMOOTH);
        ImageIcon newIcon       = new ImageIcon(newImage); 
        picturebox.setIcon(newIcon);  
    }
    
    public Coordinates getCoordinates() {
        int x = picturebox.getX();
        int y = picturebox.getY();
        int w = picturebox.getWidth();
        int h = picturebox.getHeight();
        return new Coordinates(x, y, w, h, 0, 0);
    }
    
    public void update(Coordinates coordinates) {
        coordinates.x      = picturebox.getX();
        coordinates.y      = picturebox.getY();
        coordinates.width  = picturebox.getWidth();
        coordinates.height = picturebox.getHeight();
        coordinates.recalculate();
    }
        
    public void redraw(Coordinates coordinates) {
        int x = coordinates.x;
        int y = coordinates.y;
        int w = coordinates.width;
        int h = coordinates.height;
        picturebox.setBounds(x, y, w, h);
    }
    
    /**
     * Change the image inside a label to a new image an possibly resize the 
     * image to fit the label size
     * 
     * @param imageFile the new image file to change the label to
     */
    public void setImage(String imageFile) {
        ImageIcon icon = new ImageIcon(getClass().getResource(imageFile));
        picturebox.setIcon(icon);
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
        picturebox.setBorder(BorderFactory.createEtchedBorder());        
        picturebox.setIcon(null);
        picturebox.setOpaque(true);
        picturebox.setBackground(background);
        picturebox.setForeground(Color.white);
        picturebox.setHorizontalAlignment(SwingConstants.CENTER);
        picturebox.setFont(new Font("Arial Narrow",Font.BOLD,8));
        picturebox.setText(text);    
    }
        
}
