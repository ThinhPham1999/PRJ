/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import chatBox.ChatInterface;
import chatBox.Message;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author Thinh
 */
public class Chat extends javax.swing.JFrame implements MouseListener, KeyListener {

    String user;
    ChatInterface chat;
    List<Message> msgs = new ArrayList<>();
    List<String> users = new ArrayList<>();
    /**
     * Creates new form Chat
     */
    public Chat(ChatInterface chat, String user) throws RemoteException{
        initComponents();
        this.chat = chat;
        this.user = user;
        chat.login(user);
        execute();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        SP_OnlineUser = new javax.swing.JScrollPane();
        txt_ListUsers = new javax.swing.JTextArea();
        lb_Online = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lb_name = new javax.swing.JLabel();
        bt_logout = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_Chat = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        txt_send = new javax.swing.JTextField();
        bt_send = new javax.swing.JButton();

        setSize(new java.awt.Dimension(500, 600));

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_ListUsers.setEditable(false);
        txt_ListUsers.setColumns(20);
        txt_ListUsers.setRows(5);
        SP_OnlineUser.setViewportView(txt_ListUsers);

        jPanel1.add(SP_OnlineUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 80, 260));

        lb_Online.setText("Online User");
        jPanel1.add(lb_Online, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        getContentPane().add(jPanel1, java.awt.BorderLayout.LINE_START);

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel3.setLayout(new java.awt.GridBagLayout());

        lb_name.setText("Name");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 195;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        jPanel3.add(lb_name, gridBagConstraints);

        bt_logout.setText("Logout");
        bt_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_logoutActionPerformed(evt);
            }
        });
        jPanel3.add(bt_logout, new java.awt.GridBagConstraints());

        jPanel2.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        txt_Chat.setEditable(false);
        txt_Chat.setColumns(20);
        txt_Chat.setRows(5);
        jScrollPane2.setViewportView(txt_Chat);

        jPanel2.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel4.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        jPanel4.add(txt_send, gridBagConstraints);

        bt_send.setText("Send");
        bt_send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sendActionPerformed(evt);
            }
        });
        jPanel4.add(bt_send, new java.awt.GridBagConstraints());

        jPanel2.add(jPanel4, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_logoutActionPerformed
        try {
            chat.logout(user);  //use the reference "chat" to call remote methods
            System.exit(0);
            //catch the exceptions may occur, Rubbish URL, RemoteException
        } catch (RemoteException ex) {
            Logger.getLogger(Chat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bt_logoutActionPerformed

    private void bt_sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sendActionPerformed
        sendNewMessage();
    }//GEN-LAST:event_bt_sendActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane SP_OnlineUser;
    private javax.swing.JButton bt_logout;
    private javax.swing.JButton bt_send;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lb_Online;
    private javax.swing.JLabel lb_name;
    private javax.swing.JTextArea txt_Chat;
    private javax.swing.JTextArea txt_ListUsers;
    private javax.swing.JTextField txt_send;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            sendNewMessage();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
    private void execute() {
        txt_ListUsers.setLineWrap(true);     // to remove horizontal scrolling bar   
        setTitle("Public Chat");
        addListeners();      
        this.lb_name.setText(user);
        this.setVisible(true);
        setLocationRelativeTo(null);            // to visible the GUI in the middle of the screen
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    refresh();                  // this thread is used to refresh the chat window by every second 
                    try {                       // to display whole chat list
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Chat.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        t1.start();
    }
    
    public void refresh() {
        try {
            displayChatList();
            displayUserList();
        } catch (RemoteException ex) {
            Logger.getLogger(Chat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void displayChatList() throws RemoteException {
        txt_Chat.setText("");
        msgs = chat.getAllMessages();
        String doc = "\n";
        for (Message m : msgs) {
            if (!((m.getUsername().equals(user)) && (m.getType().equals("join")))) {             
                String smileyName = m.getSmiley();               
                Date date = m.getDate();
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                String a = dateFormat.format(date);
                SimpleDateFormat parseFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                SimpleDateFormat printFormat = new SimpleDateFormat("HH:mm:ss");
                try {
                    Date time = parseFormat.parse(a);
                    if (smileyName == null) {
                        doc +=  
                                printFormat.format(time) 
                                + " " 
                                + m.getUsername() 
                                + "\t " 
                                + m.getMsg() 
                                + "\n";
                    } else {                  
                        doc += "" 
                                + printFormat.format(time) 
                                + " " 
                                + m.getUsername()  
                                + "\t" 
                                + this.getClass().getResource("/images/"+smileyName) 
                                + "\n";
                    }
                } catch (ParseException ex) {
                    Logger.getLogger(Chat.class.getName()).log(Level.SEVERE, null, ex);
                }                        
            }
        }
        doc += "\n";
        txt_Chat.setText(doc);
    }
    
    private void displayUserList() throws RemoteException {
        txt_ListUsers.setText("");
        users = chat.getAllUsers();
        for (String u : users) {
            if (!u.equals(user)) {             
                txt_ListUsers.append(" " + u + "\n");             
            }
        }
    }
    
    private void addListeners() {
        txt_send.addKeyListener(this);
    }
    
    private void sendNewMessage() {
        String inputMessage = txt_send.getText();
        txt_send.setText("");
        Message message = new Message();
        message.setUsername(user);
        message.setMsg(inputMessage);
        message.setType("client");
        message.setDate(new Date());
        try {
            chat.sendMessage(message);
        } catch (RemoteException ex) {
            Logger.getLogger(Chat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
