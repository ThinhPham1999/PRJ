
package chatBox;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChatImp extends UnicastRemoteObject implements ChatInterface, Serializable{

    List<String> users = new ArrayList<>();
    List<Message> messages = new ArrayList<>();
    
    public ChatImp() throws RemoteException{
        super();
    }
    
    @Override
    public boolean login(String username) throws RemoteException {
        boolean checExist = false;
        // if user is in list user in chatbox
        for (String user : users) {
            if (username.equals(user)) {
                checExist = true;
                break;
            } else {
                checExist = false;
            }
        }
        // if user is not in the list chatbox
        if (checExist == false) {
            users.add(username);
            Message message = new Message();
            message.setUsername(username);
            message.setMsg(" joined the conversation ");
            message.setType("join");
            //set date send message
            message.setDate(new Date());
            messages.add(message);
            
            return true;
        }else{
            return false;
        } 
    }

    @Override
    public void logout(String username) throws RemoteException {
        users.remove(username);
        Message message = new Message();
        message.setUsername(username);
        message.setMsg(" left the conversation ");
        message.setType("left");
        message.setDate(new Date());
        messages.add(message);
    }

    @Override
    public void sendMessage(Message message) throws RemoteException {
        messages.add(message);
    }

    @Override
    public List<Message> getAllMessages() throws RemoteException {
        for(Message m : messages){
            System.out.println(m.getUsername() + " " + m.getMsg());
        }
        return messages;
    }

    @Override
    public List<String> getAllUsers() throws RemoteException {
        for(String u : users){
            System.out.println(u);
        }
        return users;
    }
    
}
