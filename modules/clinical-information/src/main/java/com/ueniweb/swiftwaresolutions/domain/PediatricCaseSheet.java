package com.ueniweb.swiftwaresolutions.domain;

import com.ueniweb.swiftwaresolutions.request.CreatePeadiatricCaseSheetRequest;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "PediatricCaseSheet")
@Table(name = "cli_patient_pediatric_casesheet")
@Data
public class PediatricCaseSheet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "patId", nullable = false)
    @Basic(optional = false)
    private Long patId;

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

    @Column(name = "birthHistory", columnDefinition = "TEXT")
    private String birthHistory;

    @Column(name = "personalHistory", columnDefinition = "TEXT")
    private String personalHistory;

    @Column(name = "perinatalhistory", columnDefinition = "TEXT")
    private String perinatalhistory;

    @Column(name = "treatmentHistory", columnDefinition = "TEXT")
    private String treatmentHistory;

    @Column(name = "investigationHistory", columnDefinition = "TEXT")
    private String investigationHistory;

    @Column(name = "feedinghistory", columnDefinition = "TEXT")
    private String feedinghistory;

    @Column(name = "pulse")
    private String pulse;

    @Column(name = "bp")
    private String bp;

    @Column(name = "rr")
    private String rr;

    @Column(name = "spo2")
    private String spo2;

    @Column(name = "crt")
    private String crt;

    @Column(name = "temp")
    private String temp;

    @Column(name = "pallor")
    private String pallor;

    @Column(name = "clubbing")
    private String clubbing;

    @Column(name = "icterus")
    private String icterus;

    @Column(name = "cyanosis")
    private String cyanosis;

    @Column(name = "lymphadenopathy")
    private String lymphadenopathy;

    @Column(name = "edema")
    private String edema;

    @Column(name = "headtotoe", columnDefinition = "TEXT")
    private String headtotoe;

    @Column(name = "oralcavity", columnDefinition = "TEXT")
    private String oralcavity;

    @Column(name = "cvs", columnDefinition = "TEXT")
    private String cvs;

    @Column(name = "rs", columnDefinition = "TEXT")
    private String rs;

    @Column(name = "cns", columnDefinition = "TEXT")
    private String cns;

    @Column(name = "abdo", columnDefinition = "TEXT")
    private String abdo;

    @Column(name = "skin", columnDefinition = "TEXT")
    private String skin;

    @Column(name = "musculoskeletal", columnDefinition = "TEXT")
    private String musculoskeletal;

    @Column(name = "aditionalfindings", columnDefinition = "TEXT")
    private String aditionalfindings;

    @Column(name = "allergy", columnDefinition = "TEXT")
    private String allergy;

    @Column(name = "differentialDiagnosis", columnDefinition = "TEXT")
    private String differentialDiagnosis;

    @Column(name = "confirmedDiagnosis", columnDefinition = "TEXT")
    private String confirmedDiagnosis;


    @OneToMany(mappedBy = "caseSheetId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PediatricComplaintDetails> pediatricComplaintDetailsList = new ArrayList<>();

    public static PediatricCaseSheet to(final CreatePeadiatricCaseSheetRequest createPeadiatricCaseSheetRequest) {
        PediatricCaseSheet pediatricCaseSheet = new PediatricCaseSheet();
        pediatricCaseSheet.setPatId(createPeadiatricCaseSheetRequest.getPatId());
        pediatricCaseSheet.setVisitId(createPeadiatricCaseSheetRequest.getVisitId());
        pediatricCaseSheet.setIpId(createPeadiatricCaseSheetRequest.getIpId());
        pediatricCaseSheet.setPresentIllness(createPeadiatricCaseSheetRequest.getPresentIllness());
        pediatricCaseSheet.setPastHistory(createPeadiatricCaseSheetRequest.getPastHistory());
        pediatricCaseSheet.setBirthHistory(createPeadiatricCaseSheetRequest.getBirthHistory());
        pediatricCaseSheet.setPersonalHistory(createPeadiatricCaseSheetRequest.getPersonalHistory());
        pediatricCaseSheet.setPerinatalhistory(createPeadiatricCaseSheetRequest.getPerinatalhistory());
        pediatricCaseSheet.setTreatmentHistory(createPeadiatricCaseSheetRequest.getTreatmentHistory());
        pediatricCaseSheet.setInvestigationHistory(createPeadiatricCaseSheetRequest.getInvestigationHistory());
        pediatricCaseSheet.setFeedinghistory(createPeadiatricCaseSheetRequest.getFeedinghistory());
        pediatricCaseSheet.setPulse(createPeadiatricCaseSheetRequest.getPulse());
        pediatricCaseSheet.setBp(createPeadiatricCaseSheetRequest.getBp());
        pediatricCaseSheet.setRr(createPeadiatricCaseSheetRequest.getRr());
        pediatricCaseSheet.setSpo2(createPeadiatricCaseSheetRequest.getSpo2());
        pediatricCaseSheet.setCrt(createPeadiatricCaseSheetRequest.getCrt());
        pediatricCaseSheet.setTemp(createPeadiatricCaseSheetRequest.getTemp());
        pediatricCaseSheet.setPallor(createPeadiatricCaseSheetRequest.getPallor());
        pediatricCaseSheet.setClubbing(createPeadiatricCaseSheetRequest.getClubbing());
        pediatricCaseSheet.setIcterus(createPeadiatricCaseSheetRequest.getIcterus());
        pediatricCaseSheet.setCyanosis(createPeadiatricCaseSheetRequest.getCyanosis());
        pediatricCaseSheet.setLymphadenopathy(createPeadiatricCaseSheetRequest.getLymphadenopathy());
        pediatricCaseSheet.setEdema(createPeadiatricCaseSheetRequest.getEdema());
        pediatricCaseSheet.setHeadtotoe(createPeadiatricCaseSheetRequest.getHeadtotoe());
        pediatricCaseSheet.setOralcavity(createPeadiatricCaseSheetRequest.getOralcavity());
        pediatricCaseSheet.setCvs(createPeadiatricCaseSheetRequest.getCvs());
        pediatricCaseSheet.setRs(createPeadiatricCaseSheetRequest.getRs());
        pediatricCaseSheet.setCns(createPeadiatricCaseSheetRequest.getCns());
        pediatricCaseSheet.setAbdo(createPeadiatricCaseSheetRequest.getAbdo());
        pediatricCaseSheet.setSkin(createPeadiatricCaseSheetRequest.getSkin());
        pediatricCaseSheet.setMusculoskeletal(createPeadiatricCaseSheetRequest.getMusculoskeletal());
        pediatricCaseSheet.setAditionalfindings(createPeadiatricCaseSheetRequest.getAditionalfindings());
        pediatricCaseSheet.setAllergy(createPeadiatricCaseSheetRequest.getAllergy());
        pediatricCaseSheet.setDifferentialDiagnosis(createPeadiatricCaseSheetRequest.getDifferentialDiagnosis());
        pediatricCaseSheet.setConfirmedDiagnosis(createPeadiatricCaseSheetRequest.getConfirmedDiagnosis());
return pediatricCaseSheet;
    }

    public void update(final CreatePeadiatricCaseSheetRequest createPeadiatricCaseSheetRequest){

            this.setPatId(createPeadiatricCaseSheetRequest.getPatId());
            this.setVisitId(createPeadiatricCaseSheetRequest.getVisitId());
            this.setIpId(createPeadiatricCaseSheetRequest.getIpId());
            this.setPresentIllness(createPeadiatricCaseSheetRequest.getPresentIllness());
            this.setPastHistory(createPeadiatricCaseSheetRequest.getPastHistory());
            this.setBirthHistory(createPeadiatricCaseSheetRequest.getBirthHistory());
            this.setPersonalHistory(createPeadiatricCaseSheetRequest.getPersonalHistory());
            this.setPerinatalhistory(createPeadiatricCaseSheetRequest.getPerinatalhistory());
            this.setTreatmentHistory(createPeadiatricCaseSheetRequest.getTreatmentHistory());
            this.setInvestigationHistory(createPeadiatricCaseSheetRequest.getInvestigationHistory());
            this.setFeedinghistory(createPeadiatricCaseSheetRequest.getFeedinghistory());
            this.setPulse(createPeadiatricCaseSheetRequest.getPulse());
            this.setBp(createPeadiatricCaseSheetRequest.getBp());
            this.setRr(createPeadiatricCaseSheetRequest.getRr());
            this.setSpo2(createPeadiatricCaseSheetRequest.getSpo2());
            this.setCrt(createPeadiatricCaseSheetRequest.getCrt());
            this.setTemp(createPeadiatricCaseSheetRequest.getTemp());
            this.setPallor(createPeadiatricCaseSheetRequest.getPallor());
            this.setClubbing(createPeadiatricCaseSheetRequest.getClubbing());
            this.setIcterus(createPeadiatricCaseSheetRequest.getIcterus());
            this.setCyanosis(createPeadiatricCaseSheetRequest.getCyanosis());
            this.setLymphadenopathy(createPeadiatricCaseSheetRequest.getLymphadenopathy());
            this.setEdema(createPeadiatricCaseSheetRequest.getEdema());
            this.setHeadtotoe(createPeadiatricCaseSheetRequest.getHeadtotoe());
            this.setOralcavity(createPeadiatricCaseSheetRequest.getOralcavity());
            this.setCvs(createPeadiatricCaseSheetRequest.getCvs());
            this.setRs(createPeadiatricCaseSheetRequest.getRs());
            this.setCns(createPeadiatricCaseSheetRequest.getCns());
            this.setAbdo(createPeadiatricCaseSheetRequest.getAbdo());
            this.setSkin(createPeadiatricCaseSheetRequest.getSkin());
            this.setMusculoskeletal(createPeadiatricCaseSheetRequest.getMusculoskeletal());
            this.setAditionalfindings(createPeadiatricCaseSheetRequest.getAditionalfindings());
            this.setAllergy(createPeadiatricCaseSheetRequest.getAllergy());
            this.setDifferentialDiagnosis(createPeadiatricCaseSheetRequest.getDifferentialDiagnosis());
            this.setConfirmedDiagnosis(createPeadiatricCaseSheetRequest.getConfirmedDiagnosis());
        }


}
