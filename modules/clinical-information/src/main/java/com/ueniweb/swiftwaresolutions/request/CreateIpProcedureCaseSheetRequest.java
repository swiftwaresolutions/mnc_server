package com.ueniweb.swiftwaresolutions.request;

import lombok.Data;

@Data
public class CreateIpProcedureCaseSheetRequest {

    private Long patientId;

    private Long visitId;

    private Long ipId;

    private Long consultantId;

    private String date;

    private String time;

    private String temperature;

    private String pulse;

    private String rr;

    private String bp;

    private String spo2;

    private String height;

    private String weight;

    private String bmi;

    private String progressNotes;

    private String progressPlan;

    private Long isCancelled;

    @Override
    public String toString() {
        return "CreateIpProcedureCaseSheetRequest{" +
                "patientId=" + patientId +
                ", visitId=" + visitId +
                ", ipId=" + ipId +
                ", consultantId=" + consultantId +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", temperature='" + temperature + '\'' +
                ", pulse='" + pulse + '\'' +
                ", rr='" + rr + '\'' +
                ", bp='" + bp + '\'' +
                ", spo2='" + spo2 + '\'' +
                ", height='" + height + '\'' +
                ", weight='" + weight + '\'' +
                ", bmi='" + bmi + '\'' +
                ", progressNotes='" + progressNotes + '\'' +
                ", progressPlan='" + progressPlan + '\'' +
                ", isCancelled=" + isCancelled +
                '}';
    }
}
