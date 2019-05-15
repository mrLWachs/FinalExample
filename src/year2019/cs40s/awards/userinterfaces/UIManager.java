/*
 *  Mr. Wachs' classes - Java Computer Science learning file UIManager.java
 *  for project FinalExamples on 15-May-2019 at 8:15:22 AM by lawrence.wachs
 */


/** required package class namespace */
package year2019.cs40s.awards.userinterfaces;

import year2019.cs40s.awards.userinterfaces.views.MainUIView;



/**
 * UIManager.java - 
 *
 * @author Mr. Wachs 
 * @since 15-May-2019 
 */
public class UIManager 
{

    /**
     * Default constructor for the class, sets class properties
     */
    public UIManager() {
        new MainUIView();
    }

    /**
     * String representation of this object
     *
     * @return The object represented as a String
     */
    @Override
    public String toString() {
        return "UIManager " + super.toString();
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
    public UIManager clone() {
        return this;
    }

}
