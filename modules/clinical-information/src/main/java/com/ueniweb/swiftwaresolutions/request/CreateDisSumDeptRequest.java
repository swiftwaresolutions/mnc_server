package com.ueniweb.swiftwaresolutions.request;

import lombok.Data;

@Data
public class CreateDisSumDeptRequest {

    private Long summaryId;

    private Integer deptId;

    private Integer isValid;

    @Override
    public String toString() {
        return "CreateDisSumDeptRequest{" +
                "summaryId=" + summaryId +
                ", deptId=" + deptId +
                ", isValid=" + isValid +
                '}';
    }


}
