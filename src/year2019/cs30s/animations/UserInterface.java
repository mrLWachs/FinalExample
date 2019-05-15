/*
 *  Mr. Wachs' classes - Java Computer Science learning file UserInterface.java
 *  for project FinalExamples on 15-May-2019 at 12:15:28 PM by lawrence.wachs
 */


/** required package class namespace */
package year2019.cs30s.animations;

import javax.swing.JLabel;


/**
 * UserInterface.java - 
 *
 * @author Mr. Wachs 
 * @since 15-May-2019 
 */
public class UserInterface extends javax.swing.JFrame 
{

    private Engine engine;
    
    /** Creates new form UserInterface */
    public UserInterface() {
        initComponents();
        JLabel[] walls = {
            wall01Label,wall02Label,wall03Label,wall04Label,wall05Label,
            wall06Label,wall07Label,wall08Label,wall09Label,wall10Label
        };
        JLabel[] enemies = {
            enemy1Label,enemy2Label
        };
        engine = new Engine(heroLabel,objectiveLabel,walls,enemies,
                backgroundLabel,this);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        heroLabel = new javax.swing.JLabel();
        enemy1Label = new javax.swing.JLabel();
        enemy2Label = new javax.swing.JLabel();
        objectiveLabel = new javax.swing.JLabel();
        wall01Label = new javax.swing.JLabel();
        wall02Label = new javax.swing.JLabel();
        wall03Label = new javax.swing.JLabel();
        wall04Label = new javax.swing.JLabel();
        wall05Label = new javax.swing.JLabel();
        wall06Label = new javax.swing.JLabel();
        wall07Label = new javax.swing.JLabel();
        wall08Label = new javax.swing.JLabel();
        wall09Label = new javax.swing.JLabel();
        wall10Label = new javax.swing.JLabel();
        backgroundLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        getContentPane().setLayout(null);

        heroLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        heroLabel.setText("HERO");
        heroLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(heroLabel);
        heroLabel.setBounds(860, 60, 60, 60);

        enemy1Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        enemy1Label.setText("ENEMY");
        enemy1Label.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(enemy1Label);
        enemy1Label.setBounds(80, 80, 110, 100);

        enemy2Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        enemy2Label.setText("ENEMY");
        enemy2Label.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(enemy2Label);
        enemy2Label.setBounds(820, 490, 110, 100);

        objectiveLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        objectiveLabel.setText("OBJECTIVE");
        objectiveLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(objectiveLabel);
        objectiveLabel.setBounds(70, 530, 80, 70);

        wall01Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        wall01Label.setText("WALL");
        wall01Label.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(wall01Label);
        wall01Label.setBounds(10, 10, 40, 640);

        wall02Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        wall02Label.setText("WALL");
        wall02Label.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(wall02Label);
        wall02Label.setBounds(10, 10, 990, 40);

        wall03Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        wall03Label.setText("WALL");
        wall03Label.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(wall03Label);
        wall03Label.setBounds(10, 610, 990, 40);

        wall04Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        wall04Label.setText("WALL");
        wall04Label.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(wall04Label);
        wall04Label.setBounds(960, 10, 40, 640);

        wall05Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        wall05Label.setText("WALL");
        wall05Label.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(wall05Label);
        wall05Label.setBounds(160, 450, 40, 200);

        wall06Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        wall06Label.setText("WALL");
        wall06Label.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(wall06Label);
        wall06Label.setBounds(160, 450, 210, 40);

        wall07Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        wall07Label.setText("WALL");
        wall07Label.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(wall07Label);
        wall07Label.setBounds(330, 370, 40, 120);

        wall08Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        wall08Label.setText("WALL");
        wall08Label.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(wall08Label);
        wall08Label.setBounds(610, 170, 40, 120);

        wall09Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        wall09Label.setText("WALL");
        wall09Label.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(wall09Label);
        wall09Label.setBounds(610, 170, 210, 40);

        wall10Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        wall10Label.setText("WALL");
        wall10Label.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(wall10Label);
        wall10Label.setBounds(780, 10, 40, 200);

        backgroundLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        backgroundLabel.setText("BACKGROUND");
        backgroundLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(backgroundLabel);
        backgroundLabel.setBounds(10, 10, 990, 640);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        engine.keyPress(evt);
    }//GEN-LAST:event_formKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backgroundLabel;
    private javax.swing.JLabel enemy1Label;
    private javax.swing.JLabel enemy2Label;
    private javax.swing.JLabel heroLabel;
    private javax.swing.JLabel objectiveLabel;
    private javax.swing.JLabel wall01Label;
    private javax.swing.JLabel wall02Label;
    private javax.swing.JLabel wall03Label;
    private javax.swing.JLabel wall04Label;
    private javax.swing.JLabel wall05Label;
    private javax.swing.JLabel wall06Label;
    private javax.swing.JLabel wall07Label;
    private javax.swing.JLabel wall08Label;
    private javax.swing.JLabel wall09Label;
    private javax.swing.JLabel wall10Label;
    // End of variables declaration//GEN-END:variables

}
