/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import static rmi.DatabaseInfo.dbURL;
import static rmi.DatabaseInfo.driverName;
import static rmi.DatabaseInfo.passDB;
import static rmi.DatabaseInfo.userDB;

/**
 *
 * @author Thinh
 */
public class ProductDB {
    public static String newProduct(String id, String name, String unit, int price){
        try{
            Class.forName(driverName);
            Connection con = DriverManager.getConnection(dbURL, userDB, passDB);
            PreparedStatement stmt = con.prepareStatement("INSERT INTO Product_DE130111 VALUES(?, ?, ?, ?)");
            stmt.setString(1, id);
            stmt.setString(2, name);
            stmt.setString(3, unit);
            stmt.setInt(4, price);
            stmt.execute();
            stmt.close();
            con.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }       
        return "";
    }
    
    public static ArrayList<Product> getAll() {
        ArrayList<Product> result = new ArrayList<>();
        try {
            Class.forName(driverName);
            Connection con = DriverManager.getConnection(dbURL, userDB, passDB);
            Statement stmt = con.createStatement();
            ResultSet re = stmt.executeQuery("Select sProduct_ID, sProduct_Name, sUnit, sPrice from Product_DE130111");
            while (re.next()) {
                String code = re.getString(1);
                String name = re.getString(2);
                String unit = re.getString(3);
                int price = re.getInt(4);
                result.add(new Product(code, name, unit, price));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
    
    public static Product getProduct(String newid){
        Product product=null;
        try {
            // Step 1: Load driver
            Class.forName(driverName);
            Connection con = DriverManager.getConnection(dbURL,userDB,passDB);
            // Step 3: Create Statment
            Statement stmt= con.createStatement(); 
            // Step 4: Execute Stament 
            ResultSet rs=stmt.executeQuery("Select sProduct_ID, sProduct_Name, sUnit, sPrice from Product_DE130111 where sProduct_ID='"+newid+"'"); 
            // Step 5: Process Result
            if(rs.next()){
                String code=rs.getString(1); 
                String name=rs.getString(2);  
                String unit = rs.getString(3);
                int price = rs.getInt(4);
                product = new Product(code, name, unit, price);
            }
             // Step 6: Close connection
            con.close();
            return product;
        } catch (Exception ex) {// Throws Exception Sql 
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
