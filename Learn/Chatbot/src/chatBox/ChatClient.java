package chatBox;

import View.Welcome;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ChatClient {

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1088);
            ChatInterface chat = (ChatInterface) registry.lookup("Chatbox");  //getting a remote reference       
            new Welcome(chat);  //pass the reference as a parameter 

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
