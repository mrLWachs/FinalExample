
/** required package class namespace */
package year2018.cs30s.uno;

/** required imports */
import javax.swing.JLabel;

/**
 * UnoPlayer.java - description here...
 *
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public abstract class UnoPlayer 
{

    protected UnoHand  hand;
    protected UnoDeck  deck;
    protected UnoPile  pile;
    protected UnoRules rules;
    protected JLabel[] labels;
    
    public    JLabel   informationLabel;
    public    int      type;
    
    
    public UnoPlayer(UnoDeck deck, 
                     UnoPile pile,
                     UnoRules rules,
                     JLabel[] labels,
                     JLabel informationLabel,
                     int type) {
        this.deck             = deck;
        this.pile             = pile;
        this.rules            = rules;
        this.labels           = labels;    
        this.type             = type;
        this.informationLabel = informationLabel;
        hand                  = new UnoHand(deck,pile,rules,labels);
    }
    
    public void play(int index) {
        UnoCard card    = hand.lookAt(index);
        UnoCard topCard = pile.lookAtTop();
        if (card.canPlayWith(topCard)) {
            hand.play(index);
            pile.putOn(card);
            rules.nextTurn(this,card);
        }
        else {
            rules.message(rules.CANNOT_PLAY_CARD);
        }
    }

    public abstract void chooseColor();
    public abstract void skip();
    
    public void draw(int number) {
        for (int i = 0; i < number; i++) {
            UnoCard card = deck.draw();
            hand.get(card);        
        }
    }
    
    public boolean hasWon() {
        if (hand.isEmpty()) {
            return true;
        }
        return false;
    }
    
}
