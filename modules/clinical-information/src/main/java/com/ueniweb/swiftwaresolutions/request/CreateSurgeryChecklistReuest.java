package com.ueniweb.swiftwaresolutions.request;


import lombok.Data;

@Data
public class CreateSurgeryChecklistReuest {

    private Long id;

    private Long patId;

    private Long visitId;

    private Long ipId;

    private Long airway;

    private Long allergy;

    private Long anticipatedBlood;

    private Long bloodloss;

    private Long confermation;

    private Long critical;

    private Long equipmentIssues;

    private Long equipmentProblems;

    private Long imaging;

    private Long incision;

    private Long marked;

    private Long medication;

    private Long oximeter;

    private Long patientSpecific;

    private Long procedures;

    private Long prophylaxis;

    private Long recovery;

    private Long specimen;

    private Long sponge;

    private Long sterility;

    private Long teamMembers;

    private Long timeTaken;

    private String dtm;

    private String surgName;

    private Long docId;


    @Override
    public String toString() {
        return "CreateSurgeryChecklistReuest{" +
                "id=" + id +
                ", patId=" + patId +
                ", visitId=" + visitId +
                ", ipId=" + ipId +
                ", airway=" + airway +
                ", allergy=" + allergy +
                ", anticipatedBlood=" + anticipatedBlood +
                ", bloodloss=" + bloodloss +
                ", confermation=" + confermation +
                ", critical=" + critical +
                ", equipmentIssues=" + equipmentIssues +
                ", equipmentProblems=" + equipmentProblems +
                ", imaging=" + imaging +
                ", incision=" + incision +
                ", marked=" + marked +
                ", medication=" + medication +
                ", oximeter=" + oximeter +
                ", patientSpecific=" + patientSpecific +
                ", procedures=" + procedures +
                ", prophylaxis=" + prophylaxis +
                ", recovery=" + recovery +
                ", specimen=" + specimen +
                ", sponge=" + sponge +
                ", sterility=" + sterility +
                ", teamMembers=" + teamMembers +
                ", timeTaken=" + timeTaken +
                ", dtm=" + dtm +
                ", surgName=" + surgName +
                ", docId=" + docId +
                '}';
    }

}
