
/** required package class namespace */
package year2019.cs40s.twitter;

/** required imports */
import javax.swing.JComponent;


/**
 * UIView.java - the view class (based on MVC model) for the 
 * application user interface
 *
 * @author Mr. Wachs 
 * @since 12-Mar-2019 
 */
public class UIView extends javax.swing.JFrame 
{

    private UIController engine;
    
    /** 
     * Default constructor for the class, sets class properties, it creates a
     * new form UI 
     */
    public UIView() {
        initComponents();        
        JComponent[] controls = {
            jButton2,jButton3,jButton4,jButton1,
            jLabel1,jLabel2,jLabel4,jLabel5,
            jList1,jList2,jList3,jPanel1,
            jPanel2,jPanel3,jProgressBar1,
            jScrollPane1,jScrollPane2,jScrollPane3,
            jTextField1,jTextField2,
            jToggleButton2
        };        
        engine = new UIController(controls,this);        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList3 = new javax.swing.JList<>();
        jProgressBar1 = new javax.swing.JProgressBar();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("All Tweet Data"));
        jPanel1.setLayout(null);

        jScrollPane1.setViewportView(jList1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 20, 460, 430);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 200, 480, 460);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Relevant Tweet Data"));
        jPanel2.setLayout(null);

        jScrollPane3.setViewportView(jList3);

        jPanel2.add(jScrollPane3);
        jScrollPane3.setBounds(10, 20, 460, 430);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(510, 200, 480, 460);
        getContentPane().add(jProgressBar1);
        jProgressBar1.setBounds(10, 670, 970, 30);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Tweet Commands"));
        jPanel3.setLayout(null);

        jLabel1.setText("Twitter feed currently not reading");
        jPanel3.add(jLabel1);
        jLabel1.setBounds(10, 110, 290, 40);

        jLabel2.setText("Twitter user to check");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(10, 30, 290, 20);
        jPanel3.add(jTextField1);
        jTextField1.setBounds(310, 30, 200, 20);

        jLabel4.setText("Add watch word:");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(520, 30, 200, 20);
        jPanel3.add(jTextField2);
        jTextField2.setBounds(720, 30, 250, 20);

        jButton2.setText("Clear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2);
        jButton2.setBounds(520, 120, 190, 30);

        jScrollPane2.setViewportView(jList2);

        jPanel3.add(jScrollPane2);
        jScrollPane2.setBounds(720, 60, 250, 90);

        jButton3.setText("Add");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3);
        jButton3.setBounds(520, 60, 190, 30);

        jButton4.setText("Remove");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton4);
        jButton4.setBounds(520, 90, 190, 30);

        jToggleButton2.setText("START / STOP");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jToggleButton2);
        jToggleButton2.setBounds(310, 110, 200, 40);

        jLabel5.setToolTipText("");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(10, 70, 290, 30);

        jButton1.setText("Create Report File");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);
        jButton1.setBounds(310, 60, 200, 40);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(10, 10, 980, 170);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        engine.createReportFile();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        engine.startStop();
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        engine.addWord();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        engine.removeWord();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        engine.clearWords();
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JList<String> jList3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JToggleButton jToggleButton2;
    // End of variables declaration//GEN-END:variables

}
