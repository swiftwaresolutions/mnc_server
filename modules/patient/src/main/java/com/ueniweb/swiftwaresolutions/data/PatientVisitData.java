package com.ueniweb.swiftwaresolutions.data;

import lombok.Data;

import java.util.Date;


@Data
public class PatientVisitData {

    private Long visitId;

    private String date;

    private String doctorName;

    private String departmentName;

    public PatientVisitData(Long visitId,String date, String doctorName, String departmentName) {
        this.visitId = visitId;
        this.date = date;
        this.doctorName = doctorName;
        this.departmentName = departmentName;
    }

    public static PatientVisitData newInstance( Long visitId,String date, String doctorName, String departmentName) {
        return new PatientVisitData(visitId,date, doctorName, departmentName);
    }

}
