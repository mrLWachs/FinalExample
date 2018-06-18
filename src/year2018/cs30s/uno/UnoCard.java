
/** required package class namespace */
package year2018.cs30s.uno;

/** required imports */
import java.awt.Color;

/**
 * UnoCard.java - description here...
 *
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public class UnoCard 
{
    
    public  int    type;
    public  int    color;
    public  Color  backcolor;
    public  Color  forecolor;
    public  String text;
    
    private UnoRules rules;
    
    
    public UnoCard(int value, int color, UnoRules rules) {
        this.type  = value;        
        this.color = color;   
        this.rules = rules;
        setColor(color);     
        setText();
    }
 
    public boolean canPlayWith(UnoCard card) {
        if      (card == null)                            return false;
        else if (type == rules.WILD_VALUE)                return true;
        else if (type == rules.WILD_DRAW_4_VALUE)         return true;
        else if (card.type == rules.WILD_VALUE &&
                 color     == rules.choosenColor)         return true;
        else if (card.type == rules.WILD_DRAW_4_VALUE &&
                 color     == rules.choosenColor)         return true;
        else {
            if      (color == card.color)                 return true;
            else if (type  == card.type)                  return true;
        }
        return false;
    }
    
    public boolean equals(UnoCard card) {
        if (this.type == card.type &&
            this.backcolor == card.backcolor) {
            return true;
        }
        else {
            return false;
        }
    }

    private void setColor(int color) {
        if (color == rules.RED_VALUE) {
            backcolor = rules.RED;
            forecolor = rules.RED_FORECOLOR;
        }
        else if (color == rules.GREEN_VALUE) {
            backcolor = rules.GREEN;
            forecolor = rules.GREEN_FORECOLOR;
        }
        else if (color == rules.YELLOW_VALUE) {
            backcolor = rules.YELLOW;
            forecolor = rules.YELLOW_FORECOLOR;
        }
        else if (color == rules.BLUE_VALUE) {
            backcolor = rules.BLUE;
            forecolor = rules.BLUE_FORECOLOR;
        }
        else if (color == rules.WILD_VALUE) {
            backcolor = rules.WILD_COLOR;
            forecolor = rules.WILD_FORECOLOR;
        }
        else if (color == rules.WILD_DRAW_4_VALUE) {
            backcolor = rules.WILD_DRAW_4_COLOR;
            forecolor = rules.WILD_DRAW_4_FORECOLOR;
        }
    }

    private void setText() {
        if      (type == rules.DRAW_2_VALUE)      text = rules.DRAW_2_TEXT;
        else if (type == rules.SKIP_VALUE)        text = rules.SKIP_TEXT;
        else if (type == rules.REVERSE_VALUE)     text = rules.REVERSE_TEXT;
        else if (type == rules.WILD_VALUE)        text = rules.WILD_TEXT;
        else if (type == rules.WILD_DRAW_4_VALUE) text = rules.WILD_DRAW_4_TEXT;
        else                                      text = "" + type;
    }  
    
}
