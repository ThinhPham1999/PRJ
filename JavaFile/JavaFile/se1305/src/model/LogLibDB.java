package model;

import java.util.ArrayList;
import java.util.Vector;
import static model.DatabaseInfo.*;
import java.sql.*;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LogLibDB {
    //---------------------------------------------------------------------------------------

    public static LogLib getLog(int logID) {
        LogLib newLogLib = null;
        try {
            Class.forName(driverName);
            Connection con = DriverManager.getConnection(dbURL);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select UserID, BookId, NgayDat, NgayMuon, NgayPTra, NgayTra, MaNV, LogID from LogLibs where LogID ='" + logID + "'");
            if (rs.next()) {
                String userID = rs.getString(1);
                String bookID = rs.getString(2);
                LocalDate ngayDat = rs.getDate(3).toLocalDate();
                LocalDate ngayMuon = rs.getDate(4).toLocalDate();
                LocalDate ngayPTra = rs.getDate(5).toLocalDate();
                LocalDate ngayTra = rs.getDate(6).toLocalDate();
                String maNV = rs.getString(7);
                int logid = rs.getInt(8);
                newLogLib = new LogLib(logid, ngayDat, ngayMuon, ngayPTra, ngayTra, maNV, userID, bookID);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newLogLib;
    }
    //---------------------------------------------------------------------------------------

    public static boolean updateLog(LogLib log) {
        try{
            Class.forName(driverName);
            Connection con = DriverManager.getConnection(dbURL);
            PreparedStatement stmt = con.prepareStatement("Update LogLibs set UserID=?, BookID=?, NgayDat=?, NgayMuon=?, NgayPTra=?, NgayTra=?, MANV=? where LogID=?");
            stmt.setString(1, log.getUserID());
            stmt.setString(2, log.getBookID());
            stmt.setDate(3, Date.valueOf(log.getNgayDat()));
            stmt.setDate(4, Date.valueOf(log.getNgayMuon()));
            stmt.setDate(5, Date.valueOf(log.getNgayPTra()));
            stmt.setDate(6, Date.valueOf(log.getNgayTra()));
            stmt.setString(7, log.getMaNV());
            int rs = stmt.executeUpdate();
            con.close();
            return rs == 1;
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    }
    //---------------------------------------------------------------------------------------

    public static int writeLog(LogLib log) {

        return -1;
    }
    //---------------------------------------------------------------------------------------   

    public static Vector<Vector> viewLogByUser(String uid) {
        return null;
    }
    //---------------------------------------------------------------------------------------   

    public static ArrayList<LogLib> getLogsByUser(String uid) {
        return null;
    }
}
