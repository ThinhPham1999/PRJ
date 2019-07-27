/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import model.Student;

/**
 *
 * @author Thinh
 */
public interface StudentManagerInterface extends Remote{
    public ArrayList<Student> getAllStudent() throws RemoteException;
    public Student addStudent(Student st) throws RemoteException;
}
