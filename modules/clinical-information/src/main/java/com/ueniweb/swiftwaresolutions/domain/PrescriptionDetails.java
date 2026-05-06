package com.ueniweb.swiftwaresolutions.domain;

import com.ueniweb.swiftwaresolutions.request.CreatePrescriptionDetailsRequest;
import com.ueniweb.swiftwaresolutions.utils.DateTimeUtils;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name="PrescriptionDetails")
@Table(name = "ph_prescription_details")
@Getter
@Setter
@ToString
public class PrescriptionDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "prescription_id",nullable = false)
    @Basic(optional = false)
    private Prescription prescriptionId;

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

    @Column(name = "qno",nullable = false)
    @Basic(optional = false)
    private double qno;

    @Column(name = "timing")
    private Long timing;

    @Column(name = "duration",nullable = false)
    @Basic(optional = false)
    private double duration;

    @Column(name = "period",nullable = false)
    @Basic(optional = false)
    private Long period;

    @Column(name = "route")
    private Long route;

    @Column(name = "instruction")
    private Long instruction;

    @Column(name = "date")
    private String date;

    @Column(name = "is_order_prepared")
    private Long isOrderPrepared;

    @Column(name = "order_id",nullable = false)
    @Basic(optional = false)
    private Long orderId;

    @Column(name = "is_paid",nullable = false)
    @Basic(optional = false)
    private Long isPaid;

    @Column(name = "is_own")
    private Long isOwn;

    @Column(name = "is_cancelled")
    private Long isCancelled;

    @Column(name = "batchId",nullable = false)
    @Basic(optional = false)
    private Long batchId;

    @Column(name = "notes", columnDefinition = "TEXT")
    private String notes;

    @Column(name = "timingUnits", columnDefinition = "varchar")
    private String timingUnits;

    public static List<PrescriptionDetails> to(final Prescription prescription, final List<CreatePrescriptionDetailsRequest> createPrescriptionDetailsRequestList){
        List<PrescriptionDetails> phDescriptionDetailsList = new ArrayList<>();
        for (CreatePrescriptionDetailsRequest createPrescriptionDetailsRequest : createPrescriptionDetailsRequestList) {
            phDescriptionDetailsList.add(to(prescription, createPrescriptionDetailsRequest));
        }
        return phDescriptionDetailsList;
    }

    public static PrescriptionDetails to(final Prescription prescription, final CreatePrescriptionDetailsRequest createPrescriptionDetailsRequest){
        PrescriptionDetails prescriptionDetail = new PrescriptionDetails();
        prescriptionDetail.setPrescriptionId(prescription);
        prescriptionDetail.setGenericId(createPrescriptionDetailsRequest.getGeneric_id());
        prescriptionDetail.setProdsId(createPrescriptionDetailsRequest.getProds_id());
        prescriptionDetail.setQuantity(createPrescriptionDetailsRequest.getQuantity());
        prescriptionDetail.setUnit(createPrescriptionDetailsRequest.getUnit());
        prescriptionDetail.setQno(createPrescriptionDetailsRequest.getQno());
        prescriptionDetail.setTiming(createPrescriptionDetailsRequest.getTiming());
        prescriptionDetail.setDuration(createPrescriptionDetailsRequest.getDuration());
        prescriptionDetail.setPeriod(createPrescriptionDetailsRequest.getPeriod());
        prescriptionDetail.setRoute(createPrescriptionDetailsRequest.getRoute());
        prescriptionDetail.setInstruction(createPrescriptionDetailsRequest.getInstruction());
        prescriptionDetail.setDate(DateTimeUtils.convertLocalDateToDateFormat(LocalDate.now()));
        prescriptionDetail.setIsOrderPrepared(createPrescriptionDetailsRequest.getIs_order_prepared());
        prescriptionDetail.setOrderId(createPrescriptionDetailsRequest.getOrder_id());
        prescriptionDetail.setIsPaid(createPrescriptionDetailsRequest.getIs_paid());
        prescriptionDetail.setIsOwn(createPrescriptionDetailsRequest.getIs_own());
        prescriptionDetail.setIsCancelled(createPrescriptionDetailsRequest.getIs_cancelled());
        prescriptionDetail.setBatchId(createPrescriptionDetailsRequest.getBatchId());
        prescriptionDetail.setNotes(createPrescriptionDetailsRequest.getNotes());
        prescriptionDetail.setTimingUnits(createPrescriptionDetailsRequest.getTimingUnits());
        return prescriptionDetail;
    }

    public void update(final Prescription prescription, final CreatePrescriptionDetailsRequest createPrescriptionDetailsRequest){
        this.prescriptionId = prescription;
        this.genericId = createPrescriptionDetailsRequest.getGeneric_id();
        this.prodsId = createPrescriptionDetailsRequest.getProds_id();
        this.quantity = createPrescriptionDetailsRequest.getQuantity();
        this.unit = createPrescriptionDetailsRequest.getUnit();
        this.qno = createPrescriptionDetailsRequest.getQno();
        this.timing = createPrescriptionDetailsRequest.getTiming();
        this.duration = createPrescriptionDetailsRequest.getDuration();
        this.period = createPrescriptionDetailsRequest.getPeriod();
        this.route = createPrescriptionDetailsRequest.getRoute();
        this.instruction = createPrescriptionDetailsRequest.getInstruction();
        this.date = DateTimeUtils.convertLocalDateToDateFormat(LocalDate.now());
        this.isOrderPrepared = createPrescriptionDetailsRequest.getIs_order_prepared();
        this.orderId = createPrescriptionDetailsRequest.getOrder_id();
        this.isPaid = createPrescriptionDetailsRequest.getIs_paid();
        this.isOwn = createPrescriptionDetailsRequest.getIs_own();
        this.isCancelled = createPrescriptionDetailsRequest.getIs_cancelled();
        this.batchId = createPrescriptionDetailsRequest.getBatchId();
        this.notes = createPrescriptionDetailsRequest.getNotes();
    }

}
