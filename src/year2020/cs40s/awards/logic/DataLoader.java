
/** required package class namespace */
package year2020.cs40s.awards.logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFrame;
import year2020.cs40s.awards.data.Course;
import year2020.cs40s.awards.data.CourseRoster;
import year2020.cs40s.awards.data.DataStructures;
import year2020.cs40s.awards.data.Student;
import year2020.cs40s.awards.io.Dialogs;
import year2020.cs40s.awards.userinterfaces.LoadingView;

 
/**
 * DataLoader.java - description
 *
 * @author Mr. Wachs
 * @since 19-May-2020, 9:32:27 PM
 */
public class DataLoader 
{

    private static Dialogs dialog;
    
    private static Student student;
    private static Course course;
    
    
    public static void loadData(JFrame frame) {
        dialog = new Dialogs();
        File file = dialog.openFile(frame);
        if (file != null) {            
            try {
                
                final int MINUTES = 4;
                final int SECONDS = 30;
                final int SEC_TIME = 1000;
                final int MIN_TIME = SEC_TIME * 60;
                int time = (MINUTES * MIN_TIME) + (SECONDS * SEC_TIME);
                                
                new LoadingView(null, time);
                
                FileReader reader = new FileReader(file);
                BufferedReader buffer = new BufferedReader(reader);
                String line = buffer.readLine();
                while (line != null) {  
                    if      (isName(line))   addName(line);
                    else if (isGrade(line))  addGrade(line);
                    else if (isTerm(line))   addTerm(line);
                    else if (isCourse(line)) addCourse(line);
                    line = buffer.readLine();
                }
                addName(line);
                buffer.close();
            } catch (IOException e) {
                System.out.println("File read error -> " + e.toString());
            }
        }
    }

    private static boolean isName(String line) {
        if (line == null) return false;
        if (line.charAt(0) == '"') return true;
        return false;
    }

    private static boolean isCourse(String line) {
        if (line == null)               return false;
        if (line.equals("Row Labels"))  return false;
        if (line.equals("Grand Total")) return false; 
        if (line.equals(""))            return false;         
        return true;
    }
    
    private static boolean isGrade(String line) {
        if (line == null) return false;
        char first = line.charAt(0);
        if (first == '1') return true;
        if (first == '2') return true;
        if (first == '3') return true;
        if (first == '4') return true;
        if (first == '5') return true;
        if (first == '6') return true;
        if (first == '7') return true;
        if (first == '8') return true;
        if (first == '9') return true;
        if (first == '0') return true;
        return false;
    }
    
    private static boolean isTerm(String line) {
        if (line == null) return false;
        if (line.equals("Y1")) return true;
        if (line.equals("T1")) return true;
        if (line.equals("T2")) return true;
        if (line.equals("T3")) return true;
        return false;
    }
    
    private static void addName(String line) {
        if (student != null) {
            DataStructures.students.add(student);
            addCourses(student);
        }
        if (line == null) return;
        int length = line.length() - 1;
        String name = line.substring(1, length); 
        student = new Student(name);       
    }

    private static void addCourse(String line) {
        CourseRoster courseRoster = new CourseRoster(line);
        if (!DataStructures.courses.contains(courseRoster)) {
            DataStructures.courses.add(courseRoster);            
        }
        course.name = line;
    }

    private static void addTerm(String line) {
        course.term = line;
        student.courses.add(course);
    }

    private static void addGrade(String line) {
        course = new Course(line);
    }

    private static void addCourses(Student student) {        
        for (int i = 0; i < student.courses.size(); i++) {
            String studentCourseName = student.courses.get(i).name; 
            String studentName = student.name;
            for (int j = 0; j < DataStructures.courses.size(); j++) {
                CourseRoster courseRoster = DataStructures.courses.get(j);
                String allCoursesName = courseRoster.name;
                if (studentCourseName.equals(allCoursesName)) {
                    boolean inList = false;
                    for (int k = 0; k < courseRoster.students.size(); k++) {
                        Student allCoursesStudent = courseRoster.students.get(k);
                        String allCoursesStudentName = allCoursesStudent.name;
                        if (allCoursesStudentName.equals(studentName)) {
                            inList = true;
                        }
                    }
                    if (!inList) courseRoster.students.add(student);
                }
            }            
        }
    }
    
}

