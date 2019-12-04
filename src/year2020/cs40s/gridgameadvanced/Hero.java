
/** required package class namespace */
package year2020.cs40s.gridgameadvanced;

/** requires imports */
import javax.swing.JLabel;
import year2020.cs40s.gridgameadvanced.tools.GameCharacter;

 
/**
 * Hero.java - the hero in the game, moving on the map
 *
 * @author Mr. Wachs
 * @since Dec. 4, 2019, 7:44:41 a.m.
 */
public class Hero extends GameCharacter
{
    
    private Display display;
    
    /**
     * Constructor, set class properties
     */
    public Hero(JLabel heroLabel, Display display) {
        super(heroLabel, Constants.HERO_AMOUNT, Constants.HERO_DIRECTION,
                Constants.HERO_DELAY, Constants.NUMBER_OF_DIRECTIONS);
        this.display = display;
    }

    @Override
    public void action() {
        mover.move();
        redraw();
    }
    
}
