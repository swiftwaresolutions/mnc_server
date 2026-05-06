package com.ueniweb.swiftwaresolutions.domain;

import com.ueniweb.swiftwaresolutions.request.CreateDiagnosisDetailsRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity(name="OpthamologyDiagnosisDetails")
@Table(name = "cli_patient_diagnosis")
@Getter
@Setter
public class OpthamologyDiagnosisDetails {

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
    private OpthamologyCaseSheet caseSheetId;

    @Column(name = "diagnosisId",nullable = false)
    @Basic(optional = false)
    private Long diagnosisId;

    @Column(name = "isValid")
    private Long isValid;

    public static List<OpthamologyDiagnosisDetails> to(final OpthamologyCaseSheet opthamologyCaseSheet,
                                                       final List<CreateDiagnosisDetailsRequest> createDiagnosisDetailsRequestList){
        List<OpthamologyDiagnosisDetails> opthamologyDiagnosisDetailsList = new ArrayList<>();
        for(CreateDiagnosisDetailsRequest createDiagnosisDetailsRequest: createDiagnosisDetailsRequestList){
            opthamologyDiagnosisDetailsList.add(to(opthamologyCaseSheet,createDiagnosisDetailsRequest));
        }
        return opthamologyDiagnosisDetailsList;
    }

    public static OpthamologyDiagnosisDetails to(final OpthamologyCaseSheet opthamologyCaseSheet,
                                                 final CreateDiagnosisDetailsRequest diagnosisDetailsRequest){
        OpthamologyDiagnosisDetails opthamologyDiagnosisDetails = new OpthamologyDiagnosisDetails();

        opthamologyDiagnosisDetails.setPatId(diagnosisDetailsRequest.getPatId());
        opthamologyDiagnosisDetails.setVstId(diagnosisDetailsRequest.getVstId());
        opthamologyDiagnosisDetails.setIpId(diagnosisDetailsRequest.getIpId());
        opthamologyDiagnosisDetails.setCaseSheetType(diagnosisDetailsRequest.getCaseSheetType());
        opthamologyDiagnosisDetails.setCaseSheetId(opthamologyCaseSheet);
        opthamologyDiagnosisDetails.setDiagnosisId(diagnosisDetailsRequest.getDiagnosisId());
        opthamologyDiagnosisDetails.setIsValid(diagnosisDetailsRequest.getIsValid());

        return opthamologyDiagnosisDetails;
    }
}
