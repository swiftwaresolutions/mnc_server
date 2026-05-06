package com.ueniweb.swiftwaresolutions.domain;
import com.ueniweb.swiftwaresolutions.request.CreateAncDeliveryRequest;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
@Entity(name = "AncDeliverySheet")
@Table(name = "cli_anc_delivery_entry")
public class AncDeliverySheet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "patId",nullable = false)
    @Basic(optional = false)
    private Long patId;

    @Column(name = "vstId",nullable = false)
    @Basic(optional = false)
    private Long vstId;

    @Column(name = "Mins1",nullable = false)
    @Basic(optional = false)
    private String Mins1;

    @Column(name = "Mins5",nullable = false)
    @Basic(optional = false)
    private String Mins5;

    @Column(name = "augmentation",nullable = false)
    @Basic(optional = false)
    private String augmentation;

    @Column(name = "birth",nullable = false)
    @Basic(optional = false)
    private String birth;

    @Column(name = "birthWeight",nullable = false)
    @Basic(optional = false)
    private String birthWeight;

    @Column(name = "complication",nullable = false)
    @Basic(optional = false)
    private String complication;

    @Column(name = "deliveryDoc",nullable = false)
    @Basic(optional = false)
    private String deliveryDoc;

    @Column(name = "doa",nullable = false)
    @Basic(optional = false)
    private String doa;

    @Column(name = "dod",nullable = false)
    @Basic(optional = false)
    private String dod;

    @Column(name = "dob",nullable = false)
    @Basic(optional = false)
    private String dob;

    @Column(name = "indication",nullable = false)
    @Basic(optional = false)
    private String indication;

    @Column(name = "liquor",nullable = false)
    @Basic(optional = false)
    private String liquor;

    @Column(name = "modeDelivery",nullable = false)
    @Basic(optional = false)
    private String modeDelivery;

    @Column(name = "other",nullable = false)
    @Basic(optional = false)
    private String other;

    @Column(name = "overais",nullable = false)
    @Basic(optional = false)
    private String overais;

    @Column(name = "presentation",nullable = false)
    @Basic(optional = false)
    private String presentation;

    @Column(name = "riskFactor",nullable = false)
    @Basic(optional = false)
    private String riskFactor;

    @Column(name = "sex",nullable = false)
    @Basic(optional = false)
    private String sex;

    @Column(name = "toa",nullable = false)
    @Basic(optional = false)
    private String toa;

    @Column(name = "tob",nullable = false)
    @Basic(optional = false)
    private String tob;

    @Column(name = "tod",nullable = false)
    @Basic(optional = false)
    private String tod;

    @Column(name = "uterus",nullable = false)
    @Basic(optional = false)
    private String uterus;

    @OneToMany(mappedBy = "anc_Delivery_id", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AncDeliveryInduction> ancDeliveryInductionList = new ArrayList<>();


    public static AncDeliverySheet to(final CreateAncDeliveryRequest createAncDeliveryRequest){
        AncDeliverySheet ancDeliverySheet = new AncDeliverySheet();
        ancDeliverySheet.setPatId(createAncDeliveryRequest.getPatId());
        ancDeliverySheet.setVstId(createAncDeliveryRequest.getVstId());
        ancDeliverySheet.setMins1(createAncDeliveryRequest.getMins1());
        ancDeliverySheet.setMins5(createAncDeliveryRequest.getMins5());
        ancDeliverySheet.setAugmentation(createAncDeliveryRequest.getAugmentation());
        ancDeliverySheet.setBirth(createAncDeliveryRequest.getBirth());
        ancDeliverySheet.setBirthWeight(createAncDeliveryRequest.getBirthWeight());
        ancDeliverySheet.setComplication(createAncDeliveryRequest.getComplication());
        ancDeliverySheet.setDeliveryDoc(createAncDeliveryRequest.getDeliveryDoc());
        ancDeliverySheet.setDoa(createAncDeliveryRequest.getDoa());
        ancDeliverySheet.setDob(createAncDeliveryRequest.getDob());
        ancDeliverySheet.setDod(createAncDeliveryRequest.getDod());
        ancDeliverySheet.setIndication(createAncDeliveryRequest.getIndication());
        ancDeliverySheet.setLiquor(createAncDeliveryRequest.getLiquor());
        ancDeliverySheet.setModeDelivery(createAncDeliveryRequest.getModeDelivery());
        ancDeliverySheet.setOther(createAncDeliveryRequest.getOther());
        ancDeliverySheet.setOverais(createAncDeliveryRequest.getOverais());
        ancDeliverySheet.setPresentation(createAncDeliveryRequest.getPresentation());
        ancDeliverySheet.setRiskFactor(createAncDeliveryRequest.getRiskFactor());
        ancDeliverySheet.setSex(createAncDeliveryRequest.getSex());
        ancDeliverySheet.setToa(createAncDeliveryRequest.getToa());
        ancDeliverySheet.setTob(createAncDeliveryRequest.getTob());
        ancDeliverySheet.setTod(createAncDeliveryRequest.getTod());
        ancDeliverySheet.setUterus(createAncDeliveryRequest.getUterus());

        return ancDeliverySheet;
    }
    public void update(final CreateAncDeliveryRequest createAncDeliveryRequest) {
        this.setPatId(createAncDeliveryRequest.getPatId());
        this.setVstId(createAncDeliveryRequest.getVstId());
        this.setMins1(createAncDeliveryRequest.getMins1());
        this.setMins5(createAncDeliveryRequest.getMins5());
        this.setAugmentation(createAncDeliveryRequest.getAugmentation());
        this.setBirth(createAncDeliveryRequest.getBirth());
        this.setBirthWeight(createAncDeliveryRequest.getBirthWeight());
        this.setComplication(createAncDeliveryRequest.getComplication());
        this.setDeliveryDoc(createAncDeliveryRequest.getDeliveryDoc());
        this.setDoa(createAncDeliveryRequest.getDoa());
        this.setDod(createAncDeliveryRequest.getDod());
        this.setDob(createAncDeliveryRequest.getDob());
        this.setIndication(createAncDeliveryRequest.getIndication());
        this.setLiquor(createAncDeliveryRequest.getLiquor());
        this.setModeDelivery(createAncDeliveryRequest.getModeDelivery());
        this.setOther(createAncDeliveryRequest.getOther());
        this.setOverais(createAncDeliveryRequest.getOverais());
        this.setPresentation(createAncDeliveryRequest.getPresentation());
        this.setRiskFactor(createAncDeliveryRequest.getRiskFactor());
        this.setSex(createAncDeliveryRequest.getSex());
        this.setToa(createAncDeliveryRequest.getToa());
        this.setTob(createAncDeliveryRequest.getTob());
        this.setUterus(createAncDeliveryRequest.getUterus());
    }
}
