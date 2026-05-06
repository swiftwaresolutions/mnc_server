package com.ueniweb.swiftwaresolutions.domain;

import com.ueniweb.swiftwaresolutions.request.CreateComplaintDetailsRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity(name="ComplaintDetails")
@Table(name = "cli_patient_complaint")
@Getter
@Setter
public class ComplaintDetails {

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

    @Column(name = "complaintId",nullable = false)
    @Basic(optional = false)
    private Long complaintId;

    @Column(name = "number")
    private Double number;

    @Column(name = "period")
    private String period;

    @Column(name = "isValid")
    private Long isValid;

    public static List<ComplaintDetails> to(final GeneralCaseSheet generalCaseSheet,final List<CreateComplaintDetailsRequest> createComplaintDetailsRequestList){
        List<ComplaintDetails> complaintDetailsList = new ArrayList<>();
        for (CreateComplaintDetailsRequest createComplaintDetailsRequest: createComplaintDetailsRequestList) {
            complaintDetailsList.add(to(generalCaseSheet,createComplaintDetailsRequest));
        }
        return complaintDetailsList;
    }

        public static ComplaintDetails to(final GeneralCaseSheet generalCaseSheet,final CreateComplaintDetailsRequest complaintDetailsRequest){
            ComplaintDetails complaintDetails = new ComplaintDetails();
            complaintDetails.setPatId(complaintDetailsRequest.getPatId());
            complaintDetails.setVstId(complaintDetailsRequest.getVstId());
            complaintDetails.setIpId(complaintDetailsRequest.getIpId());
            complaintDetails.setCaseSheetType(complaintDetailsRequest.getCaseSheetType());
            complaintDetails.setCaseSheetId(generalCaseSheet);
            complaintDetails.setComplaintId(complaintDetailsRequest.getComplaintId());
            complaintDetails.setNumber(complaintDetailsRequest.getNumber());
            complaintDetails.setPeriod(complaintDetailsRequest.getPeriod());
            complaintDetails.setIsValid(complaintDetailsRequest.getIsValid());

            return complaintDetails;
        }

}
