package yearOthers.triangle;


import java.awt.Color;
import java.awt.Frame;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.Timer;


/** @author Mr. Wachs */
class FractalLogic 
{
    
    
    private static final int    LABEL_SIZE       = 10;
    private static final int    MIN_ITERATIONS   = 1;
    private static final int    MAX_ITERATIONS   = 50000;
    private static final int    START_ITERATIONS = MAX_ITERATIONS/2;    
    private static final int    MIN_DOT_SIZE     = 2;
    private static final int    MAX_DOT_SIZE     = 100;
    private static final int    START_DOT_SIZE   = MAX_DOT_SIZE/2;        
    private static final int    OPTION_WIDTH     = 535;
    private static final int    OPTION_HEIGHT    = 265;  
    private static final String APP_TITLE        = "Serpinski Triangle Generator";
    private static final String FORE_TITLE       = "Choose Foreground Color";
    private static final String BACK_TITLE       = "Choose Foreground Color";
        
    private static Frame          canvas           = null;   
    private static JFrame         options          = null;   
    private static JSlider        slider           = null;
    private static JSlider        sliderDot        = null;
    private static JLabel         iterationsLabel  = null;
    private static JLabel         dotSizeLabel     = null;    
    private static Timer          timer            = null;
    private static ActionListener timerListener    = null;
    private static Point          p1               = new Point(0,0);
    private static Point          p2               = new Point(0,0);
    private static Point          p3               = new Point(0,0);
    private static Point          currentPoint     = new Point(0,0);
    private static int            dot              = 0;    
    private static int            currentDot       = 0;  
    
    public static Color   foregroundColor = null;    
    public static Color   backgroundColor = null;
    public static int     iterations      = 0;
    public static int     dotSize         = 1;
    public static int     x               = -dotSize;
    public static int     y               = -dotSize;
    public static boolean isRandom        = false;
    
    
    static void sliderDotChange() {
        dotSize = sliderDot.getValue();
        dotSizeLabel.setText("" + dotSize);
    }

    public FractalLogic() {
        FractalLogic.options  = null;
        FractalLogic.canvas   = null;
    }
    
    public FractalLogic(JFrame options, JFrame canvas) {
        FractalLogic.options = options;
        FractalLogic.canvas  = canvas;
    }
    
    public FractalLogic(JFrame options, Frame canvas) {
        FractalLogic.options = options;
        FractalLogic.canvas  = canvas;
    }
    
    public static void setLogic() {
        slider.setMinimum(MIN_ITERATIONS);
        slider.setMaximum(MAX_ITERATIONS);
        slider.setValue(START_ITERATIONS);
        iterations = START_ITERATIONS;
        sliderChange();         
        sliderDot.setMinimum(MIN_DOT_SIZE);
        sliderDot.setMaximum(MAX_DOT_SIZE);
        sliderDot.setValue(START_DOT_SIZE);
        dotSize = START_DOT_SIZE;  
        sliderDotChange();
        foregroundColor = null;
        backgroundColor = Box.randomColor();
        isRandom        = false;
        Box.setGUI(options,OPTION_WIDTH,OPTION_HEIGHT,APP_TITLE,false);
        Box.centerFrameOnScreen(options);        
    }
    
    public static void setOptions(JSlider slider, JSlider sliderDot, 
            JLabel iterationsLabel, JLabel dotSizeLabel) {
        FractalLogic.slider          = slider;
        FractalLogic.sliderDot       = sliderDot;
        FractalLogic.iterationsLabel = iterationsLabel; 
        FractalLogic.dotSizeLabel    = dotSizeLabel;         
    }

    public static void sliderChange() {
        iterations = slider.getValue();
        iterationsLabel.setText("" + iterations);
    }

    public static void drawCanvas() {
        setTimer();
        Box.setFullScreen(canvas);
        setColors();
    }
    
    public static void quit() {
        Box.end("Thank you for using the " + APP_TITLE,APP_TITLE);
    }
    
    public static void keyDown() {
        timer.stop();
        canvas.setVisible(false);
        canvas.dispose();
    }

    public static void chooseColor() {
        foregroundColor = JColorChooser.showDialog(canvas,FORE_TITLE,foregroundColor);
        backgroundColor = JColorChooser.showDialog(canvas,BACK_TITLE,backgroundColor);
        if (foregroundColor != null && backgroundColor != null && 
            canvas != null) setColors();
    }

    private static void setColors() {
        if (foregroundColor != null) canvas.setForeground(foregroundColor);        
        if (backgroundColor != null) canvas.setBackground(backgroundColor);           
    }
    
    public static void mouseDown(MouseEvent e) {        
        if      (e.getButton() == MouseEvent.BUTTON1) setVertices(e);
        else if (e.getButton() == MouseEvent.BUTTON3) drawTriangle();
    }

    private static void drawDot() {    
        if (dot >= iterations) {
            timer.stop();
            dot = MIN_ITERATIONS;
        }
        else {         
            dot++;
            int go = Box.randomInt(1.0, 3.0); 
            int currX = calcX(go);
            int currY = calcY(go);
            currentPoint = new Point(currX,currY);  
            x = (int)currentPoint.getX();
            y = (int)currentPoint.getY();
            canvas.repaint();
        }
    }

    private static void drawTriangle() {
        findStart();    
        dot = MIN_ITERATIONS;       
        timer.start();        
    }
    
    public static void findStart() {
        int lowX = 0;
        if      (p1.getX() < p2.getX() && p1.getX() < p3.getX()) lowX = (int)p1.getX();
        else if (p2.getX() < p1.getX() && p2.getX() < p3.getX()) lowX = (int)p2.getX();
        else if (p3.getX() < p1.getX() && p3.getX() < p2.getX()) lowX = (int)p3.getX();      
        int lowY = 0;
        if      (p1.getY() < p2.getY() && p1.getY() < p3.getY()) lowY = (int)p1.getY();
        else if (p2.getY() < p1.getY() && p2.getY() < p3.getY()) lowY = (int)p2.getY();
        else if (p3.getY() < p1.getY() && p3.getY() < p2.getY()) lowY = (int)p3.getY();        
        int highX = 0;
        if      (p1.getX() > p2.getX() && p1.getX() > p3.getX()) highX = (int)p1.getX();
        else if (p2.getX() > p1.getX() && p2.getX() > p3.getX()) highX = (int)p2.getX();
        else if (p3.getX() > p1.getX() && p3.getX() > p2.getX()) highX = (int)p3.getX();       
        int highY = 0;
        if      (p1.getY() > p2.getY() && p1.getY() > p3.getY()) highY = (int)p1.getY();
        else if (p2.getY() > p1.getY() && p2.getY() > p3.getY()) highY = (int)p2.getY();
        else if (p3.getY() > p1.getY() && p3.getY() > p2.getY()) highY = (int)p3.getY();       
        int startX = ((highX + lowX) / 2)-(LABEL_SIZE/2);
        int startY = ((highY + lowY) / 2)-(LABEL_SIZE/2);   
        currentPoint = new Point(startX-(LABEL_SIZE/2),startY-(LABEL_SIZE/2));
    }

    private static void setVertices(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        canvas.repaint();
        currentDot++;
        if      (currentDot == 1) p1 = new Point(e.getX(),e.getY());         
        else if (currentDot == 2) p2 = new Point(e.getX(),e.getY());
        else if (currentDot == 3) {
            p3 = new Point(e.getX(),e.getY());
            currentDot = 0;
        }
    }
    
    private static int calcX(int point) {
        int x1 = (int)currentPoint.getX();
        int x2 = 0;                
        if(point == 1) {
            x2 = ((int)p1.getX());
            return Box.midpoint(x1, x2);
        }
        else if(point == 2) {
            x2 = ((int)p2.getX());
            return Box.midpoint(x1, x2);
        }
        else if(point == 3) {
            x2 = ((int)p3.getX());
            return Box.midpoint(x1, x2);
        }
        return 0;
    }
    
    private static int calcY(int point) {
        int y1 = (int)currentPoint.getY();
        int y2 = 0;                
        if(point == 1) {
            y2 = ((int)p1.getY());
            return Box.midpoint(y1, y2);
        }
        else if(point == 2) {
            y2 = ((int)p2.getY());
            return Box.midpoint(y1, y2);
        }
        else if(point == 3) {
            y2 = ((int)p3.getY());
            return Box.midpoint(y1, y2);
        }
        return 0;
    }

    private static void setTimer() {
        timerListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                drawDot();
            }
        };
        timer = new Timer(1,timerListener);
    }
        
}
