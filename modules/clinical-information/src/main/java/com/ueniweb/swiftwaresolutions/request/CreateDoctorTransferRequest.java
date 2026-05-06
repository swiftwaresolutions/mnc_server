package com.ueniweb.swiftwaresolutions.request;

import lombok.Data;

import java.util.List;

@Data
public class CreateDoctorTransferRequest {


    private Long toDoc;

    // existing investigation order request
    private List<CreateInvestigationOrderRequest> investigationOrders;
}
