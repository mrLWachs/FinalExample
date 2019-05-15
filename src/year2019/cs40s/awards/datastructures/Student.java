

/** required package class namespace */
package year2019.cs40s.awards.datastructures;

import java.io.Serializable;



/**
 * Student.java - 
 *
 * @author Mr. Wachs 
 * @since 14-May-2019 
 */
public class Student implements Comparable<Student>, Serializable
{
    
    private String rawData;
    private String firstName;
    private String lastName;
    
    private int grade;
    
    private Courses allCourses;
    private Courses grade9Courses;
    private Courses grade10Courses;
    private Courses grade11Courses;
    private Courses grade12Courses;
    
    private double gpa;

    /**
     * Default constructor for the class, sets class properties
     */
    public Student() {
        
    }

    /**
     * String representation of this object
     *
     * @return The object represented as a String
     */
    @Override
    public String toString() {
        return "Student " + super.toString();
    }
        
    /**
     * Determines if two objects are "equal" in this context
     *
     * @param object the object to compare to
     * @return the objects are "equal" (true) or not (false)
     */
    @Override
    public boolean equals(Object object) {
        return super.equals(object);
    }

    /**
     * Creates a duplicate object using new memory
     *
     * @return a "clone" of the object using new memory
     */
    @Override
    public Student clone() {
        return this;
    }

    @Override
    public int compareTo(Student o) {
        return 0;
    }

}
