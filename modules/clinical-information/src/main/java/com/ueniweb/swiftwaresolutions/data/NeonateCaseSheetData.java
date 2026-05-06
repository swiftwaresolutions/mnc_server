package com.ueniweb.swiftwaresolutions.data;

import com.ueniweb.swiftwaresolutions.domain.NeoNateComplaintDetails;
import lombok.Data;

import java.util.List;

@Data
public class NeonateCaseSheetData {

    private Long id;

    private Long patId;

    private Long visitId;

    private Long ipId;

    private String dobTob;

    private String placeofbirth;

    private String presentIllness;

    private String maternalHistory;

    private String birthHistory;

    private String treatmentHistory;

    private String investigationHistory;

    private String pulse;

    private String bp;

    private String rr;

    private String spo2;

    private String crt;

    private String temp;

    private String pallor;

    private String icterus;

    private String cyanosis;

    private String cogenital;

    private String headtotoe;

    private String oralcavity;

    private String cvs;

    private String res;

    private String abdo;

    private String cns;

    private String skin;

    private String musculoskeletal;

    private String aditionalfindings;

    private String allergy;

    private String differentialDiagnosis;

    private String confirmedDiagnosis;

    private List<ComplaintDetailsData> complaintDataList;

    public NeonateCaseSheetData(Long id, Long patId, Long visitId, Long ipId, String dobTob, String placeofbirth, String presentIllness, String maternalHistory, String birthHistory,
                                String treatmentHistory, String investigationHistory, String pulse, String bp, String rr, String spo2, String crt, String temp, String pallor, String icterus, String cyanosis, String cogenital,
                                String headtotoe, String oralcavity, String cvs, String res, String abdo, String cns,String skin, String musculoskeletal, String aditionalfindings, String allergy, String differentialDiagnosis, String confirmedDiagnosis) {
        this.id = id;
        this.patId = patId;
        this.visitId = visitId;
        this.ipId = ipId;
        this.dobTob = dobTob;
        this.placeofbirth = placeofbirth;
        this.presentIllness = presentIllness;
        this.maternalHistory = maternalHistory;
        this.birthHistory = birthHistory;
        this.treatmentHistory = treatmentHistory;
        this.investigationHistory = investigationHistory;
        this.pulse = pulse;
        this.bp = bp;
        this.rr = rr;
        this.spo2 = spo2;
        this.crt = crt;
        this.temp = temp;
        this.pallor = pallor;
        this.icterus = icterus;
        this.cyanosis = cyanosis;
        this.cogenital = cogenital;
        this.headtotoe = headtotoe;
        this.oralcavity = oralcavity;
        this.cvs = cvs;
        this.res = res;
        this.abdo = abdo;
        this.cns = cns;
        this.skin = skin;
        this.musculoskeletal = musculoskeletal;
        this.aditionalfindings = aditionalfindings;
        this.allergy = allergy;
        this.differentialDiagnosis = differentialDiagnosis;
        this.confirmedDiagnosis = confirmedDiagnosis;
    }

    public static NeonateCaseSheetData newInstance(Long id, Long patId, Long visitId, Long ipId, String dobTob, String placeofbirth, String presentIllness, String maternalHistory, String birthHistory,
                                                   String treatmentHistory, String investigationHistory, String pulse, String bp, String rr, String spo2, String crt, String temp, String pallor, String icterus, String cyanosis, String cogenital,
                                                   String headtotoe, String oralcavity, String cvs, String res, String abdo, String cns,String skin, String musculoskeletal, String aditionalfindings, String allergy, String differentialDiagnosis, String confirmedDiagnosis) {
        return new NeonateCaseSheetData(id,patId,visitId,ipId,dobTob,placeofbirth,presentIllness, maternalHistory, birthHistory,
                 treatmentHistory,  investigationHistory,  pulse,  bp,  rr,spo2,crt,temp,pallor,icterus,cyanosis,cogenital,
                 headtotoe,  oralcavity,  cvs,  res,  abdo, cns, skin,musculoskeletal,aditionalfindings,allergy,differentialDiagnosis,confirmedDiagnosis);
    }
}