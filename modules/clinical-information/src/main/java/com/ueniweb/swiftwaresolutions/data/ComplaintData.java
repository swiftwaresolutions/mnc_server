package com.ueniweb.swiftwaresolutions.data;

import lombok.Data;

@Data
public class ComplaintData {

    private Integer id;

    private String name;

    public ComplaintData(final Integer id, final String name) {
        this.id = id;
        this.name = name;
    }

    public static ComplaintData createNewInstance(final Integer id, final String name) {
        return new ComplaintData(id, name);
    }


}
