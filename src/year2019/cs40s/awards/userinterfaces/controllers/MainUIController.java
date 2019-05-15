/*
 *  Mr. Wachs' classes - Java Computer Science learning file MainUIController.java
 *  for project FinalExamples on 14-May-2019 at 8:19:58 AM by lawrence.wachs
 */


/** required package class namespace */
package year2019.cs40s.awards.userinterfaces.controllers;

import year2019.cs40s.awards.userinterfaces.views.MainUIView;



/**
 * MainUIController.java - 
 *
 * @author Mr. Wachs 
 * @since 14-May-2019 
 */
public class MainUIController 
{

    public MainUIController(MainUIView aThis) {
        aThis.setSize(830, 800);
        aThis.setLocationRelativeTo(null);
        aThis.setVisible(true);
    }

    /**
     * String representation of this object
     *
     * @return The object represented as a String
     */
    @Override
    public String toString() {
        return "MainUIController " + super.toString();
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
    public MainUIController clone() {
        return this;
    }

}
