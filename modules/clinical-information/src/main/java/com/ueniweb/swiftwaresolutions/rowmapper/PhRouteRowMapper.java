package com.ueniweb.swiftwaresolutions.rowmapper;

import com.ueniweb.swiftwaresolutions.data.PhRouteData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PhRouteRowMapper implements RowMapper<PhRouteData> {
    @Override
    public PhRouteData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final int id = rs.getInt("id");
        final String name = rs.getString("name");
        return PhRouteData.createNewInstance(id, name);
    }
}
