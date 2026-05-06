package com.ueniweb.swiftwaresolutions.domain;

import com.ueniweb.swiftwaresolutions.request.CreateComplaintDetailsRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity(name="NeoNateComplaintDetails")
@Table(name = "cli_patient_complaint")
@Getter
@Setter
public class NeoNateComplaintDetails {

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
    private NeonateCaseSheet caseSheetId;

    @Column(name = "complaintId",nullable = false)
    @Basic(optional = false)
    private Long complaintId;

    @Column(name = "number")
    private Double number;

    @Column(name = "period")
    private String period;

    @Column(name = "isValid")
    private Long isValid;

    public static List<NeoNateComplaintDetails> to(final NeonateCaseSheet neonateCaseSheet, final List<CreateComplaintDetailsRequest> createComplaintDetailsRequestList){
        List<NeoNateComplaintDetails> complaintDetailsList = new ArrayList<>();
        for (CreateComplaintDetailsRequest createComplaintDetailsRequest: createComplaintDetailsRequestList) {
            complaintDetailsList.add(to(neonateCaseSheet,createComplaintDetailsRequest));
        }
        return complaintDetailsList;
    }

    public static NeoNateComplaintDetails to(final NeonateCaseSheet neonateCaseSheet, final CreateComplaintDetailsRequest complaintDetailsRequest){
        NeoNateComplaintDetails complaintDetails = new NeoNateComplaintDetails();
        complaintDetails.setPatId(complaintDetailsRequest.getPatId());
        complaintDetails.setVstId(complaintDetailsRequest.getVstId());
        complaintDetails.setIpId(complaintDetailsRequest.getIpId());
        complaintDetails.setCaseSheetType(complaintDetailsRequest.getCaseSheetType());
        complaintDetails.setCaseSheetId(neonateCaseSheet);
        complaintDetails.setComplaintId(complaintDetailsRequest.getComplaintId());
        complaintDetails.setNumber(complaintDetailsRequest.getNumber());
        complaintDetails.setPeriod(complaintDetailsRequest.getPeriod());
        complaintDetails.setIsValid(complaintDetailsRequest.getIsValid());

        return complaintDetails;
    }
}
