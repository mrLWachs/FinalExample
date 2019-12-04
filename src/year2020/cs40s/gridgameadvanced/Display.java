
/** required package class namespace */
package year2020.cs40s.gridgameadvanced;

import javax.swing.JPanel;
import year2020.cs40s.gridgameadvanced.matrix.SmallMatrix;

 
/**
 * Display.java - description
 *
 * @author Mr. Wachs
 * @since Nov. 29, 2019, 3:30:23 p.m.
 */
public class Display 
{

    private JPanel panel;
    private Map    map;
    
    public SmallMatrix matrix;
    
    
    public Display(JPanel panel, Map map) {
        this.panel = panel;
        this.map   = map;
    }

    public void update() {
        
    }

}
