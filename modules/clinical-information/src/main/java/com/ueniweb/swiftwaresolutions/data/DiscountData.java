package com.ueniweb.swiftwaresolutions.data;

import lombok.Data;

@Data
public class DiscountData {

    private Integer id;

    private Integer patId;

    private String datetime;

    private Double discAmt;

    public DiscountData(Integer id, Integer patId, String datetime, Double discAmt) {
        this.id = id;
        this.patId = patId;
        this.datetime = datetime;
        this.discAmt = discAmt;
    }

    public static DiscountData createNewInstance(Integer id, Integer patId, String datetime, Double discAmt) {
        return new DiscountData(id,patId,datetime,discAmt);
    }
}
