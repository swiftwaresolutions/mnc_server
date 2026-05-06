package com.ueniweb.swiftwaresolutions.security;

import com.ueniweb.swiftwaresolutions.data.AppUser;
import com.ueniweb.swiftwaresolutions.filters.AppContext;
import com.ueniweb.swiftwaresolutions.infrastructure.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SpringSecurityPlatformSecurityContext implements PlatformSecurityContext {

    @Override
    public AppUser authenticateUser() {
        final AppUser appUser = AppContext.get();
        if(appUser == null) {
            throw new NotFoundException("Authentication Failed");
        }
        return appUser;
    }
}
