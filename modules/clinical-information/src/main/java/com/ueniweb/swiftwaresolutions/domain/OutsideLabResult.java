package com.ueniweb.swiftwaresolutions.domain;

import com.ueniweb.swiftwaresolutions.request.CreateOutsideLabResultRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "OutsideLabResult")
@Table(name = "cli_patient_outside_lab_result")
@Getter
@Setter
public class OutsideLabResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "labDisplay",nullable = false)
    @Basic(optional = false)
    private OutsideLab labDisp;

    @Column(name = "deptId",nullable = false)
    @Basic(optional = false)
    private Long deptId;

    @Column(name = "testId",nullable = false)
    @Basic(optional = false)
    private Long testId;

    @Column(name = "notes")
    private String notes;

    @Column(name = "isValid")
    private Long isValid;

    @OneToMany(mappedBy = "labTestDisp",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OutsideLabResultDetails> outsideLabResultDetailsList =new ArrayList<>();

    public static List<OutsideLabResult> to(final OutsideLab outsideLab, final List<CreateOutsideLabResultRequest> createOutsideLabResultRequestList) {
        List<OutsideLabResult> outsideLabResultList = new ArrayList<>();

        for (CreateOutsideLabResultRequest createOutsideLabResultRequest : createOutsideLabResultRequestList) {
            outsideLabResultList.add(to(outsideLab, createOutsideLabResultRequest));
        }
        return outsideLabResultList;
    }

    public static OutsideLabResult to(final OutsideLab outsideLab, final CreateOutsideLabResultRequest createOutsideLabResultRequest) {
        OutsideLabResult outsideLabResult = new OutsideLabResult();

        outsideLabResult.setLabDisp(outsideLab);
        outsideLabResult.setTestId(createOutsideLabResultRequest.getTestId());
        outsideLabResult.setDeptId(createOutsideLabResultRequest.getDeptId());
        outsideLabResult.setNotes(createOutsideLabResultRequest.getNotes());
        outsideLabResult.setIsValid(1L);

        if (createOutsideLabResultRequest.getCreateOutsideLabResultDetailsRequestList() != null) {
            List<OutsideLabResultDetails> detailsList = OutsideLabResultDetails.to(outsideLabResult, createOutsideLabResultRequest.getCreateOutsideLabResultDetailsRequestList());
            outsideLabResult.setOutsideLabResultDetailsList(detailsList);
        }

        return outsideLabResult;
    }

}
