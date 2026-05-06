package com.ueniweb.swiftwaresolutions.domain;

import com.ueniweb.swiftwaresolutions.request.CreateComplaintDetailsRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity(name="DentalComplaintDetails")
@Table(name = "cli_patient_complaint")
@Getter
@Setter
public class DentalComplaintDetails {

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
    private DentalCaseSheet caseSheetId;

    @Column(name = "complaintId",nullable = false)
    @Basic(optional = false)
    private Long complaintId;

    @Column(name = "number")
    private Double number;

    @Column(name = "period")
    private String period;

    @Column(name = "isValid")
    private Long isValid;

    public static List<DentalComplaintDetails> to(final DentalCaseSheet dentalCaseSheet,
                                                  final List<CreateComplaintDetailsRequest> createComplaintDetailsRequestList){
        List<DentalComplaintDetails> complaintDetailsList = new ArrayList<>();
        for (CreateComplaintDetailsRequest createComplaintDetailsRequest: createComplaintDetailsRequestList) {
            complaintDetailsList.add(to(dentalCaseSheet,createComplaintDetailsRequest));
        }
        return complaintDetailsList;

    }

    public static DentalComplaintDetails to(final DentalCaseSheet dentalCaseSheet,final CreateComplaintDetailsRequest complaintDetailsRequest){
        DentalComplaintDetails complaintDetails = new DentalComplaintDetails();
        complaintDetails.setPatId(complaintDetailsRequest.getPatId());
        complaintDetails.setVstId(complaintDetailsRequest.getVstId());
        complaintDetails.setIpId(complaintDetailsRequest.getIpId());
        complaintDetails.setCaseSheetType(complaintDetailsRequest.getCaseSheetType());
        complaintDetails.setCaseSheetId(dentalCaseSheet);
        complaintDetails.setComplaintId(complaintDetailsRequest.getComplaintId());
        complaintDetails.setNumber(complaintDetailsRequest.getNumber());
        complaintDetails.setPeriod(complaintDetailsRequest.getPeriod());
        complaintDetails.setIsValid(complaintDetailsRequest.getIsValid());

        return complaintDetails;
    }

}
