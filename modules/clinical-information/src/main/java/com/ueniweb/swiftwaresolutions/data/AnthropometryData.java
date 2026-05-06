package com.ueniweb.swiftwaresolutions.data;

import lombok.Data;

@Data
public class AnthropometryData {

    private Long id;
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

    public AnthropometryData(Long id, Long patId, Long vstId, Long ipId, String visitDate,
                               Integer age,Integer headCircum,Integer height,Integer htWtAgePercentile,Integer weight,Integer wtAgePercentile,Integer htAgePercentile,Integer bmi,
                             Integer bmiAgePercentile,Integer isValid) {
        this.id = id;
        this.patId = patId;
        this.vstId = vstId;
        this.ipId = ipId;
        this.visitDate = visitDate;
        this.age = age;
        this.headCircum = headCircum;
        this.height = height;
        this.htWtAgePercentile = htWtAgePercentile;
        this.weight = weight;
        this.wtAgePercentile = wtAgePercentile;
        this.htAgePercentile = htAgePercentile;
        this.bmi = bmi;
        this.bmiAgePercentile = bmiAgePercentile;
        this.isValid = isValid;
    }

    public static AnthropometryData createNewInstance(Long id,Long patId,Long vstId,Long ipId,String visitDate,
                                                   Integer age,Integer headCircum,Integer height,Integer htWtAgePercentile,Integer weight,Integer wtAgePercentile,Integer htAgePercentile,Integer bmi,
                                                   Integer bmiAgePercentile,Integer isValid) {

        return new AnthropometryData(id, patId,vstId,ipId,visitDate,age,headCircum,height,
                htWtAgePercentile,weight,wtAgePercentile,htAgePercentile,bmi,bmiAgePercentile,isValid);
    }
}
