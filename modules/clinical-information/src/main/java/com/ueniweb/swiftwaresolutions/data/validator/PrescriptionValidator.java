package com.ueniweb.swiftwaresolutions.data.validator;

import com.ueniweb.swiftwaresolutions.core.data.ApiParameterError;
import com.ueniweb.swiftwaresolutions.infrastructure.exceptions.PlatformApiDataValidationException;
import com.ueniweb.swiftwaresolutions.request.CreatePrescriptionDetailsRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PrescriptionValidator {

    public void validatePrescriptionData(final List<CreatePrescriptionDetailsRequest> createPrescriptionDetailsRequestList ){
    List<ApiParameterError> errorList = new ArrayList<>();
        for (CreatePrescriptionDetailsRequest prescriptionDetailsRequest : createPrescriptionDetailsRequestList){
        if(prescriptionDetailsRequest.getProds_id() == null || prescriptionDetailsRequest.getProds_id() == 0 || prescriptionDetailsRequest.getQuantity() == null || prescriptionDetailsRequest.getUnit() == null || prescriptionDetailsRequest.getTiming() == null ){
            ApiParameterError error = ApiParameterError.parameterError("Prods.Qty.required","ProdsId is required for Medicine : "+prescriptionDetailsRequest.getProds_id(),"Medicine");
            errorList.add(error);
        }
        if(prescriptionDetailsRequest.getProds_id() == null){
            ApiParameterError error = ApiParameterError.parameterError("Product.id.required","Choose proper Medicine name!","ProdsId");
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
