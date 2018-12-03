
/** required package class namespace */
package year2019.cs30s.email;

/** required imports */
import java.awt.Color;
import mainpackage.MainConstants;


/**
 * Environmentals.java - the environmental variables for the application
 *
 * @author Mr. Wachs 
 * @since 16-Nov-2018 
 */
public class Environmentals 
{
    
    public static final String EMAILER_UI_TITLE      = "Emailer";
    public static final int    EMAILER_UI_WIDTH      = 337;
    public static final int    EMAILER_UI_HEIGHT     = 358;
    public static final Color  EMAILER_UI_BACK_COLOR = Color.white;
    public static final String EMAILER_UI_ICON       = 
            MainConstants.MEDIA_PATH + "icon.png";    
    public static final String EMAILER_WARNING_1     = 
            "Please fill out the 'From' section";
    public static final String EMAILER_WARNING_2     = 
            "Please fill out the 'Password' section";
    public static final String EMAILER_WARNING_3     = 
            "Please fill out the 'To' section";
    public static final String EMAILER_WARNING_4     = 
            "Please fill out the 'Subject' section";
    public static final String EMAILER_WARNING_5     = 
            "Please fill out some content for this email";
    public static final String EMAILER_WARNING       = "Warning!";    
    public static final String HOST_NAME             = "smtp.gmail.com";
    public static final String SMTP_ENABLE           = 
            "mail.smtp.starttls.enable";
    public static final String TRUE                  = "true";
    public static final String SMTP_HOST             = "mail.smtp.host";
    public static final String SMTP_USER             = "mail.smtp.user";
    public static final String SMTP_PASSWORD         = "mail.smtp.password";
    public static final String SMTP_PORT             = "mail.smtp.port";
    public static final String SMTP_NUMBER           = "587";
    public static final String SMTP_AUTHENTICATE     = "mail.smtp.auth";
    public static final String SMTP                  = "smtp";    
    public static final String ERROR_1               = 
            "Address Mail Error\n(see AddressException: ";
    public static final String ERROR_2               = 
            "Messaging Mail Error\n(see MessagingException: ";
    
}
