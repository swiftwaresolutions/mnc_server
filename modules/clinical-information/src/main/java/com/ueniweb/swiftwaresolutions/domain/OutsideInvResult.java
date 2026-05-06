package com.ueniweb.swiftwaresolutions.domain;

import com.ueniweb.swiftwaresolutions.request.CreateOutsideInvDetailsRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "OutsideInvResult")
@Table(name = "cli_patient_outside_inv")
@Getter
@Setter
public class OutsideInvResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "invDisplay",nullable = false)
    @Basic(optional = false)
    private OutsideInv invDisplay;

    @Column(name = "deptId",nullable = false)
    @Basic(optional = false)
    private Long deptId;

    @Column(name = "invId",nullable = false)
    @Basic(optional = false)
    private Long invId;

    @Column(name = "findings")
    private String findings;

    @Column(name = "isValid")
    private Long isValid;

    public static List<OutsideInvResult> to(final OutsideInv outsideInv, final List<CreateOutsideInvDetailsRequest> createOutsideInvDetailsRequestList) {
        List<OutsideInvResult> outsideInvResultList = new ArrayList<>();

        for (CreateOutsideInvDetailsRequest createOutsideInvDetailsRequest : createOutsideInvDetailsRequestList) {
            outsideInvResultList.add(to(outsideInv,createOutsideInvDetailsRequest));
        }
        return outsideInvResultList;
    }

    public static OutsideInvResult to(final OutsideInv outsideInv, final CreateOutsideInvDetailsRequest createOutsideInvDetailsRequest) {
        OutsideInvResult outsideInvResult = new OutsideInvResult();

        outsideInvResult.setInvDisplay(outsideInv);
        outsideInvResult.setDeptId(createOutsideInvDetailsRequest.getDeptId());
        outsideInvResult.setInvId(createOutsideInvDetailsRequest.getInvId());
        outsideInvResult.setFindings(createOutsideInvDetailsRequest.getFindings());
        outsideInvResult.setIsValid(1L);

        return outsideInvResult;
    }
}
