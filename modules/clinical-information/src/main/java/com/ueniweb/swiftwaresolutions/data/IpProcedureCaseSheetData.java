package com.ueniweb.swiftwaresolutions.data;

import lombok.Data;

@Data
public class IpProcedureCaseSheetData {

    private Long id;

    private Long patId;

    private Long vstId;

    private Long ipId;

    private Long consultantId;

    private String date;

    private String time;

    private String temperature;

    private String pulse;

    private String rr;

    private String bp;

    private String spo2;

    private String height;

    private String weight;

    private String bmi;

    private String progressNotes;

    private String progressPlan;

    private Long isCancelled;

    public IpProcedureCaseSheetData(Long id, Long patId, Long vstId, Long ipId, Long consultantId, String date, String time,
                                    String temperature, String pulse, String rr, String bp, String spo2, String height,
                                    String weight, String bmi, String progressNotes, String progressPlan, Long isCancelled){

        this.id            = id;
        this.patId         = patId;
        this.vstId         = vstId;
        this.ipId          = ipId;
        this.consultantId  = consultantId;
        this.date          = date;
        this.time          = time;
        this.temperature   = temperature;
        this.pulse         = pulse;
        this.rr            = rr;
        this.bp            = bp;
        this.spo2          = spo2;
        this.height        = height;
        this.weight        = weight;
        this.bmi           = bmi;
        this.progressNotes = progressNotes;
        this.progressPlan  = progressPlan;
        this.isCancelled   = isCancelled;
    }

    public static IpProcedureCaseSheetData newInstance(Long id, Long patId, Long vstId, Long ipId, Long consultantId, String date, String time,
                                                       String temperature, String pulse,String rr, String bp, String spo2, String height,
                                                       String weight, String bmi, String progressNotes, String progressPlan, Long isCancelled){

        return new IpProcedureCaseSheetData(id, patId, vstId, ipId, consultantId, date, time, temperature, pulse, rr, bp, spo2, height,
                weight, bmi, progressNotes, progressPlan, isCancelled);
    }
}
