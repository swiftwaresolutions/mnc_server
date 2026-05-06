package com.ueniweb.swiftwaresolutions.domain;

import com.ueniweb.swiftwaresolutions.request.CreateDermatologyCaseSheetRequest;
import com.ueniweb.swiftwaresolutions.utils.DateTimeUtils;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity(name = "DermatologyCaseSheet")
@Table(name = "cli_patient_dermatology_casesheet")
@Data
public class DermatologyCaseSheet {

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
    private List<DermatologyComplaintDetails> dermatologyComplaintDetailsList = new ArrayList<>();

    @OneToMany(mappedBy = "caseSheetId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DermatologyDiagnosisDetails> dermatologyDiagnosisDetailsList = new ArrayList<>();

    public static DermatologyCaseSheet to(final CreateDermatologyCaseSheetRequest createDermatologyCaseSheetRequest ){
        DermatologyCaseSheet dermatologyCaseSheet = new DermatologyCaseSheet();

        dermatologyCaseSheet.setPatientId(createDermatologyCaseSheetRequest.getPatientId());
        dermatologyCaseSheet.setVisitId(createDermatologyCaseSheetRequest.getVisitId());
        dermatologyCaseSheet.setIpId(createDermatologyCaseSheetRequest.getIpId());
        dermatologyCaseSheet.setConsultantId(createDermatologyCaseSheetRequest.getConsultantId());
        dermatologyCaseSheet.setDateTime(DateTimeUtils.convertLocalDateToDateTimeFormat(LocalDateTime.now()));
        dermatologyCaseSheet.setPresentIllness(createDermatologyCaseSheetRequest.getPresentIllness());
        dermatologyCaseSheet.setPastHistory(createDermatologyCaseSheetRequest.getPastHistory());
        dermatologyCaseSheet.setAllergy(createDermatologyCaseSheetRequest.getAllergy());
        dermatologyCaseSheet.setTemperature(createDermatologyCaseSheetRequest.getTemperature());
        dermatologyCaseSheet.setPulse(createDermatologyCaseSheetRequest.getPulse());
        dermatologyCaseSheet.setRr(createDermatologyCaseSheetRequest.getRr());
        dermatologyCaseSheet.setBp(createDermatologyCaseSheetRequest.getBp());
        dermatologyCaseSheet.setSpo2(createDermatologyCaseSheetRequest.getSpo2());
        dermatologyCaseSheet.setHeight(createDermatologyCaseSheetRequest.getHeight());
        dermatologyCaseSheet.setWeight(createDermatologyCaseSheetRequest.getWeight());
        dermatologyCaseSheet.setBmi(createDermatologyCaseSheetRequest.getBmi());
        dermatologyCaseSheet.setExamination(createDermatologyCaseSheetRequest.getExamination());
        dermatologyCaseSheet.setDiagnosis(createDermatologyCaseSheetRequest.getDiagnosis());
        dermatologyCaseSheet.setDiscussion(createDermatologyCaseSheetRequest.getDiscussion());
        dermatologyCaseSheet.setRecomendations(createDermatologyCaseSheetRequest.getRecomendations());
        dermatologyCaseSheet.setTreatmentPlan(createDermatologyCaseSheetRequest.getTreatmentPlan());
        dermatologyCaseSheet.setTreatmentGiven(createDermatologyCaseSheetRequest.getTreatmentGiven());
        dermatologyCaseSheet.setExtra1(createDermatologyCaseSheetRequest.getExtra1());
        dermatologyCaseSheet.setExtra2(createDermatologyCaseSheetRequest.getExtra2());
        dermatologyCaseSheet.setExtra3(createDermatologyCaseSheetRequest.getExtra3());
        dermatologyCaseSheet.setExtra4(createDermatologyCaseSheetRequest.getExtra4());
        dermatologyCaseSheet.setExtra5(createDermatologyCaseSheetRequest.getExtra5());
        dermatologyCaseSheet.setIsCancelled(createDermatologyCaseSheetRequest.getIsCancelled());

        return dermatologyCaseSheet;
    }

    public void update (final CreateDermatologyCaseSheetRequest createDermatologyCaseSheetRequest){

        this.patientId      = createDermatologyCaseSheetRequest.getPatientId();
        this.visitId        = createDermatologyCaseSheetRequest.getVisitId();
        this.ipId           = createDermatologyCaseSheetRequest.getIpId();
        this.consultantId   = createDermatologyCaseSheetRequest.getConsultantId();
        this.dateTime       = DateTimeUtils.convertLocalDateToDateTimeFormat(LocalDateTime.now());
        this.presentIllness = createDermatologyCaseSheetRequest.getPresentIllness();
        this.pastHistory    = createDermatologyCaseSheetRequest.getPastHistory();
        this.allergy        = createDermatologyCaseSheetRequest.getAllergy();
        this.temperature    = createDermatologyCaseSheetRequest.getTemperature();
        this.pulse          = createDermatologyCaseSheetRequest.getPulse();
        this.rr             = createDermatologyCaseSheetRequest.getRr();
        this.bp             = createDermatologyCaseSheetRequest.getBp();
        this.spo2           = createDermatologyCaseSheetRequest.getSpo2();
        this.height         = createDermatologyCaseSheetRequest.getHeight();
        this.weight         = createDermatologyCaseSheetRequest.getWeight();
        this.bmi            = createDermatologyCaseSheetRequest.getBmi();
        this.examination    = createDermatologyCaseSheetRequest.getExamination();
        this.diagnosis      = createDermatologyCaseSheetRequest.getDiagnosis();
        this.discussion     = createDermatologyCaseSheetRequest.getDiscussion();
        this.recomendations = createDermatologyCaseSheetRequest.getRecomendations();
        this.treatmentPlan  = createDermatologyCaseSheetRequest.getTreatmentPlan();
        this.treatmentGiven = createDermatologyCaseSheetRequest.getTreatmentGiven();
        this.extra1         = createDermatologyCaseSheetRequest.getExtra1();
        this.extra2         = createDermatologyCaseSheetRequest.getExtra2();
        this.extra3         = createDermatologyCaseSheetRequest.getExtra3();
        this.extra4         = createDermatologyCaseSheetRequest.getExtra4();
        this.extra5         = createDermatologyCaseSheetRequest.getExtra5();
        this.isCancelled    = createDermatologyCaseSheetRequest.getIsCancelled();
    }
}
