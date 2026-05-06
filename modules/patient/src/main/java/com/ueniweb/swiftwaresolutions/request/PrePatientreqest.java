package com.ueniweb.swiftwaresolutions.request;

import lombok.Data;

@Data
public class PrePatientreqest {

    private String name;

    private String dob;

    private String sex;

    private String admDate;

    private String disdischarged_date;

    @Override
    public String toString() {
        return "PrePatientreqest{" +
                "name='" + name + '\'' +
                ", dob='" + dob + '\'' +
                ", sex='" + sex + '\'' +
                ", admDate='" + admDate + '\'' +
                ", disdischarged_date='" + disdischarged_date + '\'' +
                '}';
    }
}
