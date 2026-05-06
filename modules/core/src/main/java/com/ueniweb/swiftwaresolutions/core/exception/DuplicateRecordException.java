package com.ueniweb.swiftwaresolutions.core.exception;

import com.ueniweb.swiftwaresolutions.infrastructure.exceptions.AbstractApplicationPlatformException;

public class DuplicateRecordException extends AbstractApplicationPlatformException {

    public DuplicateRecordException(String message) {
        super("error.msg.duplicate", message);
    }
}