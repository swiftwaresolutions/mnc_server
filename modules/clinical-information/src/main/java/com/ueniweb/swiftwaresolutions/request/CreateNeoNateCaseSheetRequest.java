package com.ueniweb.swiftwaresolutions.request;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class CreateNeoNateCaseSheetRequest extends AbstractCaseSheetRequest {

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

    private List<CreateComplaintDetailsRequest> createComplaintDetailsRequestList;


    @Override
    public String toString() {
        return "CreateNeoNateCaseSheetRequest{" +
                "patId=" + patId +
                ", visitId=" + visitId +
                ", ipId=" + ipId +
                ", dobTob='" + dobTob + '\'' +
                ", placeofbirth='" + placeofbirth + '\'' +
                ", presentIllness='" + presentIllness + '\'' +
                ", maternalhistory='" + maternalHistory + '\'' +
                ", birthHistory='" + birthHistory + '\'' +
                ", treatmentHistory='" + treatmentHistory + '\'' +
                ", investigationHistory='" + investigationHistory + '\'' +
                ", pulse='" + pulse + '\'' +
                ", bp='" + bp + '\'' +
                ", rr='" + rr + '\'' +
                ", spo2='" + spo2 + '\'' +
                ", crt='" + crt + '\'' +
                ", temp='" + temp + '\'' +
                ", pallor='" + pallor + '\'' +
                ", icterus='" + icterus + '\'' +
                ", cyanosis='" + cyanosis + '\'' +
                ", cogenital='" + cogenital + '\'' +
                ", headtotoe='" + headtotoe + '\'' +
                ", oralcavity='" + oralcavity + '\'' +
                ", cvs='" + cvs + '\'' +
                ", rs='" + res + '\'' +
                ", abdo='" + abdo + '\'' +
                ", cns='" + cns + '\'' +
                ", skin='" + skin + '\'' +
                ", musculoskeletal='" + musculoskeletal + '\'' +
                ", aditionalfindings='" + aditionalfindings + '\'' +
                ", allergy='" + allergy + '\'' +
                ", differentialDiagnosis='" + differentialDiagnosis + '\'' +
                ", confirmedDiagnosis='" + confirmedDiagnosis + '\'' +
                '}';
    }

}
