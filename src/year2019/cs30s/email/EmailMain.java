/** required package class namespace */
package year2019.cs30s.email;

/**
 * EmailMain.java - the main class for the application for sending emails
 * 
 * References:
 * https://stackoverflow.com/questions/46663/
 * how-can-i-send-an-email-by-java-application-using-gmail-yahoo-or-hotmail
 * 
 * and...
 * https://stackoverflow.com/questions/3649014/send-email-using-java
 * https://stackoverflow.com/questions/6606529/
 * package-javax-mail-and-javax-mail-internet-do-not-exist
 * https://javaee.github.io/javamail/#Download_JavaMail_Release
 * 
 * download the jar file at:
 * https://javaee.github.io/javamail/#Download_JavaMail_Release
 * 
 * After downloading javax.mail.jar add it to your project using the 
 * following steps: 
 * (1) Extract the mail.jar file
 * (2) Right click the project node (JavaMail), click Properties to change 
 *     properties of the project
 * (3) Now go to Libraries Tab
 * (4) Click on Add JAR/Folder Button. A window opens up.
 * (5) Browse to the location where you have unzipped your Mail.jar
 * (6) Press ok
 * (7) Compile your program to check whether the JAR files have been 
 *     successfully included
 * 
 * From your gmail account you also need to set it to explicitly enable 
 * "less secure apps" in gmail settings: 
 * google.com/settings/security/lesssecureapps
 * Once "less secure apps" is enabled, the code will work
 *
 * @author Mr. Wachs
 * @since 13-Nov-2018
 */
public class EmailMain 
{

    /**
     * Default constructor for the class
     */
    public EmailMain() {
        new UserInterface();
    }

}
