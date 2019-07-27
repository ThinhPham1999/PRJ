
package rmi;

import java.awt.List;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import model.*;




public class StudentImp extends UnicastRemoteObject implements StudentManagerInterface, Serializable{
    ArrayList<Student> listStudent = new ArrayList<>();

    public StudentImp() throws RemoteException {
        super();
    }
  
    @Override
    public ArrayList<Student> getAllStudent() throws RemoteException {
        for(Student stu : listStudent){
            System.out.println(stu);
        }
        return listStudent;
    }

    @Override
    public Student addStudent(Student st) throws RemoteException {
        return "";
    }
    
    
}
