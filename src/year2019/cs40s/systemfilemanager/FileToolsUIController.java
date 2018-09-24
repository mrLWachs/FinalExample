
/** required package class namespace */
package year2019.cs40s.systemfilemanager;

/** required imports */
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import mainpackage.Examples2018;
import year2018.cs30s.tools.FrameTools;


/**
 * FileToolsUIController.java - the user interface controller for the 
 * application
 *
 * @author Mr. Wachs 
 * @since 21-Sep-2018 
 */
public class FileToolsUIController 
{
    
    private JButton      selectTargetFolderButton;
    private JButton      selectDestinationFolderButton;
    private JButton      selectFolderButton;
    private JButton      selectClassListButton;
    private JButton      executeButton;
    private JLabel       applicationTitleLabel;
    private JLabel       executeLabel;       
    private JPanel       fileDuplicatorPanel;
    private JPanel       fileCopierPanel;
    private JTextArea    informationTextArea;
    private JTextArea    fileDuplicatorTextArea;
    private JTextArea    fileCopierTextArea;    
    private JTextArea    folderCopierDestinationTextArea;
    private JTextArea    folderCopierTargetTextArea;
    private JTextArea    fileDuplicatorClassListTextArea;
    private JTextArea    fileDuplicatorTargetTextArea;
    private FileToolsUI  userInterface;
    private FolderLogic  folderLogic;
    private RenamerLogic renamerLogic;
    
    
    /**
     * Constructor for the class sets class properties
     * 
     * @param selectFolderButton UI button
     * @param selectClassListButton UI button
     * @param executeButton UI button
     * @param selectTargetFolderButton UI button
     * @param selectDestinationFolderButton UI button
     * @param applicationTitleLabel UI label
     * @param executeLabel UI label
     * @param fileDuplicatorPanel UI panel
     * @param fileCopierPanel UI panel
     * @param fileDuplicatorTextArea UI text area
     * @param informationTextArea UI text area
     * @param fileCopierTextArea UI text area
     * @param folderCopierDestinationTextArea UI text area
     * @param folderCopierTargetTextArea UI text area
     * @param fileDuplicatorClassListTextArea UI text area
     * @param fileDuplicatorTargetTextArea UI text area
     * @param userInterface the user interface form
     */
    public FileToolsUIController(
            JButton selectFolderButton, 
            JButton selectClassListButton, 
            JButton executeButton, 
            JButton selectTargetFolderButton, 
            JButton selectDestinationFolderButton, 
            JLabel applicationTitleLabel, 
            JLabel executeLabel, 
            JPanel fileDuplicatorPanel, 
            JPanel fileCopierPanel, 
            JTextArea fileDuplicatorTextArea, 
            JTextArea informationTextArea, 
            JTextArea fileCopierTextArea, 
            JTextArea folderCopierDestinationTextArea, 
            JTextArea folderCopierTargetTextArea, 
            JTextArea fileDuplicatorClassListTextArea, 
            JTextArea fileDuplicatorTargetTextArea, 
            FileToolsUI userInterface) {        
        this.selectTargetFolderButton        = selectTargetFolderButton;
        this.selectDestinationFolderButton   = selectDestinationFolderButton;
        this.selectFolderButton              = selectFolderButton;
        this.selectClassListButton           = selectClassListButton;
        this.executeButton                   = executeButton;
        this.applicationTitleLabel           = applicationTitleLabel;
        this.executeLabel                    = executeLabel;
        this.fileDuplicatorPanel             = fileDuplicatorPanel;
        this.fileCopierPanel                 = fileCopierPanel;
        this.informationTextArea             = informationTextArea;
        this.fileDuplicatorTextArea          = fileDuplicatorTextArea;
        this.fileCopierTextArea              = fileCopierTextArea;
        this.folderCopierDestinationTextArea = folderCopierDestinationTextArea;
        this.folderCopierTargetTextArea      = folderCopierTargetTextArea;
        this.fileDuplicatorClassListTextArea = fileDuplicatorClassListTextArea;
        this.fileDuplicatorTargetTextArea    = fileDuplicatorTargetTextArea;
        this.userInterface                   = userInterface;
        folderLogic                          = new FolderLogic(userInterface);
        renamerLogic                         = new RenamerLogic(userInterface);        
        new FrameTools().startup(
                userInterface, 
                Enviromentals.APP_TITLE, 
                Enviromentals.UI_WIDTH, 
                Enviromentals.UI_HEIGHT, 
                false, true, false, false, 
                Enviromentals.DIALOG_BACKGROUND_COLOR, 
                Enviromentals.UI_ICON);                
    }
    
    /**
     * Select the destination folder for folder copy structure with a dialog
     */
    public void selectDestination() {
        String result = folderLogic.selectDestination();
        folderCopierDestinationTextArea.setText(result);
    }

    /**
     * Select the target folder for folder copy structure with a dialog
     */
    public void selectTarget() {
        String result = folderLogic.selectTarget();
        folderCopierTargetTextArea.setText(result);
    }

    /**
     * Select folder and file for duplication
     */
    public void selectFileAndFolder() {
        String result = renamerLogic.selectFileAndFolder();
        fileDuplicatorTargetTextArea.setText(result);
    }

    /**
     * Execute file duplication process
     */
    public void execute() {
        String result = renamerLogic.execute();
        executeLabel.setText(result);
    }

    /**
     * Select class list for duplication
     */
    public void selectClassList() {
        String result = renamerLogic.selectClassList();
        fileDuplicatorClassListTextArea.setText(result);
    }

    /**
     * The form is shutting down
     */
    public void shutDown() {
        userInterface.dispose();
        mainpackage.MainClass.gamesPlayed++;
        Examples2018.menu();
    }

}
