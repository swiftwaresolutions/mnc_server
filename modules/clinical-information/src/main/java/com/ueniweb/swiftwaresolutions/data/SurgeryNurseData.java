package com.ueniweb.swiftwaresolutions.data;
import com.ueniweb.swiftwaresolutions.request.CreateSurigicalNurseRequest;
import com.ueniweb.swiftwaresolutions.request.CreateSurigicalSurgonRequest;
import jakarta.persistence.Column;
import lombok.Data;

import java.util.List;
@Data
public class SurgeryNurseData {

    private Long id;

    private Long surId;

    private String nurse;

    private Long isAssNurse;

    private Long isValid;

    public SurgeryNurseData(final Long id,final Long surId,final  String nurse,final  Long isAssNurse,final  Long isValid
    ){
        this.id=id;

        this.surId=surId;

        this.nurse=nurse;

        this.isAssNurse=isAssNurse;

        this.isValid=isValid;


    }
    public static SurgeryNurseData createNewInstance(final Long id,final Long surId,final String nurse,final Long isAssNurse,final Long isValid) {

        return new SurgeryNurseData( id, surId, nurse, isAssNurse , isValid);
    }
}
