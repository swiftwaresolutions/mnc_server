package com.ueniweb.swiftwaresolutions.request;

import lombok.Data;

@Data
public class CreateOrderTemplateDetailsRequest {

    private Long templateId;

    private Long procedureId;

    private String procedureType;

    private String procedureName;

    private Double procedureRate;

    @Override
    public String toString() {
        return "CreateOrderTemplateDetailsRequest{" +
                "templateId=" + templateId +
                ", procedureId=" + procedureId +
                ", procedureType='" + procedureType + '\'' +
                ", procedureName='" + procedureName + '\'' +
                ", procedureRate=" + procedureRate +
                '}';
    }

}
