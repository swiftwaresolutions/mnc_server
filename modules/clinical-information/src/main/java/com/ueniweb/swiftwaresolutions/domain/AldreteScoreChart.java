package com.ueniweb.swiftwaresolutions.domain;

import com.ueniweb.swiftwaresolutions.request.CreateAldreteScoreChartReuest;
import com.ueniweb.swiftwaresolutions.request.CreateNursingIoReuest;

import com.ueniweb.swiftwaresolutions.request.CreateOPVitalsRequest;
import com.ueniweb.swiftwaresolutions.request.CreateSurgeryChecklistReuest;
import com.ueniweb.swiftwaresolutions.utils.DateTimeUtils;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity(name="AldreteScoreChart")
@Table(name = "cli_ot_scorechart")
@Data
public class AldreteScoreChart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "patId", nullable = false)
    @Basic(optional = false)
    private Long patId;

    @Column(name = "visitId", nullable = false)
    @Basic(optional = false)
    private Long visitId;

    @Column(name = "ipId",nullable = false)
    @Basic(optional = false)
    private Long ipId;

    @Column(name = "userId",nullable = false)
    @Basic(optional = false)
    private Long userId;

    @Column(name = "activity",nullable = false)
    @Basic(optional = false)
    private Long activity;

    @Column(name = "conscious",nullable = false)
    @Basic(optional = false)
    private Long conscious;

    @Column(name = "respiration",nullable = false)
    @Basic(optional = false)
    private Long respiration;

    @Column(name = "saturation",nullable = false)
    @Basic(optional = false)
    private Long saturation;

    @Column(name = "dtm")
    @Basic(optional = false)
    private String dtm;


    public static AldreteScoreChart to(final CreateAldreteScoreChartReuest createAldreteScoreChartReuest){

        AldreteScoreChart aldreteScoreChart = new AldreteScoreChart();
        aldreteScoreChart.setPatId(createAldreteScoreChartReuest.getPatId());
        aldreteScoreChart.setVisitId(createAldreteScoreChartReuest.getVisitId());
        aldreteScoreChart.setIpId(createAldreteScoreChartReuest.getIpId());
        aldreteScoreChart.setUserId(createAldreteScoreChartReuest.getUserId());
        aldreteScoreChart.setConscious(createAldreteScoreChartReuest.getConscious());
        aldreteScoreChart.setActivity(createAldreteScoreChartReuest.getActivity());
        aldreteScoreChart.setRespiration(createAldreteScoreChartReuest.getRespiration());
        aldreteScoreChart.setSaturation(createAldreteScoreChartReuest.getSaturation());
        aldreteScoreChart.setDtm(createAldreteScoreChartReuest.getDtm());

        return aldreteScoreChart;
    }
    public void update(final CreateAldreteScoreChartReuest createAldreteScoreChartReuest){

        this.setPatId(createAldreteScoreChartReuest.getPatId());
        this.setVisitId(createAldreteScoreChartReuest.getVisitId());
        this.setIpId(createAldreteScoreChartReuest.getIpId());
        this.setUserId(createAldreteScoreChartReuest.getUserId());
        this.setConscious(createAldreteScoreChartReuest.getConscious());
        this.setActivity(createAldreteScoreChartReuest.getActivity());
        this.setRespiration(createAldreteScoreChartReuest.getRespiration());
        this.setSaturation(createAldreteScoreChartReuest.getSaturation());
        this.setDtm(DateTimeUtils.convertLocalDateToDateTimeFormat(LocalDateTime.now()));

    }
}
