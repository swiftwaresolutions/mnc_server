package com.ueniweb.swiftwaresolutions.service;

import com.ueniweb.swiftwaresolutions.core.response.ResponseDO;
import com.ueniweb.swiftwaresolutions.domain.ConsultantRepository;
import com.ueniweb.swiftwaresolutions.domain.DoctorDailyScheduleRepository;
import com.ueniweb.swiftwaresolutions.domain.User;
import com.ueniweb.swiftwaresolutions.dtos.UserDTO;
import com.ueniweb.swiftwaresolutions.infrastructure.exceptions.NoRecordFoundException;
import com.ueniweb.swiftwaresolutions.model.AuthModel;
import com.ueniweb.swiftwaresolutions.repository.CustomUserRepository;
import com.ueniweb.swiftwaresolutions.repository.DepartmentRepository;
import com.ueniweb.swiftwaresolutions.repository.UserRepository;
import com.ueniweb.swiftwaresolutions.utils.AccessTokenUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final CustomUserRepository usersRepository;

    private final UserRepository userRepository;

    private final AccessTokenUtils accessTokenUtils;

    private final ConsultantRepository consultantRepository;

    private final DepartmentRepository departmentRepository;

    private final DoctorDailyScheduleRepository doctorDailyScheduleRepository;

    @Override
    public Optional<User> fetchById(Long userId) {
        return this.userRepository.findById(userId);
    }

    @Override
    public User login(AuthModel authModel) {
        User user = this.usersRepository.login(authModel.getUserName(), authModel.getPassword());
        return user;
    }

    @Override
    public User fetchUser(Long userId) {
        Optional<User> userOptional = fetchById(userId);
        if (!userOptional.isPresent()) {
            throw new NoRecordFoundException("User not found");
        }
        return userOptional.get();
    }

    @Override
    @Transactional
    public ResponseDO doLogin(AuthModel authModel) {
        User user = this.login(authModel);
        UserDTO userDTO = user.to(consultantRepository, departmentRepository);

        if (user.getIsDoctor() == 1 && user.getDoctor_id() != null) {
            boolean scheduleExists = doctorDailyScheduleRepository
                    .existsByDoctorIdAndAttendanceDate(user.getDoctor_id(), LocalDate.now());
            if (scheduleExists) {
                doctorDailyScheduleRepository.updateScheduledStartTime(
                        user.getDoctor_id(),
                        LocalDate.now(),
                        LocalTime.now(),
                        "AVAILABLE"
                );
            }
        }

        String accessToken = accessTokenUtils.generateAccessToken(user.getId());
        userDTO.setAccessToken(accessToken);
        ResponseDO responseDO = new ResponseDO();
        responseDO.setSuccess(true);
        responseDO.setData(userDTO);
        return responseDO;
    }
}
