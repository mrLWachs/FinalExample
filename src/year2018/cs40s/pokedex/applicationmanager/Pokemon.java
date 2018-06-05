
/** required package class namespace */
package year2018.cs40s.pokedex.applicationmanager;

/** required imports */
import java.io.Serializable;

/**
 * Pokemon.java - represents a Pokémon and it's data
 *
 * @author Mr. Wachs
 * @since Dec 20, 2017 
 * @instructor Mr. Wachs
 */
public class Pokemon implements Serializable, Comparable<Pokemon>
{

    public String name;                 // various data fields for the Pokémon
    public int number;
    public int hp;
    public int attack;
    public int defense;
    public int speed;
    public int special;
        
    
    /**
     * Constructor for the class sets class properties
     * 
     * @param name the name field for the Pokémon
     * @param number the number field for the Pokémon
     * @param hp the health points field for the Pokémon
     * @param attack the attack field for the Pokémon
     * @param defense the defense field for the Pokémon
     * @param speed the speed field for the Pokémon
     * @param special the special field for the Pokémon
     */
    public Pokemon(String name,
                   int number,
                   int hp,
                   int attack,
                   int defense,
                   int speed,
                   int special) {
        this.name    = name;
        this.number  = number;
        this.hp      = hp;
        this.attack  = attack;
        this.defense = defense;
        this.speed   = speed;
        this.special = special;        
    }

    /**
     * String representation of this object
     *
     * @return The object represented as a String
     */
    @Override
    public String toString() {
        return name +  "," +
               number + "," +
               hp + "," +
               attack + "," +
               defense + "," +
               speed + "," +
               special;
    }

    /**
     * Determines if two objects are "equal" in this context
     *
     * @param object the object to compare to
     * @return the objects are "equal" (true) or not (false)
     */
    @Override
    public boolean equals(Object object) {
        Pokemon pokemon = (Pokemon)object;
        if (this.name.equals(pokemon.name) &&
            this.hp == pokemon.hp &&
            this.attack == pokemon.attack &&
            this.defense == pokemon.defense &&
            this.speed == pokemon.speed &&
            this.special == pokemon.special)
            return true;
        return false;
    }

    /**
     * Creates a duplicate object using new memory
     *
     * @return a "clone" of the object using new memory
     */
    public Pokemon clone() {
        return this;
    }
    
    /**
     * compares the entry parameter to the current entry in terms of
     * less than, greater than, or equal to
     * 
     * @param pokemon the pokemon to compare to 
     * @return less than ( < 0 ), greater than ( > 0 ), or equal ( 0 )
     */
    @Override
    public int compareTo(Pokemon pokemon) {
        return this.name.compareTo(pokemon.name);
    }

}
