
/** required package class namespace */
package year2020.cs40s.awards.userinterfaces.controllers;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import year2020.cs40s.awards.data.Course;
import year2020.cs40s.awards.data.DataStructures;
import year2020.cs40s.awards.data.Student;
import year2020.cs40s.awards.logic.LookFactory;
import year2020.cs40s.awards.tools.Numbers;
import year2020.cs40s.awards.tools.Sort;
import year2020.cs40s.awards.userinterfaces.StudentDataUIView;

 
/**
 * StudentDataUIController.java - description
 *
 * @author Mr. Wachs
 * @since 20-May-2020, 6:27:29 PM
 */
public class StudentDataUIController 
{
    
    private JButton           sortByGradeButton; 
    private JButton           sortByNameButton; 
    private JButton           sortByTermButton; 
    private JButton           goBackButton;
    private JLabel            courseGradeLabel; 
    private JLabel            nameDescriptionLabel; 
    private JLabel            nameLabel; 
    private JLabel            courseNameLabel; 
    private JLabel            courseTermLabel; 
    private JList<String>     courseGradeList; 
    private JList<String>     courseNameList; 
    private JList<String>     courseTermList; 
    private JScrollPane       courseGradeScrollPane; 
    private JScrollPane       courseNameScrollPane; 
    private JScrollPane       courseTermScrollPane; 
    private StudentDataUIView userInterface;
    private JFrame            parent;
    private int               index;
    
    private DefaultListModel  courseGradeListModel;
    private DefaultListModel  courseNameListModel;
    private DefaultListModel  courseTermListModel;
        
    private Student student;
    

    public StudentDataUIController(
            JButton           sortByGradeButton, 
            JButton           sortByNameButton, 
            JButton           sortByTermButton, 
            JButton           goBackButton, 
            JLabel            courseGradeLabel, 
            JLabel            nameDescriptionLabel, 
            JLabel            nameLabel, 
            JLabel            courseNameLabel, 
            JLabel            courseTermLabel, 
            JList<String>     courseGradeList, 
            JList<String>     courseNameList, 
            JList<String>     courseTermList, 
            JScrollPane       courseGradeScrollPane, 
            JScrollPane       courseNameScrollPane, 
            JScrollPane       courseTermScrollPane, 
            StudentDataUIView userInterface,
            JFrame            parent,
            int               index) {      
        
        // set parameter association with properties
        this.sortByGradeButton     = sortByGradeButton;
        this.sortByNameButton      = sortByNameButton;
        this.sortByTermButton      = sortByTermButton;
        this.goBackButton          = goBackButton;
        this.courseGradeLabel      = courseGradeLabel;
        this.nameDescriptionLabel  = nameDescriptionLabel;
        this.nameLabel             = nameLabel;
        this.courseNameLabel       = courseNameLabel;
        this.courseTermLabel       = courseTermLabel;
        this.courseGradeList       = courseGradeList;
        this.courseNameList        = courseNameList;
        this.courseTermList        = courseTermList;
        this.courseGradeScrollPane = courseGradeScrollPane;
        this.courseNameScrollPane  = courseNameScrollPane;
        this.courseTermScrollPane  = courseTermScrollPane;
        this.userInterface         = userInterface;
        this.parent                = parent;
        this.index                 = index;
        
        // instantiate all list models
        courseGradeListModel = new DefaultListModel();
        courseNameListModel  = new DefaultListModel();
        courseTermListModel  = new DefaultListModel();
                
        // set list models to the UI list box controls
        courseGradeList.setModel( courseGradeListModel );
        courseNameList.setModel( courseNameListModel );
        courseTermList.setModel( courseTermListModel );
                
        // set dialog parenting
        DataStructures.dialog.parent = userInterface;
        
        // hide parent
        parent.setVisible(false);
        
        // initializ user interface        
        initialize();
    }

    public void sortByName() {
        for (int i = 0; i < student.courses.size(); i++) {
            Course course = student.courses.get(i);
            course.setSortMethod(DataStructures.SORT_COURSES_BY_NAME);
        }
        DataStructures.sorter.quick(student.courses);
        fill();
    }

    public void sortByTerm() {
        for (int i = 0; i < student.courses.size(); i++) {
            Course course = student.courses.get(i);
            course.setSortMethod(DataStructures.SORT_COURSES_BY_TERM);
        }
        DataStructures.sorter.quick(student.courses);
        fill();
    }

    public void sortByGrade() {
        for (int i = 0; i < student.courses.size(); i++) {
            Course course = student.courses.get(i);
            course.setSortMethod(DataStructures.SORT_COURSES_BY_GRADE);
        }
        DataStructures.sorter.quick(student.courses);
        fill();
    }

    public void goBack() {
        DataStructures.dialog.parent = parent;
        parent.setVisible(true);
        userInterface.dispose();
    }

    public void courseNameListClick() {
        int index = courseNameList.getSelectedIndex();
        courseGradeList.setSelectedIndex(index);
        courseTermList.setSelectedIndex(index);
    }

    public void courseTermListClick() {
        int index = courseTermList.getSelectedIndex();
        courseGradeList.setSelectedIndex(index);
        courseNameList.setSelectedIndex(index);
    }

    public void courseGradeListClick() {
        int index = courseGradeList.getSelectedIndex();
        courseNameList.setSelectedIndex(index);
        courseTermList.setSelectedIndex(index);
    }
    
    private void initialize() {
        final int WIDTH = 600;
        final int HEIGHT = 550;
        JComponent[] components = {
            sortByGradeButton,
            sortByNameButton,
            sortByTermButton,
            goBackButton, 
            courseGradeLabel,
            nameDescriptionLabel,
            nameLabel, 
            courseNameLabel, 
            courseTermLabel, 
            courseGradeList, 
            courseNameList, 
            courseTermList, 
            courseGradeScrollPane,
            courseNameScrollPane,
            courseTermScrollPane
        };
        LookFactory.setComponents(components, userInterface, WIDTH, HEIGHT);
        userInterface.setVisible(true);        
        fill();
    }

    private void fill() {
        courseGradeListModel.removeAllElements();
        courseNameListModel.removeAllElements();
        courseTermListModel.removeAllElements();
        student = DataStructures.students.get(index);
        if (student != null) {
            double average = student.getAverage();
            double rounded = new Numbers().round(average, 2);
            String text = student.name + " (average: " + 
                          rounded + ")";
            nameLabel.setText(text);
            for (int i = 0; i < student.courses.size(); i++) {
                Course course = student.courses.get(i);
                courseNameListModel.add(i,course.name);  
                courseTermListModel.add(i,course.term);  
                courseGradeListModel.add(i,course.grade);                  
            }
            courseGradeLabel.setText("Course Grade (" + 
                    student.courses.size() + "):");
            courseNameLabel.setText("Course Name (" + 
                    student.courses.size() + "):");
            courseTermLabel.setText("Course Term (" + 
                    student.courses.size() + "):");
        }
    }

}
