/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import static model.DatabaseInfo.dbURL;
import static model.DatabaseInfo.driverName;
import static model.DatabaseInfo.passDB;
import static model.DatabaseInfo.userDB;

/**
 *
 * @author Thinh
 */
public class StudentDB {
    public static String addNewStudent(String code, String name, Date dateOfBirth, int gender){
        try{
            Class.forName(driverName);
            Connection con = DriverManager.getConnection(dbURL, userDB, passDB);
            PreparedStatement stmt = con.prepareStatement("INSERT INTO Student VALUES(?, ?, ?, ?)");
            stmt.setString(1, code);
            stmt.setString(2, name);
            stmt.setDate(3, new java.sql.Date(dateOfBirth.getTime()));
            stmt.setInt(4, gender);
            stmt.execute();
            stmt.close();
            con.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }       
        return "";
    }
    
    public static ArrayList<Student> displayAllStudents() {
        ArrayList<Student> result = new ArrayList<>();
        try {
            Class.forName(driverName);
            Connection con = DriverManager.getConnection(dbURL, userDB, passDB);
            Statement stmt = con.createStatement();
            ResultSet re = stmt.executeQuery("Select sCode, sName, sDoB, sGender from Student");
            while (re.next()) {
                String code = re.getString(1);
                String name = re.getString(2);
                Date dateOfBirth = re.getDate(3);
                int gender = re.getInt(4);
                result.add(new Student(code, name, dateOfBirth, gender));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
    
    public static Student getStudent(String newcode){
        Student student=null;
        try {
            // Step 1: Load driver
            Class.forName(driverName);
            Connection con = DriverManager.getConnection(dbURL,userDB,passDB);
            // Step 3: Create Statment
            Statement stmt= con.createStatement(); 
            // Step 4: Execute Stament 
            ResultSet rs=stmt.executeQuery("Select sCode, sName, sDoB, sGender from Student where sCode='"+newcode+"'"); 
            // Step 5: Process Result
            if(rs.next()){
                String code=rs.getString(1); // == fullName
                String name=rs.getString(2);  // == email
                Date dateOfBirth = rs.getDate(3); // == password
                int gender = rs.getInt(4);
                student = new Student(code, name, dateOfBirth, gender);
            }
             // Step 6: Close connection
            con.close();
            return student;
        } catch (Exception ex) {// Throws Exception Sql 
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
