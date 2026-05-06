package com.ueniweb.swiftwaresolutions.request;

import lombok.Data;

@Data
public class AppointmentRequest {

    private Long id;
    private Long patId;
    private Long vstId;
    private Long caseShetType;
    private Long consultantId;
    private String appointmentDate;
    private String appointmentPlan;

}
