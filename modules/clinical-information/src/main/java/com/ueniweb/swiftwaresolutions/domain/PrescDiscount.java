package com.ueniweb.swiftwaresolutions.domain;

import com.ueniweb.swiftwaresolutions.request.CreateOPVitalsRequest;
import com.ueniweb.swiftwaresolutions.request.CreatePrescriptionRequest;
import com.ueniweb.swiftwaresolutions.request.UpdatePrescriptionRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name="PrescDiscount")
@Table(name = "ph_prescription_disc")
@Getter
@Setter
public class PrescDiscount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "prescriptionId ",nullable = false)
    @Basic(optional = false)
    private Long presciptionId;

    @Column(name = "patId",nullable = false)
    @Basic(optional = false)
    private Long patId;

    @Column(name = "visitId",nullable = false)
    @Basic(optional = false)
    private Long visitId;

    @Column(name = "discAmt",nullable = false)
    @Basic(optional = false)
    private Double discAmt;

    @Column(name = "finalBillId",nullable = false)
    @Basic(optional = false)
    private Long finalBillId;

    public static PrescDiscount to(Long prescription , final CreatePrescriptionRequest createPrescriptionRequest){
        PrescDiscount prescDiscount = new PrescDiscount();

        prescDiscount.setPresciptionId(prescription);
        prescDiscount.setPatId(createPrescriptionRequest.getPat_id());
        prescDiscount.setVisitId(createPrescriptionRequest.getVisit_id());
        prescDiscount.setDiscAmt(createPrescriptionRequest.getDiscAmt());
        prescDiscount.setFinalBillId(createPrescriptionRequest.getFinal_bill_id());

        return prescDiscount;
    }
    public void update(final UpdatePrescriptionRequest updatePrescriptionRequest) {
        this.setDiscAmt(updatePrescriptionRequest.getDiscAmt());
    }

}
