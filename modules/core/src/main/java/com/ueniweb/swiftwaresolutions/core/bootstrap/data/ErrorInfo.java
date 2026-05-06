package com.ueniweb.swiftwaresolutions.core.bootstrap.data;

import com.ueniweb.swiftwaresolutions.core.data.ApiParameterError;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ErrorInfo {

    private int status;
    private String message;
    private String errorCode;
    private Object[] fields;
    private List<ApiParameterError> fieldErrors;
}
