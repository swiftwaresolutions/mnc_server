package com.ueniweb.swiftwaresolutions.rowmapper;

import com.ueniweb.swiftwaresolutions.data.DiagnosisData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DiagnosisRowMapper implements RowMapper<DiagnosisData> {

    private final String schema;

    public DiagnosisRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM cl_config_disease a,`cl_config_sub_disease`b ");
        this.schema = builder.toString();
    }

    public String schema() {
        return this.schema;
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("b.id, ");
        builder.append("b.NAME as diagnosis ");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public DiagnosisData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer id = rs.getInt("id");
        final String diagnosis = rs.getString("diagnosis");

        return DiagnosisData.createNewInstance(id,diagnosis);
    }
}
