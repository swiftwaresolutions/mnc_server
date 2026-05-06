package com.ueniweb.swiftwaresolutions.repository;

import com.ueniweb.swiftwaresolutions.domain.User;
import com.ueniweb.swiftwaresolutions.infrastructure.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserRepositoryWrapper {

    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public User findOneWithNotFoundDetection(final Long userId){
        return this.userRepository.findById(userId).orElseThrow(()-> new NotFoundException("User not found for id : "+userId));
    }

    @Transactional(readOnly = true)
    public User findOneWithNotFoundDetection(final String userName, final String password){
        return this.userRepository.fetchUserByUserNameAndPwd(userName, password).orElseThrow(()-> new NotFoundException("User not found"));
    }

    @Transactional(readOnly = true)
    public User findOneWithNotFoundDetection(final String userName){
        return this.userRepository.fetchUserByUserName(userName).orElseThrow(()-> new NotFoundException("User not found"));
    }
}
