package com.ueniweb.swiftwaresolutions.domain;

import com.ueniweb.swiftwaresolutions.request.CreateImgInvUploadRequest;
import com.ueniweb.swiftwaresolutions.request.GeneralCaseSheetRequest;
import com.ueniweb.swiftwaresolutions.utils.DateTimeUtils;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity(name = "ImgInvUpload")
@Table(name = "cli_xray_images")
@Data
public class InvImgUpload {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pat_id",nullable = false)
    @Basic(optional = false)
    private Long patId;

    @Column(name = "visit_id",nullable = false)
    @Basic(optional = false)
    private Long vstId;

    @Column(name = "path")
    private String path;

    @Column(name = "imgName")
    private String imgName;

    @Column(name = "dtm")
    private String dateTime;

    @Column(name = "ent_uid")
    private Long consultantId;

    @Column(name = "block_date")
    private String blockDate;

    @Column(name = "otherInv")
    private String otherInv;

    @Column(name = "is_blocked")
    private int isBlocked;

    @Column(name = "blocked_uid")
    private Long blockedUid;

    @Column(name = "deptId")
    private Long deptId;

    @Column(name = "invId")
    private Long invId;

    @Column(name = "groupId")
    private Long groupId;

    @Column(name = "invDate")
    private String invDate;

    public static InvImgUpload to(final CreateImgInvUploadRequest createImgInvUploadRequest) {
        InvImgUpload invImgUpload = new InvImgUpload();

        invImgUpload.setPatId(createImgInvUploadRequest.getPatId());
        invImgUpload.setVstId(createImgInvUploadRequest.getVstId());
        invImgUpload.setPath("");
        invImgUpload.setImgName("-");
        invImgUpload.setDateTime(DateTimeUtils.convertLocalDateToDateTimeFormat(LocalDateTime.now()));
        invImgUpload.setConsultantId(createImgInvUploadRequest.getConsultantId());
        invImgUpload.setBlockDate("0000-00-00");
        invImgUpload.setInvDate(createImgInvUploadRequest.getInvDate());
        invImgUpload.setOtherInv(createImgInvUploadRequest.getOtherInv());
        invImgUpload.setIsBlocked(0);
        invImgUpload.setBlockedUid(0L);
        invImgUpload.setDeptId(0L);
        invImgUpload.setInvId(createImgInvUploadRequest.getInvId());
        invImgUpload.setGroupId(createImgInvUploadRequest.getGroupId());

        return invImgUpload;
    }

    public void update(final Long id, final Long blockedId, final CreateImgInvUploadRequest createImgInvUploadRequest){
        this.id = id;
        this.isBlocked  = 1;
        this.blockDate = DateTimeUtils.convertLocalDateToDateTimeFormat(LocalDateTime.now());
        this.blockedUid = blockedId;

    }
}
