
/** required package class namespace */
package year2018.cs30s.moregaming.survivor;

import java.awt.Color;
import year2018.cs30s.gametools.Directions;

/**
 * Constants.java - description here...
 *
 * @author Mr. Wachs (login: lawrence.wachs)
 * @since Jun 7, 2018 
 * @instructor Mr. Wachs
 */
public class Constants 
{

    public static final int    HERO_TIMER_DELAY             = 100;
    public static final int    HERO_MOVE_AMOUNT             = 10;
    public static final int    HERO_MOVE_DIRECTIONS         = 
                                                    Directions.FOUR_DIRECTIONS;
    public static final String HERO_TEXT                    = "HERO";
    public static final Color  HERO_COLOR                   = Color.blue; 
    
    public static final int    PROJECTILE_TIMER_DELAY       = 10;
    public static final int    PROJECTILE_MOVE_AMOUNT       = 5;
    public static final int    PROJECTILE_MOVE_DIRECTIONS   = 
                                                    Directions.FOUR_DIRECTIONS;
    public static final String PROJECTILE_TEXT              = "";
    public static final Color  PROJECTILE_COLOR             = Color.black;  
        
    public static final int    ENEMY_TIMER_DELAY            = 100;
    public static final int    ENEMY_MOVE_AMOUNT            = 10;
    public static final int    ENEMY_MOVE_DIRECTIONS        = 
                                                    Directions.FOUR_DIRECTIONS;
    public static final String ENEMY_TEXT                   = "ENEMY";
    public static final Color  ENEMY_COLOR                  = Color.orange; 
    
    public static final String BACKGROUND_TEXT              = "";
    public static final Color  BACKGROUND_COLOR             = Color.gray; 
    
    public static final String WALL_TEXT                    = "";
    public static final Color  WALL_COLOR                   = Color.red; 
    
    public static final String GOAL_TEXT                    = "GOAL";
    public static final Color  GOAL_COLOR                   = Color.yellow; 
    
    public static final String SPAWN_POINT_TEXT             = "GOAL";
    public static final Color  SPAWN_POINT_COLOR            = Color.pink; 
    
    public static final int    SPAWN_TIMER_DELAY            = 2000;
    
    public static final int    SURVIVOR_UI_WIDTH            = 800;
    public static final int    SURVIVOR_UI_HEIGHT           = 730;
    public static final Color  SURVIVOR_UI_BACK_COLOR       = Color.white;
    public static final String SURVIVOR_UI_TITLE            = "Survivor";
    
}
