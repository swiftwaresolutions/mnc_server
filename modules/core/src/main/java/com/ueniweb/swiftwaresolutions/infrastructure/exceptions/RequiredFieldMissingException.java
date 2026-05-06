package com.ueniweb.swiftwaresolutions.infrastructure.exceptions;

public class RequiredFieldMissingException extends AbstractApplicationPlatformException {

    public RequiredFieldMissingException(String message) {
        super("error.msg.required.field.missing", message);
    }
}
