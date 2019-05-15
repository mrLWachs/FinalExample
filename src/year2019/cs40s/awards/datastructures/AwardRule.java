/*
 *  Mr. Wachs' classes - Java Computer Science learning file AwardRule.java
 *  for project FinalExamples on 15-May-2019 at 8:17:34 AM by lawrence.wachs
 */


/** required package class namespace */
package year2019.cs40s.awards.datastructures;

import java.io.Serializable;



/**
 * AwardRule.java - 
 *
 * @author Mr. Wachs 
 * @since 15-May-2019 
 */
public class AwardRule implements Comparable<AwardRule>, Serializable
{

    private String name;
    private Courses courses;
    private boolean requiresMinimumGrade;
    private double minimumGrade;
    
    
    /**
     * Default constructor for the class, sets class properties
     */
    public AwardRule() {
        
    }

    /**
     * String representation of this object
     *
     * @return The object represented as a String
     */
    @Override
    public String toString() {
        return "AwardRule " + super.toString();
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
    public AwardRule clone() {
        return this;
    }

    @Override
    public int compareTo(AwardRule o) {
        return 0;
    }

}
