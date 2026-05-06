package com.ueniweb.swiftwaresolutions.services;

import com.ueniweb.swiftwaresolutions.core.response.ResponseDO;
import com.ueniweb.swiftwaresolutions.data.UserRightsData;
import com.ueniweb.swiftwaresolutions.rowMapper.UserRightsRowMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserReadPlatformServiceImpl implements UserReadPlatformService {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public UserRightsData CheckUserRight(Long uid, int mod_id, int grp_det_id, int func_id) {
        log.debug("START of CheckUserRights() uid {} mod_id {} grp_det_id{} func_id{}",uid,mod_id,grp_det_id,func_id);
        final UserRightsRowMapper userRightsRowMapper = new UserRightsRowMapper();

        String qry = "SELECT a.id FROM admin_user_rights a WHERE a.uid="+uid+" AND a.mod_id="+mod_id+" AND a.grp_det_id="+grp_det_id+" AND a.func_id="+func_id;

        log.debug("END of CheckUserRights()");
        return this.jdbcTemplate.queryForObject(qry,userRightsRowMapper);
    }

    @Override
    public ResponseDO GetLoginUser(String token){
        ResponseDO response = new ResponseDO();
        response.setSuccess(true);
        System.out.println(token);
        return response;
    }
}
