package com.ueniweb.swiftwaresolutions.request;

import lombok.Data;

@Data
public class CreateCaseSheetTemplateRequest {

    private Long caseSheetType;

    private Long templateFieldId;

    private String templateName;

    private String templateDetails;

    private Long docId;

}
