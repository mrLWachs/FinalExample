
/** required package class namespace */
package year2020.cs40s.gridgameadvanced;

 
/**
 * UIController.java - the controller logic for the user interface
 *
 * @author Mr. Wachs
 * @since Nov. 29, 2019, 2:40:26 p.m.
 */
public class UIController 
{

    private UIModel model;
    private UIView  view;
      
    
    public UIController(UIModel model, UIView view) {
        this.model = model;
        this.view  = view;        
    }
    
}
