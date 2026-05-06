package com.ueniweb.swiftwaresolutions.data;

import lombok.Data;

@Data
public class InvestigationOrderedData {

    private Integer id;

    private Integer patId;

    private String procName;

    private Integer units;

    private String date;

    private Long rate;

    public InvestigationOrderedData(Integer id,Integer patId,String procName,Integer units,String date,Long rate) {

        this.id   = id;
        this.patId = patId;
        this.procName= procName;
        this.units     = units;
        this.date  = date;
        this.rate  = rate;
    }
    public static InvestigationOrderedData createNewInstance(Integer id,Integer patId,String procName,Integer units,String date,Long rate) {
        return new InvestigationOrderedData(id,patId,procName,units,date,rate);
    }

}
