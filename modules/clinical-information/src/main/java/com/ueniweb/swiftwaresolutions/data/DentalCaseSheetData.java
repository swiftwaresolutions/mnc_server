package com.ueniweb.swiftwaresolutions.data;

import lombok.Data;

import java.util.List;

@Data
public class DentalCaseSheetData {

    private Long id;

    private Long patId;

    private Long vstId;

    private Long ipId;

    private String historyofpresentIllness;

    private String medicalHistory;

    private String past_History;

    private String habitHistory;

    private String treatment_History;

    private String occupation;

    private String extraoralexamination;

    private String treatmentplan;

    private String treatmentgeneral;

    private List<ComplaintDetailsData> complaintDataList;

    private List<DentalTeethData> teethDataList;

    private List<DentalTeethTreatData> teethTreatDataList;


    public DentalCaseSheetData(Long id, Long patId, Long vstId, Long ipId, String historyofpresentIllness,
                               String medicalHistory, String past_History, String habitHistory,
                               String treatment_History, String occupation, String extraoralexamination,
                               String treatmentplan, String treatmentgeneral) {
        this.id = id;
        this.patId = patId;
        this.vstId = vstId;
        this.ipId = ipId;
        this.historyofpresentIllness = historyofpresentIllness;
        this.medicalHistory = medicalHistory;
        this.past_History = past_History;
        this.habitHistory = habitHistory;
        this.treatment_History = treatment_History;
        this.occupation = occupation;
        this.extraoralexamination = extraoralexamination;
        this.treatmentplan = treatmentplan;
        this.treatmentgeneral = treatmentgeneral;
    }

    public static DentalCaseSheetData createNewInstance(Long id, Long patId, Long vstId, Long ipId, String historyofpresentIllness,
                                                        String medicalHistory, String past_History, String habitHistory,
                                                        String treatment_History, String occupation, String extraoralexamination,
                                                        String treatmentplan, String treatmentgeneral) {
        return new DentalCaseSheetData(id, patId, vstId, ipId, historyofpresentIllness,
                medicalHistory, past_History, habitHistory, treatment_History, occupation, extraoralexamination, treatmentplan, treatmentgeneral);
    }
}
