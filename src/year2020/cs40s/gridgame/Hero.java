
package year2020.cs40s.gridgame;

import java.awt.event.KeyEvent;

public class Hero 
{

    public Location[][] locations;
    
    private int      row;
    private int      column;
    private Boundry  boundry;
    private Grid     grid;
    
    
    public Hero(Location[][] locations, Grid grid) {
        this.locations = locations;
        this.row       = locations.length    / 2;
        this.column    = locations[0].length / 2;
        this.grid      = grid;
        boundry = new Boundry(locations);
        this.locations[row][column].type = Types.HERO;
        redraw();
    }
    
    public void move(int row, int column) {
        locations[this.row][this.column].type = Types.GROUND;
        this.row    = row;
        this.column = column;
        locations[row][column].type = Types.HERO;
        redraw();
    }

    public void keyPress(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.VK_ESCAPE) System.exit(0);
        int row    = this.row;
        int column = this.column;
        if (event.getKeyCode() == KeyEvent.VK_UP) {
            row--;
            grid.setTitle("Moving up...");
        }
        else if (event.getKeyCode() == KeyEvent.VK_DOWN) {
            row++;
            grid.setTitle("Moving down...");
        }
        else if (event.getKeyCode() == KeyEvent.VK_LEFT) {
            column--;
            grid.setTitle("Moving left...");
        }
        else if (event.getKeyCode() == KeyEvent.VK_RIGHT) {
            column++;
            grid.setTitle("Moving right...");
        }
        if (boundry.inside(row,column)) move(row,column);        
    }

    public void redraw() {
        for (int row = 0; row < locations.length; row++) {
            for (int column = 0; column < locations[row].length; column++) {
                locations[row][column].draw();
            }
        }
    }
}
