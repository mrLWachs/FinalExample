
/** Required package class namespace */
package year2021.cs40s.familytree.userinterfaces;

/** Required imports */
import year2021.cs40s.familytree.collections.LinkedList;
import year2021.cs40s.familytree.datastructures.Family;
import year2021.cs40s.familytree.datastructures.Globals;
import year2021.cs40s.familytree.datastructures.Person;


/**
 * EnterRelativesUI.java - This user interface (UI) is for selecting any 
 * children or spouse(s) from all the existing family members
 *
 * @author Mr. Wachs' student 
 * @since Mar. 17, 2021 
 */
public class EnterRelativesUI extends javax.swing.JFrame {

    // <editor-fold defaultstate="collapsed" desc="All NetBeans Generated Code collapsed in NetBeans"> 
    
    /**
     * Creates new form EnterRelativesUI
     */
    public EnterRelativesUI(AddNewMemberUI parent, 
            Family family, Person person, boolean isChildren) {
        initComponents();
        startup(parent,family,person,isChildren);
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
        jButton2 = new javax.swing.JButton();
        list1 = new java.awt.List();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        jButton1.setText("CANCEL");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(250, 360, 230, 40);

        jButton2.setText("OK");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(10, 360, 230, 40);

        list1.setMultipleMode(true);
        getContentPane().add(list1);
        list1.setBounds(10, 100, 470, 250);

        jLabel1.setText("Please select the children already entered in this database:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 10, 470, 50);

        jLabel2.setText("Hold down the CTRL key to select multiple items...");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 50, 470, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        cancel();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ok();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        closeWindow();
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private java.awt.List list1;
    // End of variables declaration//GEN-END:variables

    
    // </editor-fold> 
        
    
    // Global variables (class properties) used by the class and its methods:
    private AddNewMemberUI parentUI;
    private boolean isChildren;
    private Family family;
    private Person person;
    
    
    /**
     * When the constructor for this class is call (when the UI appears), set
     * the staring conditions for this class
     * 
     * @param parentUI the user interface (UI) this UI came from 
     * @param family the family object this person is from
     * @param person the person object to assign a parent to
     * @param isChildren flag for children (true) or spouse(s) (false)
     */
    private void startup(AddNewMemberUI parentUI, Family family, Person person, 
                         boolean isChildren) {      
        // Assign the passed parameter references to the global properties 
        // (global variable references) of this class
        this.isChildren = isChildren;
        this.parentUI   = parentUI;
        this.family     = family;
        this.person     = person; 
        
        // Update label based on children or spouse(s)
        if (isChildren) {
            jLabel1.setText("Please select the children "
                    + "already entered in this database:");
        }
        else {
            jLabel1.setText("Please select the spouse(s) "
                    + "already entered in this database:");
        }
        
        // Update family names listbox and start up UI
        Globals.updateList(list1, family, person);
        Globals.startup(this, 507, 450);
    }

    /**
     * The associated code with the button to confirm the relative(s) are added
     */
    private void ok() {      
        // Create an array for the user selecting multiple items in the
        // UI listbox object and get them from what the user selected
        Object[] selectedItems = list1.getSelectedObjects();
        
        // The user has not selected any items
        if (selectedItems == null) {
            Globals.dialogs.output(Globals.NAME_ERROR);     // Prompt user
        }
        else {                                   // User has made selection(s)
            
            // Store all the index values from what the user had selected in 
            // the UI listbox 
            int[] indices = list1.getSelectedIndexes();
            
            // Create a list for all person objects
            LinkedList<Person> list = new LinkedList<>();
            
            // Loop through the array of indices
            for (int i = 0; i < indices.length; i++) {
                // Get an index from the array of indices
                int index = indices[i];
                
                // Use the index to get a person from the family LinkedList
                Person member = family.members.get(index);
                
                // Add this person to the other LinkedList
                list.add(member);
            }
            // Associate this new LinkedList with the list for this person oject
            if (isChildren) {                                      
                person.children = list;                 // list is for children 
            }
            else {
                person.spouses = list;                 // list is for spouse(s)
            }
            this.dispose();                            // Dispose this UI
            parentUI.setVisible(true);                 // Show other UI
        }
    }
    
    /**
     * The associated code with the button to cancel and reject the changes
     */
    private void cancel() {
        this.dispose();                             // Dispose this UI
        parentUI.setVisible(true);                  // Show other UI
    }
    
    /**
     * The associated code with the user closing this UI (by clicking the "X")
     */
    private void closeWindow() {
        Globals.end();
    }

}
