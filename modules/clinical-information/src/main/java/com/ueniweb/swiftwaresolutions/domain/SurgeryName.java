package com.ueniweb.swiftwaresolutions.domain;

import com.ueniweb.swiftwaresolutions.request.CreateSurgicalSurgeryRequest;
import com.ueniweb.swiftwaresolutions.request.CreateSurigicalNurseRequest;
import com.ueniweb.swiftwaresolutions.request.CreateSurigicalSurgonRequest;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "SurgeryName")
@Table(name = "cli_ot_surgeryname")
public class SurgeryName {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "surId",nullable = false)
    @Basic(optional = false)
    private SurgeryCaseSheet surId;

    @Column(name = "SurgeryName", nullable = false)
    @Basic(optional = false)
    private String SurgeryName;

    @Column(name = "isValid",nullable = false)
    @Basic(optional = false)
    private Long isValid;

    public static List<SurgeryName> to(final SurgeryCaseSheet surgeryCaseSheet, final List<CreateSurgicalSurgeryRequest> createSurgicalSurgeryRequests){
        List<SurgeryName> surgeryNameList = new ArrayList<>();
        for (CreateSurgicalSurgeryRequest createSurgicalSurgeryRequest: createSurgicalSurgeryRequests) {
            surgeryNameList.add(to(surgeryCaseSheet,createSurgicalSurgeryRequest));
        }
        return surgeryNameList;
    }

    public static SurgeryName to(final  SurgeryCaseSheet surgeryCaseSheet,final CreateSurgicalSurgeryRequest createSurgicalSurgeryRequest) {
        SurgeryName surgeryName = new SurgeryName();
        surgeryName.setSurId(surgeryCaseSheet);
        surgeryName.setSurgeryName(createSurgicalSurgeryRequest.getSurgeryName());
        surgeryName.setIsValid(createSurgicalSurgeryRequest.getIsValid());

        return surgeryName;
    }
}
