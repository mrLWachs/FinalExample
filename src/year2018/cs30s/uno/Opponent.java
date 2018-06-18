
/** required package class namespace */
package year2018.cs30s.uno;

/** required imports */
import javax.swing.JLabel;
import year2018.cs30s.tools.Numbers;

/**
 * Opponent.java - description here...
 *
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public class Opponent extends UnoPlayer
{

    private Player player;
    private int opponentNumber;
    
    public Opponent(JLabel[] labels, UnoDeck deck, UnoPile pile, Player player, 
                    JLabel informationLabel, UnoRules rules, 
                    int opponentNumber) {
        super(deck, pile, rules, labels, informationLabel, opponentNumber);     
        this.player         = player; 
        this.opponentNumber = opponentNumber;
    }
    
    public void play() {
        rules.message("Computer Opponent " + (opponentNumber + 1) + 
                " will now play...");
        int index = hand.findCard();
        if (index == UnoHand.CANNOT_PLAY) draw(1);
        else                              play(index); 
    }
    
    public void chooseColor() {
        int choice = Numbers.random(rules.RED_VALUE, rules.BLUE_VALUE);
        rules.choice = rules.COLOR_CHOICES[choice];
        rules.message("Computer chooses " + rules.choice);   
        pile.setWildColor();
    }
    
    public void skip() {
        
    }

    
}
