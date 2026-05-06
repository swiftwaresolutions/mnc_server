package com.ueniweb.swiftwaresolutions.data;

import lombok.Data;

@Data
public class ComplaintDetailsData {

    private Integer id;

    private String  name;

    private Double no;

    private String periods;

    public ComplaintDetailsData(final Integer id, final String name,final Double no,final String periods) {
        this.id = id;
        this.name = name;
        this.no     = no;
        this.periods    = periods;
    }

    public static ComplaintDetailsData createNewInstance(final Integer id, final String name,final Double no,final String periods) {
        return new ComplaintDetailsData(id,name,no,periods);
    }

}
