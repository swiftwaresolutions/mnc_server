package com.ueniweb.swiftwaresolutions.domain;

import com.ueniweb.swiftwaresolutions.request.CreateLabOrderRequest;
import com.ueniweb.swiftwaresolutions.utils.DateTimeUtils;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name="LabOrder")
@Table(name = "x_temp_lab_bill_details")
@Getter
@Setter
public class LabOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "test_id")
    private Long testId;

    @Column(name = "test_code")
    private String testCode;

    @Column(name = "dept_id")
    private Long deptId;

    @Column(name = "rate")
    private Double rate;

    @Column(name = "disc")
    private Double disc;

    @Column(name = "result_done")
    private Long resultDone;

    @Column(name = "result_date")
    private String resultDate;

    @Column(name = "result_time")
    private String  resultTime;

    @Column(name = "result_uid")
    private Long resultUid;

    @Column(name = "unit")
    private Long unit;

    @Column(name = "temp_order_id")
    private Long tempOrderId;

    @Column(name = "return_unit")
    private Long returnUnit;

    @Column(name = "fc_rate")
    private Double fcRate;

    @Column(name = "pat_id")
    private Long patId;

    @Column(name = "visitId")
    private Long visitId;

    @Column(name = "doc_id")
    private Long docId;

    @Column(name = "uid")
    private Long uid;

    @Column(name = "dtm")
    private String dtm;

    @Column(name = "head_id")
    private Long headId;

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

    public static List<LabOrder> to(final List<CreateLabOrderRequest> labOrderRequests , final Long docId){
        List<LabOrder> labOrderList = new ArrayList<>();
        for (CreateLabOrderRequest labOrderRequest: labOrderRequests) {
            labOrderList.add(to(labOrderRequest, docId));
        }
        return labOrderList;
    }

    public static LabOrder to(final CreateLabOrderRequest labOrderRequest, final Long docId){
        LabOrder labOrder = new LabOrder();
        labOrder.setOrderId(labOrderRequest.getOrderId());
        labOrder.setTestId(labOrderRequest.getTestId());
        labOrder.setTestCode(labOrderRequest.getTestCode());
        labOrder.setDeptId(labOrderRequest.getDeptId());
        labOrder.setRate(labOrderRequest.getRate());
        labOrder.setDisc(labOrderRequest.getDisc());
        labOrder.setResultDone(labOrderRequest.getResultDone());
        labOrder.setResultDate("0000-00-00");
        labOrder.setResultTime("00:00:00");
        labOrder.setResultUid(labOrderRequest.getResultUid());
        labOrder.setUnit(labOrderRequest.getUnit());
        labOrder.setTempOrderId(labOrderRequest.getTempOrderId());
        labOrder.setReturnUnit(labOrderRequest.getReturnUnit());
        labOrder.setFcRate(labOrderRequest.getFcRate());
        labOrder.setPatId(labOrderRequest.getPatId());
        labOrder.setVisitId(labOrderRequest.getVstId());
        labOrder.setDocId(docId);
        labOrder.setUid(labOrderRequest.getUid());
        labOrder.setDtm(DateTimeUtils.convertLocalDateToDateTimeFormat(LocalDateTime.now()));
        labOrder.setHeadId(labOrderRequest.getHeadId());
        labOrder.setFinalBillId(labOrderRequest.getFinalBillId());
        return labOrder;
    }
}
