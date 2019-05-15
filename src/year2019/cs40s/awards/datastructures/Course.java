

/** required package class namespace */
package year2019.cs40s.awards.datastructures;

import java.io.Serializable;



/**
 * Course.java - 
 *
 * @author Mr. Wachs 
 * @since 14-May-2019 
 */
public class Course implements Comparable<Course>, Serializable
{
    
    private String rawData;
    
    private int grade;
    private double mark;
    private String name;
    private String category;
        
    private boolean internationalBaccalaureate;
    private boolean vocational;
    private boolean academicCore;
    private boolean optional;    
    private boolean frenchImmersion;
    

    /**
     * Default constructor for the class, sets class properties
     */
    public Course() {
        
    }

    /**
     * String representation of this object
     *
     * @return The object represented as a String
     */
    @Override
    public String toString() {
        return "Course " + super.toString();
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
    public Course clone() {
        return this;
    }

    @Override
    public int compareTo(Course o) {
        return 0;
    }

}
