package com.ueniweb.swiftwaresolutions.data;

import lombok.Data;

@Data
public class PrescTemplateDetailsData {


    private Long genId;

    private String genName;

    private Long id;

    private String medName;

    private Long formType;

    private String unit;

    private Long unitId;

    private Integer medStrength;

    private Integer medQuantity;

    private Integer stock;

    private String timing;

    private Long timingId;

    private Long quantity;

    private Double duration;

    private String period;

    private Long periodId;

    private Double no;

    private Double mrpPrice;

    private String timingUnit;

    private String route;

    private int routeId;

    private String instruction;

    private int instructionId;


    public PrescTemplateDetailsData(Long genId,String genName,Long id,String medName,Long formType, String unit, Long unitId, Integer medStrength, Integer medQuantity, Integer stock, String timing, Long timingId, Long quantity, Double duration, String period, Long periodId, Double no,Double mrpPrice,String timingUnit,int routeId,String route,int instructionId,String instruction) {

        this.genId          = genId;
        this.genName        = genName;
        this.id             =id;
        this.medName        = medName;
        this.formType       = formType;
        this.unit           = unit;
        this.unitId         = unitId;
        this.medStrength    = medStrength;
        this.medQuantity    = medQuantity;
        this.stock          = stock;
        this.timing         = timing;
        this.timingId       = timingId;
        this.quantity       = quantity;
        this.duration       = duration;
        this.period         = period;
        this.periodId       = periodId;
        this.no             = no;
        this.mrpPrice       = mrpPrice;
        this.timingUnit    = timingUnit;
        this.route    = route;
        this.routeId    = routeId;
        this.instruction    = instruction;
        this.instructionId    = instructionId;

    }
    public static PrescTemplateDetailsData createNewInstance(Long genId,String genName,Long id,String medName,Long formType, String unit, Long unitId, Integer medStrength, Integer medQuantity, Integer stock, String timing, Long timingId, Long quantity, Double duration, String period, Long periodId,Double no,Double mrpPrice,String timingUnit,int routeId,String route,int instructionId,String instruction) {
        return new PrescTemplateDetailsData(genId,genName,id,medName,formType,unit,unitId,medStrength,medQuantity,stock,timing,timingId,quantity,duration,period,periodId,no,mrpPrice,timingUnit,routeId,route,instructionId,instruction);
    }
}
