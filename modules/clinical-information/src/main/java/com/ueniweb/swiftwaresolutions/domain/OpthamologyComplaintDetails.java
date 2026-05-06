package com.ueniweb.swiftwaresolutions.domain;

import com.ueniweb.swiftwaresolutions.request.CreateComplaintDetailsRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity(name="OpthamologyComplaintDetails")
@Table(name = "cli_patient_complaint")
@Getter
@Setter
public class OpthamologyComplaintDetails {

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

    @Column(name = "complaintId",nullable = false)
    @Basic(optional = false)
    private Long complaintId;

    @Column(name = "number")
    private Double number;

    @Column(name = "period")
    private String period;

    @Column(name = "isValid")
    private Long isValid;

    public static List<OpthamologyComplaintDetails> to(final OpthamologyCaseSheet opthamologyCaseSheet,
                                                       final List<CreateComplaintDetailsRequest> createComplaintDetailsRequestList){
        List<OpthamologyComplaintDetails> opthamologyComplaintDetailsList =new ArrayList<>();
        for (CreateComplaintDetailsRequest createComplaintDetailsRequest: createComplaintDetailsRequestList){
            opthamologyComplaintDetailsList.add(to(opthamologyCaseSheet,createComplaintDetailsRequest));
        }
        return  opthamologyComplaintDetailsList;
    }

    public static OpthamologyComplaintDetails to(final OpthamologyCaseSheet opthamologyCaseSheet,final CreateComplaintDetailsRequest complaintDetailsRequest){
        OpthamologyComplaintDetails opthamologyComplaintDetails = new OpthamologyComplaintDetails();

        opthamologyComplaintDetails.setPatId(complaintDetailsRequest.getPatId());
        opthamologyComplaintDetails.setVstId(complaintDetailsRequest.getVstId());
        opthamologyComplaintDetails.setIpId(complaintDetailsRequest.getIpId());
        opthamologyComplaintDetails.setCaseSheetType(complaintDetailsRequest.getCaseSheetType());
        opthamologyComplaintDetails.setCaseSheetId(opthamologyCaseSheet);
        opthamologyComplaintDetails.setComplaintId(complaintDetailsRequest.getComplaintId());
        opthamologyComplaintDetails.setNumber(complaintDetailsRequest.getNumber());
        opthamologyComplaintDetails.setPeriod(complaintDetailsRequest.getPeriod());
        opthamologyComplaintDetails.setIsValid(complaintDetailsRequest.getIsValid());

        return opthamologyComplaintDetails;
    }
}
