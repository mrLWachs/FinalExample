
/** required package class namespace */
package year2020.cs40s.awards.userinterfaces.controllers;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import year2020.cs40s.awards.collections.LinkedList;
import year2020.cs40s.awards.data.AwardRule;
import year2020.cs40s.awards.data.CourseRoster;
import year2020.cs40s.awards.data.DataStructures;
import year2020.cs40s.awards.logic.LookFactory;
import year2020.cs40s.awards.tools.Sort;
import year2020.cs40s.awards.userinterfaces.ModifyAwardRulesView;
import static year2020.cs40s.awards.data.DataStructures.data;

 
/**
 * ModifyAwardRulesController.java - description
 *
 * @author Mr. Wachs
 * @since 26-May-2020, 9:17:54 PM
 */
public class ModifyAwardRulesController 
{
    
    private JButton              goBackButton;
    private JButton              removeCourseFromRuleButton;
    private JButton              deleteSelectedRuleButton;
    private JButton              createNewRuleButton;
    private JButton              editSelectedRuleButton;
    private JButton              cancelNewRuleButton;
    private JButton              addCourseToRuleButton;
    private JButton              saveNewRuleButton;
    private JLabel               coursesInRuleListLabel;
    private JLabel               currentAwardRulesLabel;
    private JLabel               createAwardRuleLabel;
    private JLabel               newRuleNameLabel;
    private JLabel               allCoursesListLabel;
    private JList<String>        coursesInRuleList;
    private JList<String>        currentAwardRulesList;
    private JList<String>        allCoursesList;
    private JScrollPane          coursesInRuleScrollPane;
    private JScrollPane          currentAwardRulesScrollPane;
    private JScrollPane          allCoursesScrollPane;
    private JTextField           newRuleNameTextField;
    private ModifyAwardRulesView userInterface;
    private JFrame               parent;

    private DefaultListModel  coursesInRuleListModel;
    private DefaultListModel  currentAwardRulesListModel;
    private DefaultListModel  allCoursesListModel;
        
    private Sort sorter;
    
    private JComponent[] newRuleComponents;
    private JComponent[] allRulesComponents;
    
    
    public ModifyAwardRulesController(
            JButton              goBackButton, 
            JButton              removeCourseFromRuleButton, 
            JButton              deleteSelectedRuleButton, 
            JButton              createNewRuleButton, 
            JButton              editSelectedRuleButton, 
            JButton              cancelNewRuleButton, 
            JButton              addCourseToRuleButton, 
            JButton              saveNewRuleButton, 
            JLabel               coursesInRuleListLabel, 
            JLabel               currentAwardRulesLabel, 
            JLabel               createAwardRuleLabel, 
            JLabel               newRuleNameLabel, 
            JLabel               allCoursesListLabel, 
            JList<String>        coursesInRuleList, 
            JList<String>        currentAwardRulesList, 
            JList<String>        allCoursesList, 
            JScrollPane          coursesInRuleScrollPane, 
            JScrollPane          currentAwardRulesScrollPane, 
            JScrollPane          allCoursesScrollPane, 
            JTextField           newRuleNameTextField, 
            ModifyAwardRulesView userInterface, 
            JFrame               parent) {
        
        this.goBackButton                = goBackButton;
        this.removeCourseFromRuleButton  = removeCourseFromRuleButton;
        this.deleteSelectedRuleButton    = deleteSelectedRuleButton;
        this.createNewRuleButton         = createNewRuleButton;
        this.editSelectedRuleButton      = editSelectedRuleButton;
        this.cancelNewRuleButton         = cancelNewRuleButton;
        this.addCourseToRuleButton       = addCourseToRuleButton;
        this.saveNewRuleButton           = saveNewRuleButton;
        this.coursesInRuleListLabel      = coursesInRuleListLabel;
        this.currentAwardRulesLabel      = currentAwardRulesLabel;
        this.createAwardRuleLabel        = createAwardRuleLabel;
        this.newRuleNameLabel            = newRuleNameLabel;
        this.allCoursesListLabel         = allCoursesListLabel;
        this.coursesInRuleList           = coursesInRuleList;
        this.currentAwardRulesList       = currentAwardRulesList;
        this.allCoursesList              = allCoursesList;
        this.coursesInRuleScrollPane     = coursesInRuleScrollPane;
        this.currentAwardRulesScrollPane = currentAwardRulesScrollPane;
        this.allCoursesScrollPane        = allCoursesScrollPane;
        this.newRuleNameTextField        = newRuleNameTextField;
        this.userInterface               = userInterface;
        this.parent                      = parent;
        
        // instantiate all list models
        coursesInRuleListModel     = new DefaultListModel();
        currentAwardRulesListModel = new DefaultListModel();
        allCoursesListModel        = new DefaultListModel();
                
        // set list models to the UI list box controls
        coursesInRuleList.setModel( coursesInRuleListModel );
        currentAwardRulesList.setModel( currentAwardRulesListModel );
        allCoursesList.setModel( allCoursesListModel );
                
        // set dialog parenting
        DataStructures.dialog.parent = userInterface;
        
        // hide parent
        parent.setVisible(false);
        
        sorter = new Sort();
        
        // initializ user interface        
        initialize();
        
    }

    public void editSelectedRule() {
        int index = currentAwardRulesList.getSelectedIndex();
        String course = currentAwardRulesList.getSelectedValue();
        if (index == -1) {
            DataStructures.dialog.output("Please select a rule first!");            
        }
        else {
            AwardRule rule = DataStructures.rules.get(index);
            setupNewRule();
            newRuleNameTextField.setText(rule.name);
            for (int i = 0; i < rule.courseNames.size(); i++) {
                String courseName = rule.courseNames.get(i);
                allCoursesListModel.removeElement(courseName);                
                coursesInRuleListModel.addElement(courseName);                
            }
            deleteSelectedRule(false);
            cancelNewRuleButton.setEnabled(false);
        }
    }

    public void deleteSelectedRule(boolean confirm) {
        int index = currentAwardRulesList.getSelectedIndex();
        String course = currentAwardRulesList.getSelectedValue();
        if (index == -1) {
            DataStructures.dialog.output("Please select a rule first!");            
        }
        else {           
            boolean complete = false;
            if (confirm) {
                if (DataStructures.dialog.yesNo("Are you sure you want to "
                    + "delete this rule?")) {    
                    complete = true;
                }
            }
            else {
                complete = true;
            }
            if (complete) {
                currentAwardRulesListModel.remove(index);
                DataStructures.rules.remove(index);
                DataStructures.data.save();
            }                
        }
    }

    public void createNewRule() {
        setupNewRule();
    }

    public void goBack() {
        DataStructures.dialog.parent = parent;
        parent.setVisible(true);
        userInterface.dispose();
    }

    public void addCourseToRule() {
        int index = allCoursesList.getSelectedIndex();
        String course = allCoursesList.getSelectedValue();
        if (index == -1) {
            DataStructures.dialog.output("Please select a course first!");            
        }
        else {
            allCoursesListModel.remove(index);
            coursesInRuleListModel.add(0, course);
        }
    }

    public void removeCourseFromRule() {
        int index = coursesInRuleList.getSelectedIndex();
        String course = coursesInRuleList.getSelectedValue();
        if (index == -1) {
            DataStructures.dialog.output("Please select a course first!");            
        }
        else {
            coursesInRuleListModel.remove(index);
            allCoursesListModel.add(0, course);
        }
    }

    public void saveNewRule() {
        String name = newRuleNameTextField.getText();
        if (isValidRuleName(name) == false) {
            DataStructures.dialog.output("Please enter a name for the rule!"); 
            newRuleNameTextField.requestFocus();
        }
        else if (coursesInRuleListModel.getSize() == 0) {
            DataStructures.dialog.output("Please add at least one "
                    + "course for the rule!");
        }
        else {
            LinkedList<String> courseNames = new LinkedList<>();
            for (int i = 0; i < coursesInRuleListModel.size(); i++) {
                String course = allCoursesListModel.getElementAt(i).toString();
                courseNames.add(course);
            }
            AwardRule rule = new AwardRule(name, courseNames);
            DataStructures.rules.add(rule);
            DataStructures.data.save(); 
            currentAwardRulesListModel.addElement(rule.name);
            cancelSetupNewRule();
        }
    }

    public void cancelNewRule() {
        cancelSetupNewRule();
    }

    private void initialize() {
        final int WIDTH = 920;
        final int HEIGHT = 610;
        JComponent[] components = {
                goBackButton,
                removeCourseFromRuleButton,
                deleteSelectedRuleButton,
                createNewRuleButton,
                editSelectedRuleButton,
                cancelNewRuleButton,
                addCourseToRuleButton,
                saveNewRuleButton,
                coursesInRuleListLabel,
                currentAwardRulesLabel,
                createAwardRuleLabel,
                newRuleNameLabel,
                allCoursesListLabel,
                coursesInRuleList,
                currentAwardRulesList,
                allCoursesList, 
                coursesInRuleScrollPane,
                currentAwardRulesScrollPane,
                allCoursesScrollPane,
                newRuleNameTextField
        };
        LookFactory.setComponents(components, userInterface, WIDTH, HEIGHT);
        
        newRuleComponents     = new JComponent[12];
        newRuleComponents[0]  = allCoursesList;
        newRuleComponents[1]  = allCoursesScrollPane;
        newRuleComponents[2]  = allCoursesListLabel;
        newRuleComponents[3]  = coursesInRuleList;
        newRuleComponents[4]  = coursesInRuleScrollPane;
        newRuleComponents[5]  = coursesInRuleListLabel;
        newRuleComponents[6]  = addCourseToRuleButton;
        newRuleComponents[7]  = removeCourseFromRuleButton;
        newRuleComponents[8]  = newRuleNameLabel;
        newRuleComponents[9]  = newRuleNameTextField;
        newRuleComponents[10] = saveNewRuleButton;
        newRuleComponents[11] = cancelNewRuleButton;
        
        allRulesComponents    = new JComponent[5];
        allRulesComponents[0] = currentAwardRulesList;
        allRulesComponents[1] = editSelectedRuleButton;
        allRulesComponents[2] = deleteSelectedRuleButton;
        allRulesComponents[3] = createNewRuleButton;
        allRulesComponents[4] = goBackButton;
        
        cancelSetupNewRule();
        
        DataStructures.data.open();
        for (int i = 0; i < DataStructures.rules.size(); i++) {
            String name = DataStructures.rules.get(i).name;
            currentAwardRulesListModel.addElement(name);
        }
        
        userInterface.setVisible(true);
    }
    
    private void cancelSetupNewRule() {
        newRuleNameTextField.setText("");
        allCoursesListModel.removeAllElements();
        allCoursesScrollPane.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        
        coursesInRuleListModel.removeAllElements();
        coursesInRuleScrollPane.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        
        currentAwardRulesScrollPane.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        
        for (JComponent component : newRuleComponents) {
            component.setEnabled(false);
        }        
        for (JComponent component : allRulesComponents) {
            component.setEnabled(true);
        }
    }
    
    private void setupNewRule() {
        newRuleNameTextField.setText("");
        for (int i = 0; i < DataStructures.courses.size(); i++) {
            CourseRoster course = DataStructures.courses.get(i);
            allCoursesListModel.add(i, course.name);
        }
        
        allCoursesScrollPane.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        
        coursesInRuleListModel.removeAllElements();
        coursesInRuleScrollPane.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        
        currentAwardRulesScrollPane.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        
        for (JComponent component : newRuleComponents) {
            component.setEnabled(true);
        }        
        for (JComponent component : allRulesComponents) {
            component.setEnabled(false);
        }
    }

    private boolean isValidRuleName(String name) {
        if (name == null)    return false;
        if (name.equals("")) return false;        
        for (int i = 0; i < currentAwardRulesListModel.size(); i++) {
            String course = 
                    currentAwardRulesListModel.getElementAt(i).toString();
            if (name.equalsIgnoreCase(course)) {
                DataStructures.dialog.output("Cannot have two rules "
                        + "with the same name!");
                return false;
            }            
        }        
        return true;
    }
    
}
