package com.ueniweb.swiftwaresolutions.data;

import lombok.Data;

@Data
public class ConsultantData {

    private Integer id;

    private String name;

    public ConsultantData(final Integer id, final String name) {
        this.id = id;
        this.name = name;
    }

    public static com.ueniweb.swiftwaresolutions.data.ConsultantData createNewInstance(final Integer id, final String name) {
        return new com.ueniweb.swiftwaresolutions.data.ConsultantData(id, name);
    }
}
