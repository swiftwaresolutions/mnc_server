package com.ueniweb.swiftwaresolutions.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "x_temp_cash_bill")
@Getter
@Setter
public class TempCashBill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_display")
    private String orderDisplay;

    @Column(name = "total")
    private Double total = 0.00;

    @Column(name = "store_id")
    private Integer storeId = 1;

    @Column(name = "order_uid")
    private Long orderUid;

    @Column(name = "order_datetime")
    private String orderDatetime;

    @Column(name = "is_cancelled", insertable = false)
    private Boolean isCancelled;

    @Column(name = "is_billed", insertable = false)
    private Boolean isBilled;

    @Column(name = "bill_uid")
    private Long billUid;

    @Column(name = "bill_datetime")
    private String billDatetime;

    @Column(name = "pat_id")
    private Long patId;

    @Column(name = "visit_id")
    private Long visitId;

    @Column(name = "ip_id")
    private Long ipId = 0L;

    @Column(name = "is_ordered", insertable = false)
    private Boolean isOrdered;

    @Column(name = "final_bill_id")
    private Long finalBillId = 0L;

    @Column(name = "doct_id")
    private Long doctId;

}
