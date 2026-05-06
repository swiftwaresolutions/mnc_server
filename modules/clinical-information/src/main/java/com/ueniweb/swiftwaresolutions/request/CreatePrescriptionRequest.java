package com.ueniweb.swiftwaresolutions.request;

import lombok.Data;

import java.util.List;

@Data
public class CreatePrescriptionRequest  {

    private Long display;

    private Long cycle_id;

    private Long pat_id;

    private Long doc_id;

    private Long dept_id;

    private String date;

    private String time;

    private Long uid;

    private Long is_doc_prescription;

    private Long is_valid;

    private Long is_first_dosage_seted;

    private Long ip_id;

    private Long is_order_prepared;

    private Long is_opd_order;

    private Long advice;

    private Long visit_id;

    private Long isIssued;

    private Long is_billed;

    private Long final_bill_id;

    private String notes;

    private Integer isFromSummary;

    private Double discAmt;

    private List<CreatePrescriptionDetailsRequest> createPrescriptionDetailsRequestList;

    @Override
    public String toString() {
        return "CreatePrescriptionRequest{" +
                "display=" + display +
                ", cycle_id=" + cycle_id +
                ", pat_id=" + pat_id +
                ", doc_id=" + doc_id +
                ", dept_id=" + dept_id +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", uid=" + uid +
                ", is_doc_prescription=" + is_doc_prescription +
                ", is_valid=" + is_valid +
                ", is_first_dosage_seted=" + is_first_dosage_seted +
                ", ip_id=" + ip_id +
                ", is_order_prepared=" + is_order_prepared +
                ", is_opd_order=" + is_opd_order +
                ", advice=" + advice +
                ", visit_id=" + visit_id +
                ", isIssued=" + isIssued +
                ", is_billed=" + is_billed +
                ", final_bill_id=" + final_bill_id +
                ", notes='" + notes + '\'' +
                ", isFromSummary='" + isFromSummary +
                ", discAmt='" + discAmt +
                '}';
    }


}
