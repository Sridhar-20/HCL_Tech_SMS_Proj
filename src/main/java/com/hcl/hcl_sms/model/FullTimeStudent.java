package model;

import java.sql.Date;

public class FullTimeStudent extends Student {

    private double fees;

    public FullTimeStudent(String firstName, String lastName,
            Date joiningDate, double fees) {
        super(firstName, lastName, joiningDate);
        this.fees = fees;
    }

    public double getFees() {
        return fees;
    }

    @Override
    public String getStudentType() {
        return "FULL_TIME";
    }
}
