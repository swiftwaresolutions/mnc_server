package com.ueniweb.swiftwaresolutions.request;

import lombok.Data;

@Data
public class CreateInvestigationOrderRequest {

    private Long billId;

    private Long groupId;

    private Long particularId;

    private Double unit;

    private Double rate;

    private Long disc;

    private Long docId;

    private Double returnUnit;

    private Long fcRate;

    private Long patId;

    private Long vstId;

    private Long uid;

    private String dateTime;

    private Long finalBillId;


}
