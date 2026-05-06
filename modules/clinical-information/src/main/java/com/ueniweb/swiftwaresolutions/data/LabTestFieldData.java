package com.ueniweb.swiftwaresolutions.data;

import lombok.Data;

@Data
public class LabTestFieldData {

    private Integer fieldId;

    private String fieldName;

    private Integer fieldType;

    private String unit;

    private String line;

    public LabTestFieldData(Integer fieldId, String fieldName, Integer fieldType, String unit, String line) {
        this.fieldId = fieldId;
        this.fieldName = fieldName;
        this.fieldType = fieldType;
        this.unit = unit;
        this.line = line;
    }

    public static LabTestFieldData createNewInstance(Integer fieldId, String fieldName, Integer fieldType, String unit, String line) {
        return new LabTestFieldData(fieldId, fieldName, fieldType, unit, line);
    }
}
