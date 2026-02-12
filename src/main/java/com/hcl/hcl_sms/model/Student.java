package model;

import java.sql.Date;

public abstract class Student {

    protected String firstName;
    protected String lastName;
    protected Date joiningDate;

    public Student(String firstName, String lastName, Date joiningDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.joiningDate = joiningDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public abstract String getStudentType();
}
