package com.ueniweb.swiftwaresolutions.rowmapper;

import com.ueniweb.swiftwaresolutions.data.OutsideInvData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OutsideInvResultRowMapper implements RowMapper<OutsideInvData> {

    private final String schema;

    public OutsideInvResultRowMapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM cli_patient_outside_lab a ,\n" +
                "cli_patient_outside_inv b LEFT OUTER JOIN cash_config_head c ON c.id = b.invId");
        this.schema = builder.toString();
    }

    public String schema() { return this.schema;}

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" a.id AS invNo,");
        builder.append("a.labName AS labName,");
        builder.append("a.suggestDoc AS suggestDoc,");
        builder.append("DATE_FORMAT(a.selDateTime,'%d-%m-%Y') AS invDate,");
        builder.append("b.findings AS findings,");
        builder.append("c.name AS invName ");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public OutsideInvData mapRow(ResultSet rs, int i) throws SQLException {
        final Long invNo = rs.getLong("invNo");
        final String labName = rs.getString("labName");
        final String suggestDoc = rs.getString("suggestDoc");
        final String invDate = rs.getString("invDate");
        final String invName = rs.getString("invName");
        final String findings = rs.getString("findings");

        return OutsideInvData.createNewInstance(invNo, labName, suggestDoc, invDate, invName, findings);
    }
}
