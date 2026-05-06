package com.ueniweb.swiftwaresolutions.domain;

import com.ueniweb.swiftwaresolutions.request.CreatePrescriptionRequest;
import com.ueniweb.swiftwaresolutions.request.UpdatePrescriptionRequest;
import com.ueniweb.swiftwaresolutions.utils.DateTimeUtils;
import jakarta.persistence.*;
import jakarta.persistence.PrePersist;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name="Prescription")
@Table(name = "ph_prescription")
@Getter
@Setter
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "display")
    private String display;

    @Column(name = "cycle_id",nullable = false)
    @Basic(optional = false)
    private Long cycleId;

    @Column(name = "pat_id", nullable = false)
    @Basic(optional = false)
    private Long patId;

    @Column(name = "doc_id")
    private Long docId;

    @Column(name = "dept_id")
    private Long deptId;

    @Column(name = "date")
    private String date;

    @Column(name = "time")
    private String time;

    @Column(name = "uid")
    @Basic(optional = false)
    private Long uid;

    @Column(name = "is_doc_prescription")
    private Long isDocPrescription;

    @Column(name = "is_valid")
    private Long isValid;

    @Column(name = "is_first_dosage_seted")
    private Long isFirstDosageSeted;

    @Column(name = "ip_id")
    private Long ipId;

    @Column(name = "is_order_prepared")
    private Long isOrderPrepared;

    @Column(name = "is_opd_order")
    private Long isOpdOrder;

    @Column(name = "advice")
    private Long advice;

    @Column(name = "visit_id")
    private Long visitId;

    @Column(name = "isIssued")
    private Long isIssued;

    @Column(name = "is_billed")
    private Long isBilled;

    @Column(name = "final_bill_id")
    private Long finalBillId;

    @Column(name = "notes", columnDefinition = "TEXT")
    private String notes;

    @Column(name = "isFromSummary")
    private Integer isFromSummary;

    @OneToMany(mappedBy = "prescriptionId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PrescriptionDetails> phDescriptionDetailsList = new ArrayList<>();

    public static Prescription to(final CreatePrescriptionRequest prescriptionRequest, final Long doctorId){
        Prescription prescription = new Prescription();
        prescription.setDisplay(String.valueOf(prescriptionRequest.getDisplay()));
        prescription.setCycleId(prescriptionRequest.getCycle_id());
        prescription.setPatId(prescriptionRequest.getPat_id());
        prescription.setDocId(doctorId);
        prescription.setDeptId(prescriptionRequest.getDept_id());
        prescription.setDate(DateTimeUtils.convertLocalDateToDateFormat(LocalDate.now()));
        prescription.setTime(DateTimeUtils.convertLocalDateToTimeFormat(LocalTime.now()));
        prescription.setUid(prescriptionRequest.getUid());
        prescription.setIsDocPrescription(prescriptionRequest.getIs_doc_prescription());
        prescription.setIsValid(prescriptionRequest.getIs_valid());
        prescription.setIsFirstDosageSeted(prescriptionRequest.getIs_first_dosage_seted());
        prescription.setIpId(prescriptionRequest.getIp_id());
        prescription.setIsOrderPrepared(prescriptionRequest.getIs_order_prepared());
        prescription.setIsOpdOrder(prescriptionRequest.getIs_opd_order());
        prescription.setAdvice(prescriptionRequest.getAdvice());
        prescription.setVisitId(prescriptionRequest.getVisit_id());
        prescription.setIsIssued(prescriptionRequest.getIsIssued());
        prescription.setIsBilled(prescriptionRequest.getIs_billed());
        prescription.setFinalBillId(prescriptionRequest.getFinal_bill_id());
        prescription.setNotes(prescriptionRequest.getNotes());
        prescription.setIsFromSummary(prescriptionRequest.getIsFromSummary());
        return prescription;
    }


    public void update(final UpdatePrescriptionRequest prescriptionRequest, final Long doctorId){
        this.cycleId = prescriptionRequest.getCycle_id();
        this.patId = prescriptionRequest.getPat_id();
        this.docId = doctorId;
        this.deptId = prescriptionRequest.getDept_id();
        this.date = prescriptionRequest.getDate();
        this.time = prescriptionRequest.getTime();
        this.uid = prescriptionRequest.getUid();
        this.isDocPrescription = prescriptionRequest.getIs_doc_prescription();
        this.isValid = prescriptionRequest.getIs_valid();
        this.isFirstDosageSeted = prescriptionRequest.getIs_first_dosage_seted();
        this.ipId = prescriptionRequest.getIp_id();
        this.isOrderPrepared = prescriptionRequest.getIs_order_prepared();
        this.isOpdOrder = prescriptionRequest.getIs_opd_order();
        this.advice = prescriptionRequest.getAdvice();
        this.visitId = prescriptionRequest.getVisit_id();
        this.isIssued = prescriptionRequest.getIsIssued();
        this.isBilled = prescriptionRequest.getIs_billed();
        this.finalBillId = prescriptionRequest.getFinal_bill_id();
        this.notes = prescriptionRequest.getNotes();
        this.isFromSummary = prescriptionRequest.getIsFromSummary();

    }


}
