package com.ueniweb.swiftwaresolutions.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class OrderWithDetailsData {
    private Long orderId;
    private String orderDisplay;
    private Double totalAmt;
    private Long orderUserId;
    private Long doctorId;
    private String userName;
    private String doctorName;
    private String deptName;
    private List<InvestigationOrderedData> details = new ArrayList<>();
}
