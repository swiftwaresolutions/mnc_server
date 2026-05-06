package com.ueniweb.swiftwaresolutions.request;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class GeneralCaseSheetRequest extends AbstractCaseSheetRequest {

    private Long patientId;
    private Long visitId;
    private Long ipId;
    private String investigationHistory;
    private String menstrualHistory;
    private String oralCavity;
    private String generalPhysical;
    private String cvs;
    private String res;
    private String abdominal;
    private String cns;
    private String perVaginal;
    private String oralRectal;
    private String skin;
    private String others;
    private String musculoskeletal;
    private String additionalFindings;
    private String differentialDiagnosis;
    private String confirmedDiagnosis;
    private String medications;
    private String recomendations;
    private String proceduresPlanned;
    private String followUpPlan;
    private String examination;
    private String diagnosis;
    private String discussion;
    private Long uid;
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

    private String foot;

    private String wound;


    private List<CreateComplaintDetailsRequest> createComplaintDetailsRequestList;


    private List<CreateDiagnosisDetailsRequest> createDiagnosisDetailsRequestList;

}
