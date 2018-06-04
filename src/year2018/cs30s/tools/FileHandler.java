
/** required package class namespace */
package year2018.cs30s.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * FileHandler.java - various methods for saving and opening files
 *
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public class FileHandler 
{

    private String filename;
    
    public FileHandler(String filename) {
        this.filename = filename;
    }

    public String[] read() {
        try {
            URL            url    = getClass().getResource(filename); 
            URI            uri    = url.toURI();
            File           file   = new File(uri);
            FileReader     reader = new FileReader(file);
            BufferedReader buffer = new BufferedReader(reader);
            String         line   = buffer.readLine();
            if (line == null) return null;
            int            length = Integer.parseInt(line);
            String[]       lines  = new String[length-1];
            for (int i = 0; i < lines.length; i++) {
                lines[i]   = buffer.readLine();
            }
            buffer.close();
            return lines;
        }
        catch (IOException e) {
            System.out.println("I/O error");
        }
        catch (NullPointerException e) {
            System.out.println("Read Null error");
        }
        catch (URISyntaxException ex) {
            System.out.println("URI error");
        }
        return null;
    }

    public void write(String[] data) {
        try {
            URL         url     = getClass().getResource(filename); 
            URI         uri     = url.toURI();
            File        file    = new File(uri);
            if (!file.exists()) file.createNewFile();
            FileWriter  writer  = new FileWriter(file);
            PrintWriter printer = new PrintWriter(writer);
            for (int i = 0; i < data.length; i++) {
                printer.println(data[i]);
            }
            printer.close();
        }
        catch (IOException e) {
            System.out.println("I/O error");
        }
        catch (NullPointerException e) {
            System.out.println("Write Null error");
        }
        catch (URISyntaxException ex) {
            System.out.println("URI error");
        }
    }
    
    
    
}
