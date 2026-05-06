package com.ueniweb.swiftwaresolutions.infrastructure.exceptions;

public class DuplicateRecordException extends AbstractApplicationPlatformException{

    public DuplicateRecordException(String message) {
        super("error.msg.duplicate", message);

    }
}