package com.ueniweb.swiftwaresolutions.domain;

import com.ueniweb.swiftwaresolutions.request.CreateENTCaseSheetRequest;
import com.ueniweb.swiftwaresolutions.utils.DateTimeUtils;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "ENTCaseSheet")
@Table(name = "cli_patient_ent_casesheet")
@Data
public class ENTCaseSheet {

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
    private List<ENTComplaintDetails> entComplaintDetailsList = new ArrayList<>();

    @OneToMany(mappedBy = "caseSheetId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ENTDiagnosisDetails> entDiagnosisDetailsList = new ArrayList<>();

    public static ENTCaseSheet to(final CreateENTCaseSheetRequest createENTCaseSheetRequest ){
        ENTCaseSheet entCaseSheet = new ENTCaseSheet();

        entCaseSheet.setPatientId(createENTCaseSheetRequest.getPatientId());
        entCaseSheet.setVisitId(createENTCaseSheetRequest.getVisitId());
        entCaseSheet.setIpId(createENTCaseSheetRequest.getIpId());
        entCaseSheet.setConsultantId(createENTCaseSheetRequest.getConsultantId());
        entCaseSheet.setDateTime(DateTimeUtils.convertLocalDateToDateTimeFormat(LocalDateTime.now()));
        entCaseSheet.setPresentIllness(createENTCaseSheetRequest.getPresentIllness());
        entCaseSheet.setPastHistory(createENTCaseSheetRequest.getPastHistory());
        entCaseSheet.setAllergy(createENTCaseSheetRequest.getAllergy());
        entCaseSheet.setTemperature(createENTCaseSheetRequest.getTemperature());
        entCaseSheet.setPulse(createENTCaseSheetRequest.getPulse());
        entCaseSheet.setRr(createENTCaseSheetRequest.getRr());
        entCaseSheet.setBp(createENTCaseSheetRequest.getBp());
        entCaseSheet.setSpo2(createENTCaseSheetRequest.getSpo2());
        entCaseSheet.setHeight(createENTCaseSheetRequest.getHeight());
        entCaseSheet.setWeight(createENTCaseSheetRequest.getWeight());
        entCaseSheet.setBmi(createENTCaseSheetRequest.getBmi());
        entCaseSheet.setExamination(createENTCaseSheetRequest.getExamination());
        entCaseSheet.setDiagnosis(createENTCaseSheetRequest.getDiagnosis());
        entCaseSheet.setDiscussion(createENTCaseSheetRequest.getDiscussion());
        entCaseSheet.setRecomendations(createENTCaseSheetRequest.getRecomendations());
        entCaseSheet.setTreatmentPlan(createENTCaseSheetRequest.getTreatmentPlan());
        entCaseSheet.setTreatmentGiven(createENTCaseSheetRequest.getTreatmentGiven());
        entCaseSheet.setExtra1(createENTCaseSheetRequest.getExtra1());
        entCaseSheet.setExtra2(createENTCaseSheetRequest.getExtra2());
        entCaseSheet.setExtra3(createENTCaseSheetRequest.getExtra3());
        entCaseSheet.setExtra4(createENTCaseSheetRequest.getExtra4());
        entCaseSheet.setExtra5(createENTCaseSheetRequest.getExtra5());
        entCaseSheet.setIsCancelled(createENTCaseSheetRequest.getIsCancelled());

        return entCaseSheet;
    }

    public void update (final CreateENTCaseSheetRequest createENTCaseSheetRequest){

        this.patientId      = createENTCaseSheetRequest.getPatientId();
        this.visitId        = createENTCaseSheetRequest.getVisitId();
        this.ipId           = createENTCaseSheetRequest.getIpId();
        this.consultantId   = createENTCaseSheetRequest.getConsultantId();
        this.dateTime       = DateTimeUtils.convertLocalDateToDateTimeFormat(LocalDateTime.now());
        this.presentIllness = createENTCaseSheetRequest.getPresentIllness();
        this.pastHistory    = createENTCaseSheetRequest.getPastHistory();
        this.allergy        = createENTCaseSheetRequest.getAllergy();
        this.temperature    = createENTCaseSheetRequest.getTemperature();
        this.pulse          = createENTCaseSheetRequest.getPulse();
        this.rr             = createENTCaseSheetRequest.getRr();
        this.bp             = createENTCaseSheetRequest.getBp();
        this.spo2           = createENTCaseSheetRequest.getSpo2();
        this.height         = createENTCaseSheetRequest.getHeight();
        this.weight         = createENTCaseSheetRequest.getWeight();
        this.bmi            = createENTCaseSheetRequest.getBmi();
        this.examination    = createENTCaseSheetRequest.getExamination();
        this.diagnosis      = createENTCaseSheetRequest.getDiagnosis();
        this.discussion     = createENTCaseSheetRequest.getDiscussion();
        this.recomendations = createENTCaseSheetRequest.getRecomendations();
        this.treatmentPlan  = createENTCaseSheetRequest.getTreatmentPlan();
        this.treatmentGiven = createENTCaseSheetRequest.getTreatmentGiven();
        this.extra1         = createENTCaseSheetRequest.getExtra1();
        this.extra2         = createENTCaseSheetRequest.getExtra2();
        this.extra3         = createENTCaseSheetRequest.getExtra3();
        this.extra4         = createENTCaseSheetRequest.getExtra4();
        this.extra5         = createENTCaseSheetRequest.getExtra5();
        this.isCancelled    = createENTCaseSheetRequest.getIsCancelled();
    }
}
