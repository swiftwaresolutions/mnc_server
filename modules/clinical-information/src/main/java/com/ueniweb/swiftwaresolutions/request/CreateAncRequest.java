package com.ueniweb.swiftwaresolutions.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Data
@Getter
@Setter
public class CreateAncRequest {

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

    private String height;
    private String bmi;
    private String spo2;
    private String rr;
    private String bp;
    private String weight;
    private String temperature;
    private String pulse;

    private Long docId;

    private String iniSysOther;
    private String iniPaOther;
    private String iniPvOther;

    private String othersPlan;
    private String personalInfo;

    //    private List<CreateAncDetailsRequest> createAncDetailsRequestList;
    private List<CreateAncChildRequest> createAncChildRequests;

}
