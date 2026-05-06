package com.ueniweb.swiftwaresolutions.request;

import lombok.Data;

@Data
public class CreateImgInvUploadRequest {

    private Long id;

    private Long patId;

    private Long vstId;

    private String path;

    private String imgName;

    private String invDate;

    private String otherInv;

    private Long consultantId;

    private Long blockedUid;

    private Long invId;

    private Long groupId;
}
