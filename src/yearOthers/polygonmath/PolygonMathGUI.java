package yearOthers.polygonmath;


import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;



/**
 *
 * @author lwachs
 */
public class PolygonMathGUI extends JFrame {

    
    private JPanel  fraBackground;
    private JPanel  fraGraphics;
    private JLabel  lblNumberOfSides;
    private JSlider sliNumberOfSides;
    private int     setValue = 0;

    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    public PolygonMathGUI() {
        initComponents();
        initDatastructures();
    }

    
    
    
    
    private void initComponents() {

        fraBackground    = new JPanel();
        sliNumberOfSides = new JSlider();
        lblNumberOfSides = new JLabel();
        fraGraphics      = new JPanel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        fraBackground.setBorder(BorderFactory.createEtchedBorder());
        fraBackground.setLayout(null);

        sliNumberOfSides.setMaximum(500);
        sliNumberOfSides.setMinimum(1);
        sliNumberOfSides.setPaintLabels(true);
        sliNumberOfSides.setPaintTicks(true);

        sliNumberOfSides.addChangeListener(
            new ChangeListener() {
                public void stateChanged(ChangeEvent evt) {
                    sliNumberOfSidesStateChanged(evt);
                }
            }
        );

        fraBackground.add(sliNumberOfSides);
        fraBackground.add(lblNumberOfSides);
        fraBackground.add(fraGraphics);
        
        
        sliNumberOfSides.setBounds(10, 40, 720, 50);
        lblNumberOfSides.setBounds(20, 20, 240, 14);
        fraGraphics.setBounds(20, 90, 700, 450);
        
        lblNumberOfSides.setText("Number of Sides:");
        fraGraphics.setBorder(BorderFactory.createEtchedBorder());
        fraGraphics.setLayout(null);
        

        getContentPane().add(fraBackground);
        fraBackground.setBounds(10, 10, 740, 570);

        pack();
    }
    
    private void sliNumberOfSidesStateChanged(ChangeEvent evt) {                                              
        sliderChange();
    }                                             

    private void initDatastructures() {
        this.setSize(775,630);
    }

    private void sliderChange() {
        int value = sliNumberOfSides.getValue();
        lblNumberOfSides.setText("Number of Sides: " + value);
        setValue = value;
        //changePolygon();
    }

//    private void changePolygon() {
//        fraGraphics.repaint();
//    }

}
