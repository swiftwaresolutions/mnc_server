package com.ueniweb.swiftwaresolutions.domain;

import com.ueniweb.swiftwaresolutions.request.CreateDiagnosisDetailsRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity(name="ENTDiagnosisDetails")
@Table(name = "cli_patient_diagnosis")
@Getter
@Setter
public class ENTDiagnosisDetails {

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
    private ENTCaseSheet caseSheetId;

    @Column(name = "diagnosisId",nullable = false)
    @Basic(optional = false)
    private Long diagnosisId;

    @Column(name = "isValid")
    private Long isValid;

    public static List<ENTDiagnosisDetails> to(final ENTCaseSheet entCaseSheet,
                                                       final List<CreateDiagnosisDetailsRequest> createDiagnosisDetailsRequestList){
        List<ENTDiagnosisDetails> entDiagnosisDetailsList = new ArrayList<>();
        for(CreateDiagnosisDetailsRequest createDiagnosisDetailsRequest: createDiagnosisDetailsRequestList){
            entDiagnosisDetailsList.add(to(entCaseSheet,createDiagnosisDetailsRequest));
        }
        return entDiagnosisDetailsList;
    }

    public static ENTDiagnosisDetails to(final ENTCaseSheet entCaseSheet,
                                                 final CreateDiagnosisDetailsRequest diagnosisDetailsRequest){
        ENTDiagnosisDetails entDiagnosisDetails = new ENTDiagnosisDetails();

        entDiagnosisDetails.setPatId(diagnosisDetailsRequest.getPatId());
        entDiagnosisDetails.setVstId(diagnosisDetailsRequest.getVstId());
        entDiagnosisDetails.setIpId(diagnosisDetailsRequest.getIpId());
        entDiagnosisDetails.setCaseSheetType(diagnosisDetailsRequest.getCaseSheetType());
        entDiagnosisDetails.setCaseSheetId(entCaseSheet);
        entDiagnosisDetails.setDiagnosisId(diagnosisDetailsRequest.getDiagnosisId());
        entDiagnosisDetails.setIsValid(diagnosisDetailsRequest.getIsValid());

        return entDiagnosisDetails;
    }
}
