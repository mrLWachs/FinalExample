
/** required package class namespace */
package year2018.cs30s.moregaming.snake;

/** required imports */
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.border.Border;
import mainpackage.Example;
import year2018.cs30s.tools.Numbers;

/**
 * SnakeUI.java - the classic snake game
 *
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public class SnakeUI extends JFrame
{
    
    private final int    FORM_WIDTH            = 1200;
    private final int    FORM_HEIGHT           = 800;
    private final int    FORM_WIDTH_ADJUST     = 50;
    private final int    FORM_HEIGHT_ADJUST    = 90;    
    private final String FORM_TITLE            = "Snake";
    private final Color  FORM_BACKGROUND_COLOR = Color.black;
    private final int    TIMER_DELAY           = 100;
    private final int    STOP                  = 0;
    private final int    LEFT                  = 1;
    private final int    RIGHT                 = 2;
    private final int    UP                    = 3;
    private final int    DOWN                  = 4;
    private final Color  SQUARE_COLOR          = FORM_BACKGROUND_COLOR;
    private final Color  SQUARE_BORDER_COLOR   = Color.darkGray;    
    private final Color  SNAKE_HEAD_COLOR      = Color.red;
    private final Color  SNAKE_BODY_COLOR      = Color.pink;    
    private final Color  POWER_UP_COLOR        = Color.blue;
    private final int    SQUARE_SIZE           = 30;
    private final Border SQUARE_BORDER         = 
                            BorderFactory.createLineBorder(SQUARE_BORDER_COLOR);    
    private final int    BLANK                 = -1;    
    private final int    HEAD                  = 0;
    
    private JLabel[][] grid;
    private Location[] snake;
    private Location   powerUp;
    private int        maxRows;
    private int        maxColumns;
    private Timer      timer;
    private int        length;
    
    /** 
     * Default constructor for the class 
     */
    public SnakeUI() {
        setFrame();        
        setKeyListener();
        setTimer();
        startGame();
        this.setVisible(true);
    }

    /**  
     * Sets the user interface properties of the frame 
     */
    private void setFrame() {
        this.getContentPane().setLayout(null);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                close();
            }
        });
        Example.frameTool.startup(this, FORM_TITLE, FORM_WIDTH, FORM_HEIGHT, 
                false, true, false, false, FORM_BACKGROUND_COLOR,
                Example.SNAKE_ICON);
    }

    /**
     * Closes this example and returns to the main application menu2018
     */
    private void close() {
        this.dispose();
        Example.gamesPlayed++;
        Example.menu2018();
    }
    
    /** 
     * Sets the keyboard to listen to events 
     */
    private void setKeyListener() {
        this.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent key)    { }
            public void keyPressed(KeyEvent key)  { 
                keyPress(key);
            }
            public void keyReleased(KeyEvent key) { }
        });
    }

    /** 
     * Sets the game timer 
     */
    private void setTimer() {
        timer = new Timer(TIMER_DELAY, new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                action();
            }
        });
    }

    /** 
     * Starts a new game 
     */
    private void startGame() {
        setGrid();
        setSnake();
        newPowerUp();
        timer.start();
    }
    
    /** 
     * Ends the current game 
     */
    private void gameOver() {
        timer.stop();
        if (JOptionPane.showConfirmDialog(this, 
                "Game Over!\nDo you want to play again?",
                FORM_TITLE,JOptionPane.YES_NO_OPTION) == 
                JOptionPane.YES_OPTION) {
            startGame();
        }
        else { 
            close();
        }
    }
        
    /** 
     * Sets the grid to play the game on 
     */
    private void setGrid() {
        maxRows    = (FORM_HEIGHT - FORM_HEIGHT_ADJUST) / SQUARE_SIZE;
        maxColumns = (FORM_WIDTH  - FORM_WIDTH_ADJUST)  / SQUARE_SIZE;        
        grid = new JLabel[maxRows][maxColumns];
        int y = (FORM_HEIGHT - (maxRows * SQUARE_SIZE)) / 2;
        for (int row = 0; row < maxRows; row++) {
            int x = (FORM_WIDTH - (maxColumns * SQUARE_SIZE)) / 2;
            for (int column = 0; column < maxColumns; column++) {
                createSquare(x,y,row,column);
                x += SQUARE_SIZE;
            }
            y += SQUARE_SIZE;
        }        
    }
    
    /**
     * Creates each individual square on the grid
     * 
     * @param x the x coordinate of the square
     * @param y the y coordinate of the square
     * @param row this squares row
     * @param column this squares column
     */
    private void createSquare(int x, int y, int row, int column) {
        grid[row][column] = new JLabel();
        grid[row][column].setOpaque(true);
        grid[row][column].setBackground(SQUARE_COLOR);
        grid[row][column].setBorder(SQUARE_BORDER);
        this.getContentPane().add(grid[row][column]);
        grid[row][column].setBounds(x,y,SQUARE_SIZE,SQUARE_SIZE);
    }
        
    /**
     * When a key is pressed, move the snake head's direction
     * 
     * @param event this keys event
     */
    private void keyPress(KeyEvent event) {
        if      (event.getKeyCode() == KeyEvent.VK_UP)    
                                        snake[HEAD].direction = UP;
        else if (event.getKeyCode() == KeyEvent.VK_DOWN)  
                                        snake[HEAD].direction = DOWN;
        else if (event.getKeyCode() == KeyEvent.VK_LEFT)  
                                        snake[HEAD].direction = LEFT;
        else if (event.getKeyCode() == KeyEvent.VK_RIGHT) 
                                        snake[HEAD].direction = RIGHT;
    }
        
    /** 
     * Sets up the snake at the start of the game 
     */
    private void setSnake() {
        length = 1;
        snake = new Location[maxRows*maxColumns];
        for (int i = 0; i < snake.length; i++) {
            snake[i] = new Location(BLANK,BLANK,STOP);
        }
        int startRow    = maxRows    / 2;
        int startColumn = maxColumns / 2;
        snake[HEAD]     = new Location(startRow,startColumn,STOP);
    }

    /** 
     * The timers action for each cycle 
     */
    private void action() {
        moveSnake();
        if (hasEatenPowerUp() == false) checkForCollisionWithSelf();
        if (hasHitBoundry()   == false) redraw();
    }
    
    /** 
     * Redraw the game grid for this time cycle 
     */
    private void redraw() {
        for (int row = 0; row < maxRows; row++) {
            for (int column = 0; column < maxColumns; column++) {
                grid[row][column].setBackground(SQUARE_COLOR);
            }
        }
        grid[snake[HEAD].row][snake[HEAD].column].setBackground(
                SNAKE_HEAD_COLOR);
        for (int i = 1; i < length; i++) {
            grid[snake[i].row][snake[i].column].setBackground(SNAKE_BODY_COLOR);
        }
        grid[powerUp.row][powerUp.column].setBackground(POWER_UP_COLOR);
    }
        
    /** 
     * Moves all the snake positions for this time cycle 
     */
    private void moveSnake() {        
        for (int i = length; i > 0; i--) {
            snake[i].row       = snake[i-1].row;
            snake[i].column    = snake[i-1].column;   
            snake[i].direction = snake[i-1].direction;               
        }
        if      (snake[HEAD].direction == UP)    snake[HEAD].row--;
        else if (snake[HEAD].direction == DOWN)  snake[HEAD].row++;
        else if (snake[HEAD].direction == LEFT)  snake[HEAD].column--;
        else if (snake[HEAD].direction == RIGHT) snake[HEAD].column++;
    }

    /**
     * Checks if the head of the snake has gone outside the boundry
     * 
     * @return has hit the boundry (true) or not (false)
     */
    private boolean hasHitBoundry() {
        if (snake[HEAD].row    < 0        || 
            snake[HEAD].row    >= maxRows ||
            snake[HEAD].column < 0        ||
            snake[HEAD].column >= maxColumns) {
            gameOver();
            return true;
        }
        return false;
    }
    
    /**
     * Checks if the head of the snake has eaten a power up
     * 
     * @return has eaten a power up (true) or not (false)
     */
    private boolean hasEatenPowerUp() {
        if (snake[HEAD].row    == powerUp.row && 
            snake[HEAD].column == powerUp.column) {            
            growSnake();
            newPowerUp();
            Example.totalPoints++;
            return true;
        }
        return false;
    }
    
    /** 
     * Adds a new segment to the snake body 
     */
    private void growSnake() {    
        length++;
        snake[length-1].row    = snake[length-2].row;
        snake[length-1].column = snake[length-2].column;
        if      (snake[length-2].direction == UP)    snake[length-1].row++;
        else if (snake[length-2].direction == DOWN)  snake[length-1].row--;
        else if (snake[length-2].direction == LEFT)  snake[length-1].column++;
        else if (snake[length-2].direction == RIGHT) snake[length-1].column--;               
    }
        
    /** 
     * Checks to see if the snake head s hitting the snake body 
     */
    private void checkForCollisionWithSelf() {
        if (isInSnake(snake[0].row,snake[0].column,true)) {
            gameOver();
        }
    }
    
    /** 
     * Generates a new power up in a random location 
     */
    private void newPowerUp() {
        int row    = 0;
        int column = 0;
        do {
            row    = Numbers.random(0,maxRows-1);
            column = Numbers.random(0,maxColumns-1);
        } while(isInSnake(row,column,false));
        powerUp = new Location(row,column,STOP);
        grid[powerUp.row][powerUp.column].setBackground(POWER_UP_COLOR);
    }
    
    /**
     * Determines is this location is touching any part of the snake
     * 
     * @param row the row to check
     * @param column the column to check
     * @param isHead do I check the head location or not
     * @return is hitting a part of the snake (true) or not (false)
     */
    private boolean isInSnake(int row, int column, boolean isHead) {
        int i = 0;
        if (isHead) i = 1;
        while (i < length) {
            if (snake[i].row    == row && 
                snake[i].column == column) 
                return true;
            i++;
        }
        return false;
    }   
        
}