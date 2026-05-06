package com.ueniweb.swiftwaresolutions.domain;

import com.ueniweb.swiftwaresolutions.request.CreateDentalCasesheetRequest;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "DentalCaseSheet")
@Table(name = "cli_patient_dental_casesheet")

public class DentalCaseSheet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "patId", nullable = false)
    @Basic(optional = false)
    private Long patientId;

    @Column(name = "vstId", nullable = false)
    @Basic(optional = false)
    private Long visitId;

    @Column(name = "ipId")
    @Basic(optional = false)
    private Long ipId;

    @Column(name = "historyofpresentIllness", columnDefinition = "TEXT")
    private String historyofpresentIllness;

    @Column(name = "medicalHistory", columnDefinition = "TEXT")
    private String medicalHistory;

    @Column(name = "past_History", columnDefinition = "TEXT")
    private String past_History;

    @Column(name = "habitHistory", columnDefinition = "TEXT")
    private String habitHistory;

    @Column(name = "treatment_History", columnDefinition = "TEXT")
    private String treatment_History;

    @Column(name = "extraoralexamination", columnDefinition = "TEXT")
    private String extraoralexamination;

    @Column(name = "occupation", columnDefinition = "TEXT")
    private String occupation;

    @Column(name = "treatmentplan", columnDefinition = "TEXT")
    private String treatmentplan;

    @Column(name = "treatmentgeneral", columnDefinition = "TEXT")
    private String treatmentgeneral;

    @OneToMany(mappedBy = "caseSheetId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DentalComplaintDetails> dentalcomplaintDetailsList = new ArrayList<>();

    @OneToMany(mappedBy = "caseSheetId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DentalTeethExamDetails> dentalTeethExamDetailsList = new ArrayList<>();

    @OneToMany(mappedBy = "caseSheetId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DentalTeethTreatDetails> dentalTeethTreatDetailsList = new ArrayList<>();


    public static DentalCaseSheet to(final CreateDentalCasesheetRequest createDentalCasesheetRequest){
        DentalCaseSheet dentalCaseSheet = new DentalCaseSheet();
        dentalCaseSheet.setPatientId(createDentalCasesheetRequest.getPatId());
        dentalCaseSheet.setVisitId(createDentalCasesheetRequest.getVisitId());
        dentalCaseSheet.setIpId(createDentalCasesheetRequest.getIpId());
        dentalCaseSheet.setHistoryofpresentIllness(createDentalCasesheetRequest.getHistoryofpresentIllness());
        dentalCaseSheet.setMedicalHistory(createDentalCasesheetRequest.getMedicalHistory());
        dentalCaseSheet.setPast_History(createDentalCasesheetRequest.getPast_History());
        dentalCaseSheet.setHabitHistory(createDentalCasesheetRequest.getHabitHistory());
        dentalCaseSheet.setTreatment_History(createDentalCasesheetRequest.getTreatment_History());
        dentalCaseSheet.setExtraoralexamination(createDentalCasesheetRequest.getExtraoralexamination());
        dentalCaseSheet.setOccupation(createDentalCasesheetRequest.getOccupation());
        dentalCaseSheet.setTreatmentplan(createDentalCasesheetRequest.getTreatmentplan());
        dentalCaseSheet.setTreatmentgeneral(createDentalCasesheetRequest.getTreatmentgeneral());

        return dentalCaseSheet;
    }

    public void update(final CreateDentalCasesheetRequest createdentalCaseSheetRequest){
        this.patientId = createdentalCaseSheetRequest.getPatId();
        this.visitId = createdentalCaseSheetRequest.getVisitId();
        this.ipId = createdentalCaseSheetRequest.getIpId();
        this.historyofpresentIllness = createdentalCaseSheetRequest.getHistoryofpresentIllness();
        this.medicalHistory = createdentalCaseSheetRequest.getMedicalHistory();
        this.past_History = createdentalCaseSheetRequest.getPast_History();
        this.habitHistory = createdentalCaseSheetRequest.getHabitHistory();
        this.treatment_History = createdentalCaseSheetRequest.getTreatment_History();
        this.extraoralexamination = createdentalCaseSheetRequest.getExtraoralexamination();
        this.occupation = createdentalCaseSheetRequest.getOccupation();
        this.treatmentplan = createdentalCaseSheetRequest.getTreatmentplan();
        this.treatmentgeneral = createdentalCaseSheetRequest.getTreatmentgeneral();

    }
}
