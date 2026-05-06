package com.ueniweb.swiftwaresolutions.request;

import lombok.Data;

@Data
public class CreateOutsideLabResultDetailsRequest {

    private Long testId;

    private Long fldId;

    private String value;
}
