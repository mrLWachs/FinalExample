package yearOthers.seatingplan;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * @author lwachs
 */
public class SeatingPlanner {

    private JFrame frame;
    private JPanel fraBackground;
    private JLabel seats[];
    private String firstName;
    private String lastName;
    private String classList[];

    public SeatingPlanner() {
        frame = null;
    }

    public SeatingPlanner(JFrame frame, 
        JLabel lbl1,  JLabel lbl2,  JLabel lbl3,  JLabel lbl4,  JLabel lbl5,
        JLabel lbl6,  JLabel lbl7,  JLabel lbl8,  JLabel lbl9,  JLabel lbl10,
        JLabel lbl11, JLabel lbl12, JLabel lbl13, JLabel lbl14, JLabel lbl15,
        JLabel lbl16, JLabel lbl17, JLabel lbl18, JLabel lbl19, JLabel lbl20,
        JLabel lbl21, JLabel lbl22, JLabel lbl23, JLabel lbl24, JLabel lbl25,
        JLabel lbl26, JLabel lbl27, JLabel lbl28, JLabel lbl29, JLabel lbl30,
        JPanel fraBackground)
    {
        this.frame = frame;
        this.seats = new JLabel[30];
        seats[0] = lbl1;   seats[1] = lbl2;   seats[2] = lbl3;
        seats[3] = lbl4;   seats[4] = lbl5;   seats[5] = lbl6;
        seats[6] = lbl7;   seats[7] = lbl8;   seats[8] = lbl9;
        seats[9] = lbl10;  seats[10] = lbl11; seats[11] = lbl12;
        seats[12] = lbl13; seats[13] = lbl14; seats[14] = lbl15;
        seats[15] = lbl16; seats[16] = lbl17; seats[17] = lbl18;
        seats[18] = lbl19; seats[19] = lbl20; seats[20] = lbl21;
        seats[21] = lbl22; seats[22] = lbl23; seats[23] = lbl24;
        seats[24] = lbl25; seats[25] = lbl26; seats[26] = lbl27;
        seats[27] = lbl28; seats[28] = lbl29; seats[29] = lbl30;
        this.fraBackground = fraBackground;
        blankSeats();
    }

    public void setGUI() {
        frame.setSize(1100,615);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setTitle("Class Seating Plan");
        frame.setBackground(Color.BLACK);
        centerFrameOnScreen();
    }

    public void randomize() {
        blankSeats();
        for (int i = 0; i < 30; i++) {
            int randomSpot = getRandomSpot();
            seats[randomSpot].setText(classList[i]);
        }
    }

    public void randomSeating() {
        classList = getClassFile();
        randomize();
    }

    public void exitProgram() {
        int answer = JOptionPane.showConfirmDialog(frame,
                "Are you sure you want to exit?","EXIT?",
                JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if (answer == JOptionPane.YES_OPTION) System.exit(0);
    }

    private void blankSeats() {
        Font font = new Font("Arial Narrow",Font.PLAIN, 10);
        Color background = new Color(255,255,255);
        Color foreground = new Color(255,255,255);
        for (int i = 0; i < seats.length; i++) {
            seats[i].setText("EMPTY SEAT");
            seats[i].setFont(font);
            seats[i].setBackground(background);
            seats[i].setForeground(foreground);
        }
        fraBackground.setBackground(background);
    }

    private String[] getClassFile() {
        String names[] = new String[30];
        for (int i = 0; i < names.length; i++) {
            names[i] = "EMPTY SEAT";
        }
        try {
            File currentDirectory = new File("");
            JFileChooser chooser = new JFileChooser(currentDirectory);
            chooser.showOpenDialog(frame);
            File file = chooser.getSelectedFile();
            if (file == null) return null;
            int i = 0;
            FileReader     stream = new FileReader(file);
            BufferedReader reader = new BufferedReader(stream);
            String name = reader.readLine();
            while(name != null) {
                if (i > 29) {
                    message("Too many kids for the number of seats" +
                            "\n\n" +
                            "Student " + name + " will not " +
                            "have a seat!");
                }
                else {
                    name = divideName(name);
                    names[i] = name;
                }
                i++;
                name = reader.readLine();
            }
            reader.close();
        }
        catch (IOException e) {
            message("File Read error!");
        }
        return names;
    }

    private int getRandomSpot() {
        int random = randomInteger(0,29);
        boolean done = false;
        while(!done) {
            if (seats[random].getText().equalsIgnoreCase("EMPTY SEAT")) {
                done = true;
            }
            else {
                random = randomInteger(0,29);
                done = false;
            }
        }
        return random;
    }

    private void message(String text) {
        JOptionPane.showMessageDialog(frame,
                text,"ERROR",JOptionPane.ERROR_MESSAGE);
    }

    private int randomInteger(int low, int high) {
        double rnd = Math.random();
        double L = (double)low;
        double H = (double)high;
        double random = (H - L + 1) * rnd + L;
        return (int)random;        
    }

    private String divideName(String name) {
        if (name != null) {
            if (!name.equals("")) {
                firstName = "";
                lastName = "";
                int currentName = 1;
                for (int i = 0; i < name.length(); i++) {
                    char letter = name.charAt(i);
                    if(letter == ',') {
                        currentName++;
                        i++;
                    }
                    else {
                        if (currentName == 2) {
                            firstName += "" + letter;
                        }
                        else {
                            lastName += "" + letter;
                        }
                    }
                }
                return firstName;
            }                
        }
        return null;
    }

    private void centerFrameOnScreen() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dim = toolkit.getScreenSize();
        int width = frame.getWidth() / 2;
        int height = frame.getHeight() / 2;
        int x = ((int)dim.getWidth() / 2) - width;
        int y = ((int)dim.getHeight() / 2) - height;
        frame.setLocation(x,y);
    }

}
