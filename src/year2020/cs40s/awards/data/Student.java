
/** required package class namespace */
package year2020.cs40s.awards.data;

import year2020.cs40s.awards.collections.LinkedList;

 
/**
 * Student.java - description
 *
 * @author Mr. Wachs
 * @since 19-May-2020, 9:55:53 PM
 */
public class Student implements Comparable<Student>
{
    
    public String name;
    public LinkedList<Course> courses;
    
    private String sortMethod;
    
    private String courseName;

    /**
     * Default constructor, set class properties
     */
    public Student(String name) {
        this.name  = name;
        sortMethod = name;
        courses    = new LinkedList<>();
    }
    
    public void setSortMethod(int method, String courseName) {
        if (method == DataStructures.SORT_STUDENTS_BY_NAME) {
            sortMethod = name;
        }
        else if (method == DataStructures.SORT_STUDENTS_BY_AVERAGE) {
            sortMethod = "SORT_STUDENTS_BY_AVERAGE";
        }
        else if (method == DataStructures.SORT_STUDENTS_BY_COURSES) {
            int size = courses.size();
            if      (size < 10)  sortMethod = "00" + size;
            else if (size < 100) sortMethod = "0"  + size;
            else                 sortMethod = ""   + size;
        }
        else if (method == DataStructures.SORT_STUDENTS_BY_GRADE) {
            sortMethod = "SORT_STUDENTS_BY_GRADE";
            this.courseName = courseName;
        }        
    }
    
    public String toString() {
        return sortMethod;
    }
    
    public double getAverage() {
        if (courses == null) return 0;
        int count = 0;
        double sum = 0;
        for (int i = 0; i < courses.size(); i++) {
            sum += courses.get(i).getGrade();
            count++;
        }
        double average = 0;
        if (count != 0) average = sum / count;
        return average;
    }

    @Override
    public int compareTo(Student that) {        
        if (sortMethod.equals("SORT_STUDENTS_BY_AVERAGE")) {
            double averageThis = this.getAverage();
            double averageThat = that.getAverage();
            if (averageThis <  averageThat) return -1;
            if (averageThis >  averageThat) return 1;            
            return 0;
        }        
        if (sortMethod.equals("SORT_STUDENTS_BY_GRADE")) {
            String thisText = this.getGrade(courseName);
            String thatText = that.getGrade(courseName);
            double thisGrade = Double.parseDouble(thisText);
            double thatGrade = Double.parseDouble(thatText);
            if (thisGrade < thatGrade) return -1;
            if (thisGrade > thatGrade) return 1;            
            return 0;
        }
        return this.toString().compareTo(that.toString());
    }

    public String getGrade(String courseName) {
        for (int i = 0; i < courses.size(); i++) {
            Course course = courses.get(i);
            String name = course.name;
            if (name.equals(courseName)) {
                return course.grade;
            }
        }
        return "";
    }
    
}
