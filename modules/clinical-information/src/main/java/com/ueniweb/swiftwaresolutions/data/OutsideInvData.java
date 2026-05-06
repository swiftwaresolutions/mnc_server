package com.ueniweb.swiftwaresolutions.data;

import lombok.Data;

@Data
public class OutsideInvData {

    private Long invNo;

    private String labName;

    private String suggestDoc;

    private String invDate;

    private String invName;

    private String findings;

    public OutsideInvData(Long invNo, String labName, String suggestDoc, String invDate, String invName, String findings) {
        this.invNo = invNo;
        this.labName = labName;
        this.suggestDoc = suggestDoc;
        this.invDate = invDate;
        this.invName = invName;
        this.findings = findings;
    }

    public static  OutsideInvData createNewInstance(Long invNo, String labName, String suggestDoc, String invDate, String invName, String findings) {
        return new OutsideInvData(invNo, labName, suggestDoc, invDate, invName, findings);
    }
}
