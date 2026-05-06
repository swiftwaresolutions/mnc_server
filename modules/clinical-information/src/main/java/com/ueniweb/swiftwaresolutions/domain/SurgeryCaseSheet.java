package com.ueniweb.swiftwaresolutions.domain;


import com.ueniweb.swiftwaresolutions.data.SurgeryData;
import com.ueniweb.swiftwaresolutions.request.CreateAntenatalCaseSheetRequest;
import com.ueniweb.swiftwaresolutions.request.CreateSurgeryCaseSheetRequest;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
@Entity(name = "SurgeryCaseSheet")
@Table(name = "cli_ot_surgery")

public class SurgeryCaseSheet {

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

    @Column(name = "entDate")
    @Basic(optional = false)
    private String entDate;

    @Column(name = "entTime")
    @Basic(optional = false)
    private String entTime;

    @Column(name = "surgeryDate")
    @Basic(optional = false)
    private String surgeryDate;

    @Column(name = "surgeryTime")
    @Basic(optional = false)
    private String surgeryTime;

    @Column(name = "durSurgery")
    @Basic(optional = false)
    private String durSurgery;

    @Column(name = "preOtDiagnosis")
    @Basic(optional = false)
    private String preOtDiagnosis;

    @Column(name = "postOtDiagnosis")
    @Basic(optional = false)
    private String postOtDiagnosis;

    @Column(name = "DetSurgery")
    @Basic(optional = false)
    private String DetSurgery;

    @Column(name = "ProcedureNotes")
    @Basic(optional = false)
    private String ProcedureNotes;

    @Column(name = "ProgressNotes")
    @Basic(optional = false)
    private String ProgressNotes;

    @Column(name = "AnestDoc")
    @Basic(optional = false)
    private String AnestDoc;


    @OneToMany(mappedBy = "surId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<SurgerySurgon> surgerySurgonList = new ArrayList<>();

    @OneToMany(mappedBy = "surId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<SurgeryNurse> surgeryNurseList = new ArrayList<>();

    @OneToMany(mappedBy = "surId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<SurgeryName> surgeryDataList = new ArrayList<>();


    public static SurgeryCaseSheet to(final CreateSurgeryCaseSheetRequest createSurgeryCaseSheetRequest){
        SurgeryCaseSheet surgeryCaseSheet = new SurgeryCaseSheet();
        surgeryCaseSheet.setPatId(createSurgeryCaseSheetRequest.getPatId());
        surgeryCaseSheet.setVisitId(createSurgeryCaseSheetRequest.getVisitId());
        surgeryCaseSheet.setIpId(createSurgeryCaseSheetRequest.getIpId());
        surgeryCaseSheet.setEntDate(createSurgeryCaseSheetRequest.getEntDate());
        surgeryCaseSheet.setEntTime(createSurgeryCaseSheetRequest.getEntTime());
        surgeryCaseSheet.setSurgeryDate(createSurgeryCaseSheetRequest.getSurgeryDate());
        surgeryCaseSheet.setSurgeryTime(createSurgeryCaseSheetRequest.getSurgeryTime());
        surgeryCaseSheet.setDurSurgery(createSurgeryCaseSheetRequest.getDurSurgery());
        surgeryCaseSheet.setPreOtDiagnosis(createSurgeryCaseSheetRequest.getPreOtDiagnosis());
        surgeryCaseSheet.setPostOtDiagnosis(createSurgeryCaseSheetRequest.getPostOtDiagnosis());
        surgeryCaseSheet.setDetSurgery(createSurgeryCaseSheetRequest.getDetSurgery());
        surgeryCaseSheet.setProcedureNotes(createSurgeryCaseSheetRequest.getProcedureNotes());
        surgeryCaseSheet.setProgressNotes(createSurgeryCaseSheetRequest.getProgressNotes());
        surgeryCaseSheet.setAnestDoc(createSurgeryCaseSheetRequest.getAnestDoc());

        return surgeryCaseSheet;
    }
    public void update(final CreateSurgeryCaseSheetRequest createSurgeryCaseSheetRequest){


        this.setPatId(createSurgeryCaseSheetRequest.getPatId());
        this.setVisitId(createSurgeryCaseSheetRequest.getVisitId());
        this.setIpId(createSurgeryCaseSheetRequest.getIpId());
        this.setIpId(createSurgeryCaseSheetRequest.getIpId());
        this.setEntDate(createSurgeryCaseSheetRequest.getEntDate());
        this.setEntTime(createSurgeryCaseSheetRequest.getEntTime());
        this.setSurgeryDate(createSurgeryCaseSheetRequest.getSurgeryDate());
        this.setSurgeryTime(createSurgeryCaseSheetRequest.getSurgeryTime());
        this.setDurSurgery(createSurgeryCaseSheetRequest.getDurSurgery());
        this.setPreOtDiagnosis(createSurgeryCaseSheetRequest.getPreOtDiagnosis());
        this.setPostOtDiagnosis(createSurgeryCaseSheetRequest.getPostOtDiagnosis());
        this.setDetSurgery(createSurgeryCaseSheetRequest.getDetSurgery());
        this.setProcedureNotes(createSurgeryCaseSheetRequest.getProcedureNotes());
        this.setProgressNotes(createSurgeryCaseSheetRequest.getProgressNotes());
        this.setAnestDoc(createSurgeryCaseSheetRequest.getAnestDoc());

    }
}
