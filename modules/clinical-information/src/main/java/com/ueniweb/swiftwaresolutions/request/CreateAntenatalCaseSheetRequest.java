package com.ueniweb.swiftwaresolutions.request;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class CreateAntenatalCaseSheetRequest {

    private Long id;

    private Long patId;

    private Long vstId;

    private Long ipId;

    private String time;

    private String date;

    private String durationofmarriage;

    private String consanguinity;

    private String conception;

    private String menstrualhistory;

    private String hypertension;

    private String diabetesMellitus;

    private String twinGestation;

    private String chiefcomplaints;

    private String historyofpresentillness;


    private String menstrualhistroy;

    private String martialhistroy;

    private String familyHistory;


    private String surgicalHistory;

    private String allergichistory;

    private String others;

    private String instrumentaldelivery;

    private String eclampsia;

    private String postPartumHaemorrhage;

    private String ormoreabortions;

    private String previouspretermdelivery;

    private String stillbirthneonataldeath;

    private String caesareanSection;

    private String examDate;

    private String weight;

    private String pedalOdema;

    private String bp;

    private String fundalheight;

    private String presentation;

    private String fhs;

    private String pallor;

    private String iceturs;

    private String cyanosis;

    private String clubbing;

    private String lymphadenopathy;

    private String edama;

    private String lmp;

    private String edd;

    private String ga;

    private String g;

    private String p;

    private String l;

    private String a;

    private String modeofconception;

    private String redDischange;

    private String redDischangeInput;

    private String vomiting;

    private String vomitingInput;

    private String urinComp;

    private String urinCompInput;

    private String takeFolSupplement;

    private String takeFolSupplementInput;

    private String hisFoldFever;

    private String hisFoldFeverInput;

    private String quidceing;

    private String quidceinginput;

    private String anyHistory;

    private String stDose;

    private String ndDose;

    private String dose3;

    private String perFutalmovement;

    private String perFutalMovementIn;

    private String bleeding;

    private String bleedingInput;

    private String anyComplaints;

    private String anyComplaintsInput;

    private String primiUnder;

    private String primiAbove;

    private String ageAbove;

    private String pregnanceAfter;

    private String infertility;

    private String fifthPregancy;

    private String heightD;

    private String systemicDisease;

    private String threatenedAbortion;

    private String gestationExceeding;

    private String prematureLabour;

    private String apa;

    private String abnormalpresentation;

    private String iugr;

    private String multiplepregnancy;

    private String hydraminos;

    private String pih;

    private String serverAnaemia;

    private String cardiacDisease;

    private String gDMonOHA;

    private String gDMoninsulin;

    private String temperature;

    private String Pulse;

    private String rr;

    private String Fhr;

    private String Engagement;

    private String lie;

    private String FinalGestationalAge;

    private String usgAge;

    private String Cervicaldilation;

    private String Cervicaleffacement;

    private String Membrane;

    private String Clrfluid;

    private String Station;

    private String Pelvisadequate;

    private String LabExam;

    private String USGExam;

    private String otherExam;

    private String comboteim2;

    private String comboteim2In;

    private String comboteim3;

    private String comboteim3In;

    private String medicalHis;

    private String anemiaPre;

    private String obstructedlabour;

    private String aphpph;

    private String congenitalAnomaly;

    private String othesPreRisk;

    private String IfCaesarean;

    private String stDose2;

    private String stDoseIn;

    private String ndDose2;

    private String ndDoseIn;

    private String booster;

    private String boosterIn;

    private String trimester1;

    private String trimester2;

    private String trimester3;

    private String shortgravida;

    private String teenagePrimi;

    private String pregnancyInfertility;

    private String gth;

    private String elderlyGravida;

    private String grandmulti;

    private String gawks;

    private String anemiaCur;

    private String chronicDisease;

    private String othesCurRisk;

    private String dtm;

    private List<CreateAntenatalPreviousCaseSheetRequest> createAntenatalPreviousCaseSheetRequests;

    @Override
    public String toString() {
        return "CreateAntenatalCaseSheetRequest{" +
                "id=" + id +
                ", patId=" + patId +
                ", vstId=" + vstId +
                ", ipId=" + ipId +
                ", time='" + time + '\'' +
                ", date='" + date + '\'' +
                ", durationofmarriage='" + durationofmarriage + '\'' +
                ", consanguinity='" + consanguinity + '\'' +
                ", conception='" + conception + '\'' +
                ", menstrualhistory='" + menstrualhistory + '\'' +
                ", hypertension='" + hypertension + '\'' +
                ", diabetesMellitus='" + diabetesMellitus + '\'' +
                ", twinGestation='" + twinGestation + '\'' +
                ", chiefcomplaints='" + chiefcomplaints + '\'' +
                ", historyofpresentillness='" + historyofpresentillness + '\'' +
                ", menstrualhistroy='" + menstrualhistroy + '\'' +
                ", martialhistroy='" + martialhistroy + '\'' +
                ", familyHistory='" + familyHistory + '\'' +
                ", surgicalHistory='" + surgicalHistory + '\'' +
                ", allergichistory='" + allergichistory + '\'' +
                ", others='" + others + '\'' +
                ", instrumentaldelivery='" + instrumentaldelivery + '\'' +
                ", eclampsia='" + eclampsia + '\'' +
                ", postPartumHaemorrhage='" + postPartumHaemorrhage + '\'' +
                ", ormoreabortions='" + ormoreabortions + '\'' +
                ", previouspretermdelivery='" + previouspretermdelivery + '\'' +
                ", stillbirthneonataldeath='" + stillbirthneonataldeath + '\'' +
                ", caesareanSection='" + caesareanSection + '\'' +
                ", examDate='" + examDate + '\'' +
                ", weight='" + weight + '\'' +
                ", pedalOdema='" + pedalOdema + '\'' +
                ", bp='" + bp + '\'' +
                ", fundalheight='" + fundalheight + '\'' +
                ", presentation='" + presentation + '\'' +
                ", fhs='" + fhs + '\'' +
                ", pallor='" + pallor + '\'' +
                ", iceturs='" + iceturs + '\'' +
                ", cyanosis='" + cyanosis + '\'' +
                ", clubbing='" + clubbing + '\'' +
                ", lymphadenopathy='" + lymphadenopathy + '\'' +
                ", edama='" + edama + '\'' +
                ", lmp='" + lmp + '\'' +
                ", edd='" + edd + '\'' +
                ", ga='" + ga + '\'' +
                ", g='" + g + '\'' +
                ", p='" + p + '\'' +
                ", l='" + l + '\'' +
                ", a='" + a + '\'' +
                ", modeofconception='" + modeofconception + '\'' +
                ", redDischange='" + redDischange + '\'' +
                ", redDischangeInput='" + redDischangeInput + '\'' +
                ", vomiting='" + vomiting + '\'' +
                ", vomitingInput='" + vomitingInput + '\'' +
                ", urinComp='" + urinComp + '\'' +
                ", urinCompInput='" + urinCompInput + '\'' +
                ", takeFolSupplement='" + takeFolSupplement + '\'' +
                ", takeFolSupplementInput='" + takeFolSupplementInput + '\'' +
                ", hisFoldFever='" + hisFoldFever + '\'' +
                ", hisFoldFeverInput='" + hisFoldFeverInput + '\'' +
                ", quidceing='" + quidceing + '\'' +
                ", quidceinginput='" + quidceinginput + '\'' +
                ", anyHistory='" + anyHistory + '\'' +
                ", stDose='" + stDose + '\'' +
                ", ndDose='" + ndDose + '\'' +
                ", dose3='" + dose3 + '\'' +
                ", perFutalmovement='" + perFutalmovement + '\'' +
                ", perFutalMovementIn='" + perFutalMovementIn + '\'' +
                ", bleeding='" + bleeding + '\'' +
                ", bleedingInput='" + bleedingInput + '\'' +
                ", anyComplaints='" + anyComplaints + '\'' +
                ", anyComplaintsInput='" + anyComplaintsInput + '\'' +
                ", primiUnder='" + primiUnder + '\'' +
                ", primiAbove='" + primiAbove + '\'' +
                ", ageAbove='" + ageAbove + '\'' +
                ", pregnanceAfter='" + pregnanceAfter + '\'' +
                ", infertility='" + infertility + '\'' +
                ", fifthPregancy='" + fifthPregancy + '\'' +
                ", heightD='" + heightD + '\'' +
                ", systemicDisease='" + systemicDisease + '\'' +
                ", threatenedAbortion='" + threatenedAbortion + '\'' +
                ", gestationExceeding='" + gestationExceeding + '\'' +
                ", prematureLabour='" + prematureLabour + '\'' +
                ", apa='" + apa + '\'' +
                ", abnormalpresentation='" + abnormalpresentation + '\'' +
                ", iugr='" + iugr + '\'' +
                ", multiplepregnancy='" + multiplepregnancy + '\'' +
                ", hydraminos='" + hydraminos + '\'' +
                ", pih='" + pih + '\'' +
                ", serverAnaemia='" + serverAnaemia + '\'' +
                ", cardiacDisease='" + cardiacDisease + '\'' +
                ", gDMonOHA='" + gDMonOHA + '\'' +
                ", gDMoninsulin='" + gDMoninsulin + '\'' +
                ", temperature='" + temperature + '\'' +
                ", Pulse='" + Pulse + '\'' +
                ", rr='" + rr + '\'' +
                ", Fhr='" + Fhr + '\'' +
                ", Engagement='" + Engagement + '\'' +
                ", lie='" + lie + '\'' +
                ", FinalGestationalAge='" + FinalGestationalAge + '\'' +
                ", usgAge='" + usgAge + '\'' +
                ", Cervicaldilation='" + Cervicaldilation + '\'' +
                ", Cervicaleffacement='" + Cervicaleffacement + '\'' +
                ", Membrane='" + Membrane + '\'' +
                ", Clrfluid='" + Clrfluid + '\'' +
                ", Station='" + Station + '\'' +
                ", Pelvisadequate='" + Pelvisadequate + '\'' +
                ", LabExam='" + LabExam + '\'' +
                ", USGExam='" + USGExam + '\'' +
                ", otherExam='" + otherExam + '\'' +
                ", comboteim2='" + comboteim2 + '\'' +
                ", comboteim2In='" + comboteim2In + '\'' +
                ", comboteim3='" + comboteim3 + '\'' +
                ", comboteim3In='" + comboteim3In + '\'' +
                ", medicalHis='" + medicalHis + '\'' +
                ", anemiaPre='" + anemiaPre + '\'' +
                ", obstructedlabour='" + obstructedlabour + '\'' +
                ", aphpph='" + aphpph + '\'' +
                ", congenitalAnomaly='" + congenitalAnomaly + '\'' +
                ", othesPreRisk='" + othesPreRisk + '\'' +
                ", IfCaesarean='" + IfCaesarean + '\'' +
                ", stDose2='" + stDose2 + '\'' +
                ", stDoseIn='" + stDoseIn + '\'' +
                ", ndDose2='" + ndDose2 + '\'' +
                ", ndDoseIn='" + ndDoseIn + '\'' +
                ", booster='" + booster + '\'' +
                ", boosterIn='" + boosterIn + '\'' +
                ", trimester1='" + trimester1 + '\'' +
                ", trimester2='" + trimester2 + '\'' +
                ", trimester3='" + trimester3 + '\'' +
                ", shortgravida='" + shortgravida + '\'' +
                ", teenagePrimi='" + teenagePrimi + '\'' +
                ", pregnancyInfertility='" + pregnancyInfertility + '\'' +
                ", gth='" + gth + '\'' +
                ", elderlyGravida='" + elderlyGravida + '\'' +
                ", grandmulti='" + grandmulti + '\'' +
                ", gawks='" + gawks + '\'' +
                ", anemiaCur='" + anemiaCur + '\'' +
                ", chronicDisease='" + chronicDisease + '\'' +
                ", othesCurRisk='" + othesCurRisk + '\'' +
                ", dtm='" + dtm + '\'' +

                '}';
    }



}
