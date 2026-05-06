package com.ueniweb.swiftwaresolutions.data;

import lombok.Data;

@Data
public class AppointmentRegisterData {

    private String name;
    private String displayNumber;
    private Long caseSheetType;
    private String appointmentPlan;
    private String consultantName;
    private Long visitStatus;

    public AppointmentRegisterData(String name, String displayNumber, Long caseSheetType, String appointmentPlan, String consultantName, Long visitStatus) {
        this.name = name;
        this.displayNumber = displayNumber;
        this.caseSheetType = caseSheetType;
        this.appointmentPlan = appointmentPlan;
        this.consultantName = consultantName;
        this.visitStatus = visitStatus;
    }

    public static AppointmentRegisterData newInstance(String name, String displayNumber, Long caseSheetType, String appointmentPlan, String consultantName, Long visitStatus) {
        return new AppointmentRegisterData(name, displayNumber, caseSheetType, appointmentPlan, consultantName, visitStatus);
    }
}
