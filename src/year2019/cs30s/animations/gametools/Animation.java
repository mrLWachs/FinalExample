
/** required package class namespace */
package year2019.cs30s.animations.gametools;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.Timer;



/**
 * Animation.java - 
 *
 * @author Mr. Wachs 
 * @since 14-May-2019 
 */
public class Animation 
{

    private JLabel label;    
    private Picturebox[] frames;    
    private Timer timer;
    private String[] imageFiles;
    private boolean shouldLoop;
    private int delay;
    private int currentFrame;
    private int fps;
    private int lastFrame;
        
    
    public Animation(JLabel label, String[] imageFiles, int delay, 
                     boolean shouldLoop) {
        if (errorCheck(label,imageFiles)) { 
            this.label = label;
            setDelay(delay);
            setLoop(shouldLoop);  
            setImageFiles(imageFiles);      
        }
    }
    
    public void run() {
        timer.start();
    }
    
    public void stop() {
        timer.stop();
    }
    
    public void restart() {
        stop();
        frames[currentFrame].hide();
        currentFrame = 0;
        frames[currentFrame].show();
        run();
    }
    
    public void setLoop(boolean shouldLoop) {
        this.shouldLoop = shouldLoop;
    }
    
    public void setDelay(int delay) {
        this.delay = delay;
        setTimer();
    }
    
    public void setImageFiles(String[] imageFiles) {
        if (imageFiles != null) {
            setFrames();
            setTimer();
        }        
        this.imageFiles = imageFiles;
    }
    
    public int getFPS() {
        return fps;
    }
    
    public boolean isRunning() {
        return timer.isRunning();
    }
        
    private void tick() {
        frames[currentFrame].hide();                        // hide current
        if (currentFrame <= lastFrame) currentFrame++;      // cycle through
        else {
            if (shouldLoop)            currentFrame = 0;    // restart frames
            else                       stop();              // stop animation
        }
        frames[currentFrame].show();                        // show new current
    }

    private boolean errorCheck(JLabel label, String[] imageFiles) {
        if (label == null) {
            System.out.println("Animation Label is null!");
            return false;
        }
        if (imageFiles == null) {
            System.out.println("Animation imageFiles[] is null!");
            return false;
        }
        if (imageFiles.length == 0) {
            System.out.println("Animation imageFiles[] is size 0!");
            return false;
        }
        return true;
    }

    private void setTimer() {
        fps = delay / frames.length;        
        timer = new Timer(fps, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tick();
            }
        });
        run();
    }

    private void setFrames() {
        frames = new Picturebox[imageFiles.length];
        for (int i = 0; i < frames.length; i++) {
            frames[i] = new Picturebox(label, imageFiles[i]);
            frames[i].hide();
        }
        lastFrame = frames.length - 1;
        currentFrame = 0;    
        frames[currentFrame].show();
    }

}
