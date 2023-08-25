
/** Required package class namespace */
package year2021.cs40s.familytree.userinterfaces;

/** Required imports */
import year2021.cs40s.familytree.datastructures.Family;
import year2021.cs40s.familytree.datastructures.Globals;
import year2021.cs40s.familytree.datastructures.Person;


/**
 * AddNewMemberUI.java - This user interface (UI) is for adding a new person 
 * to a family or editing an existing person in the family
 *
 * @author Mr. Wachs' student 
 * @since Mar. 17, 2021 
 */
public class AddNewMemberUI extends javax.swing.JFrame {

    // <editor-fold defaultstate="collapsed" desc="All NetBeans Generated Code collapsed in NetBeans"> 
    
    /**
     * Creates new form AddNewMemberUI
     */
    public AddNewMemberUI(EditFamilyMembersUI parent, int index, int position) {
        initComponents();
        startup(parent,index,position);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel1.setText("Add New Family Member:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 10, 420, 40);

        jLabel2.setText("First Name(s):");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 60, 120, 20);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(130, 60, 300, 20);

        jLabel3.setText("Middle Name(s):");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 90, 120, 20);
        getContentPane().add(jTextField2);
        jTextField2.setBounds(130, 90, 300, 20);

        jLabel4.setText("Maiden Name:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 130, 120, 20);
        getContentPane().add(jTextField3);
        jTextField3.setBounds(130, 130, 300, 20);

        jLabel5.setText("Birth Date:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(10, 170, 120, 20);
        getContentPane().add(jTextField4);
        jTextField4.setBounds(130, 170, 300, 20);

        jLabel6.setText("Death Date:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(10, 210, 120, 20);
        getContentPane().add(jTextField5);
        jTextField5.setBounds(130, 210, 300, 20);

        jLabel8.setText("Optional (leave blank if still alive)");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(130, 230, 300, 20);

        jLabel9.setText("Optional (leave blank if not known)");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(130, 190, 300, 20);

        jButton2.setText("Enter Female Parent (Skip if not known)");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(440, 140, 300, 30);

        jButton3.setText("Enter any Spouses (Skip if none)");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(440, 180, 300, 30);

        jButton4.setText("Enter Male Parent (Skip if not known)");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(440, 100, 300, 30);

        jButton5.setText("Enter any Children (Skip if none)");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(440, 60, 300, 30);

        jButton6.setText("CANCEL");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6);
        jButton6.setBounds(440, 270, 300, 30);

        jButton7.setText("OK");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7);
        jButton7.setBounds(130, 270, 300, 30);

        jLabel10.setText("Optional (leave blank if not different from family name)");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(130, 150, 300, 20);

        jLabel11.setText("Optional (leave blank if not applicable)");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(130, 110, 300, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        cancel();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        ok();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        enterAnyChildren();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        enterMaleParent();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        enterFemaleParent();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        enterAnySpouses();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        closeWindow();
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables

    // </editor-fold> 
    
    
    // Global variables (class properties) used by the class and its methods:
    private EditFamilyMembersUI parent;
    private Family              family;
    private Person              person;
    private int                 position;
        
    
    /**
     * When the constructor for this class is call (when the UI appears), set
     * the staring conditions for this class
     * 
     * @param parent the user interface (UI) this UI came from 
     * @param index the family index location in the linked list of families
     * @param position the index position of this family member in the list
     */
    private void startup(EditFamilyMembersUI parent, int index, int position) {        
        // Assign the passed parameter references to the global properties 
        // (global variable references) of this class
        this.parent   = parent;                
        this.position = position;         
        
        // Get a reference to the family to add a member to 
        this.family = Globals.families.get(index);
                
        // Check if this is a new person or editing an existing person
        if (position == Globals.NEW_ENTRY) { 
            person = new Person();              // Create new person object
            
            // Update label            
            jLabel1.setText("Add new family member to '" + family.name
                + "' family :");
        }
        else {                                  // Edit existing person
            
            // Get a reference to this person in the family
            person = family.members.get(position);
                        
            // Adjust all labels and textboxes with data from existing person
            jLabel1.setText("Editing '" + person.familyName + 
                            "' family member:");
            jTextField1.setText(person.firstNames);
            
            // Only update if this value has stored content
            if (person.middleNames != null) {
                jTextField2.setText(person.middleNames);
            }
            if (person.maidenName != null) {
                jTextField3.setText(person.maidenName);
            }
            if (person.birthDate != null) {
                jTextField4.setText(person.birthDate);
            }
            if (person.deathDate != null) {
                jTextField5.setText(person.deathDate);
            }      
            
            // Update label
            jLabel1.setText("Edit existing family '" + family.name + 
                            "' member '" + person.firstNames + "' :");            
        }  
        
        // Assign the family name to the new (or existing) person, and
        // start up this user interface
        person.familyName = family.name;
        Globals.startup(this, 770, 350);  
    }

    /**
     * The associated code with the button to enter any children
     */
    private void enterAnyChildren() {
        new EnterRelativesUI(this,family,person,true);      // Launch other UI
        this.setVisible(false);                             // Hide this UI
    }

    /**
     * The associated code with the button to enter the male parent (father)
     */
    private void enterMaleParent() {
        new EnterParentUI(this,family,person,true);         // Launch other UI
        this.setVisible(false);                             // Hide this UI
    }

    /**
     * The associated code with the button to enter the female parent (mother)
     */
    private void enterFemaleParent() {
        new EnterParentUI(this,family,person,false);        // Launch other UI
        this.setVisible(false);                             // Hide this UI
    }

    /**
     * The associated code with the button to enter any spouse(s)
     */
    private void enterAnySpouses() {
        new EnterRelativesUI(this,family,person,false);     // Launch other UI
        this.setVisible(false);                             // Hide this UI
    }

    /**
     * The associated code with the button to confirm this person is completed
     */
    private void ok() {
        // Get the text from the textbox and confirm for the first name that
        // it must be entered or discontinue this method
        String firstNames = jTextField1.getText();
        if (firstNames == null || firstNames.equals("")) {
            Globals.dialogs.error("You must enter a first name(s)!");
            return;
        }
        
        // Now assign the values from the textboxes (even if blanks) to the 
        // class person object
        person.firstNames  = firstNames;
        person.middleNames = jTextField2.getText();
        person.maidenName  = jTextField3.getText();  
        person.birthDate   = jTextField4.getText();      
        person.deathDate   = jTextField5.getText();
        
        // Check if new person or editing existing person
        if (position == Globals.NEW_ENTRY) {   
            family.members.add(person);
        }
        else {
            family.members.set(position,person);
        }
        parent.showList();                     // Update listbox on the other UI
        this.dispose();                        // Dispose this UI
        parent.setVisible(true);               // Make other UI visible
    }

    /**
     * The associated code with the button to cancel and reject this person or
     * any changed to the existing person
     */
    private void cancel() {
        this.dispose();                             // Dispose this UI
        parent.setVisible(true);                    // Show other UI
    }

    /**
     * The associated code with the user closing this UI (by clicking the "X")
     */
    private void closeWindow() {
        Globals.end();
    }
 
}