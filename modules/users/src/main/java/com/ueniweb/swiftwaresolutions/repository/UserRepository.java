package com.ueniweb.swiftwaresolutions.repository;

import com.ueniweb.swiftwaresolutions.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from Users u where u.name=:userName AND u.pass=:password AND u.isBlock = 0")
    Optional<User> fetchUserByUserNameAndPwd(@Param("userName") String userName, @Param("password") String password);

    @Query("select u from Users u where u.name=:userName AND u.isBlock = 0")
    Optional<User> fetchUserByUserName(@Param("userName") String userName);
}
