
package se1305;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.*;

public class DemoJDBC {
    public static void main(String[] a){
//        User updateuser = new User("U0001", "Van", "a@c.d", "012345", "BT", 1);
//        UserDB.updateUser(updateuser);
//        UserDB.doBookOrder("U0001", "B0001");
        ArrayList<Book> listBook = BookDB.searchByCategory("Lập trình");
        for (Book book : listBook){
            System.out.println(book);
        }
         
    }
    
    public static void demo(){
        try { 
            //Step 1:  Load driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
            // Step 2: Create Connection
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=FuLib;","Book","21051999"); 
            // Step 3: Create Statement
            Statement stmt= con.createStatement(); 
            // Step 4: Exceute Statement
            ResultSet rs=stmt.executeQuery("Select BookID, Title from Books where BookID='B0001'"); 
            // Step 5: Process Result
            if(rs.next()){
                String bID=rs.getString(1);
                String bName=rs.getString(2);
                System.out.println(bID+" - "+bName);
            } 
            // Step 6: Close Connection
            con.close(); 
        } catch (Exception ex) {// Throw Exception 
            Logger.getLogger(DemoJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}