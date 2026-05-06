package com.ueniweb.swiftwaresolutions.infrastructure.exceptions;

public class AuthenticationException extends AbstractApplicationPlatformException {

    public AuthenticationException(String message) {
        super("error.msg.invalid.credentials", message);
    }
}
