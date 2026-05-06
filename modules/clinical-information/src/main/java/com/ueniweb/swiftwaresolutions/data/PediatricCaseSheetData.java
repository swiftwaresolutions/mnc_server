package com.ueniweb.swiftwaresolutions.data;

import lombok.Data;

import java.util.List;

@Data
public class PediatricCaseSheetData {

    private Long id;

    private Long patId;

    private Long visitId;

    private Long ipId;

    private String presentIllness;

    private String pastHistory;

    private String birthHistory;

    private String personalHistory;

    private String perinatalhistory;

    private String treatmentHistory;

    private String investigationHistory;

    private String feedinghistory;

    private String pulse;

    private String bp;

    private String rr;

    private String spo2;

    private String crt;

    private String temp;

    private String pallor;

    private String clubbing;

    private String icterus;

    private String cyanosis;

    private String lymphadenopathy;

    private String edema;

    private String headtotoe;

    private String oralcavity;

    private String cvs;

    private String rs;

    private String cns;

    private String abdo;

    private String skin;

    private String musculoskeletal;

    private String aditionalfindings;

    private String allergy;

    private String differentialDiagnosis;

    private String confirmedDiagnosis;

    private List<ComplaintDetailsData> complaintDataList;

    public PediatricCaseSheetData(Long id, Long patId, Long visitId,Long ipId,String presentIllness,String pastHistory, String birthHistory,
                                  String personalHistory,String perinatalhistory,String treatmentHistory,String investigationHistory,String feedinghistory,
                                  String pulse, String bp,String rr,String spo2,String crt,String temp,String pallor,String clubbing,String icterus,
                                  String cyanosis,String lymphadenopathy,String edema,String headtotoe, String oralcavity,String cvs,String rs,
                                  String cns,String abdo,String skin,String musculoskeletal,String aditionalfindings,String allergy,String differentialDiagnosis,String confirmedDiagnosis){

        this.id = id;
        this.patId = patId;
        this.visitId = visitId;
        this.ipId = ipId;
        this.presentIllness = presentIllness;
        this.pastHistory = pastHistory;
        this.birthHistory = birthHistory;
        this.personalHistory = personalHistory;
        this.perinatalhistory = perinatalhistory;
        this.treatmentHistory = treatmentHistory;
        this.investigationHistory = investigationHistory;
        this.feedinghistory = feedinghistory;
        this.pulse = pulse;
        this.bp = bp;
        this.rr = rr;
        this.spo2 = spo2;
        this.crt = crt;
        this.temp = temp;
        this.pallor = pallor;
        this.clubbing = clubbing;
        this.icterus = icterus;
        this.cyanosis = cyanosis;
        this.lymphadenopathy = lymphadenopathy;
        this.edema = edema;
        this.headtotoe = headtotoe;
        this.oralcavity = oralcavity;
        this.cvs = cvs;
        this.rs = rs;
        this.cns = cns;
        this.abdo = abdo;
        this.skin = skin;
        this.musculoskeletal = musculoskeletal;
        this.aditionalfindings = aditionalfindings;
        this.allergy = allergy;
        this.differentialDiagnosis = differentialDiagnosis;
        this.confirmedDiagnosis = confirmedDiagnosis;
    }

    public static PediatricCaseSheetData newInstance(Long id, Long patId, Long visitId,Long ipId,String presentIllness,String pastHistory, String birthHistory,
                                                     String personalHistory,String perinatalhistory,String treatmentHistory,String investigationHistory,String feedinghistory,
                                                     String pulse, String bp,String rr,String spo2,String crt,String temp,String pallor,String clubbing,String icterus,
                                                     String cyanosis,String lymphadenopathy,String edema,String headtotoe, String oralcavity,String cvs,String rs,
                                                     String cns,String abdo,String skin,String musculoskeletal,String aditionalfindings,String allergy,String differentialDiagnosis,String confirmedDiagnosis) {
        return new PediatricCaseSheetData(id,patId,visitId,ipId,presentIllness,pastHistory,birthHistory,
                personalHistory,perinatalhistory,treatmentHistory,investigationHistory,feedinghistory,
                pulse, bp,rr,spo2,crt,temp,pallor,clubbing,icterus,
                cyanosis,lymphadenopathy,edema,headtotoe, oralcavity,cvs,rs,
                cns,abdo,skin,musculoskeletal,aditionalfindings,allergy,differentialDiagnosis,confirmedDiagnosis);
    }
}
