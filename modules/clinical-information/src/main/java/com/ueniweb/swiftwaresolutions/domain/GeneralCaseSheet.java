package com.ueniweb.swiftwaresolutions.domain;

import com.ueniweb.swiftwaresolutions.request.GeneralCaseSheetRequest;
import com.ueniweb.swiftwaresolutions.utils.DateTimeUtils;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "GeneralCaseSheet")
@Table(name = "cli_patient_general_casesheet")
@Data
public class GeneralCaseSheet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "patId", nullable = false)
    @Basic(optional = false)
    private Long patientId;

    @Column(name = "vstId", nullable = false)
    @Basic(optional = false)
    private Long visitId;

    @Column(name = "ipId")
    @Basic(optional = false)
    private Long ipId;

    @Column(name = "presentIllness", columnDefinition = "TEXT")
    private String presentIllness;

    @Column(name = "pastHistory", columnDefinition = "TEXT")
    private String pastHistory;

    @Column(name = "treatmentHistory", columnDefinition = "TEXT")
    private String treatmentHistory;

    @Column(name = "personalHistory", columnDefinition = "TEXT")
    private String personalHistory;

    @Column(name = "investigationHistory", columnDefinition = "TEXT")
    private String investigationHistory;

    @Column(name = "menstrualHistory", columnDefinition = "TEXT")
    private String menstrualHistory;

    @Column(name = "temperature")
    private String temperature;

    @Column(name = "pulse")
    private String pulse;

    @Column(name = "rr")
    private String rr;

    @Column(name = "bp")
    private String bp;

    @Column(name = "spo2")
    private String spo2;

    @Column(name = "height")
    private String height;

    @Column(name = "weight")
    private String weight;

    @Column(name = "bmi")
    private String bmi;

    @Column(name = "oralCavity", columnDefinition = "TEXT")
    private String oralCavity;

    @Column(name = "generalPhysical", columnDefinition = "TEXT")
    private String generalPhysical;

    @Column(name = "cvs", columnDefinition = "TEXT")
    private String cvs;

    @Column(name = "res", columnDefinition = "TEXT")
    private String res;

    @Column(name = "abdominal", columnDefinition = "TEXT")
    private String abdominal;

    @Column(name = "cns", columnDefinition = "TEXT")
    private String cns;

    @Column(name = "perVaginal", columnDefinition = "TEXT")
    private String perVaginal;

    @Column(name = "oralRectal", columnDefinition = "TEXT")
    private String oralRectal;

    @Column(name = "skin", columnDefinition = "TEXT")
    private String skin;

    @Column(name = "others",columnDefinition = "Text")
    private String others;

    @Column(name = "musculoskeletal", columnDefinition = "TEXT")
    private String musculoskeletal;

    @Column(name = "additionalFindings", columnDefinition = "TEXT")
    private String additionalFindings;

    @Column(name = "allergy", columnDefinition = "TEXT")
    private String allergy;

    @Column(name = "differentialDiagnosis", columnDefinition = "TEXT")
    private String differentialDiagnosis;

    @Column(name = "confirmedDiagnosis", columnDefinition = "TEXT")
    private String confirmedDiagnosis;

    @Column(name = "medications", columnDefinition = "TEXT")
    private String medications;

    @Column(name = "recomendations", columnDefinition = "TEXT")
    private String recomendations;

    @Column(name = "proceduresPlanned", columnDefinition = "TEXT")
    private String proceduresPlanned;

    @Column(name = "followUpPlan", columnDefinition = "TEXT")
    private String followUpPlan;

    @Column(name = "examination", columnDefinition = "TEXT")
    private String examination;

    @Column(name = "diagnosis", columnDefinition = "TEXT")
    private String diagnosis;

    @Column(name = "discussion", columnDefinition = "TEXT")
    private String discussion;

    @Column(name = "dateTime",nullable = false)
    private String dateTime;

    @Column(name="uid",nullable = false)
    private Long uid;

    @Column(name = "appointMentDate")
    private String appointMentDate;

    @Column(name = "pastHistorySurgical",nullable = false)
    private String pastHistorySurgical="";

    @Column(name = "pastHistoryMedical",nullable = false)
    private String pastHistoryMedical="";

    @Column(name = "familyHistory",nullable = false)
    private String familyHistory = "";

    @Column(name = "generalExamination",nullable = false)
    private String generalExamination="";

    @Column(name = "systemicExamination",nullable = false)
    private String systemicExamination="";

    @Column(name = "presentingComplaints",nullable = false)
    private String presentingComplaints="";

    @Column(name = "pallor",nullable = false)
    private String pallor ="";

    @Column(name = "icterus",nullable = false)
    private String icterus = "";

    @Column(name = "edema",nullable = false)
    private String edema ="";

    @Column(name = "foot",nullable = false)
    private String foot ="";

    @Column(name = "wound",nullable = false)
    private String wound ="";



    @OneToMany(mappedBy = "caseSheetId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ComplaintDetails> complaintDetailsList = new ArrayList<>();

    @OneToMany(mappedBy = "caseSheetId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DiagnosisDetails> diagnosisDetailsList = new ArrayList<>();

    public static GeneralCaseSheet to(final GeneralCaseSheetRequest generalCaseSheetRequest){
        GeneralCaseSheet generalcasesheet = new GeneralCaseSheet();
        generalcasesheet.setPatientId(generalCaseSheetRequest.getPatientId());
        generalcasesheet.setVisitId(generalCaseSheetRequest.getVisitId());
        generalcasesheet.setIpId(generalCaseSheetRequest.getIpId());
        generalcasesheet.setPresentIllness(generalCaseSheetRequest.getPresentIllness());
        generalcasesheet.setPastHistory(generalCaseSheetRequest.getPastHistory());
        generalcasesheet.setTreatmentHistory(generalCaseSheetRequest.getTreatmentHistory());
        generalcasesheet.setPersonalHistory(generalCaseSheetRequest.getPersonalHistory());
        generalcasesheet.setInvestigationHistory(generalCaseSheetRequest.getInvestigationHistory());
        generalcasesheet.setMenstrualHistory(generalCaseSheetRequest.getMenstrualHistory());
        generalcasesheet.setTemperature(generalCaseSheetRequest.getTemperature());
        generalcasesheet.setPulse(generalCaseSheetRequest.getPulse());
        generalcasesheet.setRr(generalCaseSheetRequest.getRr());
        generalcasesheet.setBp(generalCaseSheetRequest.getBp());
        generalcasesheet.setSpo2(generalCaseSheetRequest.getSpo2());
        generalcasesheet.setHeight(generalCaseSheetRequest.getHeight());
        generalcasesheet.setWeight(generalCaseSheetRequest.getWeight());
        generalcasesheet.setBmi(generalCaseSheetRequest.getBmi());
        generalcasesheet.setOralCavity(generalCaseSheetRequest.getOralCavity());
        generalcasesheet.setCvs(generalCaseSheetRequest.getCvs());
        generalcasesheet.setRes(generalCaseSheetRequest.getRes());
        generalcasesheet.setAbdominal(generalCaseSheetRequest.getAbdominal());
        generalcasesheet.setCns(generalCaseSheetRequest.getCns());
        generalcasesheet.setPerVaginal(generalCaseSheetRequest.getPerVaginal());
        generalcasesheet.setOralRectal(generalCaseSheetRequest.getOralRectal());
        generalcasesheet.setSkin(generalCaseSheetRequest.getSkin());
        generalcasesheet.setMusculoskeletal(generalCaseSheetRequest.getMusculoskeletal());
        generalcasesheet.setAdditionalFindings(generalCaseSheetRequest.getAdditionalFindings());
        generalcasesheet.setAllergy(generalCaseSheetRequest.getAllergy());
        generalcasesheet.setDifferentialDiagnosis(generalCaseSheetRequest.getDifferentialDiagnosis());
        generalcasesheet.setConfirmedDiagnosis(generalCaseSheetRequest.getConfirmedDiagnosis());
        generalcasesheet.setMedications(generalCaseSheetRequest.getMedications());
        generalcasesheet.setRecomendations(generalCaseSheetRequest.getRecomendations());
        generalcasesheet.setProceduresPlanned(generalCaseSheetRequest.getProceduresPlanned());
        generalcasesheet.setFollowUpPlan(generalCaseSheetRequest.getFollowUpPlan());
        generalcasesheet.setExamination(generalCaseSheetRequest.getExamination());
        generalcasesheet.setDiagnosis(generalCaseSheetRequest.getDiagnosis());
        generalcasesheet.setDiscussion(generalCaseSheetRequest.getDiscussion());
        generalcasesheet.setGeneralPhysical(generalCaseSheetRequest.getGeneralPhysical());
        generalcasesheet.setOthers(generalCaseSheetRequest.getOthers());
        generalcasesheet.setUid(generalCaseSheetRequest.getUid());
//        generalcasesheet.setAppointMentDate(generalCaseSheetRequest.getAppointMentDate());
        generalcasesheet.setDateTime(DateTimeUtils.convertLocalDateToDateTimeFormat(LocalDateTime.now()));

//        generalcasesheet.setPastHistorySurgical(generalCaseSheetRequest.getPastHistorySurgical());
//        generalcasesheet.setPastHistoryMedical(generalCaseSheetRequest.getPastHistoryMedical());
//        generalcasesheet.setFamilyHistory(generalCaseSheetRequest.getFamilyHistory());
//        generalcasesheet.setGeneralExamination(generalCaseSheetRequest.getGeneralExamination());
//        generalcasesheet.setSystemicExamination(generalCaseSheetRequest.getSystemicExamination());
//        generalcasesheet.setPresentingComplaints(generalCaseSheetRequest.getPresentingComplaints());

//        generalcasesheet.setPallor(generalCaseSheetRequest.getPallor());
//        generalcasesheet.setIcterus(generalCaseSheetRequest.getIcterus());
//        generalcasesheet.setEdema(generalCaseSheetRequest.getEdema());

        generalcasesheet.setFoot(generalCaseSheetRequest.getFoot());
        generalcasesheet.setWound(generalCaseSheetRequest.getWound());


        return generalcasesheet;
    }

    public void update(final GeneralCaseSheetRequest generalCaseSheetRequest){
        this.patientId = generalCaseSheetRequest.getPatientId();
        this.visitId = generalCaseSheetRequest.getVisitId();
        this.ipId = generalCaseSheetRequest.getIpId();
        this.presentIllness = generalCaseSheetRequest.getPresentIllness();
        this.pastHistory = generalCaseSheetRequest.getPastHistory();
        this.treatmentHistory = generalCaseSheetRequest.getTreatmentHistory();
        this.personalHistory = generalCaseSheetRequest.getPersonalHistory();
        this.investigationHistory = generalCaseSheetRequest.getInvestigationHistory();
        this.menstrualHistory = generalCaseSheetRequest.getMenstrualHistory();
        this.temperature = generalCaseSheetRequest.getTemperature();
        this.pulse = generalCaseSheetRequest.getPulse();
        this.rr = generalCaseSheetRequest.getRr();
        this.bp = generalCaseSheetRequest.getBp();
        this.spo2 = generalCaseSheetRequest.getSpo2();
        this.height = generalCaseSheetRequest.getHeight();
        this.weight = generalCaseSheetRequest.getWeight();
        this.bmi = generalCaseSheetRequest.getBmi();
        this.oralCavity = generalCaseSheetRequest.getOralCavity();
        this.cvs = generalCaseSheetRequest.getCvs();
        this.res = generalCaseSheetRequest.getRes();
        this.abdominal = generalCaseSheetRequest.getAbdominal();
        this.cns = generalCaseSheetRequest.getCns();
        this.perVaginal = generalCaseSheetRequest.getPerVaginal();
        this.oralRectal = generalCaseSheetRequest.getOralRectal();
        this.skin = generalCaseSheetRequest.getSkin();
        this.musculoskeletal = generalCaseSheetRequest.getMusculoskeletal();
        this.additionalFindings = generalCaseSheetRequest.getAdditionalFindings();
        this.allergy = generalCaseSheetRequest.getAllergy();
        this.differentialDiagnosis = generalCaseSheetRequest.getDifferentialDiagnosis();
        this.confirmedDiagnosis = generalCaseSheetRequest.getConfirmedDiagnosis();
        this.medications = generalCaseSheetRequest.getMedications();
        this.recomendations = generalCaseSheetRequest.getRecomendations();
        this.proceduresPlanned = generalCaseSheetRequest.getProceduresPlanned();
        this.followUpPlan = generalCaseSheetRequest.getFollowUpPlan();
        this.examination = generalCaseSheetRequest.getExamination();
        this.diagnosis = generalCaseSheetRequest.getDiagnosis();
        this.discussion = generalCaseSheetRequest.getDiscussion();
        this.generalPhysical = generalCaseSheetRequest.getGeneralPhysical();
        this.others = generalCaseSheetRequest.getOthers();
        this.uid = generalCaseSheetRequest.getUid();
//        this.appointMentDate = generalCaseSheetRequest.getAppointMentDate();
        this.dateTime = DateTimeUtils.convertLocalDateToDateTimeFormat(LocalDateTime.now());

        this.pastHistorySurgical = generalCaseSheetRequest.getPastHistorySurgical();
        this.pastHistoryMedical = generalCaseSheetRequest.getPastHistoryMedical();
        this.familyHistory = generalCaseSheetRequest.getFamilyHistory();
        this.generalExamination = generalCaseSheetRequest.getGeneralExamination();
        this.systemicExamination = generalCaseSheetRequest.getSystemicExamination();
        this.presentingComplaints = generalCaseSheetRequest.getPresentingComplaints();
        this.pallor = generalCaseSheetRequest.getPallor();
        this.icterus = generalCaseSheetRequest.getIcterus();
        this.edema = generalCaseSheetRequest.getEdema();
        this.foot = generalCaseSheetRequest.getFoot();
        this.wound = generalCaseSheetRequest.getWound();

    }
}
