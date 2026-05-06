package com.ueniweb.swiftwaresolutions.rowmapper;


import com.ueniweb.swiftwaresolutions.data.OutsideInvPrevDetailsData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OutsideInvPrevResultDetailsRowMapper implements RowMapper<OutsideInvPrevDetailsData> {
    private final String schema;

    public OutsideInvPrevResultDetailsRowMapper() {
        final StringBuilder stringBuilder = new StringBuilder(200);

        stringBuilder.append(" FROM cli_patient_outside_lab a,");
        stringBuilder.append(" cli_patient_outside_inv b ");
        stringBuilder.append(" LEFT OUTER JOIN  cash_config_head c ON b.deptId = c. id ");
        stringBuilder.append(" LEFT OUTER JOIN cash_config_head d ON b.invId = d.id ");
        this.schema = stringBuilder.toString();
    }

    public String schema() {return this.schema;}

    public String tableSchema() {
        final StringBuilder stringBuilder = new StringBuilder(200);

        stringBuilder.append("c.name AS deptName,");
        stringBuilder.append("d.name AS invName,");
        stringBuilder.append("b.findings as findings,");
        stringBuilder.append("c.id as deptId, ");
        stringBuilder.append("d.id as invId ");
        stringBuilder.append(this.schema());
        return stringBuilder.toString();
    }

    @Override
    public OutsideInvPrevDetailsData mapRow(ResultSet rs, int i) throws SQLException {
        final String deptName = rs.getString("deptName");
        final String invName = rs.getString("invName");
        final String findings = rs.getString("findings");
        final Long deptId = rs.getLong("deptId");
        final Long invId = rs.getLong("invId");

        return OutsideInvPrevDetailsData.createNewInstance(deptName, invName, findings, deptId, invId);
    }
}
