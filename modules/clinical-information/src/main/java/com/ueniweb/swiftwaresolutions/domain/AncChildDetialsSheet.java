package com.ueniweb.swiftwaresolutions.domain;

import com.ueniweb.swiftwaresolutions.request.CreateAncChildRequest;
import com.ueniweb.swiftwaresolutions.request.CreateAncDetailsRequest;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Data
@Entity(name = "AncChildDetialsSheet")
@Table(name = "cli_anc_child")
@Getter
@Setter
public class AncChildDetialsSheet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "anc_id",nullable = false)
    @Basic(optional = false)
    private AncCaseSheet anc_id;

    @Column(name = "status",nullable = false)
    @Basic(optional = false)
    private Long status;

    @Column(name = "type",nullable = false)
    @Basic(optional = false)
    private Long type;

    @Column(name = "birthdate",nullable = false)
    @Basic(optional = false)
    private String birthdate;

    @Column(name = "mode",nullable = false)
    @Basic(optional = false)
    private String mode;

    @Column(name = "place",nullable = false)
    @Basic(optional = false)
    private String place;

    @Column(name = "others",nullable = false)
    @Basic(optional = false)
    private String others;

    @Column(name = "isValid",nullable = false)
    @Basic(optional = false)
    private Long isValid;

    @Column(name = "sex",nullable = false)
    @Basic(optional = false)
    private Long sex;

    @Column(name = "riskFacOfThisPre",nullable = false)
    @Basic(optional = false)
    private String riskFacOfThisPre;

    public static List<AncChildDetialsSheet> to(final AncCaseSheet ancCaseSheet, final List<CreateAncChildRequest> createAncChildRequests){
        List<AncChildDetialsSheet> ancChildDetialsSheetList = new ArrayList<>();
        for (CreateAncChildRequest createAncChildRequest: createAncChildRequests) {
            ancChildDetialsSheetList.add(to(ancCaseSheet,createAncChildRequest));
        }
        return ancChildDetialsSheetList;
    }
    public static AncChildDetialsSheet to(final AncCaseSheet ancCaseSheet, final CreateAncChildRequest createAncChildRequest){
        AncChildDetialsSheet ancChildDetialsSheet = new AncChildDetialsSheet();
        ancChildDetialsSheet.setAnc_id(ancCaseSheet);
        ancChildDetialsSheet.setStatus(createAncChildRequest.getStatus());
        ancChildDetialsSheet.setMode(createAncChildRequest.getMode());
        ancChildDetialsSheet.setBirthdate(createAncChildRequest.getBirthdate());
        ancChildDetialsSheet.setPlace(createAncChildRequest.getPlace());
        ancChildDetialsSheet.setOthers(createAncChildRequest.getOthers());
        ancChildDetialsSheet.setType(createAncChildRequest.getType());
        ancChildDetialsSheet.setIsValid(createAncChildRequest.getIsValid());
        ancChildDetialsSheet.setSex(createAncChildRequest.getSex());
        ancChildDetialsSheet.setRiskFacOfThisPre(createAncChildRequest.getRiskFacOfThisPre());


        return ancChildDetialsSheet;
    }

    public void update (final CreateAncChildRequest createAncChildRequest) {
        this.setStatus(createAncChildRequest.getStatus());
        this.setMode(createAncChildRequest.getMode());
        this.setBirthdate(createAncChildRequest.getBirthdate());
        this.setPlace(createAncChildRequest.getPlace());
        this.setOthers(createAncChildRequest.getOthers());
        this.setType(createAncChildRequest.getType());
        this.setSex(createAncChildRequest.getSex());
        this.setRiskFacOfThisPre(createAncChildRequest.getRiskFacOfThisPre());
    }
}
