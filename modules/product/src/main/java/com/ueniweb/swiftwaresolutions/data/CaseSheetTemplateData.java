package com.ueniweb.swiftwaresolutions.data;

import lombok.Data;

@Data
public class CaseSheetTemplateData {

    private Integer id;

    private String templateName;

    private String templateDetails;


    public CaseSheetTemplateData(final Integer id, final String templateName,final String templateDetails) {
        this.id                 = id;
        this.templateName       = templateName;
        this.templateDetails    = templateDetails;
    }

    public static CaseSheetTemplateData createNewInstance(final Integer id, final String templateName,final String templateDetails) {
        return new CaseSheetTemplateData(id,templateName,templateDetails);
    }
}
