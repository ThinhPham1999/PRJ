
package chatBox;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ChatInterface extends Remote{
    public boolean login(String username) throws RemoteException;
    public void logout(String username) throws RemoteException;
    public void sendMessage(Message message) throws RemoteException;
    public List<Message> getAllMessages() throws RemoteException;
    public List<String> getAllUsers() throws RemoteException;
}
