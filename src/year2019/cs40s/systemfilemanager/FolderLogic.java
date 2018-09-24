
/** required package class namespace */
package year2019.cs40s.systemfilemanager;

/** required imports */
import java.io.File;
import javax.swing.JFileChooser;
import year2018.cs40s.io.Dialogs;


/**
 * LogicController.java - the logic for copying a folder structure
 *
 * @author Mr. Wachs 
 * @since 13-Sep-2018 
 */
public class FolderLogic 
{

    private JFileChooser  chooser;
    private FileToolsUI   userInterface;
    private File          targetFolder;
    private File          destinationFolder;
    private Dialogs       dialog;
    private FolderBuilder folderBuilder;
    
    /**
     * Constructor for the class sets class properties
     * 
     * @param userInterface the user interface for the application
     */
    public FolderLogic(FileToolsUI userInterface) {
        this.userInterface = userInterface;
        chooser = new JFileChooser();           
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        dialog = new Dialogs(
                userInterface,
                Enviromentals.DIALOG_TYPE, 
                null,
                Enviromentals.DIALOG_FONT,
                Enviromentals.DIALOG_BACKGROUND_COLOR,
                Enviromentals.DIALOG_FOREGROUND_COLOR,
                Enviromentals.APP_TITLE);
        folderBuilder = new FolderBuilder();
    }
    
    /**
     * Selects the target folder to copy the folder structure from
     * 
     * @return the result of the operation message
     */
    public String selectTarget() {
        chooser.setDialogTitle(Enviromentals.SELECT_TARGET_DIALOG_TITLE);
        chooser.showOpenDialog(userInterface);
        targetFolder = chooser.getSelectedFile();
        String result = check();
        if (targetFolder != null) return buildSubFolderStructure(result);  
        else return "...";
    }

    /**
     * Selects the destination folder to copy the folder structure into
     * 
     * @return the result of the operation message 
     */
    public String selectDestination() {
        chooser.setDialogTitle(Enviromentals.SELECT_DESTINATION_DIALOG_TITLE);
        chooser.showOpenDialog(userInterface);
        destinationFolder = chooser.getSelectedFile();
        String result = check();
        if (destinationFolder != null) return copyOverFolderStructure(result);
        else return "...";
    }

    /**
     * Error checks the user's dialog selections to make sure the folders 
     * selected are valid
     * 
     * @return selections are valid (true) or not (false)
     */
    private String check() {
        String output = "";
        if (targetFolder == null) output = "Target folder      ->null";
        else                      output = "Target folder      ->" + 
                                             targetFolder.toString();        
        if (destinationFolder == null)  output += "\nDestination folder ->null"; 
        else                            output += "\nDestination folder ->" + 
                                                   destinationFolder.toString();        
        return output;
    }
    
    /**
     * Builds the initial folder structure to copy from
     * 
     * @param output the current message state 
     * @return the result of the operation message 
     */
    private String buildSubFolderStructure(String output) {
        output += "\nI will now start to build the sub-folder structure...";
        dialog.show(output);        
        folderBuilder.buildbuildSubFolderStructure(targetFolder);
        dialog.show("Complete!");
        return output;
    }

    /**
     * Copies the target folder structure over to the destination folder
     * 
     * @param output the current message state
     * @return the result of the operation message 
     */
    private String copyOverFolderStructure(String output) {
        output += "\nI will now copy over the folder structure!";
        dialog.show(output);
        folderBuilder.copyOverFolderStructure(destinationFolder);
        dialog.show("Complete!");        
        return output;
    }

}
