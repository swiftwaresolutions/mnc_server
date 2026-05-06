package com.ueniweb.swiftwaresolutions.request;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ueniweb.swiftwaresolutions.core.exception.HimsApplicationContextException;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CreateSummaryDiagnosisDetailsRequest {

    private Long patId;

    private Long vstId;

    private Long ipId;

    private Long disSumId;

    private Long diagnosisId;

    private Long isValid;

    private String name;


    public static List<CreateSummaryDiagnosisDetailsRequest> jsonStrToRequestList(final String diagnosticDataListStr) {
        List<CreateSummaryDiagnosisDetailsRequest> createSummaryDiagnosisDetailsRequestList = new ArrayList<>();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode arrayNode = objectMapper.readTree(diagnosticDataListStr);
            if (arrayNode.isArray()) {
                for (JsonNode jsonNode : arrayNode) {
                    CreateSummaryDiagnosisDetailsRequest createSummaryDiagnosisDetailsRequest = new CreateSummaryDiagnosisDetailsRequest();
                    createSummaryDiagnosisDetailsRequest.setPatId(jsonNode.get("patId").asLong());
                    createSummaryDiagnosisDetailsRequest.setVstId(jsonNode.get("vstId").asLong());
                    createSummaryDiagnosisDetailsRequest.setVstId(jsonNode.get("ipId").asLong());
                    createSummaryDiagnosisDetailsRequest.setVstId(jsonNode.get("disSumId").asLong());
                    createSummaryDiagnosisDetailsRequest.setVstId(jsonNode.get("diagnosisId").asLong());
                    createSummaryDiagnosisDetailsRequest.setVstId(jsonNode.get("isValid").asLong());
                    createSummaryDiagnosisDetailsRequest.setVstId(jsonNode.get("name").asLong());

                    createSummaryDiagnosisDetailsRequestList.add(createSummaryDiagnosisDetailsRequest);
                }
            }
            return createSummaryDiagnosisDetailsRequestList;
        } catch (JsonProcessingException e) {
            throw new HimsApplicationContextException("Error occurred while processing diagnosticData json");
        }
    }

    @Override
    public String toString() {
        return "createDiagnosisDetailsSummaryRequest{" +
                "patId=" + patId +
                ", vstId=" + vstId +
                ", ipId=" + ipId +
                ", disSumId=" + disSumId +
                ", diagnosisId=" + diagnosisId +
                ", isValid=" + isValid +
                ", name=" + name +
                '}';
    }


}
