
/** required package class namespace */
package year2019.cs40s.namepicker;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;



/**
 * MainController.java - 
 *
 * @author Mr. Wachs 
 * @since 12-Apr-2019 
 */
public class MainController 
{

    private JButton       addNameUnchosenButton;
    private JList<String> chosenNamesListBox;
    private JPanel        chosenNamesPanel;
    private JScrollPane   chosenNamesScrollPane;
    private JButton       clearListChosenButton;
    private JButton       clearListUnchosenButton;
    private JButton       drawNameButton;
    private JMenuItem     exitMenuItem;
    private JMenu         fileMenu;
    private JLabel        instructionsLabel;
    private JMenuBar      mainMenuBar;
    private JButton       moveBackChosenButton;
    private JButton       openListChosenButton;
    private JButton       openListUnchosenButton;
    private JButton       removeNameChosenButton;
    private JButton       removeSelectedUnchosenButton;
    private JButton       saveListChosenButton;
    private JButton       saveListUnchosenButton;
    private JMenuItem     settingsMenuItem;
    private JLabel        titleLabel;
    private JList<String> unchosenNamesListBox;
    private JPanel        unchosenNamesPanel;
    private JScrollPane   unchosenNamesScrollPane;
    private MainModel     mainModel;
    
    private Component[]   components;
    
    private final int     COMPONENT_SIZE = 23;
    
    
    public MainController(
            MainModel mainModel, 
            JButton addNameUnchosenButton,
            JList<String> chosenNamesListBox,
            JPanel chosenNamesPanel,
            JScrollPane chosenNamesScrollPane,
            JButton clearListChosenButton,
            JButton clearListUnchosenButton,
            JButton drawNameButton,
            JMenuItem exitMenuItem,
            JMenu fileMenu,
            JLabel instructionsLabel,
            JMenuBar mainMenuBar,
            JButton moveBackChosenButton,
            JButton openListChosenButton,
            JButton openListUnchosenButton,
            JButton removeNameChosenButton,
            JButton removeSelectedUnchosenButton,
            JButton saveListChosenButton,
            JButton saveListUnchosenButton,
            JMenuItem settingsMenuItem,
            JLabel titleLabel,
            JList<String> unchosenNamesListBox,
            JPanel unchosenNamesPanel,
            JScrollPane unchosenNamesScrollPane) {
        this.mainModel                    = mainModel;
        this.addNameUnchosenButton        = addNameUnchosenButton;
        this.chosenNamesListBox           = chosenNamesListBox;
        this.chosenNamesPanel             = chosenNamesPanel;
        this.chosenNamesScrollPane        = chosenNamesScrollPane;
        this.clearListChosenButton        = clearListChosenButton;
        this.clearListUnchosenButton      = clearListUnchosenButton;
        this.drawNameButton               = drawNameButton;
        this.exitMenuItem                 = exitMenuItem;
        this.fileMenu                     = fileMenu;
        this.instructionsLabel            = instructionsLabel;
        this.mainMenuBar                  = mainMenuBar;
        this.moveBackChosenButton         = moveBackChosenButton;
        this.openListChosenButton         = openListChosenButton;
        this.openListUnchosenButton       = openListUnchosenButton;
        this.removeNameChosenButton       = removeNameChosenButton;
        this.removeSelectedUnchosenButton = removeSelectedUnchosenButton;
        this.saveListChosenButton         = saveListChosenButton;
        this.saveListUnchosenButton       = saveListUnchosenButton;
        this.settingsMenuItem             = settingsMenuItem;
        this.titleLabel                   = titleLabel;
        this.unchosenNamesListBox         = unchosenNamesListBox;
        this.unchosenNamesPanel           = unchosenNamesPanel;
        this.unchosenNamesScrollPane      = unchosenNamesScrollPane;        
        components     = new Component[COMPONENT_SIZE];        
        components[0]  = addNameUnchosenButton;
        components[1]  = chosenNamesListBox;
        components[2]  = chosenNamesPanel;
        components[3]  = chosenNamesScrollPane;
        components[4]  = clearListChosenButton;
        components[5]  = clearListUnchosenButton;
        components[6]  = drawNameButton;
        components[7]  = exitMenuItem;
        components[8]  = fileMenu;
        components[9]  = instructionsLabel;
        components[10] = mainMenuBar;
        components[11] = moveBackChosenButton;
        components[12] = openListChosenButton;
        components[13] = openListUnchosenButton;
        components[14] = removeNameChosenButton;
        components[15] = removeSelectedUnchosenButton;
        components[16] = saveListChosenButton;
        components[17] = saveListUnchosenButton;
        components[18] = settingsMenuItem;
        components[19] = titleLabel;
        components[20] = unchosenNamesListBox;
        components[21] = unchosenNamesPanel;
        components[22] = unchosenNamesScrollPane;
        setLookAndFeel();
    }

    private void setLookAndFeel() {
        
        
        for (Component component : components) {
            component.setFont(MainView.DEFAULT_BODY_FONT);
            component.setBackground(MainView.DEFAULT_BACKGROUND_COLOR);
            component.setForeground(MainView.DEFAULT_FOREGROUND_COLOR);
        }
        
        ((TitledBorder)chosenNamesPanel.getBorder()).setTitleFont(
                MainView.DEFAULT_BODY_FONT);
        ((TitledBorder)unchosenNamesPanel.getBorder()).setTitleFont(
                MainView.DEFAULT_BODY_FONT);
        
        titleLabel.setFont(MainView.DEFAULT_TITLE_FONT);
        drawNameButton.setFont(MainView.DEFAULT_TITLE_FONT);
        
        instructionsLabel.setText(MainView.INSTRUCTIONS);
        
        
        mainModel.setSize(MainView.MAIN_UI_WIDTH,MainView.MAIN_UI_HEIGHT);
        
        mainModel.setBackground(MainView.DEFAULT_BACKGROUND_COLOR);
        mainModel.getContentPane().setBackground(MainView.DEFAULT_BACKGROUND_COLOR);
        
        mainModel.setResizable(false);
        mainModel.setLocationRelativeTo(null);
        mainModel.setVisible(true);
    }

}
