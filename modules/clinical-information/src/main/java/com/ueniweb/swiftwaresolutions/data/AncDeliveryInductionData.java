package com.ueniweb.swiftwaresolutions.data;

import lombok.Data;

@Data

public class AncDeliveryInductionData {

    private Long id;

    private Long anc_Delivery_id;

    private String indDate;

    private String indName;

    private Long indNumber;

    private String indTime;

    private Long isValid;

    public AncDeliveryInductionData( final Long id,final Long anc_Delivery_id,final String indDate,final String indName,final Long indNumber,final String indTime,final Long isValid){

        this.id=id;

        this.anc_Delivery_id=anc_Delivery_id;

        this.indDate=indDate;

        this.indName=indName;

        this.indNumber=indNumber;

        this.indTime=indTime;

        this.isValid=isValid;

        }
    public static AncDeliveryInductionData createNewInstance(final Long id,final Long anc_Delivery_id,final String indDate,final String indName,final Long indNumber,final String indTime,final Long isValid){
        return new AncDeliveryInductionData( id, anc_Delivery_id, indDate, indName, indNumber, indTime,isValid);
    }
}
