package com.ueniweb.swiftwaresolutions.data;

import lombok.Data;

@Data
public class OutsideLabResultDetailsData {

    private Long id;

    private Long labResEntId;

    private Long testId;

    private Long fieldId;

    private String result;

    private String notes;

    private Long isValid;

    public OutsideLabResultDetailsData(Long id, Long labResEntId, Long testId, Long fieldId, String result, String notes, Long isValid) {
        this.id = id;
        this.labResEntId = labResEntId;
        this.testId = testId;
        this.fieldId = fieldId;
        this.result = result;
        this.notes = notes;
        this.isValid = isValid;
    }

    public OutsideLabResultDetailsData createNewInstance(final Long id, final Long labResEntId, final Long testId, final Long fieldId, final String result, final String notes, final Long isValid) {

        return createNewInstance(id,labResEntId, testId, fieldId, result, notes, isValid);
    }
}
