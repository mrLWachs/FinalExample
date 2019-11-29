
/** required package class namespace */
package year2020.cs40s.gridgameadvanced;

import javax.swing.JPanel;

 
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
    
    
    public Display(JPanel panel) {
        this.panel = panel;
    }

    public void set(Map map) {
        this.map = map;
    }

    public void update() {
        
    }

}
