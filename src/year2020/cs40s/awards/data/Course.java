
/** required package class namespace */
package year2020.cs40s.awards.data;

 
/**
 * Course.java - description
 *
 * @author Mr. Wachs
 * @since 19-May-2020, 9:57:38 PM
 */
public class Course implements Comparable<Course> 
{

    public String name;
    public String grade;
    public String term;
        
    private String sortMethod;
    
    /**
     * Default constructor, set class properties
     */
    public Course(String grade) {
        this.grade  = grade;
        name = "";
        term = "";
        sortMethod = name;
    }
     
    public void setSortMethod(int method) {
        if (method == DataStructures.SORT_COURSES_BY_NAME) {
            sortMethod = name;
        }
        else if (method == DataStructures.SORT_COURSES_BY_GRADE) {
            sortMethod = "Average";
        }
        else if (method == DataStructures.SORT_COURSES_BY_TERM) {
            sortMethod = term;
        }
    }
    
    public String toString() {
        return sortMethod; 
    }
    
    public double getGrade() {
        if (grade == null)    return 0;
        if (grade.equals("")) return 0;
        return Double.parseDouble(grade);
    }

    @Override
    public int compareTo(Course that) {
        if (sortMethod.equals("Average")) {
            double thisGrade = this.getGrade();
            double thatGrade = that.getGrade();
            if (thisGrade < thatGrade) return -1;
            if (thisGrade > thatGrade) return 1;            
            return 0;
        }        
        return this.toString().compareTo(that.toString());
    }
        
}
