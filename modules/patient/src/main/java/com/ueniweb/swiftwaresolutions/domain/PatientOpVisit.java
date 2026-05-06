package com.ueniweb.swiftwaresolutions.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Time;
import java.time.Year;
import java.util.Date;

@Entity(name = "PatientOpVisit")
@Table(name = "rec_patient_opvisits")
@Data
public class PatientOpVisit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pat_id", nullable = false)
    @Basic(optional = false)
    private Long patientId;

    @Column(name = "token_no_dept")
    private Integer tokenNoDept;

    @Column(name = "token_no_doctor")
    private Integer tokenNoDoctor;

    @Column(name = "master_reference_no")
    private Integer masterReferenceNo;

    @Column(name = "is_appointed_pat")
    private int isAppointedPat;

    @Column(name = "is_referal_case")
    private int isReferalCase;

    @Column(name = "refered_by_user")
    private int referedByUser;

    @Column(name = "service_id")
    private Long serviceId;

    @Column(name = "is_service_noted")
    private Integer isServiceNoted;

    @Column(name = "service_noted_from")
    private Integer serviceNotedFrom;

    @Column(name = "doctor_id")
    private Long doctorId;

    @Column(name = "is_doctor_chosen")
    private Integer isDoctorChosen;

    @Column(name = "doctor_noted_from")
    private Integer doctorNotedFrom;

    @Column(name = "year")
    private Year year;

    @Column(name = "month")
    private int month;

    @Column(name = "day")
    private int day;

    @Column(name = "day_week")
    private String dayWeek;

    @Column(name = "day_year")
    private String dayYear;

    @Column(name = "day_month")
    private String dayMonth;

    @Column(name = "week_year")
    private String weekYear;

    @Column(name = "week_month")
    private String weekMonth;

    @Column(name = "date")
    private Date date;

    @Column(name = "time")
    private Time time;

    @Column(name = "datetime")
    private String dateTime;

}
