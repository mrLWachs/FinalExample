
/** required package class namespace */
package year2019.cs30s.email;

/** required imports */
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import year2018.cs30s.tools.Dialogs;

/**
 * GMailer.java - logic to send an email from a GMail account
 * 
 * @author Mr. Wachs 
 * @since 27-Nov-2018 
 */
public class GMailer 
{
    
    /**
     * Send email using GMail SMTP server.
     *
     * @param from GMail username
     * @param password GMail password
     * @param to TO recipient
     * @param subject subject of the message
     * @param content content of the message to be sent
     */
    public static void send(String from, 
                            String password,
                            String to, 
                            String subject, 
                            String content) {        
        Properties properties = System.getProperties();
        String     host       = Environmentals.HOST_NAME;
        properties.put(Environmentals.SMTP_ENABLE, Environmentals.TRUE);
        properties.put(Environmentals.SMTP_HOST, host);
        properties.put(Environmentals.SMTP_USER, from);
        properties.put(Environmentals.SMTP_PASSWORD, password);
        properties.put(Environmentals.SMTP_PORT, Environmentals.SMTP_NUMBER);
        properties.put(Environmentals.SMTP_AUTHENTICATE, Environmentals.TRUE);
        Session     session = Session.getDefaultInstance(properties);
        MimeMessage message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(from));
            InternetAddress toAddress = new InternetAddress(to);
            message.addRecipient(Message.RecipientType.TO, toAddress);
            message.setSubject(subject);
            message.setText(content);
            Transport transport = session.getTransport(Environmentals.SMTP);
            transport.connect(host, from, password);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (AddressException error) {
            new Dialogs(Environmentals.EMAILER_UI_TITLE, null).output(
                    Environmentals.ERROR_1 + error.toString(),
                    Environmentals.EMAILER_UI_TITLE);
        }
        catch (MessagingException error) {
            new Dialogs(Environmentals.EMAILER_UI_TITLE, null).output(
                    Environmentals.ERROR_2 + error.toString(),
                    Environmentals.EMAILER_UI_TITLE);
        }
    }
    
}