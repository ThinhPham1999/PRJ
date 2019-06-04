
package model;

import java.sql.*;

import java.util.ArrayList;
import java.util.Vector;
import static model.DatabaseInfo.dbURL;
import static model.DatabaseInfo.driverName;
import static model.DatabaseInfo.passDB;
import static model.DatabaseInfo.userDB;

public class BookDB {
 //--------------------------------------------------------------------
    public static Book getBook(String bid){
        Book result = null;
        try{
            Class.forName(driverName);
            Connection con = DriverManager.getConnection(dbURL, userDB, passDB);
            Statement stmt = con.createStatement();
            ResultSet re = stmt.executeQuery("Select BookId, Title, Author, Category, Keyword from Books where BookId='"+bid+"'");
            if(re.next()){
                result.setBookID(re.getString(1));
                result.setTitle(re.getString(2));
                result.setAuthor(re.getString(3)); 
                result.setCategory(re.getString(4));
                result.setKeyword(re.getString(5));             
            }
            con.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return result;
    }
 //--------------------------------------------------------------------   
    public static ArrayList<Book> searchByCategory(String cat){
        ArrayList<Book> result = new ArrayList<>();
        try{
            Class.forName(driverName);
            Connection con = DriverManager.getConnection(dbURL, userDB, passDB);
            Statement stmt = con.createStatement();
            ResultSet re = stmt.executeQuery("Select BookId, Title, Author, Category, Keyword from Books where Category='"+cat+"'");
            while(re.next()){
                String bookid = re.getString(1);
                String tittle = re.getString(2);
                String author = re.getString(3);
                String category = re.getString(4);
                String keyword = re.getString(5);
                result.add(new Book(bookid, tittle, author, category, keyword));
            }
            con.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return result;
    }
 //-------------------------------------------------------------------- 
    public static ArrayList<Book> searchByKeyword(String key){
        ArrayList<Book> result = new ArrayList<>();
        try{
            Class.forName(driverName);
            Connection con = DriverManager.getConnection(dbURL, userDB, passDB);
            Statement stmt = con.createStatement();
            ResultSet re = stmt.executeQuery("Select BookId, Title, Author, Category, Keyword from Books where Keyword='"+key+"'");
            while(re.next()){
                String bookid = re.getString(1);
                String tittle = re.getString(2);
                String author = re.getString(3);
                String category = re.getString(4);
                String keyword = re.getString(5);
                result.add(new Book(bookid, tittle, author, category, keyword));
            }
            con.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return result;
    }
 //--------------------------------------------------------------------   
    public static void addNewBook(Book b){
        try{
            Class.forName(driverName);
            Connection con = DriverManager.getConnection(dbURL, userDB, passDB);
            PreparedStatement stmt = con.prepareStatement("INSEST INTO Books VALUES(?, ?, ?, ?, ?)");
            stmt.setString(1, b.getBookID());
            stmt.setString(2, b.getTitle());
            stmt.setString(3, b.getAuthor());
            stmt.setString(4, b.getCategory());
            stmt.setString(5, b.getKeyword());
            stmt.execute();
            stmt.close();
            con.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }       
        System.out.println("Add new books successful.");
    }
 //--------------------------------------------------------------------   
    public static Vector<Book> searchByTitle(String title){
        Vector<Book> result = new Vector<>();
        try{
            Class.forName(driverName);
            Connection con = DriverManager.getConnection(dbURL, userDB, passDB);
            Statement stmt = con.createStatement();
            ResultSet re = stmt.executeQuery("Select BookId, Title, Author, Category, Keyword from Books where Title='"+title+"'");
            while(re.next()){
                String bookid = re.getString(1);
                String tittle = re.getString(2);
                String author = re.getString(3);
                String category = re.getString(4);
                String keyword = re.getString(5);
                result.add(new Book(bookid, title, author, category, keyword));
            }
            con.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return result;
    }
 //--------------------------------------------------------------------   
}
