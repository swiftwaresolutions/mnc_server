package com.ueniweb.swiftwaresolutions.domain;


import com.ueniweb.swiftwaresolutions.request.CreateTeethTreatDetailsRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity(name ="DentalTeethTreatDetails")
@Table(name = "cli_patient_teeth_treatments")
@Getter
@Setter
public class DentalTeethTreatDetails {

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
    @JoinColumn(name = "caseSheetId",nullable = false)
    @Basic(optional = false)
    private DentalCaseSheet caseSheetId;

    @Column(name = "toothnum")
    private String toothnum;

    @Column(name = "teethdetails")
    private String teethdetails;

    @Column(name = "isValid")
    private Long isValid;

    @Column(name = "teethtype")
    private Long teethtype;

    public static List<DentalTeethTreatDetails> to(final DentalCaseSheet dentalCaseSheet,
                                                   final List<CreateTeethTreatDetailsRequest> createTeethTreatDetailsRequestList) {
        List<DentalTeethTreatDetails> teethTreatDetailsList = new ArrayList<>();
        for (CreateTeethTreatDetailsRequest createTeethTreatDetailsRequest : createTeethTreatDetailsRequestList) {
            teethTreatDetailsList.add(to(dentalCaseSheet,createTeethTreatDetailsRequest));
        }
        return teethTreatDetailsList;
    }

    public static DentalTeethTreatDetails to(final DentalCaseSheet dentalCaseSheet, final CreateTeethTreatDetailsRequest teethTreatRequest){
        DentalTeethTreatDetails teethTreatDetail = new DentalTeethTreatDetails();
        teethTreatDetail.setPatId(teethTreatRequest.getPatId());
        teethTreatDetail.setVstId(teethTreatRequest.getVstId());
        teethTreatDetail.setIpId(teethTreatRequest.getIpId());
        teethTreatDetail.setCaseSheetId(dentalCaseSheet);
        teethTreatDetail.setToothnum(teethTreatRequest.getToothnum());
        teethTreatDetail.setTeethdetails(teethTreatRequest.getTeethdetails());
        teethTreatDetail.setIsValid(teethTreatRequest.getIsValid());
        teethTreatDetail.setTeethtype(teethTreatRequest.getTeethType());

        return teethTreatDetail;
    }

}
