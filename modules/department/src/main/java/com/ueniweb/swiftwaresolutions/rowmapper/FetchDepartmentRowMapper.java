package com.ueniweb.swiftwaresolutions.rowmapper;

import com.ueniweb.swiftwaresolutions.data.DepartmentData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FetchDepartmentRowMapper implements RowMapper<DepartmentData> {
    private String schema;
    private String tableSchema;

    public String schema() {
        return this.schema;
    }

    public String tableSchema() {
        return this.tableSchema;
    }


    @Override
    public DepartmentData mapRow(ResultSet rs, int i) throws SQLException {

        final String depName = rs.getString("depName");

        final int id = rs.getInt("id");

        return DepartmentData.newInstance(depName, id);
    }
}
