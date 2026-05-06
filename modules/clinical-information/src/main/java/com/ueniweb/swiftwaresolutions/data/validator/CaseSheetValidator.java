package com.ueniweb.swiftwaresolutions.data.validator;

import com.ueniweb.swiftwaresolutions.core.data.ApiParameterError;
import com.ueniweb.swiftwaresolutions.infrastructure.exceptions.PlatformApiDataValidationException;
import com.ueniweb.swiftwaresolutions.request.CreateComplaintDetailsRequest;
import com.ueniweb.swiftwaresolutions.request.GeneralCaseSheetRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CaseSheetValidator {

    public void validateComplaintData(final List<CreateComplaintDetailsRequest> complaintDetailsRequestList) {
        List<ApiParameterError> errorList = new ArrayList<>();
        for (CreateComplaintDetailsRequest complaintDetailsRequest : complaintDetailsRequestList) {
            if (complaintDetailsRequest.getPeriod() == null || complaintDetailsRequest.getPeriod().isEmpty()) {
                ApiParameterError error = ApiParameterError.parameterError("complaint.period.required", "Complaint period is required for Complaint Name : " + complaintDetailsRequest.getComplaintName(), "period");
                errorList.add(error);
            }
            if (complaintDetailsRequest.getComplaintId() == null) {
                ApiParameterError error = ApiParameterError.parameterError("complaint.id.required", "Choose proper Complaint name!", "complaintId");
                errorList.add(error);
            }
        }
        if (!errorList.isEmpty()) {
            throwValidationError(errorList.get(0).getDefaultUserMessage(), errorList);
        }
    }

    public void GeneralCaseSheetDate(final GeneralCaseSheetRequest generalCaseSheetRequest) {
        List<ApiParameterError> errorList = new ArrayList<>();
        if (generalCaseSheetRequest.getVisitId() == null || generalCaseSheetRequest.getVisitId() == 0) {
            errorList.add(ApiParameterError.parameterError("visitId.required", "Visit Id Required for GeneralCaseSheet : ", "visitId"));

            if (generalCaseSheetRequest.getPatientId() == null) {
                ApiParameterError error = ApiParameterError.parameterError("patientId.required", "Choose proper Patient name!", "patientId");
                errorList.add(error);
            }
        }
        if (!errorList.isEmpty()) {
            throwValidationError(errorList.get(0).getDefaultUserMessage(), errorList);
        }

    }


    private void throwValidationError(String defaultUserMessage, final List<ApiParameterError> errorList) {
        throw new PlatformApiDataValidationException("Mandatory Fields required!", defaultUserMessage, errorList);
    }
}
