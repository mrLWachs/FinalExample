/*
 *  Mr. Wachs' classes - Java Computer Science learning file MainUIModel.java
 *  for project FinalExamples on 14-May-2019 at 8:20:10 AM by lawrence.wachs
 */


/** required package class namespace */
package year2019.cs40s.awards.userinterfaces.models;



/**
 * MainUIModel.java - 
 *
 * @author Mr. Wachs 
 * @since 14-May-2019 
 */
public class MainUIModel 
{

    /**
     * Default constructor for the class, sets class properties
     */
    public MainUIModel() {
        
    }

    /**
     * String representation of this object
     *
     * @return The object represented as a String
     */
    @Override
    public String toString() {
        return "MainUIModel " + super.toString();
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
    public MainUIModel clone() {
        return this;
    }

}
