package com.ueniweb.swiftwaresolutions.request;

import lombok.Data;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
//@EqualsAndHashCode(callSuper = true)
@Data
public class CreateDischargeSummaryRequest {

    private Long patId;

    private Long visitId;

    private Long ipId;

    private Long docId;

    private String diagnosis;

    private String history;

    private String examination;

    private String treatment;

    private String courseInTheHospital;

    private String operativeFindings;

    private String conditionOfPatient;

    private String emergencyIndication;

    private String dischargeAdvice;

    private String gynaecology;

    private String obstetrics;

    private String neonatal;

    private String babyDetail;

    private String date;

    private String time;

    private Long uId;

    private String reviewDTM;

    private String outSideMedicine;


    private List<CreateSummaryDiagnosisDetailsRequest> createSummaryDiagnosisDetailsRequestList;

    private List<CreateLabAndInvSummaryRequest> createLabAndInvSummaryRequestList;

    private List<CreateDisSumConsRequest> createDisSumConsRequestList;

    private List<CreateDisSumDeptRequest> createDisSumDeptRequestList;


    @Override
    public String toString() {
        return "CreateDischargeSummaryRequest{" +
                "patId=" + patId +
                ", visitId=" + visitId +
                ", ipId=" + ipId +
                ", docId=" + docId +
                ", diagnosis='" + diagnosis + '\'' +
                ", history='" + history + '\'' +
                ", examination='" + examination + '\'' +
                ", treatment='" + treatment + '\'' +
                ", courseInTheHospital='" + courseInTheHospital + '\'' +
                ", operativeFindings='" + operativeFindings + '\'' +
                ", conditionOfPatient='" + conditionOfPatient + '\'' +
                ", emergencyIndication='" + emergencyIndication + '\'' +
                ", dischargeAdvice='" + dischargeAdvice + '\'' +
                ", gynaecology='" + gynaecology + '\'' +
                ", obstetrics='" + obstetrics + '\'' +
                ", neonatal='" + neonatal + '\'' +
                ", babyDetail='" + babyDetail + '\'' +
                ", date=" + date +
                ", time=" + time +
                ", uId=" + uId +
                ", reviewDTM='" + reviewDTM + '\'' +
                ", outSideMedicine='" + outSideMedicine + '\'' +
                '}';
    }




}
