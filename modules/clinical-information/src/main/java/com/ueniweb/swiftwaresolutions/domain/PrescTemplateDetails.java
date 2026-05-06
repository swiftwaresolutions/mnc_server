package com.ueniweb.swiftwaresolutions.domain;

import com.ueniweb.swiftwaresolutions.request.CreatePrescTemplateDetailsRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity(name="PrescTemplateDetails")
@Table(name = "ph_template_details")
@Getter
@Setter
public class PrescTemplateDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "template_id",nullable = false)
    @Basic(optional = false)
    private PrescTemplate templateId;

    @Column(name = "generic_id")
    private Long genericId;

    @Column(name = "prods_id",nullable = false)
    @Basic(optional = false)
    private Long prodsId;

    @Column(name = "quantity",nullable = false)
    @Basic(optional = false)
    private double quantity;

    @Column(name = "unit",nullable = false)
    @Basic(optional = false)
    private double unit;

    @Column(name = "no",nullable = false)
    @Basic(optional = false)
    private double no;

    @Column(name = "timing",nullable = false)
    @Basic(optional = false)
    private Long timing;

    @Column(name = "duration",nullable = false)
    @Basic(optional = false)
    private Long duration;

    @Column(name = "period",nullable = false)
    @Basic(optional = false)
    private Long period;

    @Column(name = "route")
    private Long route;

    @Column(name = "instruction")
    private Long instruction;

    @Column(name = "timingUnit")
    private String timingUnit;

    @Column(name = "extra1")
    private Long extra1;

    @Column(name = "extra2")
    private Long extra2;

    @Column(name = "extra3")
    private Long extra3;

    @Column(name = "extra4")
    private Long extra4;

    @Column(name = "extra5")
    private Long extra5;

    public static List<PrescTemplateDetails> to(final PrescTemplate prescTemplate, final List<CreatePrescTemplateDetailsRequest> createPrescTemplateDetailsRequestList){
        List<PrescTemplateDetails> prescTemplateDetailsList = new ArrayList<>();
        for (CreatePrescTemplateDetailsRequest createPrescTemplateDetailsRequest: createPrescTemplateDetailsRequestList) {

            prescTemplateDetailsList.add(to(prescTemplate, createPrescTemplateDetailsRequest));
        }
        return prescTemplateDetailsList;
    }

    public static PrescTemplateDetails to(final PrescTemplate prescTemplate, final CreatePrescTemplateDetailsRequest createPrescTemplateDetailsRequest){
        PrescTemplateDetails prescTemplateDetails = new PrescTemplateDetails();
        prescTemplateDetails.setTemplateId(prescTemplate);
        prescTemplateDetails.setGenericId(createPrescTemplateDetailsRequest.getGenericId());
        prescTemplateDetails.setProdsId(createPrescTemplateDetailsRequest.getProdsId());
        prescTemplateDetails.setQuantity(createPrescTemplateDetailsRequest.getQuantity());
        prescTemplateDetails.setUnit(createPrescTemplateDetailsRequest.getUnit());
        prescTemplateDetails.setNo(createPrescTemplateDetailsRequest.getNo());
        prescTemplateDetails.setTiming(createPrescTemplateDetailsRequest.getTiming());
        prescTemplateDetails.setDuration(createPrescTemplateDetailsRequest.getDuration());
        prescTemplateDetails.setPeriod(createPrescTemplateDetailsRequest.getPeriod());
        prescTemplateDetails.setRoute(createPrescTemplateDetailsRequest.getRoute());
        prescTemplateDetails.setInstruction(createPrescTemplateDetailsRequest.getInstruction());
        prescTemplateDetails.setTimingUnit(createPrescTemplateDetailsRequest.getTimingUnit());
        prescTemplateDetails.setExtra1(createPrescTemplateDetailsRequest.getExtra1());
        prescTemplateDetails.setExtra2(createPrescTemplateDetailsRequest.getExtra2());
        prescTemplateDetails.setExtra3(createPrescTemplateDetailsRequest.getExtra3());
        prescTemplateDetails.setExtra4(createPrescTemplateDetailsRequest.getExtra4());
        prescTemplateDetails.setExtra5(createPrescTemplateDetailsRequest.getExtra5());
        return prescTemplateDetails;
    }
}
