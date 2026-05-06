package com.ueniweb.swiftwaresolutions.domain;

import com.ueniweb.swiftwaresolutions.request.CreateOpthamologyCaseSheetRequest;
import com.ueniweb.swiftwaresolutions.utils.DateTimeUtils;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "OpthamologyCaseSheet")
@Table(name = "cli_patient_opthamology_casesheet")
@Data
public class OpthamologyCaseSheet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "patId", nullable = false)
    @Basic(optional = false)
    private Long patientId;

    @Column(name = "vstId", nullable = false)
    @Basic(optional = false)
    private Long visitId;

    @Column(name = "ipId")
    @Basic(optional = false)
    private Long ipId;

    @Column(name = "consultantId", nullable = false)
    @Basic(optional = false)
    private Long consultantId;

    @Column(name = "dateTime")
    private String dateTime;

    @Column(name = "presentIllness", columnDefinition = "TEXT")
    private String presentIllness;

    @Column(name = "pastHistory", columnDefinition = "TEXT")
    private String pastHistory;

    @Column(name = "allergy", columnDefinition = "TEXT")
    private String allergy;

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

    @Column(name = "examination", columnDefinition = "TEXT")
    private String examination;

    @Column(name = "diagnosis", columnDefinition = "TEXT")
    private String diagnosis;

    @Column(name = "discussion", columnDefinition = "TEXT")
    private String discussion;

    @Column(name = "recomendations", columnDefinition = "TEXT")
    private String recomendations;

    @Column(name = "treatmentPlan", columnDefinition = "TEXT")
    private String treatmentPlan;

    @Column(name = "treatmentGiven", columnDefinition = "TEXT")
    private String treatmentGiven;

    @Column(name = "extra1", columnDefinition = "TEXT")
    private String extra1;

    @Column(name = "extra2", columnDefinition = "TEXT")
    private String extra2;

    @Column(name = "extra3", columnDefinition = "TEXT")
    private String extra3;

    @Column(name = "extra4", columnDefinition = "TEXT")
    private String extra4;

    @Column(name = "extra5", columnDefinition = "TEXT")
    private String extra5;

    @Column(name = "isCancelled")
    private Long isCancelled;

    @OneToMany(mappedBy = "caseSheetId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OpthamologyComplaintDetails> opthamologyComplaintDetailsList = new ArrayList<>();

    @OneToMany(mappedBy = "caseSheetId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OpthamologyDiagnosisDetails> opthamologyDiagnosisDetailsList = new ArrayList<>();

    public static OpthamologyCaseSheet to(final CreateOpthamologyCaseSheetRequest createOpthamologyCaseSheetRequest ){
        OpthamologyCaseSheet opthamologyCaseSheet = new OpthamologyCaseSheet();

        opthamologyCaseSheet.setPatientId(createOpthamologyCaseSheetRequest.getPatientId());
        opthamologyCaseSheet.setVisitId(createOpthamologyCaseSheetRequest.getVisitId());
        opthamologyCaseSheet.setIpId(createOpthamologyCaseSheetRequest.getIpId());
        opthamologyCaseSheet.setConsultantId(createOpthamologyCaseSheetRequest.getConsultantId());
        opthamologyCaseSheet.setDateTime(DateTimeUtils.convertLocalDateToDateTimeFormat(LocalDateTime.now()));
        opthamologyCaseSheet.setPresentIllness(createOpthamologyCaseSheetRequest.getPresentIllness());
        opthamologyCaseSheet.setPastHistory(createOpthamologyCaseSheetRequest.getPastHistory());
        opthamologyCaseSheet.setAllergy(createOpthamologyCaseSheetRequest.getAllergy());
        opthamologyCaseSheet.setTemperature(createOpthamologyCaseSheetRequest.getTemperature());
        opthamologyCaseSheet.setPulse(createOpthamologyCaseSheetRequest.getPulse());
        opthamologyCaseSheet.setRr(createOpthamologyCaseSheetRequest.getRr());
        opthamologyCaseSheet.setBp(createOpthamologyCaseSheetRequest.getBp());
        opthamologyCaseSheet.setSpo2(createOpthamologyCaseSheetRequest.getSpo2());
        opthamologyCaseSheet.setHeight(createOpthamologyCaseSheetRequest.getHeight());
        opthamologyCaseSheet.setWeight(createOpthamologyCaseSheetRequest.getWeight());
        opthamologyCaseSheet.setBmi(createOpthamologyCaseSheetRequest.getBmi());
        opthamologyCaseSheet.setExamination(createOpthamologyCaseSheetRequest.getExamination());
        opthamologyCaseSheet.setDiagnosis(createOpthamologyCaseSheetRequest.getDiagnosis());
        opthamologyCaseSheet.setDiscussion(createOpthamologyCaseSheetRequest.getDiscussion());
        opthamologyCaseSheet.setRecomendations(createOpthamologyCaseSheetRequest.getRecomendations());
        opthamologyCaseSheet.setTreatmentPlan(createOpthamologyCaseSheetRequest.getTreatmentPlan());
        opthamologyCaseSheet.setTreatmentGiven(createOpthamologyCaseSheetRequest.getTreatmentGiven());
        opthamologyCaseSheet.setExtra1(createOpthamologyCaseSheetRequest.getExtra1());
        opthamologyCaseSheet.setExtra2(createOpthamologyCaseSheetRequest.getExtra2());
        opthamologyCaseSheet.setExtra3(createOpthamologyCaseSheetRequest.getExtra3());
        opthamologyCaseSheet.setExtra4(createOpthamologyCaseSheetRequest.getExtra4());
        opthamologyCaseSheet.setExtra5(createOpthamologyCaseSheetRequest.getExtra5());
        opthamologyCaseSheet.setIsCancelled(createOpthamologyCaseSheetRequest.getIsCancelled());

        return opthamologyCaseSheet;
    }

    public void update (final CreateOpthamologyCaseSheetRequest createOpthamologyCaseSheetRequest){

        this.patientId      = createOpthamologyCaseSheetRequest.getPatientId();
        this.visitId        = createOpthamologyCaseSheetRequest.getVisitId();
        this.ipId           = createOpthamologyCaseSheetRequest.getIpId();
        this.consultantId   = createOpthamologyCaseSheetRequest.getConsultantId();
        this.dateTime       = DateTimeUtils.convertLocalDateToDateTimeFormat(LocalDateTime.now());
        this.presentIllness = createOpthamologyCaseSheetRequest.getPresentIllness();
        this.pastHistory    = createOpthamologyCaseSheetRequest.getPastHistory();
        this.allergy        = createOpthamologyCaseSheetRequest.getAllergy();
        this.temperature    = createOpthamologyCaseSheetRequest.getTemperature();
        this.pulse          = createOpthamologyCaseSheetRequest.getPulse();
        this.rr             = createOpthamologyCaseSheetRequest.getRr();
        this.bp             = createOpthamologyCaseSheetRequest.getBp();
        this.spo2           = createOpthamologyCaseSheetRequest.getSpo2();
        this.height         = createOpthamologyCaseSheetRequest.getHeight();
        this.weight         = createOpthamologyCaseSheetRequest.getWeight();
        this.bmi            = createOpthamologyCaseSheetRequest.getBmi();
        this.examination    = createOpthamologyCaseSheetRequest.getExamination();
        this.diagnosis      = createOpthamologyCaseSheetRequest.getDiagnosis();
        this.discussion     = createOpthamologyCaseSheetRequest.getDiscussion();
        this.recomendations = createOpthamologyCaseSheetRequest.getRecomendations();
        this.treatmentPlan  = createOpthamologyCaseSheetRequest.getTreatmentPlan();
        this.treatmentGiven = createOpthamologyCaseSheetRequest.getTreatmentGiven();
        this.extra1         = createOpthamologyCaseSheetRequest.getExtra1();
        this.extra2         = createOpthamologyCaseSheetRequest.getExtra2();
        this.extra3         = createOpthamologyCaseSheetRequest.getExtra3();
        this.extra4         = createOpthamologyCaseSheetRequest.getExtra4();
        this.extra5         = createOpthamologyCaseSheetRequest.getExtra5();
        this.isCancelled    = createOpthamologyCaseSheetRequest.getIsCancelled();
    }
}
