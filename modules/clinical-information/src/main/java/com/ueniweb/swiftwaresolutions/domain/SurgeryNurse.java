package com.ueniweb.swiftwaresolutions.domain;

import com.ueniweb.swiftwaresolutions.request.CreateSurigicalNurseRequest;
import com.ueniweb.swiftwaresolutions.request.CreateSurigicalSurgonRequest;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
@Entity(name = "SurgeryNurse")
@Table(name = "cli_ot_nurse")
public class SurgeryNurse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "surId",nullable = false)
    @Basic(optional = false)
    private SurgeryCaseSheet surId;

    @Column(name = "nurse", nullable = false)
    @Basic(optional = false)
    private String nurse;

    @Column(name = "isAssNurse",nullable = false)
    @Basic(optional = false)
    private Long isAssNurse;

    @Column(name = "isValid",nullable = false)
    @Basic(optional = false)
    private Long isValid;

    public static List<SurgeryNurse> to(final SurgeryCaseSheet surgeryCaseSheet, final List<CreateSurigicalNurseRequest> createSurigicalNurseRequests){
        List<SurgeryNurse> surgeryNurseList = new ArrayList<>();
        for (CreateSurigicalNurseRequest createSurigicalNurseRequest: createSurigicalNurseRequests) {
            surgeryNurseList.add(to(surgeryCaseSheet,createSurigicalNurseRequest));
        }
        return surgeryNurseList;
    }
    public static SurgeryNurse to(final  SurgeryCaseSheet surgeryCaseSheet,final CreateSurigicalNurseRequest createSurigicalNurseRequest) {
        SurgeryNurse surgeryNurse = new SurgeryNurse();
        surgeryNurse.setSurId(surgeryCaseSheet);
        surgeryNurse.setNurse(createSurigicalNurseRequest.getNurse());
        surgeryNurse.setIsAssNurse(createSurigicalNurseRequest.getIsAssNurse());
        surgeryNurse.setIsValid(createSurigicalNurseRequest.getIsValid());

        return surgeryNurse;
    }
}
