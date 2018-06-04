
/** required package class namespace */
package year2018.cs30s.moregaming.frogger;

/** required imports */
import mainpackage.Example;
import year2018.cs30s.gametools.Image;
import year2018.cs30s.tools.FrameTools;

/**
 * FroggerGUI.java - the user interface for the Frogger game
 *
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public class FroggerGUI extends javax.swing.JFrame 
{

    private Engine engine;
    
    /** 
     * Constructor for the class sets class data, and creates new form
     */
    public FroggerGUI() {
        initComponents();
        Image   backgroundImage = new Image(jLabel18);        
        Image   frogImage       = new Image(jLabel14);
        Image   waterImage      = new Image(jLabel23);
        Image   homeImage       = new Image(jLabel22);
        Image[] carImages       = { 
            new Image(jLabel15),
            new Image(jLabel16)
        };
        Image[] logImages       = {
             new Image(jLabel17),
             new Image(jLabel24)
        };
        Image[] wallImages      = {
            new Image(jLabel13),
            new Image(jLabel19),
            new Image(jLabel20),
            new Image(jLabel21)
        };        
        engine = new Engine(
                backgroundImage,
                frogImage,
                waterImage,
                homeImage,
                carImages,
                logImages,
                wallImages);
        Example.frameTool.init(this, 
                Constants.FROGGER_UI_TITLE, 
                Constants.FROGGER_UI_WIDTH, 
                Constants.FROGGER_UI_HEIGHT, 
                false, true, false, false,
                Constants.FROGGER_UI_BACK_COLOR,
                Example.FROGGER_ICON);
    }

    // <editor-fold defaultstate="collapsed" desc="NetBeans Visual Editor Generated Code">  
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("wall");
        jLabel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel13);
        jLabel13.setBounds(30, 660, 860, 30);

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("frog");
        jLabel14.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel14);
        jLabel14.setBounds(430, 590, 80, 60);

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("car");
        jLabel15.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel15);
        jLabel15.setBounds(630, 460, 240, 110);

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("car");
        jLabel16.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel16);
        jLabel16.setBounds(50, 150, 240, 110);

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("log");
        jLabel17.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel17);
        jLabel17.setBounds(540, 280, 340, 90);

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("wall");
        jLabel19.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel19);
        jLabel19.setBounds(0, 0, 30, 690);

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("wall");
        jLabel20.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel20);
        jLabel20.setBounds(890, 0, 30, 690);

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("wall");
        jLabel21.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel21);
        jLabel21.setBounds(30, 0, 860, 30);

        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("home");
        jLabel22.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel22);
        jLabel22.setBounds(30, 30, 860, 80);

        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("log");
        jLabel24.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel24);
        jLabel24.setBounds(40, 360, 340, 90);

        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("water");
        jLabel23.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel23);
        jLabel23.setBounds(30, 290, 860, 150);

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("background");
        jLabel18.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel18);
        jLabel18.setBounds(0, 0, 920, 700);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    // </editor-fold> 
    
    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        engine.keyPress(evt);
    }//GEN-LAST:event_formKeyPressed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        engine.keyRelease();
    }//GEN-LAST:event_formKeyReleased

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.dispose();
        Example.gamesPlayed++;
        Example.menu();
    }//GEN-LAST:event_formWindowClosing

    // <editor-fold defaultstate="collapsed" desc="NetBeans Visual Editor Generated Code">  
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    // End of variables declaration//GEN-END:variables

    // </editor-fold> 
    
}
