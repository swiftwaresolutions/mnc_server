package com.ueniweb.swiftwaresolutions.data;

import lombok.Data;

@Data
public class OutsideLabPrevResultDetailsData {

    private String deptName;

    private String testName;

    private String notes;

    private String fieldName;

    private String value;

    private Long deptId;

    private Long testId;

    private Long fldId;

    private String unit;

    private String lowerValue;

    private String upperValue;

    public OutsideLabPrevResultDetailsData(String deptName, String testName, String notes, String fieldName,
                                           String value, Long deptId, Long testId, Long fldId, String unit, String lowerValue, String upperValue) {
        this.deptName = deptName;
        this.testName = testName;
        this.notes = notes;
        this.fieldName = fieldName;
        this.value = value;
        this.deptId = deptId;
        this.testId = testId;
        this.fldId = fldId;
        this.unit = unit;
        this.lowerValue = lowerValue;
        this.upperValue = upperValue;
    }

    public static OutsideLabPrevResultDetailsData CreateNewInstance(String deptName, String testName, String notes, String fieldName,
                                                                    String value, Long deptId, Long testId, Long fldId, String unit, String lowerValue, String upperValue) {
        return new OutsideLabPrevResultDetailsData(deptName, testName, notes, fieldName, value, deptId, testId, fldId, unit, lowerValue, upperValue);
    }
}
