
/** required package class namespace */
package year2020.cs40s.awards;

import year2020.cs40s.awards.data.DataStructures;
import year2020.cs40s.awards.userinterfaces.LoadingView;
import year2020.cs40s.awards.userinterfaces.MainUIView;


/**
 * MainClass.java - 
 *
 * @author Mr. Wachs 
 * @since 19-May-2020 
 */ 
public class MainClass 
{

    /**
     * Main method for the project
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DataStructures.initialize();
        MainUIView mainUI = new MainUIView();
    }

}
