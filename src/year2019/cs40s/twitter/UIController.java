
/** required package class namespace */
package year2019.cs40s.twitter;

/** required imports */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.Timer;
import javax.swing.border.TitledBorder;


/**
 * UIController.java - the controller class (based on MVC model) for the 
 * application user interface
 *
 * @author Mr. Wachs 
 * @since 12-Mar-2019 
 */
public class UIController 
{

    private JButton          createReportFileButton;
    private JButton          clearButton;
    private JButton          addButton;
    private JButton          removeButton;
    private JLabel           startAndStopLabel;
    private JLabel           twitterUserLabel;
    private JLabel           addWatchWordLabel;
    private JLabel           timeAndDateLabel;
    private JList<String>    allTweetDataListbox;
    private JList<String>    watchWordListbox;
    private JList<String>    relevantTweetsListbox;
    private JPanel           allTweetDataPanel;
    private JPanel           relevantTweetDataPanel;
    private JPanel           tweetCommandsPanel;
    private JProgressBar     loadingProgressbar;
    private JScrollPane      allTweetDataScrollPane;
    private JScrollPane      watchWordScrollPane;
    private JScrollPane      relevantTweetsScrollPane;
    private JTextField       twitterUserTextbox;
    private JTextField       addWatchWordTextbox;
    private JToggleButton    startStopToggleButton;
    private JComponent[]     controls;
    private JFrame           ui;    
    private DefaultListModel allTweetDataListModel;
    private DefaultListModel watchWordListModel;
    private DefaultListModel relevantTweetsListModel;    
    private Timer            timer;
    private int              counter;
    
    
    /**
     * Default constructor for the class, sets class properties
     * 
     * @param controls an array of all user interface control objects 
     * @param ui the user interface (view)
     */
    public UIController(JComponent[] controls, UIView ui) {
        this.controls            = controls;
        this.ui                  = ui;
        // associate all objects inthe array
        createReportFileButton   = (JButton)      this.controls[0];
        clearButton              = (JButton)      this.controls[1];
        addButton                = (JButton)      this.controls[2];
        removeButton             = (JButton)      this.controls[3];
        startAndStopLabel        = (JLabel)       this.controls[4];
        twitterUserLabel         = (JLabel)       this.controls[5];
        addWatchWordLabel        = (JLabel)       this.controls[6];
        timeAndDateLabel         = (JLabel)       this.controls[7];
        allTweetDataListbox      = (JList<String>)this.controls[8];
        watchWordListbox         = (JList<String>)this.controls[9];
        relevantTweetsListbox    = (JList<String>)this.controls[10];
        allTweetDataPanel        = (JPanel)       this.controls[11];
        relevantTweetDataPanel   = (JPanel)       this.controls[12];
        tweetCommandsPanel       = (JPanel)       this.controls[13];
        loadingProgressbar       = (JProgressBar) this.controls[14];
        allTweetDataScrollPane   = (JScrollPane)  this.controls[15];
        watchWordScrollPane      = (JScrollPane)  this.controls[16];
        relevantTweetsScrollPane = (JScrollPane)  this.controls[17];
        twitterUserTextbox       = (JTextField)   this.controls[18];
        addWatchWordTextbox      = (JTextField)   this.controls[19];
        startStopToggleButton    = (JToggleButton)this.controls[20];
        // instantiate all list models
        allTweetDataListModel    = new DefaultListModel();
        watchWordListModel       = new DefaultListModel();
        relevantTweetsListModel  = new DefaultListModel();
        // set list models to the UI list box controls
        allTweetDataListbox.setModel(   allTweetDataListModel   );
        watchWordListbox.setModel(      watchWordListModel      );
        relevantTweetsListbox.setModel( relevantTweetsListModel );
        // associate model objects with their defaults
        UIModel.twitterUser = UIModel.DEFAULT_TWITTER_USER;
        UIModel.watchWords  = UIModel.DEFAULT_WATCH_WORDS;
        // instantiate the Twitter reader object
        UIModel.twitterReader = new TwitterReader(
                        allTweetDataListbox, 
                        relevantTweetsListbox, 
                        allTweetDataScrollPane, 
                        relevantTweetsScrollPane, 
                        allTweetDataListModel, 
                        relevantTweetsListModel);
        // instantiate a UI icon
        ImageIcon icon = new ImageIcon(
                getClass().getResource(UIModel.APP_ICON_PATH));
        // instantiate the dialogs used by the application
        UIModel.dialog = new Dialogs(
                ui, 
                JOptionPane.PLAIN_MESSAGE, 
                icon, 
                UIModel.DEFAULT_FONT, 
                Dialogs.DEFAULT_BACKGROUND_COLOR,
                Dialogs.DEFAULT_FOREGROUND_COLOR, 
                UIModel.APP_TITLE);
        // instantiate the web page builder object
        UIModel.webPageBuilder = new WebPageBuilder(UIModel.dialog, ui);
        // assign all UI controls the font and colors
        for (JComponent control : controls) {
            control.setFont(UIModel.CONTROL_FONT);
            control.setBackground(UIModel.CONTROL_BACKGROUND);
            control.setForeground(UIModel.DEFAULT_FOREGROUND_COLOR);            
        }
        // assign progress bar control the font and colors
        loadingProgressbar.setBackground(UIModel.CONTROL_BACKGROUND);
        loadingProgressbar.setForeground(UIModel.DEFAULT_FOREGROUND_COLOR);
        // assign control borders the font and colors
        ((TitledBorder)allTweetDataPanel.getBorder()).setTitleFont(
                UIModel.PANEL_BORDER_FONT);
        ((TitledBorder)relevantTweetDataPanel.getBorder()).setTitleFont(
                UIModel.PANEL_BORDER_FONT);
        ((TitledBorder)tweetCommandsPanel.getBorder()).setTitleFont(
                UIModel.PANEL_BORDER_FONT);        
        ((TitledBorder)allTweetDataPanel.getBorder()).setTitleColor(
                UIModel.DEFAULT_FOREGROUND_COLOR);
        ((TitledBorder)relevantTweetDataPanel.getBorder()).setTitleColor(
                UIModel.DEFAULT_FOREGROUND_COLOR);
        ((TitledBorder)tweetCommandsPanel.getBorder()).setTitleColor(
                UIModel.DEFAULT_FOREGROUND_COLOR);
        // set the text for the Twitter user from the default
        twitterUserTextbox.setText(UIModel.twitterUser);     
        // set all the watch words from the model into the list box control        
        for (int i = 0; i < UIModel.watchWords.size(); i++) {
            watchWordListModel.addElement(UIModel.watchWords.get(i));
        }
        int lastIndex = watchWordListModel.getSize() - 1;
        watchWordListbox.ensureIndexIsVisible(lastIndex);
        // instantiate the timer control        
        timer = new Timer(UIModel.TIMER_DELAY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tick();
            }
        });
        counter = 0;
        // set the properties of the user interface view
        this.ui.setIconImage(icon.getImage());
        this.ui.setBackground(UIModel.CONTROL_BACKGROUND);
        this.ui.getContentPane().setBackground(UIModel.CONTROL_BACKGROUND);
        this.ui.setTitle(UIModel.APP_TITLE);
        this.ui.setSize(UIModel.APP_WIDTH, UIModel.APP_HEIGHT);
        this.ui.setResizable(false);
        this.ui.setLocationRelativeTo(null);
        this.ui.setVisible(true);
    }

    /**
     * Creates the report file of the data the user interface for the 
     * application has generated as a web page file
     */
    public void createReportFile() {
        if (UIModel.twitterReader.hasData()) {
            UIModel.webPageBuilder.build();
            timeAndDateLabel.setText(UIModel.webPageBuilder.middlename + 
                                     UIModel.webPageBuilder.lastname + 
                                     UIModel.PROMPT_REPORT_SAVED);
        }
        else {
            UIModel.dialog.show(UIModel.PROMPT_CANNOT_REPORT);
            timeAndDateLabel.setText(UIModel.PROMPT_CANNOT_REPORT);
        }
    }

    /**
     * Starts and stops the user interface progress bar and periodically
     * keeps updating the Twitter data (if a change has occurred)
     */
    public void startStop() {        
        if (UIModel.watchWords.isEmpty() ||
            twitterUserTextbox.getText() == null ||
            twitterUserTextbox.getText().equals("")) {
            UIModel.dialog.show(UIModel.PROMPT_TYPE_VALID_INFO);
            startStopToggleButton.setSelected(false);
        }
        else {
            if (timer.isRunning()) {                
                createReportFileButton.setEnabled(true);
                clearButton.setEnabled(true);
                addButton.setEnabled(true);
                removeButton.setEnabled(true);
                twitterUserTextbox.setEnabled(true);
                addWatchWordTextbox.setEnabled(true);
                watchWordListbox.setEnabled(true);                
                timer.stop();
                startAndStopLabel.setText(UIModel.PROMPT_NOT_READING);
                counter = 0;
                loadingProgressbar.setValue(counter);                
            }
            else {                
                UIModel.twitterUser = twitterUserTextbox.getText();
                createReportFileButton.setEnabled(false);
                clearButton.setEnabled(false);
                addButton.setEnabled(false);
                removeButton.setEnabled(false);
                twitterUserTextbox.setEnabled(false);
                addWatchWordTextbox.setEnabled(false);
                watchWordListbox.setEnabled(false);                
                timer.start();
                startAndStopLabel.setText(UIModel.PROMPT_READING_USER + 
                        UIModel.twitterUser);    
                UIModel.twitterReader.update();
            }
        }
    }

    /**
     * Adds the user entered word into the list of watch words
     */
    public void addWord() {
        String word = addWatchWordTextbox.getText();
        if (word == null || word.equals("")) {            
            UIModel.dialog.show(UIModel.PROMPT_TYPE_WORD_FIRST);
            addWatchWordTextbox.requestFocus();
        }
        else {
            UIModel.watchWords.add(word);
            addAndSelect(watchWordListbox, watchWordListModel, word);
            addWatchWordTextbox.setText("");
        }        
    }

    /**
     * Removes the user selected word from the list of watch words
     */
    public void removeWord() {
        String word = watchWordListbox.getSelectedValue();
        if (word == null) {
            UIModel.dialog.show(UIModel.PROMPT_SELECT_LIST_WORD);
        }
        else {
            int index = watchWordListbox.getSelectedIndex();
            watchWordListModel.remove(index);
            UIModel.watchWords.remove(index);
        }        
    }

    /**
     * Clears out the list of watch words completely
     */
    public void clearWords() {
        watchWordListModel.removeAllElements();
        UIModel.watchWords.clear();
        addWatchWordTextbox.setText("");
    }
    
    /**
     * Adds the passed value to the passed list box and moves the focus of the
     * list box to the newly added value
     * 
     * @param list the list of values used by the list box
     * @param model the model used by the list box
     * @param value the value to add to the list box
     */
    private void addAndSelect(JList list, DefaultListModel model, 
            String value) {
        model.addElement(value);
        int lastIndex = model.getSize() - 1;
        list.ensureIndexIsVisible(lastIndex);
        list.setSelectedIndex(lastIndex);
    }
    
    /**
     * The tick event by the timer to advance the progress bar and periodically 
     * update the Twitter data
     */
    private void tick() {       
        int delay  = Randomizer.generate(
                UIModel.LOW_PROGESSBAR_DELAY, 
                UIModel.HIGH_PROGESSBAR_DELAY);
        int amount = Randomizer.generate(
                UIModel.LOW_PROGESSBAR_AMOUNT, 
                UIModel.HIGH_PROGESSBAR_AMOUNT);
        timer.setDelay(delay);
        counter += amount;
        if (counter >= loadingProgressbar.getMaximum()) {
            counter = 0;
            UIModel.twitterReader.update();
        }
        loadingProgressbar.setValue(counter);
    }

}
