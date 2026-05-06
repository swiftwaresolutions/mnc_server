package com.ueniweb.swiftwaresolutions.data;

import lombok.Data;

@Data
public class TemplateData {

    private Integer id;

    private String templateName;

    public TemplateData(final Integer id, final String templateName) {
        this.id             = id;
        this.templateName   = templateName;
    }

    public static TemplateData createNewInstance(final Integer id, final String templateName) {
        return new TemplateData(id,templateName);
    }
}
