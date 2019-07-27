
package model;

import java.util.Date;


public class Student {
    private String code;
    private String name;
    private Date dateOfBirth;
    private int gender;

    public Student() {
    }

    public Student(String code, String name, Date dateOfBirth, int gender) {
        this.code = code;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public int getGender() {
        return gender;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" + "code=" + code + ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + '}';
    }
    
    
}
