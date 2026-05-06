package com.ueniweb.swiftwaresolutions.data;

import lombok.Data;

@Data
public class OutsideInvPrevDetailsData {

    private String deptName;

    private String invName;

    private String findings;

    private Long deptId;

    private Long invId;

    public OutsideInvPrevDetailsData(String deptName, String invName, String findings, Long deptId, Long invId) {
        this.deptName = deptName;
        this.invName = invName;
        this.findings = findings;
        this.deptId = deptId;
        this.invId = invId;
    }

    public static OutsideInvPrevDetailsData createNewInstance(String deptName, String invName, String findings, Long deptId, Long invId) {
        return new OutsideInvPrevDetailsData(deptName, invName, findings, deptId, invId);
    }
}
