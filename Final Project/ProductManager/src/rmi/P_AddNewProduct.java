/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.RemoteException;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Thinh
 */
public class P_AddNewProduct extends javax.swing.JPanel {

    /**
     * Creates new form P_AddNewStudent
     */
    public P_AddNewProduct() {
        initComponents();
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

        btG_gender = new javax.swing.ButtonGroup();
        P_Controller = new javax.swing.JPanel();
        Bt_Ok = new javax.swing.JButton();
        bt_Cancel = new javax.swing.JButton();
        P_Contain = new javax.swing.JPanel();
        lb_ProductID = new javax.swing.JLabel();
        lb_name = new javax.swing.JLabel();
        lb_Unit = new javax.swing.JLabel();
        lb_Price = new javax.swing.JLabel();
        txt_ProductID = new javax.swing.JTextField();
        txt_name = new javax.swing.JTextField();
        txt_Unit = new javax.swing.JTextField();
        txt_Price = new javax.swing.JTextField();

        setLayout(new java.awt.BorderLayout());

        P_Controller.setLayout(new java.awt.GridBagLayout());

        Bt_Ok.setText("Ok");
        Bt_Ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bt_OkActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(1, 39, 1, 39);
        P_Controller.add(Bt_Ok, gridBagConstraints);

        bt_Cancel.setText("Cancel");
        bt_Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_CancelActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(1, 39, 1, 39);
        P_Controller.add(bt_Cancel, gridBagConstraints);

        add(P_Controller, java.awt.BorderLayout.PAGE_END);

        P_Contain.setLayout(new java.awt.GridBagLayout());

        lb_ProductID.setText("Product ID");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        P_Contain.add(lb_ProductID, gridBagConstraints);

        lb_name.setText("Name");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        P_Contain.add(lb_name, gridBagConstraints);

        lb_Unit.setText("Unit");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        P_Contain.add(lb_Unit, gridBagConstraints);

        lb_Price.setText("Price");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        P_Contain.add(lb_Price, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        P_Contain.add(txt_ProductID, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        P_Contain.add(txt_name, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        P_Contain.add(txt_Unit, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        P_Contain.add(txt_Price, gridBagConstraints);

        add(P_Contain, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_CancelActionPerformed
        P_ViewProduct login = null;
        try {
            login = new P_ViewProduct();
        } catch (RemoteException ex) {
            Logger.getLogger(P_AddNewProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        ProductMangerrClient newFrame = (ProductMangerrClient)SwingUtilities.getWindowAncestor(this);
        this.setVisible(false);
        newFrame.getContentPane().add(login);
        newFrame.pack();
    }//GEN-LAST:event_bt_CancelActionPerformed

    private void Bt_OkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bt_OkActionPerformed
        String newcode = txt_ProductID.getText();
        ProductManagerImp manager = null;
        try {
            manager = new ProductManagerImp();
        } catch (RemoteException ex) {
            Logger.getLogger(P_AddNewProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if (manager.getProduct(newcode)!= null){
                JOptionPane.showMessageDialog(null, "Product is existed.");
                return;
            }
        } catch (RemoteException ex) {
            Logger.getLogger(P_AddNewProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        String id = txt_ProductID.getText();
        String name = txt_name.getText();
        if (id.isEmpty()){
            JOptionPane.showMessageDialog(null, "Id must not empty");
            return;
        }
        if (name.isEmpty()){
            JOptionPane.showMessageDialog(null, "Name must not empty.");
            return;
        }
        
        String unit = txt_Unit.getText();
        String stprice = txt_Price.getText().trim();
        if (stprice.isEmpty()){
            JOptionPane.showMessageDialog(null, "Price must not empty.");
            return;
        }
        int price = 0;
        try{
            price = Integer.parseInt(stprice);
            if (price < 0){
                throw new NumberFormatException();
            }
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Price is a number greater than 0");
            return;
        }
        try {
            manager.addProduct(new Product(id, name, unit, price));
        } catch (RemoteException ex) {
            Logger.getLogger(P_AddNewProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
             
        JOptionPane.showMessageDialog(null, "Add product is sucessful.");
        
        P_ViewProduct viewProduct = null;
        try {
            viewProduct = new P_ViewProduct();
        } catch (RemoteException ex) {
            Logger.getLogger(P_AddNewProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        ProductMangerrClient newFrame = (ProductMangerrClient)SwingUtilities.getWindowAncestor(this);
        this.setVisible(false);
        newFrame.getContentPane().add(viewProduct);
        newFrame.pack();
    }//GEN-LAST:event_Bt_OkActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bt_Ok;
    private javax.swing.JPanel P_Contain;
    private javax.swing.JPanel P_Controller;
    private javax.swing.ButtonGroup btG_gender;
    private javax.swing.JButton bt_Cancel;
    private javax.swing.JLabel lb_Price;
    private javax.swing.JLabel lb_ProductID;
    private javax.swing.JLabel lb_Unit;
    private javax.swing.JLabel lb_name;
    private javax.swing.JTextField txt_Price;
    private javax.swing.JTextField txt_ProductID;
    private javax.swing.JTextField txt_Unit;
    private javax.swing.JTextField txt_name;
    // End of variables declaration//GEN-END:variables
}