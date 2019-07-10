
package chatBox;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChatServer {
    public static void main(String[] args){
        try{
            System.out.println("Server starting...");
            // Create port 1088
            Registry registry = LocateRegistry.createRegistry(1088);
            // Create remote object and register it
            registry.rebind("Chatbox", new ChatImp());
            System.out.println("Server started...");
        }catch(RemoteException ex){
            Logger.getLogger(ChatServer.class.getName()).log(Level.SEVERE, null, ex);
        }catch(Exception ex){
            Logger.getLogger(ChatServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
