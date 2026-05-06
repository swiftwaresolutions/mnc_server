package com.ueniweb.swiftwaresolutions.infrastructure.exceptions;

public class NotFoundException extends AbstractApplicationPlatformException {

    public NotFoundException(String message) {
        super("error.msg.not.found", message);
    }
}
