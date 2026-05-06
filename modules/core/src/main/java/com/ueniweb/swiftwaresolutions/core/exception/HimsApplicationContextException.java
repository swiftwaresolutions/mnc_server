package com.ueniweb.swiftwaresolutions.core.exception;

import com.ueniweb.swiftwaresolutions.core.bootstrap.data.ErrorInfo;
import com.ueniweb.swiftwaresolutions.infrastructure.exceptions.AbstractApplicationPlatformException;

;

public class HimsApplicationContextException extends AbstractApplicationPlatformException {

    public HimsApplicationContextException(String message) {
        super("error.msg.not.found", message);
    }

    public HimsApplicationContextException(ErrorInfo errorInfo) {
        super("error.msg.not.found", errorInfo.getMessage(), errorInfo.getFields());
    }
}
