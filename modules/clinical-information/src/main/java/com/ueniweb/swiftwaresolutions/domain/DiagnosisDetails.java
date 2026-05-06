package com.ueniweb.swiftwaresolutions.domain;

import com.ueniweb.swiftwaresolutions.request.CreateComplaintDetailsRequest;
import com.ueniweb.swiftwaresolutions.request.CreateDiagnosisDetailsRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity(name="DiagnosisDetails")
@Table(name = "cli_patient_diagnosis")
@Getter
@Setter
public class DiagnosisDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "patId",nullable = false)
    @Basic(optional = false)
    private Long patId;

    @Column(name = "vstId",nullable = false)
    @Basic(optional = false)
    private Long vstId;

    @Column(name = "ipId")
    private Long ipId;

    @Column(name = "caseSheetType")
    private Long caseSheetType;

    @ManyToOne
    @JoinColumn(name = "caseSheetId",nullable = false)
    @Basic(optional = false)
    private GeneralCaseSheet caseSheetId;

    @Column(name = "diagnosisId",nullable = false)
    @Basic(optional = false)
    private Long diagnosisId;

    @Column(name = "isValid")
    private Long isValid;

    public static List<DiagnosisDetails> to(final GeneralCaseSheet generalCaseSheet, final List<CreateDiagnosisDetailsRequest> createDiagnosisDetailsRequestList){
        List<DiagnosisDetails> diagnosisDetailsList = new ArrayList<>();
        for (CreateDiagnosisDetailsRequest createDiagnosisDetailsRequest: createDiagnosisDetailsRequestList) {
            diagnosisDetailsList.add(to(generalCaseSheet,createDiagnosisDetailsRequest));
        }
        return diagnosisDetailsList;
    }

    public static DiagnosisDetails to(final GeneralCaseSheet generalCaseSheet,final CreateDiagnosisDetailsRequest diagnosisDetailsRequest){
        DiagnosisDetails diagnosisDetails = new DiagnosisDetails();
        diagnosisDetails.setPatId(diagnosisDetailsRequest.getPatId());
        diagnosisDetails.setVstId(diagnosisDetailsRequest.getVstId());
        diagnosisDetails.setIpId(diagnosisDetailsRequest.getIpId());
        diagnosisDetails.setCaseSheetType(diagnosisDetailsRequest.getCaseSheetType());
        diagnosisDetails.setCaseSheetId(generalCaseSheet);
        diagnosisDetails.setDiagnosisId(diagnosisDetailsRequest.getDiagnosisId());
        diagnosisDetails.setIsValid(diagnosisDetailsRequest.getIsValid());

        return diagnosisDetails;
    }
}
