
/** required package class namespace */
package year2020.cs40s.awards.data;

import java.io.Serializable;
import year2020.cs40s.awards.collections.LinkedList;

 
/**
 * AwardRule.java - description
 *
 * @author Mr. Wachs
 * @since 26-May-2020, 10:54:15 PM
 */
public class AwardRule implements Serializable
{

    public String name;
    public LinkedList<String> courseNames;
    
    /**
     * Default constructor, set class properties
     */
    public AwardRule(String name, LinkedList<String> courseNames) {
        this.name = name;
        this.courseNames = courseNames;
    }
     
   
}
