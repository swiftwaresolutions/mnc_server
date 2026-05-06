package com.ueniweb.swiftwaresolutions.data;

import lombok.Data;

@Data
public class DentalTeethData {

    private Integer id;

    private String  toothnum;

    private String teethdetails;

    private Integer teethType;

    public DentalTeethData(Integer id, String toothnum, String teethdetails, Integer teethType) {
        this.id = id;
        this.toothnum = toothnum;
        this.teethdetails = teethdetails;
        this.teethType = teethType;
    }

    public static DentalTeethData createNewInstance(final Integer id, final String toothnum, final String teethdetails, final Integer teethType) {
        return new DentalTeethData(id,toothnum,teethdetails,teethType);
    }

}
