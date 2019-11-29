
package year2020.cs40s.gridgame;

import java.awt.event.KeyEvent;

public class Hero 
{

    public Location[][] locations;
    
    private int      row;
    private int      column;
    private Boundry  boundry;
    
    
    public Hero(Location[][] locations) {
        this.locations = locations;
        this.row       = locations.length    / 2;
        this.column    = locations[0].length / 2;
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
        int row    = this.row;
        int column = this.column;
        if      (event.getKeyCode() == KeyEvent.VK_ESCAPE) System.exit(0);
        else if (event.getKeyCode() == KeyEvent.VK_UP)     row--;
        else if (event.getKeyCode() == KeyEvent.VK_DOWN)   row++;
        else if (event.getKeyCode() == KeyEvent.VK_LEFT)   column--;
        else if (event.getKeyCode() == KeyEvent.VK_RIGHT)  column++;
        if (boundry.inside(row,column))                    move(row,column);        
    }

    public void redraw() {
        for (int row = 0; row < locations.length; row++) {
            for (int column = 0; column < locations[row].length; column++) {
                locations[row][column].draw();
            }
        }
    }
}
