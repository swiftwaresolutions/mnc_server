package com.ueniweb.swiftwaresolutions.data;

import lombok.Data;
@Data
public class AldreteScoreChartData {

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


    public AldreteScoreChartData(  final Long id, final Long patId,final Long visitId,final Long ipId,final Long userId,final Long activity,final Long conscious,final Long respiration,final Long saturation,final String dtm) {

        this.id=id;
        this.patId=patId;
        this.visitId=visitId;
        this.ipId=ipId;
        this.userId=userId;
        this.activity=activity;
        this.conscious=conscious;
        this.respiration=respiration;
        this.saturation=saturation;
        this.dtm=dtm;
    }
    public static AldreteScoreChartData createNewInstance(final Long id, final Long patId,final Long visitId,final Long ipId,final Long userId,final Long activity,final Long conscious,final Long respiration,final Long saturation,final String dtm){
        return new AldreteScoreChartData(   id,  patId, visitId, ipId, userId, activity, conscious, respiration, saturation, dtm);
    }
}
