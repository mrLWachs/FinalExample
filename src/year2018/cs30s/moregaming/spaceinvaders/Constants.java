
/** required package class namespace */
package year2018.cs30s.moregaming.spaceinvaders;

/** required imports */
import java.awt.Color;
import mainpackage.MainClass;
import year2018.cs30s.gametools.Directions;

/**
 * Constants.java - game constant values for the Space Invaders game
 *
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public class Constants 
{

    public static final int    HERO_TIMER_DELAY             = 100;
    public static final int    HERO_MOVE_AMOUNT             = 10;
    public static final int    HERO_MOVE_DIRECTIONS         = 
                                                    Directions.TWO_DIRECTIONS;
    public static final String HERO_TEXT                    = "HERO";
    public static final Color  HERO_COLOR                   = Color.yellow; 
    public static final int    HERO_BULLET_TIMER_DELAY      = 10;
    public static final int    HERO_BULLET_MOVE_AMOUNT      = 5;
    public static final int    HERO_BULLET_MOVE_DIRECTIONS  = 
                                                    Directions.FOUR_DIRECTIONS;
    public static final String HERO_BULLET_TEXT             = "";
    public static final Color  HERO_BULLET_COLOR            = Color.white;  
    public static final int    ENEMY_TIMER_DELAY            = 100;
    public static final int    ENEMY_MOVE_AMOUNT            = 20;
    public static final int    ENEMY_MOVE_DIRECTIONS        = 
                                                    Directions.TWO_DIRECTIONS;
    
    public static final String ENEMY_TEXT                   = "ENEMY";
    public static final Color  ENEMY_COLOR                  = Color.white;  
    public static final int    ENEMY_BULLET_TIMER_DELAY     = 10;
    public static final int    ENEMY_BULLET_MOVE_AMOUNT     = 5;
    public static final int    ENEMY_BULLET_MOVE_DIRECTIONS = 
                                                    Directions.FOUR_DIRECTIONS;
    public static final String ENEMY_BULLET_TEXT            = "";
    public static final Color  ENEMY_BULLET_COLOR           = Color.pink;  
    public static final String BACKGROUND_TEXT              = "";
    public static final Color  BACKGROUND_COLOR             = Color.black; 
    public static final String WALL_TEXT                    = "";
    public static final Color  WALL_COLOR                   = Color.gray; 
    public static final String BASE_TEXT                    = "BASE";
    public static final Color  BASE_COLOR                   = Color.blue; 
    public static final int    ENEMY_SHOOT_TIMER_DELAY      = 3000;
    public static final int    SPACE_INVADERS_UI_WIDTH      = 935;
    public static final int    SPACE_INVADERS_UI_HEIGHT     = 720;
    public static final Color  SPACE_INVADERS_UI_BACK_COLOR = Color.black;
    public static final String SPACE_INVADERS_UI_TITLE      = "Space Invaders";
    public static final String SPACE_INVADERS_UI_ICON       = MainClass.MEDIA_PATH + 
                                                              "SpaceInvaders.png";

}
