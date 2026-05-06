package com.ueniweb.swiftwaresolutions.rowmapper;

import com.ueniweb.swiftwaresolutions.data.InvDepartmentData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class InvDepartmentRowMapper implements RowMapper<InvDepartmentData>  {

    private final String schema;

    public InvDepartmentRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM cash_config_head a ");
        this.schema = builder.toString();
    }

    public String schema() {
        return this.schema;
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("a.id, ");
        builder.append("a.name as department ");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public InvDepartmentData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer id = rs.getInt("id");
        final String department = rs.getString("department");

        return InvDepartmentData.createNewInstance(id,department);
    }
}
