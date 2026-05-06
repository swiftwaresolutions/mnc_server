package com.ueniweb.swiftwaresolutions.domain;

import com.ueniweb.swiftwaresolutions.request.CreateNeoNateCaseSheetRequest;
import com.ueniweb.swiftwaresolutions.request.CreatePeadiatricCaseSheetRequest;
import com.ueniweb.swiftwaresolutions.utils.DateTimeUtils;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "NeonateCaseSheet")
@Table(name = "cli_patient_neonate_casesheet")
public class NeonateCaseSheet {

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

    @Column(name = "dobtob")
    private String dobTob;

    @Column(name = "placeofbirth")
    private String placeofbirth;

    @Column(name = "presentIllness", columnDefinition = "TEXT")
    private String presentIllness;

    @Column(name = "maternalhistory", columnDefinition = "TEXT")
    private String maternalHistory;

    @Column(name = "birthHistory", columnDefinition = "TEXT")
    private String birthHistory;

    @Column(name = "treatmentHistory", columnDefinition = "TEXT")
    private String treatmentHistory;

    @Column(name = "investigationHistory", columnDefinition = "TEXT")
    private String investigationHistory;

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

    @Column(name = "icterus")
    private String icterus;

    @Column(name = "cyanosis")
    private String cyanosis;

    @Column(name = "cogenital")
    private String cogenital;

    @Column(name = "headtotoe", columnDefinition = "TEXT")
    private String headtotoe;

    @Column(name = "oralcavity", columnDefinition = "TEXT")
    private String oralcavity;

    @Column(name = "cvs", columnDefinition = "TEXT")
    private String cvs;

    @Column(name = "rs", columnDefinition = "TEXT")
    private String res;

    @Column(name = "abdo", columnDefinition = "TEXT")
    private String abdo;

    @Column(name = "cns", columnDefinition = "TEXT")
    private String cns;

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
    private List<NeoNateComplaintDetails> neoNateComplaintDetailsList = new ArrayList<>();

    public static NeonateCaseSheet to(final CreateNeoNateCaseSheetRequest createNeoNateCaseSheetRequest){
        NeonateCaseSheet neonateCaseSheet = new NeonateCaseSheet();
        neonateCaseSheet.setPatId(createNeoNateCaseSheetRequest.getPatId());
        neonateCaseSheet.setVisitId(createNeoNateCaseSheetRequest.getVisitId());
        neonateCaseSheet.setIpId(createNeoNateCaseSheetRequest.getIpId());
        neonateCaseSheet.setDobTob(createNeoNateCaseSheetRequest.getDobTob());
        neonateCaseSheet.setPlaceofbirth(createNeoNateCaseSheetRequest.getPlaceofbirth());
        neonateCaseSheet.setPresentIllness(createNeoNateCaseSheetRequest.getPresentIllness());
        neonateCaseSheet.setMaternalHistory(createNeoNateCaseSheetRequest.getMaternalHistory());
        neonateCaseSheet.setBirthHistory(createNeoNateCaseSheetRequest.getBirthHistory());
        neonateCaseSheet.setTreatmentHistory(createNeoNateCaseSheetRequest.getTreatmentHistory());
        neonateCaseSheet.setInvestigationHistory(createNeoNateCaseSheetRequest.getInvestigationHistory());
        neonateCaseSheet.setPulse(createNeoNateCaseSheetRequest.getPulse());
        neonateCaseSheet.setBp(createNeoNateCaseSheetRequest.getBp());
        neonateCaseSheet.setRr(createNeoNateCaseSheetRequest.getRr());
        neonateCaseSheet.setSpo2(createNeoNateCaseSheetRequest.getSpo2());
        neonateCaseSheet.setCrt(createNeoNateCaseSheetRequest.getCrt());
        neonateCaseSheet.setTemp(createNeoNateCaseSheetRequest.getTemp());
        neonateCaseSheet.setPallor(createNeoNateCaseSheetRequest.getPallor());
        neonateCaseSheet.setIcterus(createNeoNateCaseSheetRequest.getIcterus());
        neonateCaseSheet.setCyanosis(createNeoNateCaseSheetRequest.getCyanosis());
        neonateCaseSheet.setCogenital(createNeoNateCaseSheetRequest.getCogenital());
        neonateCaseSheet.setHeadtotoe(createNeoNateCaseSheetRequest.getHeadtotoe());
        neonateCaseSheet.setOralcavity(createNeoNateCaseSheetRequest.getOralcavity());
        neonateCaseSheet.setCvs(createNeoNateCaseSheetRequest.getCvs());
        neonateCaseSheet.setRes(createNeoNateCaseSheetRequest.getRes());
        neonateCaseSheet.setAbdo(createNeoNateCaseSheetRequest.getAbdo());
        neonateCaseSheet.setCns(createNeoNateCaseSheetRequest.getCns());
        neonateCaseSheet.setSkin(createNeoNateCaseSheetRequest.getSkin());
        neonateCaseSheet.setMusculoskeletal(createNeoNateCaseSheetRequest.getMusculoskeletal());
        neonateCaseSheet.setAditionalfindings(createNeoNateCaseSheetRequest.getAditionalfindings());
        neonateCaseSheet.setAllergy(createNeoNateCaseSheetRequest.getAllergy());
        neonateCaseSheet.setDifferentialDiagnosis(createNeoNateCaseSheetRequest.getDifferentialDiagnosis());
        neonateCaseSheet.setConfirmedDiagnosis(createNeoNateCaseSheetRequest.getConfirmedDiagnosis());

        return neonateCaseSheet;
    }

    public void update(final CreateNeoNateCaseSheetRequest createNeoNateCaseSheetRequest){

        this.setPatId(createNeoNateCaseSheetRequest.getPatId());
        this.setVisitId(createNeoNateCaseSheetRequest.getVisitId());
        this.setIpId(createNeoNateCaseSheetRequest.getIpId());
        this.setDobTob(createNeoNateCaseSheetRequest.getDobTob());
        this.setPlaceofbirth(createNeoNateCaseSheetRequest.getPlaceofbirth());
        this.setPresentIllness(createNeoNateCaseSheetRequest.getPresentIllness());
        this.setMaternalHistory(createNeoNateCaseSheetRequest.getMaternalHistory());
        this.setBirthHistory(createNeoNateCaseSheetRequest.getBirthHistory());
        this.setTreatmentHistory(createNeoNateCaseSheetRequest.getTreatmentHistory());
        this.setInvestigationHistory(createNeoNateCaseSheetRequest.getInvestigationHistory());
        this.setPulse(createNeoNateCaseSheetRequest.getPulse());
        this.setBp(createNeoNateCaseSheetRequest.getBp());
        this.setRr(createNeoNateCaseSheetRequest.getRr());
        this.setSpo2(createNeoNateCaseSheetRequest.getSpo2());
        this.setCrt(createNeoNateCaseSheetRequest.getCrt());
        this.setTemp(createNeoNateCaseSheetRequest.getTemp());
        this.setPallor(createNeoNateCaseSheetRequest.getPallor());
        this.setIcterus(createNeoNateCaseSheetRequest.getIcterus());
        this.setCyanosis(createNeoNateCaseSheetRequest.getCyanosis());
        this.setCogenital(createNeoNateCaseSheetRequest.getCogenital());
        this.setHeadtotoe(createNeoNateCaseSheetRequest.getHeadtotoe());
        this.setOralcavity(createNeoNateCaseSheetRequest.getOralcavity());
        this.setCvs(createNeoNateCaseSheetRequest.getCvs());
        this.setRes(createNeoNateCaseSheetRequest.getRes());
        this.setAbdo(createNeoNateCaseSheetRequest.getAbdo());
        this.setCns(createNeoNateCaseSheetRequest.getCns());
        this.setSkin(createNeoNateCaseSheetRequest.getSkin());
        this.setMusculoskeletal(createNeoNateCaseSheetRequest.getMusculoskeletal());
        this.setAditionalfindings(createNeoNateCaseSheetRequest.getAditionalfindings());
        this.setAllergy(createNeoNateCaseSheetRequest.getAllergy());
        this.setDifferentialDiagnosis(createNeoNateCaseSheetRequest.getDifferentialDiagnosis());
        this.setConfirmedDiagnosis(createNeoNateCaseSheetRequest.getConfirmedDiagnosis());

    }
}
