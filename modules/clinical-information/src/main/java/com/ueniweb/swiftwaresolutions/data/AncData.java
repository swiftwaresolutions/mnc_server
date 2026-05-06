package com.ueniweb.swiftwaresolutions.data;

import jakarta.persistence.Column;
import lombok.Data;

import java.util.List;

@Data
public class AncData {

    private Long id;
    private Long patId;
    private Long vstId;
    private String Ctime;
    private String Cdate;
    private String g;
    private String p;
    private String l;
    private String a;
    private String d;
    private String lmp;
    private String edd;
    private String sedd;
    private String ga;
    private String durationofmarriage;
    private String consanguinity;
    private String conception;
    private String menstrualHis;
    private String MenstrualOthers;
    private String surgicalHistory;
    private String chiefhistory;
    private String allergichistory;
    private String historyPreIll;
    private String familyHistory;
    private String othersHis;
    private String pallor;
    private String icterus;
    private String edema;
    private String cvs;
    private String rs;
    private String UtreusSize;
    private String SymphosisFundal;
    private String FeatolHeartRate;
    private String presentationAb;
    private String engaged;
    private String cervix;
    private String dilatation;
    private String effacement;
    private String presentationPV;
    private String station;
    private String membrane;
    private String pelvis;
    private Long diabetes;
    private Long hypertension;
    private Long asthma;
    private Long seiure;
    private Long cardiacDisease;
    private Long tb;
    private Long thyroidDisorder;
    private Long stDose1;
    private String stDoseIn;
    private Long ndDose2;
    private String ndDoseIn;
    private String riskFactor;
    private String medicalHistory;
    private String others;
    private Long isDelivered;

    private String height;
    private String bmi;
    private String spo2;
    private String rr;
    private String bp;
    private String weight;
    private String temperature;
    private String pulse;

    private String diabetesNotes;
    private String hypertensionNotes;
    private String asthmaNotes;
    private String seiureNotes;
    private String cardiacNotes;
    private String tbNotes;
    private String thyroidDisorderNotes;
    private String othersNotes;
    private String initialAppointmentDate;
    private String initialAppointmentPlan;

    private String iniSysOther;
    private  String iniPaOther;
    private  String iniPvOther;

    private  String othersPlan;
    private String personalInfo;
    private  String createdAt;

//    private List<AncDetialsData> ancDetialsDataList;
    private List<AncChildDetialsData> ancChildDetialsDataList;

    public AncData(final Long id, final Long patId, final Long vstId, final String Ctime, final String Cdate, final String g, final String p, final String l,
                   final String a, final String d, final String lmp, final String edd, final String sedd, final String ga, final String durationofmarriage,
                   final String consanguinity, final String conception, final String menstrualHis, final String MenstrualOthers, final String surgicalHistory,
                   final String chiefhistory, final String allergichistory, final String historyPreIll, final String familyHistory, final String othersHis,
                   final String pallor, final String icterus, final String edema, final String cvs, final String rs, final String UtreusSize,
                   final String SymphosisFundal, final String FeatolHeartRate, final String presentationAb, final String engaged, final String cervix,
                   final String dilatation, final String effacement, final String presentationPV, final String station, final String membrane, final String pelvis,
                   final Long diabetes, final Long hypertension, final Long asthma, final Long seiure, final Long cardiacDisease, final Long tb, final Long thyroidDisorder, final Long stDose1,
                   final String stDoseIn, final Long ndDose2, final String ndDoseIn, final String riskFactor, final String medicalHistory, final String others, final Long isDelivered,
                   final String diabetesNotes, final String hypertensionNotes, final String asthmaNotes, final String seiureNotes,
                   final String cardiacNotes, final String tbNotes, final String thyroidDisorderNotes, final String othersNotes,
                   final String initialAppointmentDate, final String initialAppointmentPlan, final String height, final String bmi, final String spo2, final String rr,
                   final String bp, final String weight, final String temperature, final String pulse,final String iniSysOther,final String iniPaOther,final String iniPvOther,
                   final String othersPlan, final String personalInfo,final String createdAt
    ) {
        this.id = id;
        this.patId = patId;
        this.vstId = vstId;
        this.Ctime = Ctime;
        this.Cdate = Cdate;
        this.g = g;
        this.p = p;
        this.l = l;
        this.a = a;
        this.d = d;
        this.lmp = lmp;
        this.edd = edd;
        this.sedd = sedd;
        this.ga = ga;
        this.durationofmarriage = durationofmarriage;
        this.consanguinity = consanguinity;
        this.conception = conception;
        this.menstrualHis = menstrualHis;
        this.MenstrualOthers = MenstrualOthers;
        this.surgicalHistory = surgicalHistory;
        this.chiefhistory = chiefhistory;
        this.allergichistory = allergichistory;
        this.historyPreIll = historyPreIll;
        this.familyHistory = familyHistory;
        this.othersHis = othersHis;
        this.pallor = pallor;
        this.icterus = icterus;
        this.edema = edema;
        this.cvs = cvs;
        this.rs = rs;
        this.UtreusSize = UtreusSize;
        this.SymphosisFundal = SymphosisFundal;
        this.FeatolHeartRate = FeatolHeartRate;
        this.presentationAb = presentationAb;
        this.engaged = engaged;
        this.cervix = cervix;
        this.dilatation = dilatation;
        this.effacement = effacement;
        this.presentationPV = presentationPV;
        this.station = station;
        this.membrane = membrane;
        this.pelvis = pelvis;
        this.diabetes = diabetes;
        this.hypertension = hypertension;
        this.asthma = asthma;
        this.seiure = seiure;
        this.cardiacDisease = cardiacDisease ;
        this.tb = tb;
        this.thyroidDisorder = thyroidDisorder;
        this.stDose1 = stDose1;
        this.stDoseIn = stDoseIn;
        this.ndDose2 = ndDose2;
        this.ndDoseIn = ndDoseIn;
        this.riskFactor = riskFactor;
        this.isDelivered = isDelivered;
        this.medicalHistory = medicalHistory;
        this.others = others;

        this.height = height;
        this.bmi = bmi;
        this.spo2 = spo2;
        this.rr = rr;
        this.bp = bp;
        this.weight = weight;
        this.temperature = temperature;
        this.pulse = pulse;

        this.diabetesNotes = diabetesNotes;
        this.hypertensionNotes = hypertensionNotes;
        this.asthmaNotes = asthmaNotes;
        this.seiureNotes = seiureNotes;
        this.cardiacNotes = cardiacNotes;
        this.tbNotes = tbNotes;
        this.thyroidDisorderNotes = thyroidDisorderNotes;
        this.othersNotes = othersNotes;
        this.initialAppointmentDate = initialAppointmentDate;
        this.initialAppointmentPlan = initialAppointmentPlan;
        this.iniSysOther=iniSysOther;
        this.iniPaOther=iniPaOther;
        this.iniPvOther=iniPvOther;

        this.othersPlan=othersPlan;
        this.personalInfo = personalInfo;
        this.createdAt=createdAt;


    }

    public static AncData newInstance(final Long id, final Long patId, final Long vstId, final String Ctime, final String Cdate, final String g, final String p,
                                      final String l, final String a, final String d, final String lmp, final String edd, final String sedd, final String ga,
                                      final String durationofmarriage, final String consanguinity, final String conception, final String menstrualHis,
                                      final String MenstrualOthers, final String surgicalHistory, final String chiefhistory, final String allergichistory,
                                      final String historyPreIll, final String familyHistory, final String othersHis, final String pallor, final String icterus,
                                      final String edema, final String cvs, final String rs, final String UtreusSize, final String SymphosisFundal,
                                      final String FeatolHeartRate, final String presentationAb, final String engaged, final String cervix, final String dilatation,
                                      final String effacement, final String presentationPV, final String station, final String membrane, final String pelvis,
                                      final Long diabetes, final Long hypertension, final Long asthma, final Long seiure, final Long  cardiacDisease, final Long tb, final Long thyroidDisorder,
                                      final Long stDose1, final String stDoseIn, final Long ndDose2, final String ndDoseIn, final String riskFactor,
                                      final String medicalHistory, final String others, final Long isDelivered,
                                      final String diabetesNotes, final String hypertensionNotes, final String asthmaNotes, final String seiureNotes,
                                      final String cardiacNotes, final String tbNotes, final String thyroidDisorderNotes, final String othersNotes,
                                      final String initialAppointmentDate, final String initialAppointmentPlan,final String height, final String bmi,
                                      final String spo2, final String rr, final String bp, final String weight, final String temperature,
                                      final String pulse,final String iniSysOther,final String iniPaOther,final String iniPvOther,
                                      final String othersPlan, final String personalInfo ,final String createdAt
    ) {
        return new AncData(id, patId, vstId, Ctime, Cdate, g, p, l, a, d, lmp, edd, sedd, ga, durationofmarriage, consanguinity,
                conception, menstrualHis, MenstrualOthers, surgicalHistory, chiefhistory, allergichistory, historyPreIll, familyHistory, othersHis,
                pallor, icterus, edema, cvs, rs, UtreusSize, SymphosisFundal, FeatolHeartRate, presentationAb, engaged, cervix, dilatation,
                effacement, presentationPV, station, membrane, pelvis, diabetes, hypertension, asthma, seiure, cardiacDisease, tb, thyroidDisorder, stDose1,
                stDoseIn, ndDose2, ndDoseIn, riskFactor, medicalHistory, others, isDelivered,
                diabetesNotes, hypertensionNotes, asthmaNotes, seiureNotes, cardiacNotes, tbNotes, thyroidDisorderNotes, othersNotes,
                initialAppointmentDate, initialAppointmentPlan,height, bmi, spo2, rr, bp, weight,temperature, pulse,iniSysOther,
                iniPaOther,iniPvOther,othersPlan,personalInfo,createdAt
        );
    }
}
