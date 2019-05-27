
/** required package class namespace */
package year2019.cs30s.animations.gametools;

/** required imports */
import java.awt.Color;
import javax.swing.JLabel;


/**
 * GameImage.java - represents an image in a game including the ability to
 * animate 
 *
 * @author Mr. Wachs 
 * @since 17-Dec-2018 
 */
public class GameImage 
{

    private Animation[] animations;
    private JLabel label;
    private Picturebox picturebox;
    private int currentIndex;
    
    
    public GameImage(JLabel label, Animation[] animations) {
        this.label = label;
        if (animations != null) setAnimations(animations);
    }
    
    public GameImage(JLabel label) {
        this.label = label;
        picturebox = new Picturebox(label);
    }
    
    public GameImage(JLabel label, String text, Color background) {
        this.label = label;
        picturebox = new Picturebox(label, text, background);
    }
    
    public void setAnimations(Animation[] animations) {
        this.animations = animations;
        for (int i = 0; i < animations.length; i++) {
            animations[i].stop();
        }
        currentIndex = 0;
        animations[currentIndex].run();
    }
    
    public void animate(int index) {
        stop(currentIndex);
        run(index);
        currentIndex = index;
    }
    
    public void update(Coordinates coordinates) {
        picturebox.update(coordinates);
    }
        
    public Coordinates getCoordinates() {
        return picturebox.getCoordinates();
    }
    
    public void redraw(Coordinates coordinates) {
        picturebox.redraw(coordinates);
    }

    public void setMovement(int direction, int amount, 
                            Coordinates coordinates) {
        coordinates.direction = direction;
        coordinates.amount = amount;
    }
    
    public void hide() {
        stopAll();
        picturebox.hide();
    }

    public void show() {
        picturebox.show();
    }
    
    public void resize(int width, int height) {
        picturebox.resize(width, height);
    }
    
    public void setImage(String imageFile) {
        picturebox.setImage(imageFile);
    }
    
    public void debug(String text, Color background) {
        picturebox.setDebug(text, background);
    }
    
    public void resizeToContainer() {
        picturebox.resizeToContainer();
    }
    
    public void stopAll() {
        if (animations == null) return;
        for (int i = 0; i < animations.length; i++) {
            animations[i].stop();
        }
    }
    
    public void run(int index) {
        animations[index].run();
    }
    
    public void stop(int index) {
        animations[index].stop();
    }
    
    public void restart(int index) {
        animations[index].restart();
    }
    
    public void setLoop(int index, boolean shouldLoop) {
        animations[index].setLoop(shouldLoop);
    }
    
    public void setDelay(int index, int delay) {
        animations[index].setDelay(delay);
    }
    
    private void setImageFiles(int index, String[] imageFiles) {
        animations[index].setImageFiles(imageFiles);
    }
    
    public int getFPS(int index) {
        return animations[index].getFPS();
    }
    
    public boolean isRunning(int index) {
        return animations[index].isRunning();
    }
    
}
