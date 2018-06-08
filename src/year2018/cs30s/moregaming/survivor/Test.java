
/** required package class namespace */
package year2018.cs30s.moregaming.survivor;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;
import mainpackage.MainClass;

/**
 * Test.java - description here...
 *
 * @author Mr. Wachs (login: lawrence.wachs)
 * @since Jun 8, 2018 
 * @instructor Mr. Wachs
 */
public class Test extends JFrame
{
    
    int width  = 1280;
    int height = 990;
    
    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        this.getContentPane().setLayout(null);
        setSize(width,height);
        this.getContentPane().setBackground(Color.black);
        this.setBackground(Color.black);
        this.setUndecorated(true);
        this.setLocationRelativeTo(null);
        
        Timer timer = new Timer(1, new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                tick();
            }
        });
        timer.start();

        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setVisible(true);
    }
    
    private void tick() {
        
        JLabel image = new JLabel();
//        image.setBorder(BorderFactory.createEtchedBorder());
        
        try {
            String path = "C:\\Users\\lawrence.wachs\\Dropbox\\WORK\\"
                        + "PROGRAMMING\\2017-2018\\Java\\FinalExamples\\"
                        + "src\\media\\Snake.png";

            File          file          = new File(path);
            BufferedImage bufferedImage = ImageIO.read(file);
            ImageIcon icon              = new ImageIcon(bufferedImage);
            image.setIcon(icon);
        }
        catch (IOException ex) {
            System.out.println("...");
        }
        
        
        this.getContentPane().add(image);      
        
        int x = rand(0,width-256);
        int y = rand(0,height-256);
        
        
        image.setBounds(x, y, 256, 256);
        
        this.setComponentZOrder(image, 0);
        
    }

    private int rand(int low, int high) {
        double L = (double)low;
        double H = (double)high;
        double seed = Math.random();
        double value = (H - L + 1) * seed + L;
        return (int)value;
    }

}
