package com.ueniweb.swiftwaresolutions.request;


import lombok.Data;
import java.util.List;

import lombok.EqualsAndHashCode;

import java.util.List;
@EqualsAndHashCode(callSuper = true)
@Data
public class CreatePeadiatricCaseSheetRequest extends AbstractCaseSheetRequest {

    private Long patId;

    private Long visitId;

    private Long ipId;

    private String birthHistory;

    private String perinatalhistory;

    private String investigationHistory;

    private String feedinghistory;

    private String crt;

    private String temp;

    private String pallor;

    private String clubbing;

    private String icterus;

    private String cyanosis;

    private String lymphadenopathy;

    private String edema;

    private String headtotoe;

    private String oralcavity;

    private String cvs;

    private String rs;

    private String cns;

    private String abdo;

    private String skin;

    private String musculoskeletal;

    private String aditionalfindings;

    private String differentialDiagnosis;

    private String confirmedDiagnosis;

    private List<CreateComplaintDetailsRequest> createComplaintDetailsRequestList;

    @Override
    public String toString() {
        return "CreatePeadiatricCaseSheetRequest{" +
                ", patId=" + patId +
                ", visitId=" + visitId +
                ", ipId=" + ipId +
                ", birthHistory='" + birthHistory + '\'' +
                ", perinatalhistory='" + perinatalhistory + '\'' +
                ", investigationHistory='" + investigationHistory + '\'' +
                ", feedinghistory='" + feedinghistory + '\'' +
                ", crt='" + crt + '\'' +
                ", temp='" + temp + '\'' +
                ", pallor='" + pallor + '\'' +
                ", clubbing='" + clubbing + '\'' +
                ", icterus='" + icterus + '\'' +
                ", cyanosis='" + cyanosis + '\'' +
                ", lymphadenopathy='" + lymphadenopathy + '\'' +
                ", edema='" + edema + '\'' +
                ", headtotoe='" + headtotoe + '\'' +
                ", oralcavity='" + oralcavity + '\'' +
                ", cvs='" + cvs + '\'' +
                ", rs='" + rs + '\'' +
                ", cns='" + cns + '\'' +
                ", abdo='" + abdo + '\'' +
                ", skin='" + skin + '\'' +
                ", musculoskeletal='" + musculoskeletal + '\'' +
                ", aditionalfindings='" + aditionalfindings + '\'' +
                ", differentialDiagnosis='" + differentialDiagnosis + '\'' +
                ", confirmedDiagnosis='" + confirmedDiagnosis + '\'' +
                '}';
    }


}
