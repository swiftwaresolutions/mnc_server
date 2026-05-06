package com.ueniweb.swiftwaresolutions.data;

import lombok.Data;

@Data
public class OutsideLabPrevResultData {

    private Long display;

    private String labName;

    private String suggestDoc;

    private Long consultant;

    private String consultName;

    private String date;

    private String selDateTime;

    public OutsideLabPrevResultData(Long display, String labName, String suggestDoc, Long consultant, String consultName, String date, String selDateTime) {
        this.display     = display;
        this.labName     = labName;
        this.suggestDoc  = suggestDoc;
        this.consultant  = consultant;
        this.consultName = consultName;
        this.date        = date;
        this.selDateTime = selDateTime;
    }

    public static OutsideLabPrevResultData CreateNewInstance(final Long display, final String labName, final String suggestDoc, final Long consultant, final String consultName, final String date, final String selDateTime) {
        return new OutsideLabPrevResultData(display,labName,suggestDoc,consultant,consultName,date, selDateTime);
    }

}
