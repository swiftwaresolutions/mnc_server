package com.ueniweb.swiftwaresolutions.data;

import lombok.Data;

@Data
public class DisSumConsultantData {

    private Long id;

    private Integer summaryId;

    private Integer consultantId;

    private String name;

    public DisSumConsultantData(final Long id, final Integer summaryId, final Integer consultantId, final String name) {
        this.id = id;
        this.summaryId = summaryId;
        this.consultantId = consultantId;
        this.name   = name;
    }

    public static DisSumConsultantData createNewInstance(final Long id, final Integer summaryId, final Integer consultantId, final String name) {
        return new DisSumConsultantData(id,summaryId,consultantId,name);
    }
}
