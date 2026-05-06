package com.ueniweb.swiftwaresolutions.data;

import lombok.Data;

@Data
public class InvestigationData {

    private Integer groupId;

    private Integer id;

    private boolean isEditable;

    private String name1;

    private String name;

    private Double rate;

    private Double charity;

    private String label;

    // Constructor
    public InvestigationData(Integer groupId, Integer id, boolean isEditable, String name1, String name, Double rate, Double charity,String label) {
        this.groupId = groupId;
        this.id = id;
        this.isEditable = isEditable;
        this.name1 = name1;
        this.name = name;
        this.rate = rate;
        this.charity = charity;
        this.label  = label;
    }

    public static InvestigationData createNewInstance(Integer groupId, Integer id, boolean isEditable, String name1, String name, Double rate, Double charity,String label) {
        return new InvestigationData(groupId, id, isEditable, name1, name, rate, charity,label);
    }
}
