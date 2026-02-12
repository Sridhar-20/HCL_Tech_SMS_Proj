package model;

import java.sql.Date;

public class PartTimeStudent extends Student {

    private int hours;

    public PartTimeStudent(String firstName, String lastName,
                           Date joiningDate, int hours) {
        super(firstName, lastName, joiningDate);
        this.hours = hours;
    }

    public int getHours() {
        return hours;
    }

    @Override
    public String getStudentType() {
        return "PART_TIME";
    }
}
