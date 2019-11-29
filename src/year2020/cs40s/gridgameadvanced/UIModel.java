
/** required package class namespace */
package year2020.cs40s.gridgameadvanced;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

 
/**
 * UIModel.java - the model logic for the user interface
 *
 * @author Mr. Wachs
 * @since Nov. 29, 2019, 2:40:15 p.m.
 */
public class UIModel 
{

    private JLabel           mapLabel;
    private JLabel           displayLabel;
    private JList<String>    statusList;
    private JPanel           mapPanel;
    private JPanel           displayPanel;
    private JScrollPane      statusScrollPane1;
    private DefaultListModel listModel;
    private UIView           view;
    private JComponent[]     components;
    private Display          display;
    private Map              map;

    private final int    WIDTH                = 1066;
    private final int    HEIGHT               = 780;
    private final String TITLE                = "Map Game Simulator";
    private final int    TOTAL_COMPONENTS     = 6;
    private final String FONT_TYPE            = "Arial";
    private final int    FONT_SIZE            = 12;
    private final int    BORDER_SIZE          = 1;
    private final Color  BORDER_COLOR         = Color.BLACK;
    private final Color  COMPONENT_BACKGROUND = Color.WHITE;
    private final Color  COMPONENT_FOREGROUND = Color.BLACK;    
    private final Font   COMPONENT_FONT       = new Font(FONT_TYPE, Font.PLAIN, FONT_SIZE);
    private final Border COMPONENT_BORDER     = BorderFactory.createLineBorder(BORDER_COLOR, BORDER_SIZE);
    
    
    public UIModel(
            JLabel mapLabel, 
            JLabel displayLabel, 
            JList<String> statusList, 
            JPanel mapPanel, 
            JPanel displayPanel, 
            JScrollPane statusScrollPane1, 
            UIView view) {
        this.mapLabel          = mapLabel;
        this.displayLabel      = displayLabel;
        this.statusList        = statusList;
        this.mapPanel          = mapPanel;
        this.displayPanel      = displayPanel;
        this.statusScrollPane1 = statusScrollPane1;
        this.view              = view;     
        setFrame();
        setComponents();
        display = new Display(displayPanel);
        map     = new Map(mapPanel);
        display.set(map);
        update("Starting up...");
    }

    private void setFrame() {
        view.setSize(WIDTH, HEIGHT);
        view.setResizable(false);
        view.setTitle(TITLE);
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }

    private void setComponents() {
        listModel = new DefaultListModel();
        statusList.setModel(listModel);
        listModel.removeAllElements();
        components = new JComponent[TOTAL_COMPONENTS];        
        components[0] = mapLabel;
        components[1] = displayLabel;
        components[2] = statusList;
        components[3] = mapPanel;
        components[4] = displayPanel;
        components[5] = statusScrollPane1;
        for (int i = 0; i < components.length; i++) {
            if (components[i] instanceof JLabel) {
                components[i].setOpaque(true);
            }
            if (components[i] instanceof JScrollPane) {
                components[i].setBorder(null);
            }
            if (components[i] instanceof JList ||
                components[i] instanceof JPanel) {
                components[i].setBorder(COMPONENT_BORDER);
            }
            components[i].setBackground(COMPONENT_BACKGROUND);
            components[i].setForeground(COMPONENT_FOREGROUND);            
            components[i].setFont(COMPONENT_FONT);            
        }
        view.getContentPane().setBackground(COMPONENT_BACKGROUND);
        view.setBackground(COMPONENT_BACKGROUND);
    }
    
    public void update(String message) {
        display.update();
        map.update();
        listModel.addElement(message);
    }

}
