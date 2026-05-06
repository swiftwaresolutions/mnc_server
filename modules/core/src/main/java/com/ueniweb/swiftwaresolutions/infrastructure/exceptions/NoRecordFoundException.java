package com.ueniweb.swiftwaresolutions.infrastructure.exceptions;

public class NoRecordFoundException extends AbstractApplicationPlatformException{
    public NoRecordFoundException(String message) {
        super("error.msg.applicant.no-record-found", message);
    }
}
