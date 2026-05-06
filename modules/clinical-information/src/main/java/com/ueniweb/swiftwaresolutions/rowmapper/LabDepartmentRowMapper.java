package com.ueniweb.swiftwaresolutions.rowmapper;

import com.ueniweb.swiftwaresolutions.data.LabDepartmentData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LabDepartmentRowMapper implements RowMapper<LabDepartmentData>  {

    private final String schema;

    public LabDepartmentRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM lab_config_master_dept a ");
        this.schema = builder.toString();
    }

    public String schema() {
        return this.schema;
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("a.dept_code as id, ");
        builder.append("a.dept_name as department ");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public LabDepartmentData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer id = rs.getInt("id");
        final String department = rs.getString("department");

        return LabDepartmentData.createNewInstance(id,department);
    }
}
