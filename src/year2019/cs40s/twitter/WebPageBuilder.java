
/** required package class namespace */
package year2019.cs40s.twitter;

/** required imports */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import year2018.cs40s.io.Dialogs;

/**
 * WebPageBuilder.java - 
 *
 * @author Mr. Wachs 
 * @since 19-Mar-2019 
 */
public class WebPageBuilder 
{

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
        this.ui = ui;
        filename = null;
    }

    public void build() {
        String text = UIModel.webPageBuilder.createWebpage(
                UIModel.twitterReader.statuses,
                UIModel.twitterReader.relevantStatuses);  
        filename = UIModel.FILE_NAME;
        File file = dialog.saveFile(ui);
        firstname = file.getAbsolutePath();
        middlename = file.getName();
        lastname = ".html";
        filename = firstname + lastname;
        UIModel.webPageBuilder.save(text, filename); 
    }

    public String createWebpage(List statuses, List relevantStatuses) {
        final String HEADER_1   = "<html><head><style>"
                + "body {"
                + "font-family:      \"Helvetica Neue\",Helvetica,Arial,"
                + "sans-serif;"
                + "background-color: rgb(29,161,242)     ; "
                + "font-size: 12pt;"
                + "color:            rgb(255,255,255) ;"
                + "line-height: 150%;"
                + ""
                + "}"
                + ""
                + "hr {"
                + "height: 5px;" 
                + "color: red;" 
                + "background-color: white;" 
                + "border: none;"
                + "}"
                + ""
                + "b {"
                + "color: rgb(170,184,194)"
                + "}"
                + "</style></head>";
        final String HEADER_2   = "<body>";
        final String HEADER_3   = "<h1>Total Tweets from @";        
        final String OUTPUT_1   = " read from Twitter was ";        
        final String OUTPUT_2   = "</h1><b>Search terms were:</b><i> ";
        final String OUTPUT_3   = "</i><h2>Total Relevant tweets sorted out was ";
        final String OUTPUT_4   = "</h2><hr/><ol>";
        final String LIST_OPEN  = "<li>";
        final String LIST_CLOSE = "</li>";        
        final String FOOTER     = "</ol></body></html>";        
        String text = HEADER_1 + HEADER_2 + HEADER_3 + 
                UIModel.twitterUser + OUTPUT_1 + 
                statuses.size() + OUTPUT_2;        
        for (int i = 0; i < UIModel.DEFAULT_WATCH_WORDS.size()-1; i++) {
            text += UIModel.DEFAULT_WATCH_WORDS.get(i) + ", ";
        }        
        text += UIModel.DEFAULT_WATCH_WORDS.get(UIModel.DEFAULT_WATCH_WORDS.size()-1) + 
                OUTPUT_3 + relevantStatuses.size() + OUTPUT_4;
        for (Object line : relevantStatuses) {
            text += LIST_OPEN + line + LIST_CLOSE;                        
        }        
        text += FOOTER;
        return text;
    }
    
    public void save(String text, String filename) {
        try {
            FileWriter stream = new FileWriter(filename);
            PrintWriter file  = new PrintWriter(stream);
            file.print(text);
            file.close();            
        } catch (IOException e) {
            System.out.println("File error");
        }
    }
    
}
