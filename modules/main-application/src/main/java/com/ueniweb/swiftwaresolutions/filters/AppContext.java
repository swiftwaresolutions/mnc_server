package com.ueniweb.swiftwaresolutions.filters;


import com.ueniweb.swiftwaresolutions.data.AppUser;
import com.ueniweb.swiftwaresolutions.domain.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AppContext {

    private static final ThreadLocal<AppUser> CONTEXT = new ThreadLocal<>();

    public static void set(AppUser appUser) {
        CONTEXT.set(appUser);
    }

    public static AppUser get() {
        return CONTEXT.get();
    }

    public static User getUser() {
        return get().getUser();
    }

    public static void destroy() {
        CONTEXT.remove();
    }
}
