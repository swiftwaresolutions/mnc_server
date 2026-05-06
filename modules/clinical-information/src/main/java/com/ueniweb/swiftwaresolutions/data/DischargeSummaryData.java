package com.ueniweb.swiftwaresolutions.data;

import lombok.Data;

import java.util.List;

@Data
public class DischargeSummaryData {

    private Long id;

    private Long patId;

    private Long vstId;

    private Long ipId;

    private Long consultantId;

    private String consultantName;

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

    private Long is_active;

    private String outSideMedicine;

    private List<DischargeDiagnosisData> dischargeDiagnosisDataList;

    private List<DischargeLabInvSummaryData> dischargeLabInvSummaryDataList;

    private List<DisSumConsultantData> disSumConsultantDataList;

    private List<DisSumDeptData> disSumDeptDataList;


    public DischargeSummaryData(Long id, Long patId, Long vstId,Long ipId,Long consultantId,String consultantName,String diagnosis,String history, String examination,
                                  String treatment,String courseInTheHospital,String operativeFindings,String conditionOfPatient,String emergencyIndication,
                                  String dischargeAdvice, String gynaecology,String obstetrics,String neonatal,String babyDetail,String date,String time,
                                  Long uId,String reviewDTM,Long is_active,String outSideMedicine){

        this.id = id;
        this.patId = patId;
        this.vstId = vstId;
        this.ipId = ipId;
        this.consultantId = consultantId;
        this.consultantName = consultantName;
        this.diagnosis = diagnosis;
        this.history = history;
        this.examination = examination;
        this.treatment = treatment;
        this.courseInTheHospital = courseInTheHospital;
        this.operativeFindings = operativeFindings;
        this.conditionOfPatient = conditionOfPatient;
        this.emergencyIndication = emergencyIndication;
        this.dischargeAdvice = dischargeAdvice;
        this.gynaecology = gynaecology;
        this.obstetrics = obstetrics;
        this.neonatal = neonatal;
        this.babyDetail = babyDetail;
        this.date = date;
        this.time = time;
        this.uId = uId;
        this.reviewDTM = reviewDTM;
        this.is_active = is_active;
        this.outSideMedicine = outSideMedicine;
    }

    public static DischargeSummaryData createNewInstance(Long id, Long patId, Long vstId,Long ipId,Long consultantId,String consultantName ,String diagnosis,String history, String examination,
                                                     String treatment,String courseInTheHospital,String operativeFindings,String conditionOfPatient,String emergencyIndication,
                                                     String dischargeAdvice, String gynaecology,String obstetrics,String neonatal,String babyDetail,String date,String time,
                                                     Long uId,String reviewDTM,Long is_active,String outSideMedicine) {

        return new DischargeSummaryData(id,patId,vstId,ipId,consultantId,consultantName,diagnosis,history,examination,
                treatment,courseInTheHospital,operativeFindings,conditionOfPatient,emergencyIndication,
                dischargeAdvice, gynaecology,obstetrics,neonatal,babyDetail,date,time,uId,reviewDTM,
                is_active,outSideMedicine);
    }

}
