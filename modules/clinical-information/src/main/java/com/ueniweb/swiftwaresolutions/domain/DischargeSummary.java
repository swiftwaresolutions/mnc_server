package com.ueniweb.swiftwaresolutions.domain;

import com.ueniweb.swiftwaresolutions.request.CreateDischargeSummaryRequest;
import com.ueniweb.swiftwaresolutions.utils.DateTimeUtils;
import jakarta.persistence.*;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity(name = "DischargeSummary")
@Table(name = "cli_discharge_summary")
@Data
public class DischargeSummary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "patId", nullable = false)
    @Basic(optional = false)
    private Long patId;

    @Column(name = "vstId", nullable = false)
    @Basic(optional = false)
    private Long vstId;

    @Column(name = "ipId")
    @Basic(optional = false)
    private Long ipId;

    @Column(name = "consultantId")
    @Basic(optional = false)
    private Long docId;

    @Column(name = "diagnosis", columnDefinition = "TEXT")
    private String diagnosis;

    @Column(name = "history", columnDefinition = "TEXT")
    private String history;

    @Column(name = "examination", columnDefinition = "TEXT")
    private String examination;

    @Column(name = "treatment", columnDefinition = "TEXT")
    private String treatment;

    @Column(name = "hospitalCourse", columnDefinition = "TEXT")
    private String courseInTheHospital;

    @Column(name = "operationFindings", columnDefinition = "TEXT")
    private String operativeFindings;

    @Column(name = "disCondition", columnDefinition = "TEXT")
    private String conditionOfPatient;

    @Column(name = "emergencyIndication", columnDefinition = "TEXT")
    private String emergencyIndication;

    @Column(name = "advice", columnDefinition = "TEXT")
    private String dischargeAdvice;

    @Column(name = "gynaecology", columnDefinition = "TEXT")
    private String gynaecology;

    @Column(name = "obstetrics", columnDefinition = "TEXT")
    private String obstetrics;

    @Column(name = "neonatal", columnDefinition = "TEXT")
    private String neonatal;

    @Column(name = "babyDetails", columnDefinition = "TEXT")
    private String babyDetail;

    @Column(name = "date")
    private String date;

    @Column(name = "time")
    private String time;

    @Column(name = "uId",nullable = false)
    @Basic(optional = false)
    private Long uId;

    @Column(name = "reviewDTM")
    private String reviewDTM;

    @Column(name = "isActive")
    private Integer isActive;


    @Column(name = "outSideMedicine", columnDefinition = "TEXT")
    private String outSideMedicine;



    @OneToMany(mappedBy = "summaryId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<SummaryDiagnosisDetails> summaryDiagnosisDetailsList = new ArrayList<>();

    @OneToMany(mappedBy = "summaryId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<LabAndInvestigationSummary> labAndInvestigationSummaryList = new ArrayList<>();

    @OneToMany(mappedBy = "summaryId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DischargeSummaryConsultant> dischargeSummaryConsultantList = new ArrayList<>();

    @OneToMany(mappedBy = "summaryId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DischargeSummaryDept> dischargeSummaryDeptList = new ArrayList<>();

    public static DischargeSummary to(final CreateDischargeSummaryRequest createDischargeSummaryRequest){
        DischargeSummary dischargeSummary = new DischargeSummary();

        dischargeSummary.setPatId(createDischargeSummaryRequest.getPatId());
        dischargeSummary.setVstId(createDischargeSummaryRequest.getVisitId());
        dischargeSummary.setIpId(createDischargeSummaryRequest.getIpId());
        dischargeSummary.setDocId(createDischargeSummaryRequest.getDocId());
        dischargeSummary.setDiagnosis(createDischargeSummaryRequest.getDiagnosis());
        dischargeSummary.setHistory(createDischargeSummaryRequest.getHistory());
        dischargeSummary.setExamination(createDischargeSummaryRequest.getExamination());
        dischargeSummary.setTreatment(createDischargeSummaryRequest.getTreatment());
        dischargeSummary.setCourseInTheHospital(createDischargeSummaryRequest.getCourseInTheHospital());
        dischargeSummary.setOperativeFindings(createDischargeSummaryRequest.getOperativeFindings());
        dischargeSummary.setConditionOfPatient(createDischargeSummaryRequest.getConditionOfPatient());
        dischargeSummary.setEmergencyIndication(createDischargeSummaryRequest.getEmergencyIndication());
        dischargeSummary.setDischargeAdvice(createDischargeSummaryRequest.getDischargeAdvice());
        dischargeSummary.setGynaecology(createDischargeSummaryRequest.getGynaecology());
        dischargeSummary.setObstetrics(createDischargeSummaryRequest.getObstetrics());
        dischargeSummary.setNeonatal(createDischargeSummaryRequest.getNeonatal());
        dischargeSummary.setBabyDetail(createDischargeSummaryRequest.getBabyDetail());
        dischargeSummary.setDate(DateTimeUtils.convertLocalDateToDateFormat(LocalDate.now()));
        dischargeSummary.setTime(DateTimeUtils.convertLocalDateToTimeFormat(LocalTime.now()));
        dischargeSummary.setUId(createDischargeSummaryRequest.getUId());
        dischargeSummary.setReviewDTM(createDischargeSummaryRequest.getReviewDTM());
        dischargeSummary.setIsActive(1);
        dischargeSummary.setOutSideMedicine(createDischargeSummaryRequest.getOutSideMedicine());

        return dischargeSummary;
    }

    public void update(final CreateDischargeSummaryRequest createDischargeSummaryRequest){

        this.patId       = createDischargeSummaryRequest.getPatId();
        this.vstId      =  createDischargeSummaryRequest.getVisitId();
        this.ipId       = createDischargeSummaryRequest.getIpId();
        this.docId          = createDischargeSummaryRequest.getDocId();
        this.diagnosis      = createDischargeSummaryRequest.getDiagnosis();
        this.history           = createDischargeSummaryRequest.getHistory();
        this.examination        = createDischargeSummaryRequest.getExamination();
        this.treatment          = createDischargeSummaryRequest.getTreatment();
        this.courseInTheHospital = createDischargeSummaryRequest.getCourseInTheHospital();
        this.operativeFindings      = createDischargeSummaryRequest.getOperativeFindings();
        this.conditionOfPatient   = createDischargeSummaryRequest.getConditionOfPatient();
        this.emergencyIndication = createDischargeSummaryRequest.getEmergencyIndication();
        this.dischargeAdvice      = createDischargeSummaryRequest.getDischargeAdvice();
        this.gynaecology        = createDischargeSummaryRequest.getGynaecology();
        this.obstetrics         = createDischargeSummaryRequest.getObstetrics();
        this.neonatal           = createDischargeSummaryRequest.getNeonatal();
        this.babyDetail         = createDischargeSummaryRequest.getBabyDetail();
        this.date               = DateTimeUtils.convertLocalDateToDateFormat(LocalDate.now());
        this.time               = DateTimeUtils.convertLocalDateToTimeFormat(LocalTime.now());
        this.uId                = createDischargeSummaryRequest.getUId();
        this.reviewDTM      = createDischargeSummaryRequest.getReviewDTM();
        this.isActive       = 1;
        this.outSideMedicine         = createDischargeSummaryRequest.getOutSideMedicine();

    }
}
