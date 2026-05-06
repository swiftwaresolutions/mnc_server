package com.ueniweb.swiftwaresolutions.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "Department")
@Table(name = "rec_config_msc_departments")
@Getter
@Setter
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    @Basic(optional = false)
    private String name;

    @Column(name = "is_active")
    private int isActive;
}
