package com.ueniweb.swiftwaresolutions.request;

import lombok.Data;

@Data
public class CreatePrescTemplateDetailsRequest {

    private Long templateId;

    private Long genericId;

    private Long prodsId;

    private double quantity;

    private double unit;

    private double no;

    private Long timing;

    private Long duration;

    private Long period;

    private Long route;

    private Long instruction;

    private String timingUnit;

    private Long extra1;

    private Long extra2;

    private Long extra3;

    private Long extra4;

    private Long extra5;

    @Override
    public String toString() {
        return "CreatePrescTemplateDetailsRequest{" +
                "templateId=" + templateId +
                ", genericId=" + genericId +
                ", prodsId=" + prodsId +
                ", quantity=" + quantity +
                ", unit=" + unit +
                ", no=" + no +
                ", timing=" + timing +
                ", duration=" + duration +
                ", period=" + period +
                ", route=" + route +
                ", instruction=" + instruction +
                ", timingUnit=" + timingUnit +
                ", extra1=" + extra1 +
                ", extra2=" + extra2 +
                ", extra3=" + extra3 +
                ", extra4=" + extra4 +
                ", extra5=" + extra5 +
                '}';
    }


}
