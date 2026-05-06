package com.ueniweb.swiftwaresolutions.data;

import lombok.Data;

@Data
public class ConsultantDetailsData {

    private Long consultantId;
    private String consultantName;

    private Long departmentId;
    private String departmentName;

    private Long particularId;
    private Long groupId;

    private Double consultationCharge;

    public ConsultantDetailsData(
            Long consultantId,
            String consultantName,
            Long departmentId,
            String departmentName,
            Long particularId,
            Long groupId,
            Double consultationCharge
    ) {
        this.consultantId = consultantId;
        this.consultantName = consultantName;
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.particularId = particularId;
        this.groupId = groupId;
        this.consultationCharge = consultationCharge;
    }

    public static ConsultantDetailsData newInstance(
            Long consultantId,
            String consultantName,
            Long departmentId,
            String departmentName,
            Long particularId,
            Long groupId,
            Double consultationCharge
    ) {
        return new ConsultantDetailsData(
                consultantId,
                consultantName,
                departmentId,
                departmentName,
                particularId,
                groupId,
                consultationCharge
        );
    }
}
