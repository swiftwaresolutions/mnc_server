package com.ueniweb.swiftwaresolutions.repository;


import com.ueniweb.swiftwaresolutions.domain.User;

public interface CustomUserRepository {

    User login(String userName, String password);

}
