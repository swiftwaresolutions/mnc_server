package com.ueniweb.swiftwaresolutions.security;


import com.ueniweb.swiftwaresolutions.data.AppUser;

public interface PlatformSecurityContext {

    AppUser authenticateUser();
}
