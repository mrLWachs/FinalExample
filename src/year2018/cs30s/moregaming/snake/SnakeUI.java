
/** required package */
package year2018.cs30s.moregaming.snake;

/** required imports */
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.border.Border;
import year2018.cs30s.moregaming.frogger.Constants;
import year2018.cs30s.tools.FrameTools;

/**
 * SnakeUI.java - the classic snake game
 * @author Mr. Wachs' Computer Science Student (login: lwachs)
 * @since 03-June-2015
 * @version 1.0
 * @instructor Mr. Wachs
 */
public class SnakeUI extends JFrame
{
    
    // game constants
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
    private final Border SQUARE_BORDER         = BorderFactory.createLineBorder(SQUARE_BORDER_COLOR);    
    private final int    BLANK                 = -1;    
    private final int    HEAD                  = 0;
    
    // game properties
    private JLabel[][] grid;
    private Location[] snake;
    private Location   powerUp;
    private int        maxRows;
    private int        maxColumns;
    private Timer      timer;
    private int        length;
    
    /** default constructor for the class */
    public SnakeUI() {
        setFrame();        
        setKeyListener();
        setTimer();
        startGame();
        this.setVisible(true);
    }

    /**  sets the gUI properties of the frame */
    private void setFrame() {
        this.getContentPane().setLayout(null);
        FrameTools.init(this, 
                FORM_TITLE, 
                FORM_WIDTH, 
                FORM_HEIGHT, 
                false, 
                true,
                true,
                false,
                FORM_BACKGROUND_COLOR);
    }

    /** sets the keyboard to listen to events */
    private void setKeyListener() {
        this.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent key)    { }
            public void keyPressed(KeyEvent key)  { 
                keyPress(key);
            }
            public void keyReleased(KeyEvent key) { }
        });
    }

    /** sets the game timer */
    private void setTimer() {
        timer = new Timer(TIMER_DELAY, new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                action();
            }
        });
    }

    /** starts a new game */
    private void startGame() {
        setGrid();
        setSnake();
        newPowerUp();
        timer.start();
    }
    
    /** ends the current game */
    private void gameOver() {
        timer.stop();
        if (JOptionPane.showConfirmDialog(this, 
                "Game Over!\nDo you want to play again?",
                FORM_TITLE,JOptionPane.YES_NO_OPTION) == 
                JOptionPane.YES_OPTION) {
            startGame();
        }
        else { 
            System.exit(0);
        }
    }
        
    /** sets the grid to play the game on */
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
     * creates each individual square on the grid
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
     * when a key is pressed, move the snake head's direction
     * @param event this keys event
     */
    private void keyPress(KeyEvent event) {
        if      (event.getKeyCode() == KeyEvent.VK_UP)    snake[HEAD].direction = UP;
        else if (event.getKeyCode() == KeyEvent.VK_DOWN)  snake[HEAD].direction = DOWN;
        else if (event.getKeyCode() == KeyEvent.VK_LEFT)  snake[HEAD].direction = LEFT;
        else if (event.getKeyCode() == KeyEvent.VK_RIGHT) snake[HEAD].direction = RIGHT;
    }
        
    /** sets up the snake at the start of the game */
    private void setSnake() {
        length = 1;
        snake = new Location[maxRows*maxColumns];
        for (int i = 0; i < snake.length; i++) {
            snake[i] = new Location(BLANK,BLANK,STOP);
        }
        int startRow    = maxRows    / 2;
        int startColumn = maxColumns / 2;
        snake[HEAD] = new Location(startRow,startColumn,STOP);
    }

    /** the timers action for each cycle */
    private void action() {
        moveSnake();
        if (hasEatenPowerUp() == false) checkForCollisionWithSelf();
        if (hasHitBoundry()   == false) redraw();
    }
    
    /** redraw the game grid for this time cycle */
    private void redraw() {
        for (int row = 0; row < maxRows; row++) {
            for (int column = 0; column < maxColumns; column++) {
                grid[row][column].setBackground(SQUARE_COLOR);
            }
        }
        grid[snake[HEAD].row][snake[HEAD].column].setBackground(SNAKE_HEAD_COLOR);
        for (int i = 1; i < length; i++) {
            grid[snake[i].row][snake[i].column].setBackground(SNAKE_BODY_COLOR);
        }
        grid[powerUp.row][powerUp.column].setBackground(POWER_UP_COLOR);
    }
        
    /** moves all the snake positions for this time cycle */
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
     * checks if the head of the snake has gone outside the boundry
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
     * checks if the head of the snake has eaten a power up
     * @return has eaten a power up (true) or not (false)
     */
    private boolean hasEatenPowerUp() {
        if (snake[HEAD].row    == powerUp.row && 
            snake[HEAD].column == powerUp.column) {            
            growSnake();
            newPowerUp();
            return true;
        }
        return false;
    }
    
    /** adds a new segment to the snake body */
    private void growSnake() {    
        length++;
        snake[length-1].row    = snake[length-2].row;
        snake[length-1].column = snake[length-2].column;
        if      (snake[length-2].direction == UP)    snake[length-1].row++;
        else if (snake[length-2].direction == DOWN)  snake[length-1].row--;
        else if (snake[length-2].direction == LEFT)  snake[length-1].column++;
        else if (snake[length-2].direction == RIGHT) snake[length-1].column--;               
    }
        
    /** checks to see if the snake head s hitting the snake body */
    private void checkForCollisionWithSelf() {
        if (isInSnake(snake[0].row,snake[0].column,true)) {
            gameOver();
        }
    }
    
    /** generates a new power up in a random location */
    private void newPowerUp() {
        int row    = 0;
        int column = 0;
        do {
            row    = randomInteger(0,maxRows-1);
            column = randomInteger(0,maxColumns-1);
        } while(isInSnake(row,column,false));
        powerUp = new Location(row,column,STOP);
        grid[powerUp.row][powerUp.column].setBackground(POWER_UP_COLOR);
    }
    
    /**
     * determines is this location is touching any part of the snake
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
    
    /**
     * generates a random integer in the range
     * @param low the lowest random integer to generate
     * @param high the highest random integer to generate
     * @return a random integer inside the range
     */
    private int randomInteger(int low, int high) {
        double L      = (double)low;
        double H      = (double)high;
        double seed   = Math.random();
        double random = (H - L + 1d) * seed + L;
        return (int)random;
    }    
    
}
    
    
    
  