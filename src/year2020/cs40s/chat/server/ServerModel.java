
package year2020.cs40s.chat.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;


public class ServerModel 
{
    
    private JButton       sendButton;
    private JLabel        titleLabel;
    private JList<String> chatList;
    private JScrollPane   chatListbox;
    private JTextField    messageTextbox;
    private ServerView    view;
    
    private DefaultListModel<String> listModel;
    
    private  ServerSocket     serverSocket;
    private  Socket           socket;
    private  DataInputStream  dataInputStream;
    private  DataOutputStream dataOutputStream;
        
    private final int   UI_WIDTH  = 616;
    private final int   UI_HEIGHT = 430;
    private final int[] PORTS     = {1202,3843,4584,4843,8989,59090};
    
    
    ServerModel(JButton sendButton, JLabel titleLabel, 
                JList<String> chatList, JScrollPane chatListbox, 
                JTextField messageTextbox, ServerView view) {
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
            serverSocket     = getAvailablePort();
            socket           = serverSocket.accept();
            dataInputStream  = new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            listModel.addElement("Server has started...");
            String message = "";
            while (!message.equals("exit")) {
                message = dataInputStream.readUTF();
                listModel.addElement(message);
            }    
            listModel.addElement("Server has stopped!");
            socket.close();
        }
        catch (IOException error) {
            listModel.addElement("IOException in running Server ->" + 
                    error.toString());
        } 
        catch (NullPointerException error) {
            listModel.addElement("NullPointerException in running Server -> " + 
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
            final String HEADER = "Server: ";
            String message = messageTextbox.getText();
            listModel.addElement(HEADER + message);
            dataOutputStream.writeUTF(HEADER + message);    
            messageTextbox.setText("");
            messageTextbox.requestFocus();
        } 
        catch (IOException error) {
            listModel.addElement("IOException in Server sendMessage -> " + 
                    error.toString());
        }   
        catch (NullPointerException error) {
            listModel.addElement("NullPointerException in sendMessage -> " + 
                    error.toString() + " <- ");
            if (socket == null) listModel.addElement("socket is null");
            if (dataInputStream == null) listModel.addElement("dataInputStream is null");
            if (dataOutputStream == null) listModel.addElement("dataOutputStream is null");          
        }
    }
    
    
    private ServerSocket getAvailablePort() {
        for (int port : PORTS) {
            try {
                ServerSocket s = new ServerSocket(port);
                listModel.addElement("Server started listening on port: " + 
                        s.getLocalPort());
                return s;
            } 
            catch (IOException ex) {
                listModel.addElement("port " + port + " not available!");
                continue; 
            }
        }
        listModel.addElement("no free port found");
        return null;
    }

}
