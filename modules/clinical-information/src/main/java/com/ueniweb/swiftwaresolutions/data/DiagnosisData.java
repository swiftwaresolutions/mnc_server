package com.ueniweb.swiftwaresolutions.data;

import lombok.Data;

@Data
public class DiagnosisData {

    private Integer id;

    private String name;

    public DiagnosisData(final Integer id, final String name) {
        this.id = id;
        this.name = name;
    }
    public static DiagnosisData createNewInstance(final Integer id, final String name) {
        return new DiagnosisData(id, name);
    }

}
