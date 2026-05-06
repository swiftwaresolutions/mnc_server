package com.ueniweb.swiftwaresolutions.data;

import lombok.Data;

@Data
public class PrescriptionData {

    private Long id;

    private Long prodsId;

    private String display;

    private String prodName;

    private String quantity;

    private String unit;

    private String timingName;

    private String prescriptionDuration;

    private String configDurationName;

    private String timingUnits;

    private Integer totalNo;

    private Integer isOwn;

    private String route;

    private String instruction;

    private String notes;



    public PrescriptionData(final Long id,final Long prodsId, final String display, final String prodName, final String quantity, final String unit,
                            final String timingName, final String prescriptionDuration, final String configDurationName,final String timingUnits,Integer totalNo,Integer isOwn,String route,String instruction,String notes) {
        this.id=id;
        this.prodsId=prodsId;
        this.display = display;
        this.prodName = prodName;
        this.quantity = quantity;
        this.unit = unit;
        this.timingName = timingName;
        this.prescriptionDuration = prescriptionDuration;
        this.configDurationName = configDurationName;
        this.timingUnits        = timingUnits;
        this.totalNo        = totalNo;
        this.isOwn        = isOwn;
        this.route        = route;
        this.instruction        = instruction;
        this.notes        = notes;
    }

    public static PrescriptionData createNewInstance(final Long id,Long prodsId,final String display, final String prodName, final String quantity, final String unit,
                                                     final String timingName, final String prescriptionDuration, final String configDurationName,String timingUnits,Integer totalNo,Integer isOwn,String route,String instruction,String notes) {
        return new PrescriptionData(id,prodsId, display, prodName, quantity, unit, timingName, prescriptionDuration, configDurationName,timingUnits,totalNo,isOwn,route,instruction,notes);
    }
}
