package com.ueniweb.swiftwaresolutions.request;

import lombok.Data;

import java.sql.Time;
import java.util.Date;

@Data
public class CreateLabDeleteDetailsRequest {

    private Long patId;

    private Long testId;

    private Date orderDate;

    private Long orderUid;

    private double units;

    private Date date;

    private Time time;

    private Long uid;
}
