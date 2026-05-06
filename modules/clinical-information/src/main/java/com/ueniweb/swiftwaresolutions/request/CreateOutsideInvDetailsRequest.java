package com.ueniweb.swiftwaresolutions.request;

import lombok.Data;

@Data
public class CreateOutsideInvDetailsRequest {

    private Long deptId;

    private Long invId;

    private String findings;
}
