package model;

import java.util.ArrayList;
import java.util.Vector;
import static model.DatabaseInfo.*;
import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LogLibDB {
    //---------------------------------------------------------------------------------------

    public static LogLib getLog(int logID) {
        LogLib log = null;
        try {
            Class.forName(driverName);
            Connection con = DriverManager.getConnection(dbURL, userDB, passDB);
            Statement st = con.createStatement();
            ResultSet re = st.executeQuery("Select * from Loglibs where Logid =" + logID);
            while (re.next()) {
                String userId = re.getString(1);
                String bookId = re.getString(2);
                LocalDateTime ngayDat = re.getTimestamp(3).toLocalDateTime();
                LocalDateTime ngayMuon;
                LocalDateTime ngayPTra;
                LocalDateTime ngayTra;
                // if Time in sql is null
                try {
                    ngayMuon = re.getTimestamp(4).toLocalDateTime();
                } catch (Exception ex) {
                    ngayMuon = null;
                }
                try {

                    ngayPTra = re.getTimestamp(5).toLocalDateTime();
                } catch (Exception ex) {

                    ngayPTra = null;
                }
                try {

                    ngayTra = re.getTimestamp(6).toLocalDateTime();
                } catch (Exception ex) {

                    ngayTra = null;
                }
                String maNv = re.getString(7);
                int logId = re.getInt(8);
                log = new LogLib(logId, ngayDat, ngayMuon, ngayPTra, ngayTra, maNv, userId, bookId);
            }
            con.close();
            return log;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    //---------------------------------------------------------------------------------------

    public static void updateLog(LogLib log) {
        try {
            Class.forName(driverName);
            Connection con = DriverManager.getConnection(dbURL, userDB, passDB);
            PreparedStatement st = con.prepareStatement("Update Loglibs set ngaymuon=? , ngayPtra = ? , ngayTra = ? , MaNV = ?  where logID = ?;");
            // set Timestamp to Date in sql
            Timestamp ts = Timestamp.valueOf(log.getNgayMuon());
            st.setTimestamp(1, ts);
            st.setTimestamp(2, Timestamp.valueOf(log.getNgayPTra()));
            try{
                st.setTimestamp(3, Timestamp.valueOf(log.getNgayTra()));
            }catch(Exception ex){
                st.setTimestamp(3, null);
            }
            st.setString(4, log.getMaNV());
            st.setInt(5, log.getLogID());
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //---------------------------------------------------------------------------------------   

    public static ArrayList<LogLib> viewLogByUser(String uid) {
        ArrayList<LogLib> result = new ArrayList<>();
        try {
            Class.forName(driverName);
            Connection con = DriverManager.getConnection(dbURL, userDB, passDB);
            Statement stmt = con.createStatement();
            ResultSet re = stmt.executeQuery("Select UserID, BookID, NgayDat, NgayMuon, NgayPtra, NgayTra, MaNV, LogID from LogLibs where UserID='" + uid + "'");
            while (re.next()) {
                String userid = re.getString(1);
                String bookid = re.getString(2);
                LocalDateTime ngayDat = re.getTimestamp(3).toLocalDateTime();
                LocalDateTime ngayMuon;
                LocalDateTime ngayPTra;
                LocalDateTime ngayTra;
                // set Timestamp to Date in sql
                try {
                    ngayMuon = re.getTimestamp(4).toLocalDateTime();
                } catch (Exception ex) {
                    ngayMuon = null;
                }
                try {
                    ngayPTra = re.getTimestamp(5).toLocalDateTime();
                } catch (Exception ex) {
                    ngayPTra = null;
                }
                try {
                    ngayTra = re.getTimestamp(6).toLocalDateTime();
                } catch (Exception ex) {
                    ngayTra = null;
                }
                String maNV = re.getString(7);
                int logid = re.getInt(8);
                result.add(new LogLib(logid, ngayDat, ngayMuon, ngayPTra, ngayTra, maNV, userid, bookid));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
    //---------------------------------------------------------------------------------------   

    public static void deleteLog(int logid) {
        try {
            Class.forName(driverName);
            Connection con = DriverManager.getConnection(dbURL, userDB, passDB);
            PreparedStatement stmt = con.prepareStatement("Delete from LogLibs where LogID=?");
            stmt.setInt(1, logid);
            stmt.executeUpdate();
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
