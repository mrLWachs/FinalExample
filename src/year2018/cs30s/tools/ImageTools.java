
/** required package class namespace */
package year2018.cs30s.tools;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import static mainpackage.Example.MEDIA_PATH;

/**
 * ImageTools.java - description here...
 *
 * @author Mr. Wachs (login: lawrence.wachs)
 * @since Jun 7, 2018 
 * @instructor Mr. Wachs
 */
public class ImageTools 
{

    public void resizeImage(JLabel imageLabel) {
        int       w             = imageLabel.getWidth();
        int       h             = imageLabel.getHeight();
        ImageIcon originalIcon  = (ImageIcon)imageLabel.getIcon();
        Image     originalImage = originalIcon.getImage();        
        Image     newImage      = originalImage.getScaledInstance(w,h,
                                                          Image.SCALE_SMOOTH);
        ImageIcon newIcon       = new ImageIcon(newImage); 
        imageLabel.setIcon(newIcon);                
    }

    public void changeImage(JLabel imageLabel, String newImageFile, 
                            boolean shouldResize) {
        ImageIcon icon = new ImageIcon(getClass().getResource(newImageFile));
        imageLabel.setIcon(icon);
        if (shouldResize) resizeImage(imageLabel);        
    }
    
}
