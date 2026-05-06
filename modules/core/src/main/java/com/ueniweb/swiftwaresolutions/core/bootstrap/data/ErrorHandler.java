package com.ueniweb.swiftwaresolutions.core.bootstrap.data;

import com.ueniweb.swiftwaresolutions.infrastructure.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

public class ErrorHandler {

    public ResponseEntity<ErrorInfo> handleException(AbstractApplicationPlatformException ex) {
        final ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value()); // Default
        if (ex instanceof AuthenticationException) {
            errorInfo.setStatus(HttpStatus.UNAUTHORIZED.value());
        }  else if (ex instanceof TimeLimitException) {
            errorInfo.setStatus(HttpStatus.GATEWAY_TIMEOUT.value());
        } else if (ex instanceof DuplicateRecordException) {
            errorInfo.setStatus(HttpStatus.CONFLICT.value());
        } else if (ex instanceof NoRecordFoundException) {
            errorInfo.setStatus(HttpStatus.FORBIDDEN.value());
        } else if (ex instanceof RequiredFieldMissingException) {
            errorInfo.setStatus(HttpStatus.FORBIDDEN.value());
        } else if (ex instanceof PlatformApiDataValidationException) {
            errorInfo.setStatus(HttpStatus.NO_CONTENT.value());
            errorInfo.setFieldErrors(((PlatformApiDataValidationException) ex).getErrors());
        }

        errorInfo.setErrorCode(ex.getGlobalisationMessageCode());
        errorInfo.setFields(ex.getDefaultUserMessageArgs());
        errorInfo.setMessage(ex.getDefaultUserMessage());

        System.err.println(LocalDateTime.now()+" : Error Occurred: " + errorInfo.getMessage() + " with status: " + errorInfo.getStatus());
        return ResponseEntity.status(errorInfo.getStatus()).body(errorInfo);
    }

}
