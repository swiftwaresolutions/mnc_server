package com.ueniweb.swiftwaresolutions.data;

import lombok.Data;

@Data
public class InvDepartmentData {

    private Integer id;

    private String name;

    public InvDepartmentData(final Integer id, final String name) {
        this.id = id;
        this.name = name;
    }
    public static InvDepartmentData createNewInstance(final Integer id, final String name) {
        return new InvDepartmentData(id, name);
    }
}
