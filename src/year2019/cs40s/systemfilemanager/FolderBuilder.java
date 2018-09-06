/** required package class namespace */
package year2019.cs40s.systemfilemanager;

import java.io.File;

/**
 * FolderBuilder.java -
 *
 * @author Mr. Wachs
 * @since 19-Sep-2018
 */
public class FolderBuilder 
{

    private File targetFolder;
    private File destinationFolder;

    public void buildbuildSubFolderStructure(File targetFolder) {
        this.targetFolder = targetFolder;
    }

    public void copyOverFolderStructure(File destinationFolder) {
        this.destinationFolder = destinationFolder;
        copy(destinationFolder, targetFolder);
    }

    private static void copy(File destinationFolder, File targetFolder) {  
        File newFolder = new File(destinationFolder.getAbsolutePath() + 
                File.separator + targetFolder.getName());        
        newFolder.mkdir();        
        File[] files = targetFolder.listFiles();
        if (files != null) {    // not yet done, not at the bottom of the tree             
            for (File file : files) {   // go through all its sub folders
                if (file.isDirectory()) {
                  copy(newFolder, file);
                }
            }                    
        }
    }

}
