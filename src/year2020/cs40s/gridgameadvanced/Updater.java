
/** required package class namespace */
package year2020.cs40s.gridgameadvanced;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;

 
/**
 * Updater.java - description
 *
 * @author Mr. Wachs
 * @since Jan. 7, 2020, 12:55:37 p.m.
 */
public class Updater 
{

    private static JList<String>    statusList;
    private static DefaultListModel listModel;
    private static JScrollPane      statusScrollPane1;
    
    
    public static void update(String message) {
        listModel.addElement(message);
        statusList.ensureIndexIsVisible(listModel.getSize() - 1);
    }
    
    public static void init(
            JList<String>    statusList,
            DefaultListModel listModel,
            JScrollPane      statusScrollPane1) {
        Updater.statusList        = statusList;
        Updater.listModel         = listModel;
        Updater.statusScrollPane1 = statusScrollPane1;           
    }    

}
