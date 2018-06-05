
/** required package class namespace */
package year2018.cs30s.login;

/** required imports */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.Timer;


/**
 * Security.java - various methods for security login features
 *
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public class Security 
{
    
    private static Timer timer;
    private static JLabel label;
    private static JButton button;
    private static int correctCount;
    
    private final static int CORRECT_COUNT = 3;

    /**
     * Checks the user typed key to see if it matches what is in the label
     * 
     * @param event the user key typed event
     */
    public static void check(KeyEvent event) {
        int    userCode   = event.getKeyCode();     // get user event into int
        String text       = label.getText();        // get text from label
        char   letter     = text.charAt(0);         // get letter from text
        int    answerCode = (int)letter;            // convert letter to int
        if (userCode == answerCode) {               // compare int codes
            correctCount++;                         // increment count
            if (correctCount == CORRECT_COUNT) {    // matching counts
                button.setEnabled(true);            // enable button
                timer.stop();                       // stop timer
            }
        }
    }    

    /**
     * Initializes the security login for a user interface
     * 
     * @param label the label to display the letter
     * @param button the button to control access to
     */
    public static void init(JLabel label, JButton button) {
        Security.label  = label;                // assign parameter to property
        Security.button = button;               // assign parameter to property
        timer = new Timer(1500,new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                tick();
            }
        });                                     // set up the timer
        timer.start();                          // start the timer
        tick();                                 // display first letter
        correctCount = 0;                       // start the login count at 0
    }

    /**
     * Timer code running to change the letter randomly in the label
     */
    private static void tick() {
        double seed   = Math.random();          // random number formula
        double low    = 65.0d;                  // capital A
        double high   = 90.0d;                  // capital Z
        double value  = (high - low + 1.0d) * seed + low;
        int    number = (int)value;             // generate integer
        char   letter = (char)number;           // generate letter
        label.setText("" + letter);             // set letter into label
    }
    
}
