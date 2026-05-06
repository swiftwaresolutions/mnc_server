package com.ueniweb.swiftwaresolutions.rowmapper;


import com.ueniweb.swiftwaresolutions.data.DischargeSummaryDiagnosisData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class DischargeSumDiagRowMapper implements RowMapper<DischargeSummaryDiagnosisData> {
    private final String schema;
    public DischargeSumDiagRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM `cli_discharge_summary_diagnosis`a,ot_master_diagnosis b  ");
        this.schema = builder.toString();
    }
    public String schema() {
        return this.schema;
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" b.`id`,b.`name`");
        builder.append(this.schema);
        return builder.toString();
    }
    @Override
    public DischargeSummaryDiagnosisData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer id = rs.getInt("id");
        final String name = rs.getString("name");

        return  DischargeSummaryDiagnosisData.createNewInstance(id,name);
    }
}
