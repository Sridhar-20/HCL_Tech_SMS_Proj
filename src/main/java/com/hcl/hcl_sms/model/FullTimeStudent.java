package com.hcl.hcl_sms.model;

import java.sql.Date;

public class FullTimeStudent extends Student {

    private double fees;

    public FullTimeStudent(String f, String l, Date d, double fees) {
        super(f, l, d);
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
