package com.ueniweb.swiftwaresolutions.domain;

import com.ueniweb.swiftwaresolutions.request.CreateInvestigationOrderRequest;
import com.ueniweb.swiftwaresolutions.utils.DateTimeUtils;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name="InvestigationOrder")
@Table(name = "x_temp_cash_bill_details")
@Getter
@Setter
public class InvestigationOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bill_id")
    private Long billId;

    @Column(name = "group_id",nullable = false)
    @Basic(optional = false)
    private Long groupId;

    @Column(name = "particular_id",nullable = false)
    @Basic(optional = false)
    private Long particularId;

    @Column(name = "unit")
    private Double unit;

    @Column(name = "rate")
    private Double rate;

    @Column(name = "disc")
    private Long disc;

    @Column(name = "doc_id")
    private Long docId;

    @Column(name = "return_unit")
    private Double returnUnit;

    @Column(name = "fc_rate")
    private Long fcRate;

    @Column(name = "pat_id",nullable = false)
    @Basic(optional = false)
    private Long patId;

    @Column(name = "visitId",nullable = false)
    @Basic(optional = false)
    private Long visitId;

    @Column(name = "uid",nullable = false)
    @Basic(optional = false)
    private Long uid;

    @Column(name = "dtm")
    private String dateTime;

    @Column(name = "finalBillId")
    private Long finalBillId;

    @Column(name = "is_cancelled", insertable = false)
    private Boolean isCancelled;

    @Column(name = "cancel_date", insertable = false)
    private LocalDate cancelDate;

    @Column(name = "cancel_time" , insertable = false)
    private LocalTime cancelTime;

    @Column(name = "cancel_uid", insertable = false)
    private Long cancelUid;


    @Column(name = "remark")
    private String remark;


    public static List<InvestigationOrder> to(final List<CreateInvestigationOrderRequest> createInvestigationOrderRequestList, final Long docId , final Long userId){
        List<InvestigationOrder> investigationOrderList = new ArrayList<>();
        for (CreateInvestigationOrderRequest createInvestigationOrderRequest : createInvestigationOrderRequestList) {
            investigationOrderList.add(to(createInvestigationOrderRequest, docId, userId));
        }
        return investigationOrderList;
    }

    public static InvestigationOrder to(final CreateInvestigationOrderRequest createInvestigationOrderRequest , final Long docId, final Long userId){
        InvestigationOrder investigationOrder = new InvestigationOrder();
        investigationOrder.setBillId(createInvestigationOrderRequest.getBillId());
        investigationOrder.setGroupId(createInvestigationOrderRequest.getGroupId());
        investigationOrder.setParticularId(createInvestigationOrderRequest.getParticularId());
        investigationOrder.setUnit(createInvestigationOrderRequest.getUnit());
        investigationOrder.setRate(createInvestigationOrderRequest.getRate());
        investigationOrder.setDisc(createInvestigationOrderRequest.getDisc());
        investigationOrder.setDocId(docId);
        investigationOrder.setReturnUnit(createInvestigationOrderRequest.getReturnUnit());
        investigationOrder.setFcRate(createInvestigationOrderRequest.getFcRate());
        investigationOrder.setPatId(createInvestigationOrderRequest.getPatId());
        investigationOrder.setVisitId(createInvestigationOrderRequest.getVstId());
        investigationOrder.setUid(userId);
        investigationOrder.setDateTime(DateTimeUtils.convertLocalDateToDateTimeFormat(LocalDateTime.now()));
        investigationOrder.setFinalBillId(createInvestigationOrderRequest.getFinalBillId());
        investigationOrder.setRemark("");
        return investigationOrder;
    }
}
