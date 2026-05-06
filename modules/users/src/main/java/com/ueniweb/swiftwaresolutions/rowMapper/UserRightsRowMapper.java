package com.ueniweb.swiftwaresolutions.rowMapper;

import com.ueniweb.swiftwaresolutions.data.UserRightsData;
import lombok.Data;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
public class UserRightsRowMapper implements RowMapper<UserRightsData> {

    @Override
    public UserRightsData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer id                = rs.getInt("id");
        return UserRightsData.createNewInstance(id);
    }
}
