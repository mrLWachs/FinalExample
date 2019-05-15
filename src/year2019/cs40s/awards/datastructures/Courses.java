

/** required package class namespace */
package year2019.cs40s.awards.datastructures;

import java.io.Serializable;
import year2019.cs40s.awards.tools.LinkedList;



/**
 * Courses.java - 
 *
 * @author Mr. Wachs 
 * @since 14-May-2019 
 */
public class Courses implements Serializable
{

    private LinkedList<Course> list;
    private int grade;
    private double gpa;
    
    
    /**
     * Default constructor for the class, sets class properties
     */
    public Courses() {
        
    }

    /**
     * String representation of this object
     *
     * @return The object represented as a String
     */
    @Override
    public String toString() {
        return "Courses " + super.toString();
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
    public Courses clone() {
        return this;
    }

}
