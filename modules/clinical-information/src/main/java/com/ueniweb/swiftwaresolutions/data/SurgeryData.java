package com.ueniweb.swiftwaresolutions.data;

import lombok.Data;
@Data
public class SurgeryData {

    private Long id;

    private Long surId;

    private String surgeryName;

    private Long isValid;

    public SurgeryData(final Long id,final  Long surId,final  String surgeryName,final  Long isValid
    ){
        this.id=id;

        this.surId=surId;

        this.surgeryName=surgeryName;

        this.isValid=isValid;

    }
    public static SurgeryData createNewInstance(final Long id,final Long surId,final  String surgeryName,final  Long isValid) {

        return new SurgeryData( id, surId, surgeryName, isValid);
    }
}
