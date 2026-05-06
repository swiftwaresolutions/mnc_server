package com.ueniweb.swiftwaresolutions.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "Doctor")
@Table(name = "rec_config_msc_consultants")
@Getter
@Setter
public class Consultant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    @Basic(optional = false)
    private String name;

    @Column(name = "is_active")
    private int isActive;

    @Column(name = "uid")
    private Long uid;

    @Column(name = "details")
    private String details;

    @Column(name = "dept_id")
    private Long deptId;

    @Column(name = "is_cons")
    private int isCons;

    @Column(name = "consultant_room")
    private String consultantRoom;

    @Column(name = "consultant_HIN")
    private String consultantHIN;
}
