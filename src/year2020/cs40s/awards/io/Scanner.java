
/** required package class namespace */
package year2020.cs40s.awards.io;

/** required imports */
import java.io.InputStream;

 
/**
 * Scanner.java - this class simulates the java.swing class that does the 
 * dialogs and user interfaces and redirects the outputs to a custom output
 *
 * @author Mr. Wachs
 * @since Feb. 11, 2020, 12:50:26 p.m.
 */
public class Scanner 
{

    /**
     * Constructor, set class properties 
     * 
     * @param in this simulator does nothing with the parameter
     */
    public Scanner(InputStream in) { }

    /**
     * Re-directs the console input to custom input
     * 
     * @return a simulated scanner input
     */
    public String nextLine() {
        return Simulator.scannerInput();
    }

}
