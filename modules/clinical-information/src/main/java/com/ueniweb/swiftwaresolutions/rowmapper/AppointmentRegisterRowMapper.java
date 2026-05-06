package com.ueniweb.swiftwaresolutions.rowmapper;

import com.ueniweb.swiftwaresolutions.data.AppointmentRegisterData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AppointmentRegisterRowMapper implements RowMapper<AppointmentRegisterData>{

    private final String schema;

    private final String tableSchema;

    public AppointmentRegisterRowMapper() {

        final StringBuilder tableBuilder = new StringBuilder(200);
        tableBuilder.append(" FROM cli_patient_appointment a ");
        tableBuilder.append(" LEFT JOIN rec_patient c ON a.patId = c.id ");
        tableBuilder.append(" LEFT JOIN admin_users d ON a.consultantId = d.id ");
        tableBuilder.append(" LEFT JOIN rec_patient_opvisits b ON b.pat_id = a.patId AND b.date = CURDATE() ");

        final StringBuilder builder = new StringBuilder(200);
        builder.append(" c.name AS NAME,");
        builder.append(" c.display_number AS displayNumber,");
        builder.append(" a.caseSheetType AS caseSheetType,");
        builder.append(" a.appPlan AS appointmentPlan,");
        builder.append(" d.name consultantName,");
        builder.append(" (CASE WHEN b.id IS NULL THEN 0 ELSE 1 END) AS appointmentStatus ");
        builder.append(tableBuilder);

        this.tableSchema = tableBuilder.toString();
        this.schema = builder.toString();
    }

    public String schema() {return this.schema;}

    public String tableSchema() {return this.tableSchema;}

    @Override
    public AppointmentRegisterData mapRow(ResultSet rs, int rowNum) throws SQLException {

        final String name = rs.getString("NAME");
        final String displayNumber= rs.getString("displayNumber");
        final Long caseSheetType = rs.getLong("caseSheetType");
        final String appointmentPlan = rs.getString("appointmentPlan");
        final String consultantName = rs.getString("consultantName");
        final Long visitStatus = rs.getLong("appointmentStatus");

        return AppointmentRegisterData.newInstance(name,displayNumber,caseSheetType,appointmentPlan,consultantName,visitStatus);
    }
}
