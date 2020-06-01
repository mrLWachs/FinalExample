
/** required package class namespace */
package year2020.cs40s.awards.userinterfaces.controllers;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import year2020.cs40s.awards.collections.LinkedList;
import year2020.cs40s.awards.data.CourseRoster;
import year2020.cs40s.awards.data.DataStructures;
import year2020.cs40s.awards.logic.LookFactory;
import year2020.cs40s.awards.userinterfaces.CourseReportView;
import year2020.cs40s.awards.userinterfaces.LoadingView;

 
/**
 * CourseReportController.java - description
 *
 * @author Mr. Wachs
 * @since 26-May-2020, 1:49:27 PM
 */
public class CourseReportController 
{
    
    private JButton          sortByStudentsEnrolledButton;
    private JButton          sortByCourseNameButton;
    private JButton          sortByOverallAverageButton;
    private JButton          goBackButton;
    private JLabel           titleLabel;
    private JScrollPane      reportAreaScrollPane;
    private JScrollPane      instructionsScrollPane;
    private JTextArea        reportAreaTextArea;
    private JTextArea        instructionsTextArea;
    private CourseReportView userInterface;
    private JFrame           parent;
    
    private int type;
    

    public CourseReportController(
            JButton          sortByStudentsEnrolledButton, 
            JButton          sortByCourseNameButton, 
            JButton          sortByOverallAverageButton, 
            JButton          goBackButton, 
            JLabel           titleLabel, 
            JScrollPane      reportAreaScrollPane,
            JScrollPane      instructionsScrollPane, 
            JTextArea        reportAreaTextArea, 
            JTextArea        instructionsTextArea, 
            CourseReportView userInterface,
            JFrame           parent) {
        // set parameter association with properties
        this.sortByStudentsEnrolledButton = sortByStudentsEnrolledButton;
        this.sortByCourseNameButton       = sortByCourseNameButton;
        this.sortByOverallAverageButton   = sortByOverallAverageButton;
        this.goBackButton                 = goBackButton;
        this.titleLabel                   = titleLabel;
        this.reportAreaScrollPane         = reportAreaScrollPane;
        this.instructionsScrollPane       = instructionsScrollPane;
        this.reportAreaTextArea           = reportAreaTextArea;
        this.instructionsTextArea         = instructionsTextArea;
        this.userInterface                = userInterface;
        this.parent                       = parent;
        
        // set dialog parenting
        DataStructures.dialog.parent = userInterface;
        
        // hide parent
        parent.setVisible(false);
        
        // initializ user interface        
        initialize();
    }

    
    public void goBack() {
        DataStructures.dialog.parent = parent;
        parent.setVisible(true);
        userInterface.dispose();
    }

    public void sortByCourseName() {
        type = DataStructures.SORT_All_COURSES_BY_NAME;
        fill();
    }

    public void sortByOverallAverage() {
        type = DataStructures.SORT_All_COURSES_BY_AVERAGE;
        fill();
    }

    public void sortByStudentsEnrolled() {
        type = DataStructures.SORT_All_COURSES_BY_STUDENTS;
        fill();
    }

    private void initialize() {
        final int WIDTH = 735;
        final int HEIGHT = 695;
        JComponent[] components = {
            sortByStudentsEnrolledButton,
            sortByCourseNameButton,
            sortByOverallAverageButton,
            goBackButton,
            titleLabel,
            reportAreaScrollPane,
            instructionsScrollPane,
            reportAreaTextArea,
            instructionsTextArea
        };
        LookFactory.setComponents(components, userInterface, WIDTH, HEIGHT);
        
        instructionsScrollPane.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        
        reportAreaTextArea.setFont(DataStructures.FONT3);
        reportAreaTextArea.setFont(DataStructures.FONT3);
        
        instructionsTextArea.setBorder(null);
        instructionsScrollPane.setBorder(null);
                
        goBackButton.requestFocus();
        
        type = DataStructures.SORT_All_COURSES_BY_AVERAGE;
        
        userInterface.setVisible(true);        
        fill();
    }
    
    private void fill() {    
        
        new LoadingView(null, 20000);
        
        String text = "Students Sorted by ";
        if (type == DataStructures.SORT_All_COURSES_BY_NAME){                
            text += "Name:\n";     
        }
        else if (type == DataStructures.SORT_All_COURSES_BY_AVERAGE){                
            text += "Average:\n";     
        }
        else if (type == DataStructures.SORT_All_COURSES_BY_STUDENTS){     
            text += "Total Courses:\n";     
        }
        DataStructures.sortCourses(type); 
        LinkedList<String> names         = new LinkedList<>();
        LinkedList<String> averages      = new LinkedList<>();
        LinkedList<String> totalStudents = new LinkedList<>();
        for (int i = 0; i < DataStructures.courses.size(); i++) {
            CourseRoster course = DataStructures.courses.get(i);
            String name    = course.name;
            String average = "" + course.getAverage();
            String totals  = "" + course.students.size();
            names.add(name);
            averages.add(average);  
            totalStudents.add(totals);
        }        
        names = DataStructures.texter.padSpaces(
                names, names.longestWord+1);
        averages = DataStructures.texter.padSpaces(
                averages, averages.longestWord+1);
        totalStudents = DataStructures.texter.padSpaces(
                totalStudents, totalStudents.longestWord+1);  
        final String DELIMIT = " ";
        int count = 1;
        for (int i = DataStructures.courses.size()-1; i >= 0; i--) {  
            if      (count < 10)   text += "\n(" + count + ")   ";            
            else if (count < 100)  text += "\n(" + count + ")  ";
            else if (count < 1000) text += "\n(" + count + ") ";
            if (type == DataStructures.SORT_All_COURSES_BY_NAME){                
                text += "Name: "    + names.get(i);
                text += DELIMIT + "Average: " + averages.get(i);
                text += DELIMIT + "Students: " + totalStudents.get(i);     
            }
            else if (type == DataStructures.SORT_All_COURSES_BY_AVERAGE){    
                text += "Average: " + averages.get(i);
                text += DELIMIT + "Name: "    + names.get(i);
                text += DELIMIT + "Students: " + totalStudents.get(i);      
            }
            else if (type == DataStructures.SORT_All_COURSES_BY_STUDENTS){  
                text += "Students: " + totalStudents.get(i); 
                text += DELIMIT + "Name: "    + names.get(i);
                text += DELIMIT + "Average: " + averages.get(i);                   
            }
//            String coursesTaken = DELIMIT + "(";
//            Student student = DataStructures.students.get(i);
//            for (int j = 0; j < student.courses.size()-1; j++) {
//                Course course = student.courses.get(j);
//                coursesTaken += course.name + ": " + course.grade + ", ";
//            }
//            Course course = student.courses.get(student.courses.size()-1);
//            coursesTaken += course.name + ": " + course.grade + ")";
//            text += coursesTaken;
            count++;
        } 
        reportAreaTextArea.setText(text);
        titleLabel.setText("Report on All Courses (" + 
                DataStructures.courses.size() + " total courses):");
        reportAreaTextArea.setCaretPosition(0);
        goBackButton.requestFocus();        
    }
    
}
