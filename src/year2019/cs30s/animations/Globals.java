

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
    public static String BACKGROUND_TEXT  = "Background";
    public static Color  BACKGROUND_COLOR = new Color(17,17,15);// new Color(17,12,4) ; //Color.BLACK;
    public static String WALL_TEXT        = "Wall";
    public static Color  WALL_COLOR       = Color.BLUE;
    public static String OBJECTIVE_TEXT   = "Objective";
    public static Color  OBJECTIVE_COLOR  = Color.GREEN;
    public static String PRIZE_TEXT       = "Prize";
    public static Color  PRIZE_COLOR      = Color.ORANGE;
    
    
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
    
    public static String MEDIA_PATH       = "/year2019/cs30s/animations/media/";
    
    public static String DATA_FILE        = MEDIA_PATH + "animationData.txt";
    
    public static String[] PACMAN_RIGHT_IMAGES  = {
        MEDIA_PATH + "right01.png",
        MEDIA_PATH + "right02.png",
        MEDIA_PATH + "right03.png",
        MEDIA_PATH + "right04.png",
        MEDIA_PATH + "right05.png",
        MEDIA_PATH + "right06.png",
        MEDIA_PATH + "right07.png",
        MEDIA_PATH + "right08.png",
        MEDIA_PATH + "right09.png",
        MEDIA_PATH + "right10.png",
        MEDIA_PATH + "right11.png"
    };
    
    public static String[] PACMAN_DOWN_IMAGES  = {
        MEDIA_PATH + "down01.png",
        MEDIA_PATH + "down02.png",
        MEDIA_PATH + "down03.png",
        MEDIA_PATH + "down04.png",
        MEDIA_PATH + "down05.png",
        MEDIA_PATH + "down06.png",
        MEDIA_PATH + "down07.png",
        MEDIA_PATH + "down08.png",
        MEDIA_PATH + "down09.png",
        MEDIA_PATH + "down10.png",
        MEDIA_PATH + "down11.png"
    };
    
    public static String[] PACMAN_LEFT_IMAGES  = {
        MEDIA_PATH + "left01.png",
        MEDIA_PATH + "left02.png",
        MEDIA_PATH + "left03.png",
        MEDIA_PATH + "left04.png",
        MEDIA_PATH + "left05.png",
        MEDIA_PATH + "left06.png",
        MEDIA_PATH + "left07.png",
        MEDIA_PATH + "left08.png",
        MEDIA_PATH + "left09.png",
        MEDIA_PATH + "left10.png",
        MEDIA_PATH + "left11.png"
    };
    
    public static String[] PACMAN_UP_IMAGES  = {
        MEDIA_PATH + "up01.png",
        MEDIA_PATH + "up02.png",
        MEDIA_PATH + "up03.png",
        MEDIA_PATH + "up04.png",
        MEDIA_PATH + "up05.png",
        MEDIA_PATH + "up06.png",
        MEDIA_PATH + "up07.png",
        MEDIA_PATH + "up08.png",
        MEDIA_PATH + "up09.png",
        MEDIA_PATH + "up10.png",
        MEDIA_PATH + "up11.png"
    };
    
    public static String[] PACMAN_IDOLE_IMAGES  = {
        MEDIA_PATH + "idle01.png",
        MEDIA_PATH + "idle02.png"
    };
    
    public static String PACMAN_SOUND = MEDIA_PATH + "pacman_chomp.wav";
    
}
