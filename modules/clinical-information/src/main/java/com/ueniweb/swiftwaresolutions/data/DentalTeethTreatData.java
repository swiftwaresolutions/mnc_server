package com.ueniweb.swiftwaresolutions.data;

import lombok.Data;

@Data
public class DentalTeethTreatData {

    private Integer id;

    private String  toothnum;

    private String teethdetails;

    private Integer teethType;

    public DentalTeethTreatData(Integer id, String toothnum, String teethdetails, Integer teethType) {
        this.id = id;
        this.toothnum = toothnum;
        this.teethdetails = teethdetails;
        this.teethType = teethType;
    }

    public static DentalTeethTreatData createNewInstance(final Integer id, final String toothnum, final String teethdetails, final Integer teethType) {
        return new DentalTeethTreatData(id,toothnum,teethdetails,teethType);
    }

}
