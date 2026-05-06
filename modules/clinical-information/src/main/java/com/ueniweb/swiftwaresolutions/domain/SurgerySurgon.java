package com.ueniweb.swiftwaresolutions.domain;
import com.ueniweb.swiftwaresolutions.request.CreateComplaintDetailsRequest;
import com.ueniweb.swiftwaresolutions.request.CreateSurgeryCaseSheetRequest;

import com.ueniweb.swiftwaresolutions.request.CreateSurigicalSurgonRequest;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
@Entity(name = "SurgerySurgon")
@Table(name = "cli_ot_surgon")

public class SurgerySurgon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "surId",nullable = false)
    @Basic(optional = false)
    private SurgeryCaseSheet surId;

    @Column(name = "surgonId", nullable = false)
    @Basic(optional = false)
    private Long surgonId;

    @Column(name = "isAssSurgon",nullable = false)
    @Basic(optional = false)
    private Long isAssSurgon;

    @Column(name = "isValid",nullable = false)
    @Basic(optional = false)
    private Long isVAlid;

    public static List<SurgerySurgon> to(final SurgeryCaseSheet surgeryCaseSheet, final List<CreateSurigicalSurgonRequest> createSurigicalSurgonRequests){
        List<SurgerySurgon> surgerySurgonList = new ArrayList<>();
        for (CreateSurigicalSurgonRequest createSurigicalSurgonRequest: createSurigicalSurgonRequests) {
            surgerySurgonList.add(to(surgeryCaseSheet,createSurigicalSurgonRequest));
        }
        return surgerySurgonList;
    }


    public static SurgerySurgon to(final  SurgeryCaseSheet surgeryCaseSheet,final CreateSurigicalSurgonRequest createSurigicalSurgonRequest){
        SurgerySurgon surgerySurgon = new SurgerySurgon();
        surgerySurgon.setSurId(surgeryCaseSheet);
        surgerySurgon.setSurgonId(createSurigicalSurgonRequest.getSurgonId());
        surgerySurgon.setIsAssSurgon(createSurigicalSurgonRequest.getIsAssSurgon());
        surgerySurgon.setIsVAlid(createSurigicalSurgonRequest.getIsValid());


        return surgerySurgon;
    }
}
