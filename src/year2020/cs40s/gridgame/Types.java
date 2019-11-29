
package year2020.cs40s.gridgame;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.border.Border;


public class Types 
{

    public static int    GROUND        = 0;
    public static int    HERO          = 1;
    public static int    BOUNDRY       = 3;
    
    public static Color  HERO_IMAGE    = Color.BLUE;
    public static Color  GROUND_IMAGE  = Color.GREEN;
    public static Color  BOUNDRY_IMAGE = Color.RED;
    public static Color  BACKGROUND    = Color.BLACK;
    
    public static Border TILE_BORDER   = 
            BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1);
              
}
