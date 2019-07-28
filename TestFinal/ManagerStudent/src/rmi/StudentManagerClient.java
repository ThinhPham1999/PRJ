/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import View.*;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Thinh
 */
public class StudentManagerClient extends javax.swing.JFrame{

    /**
     * Creates new form StudentManagerClient
     */
    Thread thread;

    public StudentManagerClient() throws RemoteException {
        initComponents();
        Registry registry = LocateRegistry.getRegistry("localhost", 1088);
        try { 
            StudentManagerInterface chat = (StudentManagerInterface) registry.lookup("StudentManager");
        } catch (NotBoundException ex) {
            Logger.getLogger(StudentManagerClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AccessException ex) {
            Logger.getLogger(StudentManagerClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        P_ViewStudent home = new P_ViewStudent();
        this.getContentPane().add(home);
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 100; i >= 0; i--) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(StudentManagerClient.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    lb_title.setText("Student Manager " + i);
                }
            }
        });
        thread.start();
        this.pack();
    }
    
    private void execute() {
        //setLocationRelativeTo(null);            // to visible the GUI in the middle of the screen
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        refresh();                  // this thread is used to refresh the Manager window by every second 
                    } catch (RemoteException ex) {
                        Logger.getLogger(StudentManagerClient.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {                       
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        System.err.println("Error");
                    }
                }
            }
        });
        t1.start();
    }
    
    public void refresh() throws RemoteException {
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lb_title = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.BorderLayout());
        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.setLayout(new java.awt.BorderLayout());

        lb_title.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lb_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_title.setText("Student Manager 100");
        jPanel2.add(lb_title, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StudentManagerClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentManagerClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentManagerClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentManagerClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {      
                StudentManagerClient a = null;
                try {
                    a = new StudentManagerClient();
                } catch (RemoteException ex) {
                    Logger.getLogger(StudentManagerClient.class.getName()).log(Level.SEVERE, null, ex);
                }
                a.setVisible(true);                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lb_title;
    // End of variables declaration//GEN-END:variables

}
