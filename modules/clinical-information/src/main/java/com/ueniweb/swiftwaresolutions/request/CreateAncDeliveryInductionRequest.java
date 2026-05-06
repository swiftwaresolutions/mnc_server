package com.ueniweb.swiftwaresolutions.request;

import lombok.Data;

@Data
public class CreateAncDeliveryInductionRequest {

    private Long id;

    private Long anc_Delivery_id;

    private String indDate;

    private String indName;

    private Long indNumber;

    private String indTime;

    private Long isValid;


    @Override
    public String toString() {
        return "CreateAncDeliveryInductionRequest{" +
                "id=" + id +
                ", anc_Delivery_id=" + anc_Delivery_id +
                ", indDate=" + indDate +
                ", indName='" + indName + '\'' +
                ", indNumber='" + indNumber + '\'' +
                ", indTime='" + indTime + '\'' +
                ", isValid='" + isValid + '\'' +
                '}';
    }
}
