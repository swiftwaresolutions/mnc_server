package com.ueniweb.swiftwaresolutions.domain;

import com.ueniweb.swiftwaresolutions.request.CreateComplaintDetailsRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity(name="DermatologyComplaintDetails")
@Table(name = "cli_patient_complaint")
@Getter
@Setter
public class DermatologyComplaintDetails {

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

    @Column(name = "complaintId",nullable = false)
    @Basic(optional = false)
    private Long complaintId;

    @Column(name = "number")
    private Double number;

    @Column(name = "period")
    private String period;

    @Column(name = "isValid")
    private Long isValid;

    public static List<DermatologyComplaintDetails> to(final DermatologyCaseSheet dermatologyCaseSheet,
                                                       final List<CreateComplaintDetailsRequest> createComplaintDetailsRequestList){
        List<DermatologyComplaintDetails> dermatologyComplaintDetailsList =new ArrayList<>();
        for (CreateComplaintDetailsRequest createComplaintDetailsRequest: createComplaintDetailsRequestList){
            dermatologyComplaintDetailsList.add(to(dermatologyCaseSheet,createComplaintDetailsRequest));
        }
        return  dermatologyComplaintDetailsList;
    }

    public static DermatologyComplaintDetails to(final DermatologyCaseSheet dermatologyCaseSheet,final CreateComplaintDetailsRequest complaintDetailsRequest){
        DermatologyComplaintDetails dermatologyComplaintDetails = new DermatologyComplaintDetails();

        dermatologyComplaintDetails.setPatId(complaintDetailsRequest.getPatId());
        dermatologyComplaintDetails.setVstId(complaintDetailsRequest.getVstId());
        dermatologyComplaintDetails.setIpId(complaintDetailsRequest.getIpId());
        dermatologyComplaintDetails.setCaseSheetType(complaintDetailsRequest.getCaseSheetType());
        dermatologyComplaintDetails.setCaseSheetId(dermatologyCaseSheet);
        dermatologyComplaintDetails.setComplaintId(complaintDetailsRequest.getComplaintId());
        dermatologyComplaintDetails.setNumber(complaintDetailsRequest.getNumber());
        dermatologyComplaintDetails.setPeriod(complaintDetailsRequest.getPeriod());
        dermatologyComplaintDetails.setIsValid(complaintDetailsRequest.getIsValid());

        return dermatologyComplaintDetails;
    }


}
