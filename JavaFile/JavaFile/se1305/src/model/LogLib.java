
package model;

import java.time.LocalDate;

public class LogLib {
    private int logID;
    private LocalDate ngayDat, ngayMuon, ngayPTra, ngayTra;
    private String maNV, userID, bookID;

    public LogLib(int logID, LocalDate ngayDat, LocalDate ngayMuon, LocalDate ngayPTra, LocalDate ngayTra, String maNV, String userID, String bookID) {
        this.logID = logID;
        this.ngayDat = ngayDat;
        this.ngayMuon = ngayMuon;
        this.ngayPTra = ngayPTra;
        this.ngayTra = ngayTra;
        this.maNV = maNV;
        this.userID = userID;
        this.bookID = bookID;
    }

    public LogLib() {
    }

    public int getLogID() {
        return logID;
    }

    public LocalDate getNgayDat() {
        return ngayDat;
    }

    public LocalDate getNgayMuon() {
        return ngayMuon;
    }

    public LocalDate getNgayPTra() {
        return ngayPTra;
    }

    public LocalDate getNgayTra() {
        return ngayTra;
    }

    public String getMaNV() {
        return maNV;
    }

    public String getUserID() {
        return userID;
    }

    public String getBookID() {
        return bookID;
    }

    public void setLogID(int logID) {
        this.logID = logID;
    }

    public void setNgayDat(LocalDate ngayDat) {
        this.ngayDat = ngayDat;
    }

    public void setNgayMuon(LocalDate ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public void setNgayPTra(LocalDate ngayPTra) {
        this.ngayPTra = ngayPTra;
    }

    public void setNgayTra(LocalDate ngayTra) {
        this.ngayTra = ngayTra;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }
    
    
}
