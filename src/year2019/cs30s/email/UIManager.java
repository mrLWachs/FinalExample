
/** required package class namespace */
package year2019.cs30s.email;

/** required imports */
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import year2018.cs30s.tools.Dialogs;
import year2018.cs30s.tools.FrameTools;


/**
 * UIManager.java - the user interface manager for the email application
 *
 * @author Mr. Wachs 
 * @since 16-Nov-2018 
 */
public class UIManager 
{

    private JTextArea      contentTextArea;
    private JPasswordField passwordArea;
    private JTextField     fromTextbox;
    private JTextField     toTextbox;
    private JTextField     subjectTextbox;
    private UserInterface  userInterface;
    private Dialogs        dialog;
    
    /**
     * Class constructor sets class properties
     * 
     * @param contentTextArea the content text area
     * @param passwordArea the password text field
     * @param fromTextbox the from email text field
     * @param toTextbox the to email text field
     * @param subjectTextbox the subject text field
     * @param userInterface the user interface frame 
     */
    public UIManager(
              JTextArea contentTextArea, 
              JPasswordField passwordArea,
              JTextField fromTextbox, 
              JTextField toTextbox, 
              JTextField subjectTextbox,
              UserInterface userInterface) {
        this.contentTextArea = contentTextArea;
        this.passwordArea    = passwordArea;        
        this.fromTextbox     = fromTextbox;
        this.toTextbox       = toTextbox;
        this.subjectTextbox  = subjectTextbox;
        this.userInterface   = userInterface;
        dialog = new Dialogs(Environmentals.EMAILER_UI_TITLE, userInterface);
        new FrameTools().startup(userInterface, 
                Environmentals.EMAILER_UI_TITLE, 
                Environmentals.EMAILER_UI_WIDTH, 
                Environmentals.EMAILER_UI_HEIGHT, 
                false, true, false, false, 
                Environmentals.EMAILER_UI_BACK_COLOR, 
                Environmentals.EMAILER_UI_ICON);  
    }

    /**
     * Sends the email based on all required fields
     */
    public void send() {
        String from     = fromTextbox.getText();
        String password = new String(passwordArea.getPassword());
        String to       = toTextbox.getText();
        String subject  = subjectTextbox.getText();
        String content  = contentTextArea.getText();
        if (from == null || from.equals("")) {
            dialog.output(Environmentals.EMAILER_WARNING_1, 
                          Environmentals.EMAILER_WARNING);
        }
        else if (password == null || password.equals("")) {
            dialog.output(Environmentals.EMAILER_WARNING_2, 
                          Environmentals.EMAILER_WARNING);
        }
        else if (to == null || to.equals("")) {
            dialog.output(Environmentals.EMAILER_WARNING_3, 
                          Environmentals.EMAILER_WARNING);
        }
        else if (subject == null || subject.equals("")) {
            dialog.output(Environmentals.EMAILER_WARNING_4, 
                          Environmentals.EMAILER_WARNING);
        }
        else if (content == null || content.equals("")) {
            dialog.output(Environmentals.EMAILER_WARNING_5, 
                          Environmentals.EMAILER_WARNING);
        }
        else  {
            GMailer.send(from,password,to,subject,content);
        }
    }

}
