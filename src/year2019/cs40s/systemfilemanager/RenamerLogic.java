
/** required package class namespace */
package year2019.cs40s.systemfilemanager;

/** required imports */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;


/**
 * LogicController.java - the logic controller for the user interface for this
 * application
 *
 * @author Mr. Wachs 
 * @since 12-Sep-2018 
 */
public class RenamerLogic 
{

    private JFileChooser  chooser; 
    private File          startingFolder;
    private File          selectedFolder;
    private File          selectedFile;    
    private File          selectedTextFile;
    private String        startingPathName;
    private String        selectedFolderPath; 
    private String        selectedTextFileName;
    private String        selectedFileExtention;
    private FileToolsUI userInterface;  
    
    
    /**
     * Constructor for the class sets class properties
     * 
     * @param userInterface the user interface frame
     */
    public RenamerLogic(FileToolsUI userInterface) {
        this.userInterface = userInterface;
        initDataStructures();
    }
    
    /**
     * User selects a file and folder
     * 
     * @return the text result of this operation
     */
    public String selectFileAndFolder() {
        chooser = new JFileChooser();
        chooser.setCurrentDirectory(startingFolder);        
        chooser.setAcceptAllFileFilterUsed(false);
        chooser.setDialogTitle(Enviromentals.DIRECTORY_CHOOSER_TITLE);
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        if (chooser.showOpenDialog(userInterface) == 
            JFileChooser.APPROVE_OPTION) {            
            selectedFolder        = chooser.getCurrentDirectory();
            selectedFile          = chooser.getSelectedFile();            
            selectedFolderPath    = selectedFolder.getAbsolutePath();
            selectedFileExtention = selectedFile.getName();
            return "Folder:" + selectedFolderPath + 
                    "<- with file ->" + selectedFileExtention;
        }
        else {
            return "...";
        }
    }

    /**
     * User selects a class list
     * 
     * @return the text result of this operation 
     */
    public String selectClassList() {
                String[] FILE_TYPES = {"txt"};
        FileFilter filter = new FileNameExtensionFilter("Text files", 
                FILE_TYPES);
        chooser = new JFileChooser();
        chooser.setCurrentDirectory(startingFolder);        
        chooser.setAcceptAllFileFilterUsed(false);
        chooser.setDialogTitle(Enviromentals.TEXT_FILE_CHOOSER_TITLE);
        chooser.setFileFilter(filter);
        chooser.addChoosableFileFilter(filter);           
        if (chooser.showOpenDialog(userInterface) == 
            JFileChooser.APPROVE_OPTION) {            
            selectedTextFile = chooser.getSelectedFile();
            if (selectedTextFile == null) {
                return "...";
            }
            else {
                selectedTextFileName = selectedTextFile.getAbsolutePath();
                return selectedTextFileName;
            }
        }
        else {
            return "...";
        }
    }
    
    /**
     * The file rename and duplication is error checked and executed
     * 
     * @return the text result of this operation
     */
    public String execute() {
        if (isReady()) {
            String students[] = getStudents();        
            for (int i = 0; i < students.length; i++) {            
                try {
                    String newFileName = selectedFolderPath + "\\" + 
                            students[i] + " " + selectedFileExtention;                
                    File file = new File(newFileName);      
                    Files.copy(selectedFile.toPath(), file.toPath());
                } catch (IOException error) {
                    System.out.println("Error: " + error.toString());
                }
            }
            return "Check folder for the new files...";
        }
        else {
            return "Please make all selections above first!";
        }
    }
    
    /**
     * Initializes the data structures for the class
     */
    private void initDataStructures() {
        startingPathName = System.getProperty("user.home");
        startingFolder   = new File(startingPathName);
    }
    
    /**
     * Gets the student names from the selected text file
     * 
     * @return an array of student names from the text file
     */
    private String[] getStudents() {        
        try {
            FileReader     reader   = new FileReader(selectedTextFileName);
            BufferedReader file     = new BufferedReader(reader);
            String         line     = file.readLine();
            int            length   = Integer.parseInt(line);
            String[]       students = new String[length];
            int            i        = 0;
            line                    = file.readLine();
            while (line != null) {
                students[i] = line;                
                i++;
                line = file.readLine();
            }
            return students;       
        }
        catch(IOException error) {
            System.out.println("Error: " + error.toString());
            return null;
        }
    }

    /**
     * Checks to see if the execute operation can be executed
     * 
     * @return the execute operation is ready (true) or not (false)
     */
    private boolean isReady() {
        if (selectedFolderPath == null)       return false;
        if (selectedFolderPath.equals(""))    return false;
        if (selectedFileExtention == null)    return false;
        if (selectedFileExtention.equals("")) return false;
        if (selectedTextFileName == null)     return false;
        if (selectedTextFileName.equals(""))  return false;
        if (selectedFile == null)             return false;
        return true;
    }
        
}





