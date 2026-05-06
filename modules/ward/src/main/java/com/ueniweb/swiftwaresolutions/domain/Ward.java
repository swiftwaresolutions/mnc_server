package com.ueniweb.swiftwaresolutions.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "Ward")
@Table(name = "ip_config_wards")
@Getter
@Setter
public class Ward {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "geo_location")
    private String geoLocation;

    @Column(name = "number_elements")
    private Integer numberElements;

    @Column(name = "number_occupied")
    private Integer numberOccupied;

    @Column(name = "price_id")
    private Long priceId;

    @Column(name = "is_aligned")
    private int isAligned;

    @Column(name = "avg_cost", columnDefinition="Decimal(10, 2) ")
    private Double avgCost;

    @Column(name = "number_patients")
    private Integer numberPatients;

    @Column(name = "admission_fee", columnDefinition="Decimal(10, 2) ")
    private Double admissionFee;

    @Column(name = "number_opbooks")
    private int numberOpBooks;

    @Column(name = "number_ipbooks")
    private int numberIpBooks;

    @Column(name = "is_blocked")
    private int isBlocked;

    @Column(name = "ward_type")
    private int wardType;

    @Column(name = "age_from")
    private int ageFrom;

    @Column(name = "age_to")
    private Integer ageTo;
}
