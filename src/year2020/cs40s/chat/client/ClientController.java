
package year2020.cs40s.chat.client;


public class ClientController 
{

    private ClientView view;
    private ClientModel model;
            
    
    public ClientController(ClientView view, ClientModel model) {
        this.view  = view;
        this.model = model;
    }

    public void send() {
        model.sendMessage();
    }
    
}
