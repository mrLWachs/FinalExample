
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


/**
 * TwitterReader.java - the logic engine to read, format and sort through 
 * tweets from Twitter based on a Twitter user name and a list of watch words 
 * to use for sorting. It connects with a user interface that will display
 * this data.
 *
 * @author Mr. Wachs 
 * @since 19-Mar-2019 
 */
public class TwitterReader 
{

    private final String ERROR_TIME_OUT = "Time out...";
    private final String ERROR_TWITTER  = "Twitter error";
    private final int    PAGE_COUNT     = 100;
    
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
     * 
     * @param allTweetDataListbox the list box for all tweets
     * @param relevantTweetsListbox the list box for relevant tweets
     * @param allTweetDataScrollPane the scroll pane for the list box
     * @param relevantTweetsScrollPane the scroll pane for the list box
     * @param allTweetDataListModel the model for the list box
     * @param relevantTweetsListModel the model for the list box 
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

    /**
     * Updates the UI from the twitter data read in by getting all the 
     * user's statuses from Twitter, formatting the tweets, then finding
     * the relevant tweets from the current watch list of words, and the
     * adding the relevant and total tweets to the list boxes in the UI
     */
    public void update() {
        twitter          = configure();
        rawStatuses      = getTweets(twitter);
        statuses         = format(rawStatuses);        
        relevantStatuses = find(statuses,
                UIModel.DEFAULT_WATCH_WORDS);
        if (allTweetDataListModel.getSize() < statuses.size()) {
            allTweetDataListModel.removeAllElements();
            relevantTweetsListModel.removeAllElements();  
            simpleOutput(statuses, relevantStatuses);
        }        
    }

    /**
     * Adds a tweet to the list box of all tweets
     * 
     * @param tweet the current tweet to add
     */
    private void display(Object tweet) {
        allTweetDataListModel.addElement(tweet.toString());
    }
    
    /**
     * Adds a tweet to the list box of relevant tweets
     * 
     * @param tweet the current tweet to add
     */
    private void displayRelevant(Object tweet) {
        relevantTweetsListModel.addElement(tweet.toString());
    }
    
    /**
     * Determines if the list of relevant tweets has any stored tweets at 
     * this point
     * 
     * @return there are tweets in the list (true) or not (false)
     */
    public boolean hasData() {
        if (relevantTweetsListModel.getSize() == 0) return false;
        else                                        return true;
    }
    
    /**
     * Creates a Twitter object to be used to read tweets off Twitter based 
     * on the Twitter user name as well as some Twitter development
     * credentials to log in and draw tweets from Twitter
     * 
     * @return A configured Twitter object connected to Twitter
     */
    private Twitter configure() {        
        ConfigurationBuilder configuration = new ConfigurationBuilder();
        configuration.setOAuthConsumerKey(UIModel.CONSUMER_KEY);
        configuration.setOAuthConsumerSecret(UIModel.CONSUMER_SECRET);
        configuration.setOAuthAccessToken(UIModel.ACCESS_TOKEN);
        configuration.setOAuthAccessTokenSecret(UIModel.ACCESS_TOKEN_SECRET);
        return new TwitterFactory(configuration.build()).getInstance();
    }
    
    /**
     * Gets all the tweets from the Twitter object (which is already set to a
     * specific Twitter user) into a list object
     * 
     * @param twitter the pre-configured Twitter object
     * @return a list of tweets from the Twitter user
     */
    private List getTweets(Twitter twitter) {
        int pageNumber = 1;
        List statuses = new ArrayList();
        while (true) {
            try {
                int    size = statuses.size();
                Paging page = new Paging(pageNumber++, PAGE_COUNT);
                statuses.addAll(twitter.getUserTimeline(
                        UIModel.twitterUser, page));
                if (statuses.size() == size) {
                    System.out.println(ERROR_TIME_OUT);
                    break;
                }
            } 
            catch (TwitterException e) {
                System.out.println(ERROR_TWITTER);
            }
        }
        return statuses;
    }
    
    /**
     * Formats the list of passed tweets into a format better to display in
     * the user interface
     * 
     * @param tweets the unformatted tweets
     * @return a list of the formatted tweets
     */
    private static ArrayList<String> format(List tweets) {
        final int    START_INDEX = 29;
        final int    END_INDEX   = 53;
        final char   APOSTROPHE  = (char)39;
        final String DELIMITER   = ": ";        
        ArrayList<String> formattedTweets = new ArrayList<>();
        for (Object tweet : tweets) {
            String  tweetText    = tweet.toString();
            String  date         = tweetText.substring(START_INDEX, END_INDEX);
            String  newTweetText = "";
            boolean done         = false;
            boolean reading      = false;
            int     i            = 0;
            while (i < tweetText.length() && !done) {        
                char character = tweetText.charAt(i);
                if (character == APOSTROPHE) {
                    if (!reading) reading = true;
                    else          done = true;
                } 
                else {
                    if (reading) newTweetText += character;  
                }
                i++;
            }
            newTweetText = date + DELIMITER + newTweetText;
            formattedTweets.add(newTweetText);
        }
        return formattedTweets;
    }

    /**
     * Finds all relevant tweets in the list of all tweets based on a list
     * of watch words to search through. It then returns the relevant tweets 
     * list
     * 
     * @param tweets the total tweets list to look through
     * @param keywords the list of watch words to search for
     * @return a list of relevant tweets
     */
    private static List find(List tweets, LinkedList<String> keywords) {
        List relevantTweets = new ArrayList();
        for (Object tweet : tweets) {
            String tweetText = tweet.toString();
            for (int i = 0; i < keywords.size(); i++) {
                String a = tweetText.toLowerCase();
                String b = keywords.get(i).toLowerCase();
                if (a.contains(b)) {
                    relevantTweets.add(tweet);
                    i = keywords.size();
                }
            }
        }
        return relevantTweets;
    }
    
    /**
     * This displays all the tweets from the pre-configured Twitter user, and 
     * the relevant tweets (based on the watch words list) from the Twitter
     * user in the user interface
     * 
     * @param allTweets all the tweets from the Twitter user
     * @param relevantTweets the relevant tweets from the Twitter user
     */
    private void simpleOutput(List allTweets, List relevantTweets) {
        final String OUTPUT_1 = "Total Tweets from @";
        final String OUTPUT_2 = " = ";
        final String OUTPUT_3 = "Total Relevant tweets = ";        
        display(OUTPUT_1 + UIModel.twitterUser + OUTPUT_2 + allTweets.size());
        for (Object tweet : allTweets) {
            display(tweet);
        }
        displayRelevant(OUTPUT_3 + relevantTweets.size());        
        for (Object tweet : relevantTweets) {
            displayRelevant(tweet);
        }
    }
    
}
