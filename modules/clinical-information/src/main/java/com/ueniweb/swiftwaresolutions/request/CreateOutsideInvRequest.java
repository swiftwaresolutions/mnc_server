package com.ueniweb.swiftwaresolutions.request;

import lombok.Data;

import java.util.List;

@Data
public class CreateOutsideInvRequest {

    private Long display;

    private Long patId;

    private Long vstId;

    private Long ipId;

    private String labName;

    private Long consultantId;

    private String SuggestDoc;

    private String selDateTime;

    private Long type;

    private List<CreateOutsideInvDetailsRequest> createOutsideInvDetailsRequestList;
}
