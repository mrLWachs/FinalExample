
/** required package class namespace */
package year2020.cs40s.awards.logic;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import year2020.cs40s.awards.collections.LinkedList;
import year2020.cs40s.awards.data.AwardRule;
import year2020.cs40s.awards.data.DataStructures;

 
/**
 * DataSaver.java - description
 *
 * @author Mr. Wachs
 * @since 27-May-2020, 12:16:10 AM
 */
public class DataSaver 
{

    private File file;
    
    /**
     * Default constructor, set class properties
     */
    public DataSaver() {
        try {
            URL  url = getClass().getResource(DataStructures.DATA_FILE);
            URI  uri = url.toURI();
            file     = new File(uri);
        }
        catch (URISyntaxException error) {
            System.out.println("File error: " + error.getMessage());
        }
    }
    
    public void save() {
        DataStructures.fileHandler.saveObject(DataStructures.rules, file);
    }
     
    
    public void open() {
        DataStructures.rules = (LinkedList<AwardRule>) 
                DataStructures.fileHandler.openObject(file);
        if (DataStructures.rules == null) {
            DataStructures.rules = new LinkedList<>();
        }
    }
    
}
