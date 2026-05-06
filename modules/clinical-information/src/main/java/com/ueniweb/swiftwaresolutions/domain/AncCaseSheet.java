package com.ueniweb.swiftwaresolutions.domain;


import com.ueniweb.swiftwaresolutions.request.CreateAncRequest;
import com.ueniweb.swiftwaresolutions.utils.DateTimeUtils;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "AncCaseSheet")
@Table(name = "cli_anc")
public class AncCaseSheet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "patId",nullable = false)
    @Basic(optional = false)
    private Long patId;

    @Column(name = "vstId",nullable = false)
    @Basic(optional = false)
    private Long vstId;

    @Column(name = "Ctime",nullable = false)
    @Basic(optional = false)
    private String Ctime;

    @Column(name = "updateDate",nullable = false)
    @Basic(optional = false)
    private String Cdate;

    @Column(name = "g",nullable = false)
    @Basic(optional = false)
    private String g;

    @Column(name = "p",nullable = false)
    @Basic(optional = false)
    private String p;

    @Column(name = "l",nullable = false)
    @Basic(optional = false)
    private String l;

    @Column(name = "a",nullable = false)
    @Basic(optional = false)
    private String a;

    @Column(name = "d",nullable = false)
    @Basic(optional = false)
    private String d;

    @Column(name = "lmp",nullable = false)
    @Basic(optional = false)
    private String lmp;

    @Column(name = "edd",nullable = false)
    @Basic(optional = false)
    private String edd;

    @Column(name = "sedd",nullable = false)
    @Basic(optional = false)
    private String sedd;

    @Column(name = "ga",nullable = false)
    @Basic(optional = false)
    private String ga;

    @Column(name = "durationofmarriage",nullable = false)
    @Basic(optional = false)
    private String durationofmarriage;

    @Column(name = "consanguinity",nullable = false)

    private String consanguinity;

    @Column(name = "conception",nullable = false)

    private String conception;

    @Column(name = "menstrualHis",nullable = false)

    private String menstrualHis;

    @Column(name = "MenstrualOthers",nullable = false)
    @Basic(optional = false)
    private String MenstrualOthers;

    @Column(name = "surgicalHistory",nullable = false)
    @Basic(optional = false)
    private String surgicalHistory;

    @Column(name = "chiefhistory",nullable = false)
    @Basic(optional = false)
    private String chiefhistory;

    @Column(name = "allergichistory",nullable = false)
    @Basic(optional = false)
    private String allergichistory;

    @Column(name = "historyPreIll",nullable = false)
    @Basic(optional = false)
    private String historyPreIll;

    @Column(name = "familyHistory",nullable = false)
    @Basic(optional = false)
    private String familyHistory;

    @Column(name = "othersHis",nullable = false)
    @Basic(optional = false)
    private String othersHis;

    @Column(name = "pallor",nullable = false)
    @Basic(optional = false)
    private String pallor;

    @Column(name = "icterus",nullable = false)
    @Basic(optional = false)
    private String icterus;

    @Column(name = "edema",nullable = false)
    @Basic(optional = false)
    private String edema;

    @Column(name = "cvs",nullable = false)
    @Basic(optional = false)
    private String cvs;

    @Column(name = "rs",nullable = false)
    @Basic(optional = false)
    private String rs;

    @Column(name = "UtreusSize",nullable = false)
    @Basic(optional = false)
    private String UtreusSize;

    @Column(name = "SymphosisFundal",nullable = false)
    @Basic(optional = false)
    private String SymphosisFundal;

    @Column(name = "FeatolHeartRate",nullable = false)
    @Basic(optional = false)
    private String FeatolHeartRate;

    @Column(name = "presentationAb")
    @Basic(optional = false)
    private String presentationAb;

    @Column(name = "engaged")
    @Basic(optional = false)
    private String engaged;

    @Column(name = "cervix")
    @Basic(optional = false)
    private String cervix;

    @Column(name = "dilatation")
    @Basic(optional = false)
    private String dilatation;

    @Column(name = "effacement")
    @Basic(optional = false)
    private String effacement;

    @Column(name = "presentationPV")
    @Basic(optional = false)
    private String presentationPV;

    @Column(name = "station")
    @Basic(optional = false)
    private String station;

    @Column(name = "membrane")
    @Basic(optional = false)
    private String membrane;

    @Column(name = "pelvis")
    @Basic(optional = false)
    private String pelvis;

    @Column(name = "diabetes")
    @Basic(optional = false)
    private Long diabetes;

    @Column(name = "hypertension")
    @Basic(optional = false)
    private Long hypertension;

    @Column(name = "asthma")
    @Basic(optional = false)
    private Long asthma;

    @Column(name = "seiure")
    @Basic(optional = false)
    private Long seiure;

    @Column(name = "cardiac")
    @Basic(optional = false)
    private Long cardiacDisease;

    @Column(name = "tb")
    @Basic(optional = false)
    private Long tb;

    @Column(name = "thyroidDisorder")
    @Basic(optional = false)
    private Long thyroidDisorder;

    @Column(name = "stDose1")
    @Basic(optional = false)
    private Long stDose1;

    @Column(name = "stDoseIn")
    @Basic(optional = false)
    private String stDoseIn;

    @Column(name = "ndDose2")
    @Basic(optional = false)
    private Long ndDose2;

    @Column(name = "ndDoseIn")
    @Basic(optional = false)
    private String ndDoseIn;

    @Column(name = "riskFactor")
    @Basic(optional = false)
    private String riskFactor;

    @Column(name = "medicalHistory")
    private String medicalHistory;

    @Column(name = "others")
    private String others;

    @Column(name = "isDelivered")
    @Basic(optional = false)
    private Long isDelivered;

    @Column(name = "height",nullable = false)
    @Basic(optional = false)
    private String height;

    @Column(name = "bmi",nullable = false)
    @Basic(optional = false)
    private String bmi;

    @Column(name = "spo2",nullable = false)
    @Basic(optional = false)
    private String spo2;

    @Column(name = "rr",nullable = false)
    @Basic(optional = false)
    private String rr;

    @Column(name = "bp",nullable = false)
    @Basic(optional = false)
    private String bp;

    @Column(name = "weight",nullable = false)
    @Basic(optional = false)
    private String weight;

    @Column(name = "temperature",nullable = false)
    @Basic(optional = false)
    private String temperature;

    @Column(name = "pulse",nullable = false)
    @Basic(optional = false)
    private String pulse;


    @Column(name = "diabetesNotes")
    private String diabetesNotes;

    @Column(name = "hypertensionNotes")
    private String hypertensionNotes;

    @Column(name = "asthmaNotes")
    private String asthmaNotes;

    @Column(name = "seiureNotes")
    private String seiureNotes;

    @Column(name = "cardiacNotes")
    private String cardiacNotes;

    @Column(name = "tbNotes")
    private String tbNotes;

    @Column(name = "thyroidDisorderNotes")
    private String thyroidDisorderNotes;

    @Column(name = "othersNotes")
    private String othersNotes;

    @Column(name = "initialAppointmentDate")
    private String initialAppointmentDate;

    @Column(name = "initialAppointmentPlan")
    private String initialAppointmentPlan;

    @Column(name = "consultantId",nullable = false)
    @Basic(optional = false)
    private Long docId;

    @Column(name = "updateUserId",nullable = false)
    @Basic(optional = false)
    private Long updateDocId;

    @Column(name = "iniSysOther",nullable = false)
    @Basic(optional = false)
    private String iniSysOther;

    @Column(name = "iniPaOther",nullable = false)
    @Basic(optional = false)
    private String iniPaOther;

    @Column(name = "iniPvOther",nullable = false)
    @Basic(optional = false)
    private String iniPvOther;

    @Column(name = "othersPlan",nullable = false)
    @Basic(optional = false)
    private String othersPlan;

    @Column(name = "personalInfo",nullable = false)
    @Basic(optional = false)
    private String personalInfo;


//    @OneToMany(mappedBy = "anc_id", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<AncDetailsSheet> ancDetailsSheetList = new ArrayList<>();

    @OneToMany(mappedBy = "anc_id", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AncChildDetialsSheet> ancChildDetialsSheetList = new ArrayList<>();

    public static AncCaseSheet to(final CreateAncRequest createAncRequest){
        AncCaseSheet ancCaseSheet = new AncCaseSheet();
        ancCaseSheet.setPatId(createAncRequest.getPatId());
        ancCaseSheet.setVstId(createAncRequest.getVstId());
        ancCaseSheet.setCtime(createAncRequest.getCtime());
        ancCaseSheet.setCdate(createAncRequest.getCdate());
        ancCaseSheet.setG(createAncRequest.getG());
        ancCaseSheet.setP(createAncRequest.getP());
        ancCaseSheet.setL(createAncRequest.getL());
        ancCaseSheet.setA(createAncRequest.getA());
        ancCaseSheet.setD(createAncRequest.getD());
        ancCaseSheet.setLmp(createAncRequest.getLmp());
        ancCaseSheet.setEdd(createAncRequest.getEdd());
        ancCaseSheet.setSedd(createAncRequest.getSedd());
        ancCaseSheet.setGa(createAncRequest.getGa());
        ancCaseSheet.setDurationofmarriage(createAncRequest.getDurationofmarriage());
        ancCaseSheet.setConsanguinity(createAncRequest.getConsanguinity());
        ancCaseSheet.setConception(createAncRequest.getConception());
        ancCaseSheet.setMenstrualHis(createAncRequest.getMenstrualHis());
        ancCaseSheet.setMenstrualOthers(createAncRequest.getMenstrualOthers());
        ancCaseSheet.setSurgicalHistory(createAncRequest.getAllergichistory());
        ancCaseSheet.setChiefhistory(createAncRequest.getChiefhistory());
        ancCaseSheet.setAllergichistory(createAncRequest.getAllergichistory());
        ancCaseSheet.setAllergichistory(createAncRequest.getAllergichistory());
        ancCaseSheet.setHistoryPreIll(createAncRequest.getHistoryPreIll());
        ancCaseSheet.setFamilyHistory(createAncRequest.getFamilyHistory());
        ancCaseSheet.setOthersHis(createAncRequest.getOthersHis());
        ancCaseSheet.setPallor(createAncRequest.getPallor());
        ancCaseSheet.setIcterus(createAncRequest.getIcterus());
        ancCaseSheet.setEdema(createAncRequest.getEdema());
        ancCaseSheet.setCvs(createAncRequest.getCvs());
        ancCaseSheet.setRs(createAncRequest.getRs());
        ancCaseSheet.setUtreusSize(createAncRequest.getUtreusSize());
        ancCaseSheet.setSymphosisFundal(createAncRequest.getSymphosisFundal());
        ancCaseSheet.setFeatolHeartRate(createAncRequest.getFeatolHeartRate());
        ancCaseSheet.setPresentationAb(createAncRequest.getPresentationAb());
        ancCaseSheet.setEngaged(createAncRequest.getEngaged());
        ancCaseSheet.setCervix(createAncRequest.getCervix());
        ancCaseSheet.setDilatation(createAncRequest.getDilatation());
        ancCaseSheet.setEffacement(createAncRequest.getEffacement());
        ancCaseSheet.setPresentationPV(createAncRequest.getPresentationPV());
        ancCaseSheet.setStation(createAncRequest.getStation());
        ancCaseSheet.setMembrane(createAncRequest.getMembrane());
        ancCaseSheet.setPelvis(createAncRequest.getPelvis());
        ancCaseSheet.setDiabetes(createAncRequest.getDiabetes());
        ancCaseSheet.setHypertension(createAncRequest.getHypertension());
        ancCaseSheet.setAsthma(createAncRequest.getAsthma());
        ancCaseSheet.setSeiure(createAncRequest.getSeiure());
        ancCaseSheet.setCardiacDisease(createAncRequest.getCardiacDisease());
        ancCaseSheet.setTb(createAncRequest.getTb());
        ancCaseSheet.setThyroidDisorder(createAncRequest.getThyroidDisorder());
        ancCaseSheet.setStDose1(createAncRequest.getStDose1());
        ancCaseSheet.setStDoseIn(createAncRequest.getStDoseIn());
        ancCaseSheet.setNdDose2(createAncRequest.getNdDose2());
        ancCaseSheet.setNdDoseIn(createAncRequest.getNdDoseIn());
        ancCaseSheet.setRiskFactor(createAncRequest.getRiskFactor());

        ancCaseSheet.setWeight(createAncRequest.getWeight());
        ancCaseSheet.setHeight(createAncRequest.getHeight());
        ancCaseSheet.setBmi(createAncRequest.getBmi());
        ancCaseSheet.setTemperature(createAncRequest.getTemperature());
        ancCaseSheet.setPulse(createAncRequest.getPulse());
        ancCaseSheet.setSpo2(createAncRequest.getSpo2());
        ancCaseSheet.setRr(createAncRequest.getRr());
        ancCaseSheet.setBp(createAncRequest.getBp());

        ancCaseSheet.setDocId(createAncRequest.getDocId());
        ancCaseSheet.setUpdateDocId(0L);

        ancCaseSheet.setIniSysOther(createAncRequest.getIniSysOther());
        ancCaseSheet.setIniPaOther(createAncRequest.getIniPaOther());
        ancCaseSheet.setIniPvOther(createAncRequest.getIniPvOther());

        ancCaseSheet.setMedicalHistory(createAncRequest.getMedicalHistory());
        ancCaseSheet.setOthers(createAncRequest.getOthers());
        ancCaseSheet.setIsDelivered(createAncRequest.getIsDelivered());

        ancCaseSheet.setDiabetesNotes(createAncRequest.getDiabetesNotes());
        ancCaseSheet.setHypertensionNotes(createAncRequest.getHypertensionNotes());
        ancCaseSheet.setAsthmaNotes(createAncRequest.getAsthmaNotes());
        ancCaseSheet.setSeiureNotes(createAncRequest.getSeiureNotes());
        ancCaseSheet.setCardiacNotes(createAncRequest.getCardiacNotes());
        ancCaseSheet.setTbNotes(createAncRequest.getTbNotes());
        ancCaseSheet.setThyroidDisorderNotes(createAncRequest.getThyroidDisorderNotes());
        ancCaseSheet.setOthersNotes(createAncRequest.getOthersNotes());
        ancCaseSheet.setInitialAppointmentDate("0000-00-00");
        ancCaseSheet.setInitialAppointmentPlan(createAncRequest.getInitialAppointmentPlan());

        ancCaseSheet.setOthersPlan(createAncRequest.getOthersPlan());
        ancCaseSheet.setPersonalInfo(createAncRequest.getPersonalInfo());

        // ancCaseSheet.setDtm(DateTimeUtils.convertLocalDateToDateTimeFormat(LocalDateTime.now()));

        return ancCaseSheet;
    }
    public void update(final CreateAncRequest createAncRequest) {

//        this.setPatId(createAncRequest.getPatId());
//        this.setVstId(createAncRequest.getVstId());
        this.setCtime(createAncRequest.getCtime());
        this.setCdate(DateTimeUtils.convertLocalDateToDateFormat(LocalDate.now()));
        this.setG(createAncRequest.getG());
        this.setP(createAncRequest.getP());
        this.setL(createAncRequest.getL());
        this.setA(createAncRequest.getA());
        this.setD(createAncRequest.getD());
        this.setLmp(createAncRequest.getLmp());
        this.setEdd(createAncRequest.getEdd());
        this.setSedd(createAncRequest.getSedd());
        this.setGa(createAncRequest.getGa());
        this.setDurationofmarriage(createAncRequest.getDurationofmarriage());
        this.setConsanguinity(createAncRequest.getConsanguinity());
        this.setConception(createAncRequest.getConception());
        this.setMenstrualHis(createAncRequest.getMenstrualHis());
        this.setMenstrualOthers(createAncRequest.getMenstrualOthers());
        this.setSurgicalHistory(createAncRequest.getSurgicalHistory());
        this.setChiefhistory(createAncRequest.getChiefhistory());
        this.setAllergichistory(createAncRequest.getAllergichistory());
        this.setAllergichistory(createAncRequest.getAllergichistory());
        this.setHistoryPreIll(createAncRequest.getHistoryPreIll());
        this.setFamilyHistory(createAncRequest.getFamilyHistory());
        this.setOthersHis(createAncRequest.getOthersHis());
        this.setPallor(createAncRequest.getPallor());
        this.setIcterus(createAncRequest.getIcterus());
        this.setEdema(createAncRequest.getEdema());
        this.setCvs(createAncRequest.getCvs());
        this.setRs(createAncRequest.getRs());
        this.setUtreusSize(createAncRequest.getUtreusSize());
        this.setSymphosisFundal(createAncRequest.getSymphosisFundal());
        this.setFeatolHeartRate(createAncRequest.getFeatolHeartRate());
        this.setPresentationAb(createAncRequest.getPresentationAb());
        this.setEngaged(createAncRequest.getEngaged());
        this.setCervix(createAncRequest.getCervix());
        this.setDilatation(createAncRequest.getDilatation());
        this.setEffacement(createAncRequest.getEffacement());
        this.setPresentationPV(createAncRequest.getPresentationPV());
        this.setStation(createAncRequest.getStation());
        this.setMembrane(createAncRequest.getMembrane());
        this.setPelvis(createAncRequest.getPelvis());
        this.setDiabetes(createAncRequest.getDiabetes());
        this.setHypertension(createAncRequest.getHypertension());
        this.setAsthma(createAncRequest.getAsthma());
        this.setSeiure(createAncRequest.getSeiure());
        this.setCardiacDisease(createAncRequest.getCardiacDisease());
        this.setTb(createAncRequest.getTb());
        this.setThyroidDisorder(createAncRequest.getThyroidDisorder());
        this.setStDose1(createAncRequest.getStDose1());
        this.setStDoseIn(createAncRequest.getStDoseIn());
        this.setNdDose2(createAncRequest.getNdDose2());
        this.setNdDoseIn(createAncRequest.getNdDoseIn());
        this.setRiskFactor(createAncRequest.getRiskFactor());
        this.setMedicalHistory(createAncRequest.getMedicalHistory());
        this.setOthers(createAncRequest.getOthers());
        this.setIsDelivered(createAncRequest.getIsDelivered());

        this.setBp(createAncRequest.getBp());
        this.setTemperature(createAncRequest.getTemperature());
        this.setRr(createAncRequest.getRr());
        this.setPulse(createAncRequest.getPulse());
        this.setSpo2(createAncRequest.getSpo2());
        this.setWeight(createAncRequest.getWeight());
        this.setHeight(createAncRequest.getHeight());
        this.setBmi(createAncRequest.getBmi());

        this.setUpdateDocId(createAncRequest.getDocId());

        this.setIniSysOther(createAncRequest.getIniSysOther());
        this.setIniPaOther(createAncRequest.getIniPaOther());
        this.setIniPvOther(createAncRequest.getIniPvOther());

        this.setDiabetesNotes(createAncRequest.getDiabetesNotes());
        this.setHypertensionNotes(createAncRequest.getHypertensionNotes());
        this.setAsthmaNotes(createAncRequest.getAsthmaNotes());
        this.setSeiureNotes(createAncRequest.getSeiureNotes());
        this.setCardiacNotes(createAncRequest.getCardiacNotes());
        this.setTbNotes(createAncRequest.getTbNotes());
        this.setThyroidDisorderNotes(createAncRequest.getThyroidDisorderNotes());
        this.setOthersNotes(createAncRequest.getOthersNotes());
        this.setInitialAppointmentDate("0000-00-00");
        this.setInitialAppointmentPlan(createAncRequest.getInitialAppointmentPlan());

        this.setOthersPlan(createAncRequest.getOthersPlan());
        this.setPersonalInfo(createAncRequest.getPersonalInfo());

    }

}
