package com.ueniweb.swiftwaresolutions.data;

import lombok.Data;

@Data
public class AppointmentData {

    private Long id;
    private String appointmentDate;
    private String appointmentPlan;

    public AppointmentData(Long id, String appointmentDate, String appointmentPlan) {
        this.id = id;
        this.appointmentDate = appointmentDate;
        this.appointmentPlan = appointmentPlan;
    }

    public static AppointmentData NewInstance(final Long id, final String appointmentDate, final String appointmentPlan) {
        return new AppointmentData(id,appointmentDate,appointmentPlan);
    }
}
