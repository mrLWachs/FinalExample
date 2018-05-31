
package year2018.cs30s.findprize;

import java.awt.event.KeyEvent;
import javax.swing.JLabel;

public class Engine 
{

    private JLabel[][] grid;
    private Location hero;
    private Location goal;  
    private Location[] prizes;
    private int totalPrizes;
    
    
    public Engine(JLabel[][] grid) {
        this.grid   = grid;  
        totalPrizes = 0;
        prizes      = new Location[ (grid.length * grid[0].length) - 2];
        hero        = new Location(grid,Globals.HERO_COLOR);
        goal        = new Location(grid,Globals.GOAL_COLOR); 
        prizes[0]   = new Location(grid,Globals.PRIZE_COLOR); 
        totalPrizes++;
    }
        
    public void keyPress(KeyEvent e) {
        grid[hero.row][hero.column].setBackground(Globals.GRID_COLOR);
        grid[hero.row][hero.column].setText(Globals.GRID_TEXT);
        if      (e.getKeyCode() == KeyEvent.VK_ESCAPE) next();
        else if (e.getKeyCode() == KeyEvent.VK_UP)     hero.row--;
        else if (e.getKeyCode() == KeyEvent.VK_DOWN)   hero.row++;
        else if (e.getKeyCode() == KeyEvent.VK_LEFT)   hero.column--;
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT)  hero.column++;
        checkEdges();
        checkPrizes();
        checkGoal(); 
        grid[hero.row][hero.column].setBackground(Globals.HERO_COLOR); 
        grid[hero.row][hero.column].setText(Globals.HERO_TEXT);
    }
        
    private void next() {
        Globals.main.setVisible(false);
        Globals.next.setVisible(true);
    }
    
    private void checkEdges() {        
        if      (hero.row < 0)                       hero.row = 0; 
        else if (hero.row >= Globals.gridRows)       hero.row = Globals.gridRows-1; 
        else if (hero.column < 0)                    hero.column = 0; 
        else if (hero.column >= Globals.gridColumns) hero.column = Globals.gridColumns-1;   
    }

    private void checkPrizes() {
        for (int i = 0; i < totalPrizes; i++) {
            Location prize = prizes[i];
            if (hero.row == prize.row && hero.column == prize.column) {                
                grid[hero.row][hero.column].setBackground(Globals.PRIZE_EATEN_COLOR);
                grid[hero.row][hero.column].setText(Globals.PRIZE_EATEN_TEXT);                
                prizes[totalPrizes] = new Location(grid,Globals.PRIZE_COLOR);
                totalPrizes++;
                return;
            }
            else {
                grid[prize.row][prize.column].setBackground(Globals.PRIZE_COLOR);
                grid[prize.row][prize.column].setText(Globals.PRIZE_TEXT + (i+1));   
            }
        }
    }

    private void checkGoal() {        
        if (hero.row == goal.row && hero.column == goal.column) {
            grid[hero.row][hero.column].setBackground(Globals.GRID_COLOR);
            grid[goal.row][goal.column].setBackground(Globals.GRID_COLOR);            
            grid[hero.row][hero.column].setText(Globals.GRID_TEXT);
            grid[goal.row][goal.column].setText(Globals.GRID_TEXT);
            next();
            hero = new Location(grid,Globals.HERO_COLOR);
            goal = new Location(grid,Globals.GOAL_COLOR);
        }        
    }   

}
