

/** required package class namespace */
package mainpackage;



/**
 * Constants.java - 
 *
 * @author Mr. Wachs 
 * @since 13-Nov-2018 
 */
public class MainConstants 
{

    public static final String MENU_PROMPT_1 = "You have run ";
    public static final String MENU_PROMPT_2 = " total apps, and earned ";
    public static final String MENU_PROMPT_3 = " total achievement points!\n\n";    
    public static final String MENU_PROMPT_4 = "Choose an example from ";    
    public static final String MENU_PROMPT_5 = "in Computer Science 30S "
            + "(or 32SIB) or 40S (or 42SIB)...";    
    public static final String MENU_PROMPT_6 = "Choose a Computer Science "
            + "30S example...";    
    public static final String MENU_PROMPT_7 = "Choose a Computer Science "
            + "40S example...";    
    public static final String MENU_PROMPT_8 = "Choose a year to see "
            + "examples from...";
    
    public  static final String   MEDIA_PATH      = "/media/";  
    public  static final String   APP_ICON        = MEDIA_PATH + "icon.png";
    public  static final String   SOUND           = MEDIA_PATH + "Ding.wav";   
    public  static final String   DATA_FILE       = MEDIA_PATH + "data.txt";
        
    public static final String[] YEAR_OPTIONS    = { "2021-2022",
                                                     "2020-2021",
                                                     "2019-2020",
                                                     "2018-2019",
                                                     "2017-2018",                                                     
                                                     "Past years",
                                                     "Exit" };    
    public static final String[]  EXAMPLE_OPTIONS = { "Computer Science 30S",
                                                      "Computer Science 40S",
                                                      "Choose year",
                                                      "Exit" };
    public static final String    APP_TITLE       = "Mr. Wachs Examples...";
}
