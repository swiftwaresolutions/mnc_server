package com.ueniweb.swiftwaresolutions.rowmapper;

import com.ueniweb.swiftwaresolutions.data.DischargeDiagnosisData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DischargeDiagnosisRowMapper implements RowMapper<DischargeDiagnosisData> {

    private final String schema;

    public DischargeDiagnosisRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM `cli_discharge_summary_diagnosis`a, `cli_discharge_summary` b,cl_config_sub_disease c ");
        this.schema = builder.toString();
    }

    public String schema() {
        return this.schema;
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" a.`id`, a.`patId`, a.`vstId`, a.`ipId`, a.`summaryId`, a.`diagnosisId`, a.`isValid`,c.name ");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public DischargeDiagnosisData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer id = rs.getInt("id");
        final Integer patId = rs.getInt("patId");
        final Integer vstId = rs.getInt("vstId");
        final Integer ipId = rs.getInt("ipId");
        final Integer summaryId = rs.getInt("summaryId");
        final Integer diagnosisId = rs.getInt("diagnosisId");
        final Integer isValid = rs.getInt("isValid");
        final String name = rs.getString("name");


        return DischargeDiagnosisData.createNewInstance(id,patId,vstId,ipId,summaryId,diagnosisId,isValid,name);
    }

}
