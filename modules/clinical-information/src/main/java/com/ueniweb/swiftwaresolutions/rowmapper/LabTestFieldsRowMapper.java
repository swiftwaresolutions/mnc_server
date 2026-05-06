package com.ueniweb.swiftwaresolutions.rowmapper;

import com.ueniweb.swiftwaresolutions.data.LabTestFieldData;
import lombok.Data;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
public class LabTestFieldsRowMapper implements RowMapper<LabTestFieldData> {

    private final String schema;

    public LabTestFieldsRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM lab_config_master_test_fld a,");
        builder.append(" lab_config_master_fields b ");
        this.schema = builder.toString();
    }

    public String schema(){ return this.schema; }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("a.fieldid as fieldId, ");
        builder.append("a.fieldname as fieldName, ");
        builder.append("a.fieldtype as fieldType, ");
        builder.append("a.unit, ");
        builder.append("b.line ");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public LabTestFieldData mapRow(ResultSet rs, int rowNum) throws SQLException {

        final Integer fieldId = rs.getInt("fieldid");
        final String fieldName = rs.getString("fieldname");
        final Integer fieldType = rs.getInt("fieldtype");
        final String unit = rs.getString("unit");
        final String line = rs.getString("line");

        return LabTestFieldData.createNewInstance(fieldId, fieldName, fieldType, unit, line);
    }
}
