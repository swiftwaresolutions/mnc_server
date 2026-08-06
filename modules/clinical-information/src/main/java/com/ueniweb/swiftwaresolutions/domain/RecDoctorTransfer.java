package com.ueniweb.swiftwaresolutions.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@Entity
@Table(name = "rec_doctor_transfer")
public class RecDoctorTransfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pat_id")
    private Long patId;

    @Column(name = "vst_id")
    private Long vstId;

//    @Column(name = "ip_id")
//    private Long ipId;

    @Column(name = "from_doc")
    private Long fromDoc;

    @Column(name = "to_doc")
    private Long toDoc;

    @Column(name = "ent_uid")
    private Long entUid;

    @Column(name = "edit_uid" , insertable = false)
    private Long editUid;

    @Column(name = "block_uid", insertable = false)
    private Long blockUid;

    @Column(name = "ent_dateTime")
    private LocalDateTime entDateTime;

    @Column(name = "edit_dateTime", insertable = false)
    private LocalDateTime editDateTime;

    @Column(name = "block_dateTime", insertable = false)
    private LocalDateTime blockDateTime;

    @Column(name = "is_cancelled")
    private Boolean isCancelled;

    @Column(name = "sys_ip")
    private String systemIp;

    @Column(name = "is_completed")
    private int isCompleted;

    @Column(name = "next_review")
    private String nextReview;

    @Column(name = "doctor_token")
    private int doctorToken;

    @Column(name = "is_doctor_viewing")
    private int isDoctorViewing;

}
