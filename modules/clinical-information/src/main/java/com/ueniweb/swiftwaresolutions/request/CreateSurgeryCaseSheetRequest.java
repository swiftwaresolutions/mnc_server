package com.ueniweb.swiftwaresolutions.request;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class CreateSurgeryCaseSheetRequest {

    private Long id;

    private Long patId;

    private Long visitId;

    private Long ipId;

    private String entDate;

    private String entTime;

    private String surgeryDate;

    private String surgeryTime;

    private String durSurgery;

    private String preOtDiagnosis;

    private String postOtDiagnosis;

    private String DetSurgery;

    private String ProcedureNotes;

    private String ProgressNotes;

    private String AnestDoc;


    private List<CreateSurigicalSurgonRequest> createSurigicalSurgonRequests;

    private List<CreateSurigicalNurseRequest> createSurigicalNurseRequests;

    private List<CreateSurgicalSurgeryRequest> createSurgicalSurgeryRequests;

    @Override
    public String toString() {
        return "CreateSurgeryCaseSheetRequest{" +
                "id=" + id +
                ", patId=" + patId +
                ", visitId=" + visitId +
                ", ipId=" + ipId +
                ", entDate='" + entDate + '\'' +
                ", entTime='" + entTime + '\'' +
                ", surgeryDate='" + surgeryDate + '\'' +
                ", surgeryTime='" + surgeryTime + '\'' +
                ", durSurgery='" + durSurgery + '\'' +
                ", preOtDiagnosis='" + preOtDiagnosis + '\'' +
                ", postOtDiagnosis='" + postOtDiagnosis + '\'' +
                ", DetSurgery='" + DetSurgery + '\'' +
                ", ProcedureNotes='" + ProcedureNotes + '\'' +
                ", ProgressNotes='" + ProgressNotes + '\'' +
                ", AnestDoc='" + AnestDoc + '\'' +
                '}';
    }

}
