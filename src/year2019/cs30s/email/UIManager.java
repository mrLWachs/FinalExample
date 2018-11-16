/*
 *  Mr. Wachs' classes - Java Computer Science learning file UIManager.java
 *  for project FinalExamples on 16-Nov-2018 at 12:02:18 PM by lawrence.wachs
 */


/** required package class namespace */
package year2019.cs30s.email;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import year2018.cs30s.tools.Dialogs;
import year2018.cs30s.tools.FrameTools;



/**
 * UIManager.java - 
 *
 * @author Mr. Wachs 
 * @since 16-Nov-2018 
 */
public class UIManager 
{

    private JTextArea     contentTextArea;
    private JTextField    fromTextbox;
    private JTextField    toTextbox;
    private JTextField    subjectTextbox;
    private UserInterface userInterface;
    private Dialogs       dialog;
    
    
    public UIManager(
              JTextArea contentTextArea, 
              JTextField fromTextbox, 
              JTextField toTextbox, 
              JTextField subjectTextbox,
              UserInterface userInterface) {
        this.contentTextArea = contentTextArea;
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

    public void send() {
        String from    = fromTextbox.getText();
        String to      = toTextbox.getText();
        String subject = subjectTextbox.getText();
        String content = contentTextArea.getText();
        if (from == null || from.equals("")) {
            dialog.output("Please fill out the 'From' section", "Warning!");
        }
        else if (to == null || to.equals("")) {
            dialog.output("Please fill out the 'To' section", "Warning!");
        }
        else if (subject == null || subject.equals("")) {
            dialog.output("Please fill out the 'Subject' section", "Warning!");
        }
        else if (content == null || content.equals("")) {
            dialog.output("Please fill out some content for this email", 
                    "Warning!");
        }
        else  {
            //Email.send(from,to,subject,content);
        }
    }

}
