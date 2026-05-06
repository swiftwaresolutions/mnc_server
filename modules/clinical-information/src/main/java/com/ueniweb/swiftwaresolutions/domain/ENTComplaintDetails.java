package com.ueniweb.swiftwaresolutions.domain;

import com.ueniweb.swiftwaresolutions.request.CreateComplaintDetailsRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity(name="ENTComplaintDetails")
@Table(name = "cli_patient_complaint")
@Getter
@Setter
public class ENTComplaintDetails {

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

    @Column(name = "complaintId",nullable = false)
    @Basic(optional = false)
    private Long complaintId;

    @Column(name = "number")
    private Double number;

    @Column(name = "period")
    private String period;

    @Column(name = "isValid")
    private Long isValid;

    public static List<ENTComplaintDetails> to(final ENTCaseSheet entCaseSheet,
                                                       final List<CreateComplaintDetailsRequest> createComplaintDetailsRequestList){
        List<ENTComplaintDetails> entComplaintDetailsList =new ArrayList<>();
        for (CreateComplaintDetailsRequest createComplaintDetailsRequest: createComplaintDetailsRequestList){
            entComplaintDetailsList.add(to(entCaseSheet,createComplaintDetailsRequest));
        }
        return  entComplaintDetailsList;
    }

    public static ENTComplaintDetails to(final ENTCaseSheet entCaseSheet,final CreateComplaintDetailsRequest complaintDetailsRequest){
        ENTComplaintDetails entComplaintDetails = new ENTComplaintDetails();

        entComplaintDetails.setPatId(complaintDetailsRequest.getPatId());
        entComplaintDetails.setVstId(complaintDetailsRequest.getVstId());
        entComplaintDetails.setIpId(complaintDetailsRequest.getIpId());
        entComplaintDetails.setCaseSheetType(complaintDetailsRequest.getCaseSheetType());
        entComplaintDetails.setCaseSheetId(entCaseSheet);
        entComplaintDetails.setComplaintId(complaintDetailsRequest.getComplaintId());
        entComplaintDetails.setNumber(complaintDetailsRequest.getNumber());
        entComplaintDetails.setPeriod(complaintDetailsRequest.getPeriod());
        entComplaintDetails.setIsValid(complaintDetailsRequest.getIsValid());

        return entComplaintDetails;
    }
}
