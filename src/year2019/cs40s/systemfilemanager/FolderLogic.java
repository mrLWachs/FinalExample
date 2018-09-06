/** required package class namespace */
package year2019.cs40s.systemfilemanager;

import java.io.File;
import javax.swing.JFileChooser;
import year2018.cs40s.io.Dialogs;



/**
 * LogicController.java - 
 *
 * @author Mr. Wachs 
 * @since 13-Sep-2018 
 */
public class FolderLogic 
{

    private JFileChooser  chooser;
    private FileToolsUI        userInterface;
    private File          targetFolder;
    private File          destinationFolder;
    private Dialogs       dialog;
    private FolderBuilder folderBuilder;
    
    
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
    
    public String selectTarget() {
        chooser.setDialogTitle(Enviromentals.SELECT_TARGET_DIALOG_TITLE);
        chooser.showOpenDialog(userInterface);
        targetFolder = chooser.getSelectedFile();
        String result = check();
        if (targetFolder != null) return buildSubFolderStructure(result);  
        else return "...";
    }

    public String selectDestination() {
        chooser.setDialogTitle(Enviromentals.SELECT_DESTINATION_DIALOG_TITLE);
        chooser.showOpenDialog(userInterface);
        destinationFolder = chooser.getSelectedFile();
        String result = check();
        if (destinationFolder != null) return copyOverFolderStructure(result);
        else return "...";
    }

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
    
    private String buildSubFolderStructure(String output) {
        output += "\nI will now start to build the sub-folder structure...";
        dialog.show(output);        
        folderBuilder.buildbuildSubFolderStructure(targetFolder);
        dialog.show("Complete!");
        return output;
    }

    private String copyOverFolderStructure(String output) {
        output += "\nI will now copy over the folder structure!";
        dialog.show(output);
        folderBuilder.copyOverFolderStructure(destinationFolder);
        dialog.show("Complete!");        
        return output;
    }

}
