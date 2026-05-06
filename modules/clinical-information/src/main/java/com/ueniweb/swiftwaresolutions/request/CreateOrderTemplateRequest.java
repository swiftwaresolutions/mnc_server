package com.ueniweb.swiftwaresolutions.request;

import jakarta.persistence.Column;
import lombok.Data;

import java.util.List;

@Data
public class CreateOrderTemplateRequest {

    private String templateName;

    private Long consultantId;

    private Long isActive;

    private Long createdBy;

    private String createdDTM;

    private Long tempType;

    private List<CreateOrderTemplateDetailsRequest> createOrderTemplateDetailsRequestsList;


    @Override
    public String toString() {
        return "CreateOrderTemplateRequest{" +
                "templateName='" + templateName + '\'' +
                ", consultantId=" + consultantId +
                ", isActive=" + isActive +
                ", createdBy=" + createdBy +
                ", tempType=" + tempType +
                ", createdDTM='" + createdDTM + '\'' +
                '}';
    }


}
