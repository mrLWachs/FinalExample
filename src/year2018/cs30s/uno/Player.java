
/** required package class namespace */
package year2018.cs30s.uno;

/** required imports */
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import year2018.cs30s.tools.Dialogs;

/**
 * Player.java - description here...
 *
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public class Player extends UnoPlayer
{
    
    private Opponent[] opponents;
    private Dialogs dialog;
    
    
    public Player(UnoPile pile, UnoDeck deck, JLabel[] labels, 
                  JLabel informationLabel, UnoRules rules) {
        super(deck, pile, rules, labels, informationLabel, rules.PLAYER);
        this.labels = labels;
        dialog      = new Dialogs(Environmentals.UNO_UI_TITLE, null);
        setClickEvents();
    }
    
    public void connectTo(Opponent[] opponents) {
        this.opponents = opponents;
    }
        
    public void chooseColor() {
        rules.choice = dialog.buttons("Choose color:", rules.COLOR_CHOICES);
        pile.setWildColor();
    }
        
    public void skip() {
        
    }

    private void setClickEvents() {
        for (int i = 0; i < labels.length; i++) {
            final int INDEX = i;
            labels[i].addMouseListener(new MouseListener() {
                public void mouseClicked(MouseEvent e)  { play(INDEX); }
                public void mousePressed(MouseEvent e)  {              }
                public void mouseReleased(MouseEvent e) {              }
                public void mouseEntered(MouseEvent e)  {              }
                public void mouseExited(MouseEvent e)   {              }
            });            
        }        
    }

}
