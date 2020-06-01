
/** required package class namespace */
package year2020.cs40s.awards.userinterfaces.controllers;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import year2020.cs40s.awards.data.CourseRoster;
import year2020.cs40s.awards.data.DataStructures;
import year2020.cs40s.awards.data.Student;
import year2020.cs40s.awards.logic.LookFactory;
import year2020.cs40s.awards.tools.Numbers;
import year2020.cs40s.awards.tools.Sort;
import year2020.cs40s.awards.userinterfaces.CoursesDataUIView;

 
/**
 * CoursesDataUIController.java - description
 *
 * @author Mr. Wachs
 * @since 20-May-2020, 9:08:45 PM
 */
public class CoursesDataUIController 
{
    
    private JButton           goBackButton; 
    private JButton           sortByGradeButton; 
    private JButton           sortByNameButton; 
    private JLabel            courseNameLabel; 
    private JLabel            studentsInCourseLabel; 
    private JLabel            courseNameDescriptionLabel; 
    private JList<String>     studentsInCourseList; 
    private JScrollPane       studentsInCourseScrollPane; 
    private CoursesDataUIView userInterface; 
    private JFrame            parent; 
    private int               index;
                    
    private DefaultListModel  studentsInCourseListModel;
        
    private CourseRoster courseRoster;
    

    public CoursesDataUIController(
            JButton           goBackButton, 
            JButton           sortByGradeButton, 
            JButton           sortByNameButton, 
            JLabel            courseNameLabel, 
            JLabel            studentsInCourseLabel, 
            JLabel            courseNameDescriptionLabel, 
            JList<String>     studentsInCourseList, 
            JScrollPane       studentsInCourseScrollPane, 
            CoursesDataUIView userInterface, 
            JFrame            parent,  
            int               index) {
        this.goBackButton               = goBackButton;
        this.sortByGradeButton          = sortByGradeButton;
        this.sortByNameButton           = sortByNameButton;
        this.courseNameLabel            = courseNameLabel;
        this.studentsInCourseLabel      = studentsInCourseLabel;
        this.courseNameDescriptionLabel = courseNameDescriptionLabel;
        this.studentsInCourseList       = studentsInCourseList;
        this.studentsInCourseScrollPane = studentsInCourseScrollPane;
        this.userInterface              = userInterface;
        this.parent                     = parent;
        this.index                      = index;
        
        // instantiate all list models
        studentsInCourseListModel = new DefaultListModel();
                
        // set list models to the UI list box controls
        studentsInCourseList.setModel( studentsInCourseListModel );
                
        DataStructures.dialog.parent = userInterface;
        
        parent.setVisible(false);
        
        courseRoster = DataStructures.courses.get(index);
                
        initialize();        
    }

    public void sortByName() {
        for (int i = 0; i < courseRoster.students.size(); i++) {
            Student student = courseRoster.students.get(i);
            student.setSortMethod(DataStructures.SORT_STUDENTS_BY_NAME,"");
        }
        DataStructures.sorter.quick(courseRoster.students);
        fill();
    }

    public void sortByGrade() {
        String courseName = courseRoster.name;
        for (int i = 0; i < courseRoster.students.size(); i++) {
            Student student = courseRoster.students.get(i);
            student.setSortMethod(DataStructures.SORT_STUDENTS_BY_GRADE,
                    courseName);
        }
        DataStructures.sorter.quick(courseRoster.students);
        fill();
    }

    public void goBack() {
        DataStructures.dialog.parent = parent;
        parent.setVisible(true);
        userInterface.dispose();
    }

    private void initialize() {
        final int WIDTH = 520;
        final int HEIGHT = 530;
        JComponent[] components = {
            goBackButton,
            sortByGradeButton,
            sortByNameButton,
            courseNameLabel,
            studentsInCourseLabel,
            courseNameDescriptionLabel,
            studentsInCourseList,
            studentsInCourseScrollPane
        };
        LookFactory.setComponents(components, userInterface, WIDTH, HEIGHT);
        userInterface.setVisible(true);        
        fill();
    }

    private void fill() {
        studentsInCourseListModel.removeAllElements();
        String courseName = courseRoster.name;
        if (courseName != null) {
            double average = courseRoster.getAverage();
            double rounded = new Numbers().round(average, 2);
            String text = courseName + " (overall average: " + 
                          rounded + ")";
            courseNameLabel.setText(text);
        }        
        for (int i = 0; i < courseRoster.students.size(); i++) {
            Student student = courseRoster.students.get(i);
            String name  = student.name;
            String grade = student.getGrade(courseName);
            String text  = name + " (" + grade + ")";
            studentsInCourseListModel.add(i,text);            
        }
        String text = "Students in Course (" +
                      courseRoster.students.size() + "):";
        studentsInCourseLabel.setText(text);
    }
    
}
