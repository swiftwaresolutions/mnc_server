package com.ueniweb.swiftwaresolutions.request;


import lombok.Data;

@Data
public class CreateAntenatalPreviousCaseSheetRequest {


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

    @Override
    public String toString() {
        return "CreateAntenatalPreviousCaseSheetRequest{" +
                "id=" + id +
                ", ancId=" + ancId +
                ", ChildNo=" + ChildNo +
                ", YrOfBirth='" + YrOfBirth + '\'' +
                ", Gender='" + Gender + '\'' +
                ", PregDuration='" + PregDuration + '\'' +
                ", PlaceDelivery='" + PlaceDelivery + '\'' +
                ", ModeDelivery='" + ModeDelivery + '\'' +
                ", Birthweight='" + Birthweight + '\'' +
                ", ChildStatus='" + ChildStatus + '\'' +
                ", isValid=" + isValid +
                '}';
    }

}
