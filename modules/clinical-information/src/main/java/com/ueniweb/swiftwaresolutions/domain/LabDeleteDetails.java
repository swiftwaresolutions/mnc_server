package com.ueniweb.swiftwaresolutions.domain;

import com.ueniweb.swiftwaresolutions.request.CreateLabDeleteDetailsRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.util.Date;

@Entity(name="LabDeleteDetails")
@Table(name = "x_temp_lab_delete_details")
@Getter
@Setter
public class LabDeleteDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pat_id")
    private Long patId;

    @Column(name = "test_id")
    private Long testId;

    @Column(name = "order_date")
    private Date orderDate;

    @Column(name = "order_uid")
    private Long orderUid;

    @Column(name = "units", columnDefinition = "Decimal(10, 2)")
    private double units;

    @Column(name = "date")
    private Date date;

    @Column(name = "time")
    private Time time;

    @Column(name = "uid")
    private Long uid;

    public static LabDeleteDetails createNewInstance(CreateLabDeleteDetailsRequest createLabDeleteDetailsRequest) {
        LabDeleteDetails labDeleteDetails = new LabDeleteDetails();
        labDeleteDetails.setPatId(createLabDeleteDetailsRequest.getPatId());
        labDeleteDetails.setTestId(createLabDeleteDetailsRequest.getTestId());
        labDeleteDetails.setTime(createLabDeleteDetailsRequest.getTime());
        labDeleteDetails.setDate(createLabDeleteDetailsRequest.getDate());
        labDeleteDetails.setUnits(createLabDeleteDetailsRequest.getUnits());
        labDeleteDetails.setOrderDate(createLabDeleteDetailsRequest.getOrderDate());
        labDeleteDetails.setOrderUid(createLabDeleteDetailsRequest.getOrderUid());
        labDeleteDetails.setUid(createLabDeleteDetailsRequest.getUid());
        return labDeleteDetails;
    }
}
