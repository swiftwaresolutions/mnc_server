package com.ueniweb.swiftwaresolutions.rowmapper;

import com.ueniweb.swiftwaresolutions.data.LabResultData;
import com.ueniweb.swiftwaresolutions.data.OutsideLabData;
import com.ueniweb.swiftwaresolutions.data.OutsideLabResultData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OutsideLabResultRowMapper implements RowMapper<OutsideLabData> {

    private final String schema;

    public OutsideLabResultRowMapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("FROM cli_patient_outside_lab a , cli_patient_outside_lab_result b \n" +
                "LEFT JOIN lab_config_master_test c ON b.testId = c.test_id \n" +
                "LEFT JOIN lab_config_master_specimen f ON f.spec_code = c.spec_code,\n" +
                "cli_patient_outside_lab_result_value d LEFT JOIN lab_config_master_test_fld e ON d.fldId = e.fieldid");
        this.schema = builder.toString();
    }

    public String schema() { return this.schema;}

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("a.id AS labId,");
        builder.append("a.labName AS labName,");
        builder.append("a.suggestDoc AS suggestDoc,");
        builder.append("DATE_FORMAT(a.selDateTime,'%d-%m-%Y') AS date, ");
        builder.append("f.spec_name AS specName, ");
        builder.append("c.test_name AS testName, ");
        builder.append("d.value AS value, ");
        builder.append("e.unit AS unit, ");
        builder.append("e.fieldname AS fieldName, ");
        builder.append("d.fldId AS fieldId ");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public OutsideLabData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Long labId = rs.getLong("labId");
        final String labName = rs.getString("labName");
        final String suggestDoc = rs.getString("suggestDoc");
        final String selDate = rs.getString("date");
        final String specName = rs.getString("specName");
        final String testName = rs.getString("testName");
        final String value = rs.getString("value");
        final String unit = rs.getString("unit");
        final String fieldName = rs.getString("fieldName");
        final Long fieldId = rs.getLong("fieldId");
        return OutsideLabData.createNewInstance(labId, labName, suggestDoc, selDate, specName, testName, value, unit, fieldName, fieldId);
    }
}
