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

    public static Book getBook(String bid) {
        try {
            Class.forName(driverName);
            Connection con = DriverManager.getConnection(dbURL, userDB, passDB);
            // Step 3: Create Statement
            Statement stmt = con.createStatement();
            // Step 4: Exceute Statement
            ResultSet rs = stmt.executeQuery("Select BookID, Title, Author, Category, Keyword from Books where BookID='"+bid+"'");
            // Step 5: Process Result
            if (rs.next()) {
                String bookid = rs.getString(1);
                String tittle = rs.getString(2);
                String auhor = rs.getString(3);
                String category = rs.getString(4);
                String keyword = rs.getString(5);
                Book book = new Book(bookid, tittle, auhor, category, keyword);
                return book;
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    //--------------------------------------------------------------------   

    public static ArrayList<Book> searchByCategory(String cat) {
        ArrayList<Book> result = new ArrayList<>();
        try {
            Class.forName(driverName);
            Connection con = DriverManager.getConnection(dbURL, userDB, passDB);
            Statement stmt = con.createStatement();
            ResultSet re = stmt.executeQuery("Select BookId, Title, Author, Category, Keyword from Books where Category='" + cat + "'");
            while (re.next()) {
                String bookid = re.getString(1);
                String tittle = re.getString(2);
                String author = re.getString(3);
                String category = re.getString(4);
                String keyword = re.getString(5);
                result.add(new Book(bookid, tittle, author, category, keyword));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
    //-------------------------------------------------------------------- 

    public static ArrayList<Book> searchByKeyword(String key) {
        ArrayList<Book> result = new ArrayList<>();
        try {
            Class.forName(driverName);
            Connection con = DriverManager.getConnection(dbURL, userDB, passDB);
            Statement stmt = con.createStatement();
            ResultSet re = stmt.executeQuery("Select BookId, Title, Author, Category, Keyword from Books where Keyword='" + key + "'");
            while (re.next()) {
                String bookid = re.getString(1);
                String tittle = re.getString(2);
                String author = re.getString(3);
                String category = re.getString(4);
                String keyword = re.getString(5);
                result.add(new Book(bookid, tittle, author, category, keyword));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
    //--------------------------------------------------------------------   

    public static void addNewBook(Book b) {
        try {
            Class.forName(driverName);
            Connection con = DriverManager.getConnection(dbURL, userDB, passDB);
            PreparedStatement stmt = con.prepareStatement("INSERT INTO Books VALUES(?, ?, ?, ?, ?)");
            stmt.setString(1, b.getBookID());
            stmt.setString(2, b.getTitle());
            stmt.setString(3, b.getAuthor());
            stmt.setString(4, b.getCategory());
            stmt.setString(5, b.getKeyword());
            stmt.execute();
            stmt.close();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("Add new books successful.");
    }
    //--------------------------------------------------------------------   

    public static ArrayList<Book> searchByTitle(String title) {
        ArrayList<Book> result = new ArrayList<>();
        try {
            Class.forName(driverName);
            Connection con = DriverManager.getConnection(dbURL, userDB, passDB);
            Statement stmt = con.createStatement();
            ResultSet re = stmt.executeQuery("Select BookId, Title, Author, Category, Keyword from Books where Title='" + title + "'");
            while (re.next()) {
                String bookid = re.getString(1);
                String tittle = re.getString(2);
                String author = re.getString(3);
                String category = re.getString(4);
                String keyword = re.getString(5);
                result.add(new Book(bookid, tittle, author, category, keyword));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
    //--------------------------------------------------------------------   

    public static ArrayList<Book> displayAllBooks() {
        ArrayList<Book> result = new ArrayList<>();
        try {
            Class.forName(driverName);
            Connection con = DriverManager.getConnection(dbURL, userDB, passDB);
            Statement stmt = con.createStatement();
            ResultSet re = stmt.executeQuery("Select BookId, Title, Author, Category, Keyword from Books");
            while (re.next()) {
                String bookid = re.getString(1);
                String tittle = re.getString(2);
                String author = re.getString(3);
                String category = re.getString(4);
                String keyword = re.getString(5);
                result.add(new Book(bookid, tittle, author, category, keyword));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
}
