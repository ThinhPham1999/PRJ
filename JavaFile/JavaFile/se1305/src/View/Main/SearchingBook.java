/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Main;

import static View.Main.Home.useid;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Book;
import model.BookDB;

import static model.DatabaseInfo.dbURL;
import static model.DatabaseInfo.driverName;
import static model.DatabaseInfo.passDB;
import static model.DatabaseInfo.userDB;
import model.UserDB;

/**
 *
 * @author Thinh
 */
public class SearchingBook extends javax.swing.JPanel {

    DefaultTableModel dtb = new DefaultTableModel();
    
    /**
     * Creates new form P_SearchingBook
     */
    public SearchingBook() {
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

        p_Top = new javax.swing.JPanel();
        lb_SearchingBook = new javax.swing.JLabel();
        P_Contant = new javax.swing.JPanel();
        tbp_SearchByKeyWord = new javax.swing.JTabbedPane();
        P_SearchByTittle = new javax.swing.JPanel();
        P_SearchByTittleComand = new javax.swing.JPanel();
        txt_SearchByTittle = new javax.swing.JTextField();
        bt_SearchByTittle = new javax.swing.JButton();
        bt_OrderBookTittle = new javax.swing.JButton();
        SP_SearchByTittle = new javax.swing.JScrollPane();
        tb_SearchByTittle = new javax.swing.JTable();
        P_SearchByKeyword = new javax.swing.JPanel();
        P_SearchByKeywordComand = new javax.swing.JPanel();
        txt_SearchByKeyword = new javax.swing.JTextField();
        bt_SearchByKeyword = new javax.swing.JButton();
        bt_OrderBookKeyword = new javax.swing.JButton();
        SP_SearchByKeyword = new javax.swing.JScrollPane();
        tb_SearchByKeyword = new javax.swing.JTable();
        P_SearchByCategory = new javax.swing.JPanel();
        P_SearchByCategoryComand = new javax.swing.JPanel();
        cb_SearchByCategory = new javax.swing.JComboBox<>();
        bt_SearchByCategory = new javax.swing.JButton();
        bt_OrderBookCategory = new javax.swing.JButton();
        SP_SearchByCategory = new javax.swing.JScrollPane();
        tb_SearchByCategory = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        p_Top.setLayout(new java.awt.BorderLayout());

        lb_SearchingBook.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lb_SearchingBook.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_SearchingBook.setText("Searching Book");
        p_Top.add(lb_SearchingBook, java.awt.BorderLayout.CENTER);

        add(p_Top, java.awt.BorderLayout.PAGE_START);

        P_Contant.setLayout(new java.awt.GridLayout(1, 0));

        P_SearchByTittle.setLayout(new java.awt.BorderLayout());

        P_SearchByTittleComand.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        P_SearchByTittleComand.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        P_SearchByTittleComand.add(txt_SearchByTittle, gridBagConstraints);

        bt_SearchByTittle.setText("Search");
        bt_SearchByTittle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_SearchByTittleActionPerformed(evt);
            }
        });
        P_SearchByTittleComand.add(bt_SearchByTittle, new java.awt.GridBagConstraints());

        bt_OrderBookTittle.setText("Order Book");
        bt_OrderBookTittle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_OrderBookTittleActionPerformed(evt);
            }
        });
        P_SearchByTittleComand.add(bt_OrderBookTittle, new java.awt.GridBagConstraints());

        P_SearchByTittle.add(P_SearchByTittleComand, java.awt.BorderLayout.PAGE_START);

        tb_SearchByTittle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "BookID", "Tittle", "Author", "Category", "Keyword"
            }
        ));
        SP_SearchByTittle.setViewportView(tb_SearchByTittle);

        P_SearchByTittle.add(SP_SearchByTittle, java.awt.BorderLayout.CENTER);

        tbp_SearchByKeyWord.addTab("Search By Tittle", P_SearchByTittle);

        P_SearchByKeyword.setLayout(new java.awt.BorderLayout());

        P_SearchByKeywordComand.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        P_SearchByKeywordComand.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        P_SearchByKeywordComand.add(txt_SearchByKeyword, gridBagConstraints);

        bt_SearchByKeyword.setText("Search");
        bt_SearchByKeyword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_SearchByKeywordActionPerformed(evt);
            }
        });
        P_SearchByKeywordComand.add(bt_SearchByKeyword, new java.awt.GridBagConstraints());

        bt_OrderBookKeyword.setText("Order Book");
        bt_OrderBookKeyword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_OrderBookKeywordActionPerformed(evt);
            }
        });
        P_SearchByKeywordComand.add(bt_OrderBookKeyword, new java.awt.GridBagConstraints());

        P_SearchByKeyword.add(P_SearchByKeywordComand, java.awt.BorderLayout.PAGE_START);

        tb_SearchByKeyword.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "BookID", "Tittle", "Author", "Category", "Keyword"
            }
        ));
        SP_SearchByKeyword.setViewportView(tb_SearchByKeyword);

        P_SearchByKeyword.add(SP_SearchByKeyword, java.awt.BorderLayout.CENTER);

        tbp_SearchByKeyWord.addTab("Search By Keyword", P_SearchByKeyword);

        P_SearchByCategory.setLayout(new java.awt.BorderLayout());

        P_SearchByCategoryComand.setLayout(new java.awt.GridBagLayout());

        try{
            Class.forName(driverName);
            Connection con = DriverManager.getConnection(dbURL, userDB, passDB);
            Statement stmt = con.createStatement();
            ResultSet re = stmt.executeQuery("Select DISTINCT Category from Books");
            while(re.next()){
                String category = re.getString(1);
                cb_SearchByCategory.addItem(category);
            }
            con.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        P_SearchByCategoryComand.add(cb_SearchByCategory, gridBagConstraints);

        bt_SearchByCategory.setText("Search");
        bt_SearchByCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_SearchByCategoryActionPerformed(evt);
            }
        });
        P_SearchByCategoryComand.add(bt_SearchByCategory, new java.awt.GridBagConstraints());

        bt_OrderBookCategory.setText("Order Book");
        bt_OrderBookCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_OrderBookCategoryActionPerformed(evt);
            }
        });
        P_SearchByCategoryComand.add(bt_OrderBookCategory, new java.awt.GridBagConstraints());

        P_SearchByCategory.add(P_SearchByCategoryComand, java.awt.BorderLayout.PAGE_START);

        tb_SearchByCategory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "BookID", "Tittle", "Author", "Category", "Keyword"
            }
        ));
        SP_SearchByCategory.setViewportView(tb_SearchByCategory);

        P_SearchByCategory.add(SP_SearchByCategory, java.awt.BorderLayout.CENTER);

        tbp_SearchByKeyWord.addTab("Search By Category", P_SearchByCategory);

        P_Contant.add(tbp_SearchByKeyWord);

        add(P_Contant, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_SearchByTittleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_SearchByTittleActionPerformed
        String tittle = txt_SearchByTittle.getText();
        ArrayList<Book> array = BookDB.searchByTitle(tittle);
        dtb = (DefaultTableModel) tb_SearchByTittle.getModel();
        dtb.setRowCount(0);
        for (int i = 0; i < array.size(); i++) {
            dtb.addRow(new Object[]{
                i , array.get(i).getBookID() , array.get(i).getTitle(),array.get(i).getAuthor(),array.get(i).getCategory(),array.get(i).getKeyword()
            });
        }
        tb_SearchByTittle.setModel(dtb);
    }//GEN-LAST:event_bt_SearchByTittleActionPerformed

    private void bt_SearchByKeywordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_SearchByKeywordActionPerformed
        String keyword = txt_SearchByKeyword.getText();
        ArrayList<Book> array = BookDB.searchByKeyword(keyword);
        dtb = (DefaultTableModel) tb_SearchByKeyword.getModel();
        dtb.setRowCount(0);
        for (int i = 0; i < array.size(); i++) {
            dtb.addRow(new Object[]{
                i , array.get(i).getBookID() , array.get(i).getTitle(),array.get(i).getAuthor(),array.get(i).getCategory(),array.get(i).getKeyword()
            });
        }
        tb_SearchByKeyword.setModel(dtb);
    }//GEN-LAST:event_bt_SearchByKeywordActionPerformed

    private void bt_SearchByCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_SearchByCategoryActionPerformed
        String category = (String)cb_SearchByCategory.getSelectedItem();
        System.out.println(category);
        ArrayList<Book> array = BookDB.searchByCategory(category);
        dtb = (DefaultTableModel) tb_SearchByCategory.getModel();
        dtb.setRowCount(0);
        for (int i = 0; i < array.size(); i++) {
            dtb.addRow(new Object[]{
                i , array.get(i).getBookID() , array.get(i).getTitle(),array.get(i).getAuthor(),array.get(i).getCategory(),array.get(i).getKeyword()
            });
        }
        tb_SearchByCategory.setModel(dtb);
    }//GEN-LAST:event_bt_SearchByCategoryActionPerformed

    private void bt_OrderBookTittleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_OrderBookTittleActionPerformed
        int row = tb_SearchByTittle.getSelectedRow();
        if (row == -1){
            JOptionPane.showMessageDialog(null, "Please choose book first.");
            return;
        }

        String bookid = (String)tb_SearchByTittle.getValueAt(row, 1);
        System.out.println(bookid);
        UserDB.getUser(useid).orderBook(bookid);
        JOptionPane.showMessageDialog(null, "Order Book sucessful.");
    }//GEN-LAST:event_bt_OrderBookTittleActionPerformed

    private void bt_OrderBookKeywordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_OrderBookKeywordActionPerformed
        int row = tb_SearchByKeyword.getSelectedRow();
        if (row == -1){
            JOptionPane.showMessageDialog(null, "Please choose book first.");
            return;
        }

        String bookid = (String)tb_SearchByKeyword.getValueAt(row, 1);
        System.out.println(bookid);
        UserDB.getUser(useid).orderBook(bookid);
        JOptionPane.showMessageDialog(null, "Order Book sucessful.");
    }//GEN-LAST:event_bt_OrderBookKeywordActionPerformed

    private void bt_OrderBookCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_OrderBookCategoryActionPerformed
        int row = tb_SearchByCategory.getSelectedRow();
        if (row == -1){
            JOptionPane.showMessageDialog(null, "Please choose book first.");
            return;
        }

        String bookid = (String)tb_SearchByCategory.getValueAt(row, 1);
        System.out.println(bookid);
        UserDB.getUser(useid).orderBook(bookid);
        JOptionPane.showMessageDialog(null, "Order Book sucessful.");
    }//GEN-LAST:event_bt_OrderBookCategoryActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel P_Contant;
    private javax.swing.JPanel P_SearchByCategory;
    private javax.swing.JPanel P_SearchByCategoryComand;
    private javax.swing.JPanel P_SearchByKeyword;
    private javax.swing.JPanel P_SearchByKeywordComand;
    private javax.swing.JPanel P_SearchByTittle;
    private javax.swing.JPanel P_SearchByTittleComand;
    private javax.swing.JScrollPane SP_SearchByCategory;
    private javax.swing.JScrollPane SP_SearchByKeyword;
    private javax.swing.JScrollPane SP_SearchByTittle;
    private javax.swing.JButton bt_OrderBookCategory;
    private javax.swing.JButton bt_OrderBookKeyword;
    private javax.swing.JButton bt_OrderBookTittle;
    private javax.swing.JButton bt_SearchByCategory;
    private javax.swing.JButton bt_SearchByKeyword;
    private javax.swing.JButton bt_SearchByTittle;
    private javax.swing.JComboBox<String> cb_SearchByCategory;
    private javax.swing.JLabel lb_SearchingBook;
    private javax.swing.JPanel p_Top;
    private javax.swing.JTable tb_SearchByCategory;
    private javax.swing.JTable tb_SearchByKeyword;
    private javax.swing.JTable tb_SearchByTittle;
    private javax.swing.JTabbedPane tbp_SearchByKeyWord;
    private javax.swing.JTextField txt_SearchByKeyword;
    private javax.swing.JTextField txt_SearchByTittle;
    // End of variables declaration//GEN-END:variables
}
