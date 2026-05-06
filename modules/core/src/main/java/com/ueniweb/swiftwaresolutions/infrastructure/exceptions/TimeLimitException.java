package com.ueniweb.swiftwaresolutions.infrastructure.exceptions;

public class TimeLimitException extends AbstractApplicationPlatformException {
    public TimeLimitException(String message) {
        super("error.msg.Time.LimitExceed", message);
    }
}
