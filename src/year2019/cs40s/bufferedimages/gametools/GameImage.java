
/** required package class namespace */
package year2019.cs40s.bufferedimages.gametools;

/** required imports */
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JLabel;

/**
 * Image.java - a visual picture image used on a user interface
 * 
 * Resources:
 * https://docs.oracle.com/javase/tutorial/2d/images/drawimage.html
 * 
 *
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public class GameImage 
{
    
    private BufferedImage image;
    private Container container;
    private JLabel hitbox;
    private Graphics graphics;
    
    public Coordinate coordinates;
    
    /**
     * Class constructor sets class properties
     * 
     * @param filename
     * @param hitbox
     * @param container
     */
    public GameImage(String filename, JLabel hitbox, Container container) {   
        try {
            this.container = container;
            this.hitbox    = hitbox;            
            int x          = hitbox.getX();
            int y          = hitbox.getY();    
            URL url        = GameImage.class.getResource(filename);
            image          = ImageIO.read(url); 
            graphics       = container.getGraphics();
            boolean drawn  = graphics.drawImage(image, x, y, null);
            coordinates    = new Coordinate(this);
            coordinates.x  = x;
            coordinates.y  = y;
            
            container.repaint();
            debug(x, y, drawn);
            
        } catch (IOException ex) {
            System.out.println("IOException: " + ex.toString());
        }
    }
    
    
    private void debug(int x, int y, boolean drawn) {
        System.out.println("Image = " + image.toString());
        System.out.println("(" + x + "," + y + ")");
        System.out.println("Draw = " + drawn);
    }


    /**
     * Re-positions the image in it's container based on game character's data
     * 
     * @param coordinate the coordinate data for this image to use
     */
    public void redraw() {
        
        graphics.drawImage(image, 
                coordinates.x, 
                coordinates.y, null);
        
//        picture.setBounds(coordinate.x, coordinate.y,
//                          coordinate.width, coordinate.height);
    }    
    
    /**
     * Shows the image in the user interface
     */
    public void show() {
//        picture.setVisible(true);
    }
    
    /**
     * Hides the image in the user interface
     */
    public void hide() {
//        picture.setVisible(false);
    }

    /**
     * Accesses the current x coordinate of the image in it's container
     * 
     * @return the current x coordinate
     */
    public int getX() {
        return 0;
//        return picture.getX();
    }
    
    /**
     * Accesses the current y coordinate of the image in it's container
     * 
     * @return the current y coordinate
     */
    public int getY() {
        return 0;
//        return picture.getY();
    }
    
    /**
     * Accesses the current width of the image in it's container
     * 
     * @return the current width
     */
    public int getWidth() {
        return image.getWidth();
//        return 0;
//        return picture.getWidth();
    }
    
    /**
     * Accesses the current height of the image in it's container
     * 
     * @return the current height
     */
    public int getHeight() {
        return image.getWidth();
//        return 0;
//        return picture.getHeight();
    }
    
    /**
     * Accesses the background color of the image
     * 
     * @return the images background color
     */
    public Color getBackground() {
        return null;
//        return picture.getBackground();
    }
    
//    /**
//     * Sets a border around the image (or not)
//     * 
//     * @param haveBorder should have a border (true) or not (false)
//     */
//    public void setBorder(boolean haveBorder) {
//        if (haveBorder) picture.setBorder(BorderFactory.createEtchedBorder()); 
//        else            picture.setBorder(null); 
//    }
    
}
