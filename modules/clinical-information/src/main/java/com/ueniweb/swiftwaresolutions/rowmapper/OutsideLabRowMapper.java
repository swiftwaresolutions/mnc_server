package com.ueniweb.swiftwaresolutions.rowmapper;

import com.ueniweb.swiftwaresolutions.data.OutsideLabResultData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OutsideLabRowMapper implements RowMapper<OutsideLabResultData> {

    private final String schema;

    public OutsideLabRowMapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("FROM cli_patient_outside_lab lr ");
        builder.append("INNER JOIN cli_patient_outside_lab_result lrd on lr.id=lrd.labDisplay ");
        this.schema = builder.toString();
    }

    private String schema() {return this.schema;}

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("lr.id as id,");
        builder.append("lr.display as labDisplay,");
        builder.append("lr.patId as patId,");
        builder.append("lr.vstId,");
        builder.append("lr.ipId as ipId,");
        builder.append("lr.labName as labName,");
        builder.append("lr.consultantId as consultantId,");
        builder.append("lr.suggestDoc as suggestDoc,");
        builder.append("lr.dateTime as entDateTime,");
        builder.append("lr.isValid as isValid ");
        builder.append(this.schema());
        return builder.toString();
    }

    @Override
    public OutsideLabResultData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Long id = rs.getLong("id");
        final Long labDisplay = rs.getLong("labDisplay");
        final Long patId = rs.getLong("patId");
        final Long vstId = rs.getLong("vstId");
        final Long ipId = rs.getLong("ipId");
        final String labName= rs.getString("labName");
        final Long consultantId = rs.getLong("consultantId");
        final String suggestDoc = rs.getString("suggestDoc");
        final String entDateTime = rs.getString("entDateTime");
        final Long isValid = rs.getLong("isValid");

        return OutsideLabResultData.createNewInstance(id, labDisplay, patId,vstId, ipId, labName, consultantId, suggestDoc, entDateTime, isValid);
    }

}
