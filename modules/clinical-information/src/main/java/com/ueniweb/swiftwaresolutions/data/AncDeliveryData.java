package com.ueniweb.swiftwaresolutions.data;

import lombok.Data;

import java.util.List;
@Data
public class AncDeliveryData {
    private Long id;

    private Long patId;

    private Long vstId;

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

    private List<AncDeliveryInductionData> ancDeliveryInductionList;

    public AncDeliveryData(final Long id , final Long patId, final Long vstId,final  String Mins1,final  String Mins5,final  String augmentation,final  String birth,final  String birthWeight,final  String complication,final  String deliveryDoc,final  String doa,final  String dod,final  String dob,final  String indication,final  String liquor,final  String modeDelivery,final  String other,final  String overais,final  String presentation,final  String riskFactor,final  String sex,final  String toa,final  String tob,final  String tod,final  String uterus){

        this.id=id;

        this.patId=patId;

        this.vstId=vstId;

        this.Mins1=Mins1;

        this.Mins5=Mins5;

        this.augmentation=augmentation;

        this.birth=birth;

        this.birthWeight=birthWeight;

        this.complication=complication;

        this.deliveryDoc=deliveryDoc;

        this.doa=doa;

        this.dod=dod;

        this.dob=dob;

        this.indication=indication;

        this.liquor=liquor;

        this.modeDelivery=modeDelivery;

        this.other=other;

        this.overais=overais;

        this.presentation=presentation;

        this.riskFactor=riskFactor;

        this.sex=sex;

        this.toa=toa;

        this.tob=tob;

        this.tod=tod;

        this.uterus=uterus;

    }
    public static AncDeliveryData newInstance(final Long id, final Long patId, final Long vstId,final  String Mins1,final  String Mins5,final  String augmentation,final  String birth,final  String birthWeight,final  String complication,final  String deliveryDoc,final  String doa,final  String dod,final  String dob,final  String indication,final  String liquor,final  String modeDelivery,final  String other,final  String overais,final  String presentation,final  String riskFactor,final  String sex,final  String toa,final  String tob,final  String tod,final  String uterus){
        return new AncDeliveryData(  id,patId,vstId,   Mins1,   Mins5,   augmentation,   birth,   birthWeight,   complication,   deliveryDoc,   doa,   dod,dob,   indication,   liquor,   modeDelivery,   other,   overais,   presentation,   riskFactor,   sex,   toa,   tob,   tod,   uterus);
    }
}
