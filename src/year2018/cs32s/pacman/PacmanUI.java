
/** required package class namespace */
package year2018.cs32s.pacman;

/** required imports */
import year2018.cs32s.gametools.Image;
import java.awt.Color;

/**
 * PacmanUI.java - the user interface for the Pacman game
 *
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public class PacmanUI extends javax.swing.JFrame 
{
    
    private Engine engine;                              // game logic engine
    
    /**
     * Default constructor for the class
     */
    public PacmanUI() {
        initComponents();
        
        Image pacman = new Image(jLabel36,false,"PACMAN",Color.yellow);
        
        Image[] ghosts = new Image[2];
        ghosts[0] = new Image(jLabel1,false,"INKY",Color.pink);
        ghosts[1] = new Image(jLabel37,false,"BLINKY",Color.green);
        
        Image[] dots = new Image[20];
        dots[0] = new Image(jLabel17,false,"",Color.white);
        dots[1] = new Image(jLabel18,false,"",Color.white);
        dots[2] = new Image(jLabel19,false,"",Color.white);
        dots[3] = new Image(jLabel20,false,"",Color.white);
        dots[4] = new Image(jLabel21,false,"",Color.white);
        dots[5] = new Image(jLabel22,false,"",Color.white);
        dots[6] = new Image(jLabel23,false,"",Color.white);
        dots[7] = new Image(jLabel24,false,"",Color.white);
        dots[8] = new Image(jLabel25,false,"",Color.white);
        dots[9] = new Image(jLabel26,false,"",Color.white);
        dots[10] = new Image(jLabel27,false,"",Color.white);
        dots[11] = new Image(jLabel28,false,"",Color.white);
        dots[12] = new Image(jLabel29,false,"",Color.white);
        dots[13] = new Image(jLabel30,false,"",Color.white);
        dots[14] = new Image(jLabel31,false,"",Color.white);
        dots[15] = new Image(jLabel32,false,"",Color.white);
        dots[16] = new Image(jLabel33,false,"",Color.white);
        dots[17] = new Image(jLabel34,false,"",Color.white);
        dots[18] = new Image(jLabel35,false,"",Color.white);
        dots[19] = new Image(jLabel8,false,"",Color.white);
        
        Image[] walls = new Image[14];
        walls[0]  = new Image(jLabel2,false,"",Color.blue);
        walls[1]  = new Image(jLabel3,false,"",Color.blue);
        walls[2]  = new Image(jLabel4,false,"",Color.blue);
        walls[3]  = new Image(jLabel5,false,"",Color.blue);
        walls[4]  = new Image(jLabel6,false,"",Color.blue);
        walls[5]  = new Image(jLabel7,false,"",Color.blue);
        walls[6]  = new Image(jLabel9,false,"",Color.blue);
        walls[7]  = new Image(jLabel10,false,"",Color.blue);
        walls[8]  = new Image(jLabel11,false,"",Color.blue);
        walls[9]  = new Image(jLabel12,false,"",Color.blue);
        walls[10]  = new Image(jLabel13,false,"",Color.blue);
        walls[11]  = new Image(jLabel14,false,"",Color.blue);
        walls[12]  = new Image(jLabel15,false,"",Color.blue);
        walls[13]  = new Image(jLabel16,false,"",Color.blue);
                
        engine = new Engine(pacman,ghosts,dots,walls,this);
        
        setBackground(Color.black);
        getContentPane().setBackground(Color.black);
        setSize(900, 700);
        setVisible(true);
        
    }

    /** 
     * NETBEANS EDITOR GENERATED CODE:
     * 
     * This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel1.setBackground(new java.awt.Color(255, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ghost");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(440, 70, 76, 73);

        jLabel2.setBackground(new java.awt.Color(51, 51, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Wall");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel2.setOpaque(true);
        getContentPane().add(jLabel2);
        jLabel2.setBounds(60, 450, 150, 40);

        jLabel3.setBackground(new java.awt.Color(51, 51, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Wall");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel3.setOpaque(true);
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 11, 49, 642);

        jLabel4.setBackground(new java.awt.Color(51, 51, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Wall");
        jLabel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel4.setOpaque(true);
        getContentPane().add(jLabel4);
        jLabel4.setBounds(810, 10, 49, 642);

        jLabel5.setBackground(new java.awt.Color(51, 51, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Wall");
        jLabel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel5.setOpaque(true);
        getContentPane().add(jLabel5);
        jLabel5.setBounds(50, 10, 770, 40);

        jLabel6.setBackground(new java.awt.Color(51, 51, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Wall");
        jLabel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel6.setOpaque(true);
        getContentPane().add(jLabel6);
        jLabel6.setBounds(50, 610, 770, 40);

        jLabel7.setBackground(new java.awt.Color(51, 51, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Wall");
        jLabel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel7.setOpaque(true);
        getContentPane().add(jLabel7);
        jLabel7.setBounds(360, 40, 50, 200);

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Dot");
        jLabel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel8.setOpaque(true);
        getContentPane().add(jLabel8);
        jLabel8.setBounds(750, 70, 30, 30);

        jLabel9.setBackground(new java.awt.Color(51, 51, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Wall");
        jLabel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel9.setOpaque(true);
        getContentPane().add(jLabel9);
        jLabel9.setBounds(260, 240, 150, 40);

        jLabel10.setBackground(new java.awt.Color(51, 51, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Wall");
        jLabel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel10.setOpaque(true);
        getContentPane().add(jLabel10);
        jLabel10.setBounds(410, 160, 150, 40);

        jLabel11.setBackground(new java.awt.Color(51, 51, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Wall");
        jLabel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel11.setOpaque(true);
        getContentPane().add(jLabel11);
        jLabel11.setBounds(540, 160, 50, 160);

        jLabel12.setBackground(new java.awt.Color(51, 51, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Wall");
        jLabel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel12.setOpaque(true);
        getContentPane().add(jLabel12);
        jLabel12.setBounds(730, 250, 90, 40);

        jLabel13.setBackground(new java.awt.Color(51, 51, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Wall");
        jLabel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel13.setOpaque(true);
        getContentPane().add(jLabel13);
        jLabel13.setBounds(530, 470, 50, 160);

        jLabel14.setBackground(new java.awt.Color(51, 51, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Wall");
        jLabel14.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel14.setOpaque(true);
        getContentPane().add(jLabel14);
        jLabel14.setBounds(530, 430, 150, 40);

        jLabel15.setBackground(new java.awt.Color(51, 51, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Wall");
        jLabel15.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel15.setOpaque(true);
        getContentPane().add(jLabel15);
        jLabel15.setBounds(210, 240, 50, 90);

        jLabel16.setBackground(new java.awt.Color(51, 51, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Wall");
        jLabel16.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel16.setOpaque(true);
        getContentPane().add(jLabel16);
        jLabel16.setBounds(320, 530, 50, 90);

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Dot");
        jLabel17.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel17.setOpaque(true);
        getContentPane().add(jLabel17);
        jLabel17.setBounds(90, 80, 30, 30);

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Dot");
        jLabel18.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel18.setOpaque(true);
        getContentPane().add(jLabel18);
        jLabel18.setBounds(90, 170, 30, 30);

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Dot");
        jLabel19.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel19.setOpaque(true);
        getContentPane().add(jLabel19);
        jLabel19.setBounds(90, 260, 30, 30);

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Dot");
        jLabel20.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel20.setOpaque(true);
        getContentPane().add(jLabel20);
        jLabel20.setBounds(90, 350, 30, 30);

        jLabel21.setBackground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Dot");
        jLabel21.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel21.setOpaque(true);
        getContentPane().add(jLabel21);
        jLabel21.setBounds(100, 520, 30, 30);

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Dot");
        jLabel22.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel22.setOpaque(true);
        getContentPane().add(jLabel22);
        jLabel22.setBounds(170, 560, 30, 30);

        jLabel23.setBackground(new java.awt.Color(255, 255, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Dot");
        jLabel23.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel23.setOpaque(true);
        getContentPane().add(jLabel23);
        jLabel23.setBounds(290, 430, 30, 30);

        jLabel24.setBackground(new java.awt.Color(255, 255, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Dot");
        jLabel24.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel24.setOpaque(true);
        getContentPane().add(jLabel24);
        jLabel24.setBounds(290, 310, 30, 30);

        jLabel25.setBackground(new java.awt.Color(255, 255, 255));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Dot");
        jLabel25.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel25.setOpaque(true);
        getContentPane().add(jLabel25);
        jLabel25.setBounds(460, 230, 30, 30);

        jLabel26.setBackground(new java.awt.Color(255, 255, 255));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Dot");
        jLabel26.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel26.setOpaque(true);
        getContentPane().add(jLabel26);
        jLabel26.setBounds(400, 310, 30, 30);

        jLabel27.setBackground(new java.awt.Color(255, 255, 255));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Dot");
        jLabel27.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel27.setOpaque(true);
        getContentPane().add(jLabel27);
        jLabel27.setBounds(410, 430, 30, 30);

        jLabel28.setBackground(new java.awt.Color(255, 255, 255));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Dot");
        jLabel28.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel28.setOpaque(true);
        getContentPane().add(jLabel28);
        jLabel28.setBounds(540, 360, 30, 30);

        jLabel29.setBackground(new java.awt.Color(255, 255, 255));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("Dot");
        jLabel29.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel29.setOpaque(true);
        getContentPane().add(jLabel29);
        jLabel29.setBounds(640, 260, 30, 30);

        jLabel30.setBackground(new java.awt.Color(255, 255, 255));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Dot");
        jLabel30.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel30.setOpaque(true);
        getContentPane().add(jLabel30);
        jLabel30.setBounds(710, 360, 30, 30);

        jLabel31.setBackground(new java.awt.Color(255, 255, 255));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("Dot");
        jLabel31.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel31.setOpaque(true);
        getContentPane().add(jLabel31);
        jLabel31.setBounds(730, 430, 30, 30);

        jLabel32.setBackground(new java.awt.Color(255, 255, 255));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("Dot");
        jLabel32.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel32.setOpaque(true);
        getContentPane().add(jLabel32);
        jLabel32.setBounds(730, 530, 30, 30);

        jLabel33.setBackground(new java.awt.Color(255, 255, 255));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("Dot");
        jLabel33.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel33.setOpaque(true);
        getContentPane().add(jLabel33);
        jLabel33.setBounds(640, 160, 30, 30);

        jLabel34.setBackground(new java.awt.Color(255, 255, 255));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("Dot");
        jLabel34.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel34.setOpaque(true);
        getContentPane().add(jLabel34);
        jLabel34.setBounds(750, 170, 30, 30);

        jLabel35.setBackground(new java.awt.Color(255, 255, 255));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("Dot");
        jLabel35.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel35.setOpaque(true);
        getContentPane().add(jLabel35);
        jLabel35.setBounds(640, 80, 30, 30);

        jLabel36.setBackground(new java.awt.Color(255, 255, 0));
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("Pacman");
        jLabel36.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel36.setOpaque(true);
        getContentPane().add(jLabel36);
        jLabel36.setBounds(230, 100, 76, 73);

        jLabel37.setBackground(new java.awt.Color(0, 255, 51));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("Ghost");
        jLabel37.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel37.setOpaque(true);
        getContentPane().add(jLabel37);
        jLabel37.setBounds(410, 500, 76, 73);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        engine.keyPress(evt);
    }//GEN-LAST:event_formKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables

}
