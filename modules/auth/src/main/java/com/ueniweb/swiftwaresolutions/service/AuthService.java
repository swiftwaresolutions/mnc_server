package com.ueniweb.swiftwaresolutions.service;

import com.ueniweb.swiftwaresolutions.core.response.ResponseDO;
import com.ueniweb.swiftwaresolutions.domain.User;
import com.ueniweb.swiftwaresolutions.model.AuthModel;

import java.util.Optional;

public interface AuthService {

    ResponseDO doLogin(AuthModel authModel);

    User login(AuthModel authModel);

    Optional<User> fetchById(Long userId);

    User fetchUser(Long userId);
}
