package com.ueniweb.swiftwaresolutions.request;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import lombok.Data;

import java.util.List;

@Data
public class CreateLabAndInvSummaryRequest {

    private Long summaryId;

    private String procName;

    private String procDate;

    private String report;

    private String date;

    private String time;

    private Long uid;

    private Long isActive;

    @Override
    public String toString() {
        return "CreateLabAndInvSummaryRequest{" +
                "summaryId=" + summaryId +
                ", procName='" + procName + '\'' +
                ", procDate='" + procDate + '\'' +
                ", report='" + report + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", uid=" + uid +
                ", isActive=" + isActive +
                '}';
    }

}
