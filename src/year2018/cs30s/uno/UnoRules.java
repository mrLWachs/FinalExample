
/** required package class namespace */
package year2018.cs30s.uno;

/** required imports */
import java.awt.Color;
import javax.swing.JLabel;
import year2018.cs30s.tools.Dialogs;
import year2018.cs30s.tools.ImageTools;

/**
 * UnoRules.java - the rules and logic driving game play for the uno game
 *
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public class UnoRules 
{

    private final String  TAG1                  = "<html><center>";
    private final String  TAG2                  = "</center></html>";    
    private final int     CLOCKWISE             = 1;
    private final int     COUNTER_CLOCKWISE     = 2;    
    public final int      STANDARD_PLAY         = -1;
    public final int      DRAW_2_VALUE          = 10;
    public final int      SKIP_VALUE            = 11;
    public final int      REVERSE_VALUE         = 12;
    public final int      WILD_VALUE            = 13;
    public final int      WILD_DRAW_4_VALUE     = 14;
    public final String   DRAW_2_TEXT           = TAG1 + "Draw<br>Two" + TAG2;
    public final String   SKIP_TEXT             = "Skip";
    public final String   REVERSE_TEXT          = "Reverse";
    public final String   WILD_TEXT             = "Wild";
    public final String   WILD_DRAW_4_TEXT      = TAG1 + "Wild<br>Draw<br>Four" 
                                                  + TAG2;
    public final int      RED_VALUE             = 0;
    public final int      GREEN_VALUE           = 1;
    public final int      YELLOW_VALUE          = 2;
    public final int      BLUE_VALUE            = 3;
    public final Color    RED                   = Color.red;
    public final Color    GREEN                 = Color.green;
    public final Color    YELLOW                = Color.yellow;
    public final Color    BLUE                  = Color.blue;
    public final Color    WILD_COLOR            = Color.black;
    public final Color    WILD_DRAW_4_COLOR     = WILD_COLOR;    
    public final Color    RED_FORECOLOR         = Color.white;
    public final Color    GREEN_FORECOLOR       = Color.black;
    public final Color    YELLOW_FORECOLOR      = Color.black;
    public final Color    BLUE_FORECOLOR        = Color.white;
    public final Color    WILD_FORECOLOR        = Color.white;    
    public final Color    WILD_DRAW_4_FORECOLOR = WILD_FORECOLOR;        
    public final int      DECK_SIZE             = 108;   
    public final int      DEALT_CARDS_IN_HAND   = 7;
    public final int      NUMBER_OF_OPPONENTS   = 3;
    public final int      PLAYER                = 3;
    public final int      OPPONENT_1            = 0;
    public final int      OPPONENT_2            = 1;
    public final int      OPPONENT_3            = 2;
    public final String   PLAYER_TEXT           = "Player";
    public final String   OPPONENT_1_TEXT       = "Opponent 1";
    public final String   OPPONENT_2_TEXT       = "Opponent 2";
    public final String   OPPONENT_3_TEXT       = "Opponent 3";    
    public final int      ALL_CARDS_ON_DECK     = 1;    
    public final int      DECK_EMPTY            = 2;
    public final int      PLAYER_WINS           = 3;
    public final int      OPPONENT_WINS         = 4;
    public final String   CANNOT_PLAY_CARD      = "You cannot play this card!";
    public final String   HAND_CARDS_FULL       = "Your hand is full!";    
    public final String[] COLOR_CHOICES         = {"Red","Green","Yellow",
                                                   "Blue"};   
    
    private JLabel     instructionsLabel;
    private JLabel     playerInformationLabel;
    private JLabel[]   opponentInformationLabels;    
    private UnoUI      unoUI;
    private int        nextTurn;    
    private int        direction;    
    private Player     player;
    private Opponent[] opponents;   
    private UnoPlayer  opponent; 
    private ImageTools imageTool;
    private boolean graphicsMode;
    
    public String  choice;    
    public int     choosenColor;    
    public Dialogs dialog;
    
    
    /**
     * Constructor for the class sets class data to the parameters
     * 
     * @param instructionsLabel the label for instructions
     * @param playerInformationLabel the label for information on the player
     * @param opponentInformationLabels the label array for opponent's info
     * @param unoUI the user interface for the uno game
     */
    public UnoRules(JLabel instructionsLabel, JLabel playerInformationLabel,
                  JLabel[] opponentInformationLabels, UnoUI unoUI) {
        this.instructionsLabel         = instructionsLabel;
        this.playerInformationLabel    = playerInformationLabel;
        this.opponentInformationLabels = opponentInformationLabels;    
        this.unoUI                     = unoUI;            
        nextTurn                       = PLAYER;
        direction                      = CLOCKWISE;
        dialog       = new Dialogs(Environmentals.UNO_UI_TITLE, unoUI);
        graphicsMode = dialog.yesNo("Do you want Uno Card graphics?");
        message(PLAYER_TEXT + "'s turn");     
        imageTool = new ImageTools();
    }
    
    /**
     * Connects the rules to the player object and the opponent objects
     * 
     * @param player the player object to connect to
     * @param opponents the opponent object array to connect to
     */
    public void connectTo(Player player, Opponent[] opponents) {
        this.player    = player;
        this.opponents = opponents;        
    }
    
    /**
     * 
     * @param ending 
     */
    public void gameOver(int ending) {
        if (ending == ALL_CARDS_ON_DECK) 
            message("All cards have been played, the game is a draw!");
        else if (ending == DECK_EMPTY) 
            message("There are no cards left in the deck, the game is a draw!");
        else if (ending == PLAYER_WINS) 
            message("You have won UNO!");
        else if (ending == OPPONENT_WINS) 
            message("Your opponent has won UNO!");
    }

    public void nextTurn(UnoPlayer lastPlayer, UnoCard playedCard) {
        boolean shouldSkip = checkForSkips(playedCard);
        checkForReverse(playedCard);  
        String opponentText = setNextTurn(lastPlayer,shouldSkip);      
        boolean isDrawOrWild = false;
        if (!isDrawOrWild) isDrawOrWild = checkForDraw2(playedCard, 
                                                        opponentText);
        if (!isDrawOrWild) isDrawOrWild = checkForWild(playedCard, lastPlayer);
        if (!isDrawOrWild) isDrawOrWild = checkForWildDraw4(playedCard, 
                                                            opponentText, 
                                                            lastPlayer);
        if (!isDrawOrWild) message(opponentText + "'s turn");
        if (nextTurn != PLAYER) {
            Opponent myOpponent = (Opponent)opponent;
            myOpponent.play();
            checkForWin(myOpponent);
        }        
    }

    private void checkForWin(Opponent myOpponent) {
        if      (myOpponent.hasWon()) gameOver(OPPONENT_WINS);
        else if (player.hasWon())     gameOver(PLAYER_WINS);
    }
    
    private boolean checkForDraw2(UnoCard playedCard, String opponentText) {
        if (playedCard.type == DRAW_2_VALUE) {
            message(opponentText + " must draw 2 cards!");
            opponent.draw(2);
            return true;
        }       
        return false;
    }
    
    private boolean checkForWild(UnoCard playedCard, UnoPlayer lastPlayer) {
        if (playedCard.type == WILD_VALUE) {
            message("Wild card!");
            lastPlayer.chooseColor();
            return true;
        }       
        return false;
    }
    
    private boolean checkForWildDraw4(UnoCard playedCard, String opponentText, 
                                   UnoPlayer lastPlayer) {
        if (playedCard.type == WILD_DRAW_4_VALUE) {
            message("Wild card and " + opponentText + " must draw 4 cards!");
            lastPlayer.chooseColor();
            opponent.draw(4);
            return true;
        }       
        return false;
    }
    
    public void drawCard(JLabel label, UnoCard card) {
        if (label == null) return;        
        label.setOpaque(false);
        label.setBackground(null);
        label.setText("");
        label.setBorder(null);        
        if (card == null) {
            if (graphicsMode) {
                imageTool.changeImage(label, 
                        Environmentals.IMAGE_PATH + 
                        "UnoBack.png", true);
            }
            else {           
                label.setText("DECK");
                label.setOpaque(true);
                label.setBackground(Color.lightGray);
                label.setForeground(Color.black);
                label.setBorder(null);
            }
        }
        else {           
            if (graphicsMode) {
                String cardFile = "";
                if      (card.type == WILD_VALUE)        
                    cardFile = "Wild Card.jpg";
                else if (card.type == WILD_DRAW_4_VALUE) 
                    cardFile = "plus4wild.jpg";
                else {
                    if      (card.color == RED_VALUE)   
                        cardFile = "red";
                    else if (card.color == GREEN_VALUE)  
                        cardFile = "green";
                    else if (card.color == YELLOW_VALUE) 
                        cardFile = "yellow";
                    else if (card.color == BLUE_VALUE)   
                        cardFile = "blue";
                    if      (card.type == DRAW_2_VALUE)  
                        cardFile += "plus2.jpg";
                    else if (card.type == SKIP_VALUE)    
                        cardFile += "skip.jpg";
                    else if (card.type == REVERSE_VALUE) 
                        cardFile += "switch.jpg";
                    else                                 
                        cardFile += card.text + ".jpg";
                }
                imageTool.changeImage(label, 
                            Environmentals.IMAGE_PATH + 
                            cardFile, true);         
            }
            else {
                label.setOpaque(true);
                label.setText(card.text);
                label.setBackground(card.backcolor);
                label.setForeground(card.forecolor);        
                label.setBorder(Environmentals.CARD_BORDER);
            }
        }
    }

    public void message(String text) {        
        if (player != null) {
            player.informationLabel.setBackground(Environmentals.UNO_UI_BACK_COLOR);
            opponents[OPPONENT_1].informationLabel.setBackground(Environmentals.UNO_UI_BACK_COLOR);
            opponents[OPPONENT_2].informationLabel.setBackground(Environmentals.UNO_UI_BACK_COLOR);
            opponents[OPPONENT_3].informationLabel.setBackground(Environmentals.UNO_UI_BACK_COLOR);
            if (nextTurn != PLAYER) {
                opponent.informationLabel.setBackground(Color.yellow);
            }
            else {
                player.informationLabel.setBackground(Color.yellow);
            }
        }        
        instructionsLabel.setText(text);
        dialog.output(text, Environmentals.UNO_UI_TITLE);
    }

    private boolean checkForSkips(UnoCard playedCard) {
        if (playedCard.type == SKIP_VALUE) {            
            return true;
        }
        return false;
    }

    private void checkForReverse(UnoCard playedCard) {
        if (playedCard.type == REVERSE_VALUE) {
            message("direction now changes!");
            if      (direction == CLOCKWISE)         
                direction = COUNTER_CLOCKWISE;
            else if (direction == COUNTER_CLOCKWISE) 
                direction = CLOCKWISE;            
        }
    }

    private String setNextTurn(UnoPlayer lastPlayer, boolean shouldSkip) {
        opponent = null;
        String opponentText = "";
        if (direction == CLOCKWISE) {
            if (lastPlayer.type == PLAYER) {
                if (shouldSkip) {
                    nextTurn     = OPPONENT_2;
                    opponentText = OPPONENT_2_TEXT;
                    opponent     = opponents[OPPONENT_2];
                    message(OPPONENT_1_TEXT + " must skip a turn!");
                }
                else {
                    nextTurn     = OPPONENT_1;
                    opponentText = OPPONENT_1_TEXT;
                    opponent     = opponents[OPPONENT_1];
                }
            }
            else if (lastPlayer.type == OPPONENT_1) {
                if (shouldSkip) {
                    nextTurn     = OPPONENT_3;
                    opponentText = OPPONENT_3_TEXT;
                    opponent     = opponents[OPPONENT_3];
                    message(OPPONENT_2_TEXT + " must skip a turn!");
                }
                else {
                    nextTurn     = OPPONENT_2;
                    opponentText = OPPONENT_2_TEXT;
                    opponent     = opponents[OPPONENT_2];
                }
            }
            else if (lastPlayer.type == OPPONENT_2) {
                if (shouldSkip) {
                    nextTurn     = PLAYER;
                    opponentText = PLAYER_TEXT;
                    opponent     = player;
                    message(OPPONENT_3_TEXT + " must skip a turn!");
                }
                else {
                    nextTurn     = OPPONENT_3;
                    opponentText = OPPONENT_3_TEXT;
                    opponent     = opponents[OPPONENT_3];
                }
            }
            else if (lastPlayer.type == OPPONENT_3) {
                if (shouldSkip) {
                    nextTurn     = OPPONENT_1;
                    opponentText = OPPONENT_1_TEXT;
                    opponent     = opponents[OPPONENT_1];
                    message(PLAYER_TEXT + " must skip a turn!");
                }
                else {
                    nextTurn     = PLAYER;
                    opponentText = PLAYER_TEXT;
                    opponent     = player;
                }
            }
        }
        else if (direction == COUNTER_CLOCKWISE) {
            if (lastPlayer.type == PLAYER) {
                if (shouldSkip) {
                    nextTurn     = OPPONENT_2;
                    opponentText = OPPONENT_2_TEXT;
                    opponent     = opponents[OPPONENT_2];
                    message(OPPONENT_3_TEXT + " must skip a turn!");
                }
                else {
                    nextTurn     = OPPONENT_3;
                    opponentText = OPPONENT_3_TEXT;
                    opponent     = opponents[OPPONENT_3];
                }
            }
            else if (lastPlayer.type == OPPONENT_1) {
                if (shouldSkip) {
                    nextTurn     = OPPONENT_3;
                    opponentText = OPPONENT_3_TEXT;
                    opponent     = opponents[OPPONENT_3];
                    message(PLAYER_TEXT + " must skip a turn!");
                }
                else {
                    nextTurn     = PLAYER;
                    opponentText = PLAYER_TEXT;
                    opponent     = player;
                }
            }
            else if (lastPlayer.type == OPPONENT_2) {
                if (shouldSkip) {
                    nextTurn     = PLAYER;
                    opponentText = PLAYER_TEXT;
                    opponent     = player;
                    message(OPPONENT_1_TEXT + " must skip a turn!");
                }
                else {
                    nextTurn     = OPPONENT_1;
                    opponentText = OPPONENT_1_TEXT;
                    opponent     = opponents[OPPONENT_1];
                }
            }
            else if (lastPlayer.type == OPPONENT_3) {
                if (shouldSkip) {
                    nextTurn     = OPPONENT_1;
                    opponentText = OPPONENT_1_TEXT;
                    opponent     = opponents[OPPONENT_1];
                    message(OPPONENT_2_TEXT + " must skip a turn!");
                }
                else {
                    nextTurn     = OPPONENT_2;
                    opponentText = OPPONENT_2_TEXT;
                    opponent     = opponents[OPPONENT_2];
                }
            }
        }
        return opponentText;
    }
        
}
