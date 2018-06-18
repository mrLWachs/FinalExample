
/** required package class namespace */
package year2018.cs30s.uno;

/** required imports */
import java.awt.Color;
import javax.swing.JLabel;

/**
 * UnoPile.java - description here...
 *
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public class UnoPile 
{

    private JLabel    pileLabel;
    private UnoCard[] pile;
    private UnoRules  rules;
    private int       index;
    
    
    public UnoPile(JLabel pileLabel, UnoRules rules) {
        this.pileLabel = pileLabel;
        this.rules     = rules;        
        pile           = new UnoCard[rules.DECK_SIZE];
        index          = 0;
        
        rules.drawCard(pileLabel, null);
        
        pileLabel.setText("PILE");
        pileLabel.setOpaque(true);
        pileLabel.setBackground(Color.darkGray);
        pileLabel.setForeground(Color.white);
    }
    
    public void setWildColor() {
        if (rules.choice.equals(rules.COLOR_CHOICES[0])) {
            pileLabel.setBackground(rules.RED);
            pileLabel.setForeground(rules.RED_FORECOLOR);
            rules.choosenColor = rules.RED_VALUE;
        }
        else if (rules.choice.equals(rules.COLOR_CHOICES[1])) {
            pileLabel.setBackground(rules.GREEN);
            pileLabel.setForeground(rules.GREEN_FORECOLOR);
            rules.choosenColor = rules.GREEN_VALUE;
        }
        else if (rules.choice.equals(rules.COLOR_CHOICES[2])) {
            pileLabel.setBackground(rules.YELLOW);
            pileLabel.setForeground(rules.YELLOW_FORECOLOR);
            rules.choosenColor = rules.YELLOW_VALUE;
        }
        else if (rules.choice.equals(rules.COLOR_CHOICES[3])) {
            pileLabel.setBackground(rules.BLUE);
            pileLabel.setForeground(rules.BLUE_FORECOLOR);
            rules.choosenColor = rules.BLUE_VALUE;
        }
    }
    
    public void putOn(UnoCard card) {
        pile[index] = card;
        index++;
        rules.drawCard(pileLabel,card);
        if (index >= rules.DECK_SIZE) rules.gameOver(rules.ALL_CARDS_ON_DECK);
    }
    
    public UnoCard lookAtTop() {
        return pile[index-1];
    }
    
}
