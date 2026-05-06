package com.ueniweb.swiftwaresolutions.domain;


import com.ueniweb.swiftwaresolutions.request.CreateTeethExamDetailsRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity(name ="DentalTeethExamDetails")
@Table(name = "cli_patient_teeth_complaints")
@Getter
@Setter
public class DentalTeethExamDetails {

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

    public static List<DentalTeethExamDetails> to(final DentalCaseSheet dentalCaseSheet,
                                                  final List<CreateTeethExamDetailsRequest> createTeethExamDetailsRequestList) {
        List<DentalTeethExamDetails> teethExamDetailsList = new ArrayList<>();
        for (CreateTeethExamDetailsRequest createTeethExamDetailsRequest : createTeethExamDetailsRequestList) {
            teethExamDetailsList.add(to(dentalCaseSheet,createTeethExamDetailsRequest));
        }
        return teethExamDetailsList;
    }

    public static DentalTeethExamDetails to(final DentalCaseSheet dentalCaseSheet, final CreateTeethExamDetailsRequest teethExamRequest){
        DentalTeethExamDetails teethExamDetail = new DentalTeethExamDetails();
        teethExamDetail.setPatId(teethExamRequest.getPatId());
        teethExamDetail.setVstId(teethExamRequest.getVstId());
        teethExamDetail.setIpId(teethExamRequest.getIpId());
        teethExamDetail.setCaseSheetId(dentalCaseSheet);
        teethExamDetail.setToothnum(teethExamRequest.getToothnum());
        teethExamDetail.setTeethdetails(teethExamRequest.getTeethdetails());
        teethExamDetail.setIsValid(teethExamRequest.getIsValid());
        teethExamDetail.setTeethtype(teethExamRequest.getTeethType());

        return teethExamDetail;
    }

}
