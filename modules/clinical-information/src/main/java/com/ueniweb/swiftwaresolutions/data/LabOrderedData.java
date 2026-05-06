package com.ueniweb.swiftwaresolutions.data;

import lombok.Data;

@Data
public class LabOrderedData {

    private Integer id;

    private Integer patId;

    private String testName;

    private Integer units;

    private String date;

    private Long rate;



    public LabOrderedData(Integer id,Integer patId,String testName,Integer units,String date,Long rate) {

        this.id   = id;
        this.patId = patId;
        this.testName= testName;
        this.units    = units;
        this.date  = date;
        this.rate  = rate;

    }
    public static LabOrderedData createNewInstance(Integer id,Integer patId,String testName,Integer units,String date,Long rate) {
        return new LabOrderedData(id,patId,testName,units,date,rate);
    }


}
