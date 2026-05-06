package com.ueniweb.swiftwaresolutions.core.exception;

import com.ueniweb.swiftwaresolutions.infrastructure.exceptions.AbstractApplicationPlatformException;

public class InvalidMailException extends AbstractApplicationPlatformException {

    public InvalidMailException(String message) {
        super("error.msg.email.notvalid", message);
    }
}
