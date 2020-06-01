
/** required package class namespace */
package year2020.cs40s.awards.data;

import year2020.cs40s.awards.collections.LinkedList;

 
/**
 * CourseRoster.java - description
 *
 * @author Mr. Wachs
 * @since 21-May-2020, 11:05:59 AM
 */
public class CourseRoster implements Comparable<CourseRoster>
{

    public LinkedList<Student> students;
    public String name;
    
    private String sortMethod;
    
    
    
    public CourseRoster(String name) {
        this.name  = name;
        sortMethod = name;
        students   = new LinkedList<>();        
    }

    public void setSortMethod(int method) {
        if (method == DataStructures.SORT_All_COURSES_BY_NAME) {
            sortMethod = name;
        }
        else if (method == DataStructures.SORT_All_COURSES_BY_AVERAGE) {
            sortMethod = "SORT_All_COURSES_BY_AVERAGE";
        }
        else if (method == DataStructures.SORT_All_COURSES_BY_STUDENTS) {
            int size = students.size();
            if      (size < 10)  sortMethod = "00" + size;
            else if (size < 100) sortMethod = "0"  + size;
            else                 sortMethod = ""   + size;
        }
    }
    
    public boolean equals(Object object) {
        if (object == null) return false;
        try {
            CourseRoster that = (CourseRoster)object;
            if (!this.name.equals(that.name)) return false;
            return true;
        } catch (ClassCastException e) {
            System.out.println("Cast error -> " + e.toString());
            return false;
        }
    }    

    public String toString() {
        return sortMethod;
    }
    
    public double getAverage() {
        if (students == null) return 0;
        int count = 0;
        double sum = 0;
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            for (int j = 0; j < student.courses.size(); j++) {
                Course course = student.courses.get(j);
                String studentCourseName = course.name;
                if (name.equals(studentCourseName)) {
                    double grade = course.getGrade();
                    sum += grade;
                    count++;
                }
            }
        }
        double average = 0;
        if (count != 0) average = sum / count;
        return average;
    }

    @Override
    public int compareTo(CourseRoster that) {
        if (sortMethod.equals("SORT_All_COURSES_BY_AVERAGE")) {
            double averageThis = this.getAverage();
            double averageThat = that.getAverage();
            if (averageThis <  averageThat) return -1;
            if (averageThis >  averageThat) return 1;            
            return 0;
        } 
        return this.toString().compareTo(that.toString());
    }

}
