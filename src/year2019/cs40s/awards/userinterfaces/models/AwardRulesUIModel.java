/*
 *  Mr. Wachs' classes - Java Computer Science learning file AwardRulesUIModel.java
 *  for project FinalExamples on 15-May-2019 at 8:38:18 AM by lawrence.wachs
 */


/** required package class namespace */
package year2019.cs40s.awards.userinterfaces.models;



/**
 * AwardRulesUIModel.java - 
 *
 * @author Mr. Wachs 
 * @since 15-May-2019 
 */
public class AwardRulesUIModel 
{

    /**
     * Default constructor for the class, sets class properties
     */
    public AwardRulesUIModel() {
        
    }

    /**
     * String representation of this object
     *
     * @return The object represented as a String
     */
    @Override
    public String toString() {
        return "AwardRulesUIModel " + super.toString();
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
    public AwardRulesUIModel clone() {
        return this;
    }

}
