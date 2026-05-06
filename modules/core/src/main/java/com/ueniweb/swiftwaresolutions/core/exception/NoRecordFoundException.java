package com.ueniweb.swiftwaresolutions.core.exception;

import com.ueniweb.swiftwaresolutions.infrastructure.exceptions.AbstractApplicationPlatformException;

public class NoRecordFoundException extends AbstractApplicationPlatformException {
    public NoRecordFoundException(String message) {
        super("error.msg.applicant.no-record-found", message);
    }
}
