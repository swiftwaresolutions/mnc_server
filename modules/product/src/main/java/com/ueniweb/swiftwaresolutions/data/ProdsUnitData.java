package com.ueniweb.swiftwaresolutions.data;

import lombok.Data;

@Data
public class ProdsUnitData {

    private String units;


    public ProdsUnitData(String units) {

        this.units       = units;
    }

    public static ProdsUnitData createNewInstance(String units) {
        return new ProdsUnitData(units);
    }
}
