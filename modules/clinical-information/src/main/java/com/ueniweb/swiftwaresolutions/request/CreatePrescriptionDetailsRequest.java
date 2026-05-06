package com.ueniweb.swiftwaresolutions.request;

import lombok.Data;

@Data
public class CreatePrescriptionDetailsRequest {

    private Long prescription_id;

    private Long generic_id;

    private Long prods_id;

    private Double quantity;

    private Long unit;

    private Double qno;

    private Long timing;

    private Double duration;

    private Long period;

    private Long route;

    private Long instruction;

    private String date;

    private Long is_order_prepared;

    private Long order_id;

    private Long is_paid;

    private Long is_own;

    private Long is_cancelled;

    private Long batchId;

    private String notes;

    private String timingUnits;

    @Override
    public String toString() {
        return "PrescriptionDetailsRequest{" +
                "prescription_id=" + prescription_id +
                ", generic_id=" + generic_id +
                ", prods_id=" + prods_id +
                ", quantity=" + quantity +
                ", unit=" + unit +
                ", qno=" + qno +
                ", timing=" + timing +
                ", duration=" + duration +
                ", period=" + period +
                ", route=" + route +
                ", instruction=" + instruction +
                ", date='" + date + '\'' +
                ", is_order_prepared=" + is_order_prepared +
                ", order_id=" + order_id +
                ", is_paid=" + is_paid +
                ", is_own=" + is_own +
                ", is_cancelled=" + is_cancelled +
                ", batchId=" + batchId +
                ", notes='" + notes + '\'' +
                ", timingUnits='" + timingUnits + '\'' +
                '}';
    }




}
