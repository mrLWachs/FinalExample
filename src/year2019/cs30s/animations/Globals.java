

/** required package class namespace */
package year2019.cs30s.animations;

import java.awt.Color;
import year2019.cs30s.animations.gametools.Directions;



/**
 * Globals.java - 
 *
 * @author Mr. Wachs 
 * @since 15-May-2019 
 */
public class Globals 
{

    public static int    UI_WIDTH         = 1013;
    public static int    UI_HEIGHT        = 688;
    public static String UI_TITLE         = "Gaming Demo..."; 
    public static String BACKGROUND_TEXT  = "";
    public static Color  BACKGROUND_COLOR = Color.WHITE;
    public static String WALL_TEXT        = "Wall";
    public static Color  WALL_COLOR       = Color.BLUE;
    public static String OBJECTIVE_TEXT   = "Objective";
    public static Color  OBJECTIVE_COLOR  = Color.GREEN;
    
    public static String ENEMY_TEXT       = "Enemy";
    public static Color  ENEMY_COLOR      = Color.RED;
    public static int    ENEMY_AMOUNT     = 1;
    public static int    ENEMY_DIRECTION  = Directions.STOP;
    public static int    ENEMY_DELAY      = 10;
    public static int    ENEMY_DIRECTIONS = Directions.FOUR_DIRECTIONS;
    
    public static String HERO_TEXT        = "Hero";
    public static Color  HERO_COLOR       = Color.BLACK;
    public static int    HERO_AMOUNT      = 1;
    public static int    HERO_DIRECTION   = Directions.STOP;
    public static int    HERO_DELAY       = 10;
    public static int    HERO_DIRECTIONS  = Directions.FOUR_DIRECTIONS;
    
    
    
    
}
