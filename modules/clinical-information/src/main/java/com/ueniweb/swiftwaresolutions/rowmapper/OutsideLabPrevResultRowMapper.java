package com.ueniweb.swiftwaresolutions.rowmapper;

import com.ueniweb.swiftwaresolutions.data.OutsideLabPrevResultData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OutsideLabPrevResultRowMapper implements RowMapper<OutsideLabPrevResultData> {

    private final String schema;

    public OutsideLabPrevResultRowMapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM cli_patient_outside_lab a LEFT OUTER JOIN admin_users b ON a.consultantId = b.id ");
        this.schema = builder.toString();

    }
    public String schema() {return this.schema;}

    public String tableSchma(){
        final StringBuilder builder = new StringBuilder(200);

        builder.append("a.display AS Display, ");
        builder.append("a.labName labName, ");
        builder.append("a.suggestDoc AS suggestDoctor, ");
        builder.append("a.`consultantId` AS consultant, ");
        builder.append("b.name AS consultantName, ");
        builder.append("DATE(a.`dateTime`) AS DATE, ");
        builder.append("a.selDateTime AS selectDateTime");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public OutsideLabPrevResultData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Long display = rs.getLong("Display");
        final String labName = rs.getString("labName");
        final String suggestDoc = rs.getString("suggestDoctor");
        final Long consultant = rs.getLong("consultant");
        final String consultantName = rs.getString("consultantName");
        final String date = rs.getString("DATE");
        final String selDateTime = rs.getString("selectDateTime");
        return OutsideLabPrevResultData.CreateNewInstance(display,labName,suggestDoc,consultant,consultantName,date, selDateTime);
    }
}
