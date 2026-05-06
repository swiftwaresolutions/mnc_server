package com.ueniweb.swiftwaresolutions.domain;

import com.ueniweb.swiftwaresolutions.request.CreateOPVitalsRequest;
import com.ueniweb.swiftwaresolutions.utils.DateTimeUtils;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity(name="OpVitals")
@Table(name = "cli_patient_vital_details")
@Data
public class Opvitals {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "patId",nullable = false)
    @Basic(optional = false)
    private Long patId;

    @Column(name = "vstId",nullable = false)
    @Basic(optional = false)
    private Long vstId;

    @Column(name = "temperature")
    private String temperature;

    @Column(name = "pulse")
    private String pulse;

    @Column(name = "rr")
    private String rr;

    @Column(name = "bp")
    private String bp;

    @Column(name = "spo2")
    private String spo2;

    @Column(name = "height")
    private String height;

    @Column(name = "weight")
    private String weight;

    @Column(name = "bmi")
    private String bmi;

    @Column(name = "dateTime")
    private String datetime;

    @Column(name = "grbs")
    private String grbs;

    public static Opvitals to(final CreateOPVitalsRequest createOPVitalsRequest){
        Opvitals opvitals = new Opvitals();
        opvitals.setPatId(createOPVitalsRequest.getPatId());
        opvitals.setVstId(createOPVitalsRequest.getVstId());
        opvitals.setTemperature(createOPVitalsRequest.getTemperature());
        opvitals.setPulse(createOPVitalsRequest.getPulse());
        opvitals.setRr(createOPVitalsRequest.getRr());
        opvitals.setBp(createOPVitalsRequest.getBp());
        opvitals.setSpo2(createOPVitalsRequest.getSpo2());
        opvitals.setHeight(createOPVitalsRequest.getHeight());
        opvitals.setWeight(createOPVitalsRequest.getWeight());
        opvitals.setBmi(createOPVitalsRequest.getBmi());
        opvitals.setDatetime(DateTimeUtils.convertLocalDateToDateTimeFormat(LocalDateTime.now()));
        opvitals.setGrbs(createOPVitalsRequest.getGrbs());

        return opvitals;
    }


    public void update(final CreateOPVitalsRequest createOPVitalsRequest){

        this.setPatId(createOPVitalsRequest.getPatId());
        this.setVstId(createOPVitalsRequest.getVstId());
        this.setTemperature(createOPVitalsRequest.getTemperature());
        this.setPulse(createOPVitalsRequest.getPulse());
        this.setRr(createOPVitalsRequest.getRr());
        this.setBp(createOPVitalsRequest.getBp());
        this.setSpo2(createOPVitalsRequest.getSpo2());
        this.setHeight(createOPVitalsRequest.getHeight());
        this.setWeight(createOPVitalsRequest.getWeight());
        this.setBmi(createOPVitalsRequest.getBmi());
        this.setDatetime(DateTimeUtils.convertLocalDateToDateTimeFormat(LocalDateTime.now()));
        this.setGrbs(createOPVitalsRequest.getGrbs());

    }
}
