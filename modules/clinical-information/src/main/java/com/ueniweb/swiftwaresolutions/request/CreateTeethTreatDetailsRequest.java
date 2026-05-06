package com.ueniweb.swiftwaresolutions.request;

import lombok.Data;

@Data
public class CreateTeethTreatDetailsRequest {

    private Long patId;

    private Long vstId;

    private Long ipId;

    private Long caseSheetId;

    private String toothnum;

    private String teethdetails;

    private Long isValid;

    private Long teethType;

    @Override
    public String toString() {
        return "CreateTeethTreatDetailsRequest{" +
                "patId=" + patId +
                ",vstId=" + vstId +
                ",ipId=" + ipId +
                ",caseSheetId=" + caseSheetId +
                ",toothnum=" + toothnum +
                ",teethdetails=" + teethdetails +
                ",isValid=" + isValid +
                ",teethType=" + teethType +
                '}';
    }
}
