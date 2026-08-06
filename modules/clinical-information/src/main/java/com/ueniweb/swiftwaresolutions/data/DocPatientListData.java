package com.ueniweb.swiftwaresolutions.data;

import lombok.Data;

@Data
public class DocPatientListData {

    private String displayNumber;
    private String patientName;
    private String entDateTime;
    private String doctorName;
    private String referDoctor;
    private String contactNumber;
    private String age;
    private String status;

    public DocPatientListData(String displayNumber, String patientName, String entDateTime,
                               String doctorName, String referDoctor, String contactNumber,
                               String age, String status) {
        this.displayNumber = displayNumber;
        this.patientName = patientName;
        this.entDateTime = entDateTime;
        this.doctorName = doctorName;
        this.referDoctor = referDoctor;
        this.contactNumber = contactNumber;
        this.age = age;
        this.status = status;
    }

    public static DocPatientListData newInstance(final String displayNumber, final String patientName,
                                                  final String entDateTime, final String doctorName,
                                                  final String referDoctor, final String contactNumber,
                                                  final String age, final String status) {
        return new DocPatientListData(displayNumber, patientName, entDateTime, doctorName,
                referDoctor, contactNumber, age, status);
    }
}
