
/** required package class namespace */
package year2019.cs40s.systemfilemanager;

/** required imports */
import java.io.File;

/**
 * FolderBuilder.java - the logic for copying a folder structure
 *
 * @author Mr. Wachs
 * @since 19-Sep-2018
 */
public class FolderBuilder 
{

    private File targetFolder;
    private File destinationFolder;

    /**
     * Sets the target folder to the parameter
     * 
     * @param targetFolder the target folder for the application
     */
    public void buildbuildSubFolderStructure(File targetFolder) {
        this.targetFolder = targetFolder;
    }

    /**
     * Sets the destination folder to the parameter
     * 
     * @param destinationFolder the destination folder for the application
     */
    public void copyOverFolderStructure(File destinationFolder) {
        this.destinationFolder = destinationFolder;
        copy(destinationFolder, targetFolder);
    }

    /**
     * Makes a copy of the target folder into the destination folder without
     * any of its files. It also recursively does this for all sub folders
     * 
     * @param destinationFolder the destination folder to copy into
     * @param targetFolder the target folder to copy from 
     */
    private static void copy(File destinationFolder, File targetFolder) {  
        File newFolder = new File(destinationFolder.getAbsolutePath() + 
                File.separator + targetFolder.getName());        
        newFolder.mkdir();        
        File[] files = targetFolder.listFiles();
        if (files != null) {    // not yet done, not at the bottom of the tree             
            for (File file : files) {       // go through all its sub folders
                if (file.isDirectory()) {
                  copy(newFolder, file);
                }
            }                    
        }
    }

}
