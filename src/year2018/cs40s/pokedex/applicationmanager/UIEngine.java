
/** required package class namespace */
package year2018.cs40s.pokedex.applicationmanager;

/** required imports */
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import mainpackage.MainClass;
import year2018.cs40s.io.Dialogs;

/**
 * UIEngine.java - a logic manager that drives the logic behind the user 
 * interface
 *
 * @author Mr. Wachs
 * @since Dec 21, 2017 
 * @instructor Mr. Wachs
 */
public class UIEngine 
{

    private JTextField nameField;                           // ui compontents
    private JSpinner   numberField;
    private JSpinner   hpField;
    private JSpinner   attackField;
    private JSpinner   defenseField;
    private JSpinner   speedField;
    private JSpinner   specialField;
    private JButton    enterIntoDBButton;
    private JButton    cancelButton;
    private JButton    displaySelectedButton;
    private JButton    deleteSelectedButton;
    private JButton    sortButton;
    private JList      list;
    private JFrame     frame;
    
    private PokeDex pokeDex;                                // Pokédex manager
    private DefaultListModel<String> listModel;             // used for listbox
    private Dialogs dialog;                                 // used for dialogs
    
    private final String POKEMON_UI_ICON = MainClass.MEDIA_PATH + "pokemon.png";
    
    
    /**
     * Constructor for the class sets class properties
     * 
     * @param nameField UI text field where name is inputted
     * @param numberField UI number spinner
     * @param hpField UI health points spinner
     * @param attackField UI attack spinner 
     * @param defenseField UI defense spinner
     * @param speedField UI speed spinner
     * @param specialField UI special spinner
     * @param enterIntoDBButton UI enter into database button
     * @param cancelButton UI cancel button
     * @param displaySelectedButton UI display selected button
     * @param deleteSelectedButton UI delete selected button
     * @param sortButton UI sort button
     * @param list UI list box 
     * @param frame UI main frame
     */
    public UIEngine(JTextField nameField,
                    JSpinner   numberField,
                    JSpinner   hpField,
                    JSpinner   attackField,
                    JSpinner   defenseField,
                    JSpinner   speedField,
                    JSpinner   specialField,
                    JButton    enterIntoDBButton,
                    JButton    cancelButton,
                    JButton    displaySelectedButton,
                    JButton    deleteSelectedButton,
                    JButton    sortButton,
                    JList      list,
                    JFrame     frame) {
        this.nameField             = nameField;             // set associations
        this.numberField           = numberField;
        this.hpField               = hpField;
        this.attackField           = attackField;
        this.defenseField          = defenseField;
        this.speedField            = speedField;
        this.specialField          = specialField;
        this.enterIntoDBButton     = enterIntoDBButton;
        this.cancelButton          = cancelButton;
        this.displaySelectedButton = displaySelectedButton;
        this.deleteSelectedButton  = deleteSelectedButton;
        this.sortButton            = sortButton;
        this.list                  = list;    
        this.frame                 = frame;     
        dialog    = new Dialogs("Pokemon Database", frame); // create dialogs
        pokeDex   = new PokeDex(dialog);                    // create Pokédex
        listModel = new DefaultListModel<String>();         // set list box
        this.list.setModel(listModel);              
        updateList();                                       // update list box        
         try {
            URL       url  = getClass().getResource(POKEMON_UI_ICON);
            URI       uri  = url.toURI();
            File      file = new File(uri);
            String    path = file.getAbsolutePath();
            ImageIcon icon = new ImageIcon(path);
            frame.setIconImage(icon.getImage());
        }
        catch (URISyntaxException ex) {
            System.out.println("URI error");
        } 
        frame.setLocationRelativeTo(null);                  // center frame
    }

    /**
     * Enter the user inputted data into the database and update UI
     */
    public void enterIntoDatatbase() {
        String name = nameField.getText();
        int number  = (Integer)numberField.getValue();      // get various 
        int hp      = (Integer)hpField.getValue();          // data from
        int attack  = (Integer)attackField.getValue();      // the UI
        int defense = (Integer)defenseField.getValue();     // components
        int speed   = (Integer)speedField.getValue();       
        int special = (Integer)specialField.getValue();     
        Pokemon pokemon = new Pokemon(name,number,hp,
                attack,defense,speed,special);              // create Pokémon
        pokeDex.add(pokemon);                               // add to Pokédex
        listModel.addElement(pokemon.toString());           // add to list box
    }

    /**
     * Cancels the user action and resets UI
     */
    public void cancel() {
        dialog.show("Operation cancelled!");                // display dialog
        nameField.setText("");                              // reset various
        numberField.setValue(Integer.valueOf(0));           // UI components
        hpField.setValue(Integer.valueOf(0));
        attackField.setValue(Integer.valueOf(0));
        defenseField.setValue(Integer.valueOf(0));
        speedField.setValue(Integer.valueOf(0));
        specialField.setValue(Integer.valueOf(0));        
    }

    /**
     * Displays the Pokémon selected from the list box
     */
    public void displaySelectedPokemon() {
        Object object = list.getSelectedValue();        // get user selection
        if (object == null) {                           // is selection valid
            dialog.show("Please make a selection!");    // show dialog
            return;                                     // exit method
        }
        String text = object.toString();                // convert to string
        Pokemon pokemon = pokeDex.find(text,list);      // find in Pokédex
        if (pokemon == null) {                          // not in Pokédex
            dialog.show("Selected Pokemon not avaialable!");
        }
        else {                                          // in Pokédex, display
            nameField.setText(pokemon.name);
            numberField.setValue(Integer.valueOf(pokemon.number));
            hpField.setValue(Integer.valueOf(pokemon.hp));
            attackField.setValue(Integer.valueOf(pokemon.attack));
            defenseField.setValue(Integer.valueOf(pokemon.defense));
            speedField.setValue(Integer.valueOf(pokemon.speed));
            specialField.setValue(Integer.valueOf(pokemon.special));
        }
    }

    /**
     * Deletes the Pokémon selected from the list box
     */
    public void deleteSelectedPokemon() {
        Object object = list.getSelectedValue();        // get user selection
        if (object == null) {                           // is selection valid
            dialog.show("Please make a selection!");    // show dialog
            return;                                     // exit method
        }
        String text = object.toString();                // convert to string
        Pokemon pokemon = pokeDex.find(text,list);      // find in Pokédex
        if (pokemon == null) {                          // not in Pokédex
            dialog.show("Selected Pokemon not avaialable!");
        }
        else {                                          // in Pokédex
            pokeDex.delete(pokemon);                    // delete from Pokédex
            listModel.remove(list.getSelectedIndex());  // remove from list box
        }
    }

    /**
     * Sorts the Pokémon in the Pokédex
     */
    public void sortPokemon() {
        pokeDex.sort(list,listModel);
    }

    /**
     * Updates the list box to match the Pokédex
     */
    private void updateList() {
        pokeDex.update(list,listModel);
    }
    
}
