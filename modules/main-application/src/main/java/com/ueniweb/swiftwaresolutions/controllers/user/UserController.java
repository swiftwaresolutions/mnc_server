package com.ueniweb.swiftwaresolutions.controllers.user;


import com.ueniweb.swiftwaresolutions.core.response.ResponseDO;
import com.ueniweb.swiftwaresolutions.data.AppUser;
import com.ueniweb.swiftwaresolutions.data.UserRightsData;
import com.ueniweb.swiftwaresolutions.domain.ConsultantRepository;
import com.ueniweb.swiftwaresolutions.domain.User;
import com.ueniweb.swiftwaresolutions.dtos.UserDTO;
import com.ueniweb.swiftwaresolutions.repository.DepartmentRepository;
import com.ueniweb.swiftwaresolutions.security.PlatformSecurityContext;
import com.ueniweb.swiftwaresolutions.services.UserReadPlatformService;
import com.ueniweb.swiftwaresolutions.model.AuthModel;
import com.ueniweb.swiftwaresolutions.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
@Slf4j
public class UserController {

    private final AuthService authService;

    private final JdbcTemplate jdbcTemplate;

    private final UserReadPlatformService userReadPlatformService;

    private final PlatformSecurityContext platformSecurityContext;

    private final ConsultantRepository consultantRepository;

    private final DepartmentRepository departmentRepository;


    @GetMapping()
    public String checkApi (){
        return "gfh";
    }

    @PostMapping("/login")
    public ResponseDO doLogin(@RequestBody AuthModel authModel) {
        return this.authService.doLogin(authModel);
    }

    @GetMapping("/CheckUserRights/{uid}/{modId}/{grpDetId}/{funcId}")
    public UserRightsData CheckUserRight(@PathVariable(name = "uid") Long uid,
                                                @PathVariable(name = "mod_id") int mod_id,
                                                @PathVariable(name = "grp_det_id") int grp_det_id,
                                                @PathVariable(name = "func_id") int func_id)
    {
        return this.userReadPlatformService.CheckUserRight(uid,mod_id,grp_det_id,func_id);
    }

    @GetMapping("/getLoginUser")
    public ResponseDO GetLoginUser(@RequestHeader(HttpHeaders.AUTHORIZATION) String token)
    {
        final AppUser appUser = this.platformSecurityContext.authenticateUser();
        String accessToken = "";
        User user = appUser.getUser();
        UserDTO userDTO = user.to(consultantRepository, departmentRepository);
        if (token != null && token.startsWith("Bearer ")) {
            accessToken = token.substring("Bearer ".length());
        }
        userDTO.setAccessToken(accessToken);
        ResponseDO responseDO = new ResponseDO();
        responseDO.setSuccess(true);
        responseDO.setData(userDTO);
        return responseDO;
    }
}
