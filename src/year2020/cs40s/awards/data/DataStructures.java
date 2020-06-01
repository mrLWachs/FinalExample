
/** required package class namespace */
package year2020.cs40s.awards.data;

import java.awt.Color;
import java.awt.Font;
import year2020.cs40s.awards.collections.LinkedList;
import year2020.cs40s.awards.io.Dialogs;
import year2020.cs40s.awards.io.FileHandler;
import year2020.cs40s.awards.logic.DataSaver;
import year2020.cs40s.awards.tools.Search;
import year2020.cs40s.awards.tools.Sort;
import year2020.cs40s.awards.tools.Text;

 
/**
 * DataStructures.java - description
 *
 * @author Mr. Wachs
 * @since 19-May-2020, 9:32:09 PM
 */
public class DataStructures 
{

    public static LinkedList<CourseRoster> courses;
    public static LinkedList<Student> students;
    public static LinkedList<AwardRule> rules;
    
    public static final String TITLE = "Awards Sorter";
    public static final Color BACKGROUND = Color.WHITE;
    public static final Color FOREGROUND = Color.BLACK;
    public static final Font FONT1 = new Font("Arial Narrow",Font.PLAIN,20);
    public static final Font FONT2 = new Font("Arial Narrow",Font.PLAIN,16);
    public static final Font FONT3 = new Font("Courier New",Font.PLAIN,10);
        
    public static final int SORT_STUDENTS_BY_NAME    = 0;
    public static final int SORT_STUDENTS_BY_AVERAGE = 1;
    public static final int SORT_STUDENTS_BY_COURSES = 2;
    public static final int SORT_STUDENTS_BY_GRADE   = 3;
        
    public static final int SORT_All_COURSES_BY_NAME     = 0;
    public static final int SORT_All_COURSES_BY_AVERAGE  = 1;
    public static final int SORT_All_COURSES_BY_STUDENTS = 2;
        
    public static final int SORT_COURSES_BY_NAME  = 0;
    public static final int SORT_COURSES_BY_GRADE = 1;
    public static final int SORT_COURSES_BY_TERM  = 2;
    
    public static final String DATA_FILE = "/year2020/cs40s/awards/data/data.txt";
    
    public static Sort        sorter;
    public static Search      searcher;    
    public static Text        texter;
    public static Dialogs     dialog;
    public static FileHandler fileHandler;
    public static DataSaver   data;
        
    
    
    public static void initialize() {
        courses     = new LinkedList<>();
        students    = new LinkedList<>();
        rules       = new LinkedList<>();        
        dialog      = new Dialogs(TITLE,null,FONT1,BACKGROUND,FOREGROUND);
        fileHandler = new FileHandler(dialog);
        sorter      = new Sort();
        searcher    = new Search();
        texter      = new Text();
        data        = new DataSaver();
    }

    public static void sortStudents(int method) {
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            student.setSortMethod(method,"");
        }
        sorter.quick(students);
    }

    public static void sortCourses(int method) {
        for (int i = 0; i < courses.size(); i++) {
            CourseRoster courseRoster = courses.get(i);
            courseRoster.setSortMethod(method);
        }
        sorter.quick(courses);
    }
    
}
