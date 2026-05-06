package com.ueniweb.swiftwaresolutions.data;

import lombok.Data;
@Data
public class AntenatalPreData {

    private Long id;

    private Long ancId;

    private Long ChildNo;

    private String YrOfBirth;

    private String Gender;

    private String PregDuration;

    private String PlaceDelivery;

    private String ModeDelivery;

    private String Birthweight;

    private String ChildStatus;

    private Long isValid;


    public AntenatalPreData(final Long id,final Long ancId,final Long ChildNo,final String YrOfBirth,final String Gender,final
                             String PregDuration,final String PlaceDelivery,final  String ModeDelivery,final  String Birthweight,final
                             String ChildStatus,Long isValid
    ) {
       this.id=id;

       this.ancId=ancId;

       this.ChildNo=ChildNo;

       this.YrOfBirth=YrOfBirth;

        this.Gender=Gender;

        this.PregDuration=PregDuration;

        this.PlaceDelivery=PlaceDelivery;

        this.ModeDelivery=ModeDelivery;

        this.Birthweight=Birthweight;

        this.ChildStatus=ChildStatus;

        this.isValid=isValid;

    }
    public static AntenatalPreData createNewInstance(final Long id,final Long ancId,final Long ChildNo,final String YrOfBirth,final String Gender,final
                                                    String PregDuration,final String PlaceDelivery,final  String ModeDelivery,final  String Birthweight,final
                                                    String ChildStatus ,final Long isValid) {
        return new AntenatalPreData( id, ancId, ChildNo, YrOfBirth, Gender,
                 PregDuration, PlaceDelivery,  ModeDelivery,  Birthweight,
                 ChildStatus,isValid);
    }
}
