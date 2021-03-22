
/** Required package class namespace */
package year2021.cs40s.familytree.datastructures;

/** Required imports */
import year2021.cs40s.familytree.collections.LinkedList;
import year2021.cs40s.familytree.io.Dialogs;
import year2021.cs40s.familytree.io.FileHandler;
import java.awt.List;
import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;


/**
 * Globals.java - This class is a class that all other classes in the app 
 * can access for global variables and global methods. The use the "static"
 * keyword so all other classes "share" these and we don't have different 
 * versions fo this data. It uses common methods to many classes and common
 * data and data structures.
 *
 * @author Mr. Wachs' student 
 * @since Mar. 17, 2021 
 */
public class Globals 
{

    // Public contstants used across the app
    public static final String APP_TITLE    = "Family Tree Maker";    
    public static final String NAME_ERROR   = "Select a name from the list!";
    public static final String SELECT_ERROR = "Select a differnt name!";    
    public static final String ERROR        = "Sorry, please try again!\n\n";
    public static final String SAME         = "~~~";    
    public static final String FILE_NAME    = "saveData.txt";    
    public static final int    NEW_ENTRY    = -1;
    public static final int    NOT_SELECTED = -1;
    
    // Public data structures used across the app including some data 
    // structures like "LinkedList" we developed together in class and  
    // "Dialogs" and "FileHandler" that we also went over in our large
    // class examples
    public static LinkedList<Family>              families;
    public static Dialogs                         dialogs; 
    public static File                            saveFile;
    public static FileHandler<LinkedList<Family>> file; 
    
    
    /**
     * When the application (app) starts before any user interfaces (UI)
     * are shown to the user by access the permanent file where the app
     * data is stored.
     */
    public static void start() {
        try {                                       // Start try block
            
            // Instantiate all public shared data structures
            families = new LinkedList<>();          // create Linked List
            dialogs  = new Dialogs(APP_TITLE);      // create for dialogs
            file     = new FileHandler<>();         // create for files
            saveFile = new File(FILE_NAME);         // create file object
            
            if (saveFile.exists()) {                // check if file exists                
                // Here we use the FileHandler class method to open an 
                // object from the permanent file and return all the data
                // as the LinedList of Family objects which is what the 
                // generic type to save was set for the FileHandler class
                // when it was created (instantiated) in the properties
                // section above in this class
                families = file.openObject(saveFile);   // open file to list
                if (families == null) {                 // list has no data
                    families = new LinkedList<>();      // instantiate list
                }
            }
            else {                                  // File does not exist
                saveFile.createNewFile();           // create file on system
            }
        }
        catch (IOException error) {                 // File error occured
            System.out.println("Error Globals->start: " + error.toString());
        }
    }
    
    /**
     * When a user interface (UI) first starts (appears) to the user, set
     * certain properties and make it visible to the user
     * 
     * @param frame the user interface (UI) to start up
     * @param width the width (in pixels) to make the UI
     * @param height the height (in pixels) to make the UI
     */
    public static void startup(JFrame frame, int width, int height) {
        frame.setTitle(APP_TITLE);              // Set the top title
        frame.setSize(width, height);           // Set the UI size (in pixels)
        frame.setResizable(false);              // Remove resizing ability
        frame.setLocationRelativeTo(null);      // Center the UI on the screen
        frame.setVisible(true);                 // Make UI visible (appear)
    } 
    
    /**
     * Updates a AWT list (a user interface control object for the NetBeans
     * designer) with all the members of a family by putting all the family
     * full names into the list box (except the passed person will be
     * omitted (use null if no one to omit)
     * 
     * @param list the AWT list box to update
     * @param family the family object to use
     * @param person the person to omit from the list (or null)
     */
    public static void updateList(List list, Family family, Person person) {
        list.removeAll();                                   // clear list box
        for (int i = 0; i < family.members.size(); i++) {   // loop through
            Person member = family.members.get(i);          // get a person
            if (member.equals(person)) {                    // check if valid
                list.add(SAME);
            }
            else {
                list.add(member.toString());                // add to the list
            }
        }
    }
    
    /**
     * When the application (app) ends by the user closing any user interfaces 
     * (UI) and accessing the permanent file where the app data is stored and
     * saving the LinkedList of all families
     */
    public static void end() {
        file.saveObject(families, saveFile);
    }

}
