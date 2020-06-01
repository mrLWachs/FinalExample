
/** required package class namespace */
package year2020.cs40s.awards.userinterfaces.controllers;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import year2020.cs40s.awards.data.CourseRoster;
import year2020.cs40s.awards.logic.DataLoader;
import year2020.cs40s.awards.data.DataStructures;
import year2020.cs40s.awards.data.Student;
import year2020.cs40s.awards.logic.LookFactory;
import year2020.cs40s.awards.userinterfaces.AwardRuleReportView;
import year2020.cs40s.awards.userinterfaces.CourseReportView;
import year2020.cs40s.awards.userinterfaces.CoursesDataUIView;
import year2020.cs40s.awards.userinterfaces.LoadingView;
import year2020.cs40s.awards.userinterfaces.MainUIView;
import year2020.cs40s.awards.userinterfaces.ModifyAwardRulesView;
import year2020.cs40s.awards.userinterfaces.NameReportView;
import year2020.cs40s.awards.userinterfaces.StudentDataUIView;

 
/**
 * MainUIController.java - description
 *
 * @author Mr. Wachs
 * @since 19-May-2020, 8:29:04 PM
 */
public class MainUIController 
{
    
    private JButton seeSelectedCourseDataButton;
    private JButton awardRuleReportButton;
    private JButton seeSelectedNameDataButton;
    private JButton openDataFileButton;
    private JButton clearAllDataButton;
    private JButton getNameReportButton;
    private JButton getCourseReportButton;
    private JButton modifyAwardRulesButton;
    private JLabel allNamesLabel;
    private JLabel currentAwardRuleLabel;
    private JLabel allCoursesLabel;
    private JList<String> allNamesList;
    private JList<String> allCoursesList;
    private JScrollPane allNamesScrollPane;
    private JScrollPane allCoursesScrollPane;
    private JComboBox<String> currentAwardRuleComboBox;
    private MainUIView userInterface;
    
    private DefaultListModel allNamesListModel;
    private DefaultListModel allCoursesListModel;
    

    /**
     * Default constructor, set class properties
     */
    public MainUIController(
            JButton seeSelectedCourseDataButton, 
            JButton awardRuleReportButton, 
            JButton seeSelectedNameDataButton, 
            JButton openDataFileButton, 
            JButton clearAllDataButton, 
            JButton getNameReportButton, 
            JButton getCourseReportButton, 
            JButton modifyAwardRulesButton, 
            JLabel allNamesLabel, 
            JLabel currentAwardRuleLabel, 
            JLabel allCoursesLabel, 
            JList<String> allNamesList, 
            JList<String> allCoursesList, 
            JScrollPane allNamesScrollPane, 
            JScrollPane allCoursesScrollPane, 
            JComboBox<String> currentAwardRuleComboBox, 
            MainUIView userInterface) {
        this.seeSelectedCourseDataButton = seeSelectedCourseDataButton;
        this.awardRuleReportButton       = awardRuleReportButton;
        this.seeSelectedNameDataButton   = seeSelectedNameDataButton;
        this.openDataFileButton          = openDataFileButton;
        this.clearAllDataButton          = clearAllDataButton;
        this.getNameReportButton         = getNameReportButton;
        this.getCourseReportButton       = getCourseReportButton;
        this.modifyAwardRulesButton      = modifyAwardRulesButton;
        this.allNamesLabel               = allNamesLabel;
        this.currentAwardRuleLabel       = currentAwardRuleLabel;
        this.allCoursesLabel             = allCoursesLabel;
        this.allNamesList                = allNamesList;
        this.allCoursesList              = allCoursesList;
        this.allNamesScrollPane          = allNamesScrollPane;
        this.allCoursesScrollPane        = allCoursesScrollPane;
        this.currentAwardRuleComboBox    = currentAwardRuleComboBox;
        this.userInterface               = userInterface;
        
        // instantiate all list models
        allNamesListModel   = new DefaultListModel();
        allCoursesListModel = new DefaultListModel();
        
        // set list models to the UI list box controls
        allNamesList.setModel( allNamesListModel );
        allCoursesList.setModel( allCoursesListModel );
        
        allNamesListModel.removeAllElements();
        allCoursesListModel.removeAllElements();
        currentAwardRuleComboBox.removeAllItems();
        
        DataStructures.dialog.parent = userInterface;
        
        initialize();
    }

    public void openDataFile() {
        DataLoader.loadData(userInterface);
        allNamesListModel.removeAllElements();
        allCoursesListModel.removeAllElements();
        DataStructures.sortStudents(DataStructures.SORT_STUDENTS_BY_NAME);
        for (int i = 0; i < DataStructures.students.size(); i++) {
            Student student = DataStructures.students.get(i);
            String name = student.name;
            allNamesListModel.add(i,name);
        }
        allNamesLabel.setText("All Names (" + 
                DataStructures.students.size() + "):");
        
        DataStructures.sortCourses(DataStructures.SORT_All_COURSES_BY_NAME);      
        for (int i = 0; i < DataStructures.courses.size(); i++) {
            CourseRoster courseRoster = DataStructures.courses.get(i);
            String name = courseRoster.name;
            allCoursesListModel.add(i,name);
        }  
        allCoursesLabel.setText("All Courses (" + 
                DataStructures.courses.size() + "):");
    }

    public void clearAllData() {
        if (DataStructures.dialog.yesNo("Are you sure you want to"
                + " clear all data?")) {  
            new LoadingView(null, 5000);
            DataStructures.initialize();
            allNamesListModel.removeAllElements();
            allCoursesListModel.removeAllElements();
            currentAwardRuleComboBox.removeAllItems();
        }
    }

    public void seeSelectedNameData() {
        int index = allNamesList.getSelectedIndex();
        if (index == -1) {
            DataStructures.dialog.output("Please select a name first!");            
        }
        else {        
            StudentDataUIView studentDataUIView = 
                    new StudentDataUIView(userInterface,index);
        }
    }

    public void seeSelectedCourseData() {
        int index = allCoursesList.getSelectedIndex();
        if (index == -1) {
            DataStructures.dialog.output("Please select a course first!");            
        }
        else {        
            CoursesDataUIView coursesDataUIView = 
                    new CoursesDataUIView(userInterface,index);
        }
    }

    public void getNameReport() {
        if (allNamesListModel.getSize() == 0) {
            DataStructures.dialog.output("Please load a data file first!");
        }
        else {        
            NameReportView nameReportView = new NameReportView(userInterface);
        }
    }

    public void getCourseReport() {
        if (allCoursesListModel.getSize() == 0) {
            DataStructures.dialog.output("Please load a data file first!");
        }
        else {
            CourseReportView courseReportView = new 
                                            CourseReportView(userInterface);
        }
    }

    public void awardRuleReport() {
        if (allCoursesListModel.getSize() == 0) {
            DataStructures.dialog.output("Please load a data file first!");
        }
        else if (currentAwardRuleComboBox.getItemCount() == 0) {
           DataStructures.dialog.output("Please modify award rules and add a "
                   + "rule to the list first!");             
        }
        else {
            String rule = currentAwardRuleComboBox.getSelectedItem().toString();
            AwardRuleReportView awardRuleReportView = 
                    new AwardRuleReportView(userInterface, rule);
        }
    }

    public void modifyAwardRules() {
        ModifyAwardRulesView modifyAwardRulesView = 
                new ModifyAwardRulesView(userInterface);
    }
    
    private void initialize() {
        final int WIDTH = 985;
        final int HEIGHT = 575;
        JComponent[] components = {
            seeSelectedCourseDataButton,
            awardRuleReportButton,
            seeSelectedNameDataButton,
            openDataFileButton,
            clearAllDataButton,
            getNameReportButton,
            getCourseReportButton,
            modifyAwardRulesButton,
            allNamesLabel, 
            currentAwardRuleLabel,
            allCoursesLabel,
            allNamesList,
            allCoursesList,
            allNamesScrollPane,
            allCoursesScrollPane,
            currentAwardRuleComboBox
        };
        LookFactory.setComponents(components, userInterface, WIDTH, HEIGHT);
        
        userInterface.setVisible(true);
    }

}
