
/** required package class namespace */
package year2018.cs30s.uno;

/** required imports */
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;

/**
 * UnoDeck.java - description here...
 *
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public class UnoDeck 
{
    
    private JLabel    deckLabel;
    private UnoCard[] deck;
    private UnoRules  rules;
    private Player    player;
    private int       index;
    
    
    public UnoDeck(JLabel deckLabel, UnoRules rules) {
        this.deckLabel = deckLabel;
        this.rules     = rules;
        deck           = new UnoCard[rules.DECK_SIZE];  
        index          = 0;
        buildDeck();
        shuffle();
        setLabel();
    }

    public void connectTo(Player player) {
        this.player = player;
    } 
        
    private void click() {
        player.draw(1);
    }
    
    private void setLabel() {
        rules.drawCard(deckLabel, null);
        deckLabel.addMouseListener(new MouseListener()
        {
            public void mouseClicked(MouseEvent e)  {  click();  }
            public void mousePressed(MouseEvent e)  {            }
            public void mouseReleased(MouseEvent e) {            }
            public void mouseEntered(MouseEvent e)  {            }
            public void mouseExited(MouseEvent e)   {            }
        });
    }

    private void buildDeck() {
        int count  = 0;
        for (int color = rules.RED_VALUE; color <= rules.BLUE_VALUE; color++) {
            deck[count] = new UnoCard(0, color, rules);
            count++;
            for (int i = 0; i < 2; i++) {
                for (int value = 1; value <= 9; value++) {
                    deck[count] = new UnoCard(value, color, rules);
                    count++;
                }
                deck[count] = new UnoCard(rules.DRAW_2_VALUE, color, rules);
                count++;
                deck[count] = new UnoCard(rules.SKIP_VALUE, color, rules);
                count++;
                deck[count] = new UnoCard(rules.REVERSE_VALUE, color, rules);
                count++; 
            }
        }
        for (int i = 0; i < 4; i++) {
            deck[count] = new UnoCard(rules.WILD_VALUE, 
                                      rules.WILD_VALUE, rules);
            count++;
            deck[count] = new UnoCard(rules.WILD_DRAW_4_VALUE, 
                                      rules.WILD_DRAW_4_VALUE, rules);
            count++;
        }
    }

    public void shuffle() {
        UnoCard[] shuffled = new UnoCard[rules.DECK_SIZE];        
        for (int i = 0; i < deck.length; i++) {
            int spot = -1;
            do {
                spot = random(0,rules.DECK_SIZE-1);
            } while (shuffled[spot] != null);
            shuffled[spot] = deck[i];
        }
        for (int i = 0; i < deck.length; i++) {
            deck[i] = shuffled[i];
        }
    }
    
    public UnoCard lookAtTop() {
        return deck[index];
    }
    
    public UnoCard draw() {
        UnoCard topCard = deck[index];
        index++;
        if (index >= rules.DECK_SIZE) {
            rules.gameOver(rules.DECK_EMPTY);
            return null;
        }
        else return topCard;
    }

    private int random(int low, int high) {
        double seed   = Math.random();
        double L      = (double)low;
        double H      = (double)high;
        double number = (H - L + 1d) * seed + L;
        return (int)number;
    }


    public void dealOut(UnoCard[] hand) {
        for (int i = 0; i < rules.DEALT_CARDS_IN_HAND; i++) {
            hand[i] = draw();
        }
    }
    
}
