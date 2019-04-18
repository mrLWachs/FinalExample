
/** required package class namespace */
package year2019.cs40s.twitter;

/** required imports */
import java.awt.Color;
import java.awt.Font;


/**
 * UIModel.java - the model class (based on MVC model) for the 
 * application user interface
 *
 * @author Mr. Wachs 
 * @since 12-Mar-2019 
 */
public class UIModel 
{

    public static final String[] DEFAULT_WATCH_WORDS_ARRAY = {
          "Amazon",
          "Bezos",
          "Toyota",
          "Boeing",
          "Lockheed",
          "Bean",
          "Rexnord",
          "Ford",
          "Chrysler",
          "General Motors",
          "Apple",
          "Macys",
          "TMobile",
          "Koch",
          "Google",
          "Facebook",
          "Twitter"
        };
    public static final String             CONSUMER_KEY             = "L53C1tMeHNPfINBYOCheQZGEb";
    public static final String             CONSUMER_SECRET          = "lGnLjH9W71BvDIyUkraksHbb5bfhrbhHWP5xBDZiZgrUNoM2js";
    public static final String             ACCESS_TOKEN             = "803783491-je22x5xXKYPJN6VhYDOL0MNjjwBt1PVmWIyWowCF";
    public static final String             ACCESS_TOKEN_SECRET      = "ukWcU4j66gLqCWNvlDPdUso9jtlj3rGghwInqsS61K3iD";    
    public static final String             FILE_NAME                = System.getProperty("user.dir") + "\\page.html";    
    public static final Font               DEFAULT_FONT             = new Font("Helvetica Neue", Font.PLAIN, 12);
    public static final Color              DEFAULT_BACKGROUND_COLOR = new Color(29,161,242);
    public static final Color              DEFAULT_FOREGROUND_COLOR = new Color(255,255,255);        
    public static final String             APP_TITLE                = "Twitter Reader";
    public static final Font               CONTROL_FONT             = DEFAULT_FONT;
    public static final Color              CONTROL_BACKGROUND       = DEFAULT_BACKGROUND_COLOR;
    public static final int                APP_WIDTH                = 1010;
    public static final int                APP_HEIGHT               = 750;
    public static final Font               PANEL_BORDER_FONT        = DEFAULT_FONT;
    public static final int                TIMER_DELAY              = 100;
    public static final String             DEFAULT_TWITTER_USER     = "realDonaldTrump";    
    public static final LinkedList<String> DEFAULT_WATCH_WORDS      = new LinkedList<>(DEFAULT_WATCH_WORDS_ARRAY);    
    public static final int                LOW_PROGESSBAR_DELAY     = 10;
    public static final int                HIGH_PROGESSBAR_DELAY    = 500;
    public static final int                LOW_PROGESSBAR_AMOUNT    = 1;
    public static final int                HIGH_PROGESSBAR_AMOUNT   = 5;    
    public static final String             PROMPT_SELECT_LIST_WORD  = "Please select a word from the list!";    
    public static final String             PROMPT_TYPE_WORD_FIRST   = "Please type in a word first!";
    public static final String             PROMPT_TYPE_VALID_INFO   = "You must have a valid twiter user entered and/or a valid list of watch words to begin!";    
    public static final String             PROMPT_NOT_READING       = "Twitter feed currently not reading";    
    public static final String             PROMPT_READING_USER      = "Reading Twitter feed from @";
    public static final String             PROMPT_CANNOT_REPORT     = "Cannot create report file, please run feed first!";
    public static final String             PROMPT_REPORT_SAVED      = " has been saved!";    
    public static final String             APP_ICON_PATH            = "/year2019/cs40s/twitter/twitter.png";
    
    public static String                   twitterUser;
    public static LinkedList<String>       watchWords;    
    public static TwitterReader            twitterReader;
    public static WebPageBuilder           webPageBuilder;
    public static Dialogs                  dialog;
    public static FileHandler              fileHandler;
    
}
