package yearOthers.triangle;


/**@author Mr. Wachs */
public class FractalMain 
{

    /**
     * @param args the command line arguments
     */
    public FractalMain() {
        FractalLogic       fractalLogic      = new FractalLogic();
        FractalOptionsGUI  fractalOptionsGUI = new FractalOptionsGUI();        
        FractalCanvasGUI   fractalCanvasGUI  = new FractalCanvasGUI();
        fractalLogic                         = new FractalLogic(fractalOptionsGUI,fractalCanvasGUI);
        fractalOptionsGUI.initGUI();
        fractalLogic.setLogic();
    }

}
