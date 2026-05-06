package com.ueniweb.swiftwaresolutions.core.exception;

import com.ueniweb.swiftwaresolutions.infrastructure.exceptions.AbstractApplicationPlatformException;

public class RequiredFieldMissingException extends AbstractApplicationPlatformException {

    public RequiredFieldMissingException(String message) {
        super("error.msg.required.field.missing", message);
    }
}
