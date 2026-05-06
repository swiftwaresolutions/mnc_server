package com.ueniweb.swiftwaresolutions.request;

import lombok.Data;

@Data
public class CreatePrescTemplateEditRequest {

    private Long id ;

    private String templateName;

    private Long editUid;

    private Long isValid;
}
