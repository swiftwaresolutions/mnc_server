package com.ueniweb.swiftwaresolutions.data;

import lombok.Data;

@Data
public class PatientIpData {

    private final String displayNumber;

    private final String ipNo;

    private final Long ipId;

    private final String fullName;

    private final String ward;

    private final String bedNo;

    private final String admissionDate;

    private final Long visitId;

    private final Long patientId;

    private final String age;

    private final String gender;

    private final Long doctorId;

    private final String address;

    private final String guardianName;

    private final String gType;


    public PatientIpData(String displayNumber, String ipNo,Long ipId, String name, String ward,
                       String bedNo, String admissionDate,Long visitId,Long patientId,String age,String gender,Long doctorId,String address,String guardianName,String gType) {
        this.displayNumber = displayNumber;
        this.ipNo = ipNo;
        this.ipId = ipId;
        this.fullName = name;
        this.ward = ward;
        this.bedNo = bedNo;
        this.admissionDate = admissionDate;
        this.visitId = visitId;
        this.patientId = patientId;
        this.age = age;
        this.gender = gender;
        this.doctorId = doctorId;
        this.address = address;
        this.guardianName = guardianName;
        this.gType = gType;
    }

    public static PatientIpData newInstance(String displayNumber, String ipNo,Long ipId, String name, String ward,
                                          String bedNo, String admissionDate,Long visitId,Long patientId,String age,String gender,Long doctorId,String address,String guardianName,String gType) {
        return new PatientIpData(displayNumber,ipNo,ipId,name,ward,bedNo,admissionDate,visitId,patientId,age,gender,doctorId,address,guardianName,gType);
    }

}
