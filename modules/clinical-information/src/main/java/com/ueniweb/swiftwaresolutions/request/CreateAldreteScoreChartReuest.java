package com.ueniweb.swiftwaresolutions.request;

import lombok.Data;

@Data
public class CreateAldreteScoreChartReuest {

    private Long id;

    private Long patId;

    private Long visitId;

    private Long ipId;

    private Long userId;

    private Long activity;

    private Long conscious;

    private Long respiration;

    private Long saturation;

    private String dtm;

    @Override
    public String toString() {
        return "CreateAldreteScoreChartReuest{" +
                "id=" + id +
                ", patId=" + patId +
                ", visitId=" + visitId +
                ", ipId=" + ipId +
                ", userId=" + userId +
                ", activity=" + activity +
                ", conscious=" + conscious +
                ", respiration=" + respiration +
                ", saturation=" + saturation +
                ", dtm='" + dtm + '\'' +
                '}';
    }


}
