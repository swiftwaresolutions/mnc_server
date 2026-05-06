package com.ueniweb.swiftwaresolutions.domain;

import com.ueniweb.swiftwaresolutions.request.CreateIpProcedureCaseSheetRequest;
import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "IpProcedureCaseSheet")
@Table(name = "cli_ipProcedure_casesheet")
@Data
public class IpProcedureCaseSheet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "patId", nullable = false)
    @Basic(optional = false)
    private Long patientId;

    @Column(name = "vstId", nullable = false)
    @Basic(optional = false)
    private Long visitId;

    @Column(name = "ipId", nullable = false)
    @Basic(optional = false)
    private Long ipId;

    @Column(name = "consultantId", nullable = false)
    @Basic(optional = false)
    private Long consultantId;

    @Column(name = "date")
    private String date;

    @Column(name = "time")
    private String time;

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

    @Column(name = "progressNotes", columnDefinition = "TEXT")
    private String progressNotes;

    @Column(name = "progressPlan", columnDefinition = "TEXT")
    private String progressPlan;

    @Column(name = "isCancelled")
    private Long isCancelled;

    public static IpProcedureCaseSheet to(CreateIpProcedureCaseSheetRequest createIpProcedureCaseSheetRequest){
        IpProcedureCaseSheet ipProcedureCaseSheet =new IpProcedureCaseSheet();

        ipProcedureCaseSheet.setPatientId(createIpProcedureCaseSheetRequest.getPatientId());
        ipProcedureCaseSheet.setVisitId(createIpProcedureCaseSheetRequest.getVisitId());
        ipProcedureCaseSheet.setIpId(createIpProcedureCaseSheetRequest.getIpId());
        ipProcedureCaseSheet.setConsultantId(createIpProcedureCaseSheetRequest.getConsultantId());
        ipProcedureCaseSheet.setDate(createIpProcedureCaseSheetRequest.getDate());
        ipProcedureCaseSheet.setTime(createIpProcedureCaseSheetRequest.getTime());
        ipProcedureCaseSheet.setTemperature(createIpProcedureCaseSheetRequest.getTemperature());
        ipProcedureCaseSheet.setPulse(createIpProcedureCaseSheetRequest.getPulse());
        ipProcedureCaseSheet.setRr(createIpProcedureCaseSheetRequest.getRr());
        ipProcedureCaseSheet.setBp(createIpProcedureCaseSheetRequest.getBp());
        ipProcedureCaseSheet.setSpo2(createIpProcedureCaseSheetRequest.getSpo2());
        ipProcedureCaseSheet.setHeight(createIpProcedureCaseSheetRequest.getHeight());
        ipProcedureCaseSheet.setWeight(createIpProcedureCaseSheetRequest.getWeight());
        ipProcedureCaseSheet.setBmi(createIpProcedureCaseSheetRequest.getBmi());
        ipProcedureCaseSheet.setProgressNotes(createIpProcedureCaseSheetRequest.getProgressNotes());
        ipProcedureCaseSheet.setProgressPlan(createIpProcedureCaseSheetRequest.getProgressPlan());
        ipProcedureCaseSheet.setIsCancelled(createIpProcedureCaseSheetRequest.getIsCancelled());
        return ipProcedureCaseSheet;
    }

    public void update(final CreateIpProcedureCaseSheetRequest createIpProcedureCaseSheetRequest){
        this.patientId     = createIpProcedureCaseSheetRequest.getPatientId();
        this.visitId       = createIpProcedureCaseSheetRequest.getVisitId();
        this.ipId          = createIpProcedureCaseSheetRequest.getIpId();
        this.consultantId  = createIpProcedureCaseSheetRequest.getConsultantId();
        this.date          = createIpProcedureCaseSheetRequest.getDate();
        this.time          = createIpProcedureCaseSheetRequest.getTime();
        this.temperature   = createIpProcedureCaseSheetRequest.getTemperature();
        this.pulse         = createIpProcedureCaseSheetRequest.getPulse();
        this.rr            = createIpProcedureCaseSheetRequest.getRr();
        this.bp            = createIpProcedureCaseSheetRequest.getBp();
        this.spo2          = createIpProcedureCaseSheetRequest.getSpo2();
        this.height        = createIpProcedureCaseSheetRequest.getHeight();
        this.weight        = createIpProcedureCaseSheetRequest.getWeight();
        this.bmi           = createIpProcedureCaseSheetRequest.getBmi();
        this.progressNotes = createIpProcedureCaseSheetRequest.getProgressNotes();
        this.progressPlan  = createIpProcedureCaseSheetRequest.getProgressPlan();
        this.isCancelled   = createIpProcedureCaseSheetRequest.getIsCancelled();
    }

}
