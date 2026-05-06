package com.ueniweb.swiftwaresolutions.data;

import lombok.Data;

@Data
public class DischargeLabInvSummaryData {

    private Integer id;

    private Integer summaryId;

    private String procName;

    private String procDate;

    private String report;

    private String date;

    private String time;

    private Integer uid;

    private Integer isActive;

    public DischargeLabInvSummaryData(final Integer id, final Integer summaryId, final String procName, final String procDate,
                                  final String report, final String date, final String time , final  Integer uid ,final Integer isActive) {
        this.id = id;
        this.summaryId = summaryId;
        this.procName = procName;
        this.procDate = procDate;
        this.report = report;
        this.date     = date;
        this.time     = time;
        this.uid    = uid;
        this.isActive    = isActive;
    }

    public static DischargeLabInvSummaryData createNewInstance(final Integer id, final Integer summaryId,final String procName,final String procDate,
                                                           final String report, final String date, final String time, final Integer uid ,final Integer isActive) {
        return new DischargeLabInvSummaryData(id,summaryId,procName,procDate,report,date,time,uid,isActive);
    }

}
