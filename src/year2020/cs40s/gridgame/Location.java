
package year2020.cs40s.gridgame;


public class Location 
{

    public int row;
    public int column;
    public int type;
    public Tile tile;
    
    public Location(int row, int column, int x, int y, 
                    int tileWidth, int tileHeight, int type, Grid grid) {
        this.row    = row;
        this.column = column;   
        this.type   = type;
        this.tile   = new Tile(tileWidth, tileHeight, x, y, grid);
    }

    public void draw() {
        if      (type == Types.HERO)    tile.set(Types.HERO_IMAGE);
        else if (type == Types.BOUNDRY) tile.set(Types.BOUNDRY_IMAGE);
        else                            tile.set(Types.GROUND_IMAGE);
    }
    
}
