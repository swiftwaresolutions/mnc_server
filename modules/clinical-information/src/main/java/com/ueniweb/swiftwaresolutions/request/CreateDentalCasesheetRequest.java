package com.ueniweb.swiftwaresolutions.request;

import lombok.Data;

import java.util.List;

@Data
public class CreateDentalCasesheetRequest {

    private Long patId;

    private Long visitId;

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

    private List<CreateComplaintDetailsRequest> createComplaintDetailsRequestList;

    private List<CreateTeethExamDetailsRequest> createTeethExamDetailsRequestList;

    private List<CreateTeethTreatDetailsRequest> createTeethTreatDetailsRequestList;


    @Override
    public String toString() {
        return "CreateDentalCasesheet{" +
                "patId=" + patId +
                ", visitId=" + visitId +
                ", ipId=" + ipId +
                ", historyofpresentIllness='" + historyofpresentIllness + '\'' +
                ", medicalHistory='" + medicalHistory + '\'' +
                ", past_History='" + past_History + '\'' +
                ", habitHistory='" + habitHistory + '\'' +
                ", treatment_History='" + treatment_History + '\'' +
                ", occupation='" + occupation + '\'' +
                ", extraoralexamination='" + extraoralexamination + '\'' +
                ", treatmentplan='" + treatmentplan + '\'' +
                ", treatmentgeneral='" + treatmentgeneral + '\'' +
                '}';
    }

}
