package com.ueniweb.swiftwaresolutions.data;

import lombok.Data;

@Data
public class LabTestNameData {

    private String deptCode;

    private Integer id;

    private String name;

    private String code;

    private Double rate;

    private Double charity;

    private String label;

    private String name1;



    public LabTestNameData(String deptCode, Integer id,String name,String code,Double rate,Double charity,String label, String name1) {

        this.deptCode = deptCode;
        this.id   = id;
        this.name = name;
        this.code= code;
        this.rate     = rate;
        this.charity  = charity;
        this.label    = label;
        this.name1 = name1;

    }
    public static LabTestNameData createNewInstance(String deptCode,Integer id,String name,String code,Double rate,Double charity,String label,String name1) {
        return new LabTestNameData(deptCode,id,name,code,rate,charity,label,name1);
    }
}
