
package model;

import java.time.LocalDate;
import java.util.Calendar;

public class User {
    private String userID,fullName,email,password,status;
    private int userRight;

    public User() {    }

    public User(String uid) {
        User s=UserDB.getUser(uid);
        this.userID = s.userID;
        this.fullName = s.fullName;
        this.email = s.email;
        this.password = s.password;
        this.status = s.status;
        this.userRight = s.userRight;
    }
//--------------------------------------------------------------------------    
    public User(String userID, String fullName, String email, String password, String status, int userRight) {
        this.userID = userID;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.status = status;
        this.userRight = userRight;
    }
//--------------------------------------------------------------------------
    public String getUserID() {
        return userID;
    }
//--------------------------------------------------------------------------
    public void setUserID(String userID) {
        this.userID = userID;
    }
//--------------------------------------------------------------------------
    public String getFullName() {
        return fullName;
    }
//--------------------------------------------------------------------------
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
//--------------------------------------------------------------------------
    public String getEmail() {
        return email;
    }
//--------------------------------------------------------------------------
    public void setEmail(String email) {
        this.email = email;
    }
//--------------------------------------------------------------------------
    public String getPassword() {
        return password;
    }
//--------------------------------------------------------------------------
    public void setPassword(String password) {
        this.password = password;
    }
//--------------------------------------------------------------------------
    public String getStatus() {
        return status;
    }
//--------------------------------------------------------------------------
    public void setStatus(String status) {
        this.status = status;
    }
//--------------------------------------------------------------------------
    public int getUserRight() {
        return userRight;
    }
//--------------------------------------------------------------------------
    public void setUserRight(int userRight) {
        this.userRight = userRight;
    }
//------------------------------------------------------------------
    @Override
    public String toString() {
        return userID + " : " + fullName ;
    }
//------------------------------------------------------------------
    public int orderBook(String bid){
        return UserDB.doBookOrder(userID, bid);
    }
//------------------------------------------------------------------
    public static User login(String uid, String pw){
        User s= new User(uid);
        if(s.password.equals(pw) && uid.equals(uid)) return s;
        return null;
    }    
//------------------------------------------------------------------ 
    public boolean logout(){
        return UserDB.updateUser(this);
    }
//------------------------------------------------------------------
    public boolean changeRight(int newright){
        userRight = newright;
        return UserDB.updateUser(this);
    }
//------------------------------------------------------------------
    public boolean changeEmail(String newEmail){
        this.email = newEmail;
        return UserDB.updateUser(this);
    }
//------------------------------------------------------------------   
    public boolean updateStatus(String newStatus){
        this.status = newStatus;
        return UserDB.updateUser(this);
    }
//------------------------------------------------------------------    
    public LocalDate renewBook(String logid){
        return null;
    }
//------------------------------------------------------------------    
    public boolean changePass(String oldP, String newP){
        if(password.equals(oldP)){
            password=newP;
            return UserDB.updateUser(this);
        }
        return false;
    }
//------------------------------------------------------------------    
    public void borrowBook(int logID, String maNV){
        LogLib log = LogLibDB.getLog(logID);
        log.setNgayMuon(LocalDate.now());
        log.setNgayPTra(LocalDate.now().plusDays(30));
        log.setMaNV(maNV);
        LogLibDB.updateLog(log);
    }
    
    public void renewBook(int logID){
        LogLib log = LogLibDB.getLog(logID);
        Calendar c = Calendar.getInstance();
        log.setNgayPTra(log.getNgayPTra().plusDays(15));
    }
    
    public Book returnBook(int logID){
        LogLib log = LogLibDB.getLog(logID);
        Book book = BookDB.getBook(log.getBookID());
        return book;
    }
    
    public void viewLog(){
        ////????????????????
    }
}
