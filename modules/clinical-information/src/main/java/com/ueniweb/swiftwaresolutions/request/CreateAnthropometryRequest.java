package com.ueniweb.swiftwaresolutions.request;

import lombok.Data;

@Data
public class CreateAnthropometryRequest {

    private Long patId;

    private Long vstId;

    private Long ipId;

    private String visitDate;

    private Integer age;

    private Integer headCircum;

    private Integer height;

    private Integer htWtAgePercentile;

    private Integer weight;

    private Integer wtAgePercentile;

    private Integer htAgePercentile;

    private Integer bmi;

    private Integer bmiAgePercentile;

    private Integer isValid;


    @Override
    public String toString() {
        return "CreateAnthropometryRequest{" +
                "patId=" + patId +
                ", vstId=" + vstId +
                ", ipId=" + ipId +
                ", visitDate='" + visitDate  +
                ", age=" + age +
                ", headCircum=" + headCircum +
                ", height=" + height +
                ", htWtAgePercentile=" + htWtAgePercentile +
                ", weight=" + weight +
                ", wtAgePercentile=" + wtAgePercentile +
                ", htAgePercentile=" + htAgePercentile +
                ", bmi=" + bmi +
                ", bmiAgePercentile=" + bmiAgePercentile +
                ", isValid=" + isValid +
                '}';
    }


}
