
/** Required package class namespace */
package year2021.cs40s.familytree.datastructures;

/** Required imports */
import year2021.cs40s.familytree.collections.LinkedList;
import java.io.Serializable;

 
/**
 * Person.java - This class represents a person in the app. The person stores
 * information about their name (first, middle, family name(s)) as well as 
 * connections (links) to male and female parents (also person objects) and
 * any spouses (a Linked List of person objects which can grow and shrink
 * dynamically as needed) and any children (also a dynamic data structure ADT
 * Linked List). The "implements Serializable" is so a person object can be
 * saved to a file (using the FileHandler class)
 *
 * @author Mr. Wachs' student 
 * @since Mar. 17, 2021 
 */
public class Person implements Serializable
{

    public String familyName;
    public String firstNames; 
    public String middleNames;     
    public String maidenName;
    public String birthDate;
    public String deathDate;
    
    public Person parentMale;
    public Person parentFemale;
    
    public LinkedList<Person> spouses;
    public LinkedList<Person> children;
        
    
    /**
     * Default constructor for the class, sets all class properties
     */
    public Person() {
        this.familyName   = "";
        this.firstNames   = ""; 
        this.middleNames  = "";         
        this.maidenName   = "";
        this.birthDate    = "";
        this.deathDate    = "";
        this.parentMale   = null;
        this.parentFemale = null;
        this.spouses      = new LinkedList<>();
        this.children     = new LinkedList<>();
    }
     
    /**
     * The method inherited from the object class we are over-riding so that
     * is we need to display a "person" as a string, this method is called 
     * instead. It shows the person's first, middle (if applicable) and 
     * family names put together.
     * 
     * @return The person object's full name 
     */
    public String toString() {
        // Create a string variable to store the data and later return which
        // starts with any first names
        String text = firstNames;
        
        // Attach (cconcatinate) any middle names but first check that this
        // person actualls has middle name(s)
        if (middleNames != null && !middleNames.equals("")) {
            text += " " + middleNames;
        }
        
        // Attach the family name
        text += " " + familyName;
        
        // Attach any maiden name checking they exist first
        if (maidenName != null && !maidenName.equals("")) {
            text += " (" + maidenName + ")";
        }        
        
        // Now return the full name
        return text;
    }
    
    /**
     * This method gives all information for this person including the full
     * name, birth and death dates, and all connected relatives information
     * 
     * @return 
     */
    public String allInformation() {
        // Create a string variable to store the data and later return which
        // starts with athe full name
        String text = toString();
        
        // Now attach the dates (if entered)
        text += " (";
        if (birthDate != null && !birthDate.equals("")) {
            text += birthDate;
        }
        else {
            text += "unknown";
        }
        text += " to ";
        if (deathDate != null && !deathDate.equals("")) {
            text += deathDate;
        }
        else {
            text += "unknown";
        }
        text += ") ";
        
        // Now attach the male and female parents (if entered)
        text += ", Father: ";
        if (parentMale != null) {
            text += parentMale.toString();
        }
        else {
            text += "unknown";
        }
        text += ", Mother: ";
        if (parentFemale != null) {
            text += parentFemale.toString();
        }      
        else {
            text += "unknown";
        }
        
        // Now attach any spouses (if entered)
        if (spouses != null && !spouses.isEmpty()) {
            // Read in the size of the list
            int size = spouses.size();
            // Only a single spouse
            if (size == 1) {
                text += ", has " + size + " spouse (";
            }
            else {
                text += ", has " + size + " spouses (";
            }
            // Loop through the list attaching names
            for (int i = 0; i < size-1; i++) {
                text += spouses.get(i).toString() + ",";
            }
            // Attach last name in the list
            text += spouses.get(size-1).toString() + ")";            
        }
        
        // Now attach any children (if entered)
        if (children != null && !children.isEmpty()) {
            // Read in the size of the list
            int size = children.size();
            // Only a single child
            if (size == 1) {
                text += ", has " + size + " child (";
            }
            else {
                text += ", has " + size + " children (";
            }
            // Loop through the list attaching names
            for (int i = 0; i < size-1; i++) {
                text += children.get(i).toString() + ",";
            }
            // Attach last name in the list
            text += children.get(size-1).toString() + ")"; 
        }
        
        // Now return all the information
        return text;
    }
        
}
