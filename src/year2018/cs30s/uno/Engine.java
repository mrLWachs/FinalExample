
/** required package class namespace */
package year2018.cs30s.uno;

/** required imports */
import java.awt.Font;
import javax.swing.JLabel;
import mainpackage.Examples2018;
import mainpackage.MainClass;

/**
 * Engine.java -  the logic connected to the user interface that runs game logic
 *
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public class Engine 
{
    
    private UnoUI      unoUI;
    private Player     player;
    private UnoDeck    deck;
    private UnoPile    pile;
    private Opponent[] opponents;
    private UnoRules   rules;    
    
    /**
     * Constructor for the class sets class data to the parameters
     * 
     * @param pileLabel the label for the card pile
     * @param deckLabel the label for the deck 
     * @param instructionsLabel the label for instructions
     * @param opponent1CardLabels the label array for opponent 1's cards
     * @param opponent2CardLabels the label array for opponent 2's cards
     * @param opponent3CardLabels the label array for opponent 3's cards
     * @param playerCardLabels the label array for the player's cards
     * @param playerInformationLabel the label for information on the player
     * @param opponentInformationLabels the label array for opponent's info
     * @param deckInformationLabel the information label for the deck
     * @param pileInformationLabel the information label for the pile
     * @param unoUI the user interface for the uno game
     */
    public Engine(JLabel pileLabel, 
                  JLabel deckLabel, 
                  JLabel instructionsLabel, 
                  JLabel[] opponent1CardLabels, 
                  JLabel[] opponent2CardLabels, 
                  JLabel[] opponent3CardLabels, 
                  JLabel[] playerCardLabels,
                  JLabel playerInformationLabel,
                  JLabel[] opponentInformationLabels,
                  JLabel deckInformationLabel,
                  JLabel pileInformationLabel,
                  UnoUI unoUI) {
        setComponents(pileLabel,deckLabel,instructionsLabel,opponent1CardLabels,
                opponent2CardLabels,opponent3CardLabels,playerCardLabels,
                playerInformationLabel,opponentInformationLabels,
                deckInformationLabel,pileInformationLabel);
        
        this.unoUI                   = unoUI;
        rules                        = new UnoRules(instructionsLabel,
                                             playerInformationLabel,
                                             opponentInformationLabels,
                                             unoUI);
        deck                         = new UnoDeck(deckLabel,rules);
        pile                         = new UnoPile(pileLabel,rules); 
        JLabel[][] allOpponentLabels = {
            opponent1CardLabels,opponent2CardLabels,opponent3CardLabels
        };
        player    = new Player(pile,deck,playerCardLabels,
                              playerInformationLabel,rules);
        opponents = new Opponent[rules.NUMBER_OF_OPPONENTS];
        for (int i = 0; i < opponents.length; i++) {
            opponents[i] = new Opponent(allOpponentLabels[i],deck,pile,
                                        player,opponentInformationLabels[i],
                                        rules,i);
        }
        player.connectTo(opponents);  
        deck.connectTo(player);
        rules.connectTo(player,opponents);        
        startGame();
    }

    /**
     * Starts up the uno game with a starting card on the pile
     */
    private void startGame() {        
        UnoCard firstCard = deck.lookAtTop();           // look at top card
        while(firstCard.type == rules.WILD_DRAW_4_VALUE ||
              firstCard.type == rules.WILD_VALUE ||
              firstCard.type == rules.DRAW_2_VALUE ||
              firstCard.type == rules.SKIP_VALUE ||
              firstCard.type == rules.REVERSE_VALUE) {  // not valid top card
            firstCard = deck.lookAtTop();               // look at top card
            deck.shuffle();                             // reshuffle deck
        } 
        firstCard = deck.draw();                        // draw the first card 
        pile.putOn(firstCard);                          // put it on pile
    }

    /**
     * Shut down the survivor game and all game characters and return
     * to main application menu
     */
    public void shutDown() {       
        unoUI.dispose();
        MainClass.gamesPlayed++;
        Examples2018.menu();
    }    

    /**
     * Sets the look and feel of all label components
     * 
     * @param pileLabel the label for the card pile
     * @param deckLabel the label for the deck 
     * @param instructionsLabel the label for instructions
     * @param opponent1CardLabels the label array for opponent 1's cards
     * @param opponent2CardLabels the label array for opponent 2's cards
     * @param opponent3CardLabels the label array for opponent 3's cards
     * @param playerCardLabels the label array for the player's cards
     * @param playerInformationLabel the label for information on the player
     * @param opponentInformationLabels the label array for opponent's info
     * @param deckInformationLabel the information label for the deck
     * @param pileInformationLabel the information label for the pile
     */
    private void setComponents(JLabel pileLabel, JLabel deckLabel, 
                               JLabel instructionsLabel, 
                               JLabel[] opponent1CardLabels, 
                               JLabel[] opponent2CardLabels, 
                               JLabel[] opponent3CardLabels, 
                               JLabel[] playerCardLabels,
                               JLabel playerInformationLabel,
                               JLabel[] opponentInformationLabels,
                               JLabel deckInformationLabel,
                               JLabel pileInformationLabel) {
        Font font = new Font(Environmentals.CARD_FONT,
                             Environmentals.CARD_FONT_STYLE,
                             Environmentals.CARD_FONT_SIZE);        
        JLabel[] singleLabels = {
            pileLabel,deckLabel,instructionsLabel,playerInformationLabel,
            deckInformationLabel,pileInformationLabel
        };        
        JLabel[][] allLabels = {
            singleLabels,
            opponent1CardLabels,
            opponent2CardLabels,
            opponent3CardLabels,
            playerCardLabels,
            opponentInformationLabels
        };        
        for (int i = 0; i < allLabels.length; i++) {
            for (int j = 0; j < allLabels[i].length; j++) {
                allLabels[i][j].setFont(font);
                allLabels[i][j].setOpaque(true);
                allLabels[i][j].setBackground(Environmentals.UNO_UI_BACK_COLOR);
            }
        }        
    }

}
