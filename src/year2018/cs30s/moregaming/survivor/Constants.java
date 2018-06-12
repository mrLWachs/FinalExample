
/** required package class namespace */
package year2018.cs30s.moregaming.survivor;

/** required imports */
import java.awt.Color;
import mainpackage.MainClass;
import year2018.cs30s.gametools.Directions;

/**
 * Constants.java - game constant values for the Survivor game
 *
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public class Constants 
{

    public static final int    HERO_TIMER_DELAY             = 20;
    public static final int    HERO_MOVE_AMOUNT             = 3;
    public static final int    HERO_MOVE_DIRECTIONS         = 
                                                    Directions.FOUR_DIRECTIONS;
    public static final String HERO_IMAGE                   = 
                                            MainClass.MEDIA_PATH + "hero.png";
    public static final int    PROJECTILE_TIMER_DELAY       = 5;
    public static final int    PROJECTILE_MOVE_AMOUNT       = 
                                                        HERO_MOVE_AMOUNT + 2;
    public static final int    PROJECTILE_MOVE_DIRECTIONS   = 
                                                        HERO_MOVE_DIRECTIONS;
    public static final String PROJECTILE_IMAGE             = 
                                        MainClass.MEDIA_PATH + "projectile.png";
    public static final String PROJECTILE_SOUND_FILE        = 
                                        MainClass.MEDIA_PATH + "projectile.wav";
    public static final int    ENEMY_TRACKER_TIMER_DELAY    = 1000;
    public static final int    ENEMY_TIMER_DELAY            = HERO_TIMER_DELAY;
    public static final int    ENEMY_MOVE_AMOUNT            = 
                                                        HERO_MOVE_AMOUNT - 1;
    public static final int    ENEMY_MOVE_DIRECTIONS        = 
                                                        HERO_MOVE_DIRECTIONS;
    public static final String ENEMY_IMAGE                  = 
                                            MainClass.MEDIA_PATH + "enemy.png";
    public static final String ENEMY_DIE_SOUND_FILE         = 
                                        MainClass.MEDIA_PATH + "explode.wav";
    public static final String WALL_TEXT                    = "";
    public static final Color  WALL_COLOR                   = Color.darkGray; 
    public static final String GOAL_IMAGE                   = 
                                            MainClass.MEDIA_PATH + "goal.png";
    public static final String SPAWN_POINT_IMAGE            = 
                                        MainClass.MEDIA_PATH + "spawnPoint.png";
    public static final int    SPAWN_POINT_BUFFER           = 10;
    public static final String SPAWN_ENEMY_SOUND_FILE       = 
                                        MainClass.MEDIA_PATH + "spawn.wav";
    public static final int    SPAWN_TIMER_DELAY            = 3500;
    public static int          SPAWN_POINT_WIDTH            = 30;
    public static int          SPAWN_POINT_HEIGHT           = 30;
    public static int          SPAWN_LOW_X                  = 70;
    public static int          SPAWN_HIGH_X                 = 920;
    public static int          SPAWN_LOW_Y                  = 70;
    public static int          SPAWN_HIGH_Y                 = 490;
    public static final int    SURVIVOR_UI_WIDTH            = 1070;
    public static final int    SURVIVOR_UI_HEIGHT           = 630;
    public static final Color  SURVIVOR_UI_BACK_COLOR       = Color.lightGray;
    public static final String SURVIVOR_UI_TITLE            = "Survivor";
    public static final String SURVIVOR_UI_ICON             = 
                                        MainClass.MEDIA_PATH + "survivor.png";
    
}
