package com.ueniweb.swiftwaresolutions.data;

import lombok.Data;

@Data
public class PrePatientData {

    private String name;

    private String dob;

    private String sex;

    private String admDate;

    private String dDate;

    private String displayNumber;

    public PrePatientData(final String name, final String dob, final String sex, final String admDate, final String dDate, final String displayNumber){

        this.name=name;

        this.dob=dob;

        this.sex=sex;

         this.admDate=admDate;

        this.dDate=dDate;

        this.displayNumber=displayNumber;
    }
    public static PrePatientData createNewInstance(final String name, final String dob, final String sex, final String admDate, final String dDate,final String displayNumber) {
        return new PrePatientData( name, dob, sex, admDate, dDate,displayNumber);
    }
}
