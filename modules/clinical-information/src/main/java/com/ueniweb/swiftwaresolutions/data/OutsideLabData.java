package com.ueniweb.swiftwaresolutions.data;

import lombok.Data;

@Data
public class OutsideLabData {

    private Long labId;

    private String labName;

    private String suggestDoc;

    private String selDate;

    private String specName;

    private String testName;

    private String value;

    private String unit;

    private String fieldName;

    private Long fieldId;

    public OutsideLabData(Long labId, String labName, String suggestDoc, String selDate, String specName, String testName, String value, String unit, String fieldName, Long fieldId) {
        this.labId = labId;
        this.labName = labName;
        this.suggestDoc = suggestDoc;
        this.selDate = selDate;
        this.specName = specName;
        this.testName = testName;
        this.value = value;
        this.unit = unit;
        this.fieldName = fieldName;
        this.fieldId = fieldId;
    }
    public static OutsideLabData createNewInstance(Long labId, String labName, String suggestDoc, String selDate, String specName, String testName, String value, String unit, String fieldName, Long fieldId) {
        return new OutsideLabData(labId,labName,suggestDoc,selDate, specName, testName, value, unit, fieldName, fieldId);
    }
}
