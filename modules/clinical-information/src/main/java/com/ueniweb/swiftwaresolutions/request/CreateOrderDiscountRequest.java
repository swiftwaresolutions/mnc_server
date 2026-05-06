package com.ueniweb.swiftwaresolutions.request;


import lombok.Data;

@Data
public class CreateOrderDiscountRequest {

    private Long patId;

    private Long uid;

    private String datetime;

    private Double discAmt;

    private Long finalBillId;

    @Override
    public String toString() {
        return "CreateOrderDiscountRequest{" +
                "patId=" + patId +
                ", uid=" + uid +
                ", datetime='" + datetime + '\'' +
                ", discAmt=" + discAmt +
                ", finalBillId=" + finalBillId +
                '}';
    }


}
