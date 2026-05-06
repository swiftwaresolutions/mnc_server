package com.ueniweb.swiftwaresolutions.request;

import lombok.Data;

import java.util.List;

@Data
public class CreateOutsideLabResultRequest {

    private Long deptId;

    private Long testId;

    private String notes;

    private List<CreateOutsideLabResultDetailsRequest> createOutsideLabResultDetailsRequestList;
}
