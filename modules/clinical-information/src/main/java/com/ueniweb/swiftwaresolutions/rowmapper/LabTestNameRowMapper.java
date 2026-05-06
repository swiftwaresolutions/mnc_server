package com.ueniweb.swiftwaresolutions.rowmapper;

import com.ueniweb.swiftwaresolutions.data.LabTestNameData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LabTestNameRowMapper implements RowMapper<LabTestNameData>  {

    private final String schema;

    public LabTestNameRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append("FROM lab_config_master_test a1,lab_config_master_dept a2 ");
        this.schema = builder.toString();
    }

    public String schema() {
        return this.schema;
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("a2.dept_code AS deptCode, ");
        builder.append("a1.test_id AS id,");
        builder.append("a1.test_name AS name, ");
        builder.append("a1.test_code AS code,");
        builder.append("a1.rate AS rate, ");
        builder.append("a1.charity AS charity,");
        builder.append("'L' AS label, ");
        builder.append("a2.`dept_name` AS name1 ");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public LabTestNameData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final String deptCode = rs.getString("deptCode");
        final Integer id  = rs.getInt("id");
        final String name = rs.getString("name");
        final String code = rs.getString("code");
        final Double rate     = rs.getDouble("rate");
        final Double charity  = rs.getDouble("charity");
        final String label    = rs.getString("label");
        final String name1    = rs.getString("name1");

        return LabTestNameData.createNewInstance(deptCode,id,name,code,rate,charity,label,name1);
    }
}
