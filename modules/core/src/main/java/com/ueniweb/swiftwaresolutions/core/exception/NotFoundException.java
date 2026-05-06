package com.ueniweb.swiftwaresolutions.core.exception;

import com.ueniweb.swiftwaresolutions.infrastructure.exceptions.AbstractApplicationPlatformException;

public class NotFoundException extends AbstractApplicationPlatformException {

    public NotFoundException(String message) {
        super("error.msg.not.found", message);
    }
}
