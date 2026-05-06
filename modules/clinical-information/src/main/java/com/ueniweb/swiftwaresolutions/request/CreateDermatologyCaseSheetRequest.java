package com.ueniweb.swiftwaresolutions.request;

import lombok.Data;

import java.util.List;

//@EqualsAndHashCode(callSuper = true)
@Data
public class CreateDermatologyCaseSheetRequest {

    private Long patientId;

    private Long visitId;

    private Long ipId;

    private Long consultantId;

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

    private List<CreateComplaintDetailsRequest> createComplaintDetailsRequestList;


    private List<CreateDiagnosisDetailsRequest> createDiagnosisDetailsRequestList;

    @Override
    public String toString() {
        return "createDermatologyCaseSheetRequest{" +
                "patientId=" + patientId +
                ", visitId=" + visitId +
                ", ipId=" + ipId +
                ", consultantId=" + consultantId +
                ", presentIllness='" + presentIllness + '\'' +
                ", pastHistory='" + pastHistory + '\'' +
                ", allergy='" + allergy + '\'' +
                ", temperature='" + temperature + '\'' +
                ", pulse='" + pulse + '\'' +
                ", rr='" + rr + '\'' +
                ", bp='" + bp + '\'' +
                ", spo2='" + spo2 + '\'' +
                ", height='" + height + '\'' +
                ", weight='" + weight + '\'' +
                ", bmi='" + bmi + '\'' +
                ", examination='" + examination + '\'' +
                ", diagnosis='" + diagnosis + '\'' +
                ", discussion='" + discussion + '\'' +
                ", recomendations='" + recomendations + '\'' +
                ", treatmentPlan='" + treatmentPlan + '\'' +
                ", treatmentGiven='" + treatmentGiven + '\'' +
                ", extra1='" + extra1 + '\'' +
                ", extra2='" + extra2 + '\'' +
                ", extra3='" + extra3 + '\'' +
                ", extra4='" + extra4 + '\'' +
                ", extra5='" + extra5 + '\'' +
                ", isCancelled=" + isCancelled +
                '}';
    }
}
