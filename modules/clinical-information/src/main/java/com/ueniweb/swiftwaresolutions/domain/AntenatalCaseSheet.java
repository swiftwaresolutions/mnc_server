package com.ueniweb.swiftwaresolutions.domain;

import com.ueniweb.swiftwaresolutions.request.CreateAntenatalCaseSheetRequest;

import com.ueniweb.swiftwaresolutions.utils.DateTimeUtils;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity(name = "AntenatalCaseSheet")
@Table(name = "cli_antenatal_master")
public class AntenatalCaseSheet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "patId", nullable = false)
    @Basic(optional = false)
    private Long patId;

    @Column(name = "vstId", nullable = false)
    @Basic(optional = false)
    private Long vstId;

    @Column(name = "ipId",nullable = false)
    @Basic(optional = false)
    private Long ipId;

    @Column(name = "time")
    @Basic(optional = false)
    private String time;

    @Column(name = "date")
    @Basic(optional = false)
    private String date;

    @Column(name = "durationofmarriage")
    @Basic(optional = false)
    private String durationofmarriage;

    @Column(name = "Consanguinity")
    @Basic(optional = false)
    private String consanguinity;

    @Column(name = "Conception")
    @Basic(optional = false)
    private String conception;

    @Column(name = "Menstrualhistory")
    @Basic(optional = false)
    private String menstrualhistory;

    @Column(name = "Hypertension")
    @Basic(optional = false)
    private String hypertension;

    @Column(name = "DiabetesMellitus")
    @Basic(optional = false)
    private String diabetesMellitus;

    @Column(name = "TwinGestation")
    @Basic(optional = false)
    private String twinGestation;

    @Column(name = "Chiefcomplaints")
    @Basic(optional = false)
    private String chiefcomplaints;

    @Column(name = "Historyofpresentillness")
    @Basic(optional = false)
    private String historyofpresentillness;

    @Column(name = "Menstrualhistroy")
    @Basic(optional = false)
    private String menstrualhistroy;

    @Column(name = "Martialhistroy")
    @Basic(optional = false)
    private String martialhistroy;

    @Column(name = "FamilyHistory")
    @Basic(optional = false)
    private String familyHistory;

    @Column(name = "SurgicalHistory")
    @Basic(optional = false)
    private String surgicalHistory;

    @Column(name = "Allergichistory")
    @Basic(optional = false)
    private String allergichistory;

    @Column(name = "Others")
    @Basic(optional = false)
    private String others;

    @Column(name = "Instrumentaldelivery")
    @Basic(optional = false)
    private String instrumentaldelivery;

    @Column(name = "Eclampsia")
    @Basic(optional = false)
    private String eclampsia;

    @Column(name = "PostPartumHaemorrhage")
    @Basic(optional = false)
    private String postPartumHaemorrhage;

    @Column(name = "3ormoreabortions")
    @Basic(optional = false)
    private String ormoreabortions;

    @Column(name = "Previouspretermdelivery")
    @Basic(optional = false)
    private String previouspretermdelivery;

    @Column(name = "Stillbirthneonataldeath")
    @Basic(optional = false)
    private String stillbirthneonataldeath;

    @Column(name = "CaesareanSection")
    @Basic(optional = false)
    private String caesareanSection;

    @Column(name = "examDate")
    @Basic(optional = false)
    private String examDate;

    @Column(name = "weight")
    @Basic(optional = false)
    private String weight;

    @Column(name = "PedalOdema")
    @Basic(optional = false)
    private String pedalOdema;

    @Column(name = "Bp")
    @Basic(optional = false)
    private String bp;

    @Column(name = "Fundalheight")
    @Basic(optional = false)
    private String fundalheight;

    @Column(name = "Presentation")
    @Basic(optional = false)
    private String presentation;

    @Column(name = "fhs")
    @Basic(optional = false)
    private String fhs;

    @Column(name = "pallor")
    @Basic(optional = false)
    private String pallor;

    @Column(name = "iceturs")
    @Basic(optional = false)
    private String iceturs;

    @Column(name = "cyanosis")
    @Basic(optional = false)
    private String cyanosis;

    @Column(name = "clubbing")
    @Basic(optional = false)
    private String clubbing;

    @Column(name = "lymphadenopathy")
    @Basic(optional = false)
    private String lymphadenopathy;

    @Column(name = "edama")
    @Basic(optional = false)
    private String edama;

    @Column(name = "Lmp")
    @Basic(optional = false)
    private String lmp;

    @Column(name = "Edd")
    @Basic(optional = false)
    private String edd;

    @Column(name = "Ga")
    private String ga;

    @Column(name = "G")
    private String g;

    @Column(name = "P")
    private String p;

    @Column(name = "L")
    private String l;

    @Column(name = "A")
    private String a;

    @Column(name = "Modeofconception")
    private String modeofconception;

    @Column(name = "RedDischange")
    private String redDischange;

    @Column(name = "RedDischangeInput", columnDefinition = "TEXT")
    private String redDischangeInput;

    @Column(name = "Vomiting")
    private String vomiting;

    @Column(name = "VomitingInput", columnDefinition = "TEXT")
    private String vomitingInput;

    @Column(name = "UrinComp")
    private String urinComp;

    @Column(name = "UrinCompInput", columnDefinition = "TEXT")
    private String urinCompInput;

    @Column(name = "TakeFolSupplement")
    private String takeFolSupplement;

    @Column(name = "TakeFolSupplementInput", columnDefinition = "TEXT")
    private String takeFolSupplementInput;

    @Column(name = "HisFoldFever")
    private String hisFoldFever;

    @Column(name = "HisFoldFeverInput", columnDefinition = "TEXT")
    private String hisFoldFeverInput;

    @Column(name = "Quidceing")
    private String quidceing;

    @Column(name = "Quidceinginput", columnDefinition = "TEXT")
    private String quidceinginput;

    @Column(name = "AnyHistory", columnDefinition = "TEXT")
    private String anyHistory;

    @Column(name = "1stDose")
    private String stDose;

    @Column(name = "2ndDose")
    private String ndDose;

    @Column(name = "dose3")
    private String dose3;

    @Column(name = "PerFutalmovement")
    private String perFutalmovement;

    @Column(name = "PerFutalMovementIn", columnDefinition = "TEXT")
    private String perFutalMovementIn;

    @Column(name = "bleeding")
    private String bleeding;

    @Column(name = "bleedingInput", columnDefinition = "TEXT")
    private String bleedingInput;

    @Column(name = "AnyComplaints")
    private String anyComplaints;

    @Column(name = "AnyComplaintsInput", columnDefinition = "TEXT")
    private String anyComplaintsInput;

    @Column(name = "PrimiUnder")
    private String primiUnder;

    @Column(name = "PrimiAbove")
    private String primiAbove;

    @Column(name = "AgeAbove")
    private String ageAbove;

    @Column(name = "PregnanceAfter")
    private String pregnanceAfter;

    @Column(name = "Infertility")
    private String infertility;

    @Column(name = "FifthPregancy")
    private String fifthPregancy;

    @Column(name = "HeightD")
    private String heightD;

    @Column(name = "SystemicDisease")
    private String systemicDisease;

    @Column(name = "ThreatenedAbortion")
    private String threatenedAbortion;

    @Column(name = "GestationExceeding")
    private String gestationExceeding;

    @Column(name = "PrematureLabour")
    private String prematureLabour;

    @Column(name = "Apa")
    private String apa;

    @Column(name = "Abnormalpresentation")
    private String abnormalpresentation;

    @Column(name = "IUGR")
    private String iugr;

    @Column(name = "Multiplepregnancy")
    private String multiplepregnancy;

    @Column(name = "Hydraminos")
    private String hydraminos;

    @Column(name = "PIH")
    private String pih;

    @Column(name = "ServerAnaemia")
    private String serverAnaemia;

    @Column(name = "CardiacDisease")
    private String cardiacDisease;

    @Column(name = "GDMonOHA")
    private String gDMonOHA;

    @Column(name = "GDMoninsulin")
    private String gDMoninsulin;

    @Column(name = "temperature")
    private String temperature;

    @Column(name = "Pulse")
    private String Pulse;

    @Column(name = "rr")
    private String rr;

    @Column(name = "Fhr")
    private String Fhr;

    @Column(name = "Engagement")
    private String Engagement;

    @Column(name = "lie")
    private String lie;

    @Column(name = "FinalGestationalAge")
    private String FinalGestationalAge;

    @Column(name = "usgAge")
    private String usgAge;

    @Column(name = "Cervicaldilation")
    private String Cervicaldilation;

    @Column(name = "Cervicaleffacement")
    private String Cervicaleffacement;

    @Column(name = "Membrane")
    private String Membrane;

    @Column(name = "Clrfluid")
    private String Clrfluid;

    @Column(name = "Station")
    private String Station;

    @Column(name = "Pelvisadequate")
    private String Pelvisadequate;

    @Column(name = "LabExam")
    private String LabExam;

    @Column(name = "USGExam")
    private String USGExam;

    @Column(name = "otherExam")
    private String otherExam;

    @Column(name = "comboteim2")
    private String comboteim2;

    @Column(name = "comboteim2In")
    private String comboteim2In;

    @Column(name = "comboteim3")
    private String comboteim3;

    @Column(name = "comboteim3In")
    private String comboteim3In;

    @Column(name = "medicalHis")
    private String medicalHis;

    @Column(name = "anemiaPre")
    private String anemiaPre;

    @Column(name = "obstructedlabour")
    private String obstructedlabour;

    @Column(name = "aphpph")
    private String aphpph;

    @Column(name = "congenitalAnomaly")
    private String congenitalAnomaly;

    @Column(name = "othesPreRisk")
    private String othesPreRisk;

    @Column(name = "ifCaesarean")
    private String ifCaesarean;

    @Column(name = "1stDose2")
    private String stDose2;

    @Column(name = "1stDoseIn")
    private String stDoseIn;

    @Column(name = "2ndDose2")
    private String ndDose2;

    @Column(name = "2ndDoseIn")
    private String ndDoseIn;

    @Column(name = "booster")
    private String booster;

    @Column(name = "boosterIn")
    private String boosterIn;

    @Column(name = "trimester1")
    private String trimester1;

    @Column(name = "trimester2")
    private String trimester2;

    @Column(name = "trimester3")
    private String trimester3;

    @Column(name = "shortgravida")
    private String shortgravida;

    @Column(name = "teenagePrimi")
    private String teenagePrimi;

    @Column(name = "pregnancyInfertility")
    private String pregnancyInfertility;

    @Column(name = "gth")
    private String gth;

    @Column(name = "elderlyGravida")
    private String elderlyGravida;

    @Column(name = "grandmulti")
    private String grandmulti;

    @Column(name = "gawks")
    private String gawks;

    @Column(name = "anemiaCur")
    private String anemiaCur;

    @Column(name = "chronicDisease")
    private String chronicDisease;

    @Column(name = "othesCurRisk")
    private String othesCurRisk;

    @Column(name = "dtm")
    private String dtm;

    @OneToMany(mappedBy = "ancId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AntenatalCaseSheetPrevious> antenatalCaseSheetPreviousList = new ArrayList<>();


    public static AntenatalCaseSheet to(final CreateAntenatalCaseSheetRequest createAntenatalCaseSheetRequest){
        AntenatalCaseSheet antenatalCaseSheet = new AntenatalCaseSheet();
        antenatalCaseSheet.setPatId(createAntenatalCaseSheetRequest.getPatId());
        antenatalCaseSheet.setVstId(createAntenatalCaseSheetRequest.getVstId());
        antenatalCaseSheet.setIpId(createAntenatalCaseSheetRequest.getIpId());
        antenatalCaseSheet.setTime(createAntenatalCaseSheetRequest.getTime());
        antenatalCaseSheet.setDate(createAntenatalCaseSheetRequest.getDate());
        antenatalCaseSheet.setDurationofmarriage(createAntenatalCaseSheetRequest.getDurationofmarriage());
        antenatalCaseSheet.setConsanguinity(createAntenatalCaseSheetRequest.getConsanguinity());
        antenatalCaseSheet.setConception(createAntenatalCaseSheetRequest.getConception());
        antenatalCaseSheet.setMenstrualhistory(createAntenatalCaseSheetRequest.getMenstrualhistory());
        antenatalCaseSheet.setHypertension(createAntenatalCaseSheetRequest.getHypertension());
        antenatalCaseSheet.setDiabetesMellitus(createAntenatalCaseSheetRequest.getDiabetesMellitus());
        antenatalCaseSheet.setTwinGestation(createAntenatalCaseSheetRequest.getTwinGestation());
        antenatalCaseSheet.setChiefcomplaints(createAntenatalCaseSheetRequest.getChiefcomplaints());
        antenatalCaseSheet.setHistoryofpresentillness(createAntenatalCaseSheetRequest.getHistoryofpresentillness());
        antenatalCaseSheet.setMenstrualhistroy(createAntenatalCaseSheetRequest.getMenstrualhistroy());
        antenatalCaseSheet.setMartialhistroy(createAntenatalCaseSheetRequest.getMartialhistroy());
        antenatalCaseSheet.setPallor(createAntenatalCaseSheetRequest.getPallor());
        antenatalCaseSheet.setFamilyHistory(createAntenatalCaseSheetRequest.getFamilyHistory());
        antenatalCaseSheet.setSurgicalHistory(createAntenatalCaseSheetRequest.getSurgicalHistory());
        antenatalCaseSheet.setAllergichistory(createAntenatalCaseSheetRequest.getAllergichistory());
        antenatalCaseSheet.setOthers(createAntenatalCaseSheetRequest.getOthers());
        antenatalCaseSheet.setInstrumentaldelivery(createAntenatalCaseSheetRequest.getInstrumentaldelivery());
        antenatalCaseSheet.setEclampsia(createAntenatalCaseSheetRequest.getEclampsia());
        antenatalCaseSheet.setPostPartumHaemorrhage(createAntenatalCaseSheetRequest.getPostPartumHaemorrhage());
        antenatalCaseSheet.setOrmoreabortions(createAntenatalCaseSheetRequest.getOrmoreabortions());
        antenatalCaseSheet.setPreviouspretermdelivery(createAntenatalCaseSheetRequest.getPreviouspretermdelivery());
        antenatalCaseSheet.setStillbirthneonataldeath(createAntenatalCaseSheetRequest.getStillbirthneonataldeath());
        antenatalCaseSheet.setCaesareanSection(createAntenatalCaseSheetRequest.getCaesareanSection());
        antenatalCaseSheet.setExamDate(createAntenatalCaseSheetRequest.getExamDate());
        antenatalCaseSheet.setWeight(createAntenatalCaseSheetRequest.getWeight());
        antenatalCaseSheet.setPedalOdema(createAntenatalCaseSheetRequest.getPedalOdema());
        antenatalCaseSheet.setBp(createAntenatalCaseSheetRequest.getBp());
        antenatalCaseSheet.setFundalheight(createAntenatalCaseSheetRequest.getFundalheight());
        antenatalCaseSheet.setPresentation(createAntenatalCaseSheetRequest.getPresentation());
        antenatalCaseSheet.setFhs(createAntenatalCaseSheetRequest.getFhs());
        antenatalCaseSheet.setPallor(createAntenatalCaseSheetRequest.getPallor());
        antenatalCaseSheet.setIceturs(createAntenatalCaseSheetRequest.getIceturs());
        antenatalCaseSheet.setCyanosis(createAntenatalCaseSheetRequest.getCyanosis());
        antenatalCaseSheet.setClubbing(createAntenatalCaseSheetRequest.getClubbing());
        antenatalCaseSheet.setLymphadenopathy(createAntenatalCaseSheetRequest.getLymphadenopathy());
        antenatalCaseSheet.setEdama(createAntenatalCaseSheetRequest.getEdama());
        antenatalCaseSheet.setLmp(createAntenatalCaseSheetRequest.getLmp());
        antenatalCaseSheet.setEdd(createAntenatalCaseSheetRequest.getEdd());
        antenatalCaseSheet.setGa(createAntenatalCaseSheetRequest.getGa());
        antenatalCaseSheet.setG(createAntenatalCaseSheetRequest.getG());
        antenatalCaseSheet.setP(createAntenatalCaseSheetRequest.getP());
        antenatalCaseSheet.setL(createAntenatalCaseSheetRequest.getL());
        antenatalCaseSheet.setA(createAntenatalCaseSheetRequest.getA());
        antenatalCaseSheet.setModeofconception(createAntenatalCaseSheetRequest.getModeofconception());
        antenatalCaseSheet.setRedDischange(createAntenatalCaseSheetRequest.getRedDischange());
        antenatalCaseSheet.setRedDischangeInput(createAntenatalCaseSheetRequest.getRedDischangeInput());
        antenatalCaseSheet.setVomiting(createAntenatalCaseSheetRequest.getVomiting());
        antenatalCaseSheet.setVomitingInput(createAntenatalCaseSheetRequest.getVomitingInput());
        antenatalCaseSheet.setUrinComp(createAntenatalCaseSheetRequest.getUrinComp());
        antenatalCaseSheet.setUrinCompInput(createAntenatalCaseSheetRequest.getUrinCompInput());
        antenatalCaseSheet.setTakeFolSupplement(createAntenatalCaseSheetRequest.getTakeFolSupplement());
        antenatalCaseSheet.setTakeFolSupplementInput(createAntenatalCaseSheetRequest.getTakeFolSupplementInput());
        antenatalCaseSheet.setHisFoldFever(createAntenatalCaseSheetRequest.getHisFoldFever());
        antenatalCaseSheet.setHisFoldFeverInput(createAntenatalCaseSheetRequest.getHisFoldFeverInput());
        antenatalCaseSheet.setQuidceing(createAntenatalCaseSheetRequest.getQuidceing());
        antenatalCaseSheet.setQuidceinginput(createAntenatalCaseSheetRequest.getQuidceinginput());
        antenatalCaseSheet.setAnyHistory(createAntenatalCaseSheetRequest.getAnyHistory());
        antenatalCaseSheet.setStDose(createAntenatalCaseSheetRequest.getStDose());
        antenatalCaseSheet.setNdDose(createAntenatalCaseSheetRequest.getNdDose());
        antenatalCaseSheet.setDose3(createAntenatalCaseSheetRequest.getDose3());
        antenatalCaseSheet.setPerFutalmovement(createAntenatalCaseSheetRequest.getPerFutalmovement());
        antenatalCaseSheet.setPerFutalMovementIn(createAntenatalCaseSheetRequest.getPerFutalMovementIn());
        antenatalCaseSheet.setBleeding(createAntenatalCaseSheetRequest.getBleeding());
        antenatalCaseSheet.setBleedingInput(createAntenatalCaseSheetRequest.getBleedingInput());
        antenatalCaseSheet.setAnyComplaints(createAntenatalCaseSheetRequest.getAnyComplaints());
        antenatalCaseSheet.setAnyComplaintsInput(createAntenatalCaseSheetRequest.getAnyComplaintsInput());
        antenatalCaseSheet.setPrimiUnder(createAntenatalCaseSheetRequest.getPrimiUnder());
        antenatalCaseSheet.setPrimiAbove(createAntenatalCaseSheetRequest.getPrimiAbove());
        antenatalCaseSheet.setAgeAbove(createAntenatalCaseSheetRequest.getAgeAbove());
        antenatalCaseSheet.setPregnanceAfter(createAntenatalCaseSheetRequest.getPregnanceAfter());
        antenatalCaseSheet.setInfertility(createAntenatalCaseSheetRequest.getInfertility());
        antenatalCaseSheet.setFifthPregancy(createAntenatalCaseSheetRequest.getFifthPregancy());
        antenatalCaseSheet.setHeightD(createAntenatalCaseSheetRequest.getHeightD());
        antenatalCaseSheet.setSystemicDisease(createAntenatalCaseSheetRequest.getSystemicDisease());
        antenatalCaseSheet.setThreatenedAbortion(createAntenatalCaseSheetRequest.getThreatenedAbortion());
        antenatalCaseSheet.setGestationExceeding(createAntenatalCaseSheetRequest.getGestationExceeding());
        antenatalCaseSheet.setPrematureLabour(createAntenatalCaseSheetRequest.getPrematureLabour());
        antenatalCaseSheet.setApa(createAntenatalCaseSheetRequest.getApa());
        antenatalCaseSheet.setAbnormalpresentation(createAntenatalCaseSheetRequest.getAbnormalpresentation());
        antenatalCaseSheet.setIugr(createAntenatalCaseSheetRequest.getIugr());
        antenatalCaseSheet.setMultiplepregnancy(createAntenatalCaseSheetRequest.getMultiplepregnancy());
        antenatalCaseSheet.setHydraminos(createAntenatalCaseSheetRequest.getHydraminos());
        antenatalCaseSheet.setPih(createAntenatalCaseSheetRequest.getPih());
        antenatalCaseSheet.setServerAnaemia(createAntenatalCaseSheetRequest.getServerAnaemia());
        antenatalCaseSheet.setCardiacDisease(createAntenatalCaseSheetRequest.getCardiacDisease());
        antenatalCaseSheet.setGDMonOHA(createAntenatalCaseSheetRequest.getGDMonOHA());
        antenatalCaseSheet.setGDMoninsulin(createAntenatalCaseSheetRequest.getGDMoninsulin());
        antenatalCaseSheet.setTemperature(createAntenatalCaseSheetRequest.getTemperature());
        antenatalCaseSheet.setPulse(createAntenatalCaseSheetRequest.getPulse());
        antenatalCaseSheet.setRr(createAntenatalCaseSheetRequest.getRr());
        antenatalCaseSheet.setFhr(createAntenatalCaseSheetRequest.getFhr());
        antenatalCaseSheet.setEngagement(createAntenatalCaseSheetRequest.getEngagement());
        antenatalCaseSheet.setLie(createAntenatalCaseSheetRequest.getLie());
        antenatalCaseSheet.setFinalGestationalAge(createAntenatalCaseSheetRequest.getFinalGestationalAge());
        antenatalCaseSheet.setUsgAge(createAntenatalCaseSheetRequest.getUsgAge());
        antenatalCaseSheet.setCervicaldilation(createAntenatalCaseSheetRequest.getCervicaldilation());
        antenatalCaseSheet.setCervicaleffacement(createAntenatalCaseSheetRequest.getCervicaleffacement());
        antenatalCaseSheet.setMembrane(createAntenatalCaseSheetRequest.getMembrane());
        antenatalCaseSheet.setClrfluid(createAntenatalCaseSheetRequest.getClrfluid());
        antenatalCaseSheet.setStation(createAntenatalCaseSheetRequest.getStation());
        antenatalCaseSheet.setPelvisadequate(createAntenatalCaseSheetRequest.getPelvisadequate());
        antenatalCaseSheet.setLabExam(createAntenatalCaseSheetRequest.getLabExam());
        antenatalCaseSheet.setUSGExam(createAntenatalCaseSheetRequest.getUSGExam());
        antenatalCaseSheet.setOtherExam(createAntenatalCaseSheetRequest.getOtherExam());
        antenatalCaseSheet.setComboteim2(createAntenatalCaseSheetRequest.getComboteim2());
        antenatalCaseSheet.setComboteim2In(createAntenatalCaseSheetRequest.getComboteim2In());
        antenatalCaseSheet.setComboteim3(createAntenatalCaseSheetRequest.getComboteim3());
        antenatalCaseSheet.setComboteim3In(createAntenatalCaseSheetRequest.getComboteim3In());
        antenatalCaseSheet.setMedicalHis(createAntenatalCaseSheetRequest.getMedicalHis());
        antenatalCaseSheet.setAnemiaPre(createAntenatalCaseSheetRequest.getAnemiaPre());
        antenatalCaseSheet.setObstructedlabour(createAntenatalCaseSheetRequest.getObstructedlabour());
        antenatalCaseSheet.setAphpph(createAntenatalCaseSheetRequest.getAphpph());
        antenatalCaseSheet.setCongenitalAnomaly(createAntenatalCaseSheetRequest.getCongenitalAnomaly());
        antenatalCaseSheet.setOthesPreRisk(createAntenatalCaseSheetRequest.getOthesPreRisk());
        antenatalCaseSheet.setIfCaesarean(createAntenatalCaseSheetRequest.getIfCaesarean());
        antenatalCaseSheet.setStDose2(createAntenatalCaseSheetRequest.getStDose2());
        antenatalCaseSheet.setStDoseIn(createAntenatalCaseSheetRequest.getStDoseIn());
        antenatalCaseSheet.setNdDose2(createAntenatalCaseSheetRequest.getNdDose2());
        antenatalCaseSheet.setNdDoseIn(createAntenatalCaseSheetRequest.getNdDoseIn());
        antenatalCaseSheet.setBooster(createAntenatalCaseSheetRequest.getBooster());
        antenatalCaseSheet.setBoosterIn(createAntenatalCaseSheetRequest.getBoosterIn());
        antenatalCaseSheet.setTrimester1(createAntenatalCaseSheetRequest.getTrimester1());
        antenatalCaseSheet.setTrimester2(createAntenatalCaseSheetRequest.getTrimester2());
        antenatalCaseSheet.setTrimester3(createAntenatalCaseSheetRequest.getTrimester3());
        antenatalCaseSheet.setShortgravida(createAntenatalCaseSheetRequest.getShortgravida());
        antenatalCaseSheet.setTeenagePrimi(createAntenatalCaseSheetRequest.getTeenagePrimi());
        antenatalCaseSheet.setPregnancyInfertility(createAntenatalCaseSheetRequest.getPregnancyInfertility());
        antenatalCaseSheet.setGth(createAntenatalCaseSheetRequest.getGth());
        antenatalCaseSheet.setElderlyGravida(createAntenatalCaseSheetRequest.getElderlyGravida());
        antenatalCaseSheet.setGrandmulti(createAntenatalCaseSheetRequest.getGrandmulti());
        antenatalCaseSheet.setGawks(createAntenatalCaseSheetRequest.getGawks());
        antenatalCaseSheet.setAnemiaCur(createAntenatalCaseSheetRequest.getAnemiaCur());
        antenatalCaseSheet.setChronicDisease(createAntenatalCaseSheetRequest.getChronicDisease());
        antenatalCaseSheet.setOthesCurRisk(createAntenatalCaseSheetRequest.getOthesCurRisk());
        antenatalCaseSheet.setDtm(DateTimeUtils.convertLocalDateToDateTimeFormat(LocalDateTime.now()));


        return antenatalCaseSheet;
    }

    public void update(final CreateAntenatalCaseSheetRequest createAntenatalCaseSheetRequest){


        this.setPatId(createAntenatalCaseSheetRequest.getPatId());
        this.setVstId(createAntenatalCaseSheetRequest.getVstId());
        this.setIpId(createAntenatalCaseSheetRequest.getIpId());
        this.setTime(createAntenatalCaseSheetRequest.getTime());
        this.setDate(createAntenatalCaseSheetRequest.getDate());
        this.setDurationofmarriage(createAntenatalCaseSheetRequest.getDurationofmarriage());
        this.setConsanguinity(createAntenatalCaseSheetRequest.getConsanguinity());
        this.setConception(createAntenatalCaseSheetRequest.getConception());
        this.setMenstrualhistory(createAntenatalCaseSheetRequest.getMenstrualhistory());
        this.setHypertension(createAntenatalCaseSheetRequest.getHypertension());
        this.setDiabetesMellitus(createAntenatalCaseSheetRequest.getDiabetesMellitus());
        this.setTwinGestation(createAntenatalCaseSheetRequest.getTwinGestation());
        this.setChiefcomplaints(createAntenatalCaseSheetRequest.getChiefcomplaints());
        this.setHistoryofpresentillness(createAntenatalCaseSheetRequest.getHistoryofpresentillness());
        this.setMenstrualhistroy(createAntenatalCaseSheetRequest.getMenstrualhistroy());
        this.setMartialhistroy(createAntenatalCaseSheetRequest.getMartialhistroy());
        this.setPallor(createAntenatalCaseSheetRequest.getPallor());
        this.setFamilyHistory(createAntenatalCaseSheetRequest.getFamilyHistory());
        this.setSurgicalHistory(createAntenatalCaseSheetRequest.getSurgicalHistory());
        this.setAllergichistory(createAntenatalCaseSheetRequest.getAllergichistory());
        this.setOthers(createAntenatalCaseSheetRequest.getOthers());
        this.setInstrumentaldelivery(createAntenatalCaseSheetRequest.getInstrumentaldelivery());
        this.setEclampsia(createAntenatalCaseSheetRequest.getEclampsia());
        this.setPostPartumHaemorrhage(createAntenatalCaseSheetRequest.getPostPartumHaemorrhage());
        this.setOrmoreabortions(createAntenatalCaseSheetRequest.getOrmoreabortions());
        this.setPreviouspretermdelivery(createAntenatalCaseSheetRequest.getPreviouspretermdelivery());
        this.setStillbirthneonataldeath(createAntenatalCaseSheetRequest.getStillbirthneonataldeath());
        this.setCaesareanSection(createAntenatalCaseSheetRequest.getCaesareanSection());
        this.setExamDate(createAntenatalCaseSheetRequest.getExamDate());
        this.setWeight(createAntenatalCaseSheetRequest.getWeight());
        this.setPedalOdema(createAntenatalCaseSheetRequest.getPedalOdema());
        this.setBp(createAntenatalCaseSheetRequest.getBp());
        this.setFundalheight(createAntenatalCaseSheetRequest.getFundalheight());
        this.setPresentation(createAntenatalCaseSheetRequest.getPresentation());
        this.setFhs(createAntenatalCaseSheetRequest.getFhs());
        this.setPallor(createAntenatalCaseSheetRequest.getPallor());
        this.setIceturs(createAntenatalCaseSheetRequest.getIceturs());
        this.setCyanosis(createAntenatalCaseSheetRequest.getIceturs());
        this.setClubbing(createAntenatalCaseSheetRequest.getClubbing());
        this.setLymphadenopathy(createAntenatalCaseSheetRequest.getLymphadenopathy());
        this.setEdama(createAntenatalCaseSheetRequest.getEdama());
        this.setLmp(createAntenatalCaseSheetRequest.getLmp());
        this.setEdd(createAntenatalCaseSheetRequest.getEdd());
        this.setGa(createAntenatalCaseSheetRequest.getGa());
        this.setG(createAntenatalCaseSheetRequest.getG());
        this.setP(createAntenatalCaseSheetRequest.getP());
        this.setL(createAntenatalCaseSheetRequest.getL());
        this.setA(createAntenatalCaseSheetRequest.getA());
        this.setModeofconception(createAntenatalCaseSheetRequest.getModeofconception());
        this.setRedDischange(createAntenatalCaseSheetRequest.getRedDischange());
        this.setRedDischangeInput(createAntenatalCaseSheetRequest.getRedDischangeInput());
        this.setVomiting(createAntenatalCaseSheetRequest.getVomiting());
        this.setVomitingInput(createAntenatalCaseSheetRequest.getVomitingInput());
        this.setUrinComp(createAntenatalCaseSheetRequest.getUrinComp());
        this.setUrinCompInput(createAntenatalCaseSheetRequest.getUrinCompInput());
        this.setTakeFolSupplement(createAntenatalCaseSheetRequest.getTakeFolSupplement());
        this.setTakeFolSupplementInput(createAntenatalCaseSheetRequest.getTakeFolSupplementInput());
        this.setHisFoldFever(createAntenatalCaseSheetRequest.getHisFoldFever());
        this.setHisFoldFeverInput(createAntenatalCaseSheetRequest.getHisFoldFeverInput());
        this.setQuidceing(createAntenatalCaseSheetRequest.getQuidceing());
        this.setQuidceinginput(createAntenatalCaseSheetRequest.getQuidceinginput());
        this.setAnyHistory(createAntenatalCaseSheetRequest.getAnyHistory());
        this.setStDose(createAntenatalCaseSheetRequest.getStDose());
        this.setNdDose(createAntenatalCaseSheetRequest.getNdDose());
        this.setDose3(createAntenatalCaseSheetRequest.getDose3());
        this.setPerFutalmovement(createAntenatalCaseSheetRequest.getPerFutalmovement());
        this.setPerFutalMovementIn(createAntenatalCaseSheetRequest.getPerFutalMovementIn());
        this.setBleeding(createAntenatalCaseSheetRequest.getBleeding());
        this.setBleedingInput(createAntenatalCaseSheetRequest.getBleedingInput());
        this.setAnyComplaints(createAntenatalCaseSheetRequest.getAnyComplaints());
        this.setAnyComplaintsInput(createAntenatalCaseSheetRequest.getAnyComplaintsInput());
        this.setPrimiUnder(createAntenatalCaseSheetRequest.getPrimiUnder());
        this.setPrimiAbove(createAntenatalCaseSheetRequest.getPrimiAbove());
        this.setAgeAbove(createAntenatalCaseSheetRequest.getAgeAbove());
        this.setPregnanceAfter(createAntenatalCaseSheetRequest.getPregnanceAfter());
        this.setInfertility(createAntenatalCaseSheetRequest.getInfertility());
        this.setFifthPregancy(createAntenatalCaseSheetRequest.getFifthPregancy());
        this.setHeightD(createAntenatalCaseSheetRequest.getHeightD());
        this.setSystemicDisease(createAntenatalCaseSheetRequest.getSystemicDisease());
        this.setThreatenedAbortion(createAntenatalCaseSheetRequest.getThreatenedAbortion());
        this.setGestationExceeding(createAntenatalCaseSheetRequest.getGestationExceeding());
        this.setPrematureLabour(createAntenatalCaseSheetRequest.getPrematureLabour());
        this.setApa(createAntenatalCaseSheetRequest.getApa());
        this.setAbnormalpresentation(createAntenatalCaseSheetRequest.getAbnormalpresentation());
        this.setIugr(createAntenatalCaseSheetRequest.getIugr());
        this.setMultiplepregnancy(createAntenatalCaseSheetRequest.getMultiplepregnancy());
        this.setHydraminos(createAntenatalCaseSheetRequest.getHydraminos());
        this.setPih(createAntenatalCaseSheetRequest.getPih());
        this.setServerAnaemia(createAntenatalCaseSheetRequest.getServerAnaemia());
        this.setCardiacDisease(createAntenatalCaseSheetRequest.getCardiacDisease());
        this.setGDMonOHA(createAntenatalCaseSheetRequest.getGDMonOHA());
        this.setGDMoninsulin(createAntenatalCaseSheetRequest.getGDMoninsulin());
        this.setTemperature(createAntenatalCaseSheetRequest.getTemperature());
        this.setPulse(createAntenatalCaseSheetRequest.getPulse());
        this.setRr(createAntenatalCaseSheetRequest.getRr());
        this.setFhr(createAntenatalCaseSheetRequest.getFhr());
        this.setLie(createAntenatalCaseSheetRequest.getLie());
        this.setFinalGestationalAge(createAntenatalCaseSheetRequest.getFinalGestationalAge());
        this.setUsgAge(createAntenatalCaseSheetRequest.getUsgAge());
        this.setCervicaldilation(createAntenatalCaseSheetRequest.getCervicaldilation());
        this.setCervicaleffacement(createAntenatalCaseSheetRequest.getCervicaleffacement());
        this.setMembrane(createAntenatalCaseSheetRequest.getMembrane());
        this.setClrfluid(createAntenatalCaseSheetRequest.getClrfluid());
        this.setStation(createAntenatalCaseSheetRequest.getStation());
        this.setPelvisadequate(createAntenatalCaseSheetRequest.getPelvisadequate());
        this.setLabExam(createAntenatalCaseSheetRequest.getLabExam());
        this.setUSGExam(createAntenatalCaseSheetRequest.getUSGExam());
        this.setOtherExam(createAntenatalCaseSheetRequest.getOtherExam());
        this.setEngagement(createAntenatalCaseSheetRequest.getEngagement());
        this.setComboteim2(createAntenatalCaseSheetRequest.getComboteim2());
        this.setComboteim2In(createAntenatalCaseSheetRequest.getComboteim2In());
        this.setComboteim3(createAntenatalCaseSheetRequest.getComboteim3());
        this.setComboteim3In(createAntenatalCaseSheetRequest.getComboteim3In());
        this.setMedicalHis(createAntenatalCaseSheetRequest.getMedicalHis());
        this.setAnemiaPre(createAntenatalCaseSheetRequest.getAnemiaPre());
        this.setObstructedlabour(createAntenatalCaseSheetRequest.getObstructedlabour());
        this.setAphpph(createAntenatalCaseSheetRequest.getAphpph());
        this.setCongenitalAnomaly(createAntenatalCaseSheetRequest.getCongenitalAnomaly());
        this.setOthesPreRisk(createAntenatalCaseSheetRequest.getOthesPreRisk());
        this.setIfCaesarean(createAntenatalCaseSheetRequest.getIfCaesarean());
        this.setStDose2(createAntenatalCaseSheetRequest.getStDose2());
        this.setStDoseIn(createAntenatalCaseSheetRequest.getStDoseIn());
        this.setNdDose2(createAntenatalCaseSheetRequest.getNdDose2());
        this.setNdDoseIn(createAntenatalCaseSheetRequest.getNdDoseIn());
        this.setBooster(createAntenatalCaseSheetRequest.getBooster());
        this.setBoosterIn(createAntenatalCaseSheetRequest.getBoosterIn());
        this.setTrimester1(createAntenatalCaseSheetRequest.getTrimester1());
        this.setTrimester2(createAntenatalCaseSheetRequest.getTrimester2());
        this.setTrimester3(createAntenatalCaseSheetRequest.getTrimester3());
        this.setShortgravida(createAntenatalCaseSheetRequest.getShortgravida());
        this.setTeenagePrimi(createAntenatalCaseSheetRequest.getTeenagePrimi());
        this.setPregnancyInfertility(createAntenatalCaseSheetRequest.getPregnancyInfertility());
        this.setGth(createAntenatalCaseSheetRequest.getGth());
        this.setElderlyGravida(createAntenatalCaseSheetRequest.getElderlyGravida());
        this.setGrandmulti(createAntenatalCaseSheetRequest.getGrandmulti());
        this.setGawks(createAntenatalCaseSheetRequest.getGawks());
        this.setAnemiaCur(createAntenatalCaseSheetRequest.getAnemiaCur());
        this.setChronicDisease(createAntenatalCaseSheetRequest.getChronicDisease());
        this.setOthesCurRisk(createAntenatalCaseSheetRequest.getOthesCurRisk());
        this.setDtm(DateTimeUtils.convertLocalDateToDateTimeFormat(LocalDateTime.now()));






    }
}
