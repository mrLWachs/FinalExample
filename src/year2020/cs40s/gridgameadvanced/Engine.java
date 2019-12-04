
/** required package class namespace */
package year2020.cs40s.gridgameadvanced;

import java.awt.event.KeyEvent;
import javax.swing.DefaultListModel;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

 
/**
 * UIModel.java - the model logic for the user interface
 *
 * @author Mr. Wachs
 * @since Nov. 29, 2019, 2:40:15 p.m.
 */
public class Engine 
{

    private JLabel           mapLabel;
    private JLabel           displayLabel;
    private JLabel           heroLabel;
    private JList<String>    statusList;
    private JPanel           mapPanel;
    private JPanel           displayPanel;
    private JScrollPane      statusScrollPane1;
    private DefaultListModel listModel;
    private UserInterface           view;
    private JComponent[]     components;
    private Display          display;
    private Map              map;
    private Hero             hero;
    
    
    public Engine(
            JLabel mapLabel, 
            JLabel displayLabel, 
            JLabel heroLabel, 
            JList<String> statusList, 
            JPanel mapPanel, 
            JPanel displayPanel, 
            JScrollPane statusScrollPane1, 
            UserInterface view) {
        this.mapLabel          = mapLabel;
        this.displayLabel      = displayLabel;
        this.heroLabel         = heroLabel;        
        this.statusList        = statusList;
        this.mapPanel          = mapPanel;
        this.displayPanel      = displayPanel;
        this.statusScrollPane1 = statusScrollPane1;
        this.view              = view;     
        setFrame();
        setComponents();
        setObjects();
        update("Starting up...");
    }

    private void setFrame() {
        view.setSize(Constants.UI_WIDTH, Constants.UI_HEIGHT);
        view.setResizable(false);
        view.setTitle(Constants.TITLE);
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }

    private void setComponents() {
        listModel = new DefaultListModel();
        statusList.setModel(listModel);
        listModel.removeAllElements();
        components = new JComponent[Constants.TOTAL_COMPONENTS];        
        components[0] = mapLabel;
        components[1] = displayLabel;
        components[2] = heroLabel;
        components[3] = statusList;
        components[4] = mapPanel;
        components[5] = displayPanel;
        components[6] = statusScrollPane1;
        for (int i = 0; i < components.length; i++) {
            if (components[i] instanceof JLabel) {
                components[i].setOpaque(true);
            }
            if (components[i] instanceof JScrollPane) {
                components[i].setBorder(null);
            }
            if (components[i] instanceof JList ||
                components[i] instanceof JPanel) {
                components[i].setBorder(Constants.COMPONENT_BORDER);
            }
            components[i].setBackground(Constants.COMPONENT_BACKGROUND);
            components[i].setForeground(Constants.COMPONENT_FOREGROUND);            
            components[i].setFont(Constants.COMPONENT_FONT);            
        }
        view.getContentPane().setBackground(Constants.COMPONENT_BACKGROUND);
        view.setBackground(Constants.COMPONENT_BACKGROUND);
    }
    
    private void setObjects() {
        map     = new Map(mapPanel);
        display = new Display(displayPanel,map);
        hero    = new Hero(heroLabel,display);
    }
    
    public void update(String message) {
        display.update();
        map.update();
        listModel.addElement(message);
    }

    public void keypress(KeyEvent event) {
        hero.keypress(event);
    }

}
