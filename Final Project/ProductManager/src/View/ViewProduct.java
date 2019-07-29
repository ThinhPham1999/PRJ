/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import rmi.Product;
import rmi.ProductDB;
import java.util.ArrayList;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import model.*;

/**
 *
 * @author Thinh
 */
public class ViewProduct extends javax.swing.JPanel {

    DefaultTableModel dtb = new DefaultTableModel();
    
    public ViewProduct() {
        initComponents();
        ArrayList<Product> array = ProductDB.getAll();
        dtb = (DefaultTableModel) tb_Product.getModel();
        for (int i = 0; i < array.size(); i++) {
            dtb.addRow(new Object[]{
                i , array.get(i).getId(), array.get(i).getName(),array.get(i).getUnit(),array.get(i).getPrice()
            });
        }
        tb_Product.setModel(dtb);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Sp_ViewProduct = new javax.swing.JScrollPane();
        tb_Product = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        bt_add = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        tb_Product.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Product ID", "Product Name", "Unit", "Price"
            }
        ));
        Sp_ViewProduct.setViewportView(tb_Product);

        add(Sp_ViewProduct, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new java.awt.BorderLayout());

        bt_add.setText("Add new Student");
        bt_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_addActionPerformed(evt);
            }
        });
        jPanel1.add(bt_add, java.awt.BorderLayout.CENTER);

        add(jPanel1, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_addActionPerformed
        P_AddNewProduct add = new P_AddNewProduct();
        MainFrame newFrame = (MainFrame)SwingUtilities.getWindowAncestor(this);
        this.setVisible(false);
        newFrame.getContentPane().add(add);
        newFrame.pack();
    }//GEN-LAST:event_bt_addActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane Sp_ViewProduct;
    private javax.swing.JButton bt_add;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTable tb_Product;
    // End of variables declaration//GEN-END:variables
}
