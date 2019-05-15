/*
 *  Mr. Wachs' classes - Java Computer Science learning file Session.java
 *  for project FinalExamples on 15-May-2019 at 8:29:06 AM by lawrence.wachs
 */


/** required package class namespace */
package year2019.cs40s.awards.datastructures;

import java.io.Serializable;



/**
 * Session.java - 
 *
 * @author Mr. Wachs 
 * @since 15-May-2019 
 */
public class Session implements Serializable
{

    private String name;
    private AwardLists awardWinners;
    private AwardRules awardRules;
    private Courses allCourses;
    private Students allStudents;
        
    
    /**
     * Default constructor for the class, sets class properties
     */
    public Session() {
        
    }

    /**
     * String representation of this object
     *
     * @return The object represented as a String
     */
    @Override
    public String toString() {
        return "Session " + super.toString();
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
    public Session clone() {
        return this;
    }

}
