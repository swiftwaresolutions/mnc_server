package com.ueniweb.swiftwaresolutions.request;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ueniweb.swiftwaresolutions.core.exception.HimsApplicationContextException;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CreateDiagnosisDetailsRequest {

    private Long patId;

    private Long vstId;

    private Long ipId;

    private Long caseSheetType;

    private Long caseSheetId;

    private Long diagnosisId;

    private Long isValid;


    public static List<CreateDiagnosisDetailsRequest> jsonStrToRequestList(final String diagnosticDataListStr) {
        List<CreateDiagnosisDetailsRequest> createDiagnosisDetailsRequestList = new ArrayList<>();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode arrayNode = objectMapper.readTree(diagnosticDataListStr);
            if (arrayNode.isArray()) {
                for (JsonNode jsonNode : arrayNode) {
                    CreateDiagnosisDetailsRequest createDiagnosisDetailsRequest = new CreateDiagnosisDetailsRequest();
                    createDiagnosisDetailsRequest.setPatId(jsonNode.get("patId").asLong());
                    createDiagnosisDetailsRequest.setVstId(jsonNode.get("vstId").asLong());
                    createDiagnosisDetailsRequest.setVstId(jsonNode.get("ipId").asLong());
                    createDiagnosisDetailsRequest.setVstId(jsonNode.get("caseSheetType").asLong());
                    createDiagnosisDetailsRequest.setVstId(jsonNode.get("caseSheetId").asLong());
                    createDiagnosisDetailsRequest.setVstId(jsonNode.get("diagnosisId").asLong());
                    createDiagnosisDetailsRequest.setVstId(jsonNode.get("isValid").asLong());

                    createDiagnosisDetailsRequestList.add(createDiagnosisDetailsRequest);
                }
            }
            return createDiagnosisDetailsRequestList;
        } catch (JsonProcessingException e) {
            throw new HimsApplicationContextException("Error occurred while processing diagnosticData json");
        }
    }

    @Override
    public String toString() {
        return "CreateDiagnosisDetailsRequest{" +
                "patId=" + patId +
                ", vstId=" + vstId +
                ", ipId=" + ipId +
                ", caseSheetType=" + caseSheetType +
                ", caseSheetId=" + caseSheetId +
                ", diagnosisId=" + diagnosisId +
                ", isValid=" + isValid +
                '}';
    }


}
