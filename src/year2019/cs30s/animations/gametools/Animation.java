
/** required package class namespace */
package year2019.cs30s.animations.gametools;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import year2019.cs40s.collections.LinkedList;



/**
 * Animation.java - 
 *
 * @author Mr. Wachs 
 * @since 14-May-2019 
 */
public class Animation 
{

    private JLabel picturebox;    
    private Picturebox[] frames;
    private int delay;
    private Timer timer;
    private boolean shouldLoop;
    private int currentFrame;
    
    
    public Animation(JLabel picturebox, String[] imageFiles, 
            int delay, boolean shouldLoop) {
        this.picturebox = picturebox;
        this.delay      = delay;
        this.shouldLoop = shouldLoop;
        timer = new Timer(delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tick();
            }
        });
        frames = new Picturebox[imageFiles.length];
        for (int i = 0; i < frames.length; i++) {
            frames[i] = new Picturebox(picturebox, imageFiles[i]);
        }
        currentFrame = 0;
    }
    
    public void run() {
        timer.start();
    }
    
    public void stop() {
        timer.stop();
    }
    
    public boolean isRunning() {
        return timer.isRunning();
    }
        
    private void tick() {
        
    }

    
//    
//    private LinkedList<ImageIcon> frames;
//    private int                   currentFrame;
//    private Timer                 timer;
//        /** the swing label object used to place the image(s) in a container */
//    public JLabel image;
//    
//    /**
//     * Constructor for the class, sets class properties
//     * 
//     * @param image the swing label object
//     */
//    public GameImage(JLabel image) {
//        this(image,null,0);
//    }
    
    
//        
//
//    
//    
//    /**
//     * Constructor for the class, sets class properties
//     * 
//     * @param image the swing label object
//     * @param frames the various images for the animation
//     * @param timeFrame the amount of time (in milliseconds) to animate over
//     */
//    public GameImage(JLabel image, LinkedList<ImageIcon> frames, int timeFrame) {
//        this.image = image;  
//        if (frames != null) setAnimations(frames,timeFrame);
//        image.setOpaque(false);
//        image.setText("");   
//        image.setBorder(null); 
//    }   
//    
//    /**
//     * Sets the game image for a set of frames over a time frame to animate
//     * using a timer
//     * @param frames the various images for the animation
//     * @param timeFrame the amount of time (in milliseconds) to animate over
//     */
//    private void setAnimations(LinkedList<ImageIcon> frames, int timeFrame) {
//        this.frames = frames;                       // assign to global array
//        currentFrame = 0;                           // starting frame
//        int duration = timeFrame / frames.size();   // calculate frame time
//        timer = new Timer(duration, new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                animate();                                  // timer action
//            }
//        });
//        timer.start();                                      // start timer
//    }
//        
//    /**
//     * The image animation that cycles through the frames of the animation
//     */
//    private void animate() {        
//        if (currentFrame < frames.size()-1) currentFrame++; // cycle through
//        else currentFrame = 0;                              // restart frames
//        image.setIcon(frames.get(currentFrame));            // draw in image
//    }
//        
//    /**
//     * Sets the image to debug mode, meaning it removes any graphics and
//     * changes to a colored rectangle with text
//     * 
//     * @param text the text to display in the image
//     * @param background the background color of the image
//     */
//    public void debug(String text, Color background) {
//        image.setBorder(BorderFactory.createEtchedBorder());        
//        image.setIcon(null);
//        image.setOpaque(true);
//        image.setBackground(background);
//        image.setForeground(Color.white);
//        image.setHorizontalAlignment(SwingConstants.CENTER);
//        image.setFont(new Font("Arial Narrow",Font.BOLD,8));
//        image.setText(text);    
//    }
    
}
