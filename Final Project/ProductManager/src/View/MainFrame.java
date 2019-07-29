/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import javax.swing.JOptionPane;

/**
 *
 * @author Thinh
 */
public class MainFrame extends javax.swing.JFrame{

    /**
     * Creates new form MainFrame
     */
    Thread thread;

    public MainFrame() {
        initComponents();
        ViewProduct home = new ViewProduct();
        this.getContentPane().add(home);
        thread = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 100; i >= 0; i--) {
                    try {
                        Thread.sleep(1000);
                        lb_title.setText("Product Manager       Time: " + i);
                        if (i == 0) {
                            int dialogButton = JOptionPane.YES_NO_OPTION;
                            int dialogResult = JOptionPane.showConfirmDialog(null, "Do you want to continue ? ", "Title on Box", dialogButton);
                            if (dialogResult == 0) {
                                i = 100;

                            } else {
                                System.exit(0);

                            }
                        }
                    } catch (InterruptedException ex) {

                    }
                }
            }
        });
        thread.start();
        this.pack();
    }
    
    public void setlb(){
        for (int i = 100; i <= 0; i--){
                    //lb_title.setText("Manage Student " + i);
                    System.out.println(i);
                } 
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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {      
                MainFrame a = new MainFrame();
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
