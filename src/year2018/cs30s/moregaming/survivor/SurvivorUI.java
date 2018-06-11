
/** required package class namespace */
package year2018.cs30s.moregaming.survivor;

/** required imports */
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import mainpackage.Examples2018;
import mainpackage.MainClass;

/**
 * SurvivorUI.java - the user interface for the survivor game
 *
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public class SurvivorUI extends JFrame 
{
    
    private Engine engine;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel14;
    private JLabel jLabel15;
    private JLabel jLabel16;
    private JLabel jLabel17;
    private JLabel jLabel18;
    private JLabel jLabel19;
    private JLabel jLabel2;
    private JLabel jLabel20;
    private JLabel jLabel21;
    private JLabel jLabel22;
    private JLabel jLabel23;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel8;
    private JLabel jLabel9;
    
    /**
     * Default constructor for the class
     */
    public SurvivorUI() {
        initComponents();     
        JLabel[] walls  = {
            jLabel1,jLabel10,jLabel12,jLabel13,jLabel14,jLabel15,jLabel18,
            jLabel19,jLabel2,jLabel20,jLabel21,jLabel22,jLabel3,jLabel4,
            jLabel5,jLabel6,jLabel8,jLabel9
        };
        JLabel goal       = jLabel17;
        JLabel hero       = jLabel16;
        JLabel spawnPoint = jLabel23;                
        engine = new Engine(hero,goal,spawnPoint,walls,this);        
        MainClass.frameTool.startup(this, 
                Constants.SURVIVOR_UI_TITLE, 
                Constants.SURVIVOR_UI_WIDTH, 
                Constants.SURVIVOR_UI_HEIGHT, 
                false, 
                true,
                false,
                false,
                Constants.SURVIVOR_UI_BACK_COLOR,
                Examples2018.SPACE_INVADERS_ICON);
    }

    /**
     * Initializes all user interface components
     */
    private void initComponents() {     
        jLabel1 = new JLabel();                 // instantiate objects
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        jLabel8 = new JLabel();
        jLabel9 = new JLabel();
        jLabel10 = new JLabel();
        jLabel12 = new JLabel();
        jLabel13 = new JLabel();
        jLabel14 = new JLabel();
        jLabel15 = new JLabel();
        jLabel16 = new JLabel();
        jLabel17 = new JLabel();
        jLabel18 = new JLabel();
        jLabel19 = new JLabel();
        jLabel20 = new JLabel();
        jLabel21 = new JLabel();
        jLabel22 = new JLabel();
        jLabel23 = new JLabel();
        getContentPane().setLayout(null);       // set layout
        addWindowListener(new WindowAdapter() { // add listeners  
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        addKeyListener(new KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });        
        getContentPane().add(jLabel1);          // add components to containter
        getContentPane().add(jLabel2);
        getContentPane().add(jLabel3);
        getContentPane().add(jLabel4);
        getContentPane().add(jLabel5);
        getContentPane().add(jLabel6);        
        getContentPane().add(jLabel8);
        getContentPane().add(jLabel9);
        getContentPane().add(jLabel10);
        getContentPane().add(jLabel12);
        getContentPane().add(jLabel13);
        getContentPane().add(jLabel14);
        getContentPane().add(jLabel15);
        getContentPane().add(jLabel16);
        getContentPane().add(jLabel17);
        getContentPane().add(jLabel18);
        getContentPane().add(jLabel19);
        getContentPane().add(jLabel20);
        getContentPane().add(jLabel21);
        getContentPane().add(jLabel22);
        getContentPane().add(jLabel23);        
        // set component properties
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);        
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);                        
        jLabel1.setText("W");
        jLabel2.setText("W");
        jLabel3.setText("W");
        jLabel4.setText("W");
        jLabel5.setText("W");
        jLabel6.setText("W");        
        jLabel8.setText("W");
        jLabel9.setText("W");
        jLabel10.setText("W");
        jLabel12.setText("W");
        jLabel13.setText("W"); 
        jLabel14.setText("W"); 
        jLabel15.setText("W"); 
        jLabel16.setText("H"); 
        jLabel17.setText("G");
        jLabel18.setText("W");
        jLabel19.setText("W");
        jLabel20.setText("W");
        jLabel21.setText("W");
        jLabel22.setText("W");
        jLabel23.setText("S");        
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());        
        jLabel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel14.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel15.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel16.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel17.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel18.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel19.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel20.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel21.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel22.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel23.setBorder(javax.swing.BorderFactory.createEtchedBorder());        
        jLabel1.setBounds(410, 250, 220, 20);
        jLabel2.setBounds(10, 10, 20, 680);
        jLabel3.setBounds(760, 10, 20, 680);
        jLabel4.setBounds(30, 10, 730, 20);
        jLabel5.setBounds(30, 670, 730, 20);
        jLabel6.setBounds(140, 30, 20, 180);
        jLabel8.setBounds(530, 340, 20, 330);
        jLabel9.setBounds(110, 230, 20, 40);
        jLabel10.setBounds(270, 530, 260, 20);
        jLabel12.setBounds(630, 250, 20, 140);
        jLabel13.setBounds(530, 470, 160, 20);
        jLabel14.setBounds(650, 330, 110, 20);
        jLabel15.setBounds(110, 210, 180, 20);
        jLabel16.setBounds(570, 620, 40, 40);
        jLabel17.setBounds(60, 50, 40, 40);
        jLabel18.setBounds(270, 280, 60, 20);
        jLabel19.setBounds(270, 300, 20, 230);
        jLabel20.setBounds(30, 340, 70, 20);
        jLabel21.setBounds(410, 270, 20, 180);
        jLabel22.setBounds(360, 430, 60, 20);
        jLabel23.setBounds(50, 610, 40, 40);        
        // frame close operation
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    }
    
    /**
     * The Frame window closing event
     * 
     * @param evt the window event from the Frame
     */
    private void formWindowClosing(WindowEvent evt) {
        engine.shutDown();
    }
        
    /**
     * The key press user event 
     * 
     * @param evt the key event from the user
     */
    private void formKeyPressed(KeyEvent evt) {
        engine.keypress(evt);
    }
    
}
