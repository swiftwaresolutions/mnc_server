package com.ueniweb.swiftwaresolutions.data;

import lombok.Data;

@Data
public class ImgInvData {

    private Long id;

    private Long patId;

    private Long vstId;

    private String imgName;

    private String path;

    private String dtm;

    private Long entUid;

    private String blockDate;

    private String invDate;

    private Boolean isBlocked;

    private Long blockedUid;

    private Boolean imgExist;

    private Long invId;

    private Long groupId;

    private String invName;

    private String otherInv;

    public ImgInvData(Long id, Long patId, Long vstId, String imgName, String path, String dtm, Long entUid,
                      String blockDate, String invDate, String otherInv, Boolean isBlocked, Long blockedUid, Boolean imgExist, Long invId,Long groupId, String invName) {
        this.id = id;
        this.patId = patId;
        this.vstId = vstId;
        this.imgName = imgName;
        this.path = path;
        this.dtm = dtm;
        this.entUid = entUid;
        this.blockDate = blockDate;
        this.invDate = invDate;
        this.isBlocked = isBlocked;
        this.blockedUid = blockedUid;
        this.imgExist = imgExist;
        this.invId = invId;
        this.groupId = groupId;
        this.invName = invName;
        this.otherInv = otherInv;
    }

    public static ImgInvData createNewInstance(Long id, Long patId, Long vstId, String imgName, String path, String dtm, Long entUid,
                                               String blockDate, String invDate, String otherInv, Boolean isBlocked, Long blockedUid, Boolean imgExist, Long invId,Long groupId,String invName) {
        return new ImgInvData(id, patId, vstId, imgName, path, dtm, entUid, blockDate, invDate, otherInv, isBlocked, blockedUid, imgExist, invId, groupId, invName);
    }
}
