package com.ueniweb.swiftwaresolutions.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Getter
@Setter
public class CreateAncDetailsRequest {

    private Long id;
    private Long anc_id;
    private Long pat_id;
    private Long visit_id;
    private String time;
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
    private String UtreusSize;
    private String SymphosisFundal;
    private String FeatolHeartRate;
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
    private String HisPreIll;
    private String Cdate;
    private String Ctime;
    private String cvs;
    private String rs;
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
    private Long isValid;

    private String subsequentAppointmentDate;
    private String subsequentAppointmentPlan;

    private String subSysOther;
    private String subPaOther;
    private String subPvOther;

    private String subOthersPlan;
    private String subRiskFacter;

}
