
/** required package class namespace */
package year2018.cs40s.pokedex;

/** required imports */
import year2018.cs40s.pokedex.userinterfaces.MainUI;


/**
 * PokeDexStart.java - an example internal assessment application for I.B. 
 * Computer Science in the form of a Pokémon 
 *
 * @author Mr. Wachs 
 * @since Dec 20, 2017 
 * @instructor Mr. Wachs
 */
public class PokeDexStart 
{

    /**
     * Default constructor sets class properties
     */
    public PokeDexStart() {
        new MainUI().setVisible(true);          // create user interface
    }

}
