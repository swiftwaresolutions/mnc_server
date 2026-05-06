package com.ueniweb.swiftwaresolutions.data;

import lombok.Data;

@Data
public class UnitData {

    private Integer id;

    private String name;

    private Integer typeId;

    public UnitData(final Integer id, final String name,final Integer typeId) {
        this.id     = id;
        this.name   = name;
        this.typeId = typeId;
    }

    public static com.ueniweb.swiftwaresolutions.data.UnitData createNewInstance(final Integer id, final String name,final Integer typeId) {
        return new com.ueniweb.swiftwaresolutions.data.UnitData(id,name,typeId);
    }
}
