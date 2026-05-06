package com.ueniweb.swiftwaresolutions.data;

import lombok.Data;

@Data
public class OutsideLabResultData {

    private Long id;

    private Long labResId;

    private Long patId;

    private Long vstId;

    private Long ipId;

    private String labName;

    private Long consultantId;

    private String suggestDoc;

    private String entDateTime;

    private Long isValid;

    public OutsideLabResultData(final Long id, final Long labResId, final Long patId, final Long vstId, final Long ipId, final String labName,
                                final Long consultantId, final String suggestDoc, final String entDateTime, final Long isValid) {
        this.id = id;
        this.labResId = labResId;
        this.patId = patId;
        this.vstId = vstId;
        this.ipId = ipId;
        this.labName = labName;
        this.consultantId = consultantId;
        this.suggestDoc =  suggestDoc;
        this.entDateTime = entDateTime;
        this.isValid = isValid;
    }

    public static OutsideLabResultData createNewInstance(final Long id, final Long labResId, final Long patId, final Long vstId, final Long ipId, final String labName,
                                                  final Long consultantId, final String suggestDoc, final String entDateTime, final Long isValid) {
        return new OutsideLabResultData(id, labResId, patId, vstId, ipId, labName, consultantId, suggestDoc, entDateTime, isValid);
    }
}
