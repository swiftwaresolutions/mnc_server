package com.ueniweb.swiftwaresolutions.domain;

import com.ueniweb.swiftwaresolutions.request.CreateOrderDiscountRequest;
import com.ueniweb.swiftwaresolutions.utils.DateTimeUtils;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity(name="OrderDiscount")
@Table(name = "x_temp_inv_lab_disc")
@Getter
@Setter
public class OrderDiscount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pat_id",nullable = false)
    @Basic(optional = false)
    private Long patId;

    @Column(name = "uid")
    private Long uid;

    @Column(name = "datetime")
    private String datetime;

    @Column(name = "disc_amt",nullable = false)
    @Basic(optional = false)
    private Double discAmt;

    @Column(name = "final_bill_id",nullable = false)
    @Basic(optional = false)
    private Long finalBillId;

    public static OrderDiscount to(final CreateOrderDiscountRequest createOrderDiscountRequest){
        OrderDiscount orderDiscount = new OrderDiscount();
        orderDiscount.setPatId(createOrderDiscountRequest.getPatId());
        orderDiscount.setUid(createOrderDiscountRequest.getUid());
        orderDiscount.setDatetime(DateTimeUtils.convertLocalDateToDateTimeFormat(LocalDateTime.now()));
        orderDiscount.setDiscAmt(createOrderDiscountRequest.getDiscAmt());
        orderDiscount.setFinalBillId(createOrderDiscountRequest.getFinalBillId());

        return orderDiscount;
    }
}
