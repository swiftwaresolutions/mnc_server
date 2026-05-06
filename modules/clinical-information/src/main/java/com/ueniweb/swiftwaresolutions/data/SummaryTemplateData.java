package com.ueniweb.swiftwaresolutions.data;

import lombok.Data;

@Data
public class SummaryTemplateData {

    private Integer id;

    private String templateName;

    private String details;

    public SummaryTemplateData(final Integer id, final String templateName ,final String details) {
        this.id             = id;
        this.templateName   = templateName;
        this.details        = details;
    }

    public static SummaryTemplateData createNewInstance(final Integer id, final String templateName ,final String details) {
        return new SummaryTemplateData(id,templateName,details);
    }
}
