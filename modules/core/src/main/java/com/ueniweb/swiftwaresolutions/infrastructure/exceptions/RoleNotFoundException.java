package com.ueniweb.swiftwaresolutions.infrastructure.exceptions;

public class RoleNotFoundException extends AbstractApplicationPlatformException {

    public RoleNotFoundException(String message) {
        super("error.msg.role.not.found", message);
    }
}
