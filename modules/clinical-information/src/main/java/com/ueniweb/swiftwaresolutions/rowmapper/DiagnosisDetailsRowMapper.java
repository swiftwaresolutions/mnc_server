package com.ueniweb.swiftwaresolutions.rowmapper;

import com.ueniweb.swiftwaresolutions.data.ComplaintDetailsData;
import com.ueniweb.swiftwaresolutions.data.DiagnosisData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DiagnosisDetailsRowMapper implements RowMapper<DiagnosisData> {

    private final String schema;

    public DiagnosisDetailsRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM cl_config_sub_disease a,`cli_patient_diagnosis`b  ");
        this.schema = builder.toString();
    }

    public String schema() {
        return this.schema;
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" a.`id` AS id,a.`name` ");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public DiagnosisData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer id = rs.getInt("id");
        final String name = rs.getString("name");

        return DiagnosisData.createNewInstance(id,name);
    }
}
