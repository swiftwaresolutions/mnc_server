package com.ueniweb.swiftwaresolutions.domain;

import com.ueniweb.swiftwaresolutions.request.CreateDiagnosisDetailsRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity(name="DermatologyDiagnosisDetails")
@Table(name = "cli_patient_diagnosis")
@Getter
@Setter
public class DermatologyDiagnosisDetails {

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
    private DermatologyCaseSheet caseSheetId;

    @Column(name = "diagnosisId",nullable = false)
    @Basic(optional = false)
    private Long diagnosisId;

    @Column(name = "isValid")
    private Long isValid;

    public static List<DermatologyDiagnosisDetails> to(final DermatologyCaseSheet dermatologyCaseSheet,
                                                       final List<CreateDiagnosisDetailsRequest> createDiagnosisDetailsRequestList){
        List<DermatologyDiagnosisDetails> dermatologyDiagnosisDetailsList = new ArrayList<>();
        for(CreateDiagnosisDetailsRequest createDiagnosisDetailsRequest: createDiagnosisDetailsRequestList){
            dermatologyDiagnosisDetailsList.add(to(dermatologyCaseSheet,createDiagnosisDetailsRequest));
        }
        return dermatologyDiagnosisDetailsList;
    }

    public static DermatologyDiagnosisDetails to(final DermatologyCaseSheet dermatologyCaseSheet,
                                                 final CreateDiagnosisDetailsRequest diagnosisDetailsRequest){
        DermatologyDiagnosisDetails dermatologyDiagnosisDetails = new DermatologyDiagnosisDetails();

        dermatologyDiagnosisDetails.setPatId(diagnosisDetailsRequest.getPatId());
        dermatologyDiagnosisDetails.setVstId(diagnosisDetailsRequest.getVstId());
        dermatologyDiagnosisDetails.setIpId(diagnosisDetailsRequest.getIpId());
        dermatologyDiagnosisDetails.setCaseSheetType(diagnosisDetailsRequest.getCaseSheetType());
        dermatologyDiagnosisDetails.setCaseSheetId(dermatologyCaseSheet);
        dermatologyDiagnosisDetails.setDiagnosisId(diagnosisDetailsRequest.getDiagnosisId());
        dermatologyDiagnosisDetails.setIsValid(diagnosisDetailsRequest.getIsValid());

        return dermatologyDiagnosisDetails;
    }

}
