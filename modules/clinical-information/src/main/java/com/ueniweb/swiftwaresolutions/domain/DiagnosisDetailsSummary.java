package com.ueniweb.swiftwaresolutions.domain;

import com.ueniweb.swiftwaresolutions.request.CreateComplaintDetailsRequest;
import com.ueniweb.swiftwaresolutions.request.CreateDiagnosisDetailsRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity(name="DiagnosisDetailsSummary")
@Table(name = "cli_discharge_summary_diagnosis")
@Getter
@Setter
public class DiagnosisDetailsSummary {

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

    @ManyToOne
    @JoinColumn(name = "summaryId",nullable = false)
    @Basic(optional = false)
    private DischargeSummary summaryId;

    @Column(name = "diagnosisId",nullable = false)
    @Basic(optional = false)
    private Long diagnosisId;

    @Column(name = "isValid")
    private Long isValid;

    public static List<DiagnosisDetailsSummary> to(final DischargeSummary dischargeSummary, final List<CreateDiagnosisDetailsRequest> createDiagnosisDetailsRequestList){
        List<DiagnosisDetailsSummary> diagnosisDetailsSummaryList = new ArrayList<>();
        for (CreateDiagnosisDetailsRequest createDiagnosisDetailsRequest: createDiagnosisDetailsRequestList) {
            diagnosisDetailsSummaryList.add(to(dischargeSummary,createDiagnosisDetailsRequest));
        }
        return diagnosisDetailsSummaryList;
    }

    public static DiagnosisDetailsSummary to(final DischargeSummary dischargeSummary,final CreateDiagnosisDetailsRequest diagnosisDetailsRequest){
        DiagnosisDetailsSummary diagnosisDetailsSummary = new DiagnosisDetailsSummary();
        diagnosisDetailsSummary.setPatId(diagnosisDetailsRequest.getPatId());
        diagnosisDetailsSummary.setVstId(diagnosisDetailsRequest.getVstId());
        diagnosisDetailsSummary.setIpId(diagnosisDetailsRequest.getIpId());
        diagnosisDetailsSummary.setSummaryId(dischargeSummary);
        diagnosisDetailsSummary.setDiagnosisId(diagnosisDetailsRequest.getDiagnosisId());
        diagnosisDetailsSummary.setIsValid(diagnosisDetailsRequest.getIsValid());

        return diagnosisDetailsSummary;
    }
}
