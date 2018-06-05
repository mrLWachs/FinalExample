
/** required package class namespace */
package year2018.cs40s.pokedex.applicationmanager;

/** required imports */
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import year2018.cs40s.collections.LinkedList;
import year2018.cs40s.io.Dialogs;
import year2018.cs40s.io.FileHandler;
import year2018.cs40s.searchsort.Sorter;

/**
 * PokeDex.java - a Pokédex database of user inputted Pokémon data
 *
 * @author Mr. Wachs
 * @since Dec 22, 2017 
 * @instructor Mr. Wachs
 */
public class PokeDex implements Serializable
{
    
    private File file;                                      // file object
    private FileHandler<LinkedList<Pokemon>> fileHandler;   // file handler
    private LinkedList<Pokemon> pokemons;                   // list object
    private Dialogs dialog;                                 // dialog object
    private Sorter sort;
    
    /**
     * Constructor for the class sets class properties
     * 
     * @param dialog the dialogs associated with this Pokédex
     */
    public PokeDex(Dialogs dialog) {
        this.dialog = dialog;                           // set association
        try {
            file = new File("data.txt");                // create data file
            if (!file.exists()) file.createNewFile();   // create new file
            fileHandler = new FileHandler<LinkedList<Pokemon>>(dialog);
            pokemons    = (LinkedList<Pokemon>)fileHandler.openObject(file);
            if (pokemons == null) pokemons = new LinkedList<>();
            sort = new Sorter();
        }
        catch (IOException error) {
            dialog.show("File error!");                 // file error
        }
    }
    
    /**
     * Adds the passed Pokémon to the PokéDex
     * 
     * @param pokemon the Pokémon object to add
     */
    public void add(Pokemon pokemon) {
        pokemons.add(pokemon);                      // add to list object
        fileHandler.saveObject(pokemons, file);     // save list to file
    }

    /**
     * Finds the user selected text matching a Pokémon in the PokéDex
     * 
     * @param text the user selected text to search for
     * @param list the list box UI to update
     * @return the Pokémon object found (or null)
     */
    public Pokemon find(String text, JList list) {
        String[] parts = text.split("[,]");             // seperate the text
        String name = parts[0];                         // get name from parts
        int number  = Integer.parseInt(parts[1]);       // get various other
        int hp      = Integer.parseInt(parts[2]);       // fields from array
        int attack  = Integer.parseInt(parts[3]);       // of parts that 
        int defense = Integer.parseInt(parts[4]);       // was created from
        int speed   = Integer.parseInt(parts[5]);       // spitting the string
        int special = Integer.parseInt(parts[6]);
        Pokemon pokemon = new Pokemon(name,number,
                hp,attack,defense,speed,special);       // create Pokémon
        int index = pokemons.firstIndexOf(pokemon);     // find in list
        if (index == -1) return null;                   // not in list
        list.setSelectedIndex(index);                   // select in list box
        return pokemon;                                 // return Pokémon
    }

    /**
     * Deletes the passed Pokémon from the PokéDex
     * 
     * @param pokemon the Pokémon to delete
     */
    public void delete(Pokemon pokemon) {
        pokemons.remove(pokemon);                       // remove from list
        fileHandler.saveObject(pokemons, file);         // save updated list
    }

    /**
     * Sorts the PokéDex by name and updates the user interface
     * 
     * @param list the UI list box component
     * @param listModel the list box UI to update
     */
    public void sort(JList list, DefaultListModel<String> listModel) {
        sort.quick(pokemons);
        update(list, listModel);
        //dialog.show("Feature not yet implemented!");
    }

    /**
     * Updates the list box on the User Interface to the current PokéDex
     * 
     * @param list the UI list box component
     * @param listModel the list model for the list box UI component
     */
    public void update(JList list, DefaultListModel<String> listModel) {
        if (pokemons == null) listModel.addElement("PokeDex Empty");
        else {
            listModel.removeAllElements();
            for (int i = 0; i < pokemons.size(); i++) {
                Pokemon pokemon = pokemons.get(i);
                listModel.addElement(pokemon.toString());
            }
        }
    }

}
