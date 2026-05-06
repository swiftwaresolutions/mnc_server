package com.ueniweb.swiftwaresolutions.data;

import lombok.Data;

@Data
public class LabDepartmentData {

    private Integer id;

    private String name;

    public LabDepartmentData(final Integer id, final String name) {
        this.id = id;
        this.name = name;
    }
    public static LabDepartmentData createNewInstance(final Integer id, final String name) {
        return new LabDepartmentData(id, name);
    }
}
