package com.ueniweb.swiftwaresolutions.data;

import lombok.Data;

@Data
public class AncDetialsData {

    private Long id;
    private Long anc_id;
    private Long pat_id;
    private Long visit_id;
    private String g;
    private String p;
    private String l;
    private String a;
    private String d;
    private String ga;
    private String sedd;
    private String varBp;
    private String varweight;
    private String pallor;
    private String icterus;
    private String edema;
    private String utreusSize;
    private String symphosisFundal;
    private String featolHeartRate;
    private String presentationAb;
    private String engaged;
    private String cervix;
    private String dilatation;
    private String effacement;
    private String presentationPv;
    private String station;
    private String membrane;
    private String pelvis;
    private String chiefComplaints;
    private String hisPreIll;
    private String cdate;
    private String ctime;
    private String cvs;
    private String lmp;
    private String edd;
    private String height;
    private String bmi;
    private String spo2;
    private String rr;
    private String bp;
    private String weight;
    private String temperature;
    private String pulse;
    private String Rs;

    private String subsequentAppointmentDate;
    private String subsequentAppointmentPlan;

    private String subSysOther;
    private String subPaOther;
    private String subPvOther;

    private String subOthersPlan;
    private String subRiskFacter;
    private  String createdAt;

    public AncDetialsData(final Long id, final Long anc_id, final Long pat_id, final Long visit_id, final String g, final String p, final String l,
                          final String a, final String d,final String ga, final String sedd, final String varBp, final String varweight,
                          final String pallor, final String icterus, final String edema, final String utreusSize, final String symphosisFundal,
                          final String featolHeartRate, final String presentationAb, final String engaged, final String cervix,
                          final String dilatation, final String effacement, final String presentationPv, final String station,
                          final String membrane, final String pelvis, final String chiefComplaints, final String hisPreIll,
                          final String cdate, final String ctime, final String cvs, final String Rs, final String lmp,
                          final String edd, final String height, final String bmi, final String spo2, final String rr,
                          final String bp, final String weight, final String temperature, final String pulse, String subsequentAppointmentDate, String subsequentAppointmentPlan,
                          final String subSysOther,final String subPaOther,final String subPvOther,final String subOthersPlan,final String subRiskFacter, final String createdAt
    ) {
        this.id = id;
        this.anc_id = anc_id;
        this.pat_id = pat_id;
        this.visit_id = visit_id;
        this.g = g;
        this.p = p;
        this.l = l;
        this.a = a;
        this.d = d;
        this.ga = ga;
        this.sedd = sedd;
        this.varBp = varBp;
        this.varweight = varweight;
        this.pallor = pallor;
        this.icterus = icterus;
        this.edema = edema;
        this.utreusSize = utreusSize;
        this.symphosisFundal = symphosisFundal;
        this.featolHeartRate = featolHeartRate;
        this.presentationAb = presentationAb;
        this.engaged = engaged;
        this.cervix = cervix;
        this.dilatation = dilatation;
        this.effacement = effacement;
        this.presentationPv = presentationPv;
        this.station = station;
        this.membrane = membrane;
        this.pelvis = pelvis;
        this.chiefComplaints = chiefComplaints;
        this.hisPreIll = hisPreIll;
        this.cdate = cdate;
        this.ctime = ctime;
        this.cvs = cvs;
        this.lmp = lmp;
        this.edd = edd;
        this.height = height;
        this.bmi = bmi;
        this.spo2 = spo2;
        this.rr = rr;
        this.bp = bp;
        this.weight = weight;
        this.temperature = temperature;
        this.pulse = pulse;
        this.Rs = Rs;

        this.subsequentAppointmentDate = subsequentAppointmentDate;
        this.subsequentAppointmentPlan = subsequentAppointmentPlan;

        this.subSysOther=subSysOther;
        this.subPaOther=subPaOther;
        this.subPvOther=subPvOther;

        this.subOthersPlan=subOthersPlan;
        this.subRiskFacter=subRiskFacter;

        this.createdAt=createdAt;

    }

    public static AncDetialsData createNewInstance(final Long id, final Long anc_id, final Long pat_id,
                                                   final Long visit_id, final String g,
                                                   final String p, final String l, final String a,
                                                   final String d, final String ga, final String sedd,
                                                   final String varBp, final String varweight,
                                                   final String pallor, final String icterus, final String edema,
                                                   final String utreusSize, final String symphosisFundal,
                                                   final String featolHeartRate, final String presentationAb,
                                                   final String engaged, final String cervix,
                                                   final String dilatation, final String effacement,
                                                   final String presentationPv, final String station,
                                                   final String membrane, final String pelvis, final String chiefComplaints,
                                                   final String hisPreIll, final String cdate, final String ctime, final String cvs,
                                                   final String Rs, final String lmp, final String edd, final String height, final String bmi,
                                                   final String spo2, final String rr, final String bp, final String weight, final String temperature,
                                                   final String pulse, final String subsequentAppointmentDate, final String subsequentAppointmentPlan,
                                                   final String subSysOther,final String subPaOther,final String subPvOther,
                                                   final String subOthersPlan,final String subRiskFacter, final String createdAt
    ) {
        return new AncDetialsData(id, anc_id, pat_id, visit_id, g, p, l, a, d, ga, sedd, varBp, varweight, pallor, icterus, edema, utreusSize,
                symphosisFundal, featolHeartRate, presentationAb, engaged, cervix, dilatation, effacement, presentationPv, station, membrane,
                pelvis, chiefComplaints, hisPreIll, cdate, ctime, cvs, Rs, lmp, edd, height, bmi, spo2, rr, bp, weight,temperature, pulse,
                subsequentAppointmentDate, subsequentAppointmentPlan,subSysOther,subPaOther,subPvOther,subOthersPlan,subRiskFacter,createdAt
        );
    }
}
