package com.ueniweb.swiftwaresolutions.data;

import lombok.Data;

import java.util.List;

@Data
public class DermatologyCaseSheetData {

    private Long id;

    private Long patId;

    private Long vstId;

    private Long ipId;

    private Long consultantId;

    private String dateTime;

    private String presentIllness;

    private String pastHistory;

    private String allergy;

    private String temperature;

    private String pulse;

    private String rr;

    private String bp;

    private String spo2;

    private String height;

    private String weight;

    private String bmi;

    private String examination;

    private String diagnosis;

    private String discussion;

    private String recomendations;

    private String treatmentPlan;

    private String treatmentGiven;

    private String extra1;

    private String extra2;

    private String extra3;

    private String extra4;

    private String extra5;

    private Long isCancelled;

    private List<ComplaintDetailsData> complaintDataList;

    private List<DiagnosisData> diagnosisDetailsData;

    public DermatologyCaseSheetData(Long id, Long patId, Long vstId, Long ipId, Long consultantId, String dateTime, String presentIllness, String pastHistory,
                                    String allergy, String temperature, String pulse, String rr, String bp, String spo2, String height,
                                    String weight, String bmi, String examination, String diagnosis, String discussion, String recomendations,
                                    String treatmentPlan, String treatmentGiven, String extra1, String extra2, String extra3, String extra4,
                                    String extra5, Long isCancelled) {
        this.id             = id;
        this.patId          = patId;
        this.vstId          = vstId;
        this.ipId           = ipId;
        this.consultantId   = consultantId;
        this.dateTime       = dateTime;
        this.presentIllness = presentIllness;
        this.pastHistory    = pastHistory;
        this.allergy        = allergy;
        this.temperature    = temperature;
        this.pulse          = pulse;
        this.rr             = rr;
        this.bp             = bp;
        this.spo2           = spo2;
        this.height         = height;
        this.weight         = weight;
        this.bmi            = bmi;
        this.examination    = examination;
        this.diagnosis      = diagnosis;
        this.discussion     = discussion;
        this.recomendations = recomendations;
        this.treatmentPlan  = treatmentPlan;
        this.treatmentGiven = treatmentGiven;
        this.extra1         = extra1;
        this.extra2         = extra2;
        this.extra3         = extra3;
        this.extra4         = extra4;
        this.extra5         = extra5;
        this.isCancelled    = isCancelled;
    }

    public static DermatologyCaseSheetData newInstance(Long id, Long patId, Long vstId, Long ipId, Long consultantId,String dateTime, String presentIllness,
                                                       String pastHistory,String allergy, String temperature, String pulse, String rr, String bp,
                                                       String spo2, String height,String weight, String bmi, String examination, String diagnosis,
                                                       String discussion, String recomendations,String treatmentPlan, String treatmentGiven,
                                                       String extra1, String extra2, String extra3, String extra4,String extra5, Long isCancelled){

        return new DermatologyCaseSheetData (id, patId, vstId, ipId, consultantId, dateTime, presentIllness, pastHistory, allergy, temperature, pulse, rr, bp,
                spo2, height, weight, bmi, examination, diagnosis, discussion, recomendations, treatmentPlan, treatmentGiven, extra1, extra2,
                extra3, extra4, extra5, isCancelled);
    }
}
