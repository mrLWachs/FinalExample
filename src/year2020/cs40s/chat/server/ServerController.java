
package year2020.cs40s.chat.server;


public class ServerController 
{

    private ServerView view;
    private ServerModel model;
            
    
    public ServerController(ServerView view, ServerModel model) {
        this.view  = view;
        this.model = model;
    }

    public void send() {
        model.sendMessage();
    }
    
}
