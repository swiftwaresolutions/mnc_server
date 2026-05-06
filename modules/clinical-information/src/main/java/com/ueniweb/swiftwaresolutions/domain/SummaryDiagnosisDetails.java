package com.ueniweb.swiftwaresolutions.domain;

import com.ueniweb.swiftwaresolutions.request.CreateDiagnosisDetailsRequest;
import com.ueniweb.swiftwaresolutions.request.CreateSummaryDiagnosisDetailsRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity(name="SummaryDiagnosisDetails")
@Table(name = "cli_discharge_summary_diagnosis")
@Getter
@Setter
public class SummaryDiagnosisDetails {

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
    private Integer isValid;

    public static List<SummaryDiagnosisDetails> to(final DischargeSummary dischargeSummary, final List<CreateSummaryDiagnosisDetailsRequest> createSummaryDiagnosisDetailsRequestList){
        List<SummaryDiagnosisDetails> summaryDiagnosisDetailsList = new ArrayList<>();
        for (CreateSummaryDiagnosisDetailsRequest createSummaryDiagnosisDetailsRequest: createSummaryDiagnosisDetailsRequestList) {
            summaryDiagnosisDetailsList.add(to(dischargeSummary,createSummaryDiagnosisDetailsRequest));
        }
        return summaryDiagnosisDetailsList;
    }

    public static SummaryDiagnosisDetails to(final DischargeSummary dischargeSummary,final CreateSummaryDiagnosisDetailsRequest createSummaryDiagnosisDetailsRequest){
        SummaryDiagnosisDetails summaryDiagnosisDetails = new SummaryDiagnosisDetails();
        summaryDiagnosisDetails.setPatId(createSummaryDiagnosisDetailsRequest.getPatId());
        summaryDiagnosisDetails.setVstId(createSummaryDiagnosisDetailsRequest.getVstId());
        summaryDiagnosisDetails.setIpId(createSummaryDiagnosisDetailsRequest.getIpId());
        summaryDiagnosisDetails.setSummaryId(dischargeSummary);
        summaryDiagnosisDetails.setDiagnosisId(createSummaryDiagnosisDetailsRequest.getDiagnosisId());
        summaryDiagnosisDetails.setIsValid(1);

        return summaryDiagnosisDetails;
    }
}
