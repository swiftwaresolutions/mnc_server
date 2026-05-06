package com.ueniweb.swiftwaresolutions.data;

import lombok.Data;

import java.util.List;

@Data
public class GeneralCaseSheetData {

    private Long id;

    private Long patId;

    private Long vstId;

    private Long ipId;

    private String presentIllness;

    private String pastHistory;

    private String treatmentHistory;

    private String personalHistory;

    private String investigationHistory;

    private String menstrualHistory;

    private String temperature;

    private String pulse;

    private String rr;

    private String bp;

    private String spo2;

    private String height;

    private String weight;

    private String bmi;

    private String oralCavity;

    private String cvs;

    private String res;

    private String abdominal;

    private String cns;

    private String perVaginal;

    private String oralRectal;

    private String skin;

    private String musculoskeletal;

    private String additionalFindings;

    private String allergy;

    private String differentialDiagnosis;

    private String confirmedDiagnosis;

    private String medications;

    private String recomendations;

    private String proceduresPlanned;

    private String followUpPlan;

    private String examination;

    private String diagnosis;

    private String discussion;

    private String generalPhysical;

    private String others;

    private String appointMentDate;

    private String pastHistorySurgical;
    private String pastHistoryMedical;
    private String familyHistory;
    private String generalExamination;
    private String systemicExamination;
    private String presentingComplaints;
    private String pallor;
    private String icterus;
    private String edema;
    private String appointmentPlan;

    private String foot;
    private String wound;

    private List<ComplaintDetailsData> complaintDataList;

    private List<DiagnosisData> diagnosisDetailsData;

    public GeneralCaseSheetData(Long id, Long patId, Long vstId, Long ipId, String presentIllness,
                                String pastHistory, String treatmentHistory, String personalHistory,
                                String investigationHistory, String menstrualHistory, String temperature,
                                String pulse, String rr, String bp, String spo2, String height, String weight,
                                String bmi, String oralCavity, String cvs, String res, String abdominal, String cns, String perVaginal,
                                String oralRectal, String skin, String musculoskeletal, String additionalFindings,
                                String allergy, String differentialDiagnosis, String confirmedDiagnosis, String medications,
                                String recomendations, String proceduresPlanned, String followUpPlan, String examination, String diagnosis, String discussion, String generalPhysical, String others, String appointMentDate,
                                String pastHistorySurgical, String pastHistoryMedical, String familyHistory, String generalExamination, String systemicExamination,
                                String presentingComplaints, String pallor, String icterus, String edema,String appointmentPlan, String foot, String wound
    ) {
        this.id = id;
        this.patId = patId;
        this.vstId = vstId;
        this.ipId = ipId;
        this.presentIllness = presentIllness;
        this.pastHistory = pastHistory;
        this.treatmentHistory = treatmentHistory;
        this.personalHistory = personalHistory;
        this.investigationHistory = investigationHistory;
        this.menstrualHistory = menstrualHistory;
        this.temperature = temperature;
        this.pulse = pulse;
        this.rr = rr;
        this.bp = bp;
        this.spo2 = spo2;
        this.height = height;
        this.weight = weight;
        this.bmi = bmi;
        this.oralCavity = oralCavity;
        this.cvs = cvs;
        this.res = res;
        this.abdominal = abdominal;
        this.cns = cns;
        this.perVaginal = perVaginal;
        this.oralRectal = oralRectal;
        this.skin = skin;
        this.musculoskeletal = musculoskeletal;
        this.additionalFindings = additionalFindings;
        this.allergy = allergy;
        this.differentialDiagnosis = differentialDiagnosis;
        this.confirmedDiagnosis = confirmedDiagnosis;
        this.medications = medications;
        this.recomendations = recomendations;
        this.proceduresPlanned = proceduresPlanned;
        this.followUpPlan = followUpPlan;
        this.examination = examination;
        this.diagnosis = diagnosis;
        this.discussion = discussion;
        this.generalPhysical = generalPhysical;
        this.others = others;
        this.appointMentDate = appointMentDate;
        this.pastHistoryMedical = pastHistoryMedical;
        this.familyHistory = familyHistory;
        this.generalExamination = generalExamination;
        this.pastHistorySurgical = pastHistorySurgical;
        this.systemicExamination = systemicExamination;
        this.presentingComplaints = presentingComplaints;
        this.pallor = pallor;
        this.icterus = icterus;
        this.edema = edema;
        this.appointmentPlan = appointmentPlan;
        this.foot = foot;
        this.wound = wound;
    }

    public static GeneralCaseSheetData newInstance(Long id, Long patId, Long vstId, Long ipId, String presentIllness,
                                                   String pastHistory, String treatmentHistory, String personalHistory,
                                                   String investigationHistory, String menstrualHistory, String temperature,
                                                   String pulse, String rr, String bp, String spo2, String height, String weight,
                                                   String bmi, String oralCavity, String cvs, String res, String abdominal, String cns,
                                                   String perVaginal, String oralRectal, String skin, String musculoskeletal,
                                                   String additionalFindings, String allergy, String differentialDiagnosis,
                                                   String confirmedDiagnosis, String medications, String recomendations,
                                                   String proceduresPlanned, String followUpPlan, String examination, String diagnosis, String discussion, String generalPhysical, String others, String appointMentDate,
                                                   String pastHistorySurgical, String pastHistoryMedical, String familyHistory, String generalExamination, String systemicExamination,
                                                   String presentingComplaints, String pallor, String icterus, String edema, String appointmentPlan , String foot , String wound
    ) {
        return new GeneralCaseSheetData(id, patId, vstId, ipId, presentIllness,
                pastHistory, treatmentHistory, personalHistory, investigationHistory, menstrualHistory,
                temperature, pulse, rr, bp, spo2, height, weight, bmi, oralCavity, cvs, res, abdominal,
                cns, perVaginal, oralRectal, skin, musculoskeletal, additionalFindings,
                allergy, differentialDiagnosis, confirmedDiagnosis, medications, recomendations,
                proceduresPlanned, followUpPlan, examination, diagnosis, discussion, generalPhysical, others, appointMentDate,
                pastHistorySurgical, pastHistoryMedical, familyHistory, generalExamination, systemicExamination,
                presentingComplaints, pallor, icterus, edema, appointmentPlan,foot,wound
        );
    }
}
