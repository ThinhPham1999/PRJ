
package se1305;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.*;


public class DemoJDBC {
    public static void main(String[] a){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=FuLib;","Book","21051999");
            Statement stmt= con.createStatement();
            ResultSet rs=stmt.executeQuery("Select BookID, Title from Books where BookID='B0001'");
            if(rs.next()){
                String bID=rs.getString(1);
                String bName=rs.getString(2);
                System.out.println(bID+" - "+bName);
            }
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(DemoJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}