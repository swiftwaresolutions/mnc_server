package com.ueniweb.swiftwaresolutions.domain;

import com.ueniweb.swiftwaresolutions.request.CreateOutsideLabResultDetailsRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "OutsideLabResultDetails")
@Table(name = "cli_patient_outside_lab_result_value")
@Getter
@Setter
public class OutsideLabResultDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "labTestDisplay", nullable = false)
    @Basic(optional = false)
    private OutsideLabResult labTestDisp;

    @Column(name = "testId",nullable = false)
    @Basic(optional = false)
    private Long testId;

    @Column(name = "fldId",nullable = false)
    @Basic(optional = false)
    private Long fldId;

    @Column(name = "value")
    private String value;

    @Column(name = "isValid")
    private Long isValid;

    public static List<OutsideLabResultDetails> to(final OutsideLabResult outsideLabResult, final List<CreateOutsideLabResultDetailsRequest> createOutsideLabResultDetailsRequestList) {
        List<OutsideLabResultDetails> outsideLabResultDetailsList = new ArrayList<>();

        for(CreateOutsideLabResultDetailsRequest createOutsideLabResultDetailsRequest : createOutsideLabResultDetailsRequestList) {
            outsideLabResultDetailsList.add(to(outsideLabResult,createOutsideLabResultDetailsRequest));
        }
        return outsideLabResultDetailsList;
    }

    public static OutsideLabResultDetails to(final OutsideLabResult outsideLabResult, final CreateOutsideLabResultDetailsRequest createOutsideLabResultDetailsRequest) {
        OutsideLabResultDetails outsideLabResultDetails = new OutsideLabResultDetails();

        outsideLabResultDetails.setLabTestDisp(outsideLabResult);
        outsideLabResultDetails.setTestId(createOutsideLabResultDetailsRequest.getTestId());
        outsideLabResultDetails.setFldId(createOutsideLabResultDetailsRequest.getFldId());
        outsideLabResultDetails.setValue(createOutsideLabResultDetailsRequest.getValue());
        outsideLabResultDetails.setIsValid(1L);

        return outsideLabResultDetails;
    }


}
