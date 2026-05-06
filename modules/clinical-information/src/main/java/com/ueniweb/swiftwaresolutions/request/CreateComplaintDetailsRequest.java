package com.ueniweb.swiftwaresolutions.request;

import lombok.Data;

@Data
public class CreateComplaintDetailsRequest {

    private Long patId;

    private Long vstId;

    private Long ipId;

    private Long caseSheetType;

    private Long caseSheetId;

    private Long complaintId;

    private Double number;

    private String period;

    private Long isValid;

    private String complaintName;

    @Override
    public String toString() {
        return "CreateComplaintDetailsRequest{" +
                "patId=" + patId +
                ", vstId=" + vstId +
                ", ipId=" + ipId +
                ", caseSheetType=" + caseSheetType +
                ", caseSheetId=" + caseSheetId +
                ", complaintId=" + complaintId +
                ", number=" + number +
                ", period=" + period +
                ", isValid=" + isValid +
                ", complaintName=" + complaintName +
                '}';
    }


}
