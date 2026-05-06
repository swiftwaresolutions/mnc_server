package com.ueniweb.swiftwaresolutions.data;

import lombok.Data;

@Data
public class OPVitalsData {

    private Long id;

    private Long patId;

    private Long vstId;

    private String temperature;

    private String pulse;

    private String rr;

    private String bp;

    private String spo2;

    private String height;

    private String weight;

    private String bmi;

    private String datetime;

    private String grbs;


    public OPVitalsData(final Long id,final Long patId, final Long vstId,final String temperature,final String pulse,final String rr,final String bp,final String spo2,final String height,final String weight,final String bmi,final String datetime, final String grbs) {
        this.id = id;
        this.patId = patId;
        this.vstId =vstId;
        this.temperature=temperature;
        this.pulse=pulse;
        this.rr=rr;
        this.bp=bp;
        this.spo2=spo2;
        this.height=height;
        this.weight=weight;
        this.bmi=bmi;
        this.datetime=datetime;
        this.grbs = grbs;
    }
    public static OPVitalsData createNewInstance(final Long id,final Long patId, final Long vstId,final String temperature,final String pulse,final String rr,final String bp,final String spo2,final String height,final String weight,final String bmi,final String datetime, final String grbs) {
        return new OPVitalsData(id,patId,vstId,temperature,pulse,rr,bp,spo2,height,weight,bmi,datetime,grbs);
    }
}
