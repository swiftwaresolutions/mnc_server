package com.ueniweb.swiftwaresolutions.request;

import com.ueniweb.swiftwaresolutions.utils.DateTimeUtils;
import lombok.Data;

import java.sql.Timestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

@Data
public class CreateLabOrderRequest {

    private Long orderId;

    private Long testId;

    private String testCode;

    private Long deptId;

    private Double rate;

    private Double disc;

    private Long resultDone;

    private String resultDate;

    private String  resultTime;

    private Long resultUid;

    private Long unit;

    private Long tempOrderId;

    private Long returnUnit;

    private Double fcRate;

    private Long patId;

    private Long vstId;

    private Long uid;

    private String dtm;

    private Long headId;

    private Long finalBillId;

}
