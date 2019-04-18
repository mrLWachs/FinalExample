
/** required package class namespace */
package year2019.cs40s.twitter;

/** required imports */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


/**
 * WebPageBuilder.java - creates a formatted (using C.S.C. styles) web page
 *
 * @author Mr. Wachs 
 * @since 19-Mar-2019 
 */
public class WebPageBuilder 
{

    private final String OPEN_PAGE              = "<html><head>";    
    private final String OPEN_STYLE             = "<body><style>";
    private final String STYLE_BODY_OPEN        = "body {";
    private final String STYLE_FONT_FAMILY      = "font-family: "
                                                  + "\"Helvetica Neue"
                                                  + "\",\"Helvetica\","
                                                  + "Arial,sans-serif;";
    private final String STYLE_FONT_SIZE        = "font-size: 12pt;";
    private final String STYLE_BACKGROUND_COLOR = "background-color: "
                                                  + "rgb(29,161,242);";
    private final String STYLE_FOREGROUND_COLOR = "color: rgb(255,255,255);";    
    private final String STYLE_LINE_HEIGHT      = "line-height: 150%;";
    private final String STYLE_BODY_CLOSE       = "}";
    private final String STYLE_HR_OPEN          = "hr {";
    private final String STYLE_HR_HEIGHT        = "height: 5px;";
    private final String STYLE_HR_COLOR         = "color: red;";
    private final String STYLE_HR_BACKCOLOR     = "background-color: white;";
    private final String STYLE_HR_BORDER        = "border: none;";
    private final String STYLE_HR_CLOSE         = "}";
    private final String STYLE_BOLD_OPEN        = "b {";
    private final String STYLE_BOLD_COLOR       = "color: rgb(170,184,194);";    
    private final String STYLE_BOLD_CLOSE       = "}";    
    private final String STYLE                  = STYLE_BODY_OPEN +
                                                  STYLE_FONT_FAMILY +
                                                  STYLE_FONT_SIZE +
                                                  STYLE_BACKGROUND_COLOR +
                                                  STYLE_FOREGROUND_COLOR +
                                                  STYLE_LINE_HEIGHT +
                                                  STYLE_BODY_CLOSE +
                                                  STYLE_HR_OPEN + 
                                                  STYLE_HR_HEIGHT +
                                                  STYLE_HR_COLOR + 
                                                  STYLE_HR_BACKCOLOR + 
                                                  STYLE_HR_BORDER + 
                                                  STYLE_HR_CLOSE + 
                                                  STYLE_BOLD_OPEN +
                                                  STYLE_BOLD_COLOR + 
                                                  STYLE_BOLD_CLOSE;    
    private final String CLOSE_STYLE            = "</style></head><body>";    
    private final String OPEN_H1                = "<h1>";
    private final String CLOSE_H1               = "</h1>";
    private final String OPEN_H2                = "</h2>";
    private final String CLOSE_H2               = "</h2>";    
    private final String OPEN_BOLD              = "<b>";
    private final String CLOSE_BOLD             = "</b>";
    private final String OPEN_ITALIC            = "<i>";
    private final String CLOSE_ITALIC           = "</i>";
    private final String OPEN_BULLET_LIST       = "<ol>";
    private final String CLOSE_BULLET_LIST      = "</ol>";    
    private final String OPEN_LIST_ITEM         = "<li>";
    private final String CLOSE_LIST_ITEM        = "</li>";    
    private final String HORIZONTAL_LINE        = "<hr />";
    private final String CLOSE_PAGE             = "</body></html>";
    
    public String filename;
    public String firstname;
    public String middlename;    
    public String lastname;
        
    private Dialogs dialog;
    private UIView  ui;
    
    
    /**
     * Default constructor for the class, sets class properties
     */
    public WebPageBuilder(Dialogs dialog, UIView ui) {
        this.dialog = dialog;
        this.ui     = ui;
        filename    = null;
        UIModel.fileHandler = new FileHandler(UIModel.dialog);
    }

    /**
     * Creates a web page from the user interface data and saves it to a 
     * user chosen file location and name
     */
    public void build() {
        String text = createWebpage(
                UIModel.twitterReader.statuses,
                UIModel.twitterReader.relevantStatuses);  
        filename   = UIModel.FILE_NAME;
        File file  = dialog.saveFile(ui);
        firstname  = file.getAbsolutePath();
        middlename = file.getName();
        lastname   = ".html";
        filename   = firstname + lastname;
        UIModel.fileHandler.save(text, filename); 
    }

    /**
     * 
     * 
     * @param tweets
     * @param relevantTweets
     * @return 
     */
    public String createWebpage(List tweets, List relevantTweets) {
        final String START      = OPEN_PAGE + OPEN_STYLE + STYLE + CLOSE_STYLE;
        final String OUTPUT_1   = OPEN_H1 + "Total Tweets from @";        
        final String OUTPUT_2   = " read from Twitter was ";        
        final String OUTPUT_3   = CLOSE_H1 + OPEN_BOLD + "Search terms were:" + 
                                  CLOSE_BOLD + OPEN_ITALIC;
        final String OUTPUT_4   = CLOSE_ITALIC + OPEN_H2 + 
                                  "Total Relevant tweets sorted out was ";
        final String OUTPUT_5   = CLOSE_H2 + HORIZONTAL_LINE + OPEN_BULLET_LIST;    
        final String END        = CLOSE_BULLET_LIST + CLOSE_PAGE;      
        String text = START + OUTPUT_1 + UIModel.twitterUser + OUTPUT_2 + 
                      tweets.size() + OUTPUT_3;  
        for (int i = 0; i < UIModel.DEFAULT_WATCH_WORDS.size()-1; i++) {
            text += UIModel.DEFAULT_WATCH_WORDS.get(i) + ", ";
        }        
        text += UIModel.DEFAULT_WATCH_WORDS.get(
                UIModel.DEFAULT_WATCH_WORDS.size()-1) + 
                OUTPUT_4 + relevantTweets.size() + OUTPUT_5;
        for (Object tweet : relevantTweets) {
            text += OPEN_LIST_ITEM + tweet + CLOSE_LIST_ITEM;                        
        }        
        text += END;
        return text;
    }
    
}
