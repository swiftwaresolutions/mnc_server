package com.ueniweb.swiftwaresolutions.data;

import lombok.Data;

@Data
public class LabResultData {

    private String date;

    private String specName;

    private String testName;

    private String value;

    private String unit;

    private String fieldName;

    private Long normalPatId;

    private Long deptAutoId;

    private Long fieldId;

    public LabResultData(String date, String specName, String testName, String value, String unit, String fieldName, Long normalpatId, Long deptAutoid, Long fieldId) {
        this.date = date;
        this.specName = specName;
        this.testName = testName;
        this.value = value;
        this.unit = unit;
        this.fieldName = fieldName;
        this.normalPatId = normalpatId;
        this.deptAutoId = deptAutoid;
        this.fieldId = fieldId;
    }
    public static LabResultData createNewInstance(String date, String specName, String testName, String value, String unit, String fieldName, Long normalpatId, Long deptAutoid, Long fieldId) {
        return new LabResultData(date, specName, testName, value, unit, fieldName, normalpatId, deptAutoid, fieldId);
    }
}
