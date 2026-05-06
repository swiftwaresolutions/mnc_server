package com.ueniweb.swiftwaresolutions.data;
import com.ueniweb.swiftwaresolutions.request.CreateSurigicalNurseRequest;
import com.ueniweb.swiftwaresolutions.request.CreateSurigicalSurgonRequest;
import jakarta.persistence.Column;
import lombok.Data;

import java.util.List;
@Data
public class SurgeryCaseSheetData {

    private Long id;

    private Long patId;

    private Long visitId;

    private Long ipId;

    private String entDate;

    private String entTime;

    private String surgeryDate;

    private String surgeryTime;

    private String durSurgery;

    private String preOtDiagnosis;

    private String postOtDiagnosis;

    private String DetSurgery;

    private String ProcedureNotes;

    private String ProgressNotes;

    private  String AnestDoc;

    private List<SurgerySurgonData> surgerySurgonData;

    private List<SurgeryNurseData> surgeryNurseData;

    private List<SurgeryData> surgeryDataList;

    public SurgeryCaseSheetData(Long id, Long patId, Long visitId, Long ipId, String entDate, String entTime, String surgeryDate,
     String surgeryTime,String durSurgery, String preOtDiagnosis, String postOtDiagnosis, String DetSurgery, String ProcedureNotes, String ProgressNotes, String AnestDoc)

    {
        this.id=id;

        this.patId=patId;

        this.visitId=visitId;

        this.ipId=ipId;

        this.entDate=entDate;

        this.entTime=entTime;

        this.surgeryDate=surgeryDate;

        this.surgeryTime=surgeryTime;

        this.durSurgery=durSurgery;

        this.preOtDiagnosis=preOtDiagnosis;

        this.postOtDiagnosis=postOtDiagnosis;

        this.DetSurgery=DetSurgery;

        this.ProcedureNotes=ProcedureNotes;

        this.ProgressNotes=ProgressNotes;

        this.AnestDoc=AnestDoc;

    }
    public static SurgeryCaseSheetData newInstance(Long id, Long patId, Long visitId, Long ipId, String entDate, String entTime,
                                                   String surgeryDate, String surgeryTime,String durSurgery, String preOtDiagnosis,
                                                   String postOtDiagnosis, String DetSurgery, String ProcedureNotes, String ProgressNotes, String AnestDoc) {

        return new SurgeryCaseSheetData(  id,  patId,  visitId,  ipId,  entDate,  entTime,
                 surgeryDate,  surgeryTime, durSurgery,  preOtDiagnosis,
                 postOtDiagnosis,  DetSurgery,  ProcedureNotes,  ProgressNotes,AnestDoc);
    }
}
