package com.ueniweb.swiftwaresolutions.domain;


import com.ueniweb.swiftwaresolutions.request.CreateNursingIoReuest;

import com.ueniweb.swiftwaresolutions.request.CreateOPVitalsRequest;
import com.ueniweb.swiftwaresolutions.utils.DateTimeUtils;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity(name="NursingIoSheet")
@Table(name = "cli_nursing_io")
@Data
public class NursingIoSheet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "patId", nullable = false)
    @Basic(optional = false)
    private Long patId;

    @Column(name = "visitId", nullable = false)
    @Basic(optional = false)
    private Long visitId;

    @Column(name = "ipId",nullable = false)
    @Basic(optional = false)
    private Long ipId;

    @Column(name = "drain")
    @Basic(optional = false)
    private String drain;

    @Column(name = "drainDetails")
    @Basic(optional = false)
    private String drainDetails;

    @Column(name = "inOther")
    @Basic(optional = false)
    private String inOther;

    @Column(name = "inOtherDetails")
    @Basic(optional = false)
    private String inOtherDetails;

    @Column(name = "ivf")
    @Basic(optional = false)
    private String ivf;

    @Column(name = "ivfDetails")
    @Basic(optional = false)
    private String ivfDetails;

    @Column(name = "nurseDtmIo")
    @Basic(optional = false)
    private String nurseDtmIo;

    @Column(name = "oral")
    @Basic(optional = false)
    private String oral;

    @Column(name = "oralDetails")
    @Basic(optional = false)
    private String oralDetails;

    @Column(name = "outOther")
    @Basic(optional = false)
    private String outOther;

    @Column(name = "outOtherDetails")
    @Basic(optional = false)
    private String outOtherDetails;

    @Column(name = "urine")
    @Basic(optional = false)
    private String urine;

    @Column(name = "urineDetails")
    @Basic(optional = false)
    private String urineDetails;

    @Column(name = "inTotal")
    @Basic(optional = false)
    private Long inTotal;

    @Column(name = "outTotal")
    @Basic(optional = false)
    private Long outTotal;

    @Column(name = "curDtm")
    @Basic(optional = false)
    private String curDtm;

    public static NursingIoSheet to(final CreateNursingIoReuest createNursingIoReuest){

        NursingIoSheet nursingIo = new NursingIoSheet();
        nursingIo.setPatId(createNursingIoReuest.getPatId());
        nursingIo.setVisitId(createNursingIoReuest.getVisitId());
        nursingIo.setIpId(createNursingIoReuest.getIpId());
        nursingIo.setDrain(createNursingIoReuest.getDrain());
        nursingIo.setDrainDetails(createNursingIoReuest.getDrainDetails());
        nursingIo.setInOther(createNursingIoReuest.getInOther());
        nursingIo.setInOtherDetails(createNursingIoReuest.getInOtherDetails());
        nursingIo.setOutOther(createNursingIoReuest.getOutOther());
        nursingIo.setOutOtherDetails(createNursingIoReuest.getOutOtherDetails());
        nursingIo.setIvf(createNursingIoReuest.getIvf());
        nursingIo.setIvfDetails(createNursingIoReuest.getIvfDetails());
        nursingIo.setNurseDtmIo(createNursingIoReuest.getNurseDtmIo());
        nursingIo.setOral(createNursingIoReuest.getOral());
        nursingIo.setOralDetails(createNursingIoReuest.getOralDetails());
        nursingIo.setUrine(createNursingIoReuest.getUrine());
        nursingIo.setUrineDetails(createNursingIoReuest.getUrineDetails());
        nursingIo.setInTotal(createNursingIoReuest.getInTotal());
        nursingIo.setOutTotal(createNursingIoReuest.getOutTotal());
        nursingIo.setCurDtm(DateTimeUtils.convertLocalDateToDateTimeFormat(LocalDateTime.now()));

        return nursingIo;
    }
    public void update(final CreateNursingIoReuest createNursingIoReuest){

        this.setPatId(createNursingIoReuest.getPatId());
        this.setVisitId(createNursingIoReuest.getVisitId());
        this.setIpId(createNursingIoReuest.getIpId());
        this.setDrain(createNursingIoReuest.getDrain());
        this.setDrainDetails(createNursingIoReuest.getDrainDetails());
        this.setInOther(createNursingIoReuest.getInOther());
        this.setInOtherDetails(createNursingIoReuest.getInOtherDetails());
        this.setOutOther(createNursingIoReuest.getOutOther());
        this.setOutOtherDetails(createNursingIoReuest.getOutOtherDetails());
        this.setIvf(createNursingIoReuest.getIvf());
        this.setIvfDetails(createNursingIoReuest.getIvfDetails());
        this.setNurseDtmIo(createNursingIoReuest.getNurseDtmIo());
        this.setOral(createNursingIoReuest.getOral());
        this.setOralDetails(createNursingIoReuest.getOralDetails());
        this.setUrine(createNursingIoReuest.getUrine());
        this.setUrineDetails(createNursingIoReuest.getUrineDetails());
        this.setInTotal(createNursingIoReuest.getInTotal());
        this.setOutTotal(createNursingIoReuest.getOutTotal());
        this.setCurDtm(DateTimeUtils.convertLocalDateToDateTimeFormat(LocalDateTime.now()));


    }
}
