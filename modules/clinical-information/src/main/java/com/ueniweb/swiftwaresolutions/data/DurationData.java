package com.ueniweb.swiftwaresolutions.data;

import lombok.Data;

@Data
public class DurationData {

    private Integer id;

    private String name;

    private Integer days;

    public DurationData(final Integer id, final String name,final Integer days) {
        this.id     = id;
        this.name   = name;
        this.days   = days;
    }

    public static com.ueniweb.swiftwaresolutions.data.DurationData createNewInstance(final Integer id, final String name,final Integer days) {
        return new com.ueniweb.swiftwaresolutions.data.DurationData(id,name,days);
    }
}
