package yearOthers.triangle;


/** @author Mr. Wachs */
class Debugger 
{

    private static int lineNumber = 0;
    
    public static void show(String text) {
        lineNumber++;
        System.out.println("(" + lineNumber + ")\t" + text);
    }
        
}
