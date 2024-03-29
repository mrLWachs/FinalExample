
/** required package class namespace */
package year2019.cs40s.systemfilemanager;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

 
/**
 * FolderSystem.java - description
 *
 * @author Mr. Wachs
 * @since Jan. 29, 2020, 8:55:17 a.m.
 */
public class FolderSystem 
{

    private JTextArea textArea;
            
    /**
     * Default constructor, set class properties
     * @param textArea
     */
    public FolderSystem(JTextArea textArea) {
        this.textArea = textArea;
        File   namesList    = getTextFile();
        File[] files        = getSelectedFiles();
        File   parentFolder = getParentFolder();
        if (namesList == null) {
            String text = "The list of names file was invalid!";
            textArea.setText(text);
            JOptionPane.showMessageDialog(null, text,"Folder System Tools",
                    JOptionPane.WARNING_MESSAGE);
        }
        else if (files == null) {
            String text = "The files you selected to fill the folders were invalid!";
            textArea.setText(text);
            JOptionPane.showMessageDialog(null, text,"Folder System Tools",
                    JOptionPane.WARNING_MESSAGE);
        }
        else if (parentFolder == null) {
            String text = "The parent folder you selected was invalid!";
            textArea.setText(text);
            JOptionPane.showMessageDialog(null, text,"Folder System Tools",
                    JOptionPane.WARNING_MESSAGE);
        }
        else {
            createFolders(namesList,files,parentFolder);
            String text = textArea.getText();
            text += "\n" + "Operation successful!";
            textArea.setText(text);
        }
    }

    private File getTextFile() {
        JFileChooser chooser = new JFileChooser();
        final String[] FILTER_TYPES = { "txt" };
        FileFilter filter = new FileNameExtensionFilter("Text files", 
                FILTER_TYPES);
        chooser.setDialogTitle("Select Text file of all the names "
                + "to create folders for");
        chooser.setFileFilter(filter);
        chooser.addChoosableFileFilter(filter);
        chooser.setAcceptAllFileFilterUsed(false);
        int result = chooser.showOpenDialog(null);
        if(result == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            File selectedFile = new File(file.getAbsolutePath());
            String text = "Text File Selected was: " + file.getAbsolutePath();
            textArea.setText(text);
            return selectedFile;
        }        
        return null;
    }
    
    private File[] getSelectedFiles() {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Select all files to rename and fill the "
                + "folders with");
        chooser.setMultiSelectionEnabled(true);        
        int result = chooser.showOpenDialog(null);
        if(result == JFileChooser.APPROVE_OPTION) {
            File[] files = chooser.getSelectedFiles();
            String text = textArea.getText();
            text += "\n" + "Files to duplicate were selected...";
            textArea.setText(text);
            return files;
        }        
        return null;
    }

    private String[] getNames(File textfile) {
        try {
            int length = getLength(textfile);
            if (length == 0) return null;             
            FileReader     reader = new FileReader(textfile);
            BufferedReader file   = new BufferedReader(reader);
            String[]       names  = new String[length];
            String         line   = file.readLine();
            int            i      = 0;
            while(line != null) {
                names[i] = line;
                i++;
                line = file.readLine();
            }
            file.close();            
            return names;
        } 
        catch (IOException e) {
            System.out.println("File error");
            return null;
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array out of bounds error");
            return null;
        }
        catch (NullPointerException e) {
            System.out.println("Null error");
            return null;
        }
    }

    private int getLength(File textfile) {
        try {            
            FileReader     reader = new FileReader(textfile);
            BufferedReader file   = new BufferedReader(reader);
            int length  = 0;
            String line = file.readLine();
            while(line != null) {   
                length++;
                line = file.readLine();
            }
            file.close();  
            return length;            
        } 
        catch (IOException e) {
            System.out.println("File error");
            return 0;
        }
        catch (NullPointerException e) {
            System.out.println("Null error");
            return 0;
        }
    }
    
    private File getParentFolder() {
        JFileChooser chooser = new JFileChooser();       
        chooser.setDialogTitle("Select Parent Folder to put the "
                + "folders into...");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        int result = chooser.showOpenDialog(null);        
        if (result == JFileChooser.APPROVE_OPTION) { 
            File file = chooser.getSelectedFile();   
            String text = textArea.getText();
            text += "\n" + "Parent folder selected: " + file.getAbsolutePath();
            textArea.setText(text);
            return file;
        }
        return null;
    }

    private void createFolders(File namesList, File[] files, File parentFolder) {
        try {
            String   parentPath = parentFolder.getAbsolutePath();        
            String[] names      = getNames(namesList);
            for (int i = 0; i < names.length; i++) {
                String name          = names[i];
                String newFolderPath = parentPath + File.separator + name;
                File   newFolder     = new File(newFolderPath);
                newFolder.mkdir();
                for (int f = 0; f < files.length; f++) {
                    File   sourceFile = files[f];
                    String firstName  = newFolderPath;
                    String middleName = name;
                    String lastName   = sourceFile.getName();
                    String fileName   = firstName  + File.separator +
                                        middleName + " " + lastName; 
                    File   targetFile = new File(fileName);    
                    Files.copy(sourceFile.toPath(), targetFile.toPath());
                }
            }
        } catch (IOException error) {
            System.out.println("Error: " + error.toString());
        }
    }    
}

