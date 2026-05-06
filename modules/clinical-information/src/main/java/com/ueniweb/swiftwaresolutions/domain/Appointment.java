package com.ueniweb.swiftwaresolutions.domain;

import com.ueniweb.swiftwaresolutions.request.AppointmentRequest;
import com.ueniweb.swiftwaresolutions.utils.DateTimeUtils;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity(name = "Appointment")
@Table(name = "cli_patient_appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "patId", nullable = false)
    @Basic(optional = false)
    private Long patId;

    @Column(name = "vstId", nullable = false)
    @Basic(optional = false)
    private Long vstId;

    @Column(name = "caseSheetType", nullable = false)
    @Basic(optional = false)
    private Long caseSheeType;

    @Column(name = "consultantId", nullable = false)
    @Basic(optional = false)
    private Long consultantId;

    @Column(name = "appDate")
    private String appointmentDate;

    @Column(name = "appPlan")
    private String appointmentPlan;

    @Column(name = "dateTime")
    private String dateTime;

    @Column(name = "isValid")
    private Long isValid;

    public static Appointment to(final AppointmentRequest appointmentRequest) {
        Appointment appointment = new Appointment();

        appointment.setPatId(appointmentRequest.getPatId());
        appointment.setVstId(appointmentRequest.getVstId());
        appointment.setCaseSheeType(appointmentRequest.getCaseShetType());
        appointment.setConsultantId(appointmentRequest.getConsultantId());
        appointment.setAppointmentDate(appointmentRequest.getAppointmentDate());
        appointment.setAppointmentPlan(appointmentRequest.getAppointmentPlan());
        appointment.setDateTime(DateTimeUtils.convertLocalDateToDateTimeFormat(LocalDateTime.now()));
        appointment.setIsValid(1L);

        return appointment;
    }

    public void update(final AppointmentRequest appointmentRequest) {

        this.setConsultantId(appointmentRequest.getConsultantId());
        this.setAppointmentDate(appointmentRequest.getAppointmentDate());
        this.setAppointmentPlan(appointmentRequest.getAppointmentPlan());
        this.setDateTime(DateTimeUtils.convertLocalDateToDateTimeFormat(LocalDateTime.now()));
        this.setIsValid(1L);
    }

}
