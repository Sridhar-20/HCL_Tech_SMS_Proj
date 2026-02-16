package com.hcl.hcl_sms.model;

import java.sql.Date;

public class PartTimeStudent extends Student {

    private int hours;

    public PartTimeStudent(String f, String l, Date d, int hours) {
        super(f, l, d);
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
