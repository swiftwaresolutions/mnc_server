package com.ueniweb.swiftwaresolutions.request;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ueniweb.swiftwaresolutions.core.exception.HimsApplicationContextException;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CreateDisSumConsRequest {

    private Long summaryId;

    private Integer consultantId;

    private Integer isValid;

    @Override
    public String toString() {
        return "CreateDisSumConsRequest{" +
                "summaryId=" + summaryId +
                ", consultantId=" + consultantId +
                ", isValid=" + isValid +
                '}';
    }






}
