
/** required package class namespace */
package year2018.cs30s.uno;

/** required imports */
import javax.swing.JLabel;

/**
 * UnoHand.java - description here...
 *
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public class UnoHand 
{

    private UnoCard[] hand;
    private UnoRules  rules;
    private JLabel[]  labels;
    private UnoDeck   deck;
    private UnoPile   pile;
    private int       lastIndex;
    
    
    public static final int CANNOT_PLAY = -1;
    
    
    public UnoHand(UnoDeck deck, UnoPile pile, UnoRules rules, 
                   JLabel[] labels) {
        this.deck   = deck;
        this.pile   = pile;
        this.rules  = rules;
        this.labels = labels;        
        hand        = new UnoCard[labels.length];
        lastIndex   = rules.DEALT_CARDS_IN_HAND;
        dealHand();        
    }

    private void dealHand() {
        deck.dealOut(hand);
        displayHand();
    }

    public int findCard() {
        UnoCard topCard = pile.lookAtTop();
        for (int i = 0; i < hand.length; i++) {
            if (hand[i] != null) {
                if (hand[i].canPlayWith(topCard)) {
                    return i;
                }
            }
        }
        return CANNOT_PLAY;
    }
    
    public UnoCard lookAt(int card) {
        return hand[card];
    }
    
    public void get(UnoCard card) {
        hand[lastIndex] = card;
        lastIndex++;
        displayHand();
        if (lastIndex >= hand.length) {
            lastIndex = hand.length;
            rules.message(rules.HAND_CARDS_FULL);
        }
    }
    
    public void play(int card) {
        hand[card] = null;
        moveUpCards();
    }

    private void moveUpCards() {
        int emptySpot = -1;
        for (int i = 0; i < lastIndex; i++) {
            if (hand[i] == null) {
                emptySpot = i;
                i = lastIndex;
            }
        }
        if (emptySpot == -1) return;
        for (int i = emptySpot + 1; i < lastIndex; i++) {
            hand[i-1] = hand[i];
        }
        hand[lastIndex-1] = null;
        lastIndex--;
        displayHand();
    }

    private void displayHand() {
        for (int i = 0; i < hand.length; i++) {
            rules.drawCard(labels[i],hand[i]);
        }
    }

    public boolean isEmpty() {
        for (int i = 0; i < hand.length; i++) {
            if (hand[i] != null) return false;
        }
        return true;
    }
    
}
