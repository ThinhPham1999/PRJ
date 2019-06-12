
package model;

import java.time.LocalDateTime;

public class LogLib {
    private int logID;
    private LocalDateTime ngayDat, ngayMuon, ngayPTra, ngayTra;
    private String maNV, userID, bookID;

    public LogLib(int logID, LocalDateTime ngayDat, LocalDateTime ngayMuon, LocalDateTime ngayPTra, LocalDateTime ngayTra, String maNV, String userID, String bookID) {
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
        maNV = "";
    }

    public int getLogID() {
        return logID;
    }

    public LocalDateTime getNgayDat() {
        return ngayDat;
    }

    public LocalDateTime getNgayMuon() {
        return ngayMuon;
    }

    public LocalDateTime getNgayPTra() {
        return ngayPTra;
    }

    public LocalDateTime getNgayTra() {
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

    public void setNgayDat(LocalDateTime ngayDat) {
        this.ngayDat = ngayDat;
    }

    public void setNgayMuon(LocalDateTime ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public void setNgayPTra(LocalDateTime ngayPTra) {
        this.ngayPTra = ngayPTra;
    }

    public void setNgayTra(LocalDateTime ngayTra) {
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
    
    public boolean isBorrow(){
        if (maNV == null){
            return false;
        }
        return true;
    }
    
    public boolean isReturn(){
        if (ngayTra == null){
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "LogLib{" + "logID=" + logID + ", ngayDat=" + ngayDat.toString() + ", ngayMuon=" + ngayMuon.toString() + ", ngayPTra=" + ngayPTra.toString() + ", ngayTra=" + ngayTra.toString() + ", maNV=" + maNV + ", userID=" + userID + ", bookID=" + bookID + '}';
    }
    
    
}
