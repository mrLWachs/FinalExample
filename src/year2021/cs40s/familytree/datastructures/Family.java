
/** Required package class namespace */
package year2021.cs40s.familytree.datastructures;

/** Required imports */
import year2021.cs40s.familytree.collections.LinkedList;
import java.io.Serializable;

/**
 * Family.java - This class represents an entire family (or person objects) in
 * the app. The family has a dynamic Lined List of all members (person objects)
 * and it also stores the family name (the last name). The "implements 
 * Serializable" is so a person object can be saved to a file (using the 
 * FileHandler class)
 *
 * @author Mr. Wachs' student 
 * @since Mar. 17, 2021 
 */
public class Family implements Serializable
{

    public String name;                         // The family's last name
    public LinkedList<Person> members;          // All members in the family
    
    
    /**
     * Default constructor for the class, sets all class properties
     * 
     * @param name the family's last name
     */
    public Family(String name) {
        this.name = name;                   // Set class property to parameter
        members = new LinkedList<>();       // Instantiate the Linked List
    }
    
    /**
     * Checks if one family os the same (equal to) another family by comparing
     * the family names of both families
     * 
     * @param object the object to compare with
     * @return the objects are equal (true) or not (false)
     */
    public boolean equals(Object object) {
        Family that = (Family)object;               // Cast object into family
        if (this.name.equalsIgnoreCase(that.name)) {    // Compare names
            return true;                                // Equal families
        }
        return false;                                   // Not equal familes
    }
    
}
