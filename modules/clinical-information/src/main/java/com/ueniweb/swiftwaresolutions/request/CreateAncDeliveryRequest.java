package com.ueniweb.swiftwaresolutions.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Data
@Getter
@Setter
public class CreateAncDeliveryRequest {

    private Long id;

    private  Long patId;

    private  Long vstId;

    private String Mins1;

    private String Mins5;

    private String augmentation;

    private String birth;

    private String birthWeight;

    private String complication;

    private String deliveryDoc;

    private String doa;

    private String dod;

    private String dob;

    private String indication;

    private String liquor;

    private String modeDelivery;

    private String other;

    private String overais;

    private String presentation;

    private String riskFactor;

    private String sex;

    private String toa;

    private String tob;

    private String tod;

    private String uterus;

    private List<CreateAncDeliveryInductionRequest> createAncDeliveryInductionRequestList;

    @Override
    public String toString() {
        return "CreateAncDeliveryRequest{" +
                "id=" + id +
                ", patId='" + patId + '\'' +
                ", vstId='" + vstId + '\'' +
                ", Mins1='" + Mins1 + '\'' +
                ", Mins5='" + Mins5 + '\'' +
                ", augmentation='" + augmentation + '\'' +
                ", birth='" + birth + '\'' +
                ", birthWeight='" + birthWeight + '\'' +
                ", complication='" + complication + '\'' +
                ", deliveryDoc='" + deliveryDoc + '\'' +
                ", doa='" + doa + '\'' +
                ", dob='" + dob + '\'' +
                ", dod='" + dod + '\'' +
                ", indication='" + indication + '\'' +
                ", liquor='" + liquor + '\'' +
                ", modeDelivery='" + modeDelivery + '\'' +
                ", other='" + other + '\'' +
                ", overais='" + overais + '\'' +
                ", presentation='" + presentation + '\'' +
                ", riskFactor='" + riskFactor + '\'' +
                ", sex='" + sex + '\'' +
                ", toa='" + toa + '\'' +
                ", tob='" + tob + '\'' +
                ", tod='" + tod + '\'' +
                ", uterus='" + uterus + '\'' +
                '}';
    }
}
