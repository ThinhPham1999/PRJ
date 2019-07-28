
package rmi;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;





public class StudentManagerImp extends UnicastRemoteObject implements StudentManagerInterface, Serializable{
    ArrayList<Student> listStudent = new ArrayList<>();

    public StudentManagerImp() throws RemoteException {
        super();
    }
  
    @Override
    public ArrayList<Student> getAllStudent() throws RemoteException {
        return StudentDB.displayAllStudents();
    }

    @Override
    public String addStudent(Student st) throws RemoteException {
        return model.StudentDB.addNewStudent(st.getCode(), st.getName(), st.getDateOfBirth(), st.getGender());
    }
    
    
}
