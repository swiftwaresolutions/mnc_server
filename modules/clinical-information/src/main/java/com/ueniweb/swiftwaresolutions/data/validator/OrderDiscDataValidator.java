package com.ueniweb.swiftwaresolutions.data.validator;

import com.ueniweb.swiftwaresolutions.core.data.ApiParameterError;
import com.ueniweb.swiftwaresolutions.infrastructure.exceptions.PlatformApiDataValidationException;
import com.ueniweb.swiftwaresolutions.request.CreateComplaintDetailsRequest;
import com.ueniweb.swiftwaresolutions.request.CreateOrderDiscountRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderDiscDataValidator {

    public void validateOrderDiscData(final List<CreateOrderDiscountRequest> createOrderDiscountRequests){
        List<ApiParameterError> errorList = new ArrayList<>();
        for (CreateOrderDiscountRequest createOrderDiscountRequest : createOrderDiscountRequests){
            if(createOrderDiscountRequest.getDiscAmt() == null){
                ApiParameterError error = ApiParameterError.parameterError("discAmt.required","discAmt is required for The PatId : "+createOrderDiscountRequest.getPatId(),"discAmt");
                errorList.add(error);
            }
            if(createOrderDiscountRequest.getDiscAmt() == null){
                ApiParameterError error = ApiParameterError.parameterError("disc.amt.required","Enter proper Disc Amt!","complaintId");
                errorList.add(error);
            }
        }
        if(!errorList.isEmpty()){
            throwValidationError(errorList.get(0).getDefaultUserMessage(),errorList);
        }
    }

    private void throwValidationError(String defaultUserMessage, final List<ApiParameterError> errorList){
        throw new PlatformApiDataValidationException("Mandatory Fields required!", defaultUserMessage,errorList);
    }

}
