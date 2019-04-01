
/** required package class namespace */
package year2019.cs40s.twitter;

/** required imports */
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import java.util.ArrayList;
import java.util.List;
import twitter4j.Paging;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;
import year2018.cs40s.collections.LinkedList;

/**
 * TwitterReader.java - 
 *
 * @author Mr. Wachs 
 * @since 19-Mar-2019 
 */
public class TwitterReader 
{

    private JList<String>    allTweetDataListbox;
    private JList<String>    relevantTweetsListbox;
    private JScrollPane      allTweetDataScrollPane;
    private JScrollPane      relevantTweetsScrollPane;  
    private DefaultListModel allTweetDataListModel;
    private DefaultListModel relevantTweetsListModel;
    
    public Twitter twitter;
    public List rawStatuses;
    public List statuses;
    public List relevantStatuses;
    
    /**
     * Default constructor for the class, sets class properties
     */
    public TwitterReader(JList<String>    allTweetDataListbox,
                         JList<String>    relevantTweetsListbox,
                         JScrollPane      allTweetDataScrollPane,
                         JScrollPane      relevantTweetsScrollPane,
                         DefaultListModel allTweetDataListModel,
                         DefaultListModel relevantTweetsListModel) {
        this.allTweetDataListbox      = allTweetDataListbox;
        this.relevantTweetsListbox    = relevantTweetsListbox;
        this.allTweetDataScrollPane   = allTweetDataScrollPane;
        this.relevantTweetsScrollPane = relevantTweetsScrollPane;
        this.allTweetDataListModel    = allTweetDataListModel;
        this.relevantTweetsListModel  = relevantTweetsListModel;      
    }

    public void update() {
        twitter          = configure();
        rawStatuses      = getStatuses(twitter);
        statuses         = format(rawStatuses);        
        relevantStatuses = find(statuses,
                UIModel.DEFAULT_WATCH_WORDS);
        if (allTweetDataListModel.getSize() < statuses.size()) {
            allTweetDataListModel.removeAllElements();
            relevantTweetsListModel.removeAllElements();  
            simpleOutput(statuses, relevantStatuses);
        }        
    }

    private void display(Object data) {
        allTweetDataListModel.addElement(data.toString());
    }
    
    private void displayRelevant(Object data) {
        relevantTweetsListModel.addElement(data.toString());
    }
    
    public boolean hasData() {
        if (relevantTweetsListModel.getSize() == 0) return false;
        else                                        return true;
    }
    
    private Twitter configure() {        
        ConfigurationBuilder configuration = new ConfigurationBuilder();
        configuration.setOAuthConsumerKey(UIModel.CONSUMER_KEY);
        configuration.setOAuthConsumerSecret(UIModel.CONSUMER_SECRET);
        configuration.setOAuthAccessToken(UIModel.ACCESS_TOKEN);
        configuration.setOAuthAccessTokenSecret(UIModel.ACCESS_TOKEN_SECRET);
        return new TwitterFactory(configuration.build()).getInstance();
    }
    
    private List getStatuses(Twitter twitter) {
        int pageNumber = 1;
        List statuses = new ArrayList();
        while (true) {
            try {
                int    size = statuses.size();
                Paging page = new Paging(pageNumber++, 100);
                statuses.addAll(twitter.getUserTimeline(
                        UIModel.twitterUser, page));
                if (statuses.size() == size) {
                    System.out.println("Time out...");
                    break;
                }
            } 
            catch (TwitterException e) {
                System.out.println("Twitter error");
            }
        }
        return statuses;
    }
    
     private static ArrayList<String> format(List statuses) {
        ArrayList<String> list = new ArrayList<>();
        for (Object status : statuses) {
            String text = status.toString();
            String date = text.substring(29, 53);
            String newText = "";
            boolean done = false;
            boolean reading = false;
            final char APOSTROPHE = (char)39;
            int i = 0;
            while (i < text.length() && !done) {        
                char character = text.charAt(i);
                if (character == APOSTROPHE) {
                    if (!reading) reading = true;
                    else          done = true;
                } 
                else {
                    if (reading) newText += character;  
                }
                i++;
            }
            newText = date + ": " + newText;
            list.add(newText);
        }
        return list;
    }

    private static List find(List statuses, LinkedList<String> keywords) {
        List list = new ArrayList();
        for (Object status : statuses) {
            String text = status.toString();
            for (int i = 0; i < keywords.size(); i++) {
                String a = text.toLowerCase();
                String b = keywords.get(i).toLowerCase();
                if (a.contains(b)) {
                    list.add(status);
                    i = keywords.size();
                }
            }
        }
        return list;
    }
    
    private void simpleOutput(List statuses, List relevantStatuses) {
        display("Total Tweets from @" + UIModel.twitterUser +
                " = " + statuses.size());
        for (Object line : statuses) {
            display(line);
        }
        displayRelevant("Total Relevant tweets = " + relevantStatuses.size());        
        for (Object line : relevantStatuses) {
            displayRelevant(line);
        }
    }

    
}
