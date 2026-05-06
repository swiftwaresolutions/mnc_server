package com.ueniweb.swiftwaresolutions.domain;

import com.ueniweb.swiftwaresolutions.request.CreateAncDetailsRequest;
import com.ueniweb.swiftwaresolutions.request.CreateAncRequest;
import com.ueniweb.swiftwaresolutions.request.CreateAntenatalPreviousCaseSheetRequest;
import com.ueniweb.swiftwaresolutions.request.CreatePrescriptionDetailsRequest;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Data
@Entity(name = "AncDetailsSheet")
@Table(name = "cli_anc_details")
@Getter
@Setter
public class AncDetailsSheet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //    @ManyToOne
//    @JoinColumn(name = "anc_id",nullable = false)
    @Basic(optional = false)
//    private AncCaseSheet anc_id;
    private Long anc_id;

    @Column(name = "pat_id",nullable = false)
    @Basic(optional = false)
    private Long pat_id;

    @Column(name = "visit_id",nullable = false)
    @Basic(optional = false)
    private Long visit_id;


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

    @Column(name = "ga",nullable = false)
    @Basic(optional = false)
    private String ga;

    @Column(name = "sedd",nullable = false)
    @Basic(optional = false)
    private String sedd;

    @Column(name = "varBp",nullable = false)
    @Basic(optional = false)
    private String varBp;

    @Column(name = "varweight",nullable = false)
    @Basic(optional = false)
    private String varweight;

    @Column(name = "pallor",nullable = false)
    @Basic(optional = false)
    private String pallor;

    @Column(name = "icterus",nullable = false)
    @Basic(optional = false)
    private String icterus;

    @Column(name = "edema",nullable = false)
    @Basic(optional = false)
    private String edema;

    @Column(name = "UtreusSize",nullable = false)
    @Basic(optional = false)
    private String UtreusSize;

    @Column(name = "SymphosisFundal",nullable = false)
    @Basic(optional = false)
    private String SymphosisFundal;

    @Column(name = "FeatolHeartRate",nullable = false)
    @Basic(optional = false)
    private String FeatolHeartRate;

    @Column(name = "presentationAb",nullable = false)
    @Basic(optional = false)
    private String presentationAb;

    @Column(name = "engaged",nullable = false)
    @Basic(optional = false)
    private String engaged;

    @Column(name = "cervix",nullable = false)
    @Basic(optional = false)
    private String cervix;

    @Column(name = "dilatation",nullable = false)
    @Basic(optional = false)
    private String dilatation;

    @Column(name = "effacement",nullable = false)
    @Basic(optional = false)
    private String effacement;

    @Column(name = "presentationPv",nullable = false)
    @Basic(optional = false)
    private String presentationPv;

    @Column(name = "station",nullable = false)
    @Basic(optional = false)
    private String station;

    @Column(name = "membrane",nullable = false)
    @Basic(optional = false)
    private String membrane;

    @Column(name = "pelvis",nullable = false)
    @Basic(optional = false)
    private String pelvis;

    @Column(name = "chiefComplaints",nullable = false)
    @Basic(optional = false)
    private String chiefComplaints;

    @Column(name = "HisPreIll",nullable = false)
    @Basic(optional = false)
    private String HisPreIll;

    @Column(name = "Cdate",nullable = false)
    @Basic(optional = false)
    private String Cdate;

    @Column(name = "Ctime",nullable = false)
    @Basic(optional = false)
    private String Ctime;

    @Column(name = "cvs",nullable = false)
    @Basic(optional = false)
    private String cvs;

    @Column(name = "rs",nullable = false)
    @Basic(optional = false)
    private String rs;

    @Column(name = "isValid",nullable = false)
    @Basic(optional = false)
    private Long isValid;

    @Column(name = "lmp",nullable = false)
    @Basic(optional = false)
    private String lmp;

    @Column(name = "edd",nullable = false)
    @Basic(optional = false)
    private String edd;

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


    @Column(name = "subsequentAppointmentDate")
    @Basic(optional = false)
    private String subsequentAppointmentDate;

    @Column(name = "subsequentAppointmentPlan")
    @Basic(optional = false)
    private String subsequentAppointmentPlan;

    @Column(name = "subSysOther",nullable = false)
    @Basic(optional = false)
    private String subSysOther;

    @Column(name = "subPaOther",nullable = false)
    @Basic(optional = false)
    private String subPaOther;

    @Column(name = "subPvOther",nullable = false)
    @Basic(optional = false)
    private String subPvOther;

    @Column(name = "subOthersPlan",nullable = false)
    @Basic(optional = false)
    private String subOthersPlan;

    @Column(name = "subRiskFacter",nullable = false)
    @Basic(optional = false)
    private String subRiskFacter;



    //    public static List<AncDetailsSheet> to(final AncCaseSheet ancCaseSheet, final List<CreateAncDetailsRequest> createAncDetailsRequestList){
//        List<AncDetailsSheet> ancDetailsSheetList = new ArrayList<>();
//        for (CreateAncDetailsRequest createAncDetailsRequest: createAncDetailsRequestList) {
//            ancDetailsSheetList.add(to(ancCaseSheet,createAncDetailsRequest));
//        }
//        return ancDetailsSheetList;
//    }
    public static AncDetailsSheet to(final CreateAncDetailsRequest createAncDetailsRequest){
        AncDetailsSheet ancDetailsSheet = new AncDetailsSheet();
        ancDetailsSheet.setAnc_id(createAncDetailsRequest.getAnc_id());
        ancDetailsSheet.setPat_id(createAncDetailsRequest.getPat_id());
        ancDetailsSheet.setVisit_id(createAncDetailsRequest.getVisit_id());
        ancDetailsSheet.setG(createAncDetailsRequest.getG());
        ancDetailsSheet.setP(createAncDetailsRequest.getP());
        ancDetailsSheet.setL(createAncDetailsRequest.getL());
        ancDetailsSheet.setA(createAncDetailsRequest.getA());
        ancDetailsSheet.setD(createAncDetailsRequest.getD());
        ancDetailsSheet.setGa(createAncDetailsRequest.getGa());
        ancDetailsSheet.setSedd(createAncDetailsRequest.getSedd());
        ancDetailsSheet.setVarBp(createAncDetailsRequest.getVarBp());
        ancDetailsSheet.setVarweight(createAncDetailsRequest.getVarweight());
        ancDetailsSheet.setPallor(createAncDetailsRequest.getPallor());
        ancDetailsSheet.setIcterus(createAncDetailsRequest.getIcterus());
        ancDetailsSheet.setEdema(createAncDetailsRequest.getEdema());
        ancDetailsSheet.setUtreusSize(createAncDetailsRequest.getUtreusSize());
        ancDetailsSheet.setSymphosisFundal(createAncDetailsRequest.getSymphosisFundal());
        ancDetailsSheet.setFeatolHeartRate(createAncDetailsRequest.getFeatolHeartRate());
        ancDetailsSheet.setPresentationAb(createAncDetailsRequest.getPresentationAb());
        ancDetailsSheet.setEngaged(createAncDetailsRequest.getEngaged());
        ancDetailsSheet.setCervix(createAncDetailsRequest.getCervix());
        ancDetailsSheet.setDilatation(createAncDetailsRequest.getDilatation());
        ancDetailsSheet.setEffacement(createAncDetailsRequest.getEffacement());
        ancDetailsSheet.setPresentationPv(createAncDetailsRequest.getPresentationPv());
        ancDetailsSheet.setStation(createAncDetailsRequest.getStation());
        ancDetailsSheet.setMembrane(createAncDetailsRequest.getMembrane());
        ancDetailsSheet.setPelvis(createAncDetailsRequest.getPelvis());
        ancDetailsSheet.setChiefComplaints(createAncDetailsRequest.getChiefComplaints());
        ancDetailsSheet.setHisPreIll(createAncDetailsRequest.getHisPreIll());
        ancDetailsSheet.setCdate(createAncDetailsRequest.getCdate());
        ancDetailsSheet.setCtime(createAncDetailsRequest.getCtime());
        ancDetailsSheet.setCvs(createAncDetailsRequest.getCvs());
        ancDetailsSheet.setRs(createAncDetailsRequest.getRs());
        ancDetailsSheet.setLmp(createAncDetailsRequest.getLmp());
        ancDetailsSheet.setEdd(createAncDetailsRequest.getEdd());
        ancDetailsSheet.setHeight(createAncDetailsRequest.getHeight());
        ancDetailsSheet.setBmi(createAncDetailsRequest.getBmi());
        ancDetailsSheet.setSpo2(createAncDetailsRequest.getSpo2());
        ancDetailsSheet.setRr(createAncDetailsRequest.getRr());
        ancDetailsSheet.setBp(createAncDetailsRequest.getBp());
        ancDetailsSheet.setWeight(createAncDetailsRequest.getWeight());
        ancDetailsSheet.setTemperature(createAncDetailsRequest.getTemperature());
        ancDetailsSheet.setPulse(createAncDetailsRequest.getPulse());
        ancDetailsSheet.setIsValid(createAncDetailsRequest.getIsValid());

        ancDetailsSheet.setSubsequentAppointmentDate("0000-00-00");
        ancDetailsSheet.setSubsequentAppointmentPlan(createAncDetailsRequest.getSubsequentAppointmentPlan());

        ancDetailsSheet.setSubSysOther(createAncDetailsRequest.getSubSysOther());
        ancDetailsSheet.setSubPaOther(createAncDetailsRequest.getSubPaOther());
        ancDetailsSheet.setSubPvOther(createAncDetailsRequest.getSubPvOther());

        ancDetailsSheet.setSubOthersPlan(createAncDetailsRequest.getSubOthersPlan());

        ancDetailsSheet.setSubRiskFacter(createAncDetailsRequest.getSubRiskFacter());

        return ancDetailsSheet;
    }

    public void update(final CreateAncDetailsRequest createAncDetailsRequest) {

        this.setAnc_id(createAncDetailsRequest.getAnc_id());
        this.setPat_id(createAncDetailsRequest.getPat_id());
        this.setVisit_id(createAncDetailsRequest.getVisit_id());
        this.setG(createAncDetailsRequest.getG());
        this.setP(createAncDetailsRequest.getP());
        this.setL(createAncDetailsRequest.getL());
        this.setA(createAncDetailsRequest.getA());
        this.setD(createAncDetailsRequest.getD());
        this.setGa(createAncDetailsRequest.getGa());
        this.setSedd(createAncDetailsRequest.getSedd());
        this.setVarBp(createAncDetailsRequest.getVarBp());
        this.setVarweight(createAncDetailsRequest.getVarweight());
        this.setPallor(createAncDetailsRequest.getPallor());
        this.setIcterus(createAncDetailsRequest.getIcterus());
        this.setEdema(createAncDetailsRequest.getEdema());
        this.setUtreusSize(createAncDetailsRequest.getUtreusSize());
        this.setSymphosisFundal(createAncDetailsRequest.getSymphosisFundal());
        this.setFeatolHeartRate(createAncDetailsRequest.getFeatolHeartRate());
        this.setPresentationAb(createAncDetailsRequest.getPresentationAb());
        this.setEngaged(createAncDetailsRequest.getEngaged());
        this.setCervix(createAncDetailsRequest.getCervix());
        this.setDilatation(createAncDetailsRequest.getDilatation());
        this.setEffacement(createAncDetailsRequest.getEffacement());
        this.setPresentationPv(createAncDetailsRequest.getPresentationPv());
        this.setStation(createAncDetailsRequest.getStation());
        this.setMembrane(createAncDetailsRequest.getMembrane());
        this.setPelvis(createAncDetailsRequest.getPelvis());
        this.setChiefComplaints(createAncDetailsRequest.getChiefComplaints());
        this.setHisPreIll(createAncDetailsRequest.getHisPreIll());
        this.setCdate(createAncDetailsRequest.getCdate());
        this.setCtime(createAncDetailsRequest.getCtime());
        this.setCvs(createAncDetailsRequest.getCvs());
        this.setRs(createAncDetailsRequest.getRs());
        this.setLmp(createAncDetailsRequest.getLmp());
        this.setEdd(createAncDetailsRequest.getEdd());
        this.setHeight(createAncDetailsRequest.getHeight());
        this.setBmi(createAncDetailsRequest.getBmi());
        this.setSpo2(createAncDetailsRequest.getSpo2());
        this.setRr(createAncDetailsRequest.getRr());
        this.setBp(createAncDetailsRequest.getBp());
        this.setWeight(createAncDetailsRequest.getWeight());
        this.setTemperature(createAncDetailsRequest.getTemperature());
        this.setPulse(createAncDetailsRequest.getPulse());
        this.setIsValid(createAncDetailsRequest.getIsValid());

        this.setSubsequentAppointmentPlan("0000-00-00");
        this.setSubsequentAppointmentPlan(createAncDetailsRequest.getSubsequentAppointmentPlan());

        this.setSubSysOther(createAncDetailsRequest.getSubSysOther());
        this.setSubPaOther(createAncDetailsRequest.getSubPaOther());
        this.setSubPvOther(createAncDetailsRequest.getSubPvOther());

        this.setSubOthersPlan(createAncDetailsRequest.getSubOthersPlan());
        this.setSubRiskFacter(createAncDetailsRequest.getSubRiskFacter());
    }

}
