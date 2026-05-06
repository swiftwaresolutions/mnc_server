package com.ueniweb.swiftwaresolutions.services;

import com.ueniweb.swiftwaresolutions.core.response.ResponseDO;
import com.ueniweb.swiftwaresolutions.data.UserRightsData;

public interface UserReadPlatformService {
    UserRightsData CheckUserRight(Long uid, int mod_id, int grp_det_id, int func_id);

    ResponseDO GetLoginUser(String token);

}

