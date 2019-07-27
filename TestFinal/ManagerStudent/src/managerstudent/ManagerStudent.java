/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerstudent;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import model.*;
/**
 *
 * @author Thinh
 */
public class ManagerStudent {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        ArrayList<Student> list = new ArrayList<>();
        list = StudentDB.displayAllStudents();
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date doB = formatter.parse("1999-06-12");
        Student student = new Student("S0009", "Long", doB, 2);
        System.out.println(student);
        System.out.println(list);
        StudentDB.addNewStudent("S0009", "Long", doB, 2);
    }
    
}
