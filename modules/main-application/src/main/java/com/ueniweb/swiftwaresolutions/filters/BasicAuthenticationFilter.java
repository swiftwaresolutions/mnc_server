package com.ueniweb.swiftwaresolutions.filters;


import com.ueniweb.swiftwaresolutions.data.AppUser;
import com.ueniweb.swiftwaresolutions.domain.User;
import com.ueniweb.swiftwaresolutions.service.AuthService;
import com.ueniweb.swiftwaresolutions.utils.AccessTokenUtils;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
@Order(2)
public class BasicAuthenticationFilter implements Filter {

    private final AuthService authService;

    private final AccessTokenUtils accessTokenUtils;

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        HttpServletRequest httpRequest = (HttpServletRequest) req;
        Enumeration<String> headerNames = httpRequest.getHeaderNames();
        if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
                String name = headerNames.nextElement();
                if("authorization".equalsIgnoreCase(name)) {
                    if(httpRequest.getHeader(name).equalsIgnoreCase("")) {
                        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Authorization Header Should Not Be Empty");
                        return;
                    }
                    Long userId = accessTokenUtils.fetchUserId(httpRequest.getHeader(name));
                    if (userId == null) {
                        // Skip the filter if the user ID is null
                        chain.doFilter(req, res);
                        return;
                    }
                    Optional<User> user = authService.fetchById(userId);
                    if (user.isEmpty()) {
                        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "User Not found");
                        return;
                    }
                    AppUser appUser = new AppUser();
                    appUser.setUser(user.get());
                    appUser.setId(userId);
                    AppContext.set(appUser);
                }
            }
        }
        chain.doFilter(req, res);
    }

    @Override
    public void destroy() {

    }

}