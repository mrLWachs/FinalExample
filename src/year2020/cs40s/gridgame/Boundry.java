
package year2020.cs40s.gridgame;


public class Boundry 
{

    private int lowRow;
    private int highRow;
    private int lowColumn;
    private int highColumn;
    private Location[][] locations;
    
    private final int BOUNDRY_SPACE = 2;
    
   
    public Boundry(Location[][] locations) {
        this.locations = locations;
        lowRow         = BOUNDRY_SPACE;
        lowColumn      = BOUNDRY_SPACE;
        highRow        = locations.length    - (BOUNDRY_SPACE + 1);
        highColumn     = locations[0].length - (BOUNDRY_SPACE + 1);
        for (int row = 0; row < locations.length; row++) {
            for (int column = 0; column < locations[row].length; column++) {
                if (inside(row, column) == false) set(row,column,Types.BOUNDRY);
            }
        }
    }
    
    public boolean inside(int row, int column) {
        if (row    < lowRow)     return false;
        if (row    > highRow)    return false;
        if (column < lowColumn)  return false;
        if (column > highColumn) return false;
        return true;
    }

    private void set(int row, int column, int type) {
        locations[row][column].type = type;
    }

}
