package com.ueniweb.swiftwaresolutions.domain;

import com.ueniweb.swiftwaresolutions.request.CreateAnthropometryRequest;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity(name="Anthropometry")
@Table(name = "cli_patient_anthropometry_casesheet")
@Getter
@Setter
public class Anthropometry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "patId",nullable = false)
    @Basic(optional = false)
    private Long patId;

    @Column(name = "vstId",nullable = false)
    @Basic(optional = false)
    private Long vstId;

    @Column(name = "ipId")
    private Long ipId;

    @Column(name = "visit_date")
    private String visitDate;

    @Column(name = "age")
    private Integer age;

    @Column(name = "head_circum")
    private Integer headCircum;

    @Column(name = "height")
    private Integer height;

    @Column(name = "ht_wt_age_percentile")
    private Integer htWtAgePercentile;

    @Column(name = "weight")
    private Integer weight;

    @Column(name = "wt_age_percentile")
    private Integer wtAgePercentile;

    @Column(name = "ht_age_percentile")
    private Integer htAgePercentile;

    @Column(name = "bmi")
    private Integer bmi;

    @Column(name = "bmi_age_percentile")
    private Integer bmiAgePercentile;

    @Column(name = "is_valid")
    private Integer isValid;

    public static List<Anthropometry> to(final List<CreateAnthropometryRequest> anthropometryRequest){
        List<Anthropometry> anthropometryList = new ArrayList<>();
        for (CreateAnthropometryRequest anthropometryRequest1: anthropometryRequest) {
            anthropometryList.add(to(anthropometryRequest1));
        }
        return anthropometryList;
    }

    public static Anthropometry to(final CreateAnthropometryRequest anthropometryRequest){
        Anthropometry anthropometry = new Anthropometry();
        anthropometry.setPatId(anthropometryRequest.getPatId());
        anthropometry.setVstId(anthropometryRequest.getVstId());
        anthropometry.setIpId(anthropometryRequest.getIpId());
        anthropometry.setVisitDate(anthropometryRequest.getVisitDate());
        anthropometry.setAge(anthropometryRequest.getAge());
        anthropometry.setHeadCircum(anthropometryRequest.getHeadCircum());
        anthropometry.setHeight(anthropometryRequest.getHeight());
        anthropometry.setHtWtAgePercentile(anthropometryRequest.getHtWtAgePercentile());
        anthropometry.setWeight(anthropometryRequest.getWeight());
        anthropometry.setWtAgePercentile(anthropometryRequest.getWtAgePercentile());
        anthropometry.setHtAgePercentile(anthropometryRequest.getHtAgePercentile());
        anthropometry.setBmi(anthropometryRequest.getBmi());
        anthropometry.setBmiAgePercentile(anthropometryRequest.getBmiAgePercentile());
        anthropometry.setIsValid(anthropometryRequest.getIsValid());

        return anthropometry;
    }
}
