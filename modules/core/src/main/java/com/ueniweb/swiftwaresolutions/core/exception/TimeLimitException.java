package com.ueniweb.swiftwaresolutions.core.exception;

import com.ueniweb.swiftwaresolutions.infrastructure.exceptions.AbstractApplicationPlatformException;

public class TimeLimitException extends AbstractApplicationPlatformException {
    public TimeLimitException(String message) {
        super("error.msg.Time.LimitExceed", message);
    }
}
