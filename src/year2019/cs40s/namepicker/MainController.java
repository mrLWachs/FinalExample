
/** required package class namespace */
package year2019.cs40s.namepicker;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;



/**
 * MainController.java - 
 *
 * @author Mr. Wachs 
 * @since 12-Apr-2019 
 */
public class MainController 
{

    public MainController(
            MainModel aThis, 
            JButton jButton1, 
            JButton jButton10, 
            JButton jButton11, 
            JButton jButton2, 
            JButton jButton3, 
            JButton jButton4, 
            JButton jButton5, 
            JButton jButton6, 
            JButton jButton7, 
            JButton jButton8, 
            JButton jButton9, 
            JLabel jLabel1, 
            JLabel jLabel2, 
            JList<String> jList1, 
            JList<String> jList2, 
            JMenu jMenu2, 
            JMenuBar jMenuBar2, 
            JMenuItem jMenuItem1, 
            JMenuItem jMenuItem2, 
            JPanel jPanel1, 
            JPanel jPanel2, 
            JScrollPane jScrollPane1, 
            JScrollPane jScrollPane2) {
        
        
        
        jLabel2.setText(MainView.INSTRUCTIONS);
        
        
        aThis.setSize(MainView.MAIN_UI_WIDTH,MainView.MAIN_UI_HEIGHT);
        aThis.setResizable(false);
        aThis.setLocationRelativeTo(null);
        aThis.setVisible(true);
    }

}
