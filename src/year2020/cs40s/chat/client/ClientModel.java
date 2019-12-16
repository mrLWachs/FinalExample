
package year2020.cs40s.chat.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;


public class ClientModel 
{

    private JButton       sendButton;
    private JLabel        titleLabel;
    private JList<String> chatList;
    private JScrollPane   chatListbox;
    private JTextField    messageTextbox;
    private ClientView    view;
    
    private DefaultListModel<String> listModel;
    
    private  Socket           socket;
    private  DataInputStream  dataInputStream;
    private  DataOutputStream dataOutputStream;
    private  int              port; 
    
    private final int    UI_WIDTH  = 616;
    private final int    UI_HEIGHT = 430;
    private final String ADDRESS   = "127.0.0.1";
    
    
    
    public ClientModel(JButton sendButton, JLabel titleLabel, 
                       JList<String> chatList, JScrollPane chatListbox, 
                       JTextField messageTextbox, ClientView view) {
        this.sendButton     = sendButton;
        this.titleLabel     = titleLabel;
        this.chatList       = chatList;
        this.chatListbox    = chatListbox;
        this.messageTextbox = messageTextbox;
        this.view           = view;
        initUI();
    }

    private void initUI() {
        view.setSize(UI_WIDTH, UI_HEIGHT);
        view.setLocationRelativeTo(null);
        view.setResizable(false);
        view.setTitle("Chat program");
        listModel = new DefaultListModel();
        chatList.setModel(listModel);        
        listModel.removeAllElements();
        view.setVisible(true);
    }

    public void run() {
        try {
            port = new Dialogs().inputInteger("Enter port");
            socket = new Socket(ADDRESS,port);
            dataInputStream  = new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            listModel.addElement("Client has joined server");
            String message = "";
            while (!message.equals("exit")) {
                message = dataInputStream.readUTF();
                listModel.addElement(message);
            }  
            listModel.addElement("Client has left");
            socket.close();
        }
        catch (IOException error) {
            listModel.addElement("IOException in initClient ->" + 
                    error.toString());
        }
        catch (NullPointerException error) {
            listModel.addElement("NullPointerException in sendMessage -> " + 
                    error.toString() + " <- ");
            if (socket == null) 
                listModel.addElement("socket is null");
            if (dataInputStream == null) 
                listModel.addElement("dataInputStream is null");
            if (dataOutputStream == null) 
                listModel.addElement("dataOutputStream is null");          
        }
    }

    public void sendMessage() {
        try {            
            final String HEADER = "Client: ";
            String message = messageTextbox.getText();
            listModel.addElement(HEADER + message);
            dataOutputStream.writeUTF(HEADER + message);  
            messageTextbox.setText("");
            messageTextbox.requestFocus();
        } 
        catch (IOException error) {
            System.out.println("IOException in Client sendMessage ->" + 
                    error.toString());
        } 
        catch (NullPointerException error) {
            listModel.addElement("NullPointerException in sendMessage -> " + 
                    error.toString() + " <- ");
            if (socket == null) 
                listModel.addElement("socket is null");
            if (dataInputStream == null) 
                listModel.addElement("dataInputStream is null");
            if (dataOutputStream == null) 
                listModel.addElement("dataOutputStream is null");          
        }
    }
    
}
